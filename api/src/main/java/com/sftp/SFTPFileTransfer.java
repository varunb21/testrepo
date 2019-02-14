package com.sftp;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Vector;


public class SFTPFileTransfer {
    private static final Logger LOGGER = Logger.getLogger(SFTPFileTransfer.class);
    public static final char DEFAULT_CSV_DELIMITER = ',';
    public static final boolean DEFAULT_IGNORE_SURROUNDING_SPACES = true;
    private static JSch jsch = new JSch();
    private static Session session = null;
    private static ChannelSftp sftpChannel = null;
    private static final String yyyyMMddhhmmss = "yyyyMMddhhmmss";

    public String HOST;
    public int PORT;
    public String USERNAME;
    public String PASSWORD;
    public String FOLDER;


//    public SFTPFileTransfer(){
//        Environment environment = TestConfiguration.getInstance().getEnvironment();
//        HOST = environment.get("sftpHost");
//        PORT = Integer.parseInt(environment.get("sftpPort"));
//        USERNAME = environment.get("sftpUserName");
//        PASSWORD = environment.get("sftpPassword");
//        FOLDER = environment.get("sftpFolder").trim();
//    }

    public void setHOST(String host) {
        this.HOST = host;
    }

    public void setPORT(int port) {
        this.PORT = port;
    }

    public void setUserName(String userName) {
        this.USERNAME = userName;
    }

    public void setPassword(String password) {
        this.PASSWORD = password;
    }

    /**
     * create session with channel type sftp
     */
    public static Session sftpGetSession(String host, int port, String userName, String password) {
        try {
            session = jsch.getSession(userName, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
        } catch (JSchException e) {
            e.getMessage();
        }
        return session;
    }

    /**
     * create connection with available session
     * */
    public static ChannelSftp sftpConnection(Session session){
        try {
            session.connect();
            Channel channel = session.openChannel("sftp");
//            session.setTimeout();
            channel.connect();
            sftpChannel= (ChannelSftp) channel;
        } catch (JSchException e) {
            e.getMessage();
        }
        return sftpChannel;
    }

    /**
     * disconnect open connection and session
     * */
    public void sftpDisconnect(Session session, ChannelSftp sftpChannel){
        sftpChannel.exit();
        session.disconnect();
    }



    /**
     * get file via sftp channel at remote repository with default session and channel
     * */
    public boolean isSftpFileExisted(String dstAbsolutePath) throws InterruptedException {
        Session sessionSFTP = sftpGetSession(this.HOST, this.PORT, this.USERNAME, this.PASSWORD);
        ChannelSftp channelSFTP = sftpConnection(sessionSFTP);
        boolean isExisted = false;
        int retryCount = 15;
        while (!isExisted && retryCount > 0) {
            LOGGER.info("retryCount = " + retryCount);
            try {
                SftpATTRS stat = channelSFTP.stat(dstAbsolutePath);
                if (stat != null) {
                    isExisted = true;
                }
                LOGGER.info("remoteAbsPath = " + dstAbsolutePath);
                LOGGER.info("isSftpFileExisted = " + isExisted);
            } catch (SftpException e) {
                LOGGER.info("Caught exception. " + e.getMessage());
                LOGGER.info("Sleeping 1 minute(s) ... ");
                Thread.sleep(60000);
            } finally {
                retryCount--;
            }
        }
        this.sftpDisconnect(sessionSFTP, channelSFTP);
        return isExisted;
    }

    public String getCorrectFilename(ChannelSftp sftpChannel, Session session, String
            dstAbsolutePath, String regularFileName) {
        LOGGER.info("Filename with regular expression: " + regularFileName + '\n');
        int retryCount = 15;
        String fileName;
        while ((retryCount > 0)) {
            LOGGER.info("retryCount = " + retryCount + '\n');
            try {
                SftpATTRS stat = sftpChannel.stat(dstAbsolutePath);
                if (stat.isDir()) {
                    fileName = getFileNameMatchWithRegular(regularFileName, dstAbsolutePath);
                    if(!fileName.equals("")) return fileName;
                }
            } catch (SftpException e) {
                LOGGER.info("Caught exception. " + e.getMessage() + '\n');
            } finally {
                try {
                    LOGGER.info("Sleeping 1 minute(s) ...\n");
                    Thread.sleep(1*60000);
                } catch (InterruptedException e1) {
                    //ignore
                }
                retryCount--;
            }
        }
        return regularFileName;
    }

    public String getFileNameMatchWithRegular(String regularFileName, String dstAbsolutePath) {
        try {
            Vector<ChannelSftp.LsEntry> files = sftpChannel.ls(dstAbsolutePath);
            Iterator<ChannelSftp.LsEntry> it = files.iterator();
            while (it.hasNext()) {
                ChannelSftp.LsEntry entry = it.next();
                if (entry.getFilename().matches(regularFileName)) {
                    return entry.getFilename();
                }
            }
        } catch (SftpException e) {
            LOGGER.info("Caught exception. " + e.getMessage() + '\n');
        }
        return "";
    }





}