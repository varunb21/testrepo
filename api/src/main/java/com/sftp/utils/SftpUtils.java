package com.sftp.utils;

import com.core.Wrapper;
import com.jcraft.jsch.*;
import com.sftp.SFTPFileTransfer;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.constant.Constant.CONS_SFTP_SEND_FILE_RETRYCOUNT;
import static java.util.Comparator.comparingInt;

public class SftpUtils {

    public static final String CHANNEL_TYPE_SFTP = "sftp";
    public static final String STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking";
    public static final String SFTP_HOST = "nhdevftp.sandata.com";
    public static final String SFTP_PORT = "22";
    public static final String SFTP_USER_NAME = "talend";
    public static final String SFTP_PASSWORD = "FZ4gd-Qd";//NOSONAR
//    public static final String SFTP_FOLDER = "sftpFolder";
    public static final String BASE_FOLDER = "/DevOhioInterfaces/";
    public static final String QAWAREHOUSE = "/QAExportDataWarehouse";
    public static final String DEVSWARMEXPORTDWH = BASE_FOLDER + "DevSwarmExportDataWarehouse/";
    public static final SftpConfig SFTP_CONFIG = new SftpConfig();

    static {
        SFTP_CONFIG.setHost(SFTP_HOST);
        SFTP_CONFIG.setPort(Integer.parseInt(SFTP_PORT));
        SFTP_CONFIG.setUsername(SFTP_USER_NAME);
        SFTP_CONFIG.setPassword(SFTP_PASSWORD);
    }

    private static Logger LOGGER = Logger.getLogger(SftpUtils.class);

    private SftpUtils(){}

    public static Object execute(SftpCallback callback) throws SftpException, JSchException, IOException {
        return execute(SFTP_CONFIG, callback);
    }

    public static Object execute(SftpConfig config, SftpCallback callback) throws JSchException, SftpException, IOException {
        Session session = new JSch().getSession(
                config.getUsername(),
                config.getHost(),
                config.getPort());
        session.setConfig(STRICT_HOST_KEY_CHECKING, "no");
        session.setPassword(config.getPassword());
        session.connect();
        ChannelSftp channel = (ChannelSftp)session.openChannel(CHANNEL_TYPE_SFTP);
        channel.connect();
        try {
            return callback.execute(channel);
        } catch (Exception ex) {
            LOGGER.error("SFTP error: " + ex.getMessage());
            throw ex;
        } finally {
            channel.disconnect();
            session.disconnect();
        }
    }

    public static String downloadLatestFile(String fileNamePrefix, String remoteDir, FileType fileType, String localDir) throws JSchException, SftpException, IOException {
        return downloadLatestFileWithComparator(
                fileNamePrefix,
                remoteDir,
                fileType,
                localDir,
                Comparator.comparing(o -> getFileTimestamp(o.getFilename()))
        );
    }

    public static String downloadLatestFileByModifiedTime(String fileNamePrefix, String remoteDir, FileType fileType, String localDir) throws JSchException, SftpException, IOException {
        return downloadLatestFileWithComparator(
                fileNamePrefix,
                remoteDir,
                fileType,
                localDir,
                comparingInt(o -> o.getAttrs().getMTime())
        );
    }

    public static String downloadLatestFileWithComparator(
            String fileNamePrefix,
            String remoteDir,
            FileType fileType,
            String localDir,
            Comparator<ChannelSftp.LsEntry> fileComparator) throws JSchException, SftpException, IOException {
        return (String) execute(channelSftp -> {
            Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteDir);//NOSONAR
            ChannelSftp.LsEntry latestEntry = files.stream()
                    .filter(entry -> !".".equals(entry.getFilename()) && !"..".equals(entry.getFilename()))
                    .filter(entry -> entry.getFilename().toLowerCase().endsWith(fileType.getExtension()))
                    .filter(entry -> entry.getFilename().startsWith(fileNamePrefix))
                    .peek(entry -> LOGGER.info("Found remote file: " + entry.getFilename()))
                    .max(fileComparator)
                    .orElse(null);
            if (Objects.isNull(latestEntry)) {
                return null;
            }
            Path localDirPath = Paths.get(localDir);
            if (!localDirPath.toFile().exists()) {
                Files.createDirectory(localDirPath);
            }
            String downloadedFile = Paths.get(localDir, latestEntry.getFilename()).toString();
            String remoteFileAbsPath = remoteDir + "/" + latestEntry.getFilename();
            LOGGER.info("Downloading remote file " + remoteFileAbsPath);
            channelSftp.get(
                    remoteFileAbsPath,
                    downloadedFile);
            LOGGER.info("File downloaded at " + downloadedFile);
            return downloadedFile;
        });
    }

    private static String getFileTimestamp(String fileName) {
        // We expect the filename should be "prefix_<timestamp>.extension"
        return fileName.substring(fileName.lastIndexOf('_') + 1, fileName.indexOf('.'));
    }

    public static enum FileType {
        ZIP(".zip"), CSV(".csv"), TXT(".txt");

        String extension;

        FileType(String extension) {
            this.extension = extension;
        }

        public String getExtension() {
            return extension;
        }
    }


    public static File getFile(String dstAbsolutePath, SftpUtils.FileType fileType, String fileNamePrefix, String localDir) throws Exception {
        String filePath = null;
        File file = new File(localDir + "/" + fileNamePrefix + fileType.getExtension());

        if (!file.exists()){
            LOGGER.info("No file available in local = " + localDir);
            LOGGER.info("Finding latest file from the remote = " + dstAbsolutePath);

            filePath = SftpUtils.downloadLatestFile(
                    fileNamePrefix,
                    dstAbsolutePath,
                    fileType, localDir);
            LOGGER.info("Downloaded latest file = " + filePath);
            if (fileNamePrefix.equalsIgnoreCase("SAMDataExtracts_")){
                LOGGER.info("Extracting the .zip file");
//                UnzipFile.unZip(filePath, localDir);
                file = new File(localDir + fileNamePrefix + fileType.getExtension());
            }else {
                //compare timestamp in file vs last_export_time
                file = new File(filePath);
            }
        }
        LOGGER.info("file.getPath() = " + file.getPath());
        return file;
    }

    public static ChannelSftp.LsEntry getLatestFileInSftpDirectory(
            String fileNamePrefix,
            String remoteDir,
            FileType fileType) throws JSchException, SftpException, IOException {
        return (ChannelSftp.LsEntry) execute(channelSftp -> {
            Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteDir);//NOSONAR
            ChannelSftp.LsEntry latestEntry = files.stream()
                    .filter(entry -> !".".equals(entry.getFilename()) && !"..".equals(entry.getFilename()))
                    .filter(entry -> entry.getFilename().toLowerCase().endsWith(fileType.getExtension()))
                    .filter(entry -> entry.getFilename().startsWith(fileNamePrefix))
                    .peek(entry -> LOGGER.info("Found remote file: " + entry.getFilename()))
                    .max(comparingInt(o -> o.getAttrs().getMTime()))
                    .orElse(null);
            if (Objects.isNull(latestEntry)) {
                return null;
            }
            return latestEntry;
        });
    }


    public static String getLatestModifiedTimeInSftpDirectory(String fileNamePrefix) throws IOException, SftpException, JSchException {
        SFTPFileTransfer sftp = new SFTPFileTransfer();
        String dstAbsolutePath = "/" + sftp.FOLDER;
        String latestModifiedTime;
        ChannelSftp.LsEntry latestEntry = SftpUtils.getLatestFileInSftpDirectory(fileNamePrefix,
                dstAbsolutePath,
                SftpUtils.FileType.ZIP);
        if (latestEntry != null){
            LOGGER.info("Last Modify Time of prefix file " + fileNamePrefix + ": " + latestEntry.getAttrs().getMtimeString());
            latestModifiedTime = latestEntry.getAttrs().getMtimeString();
        }
        else {
            latestModifiedTime = "";
            LOGGER.info("Sftp directory is empty!!!");
        }
        return latestModifiedTime;
    }

    public static void waitForNewFileExportedToSftp(String fileNamePrefix, String currentLatestModifiedTime, int minutes) throws Exception {
        Wrapper wrapper = new Wrapper();
        //Check query type
        String latestModifiedTime;
        int milliSec = (minutes * 60) * 1000;
        Boolean flag = true;
        while (flag) {
            for (int i = 0; i <= milliSec; i = i + 60000) {
                wrapper.holdOn(60000);
                latestModifiedTime = getLatestModifiedTimeInSftpDirectory(fileNamePrefix);
                if (!latestModifiedTime.equals(currentLatestModifiedTime)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                throw new Error("No file is exported to sftp after " + minutes + " minutes!!!");
            }
        }
        wrapper.holdOn(10000);
    }

    public static String waitForFileExported(String remoteDir,
                                             String fileNamePrefix,
                                             FileType fileType,
                                             int sleepInterval,
                                             int timeout) {
        ChannelSftp.LsEntry entry = null;
        long startTime = System.currentTimeMillis();
        do {
            try {
                entry = (ChannelSftp.LsEntry) execute(channelSftp -> {
                    Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteDir);
                    return files.stream()
                            .filter(e -> !".".equals(e.getFilename()) && !"..".equals(e.getFilename()))
                            .filter(e -> e.getFilename().toLowerCase().endsWith(fileType.getExtension()))
                            .filter(e -> e.getFilename().startsWith(fileNamePrefix))
                            .peek(e -> LOGGER.debug("Found remote file: " + e.getFilename()))
                            .findFirst()
                            .orElse(null);
                });
            } catch (SftpException | JSchException | IOException e) {
                LOGGER.warn("Error occurs: " + e.getMessage());
            }
            if (Objects.nonNull(entry)) {
                break;
            }
            try {
                LOGGER.debug("File not found, sleeping " + sleepInterval + "ms");
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e) {
                LOGGER.warn("Error occurs: " + e.getMessage());
                return null;
            }
        } while ((System.currentTimeMillis() - startTime) < timeout);

        if (Objects.isNull(entry)) {
            String message = "Fail to find expected file after " + ((System.currentTimeMillis() - startTime) + "ms");
            LOGGER.error(message);
        }
        return entry.getFilename();
    }

    public static File getFile(String remoteDir, String localDir, String remoteFileName) {
        try {
            return  (File) execute(channelSftp -> {
                String remoteAbsPath = remoteDir + "/" + remoteFileName;
                String localAbsPath = localDir + "/" + remoteFileName;
                Path localDirPath = Paths.get(localDir);
                if (!Files.exists(localDirPath)) {
                    LOGGER.info("Creating directory " + localDir);
                    Files.createDirectory(localDirPath);
                }
                LOGGER.info("Download from " + remoteAbsPath + " to " + localAbsPath);
                channelSftp.get(remoteAbsPath, localAbsPath);
                LOGGER.info("Download successfully to " + localAbsPath);
                return new File(localAbsPath);
            });
        } catch (SftpException | JSchException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void sftpSendFile(String srcAbsolutePath, String dstAbsolutePath) throws SftpException, IOException, InterruptedException {
        int retryConnectionCount = 3;
        boolean verify = false;
        while (!verify && retryConnectionCount > 0) {
            try {
                execute(channelSftp -> {
                    channelSftp.put(srcAbsolutePath, dstAbsolutePath);
                    return null;
                });
                verify = true;
                LOGGER.info("Successfully uploaded file " + srcAbsolutePath + " to " + dstAbsolutePath);
            } catch (JSchException e) {
                LOGGER.error("sftpSendFile fail by error", e);
                LOGGER.info("retryConnectionCount = " + retryConnectionCount);
                LOGGER.info("Sleeping 1 minute(s) ... ");
                Thread.sleep(60000);
                retryConnectionCount--;
            }

        }
    }

    public static boolean isSftpListFileExisted(String dstAbsolutePath, List<String> fileNames) throws InterruptedException
    {
        for(String filename: fileNames){
            boolean isExist  = getFile(dstAbsolutePath + filename, 5);
            if(isExist == false)
                return false;
        }
        return true;
    }

    public static boolean isSftpFileExisted(String dstAbsolutePath) throws InterruptedException {
        return getFile(dstAbsolutePath, CONS_SFTP_SEND_FILE_RETRYCOUNT);
    }

    public static boolean isSftpFileExisted(String dstAbsolutePath, int retryCount) throws InterruptedException {
        return getFile(dstAbsolutePath, retryCount);
    }

    private static boolean getFile(String dstAbsolutePath, int retryCount) throws InterruptedException {
        AtomicBoolean isExisted = new AtomicBoolean(false);
        while (!isExisted.get() && retryCount > 0) {
            try {
                execute(channelSftp -> {
                    channelSftp.stat(dstAbsolutePath);
                    isExisted.set(true);
                    return true;
                });
            } catch (SftpException | JSchException | IOException e) {
                LOGGER.info("Caught exception. " + e.getMessage());
                LOGGER.info("retryCount = " + retryCount);
                LOGGER.info("Sleeping 1 minute(s) ... ");
                Thread.sleep(60000);
                retryCount--;
            }
        }
        return isExisted.get();
    }

}
