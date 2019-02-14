package com.sftp.utils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

import java.io.IOException;

public interface SftpCallback {
    Object execute(ChannelSftp channelSftp) throws SftpException, IOException;
}