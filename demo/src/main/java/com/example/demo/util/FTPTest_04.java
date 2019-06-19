package com.example.demo.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TimeZone;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/5 11:15
 * @description: TODO
 */
public class FTPTest_04 {

    private FTPClient ftpClient;
    private String strIp;
    private int intPort;
    private String user;
    private String password;

    /**
     * 日志对象
     */
    private final Logger logger = LoggerFactory.getLogger(FTPTest_04.class);

    private FTPTest_04(String strIp, int intPort, String user, String Password) {
        this.strIp = strIp;
        this.intPort = intPort;
        this.user = user;
        this.password = Password;
        this.ftpClient = new FTPClient();
    }


    /**
      * 功能描述:
      *      下载文件夹
      * @param localDirectoryPath 本地地址  remoteDirectory 远程文件夹
      * @return
      * @auther: JiangT
      * @date: 2019/6/5 11:29
      */
    private void downLoadDirectory(String localDirectoryPath, String remoteDirectory) {
        try {
            String fileName = new File(remoteDirectory).getName();
            System.out.println("文件夹名称 : " + fileName);
            localDirectoryPath = localDirectoryPath + fileName + File.separator;
            new File(localDirectoryPath).mkdirs();
            boolean b = ftpClient.changeWorkingDirectory(remoteDirectory);
            System.out.println("切换文件夹 : " + b);
            FTPFile[] allFile = ftpClient.listFiles(remoteDirectory);
            System.out.println("文件个数 : " + allFile.length);
            for (FTPFile anAllFile : allFile) {
                if (!anAllFile.isDirectory()) {
                    logger.info("下载文件中.....");
                    downloadFile(anAllFile.getName(), localDirectoryPath, remoteDirectory);

                }

            }
            for (FTPFile anAllFile : allFile) {
                if (anAllFile.isDirectory()) {
                    logger.info("下载文件夹中.....");
                    String strRemoteDirectoryPath = remoteDirectory + "/" + anAllFile.getName();
                    downLoadDirectory(localDirectoryPath, strRemoteDirectoryPath);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
            logger.info("下载文件夹失败");

        }

    }

    public FTPClient getFtpClient() {
        return ftpClient;

    }


    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;

    }


    private void ftpLogOut() {
        if (null != this.ftpClient && this.ftpClient.isConnected()) {
            try {
                boolean reuslt = this.ftpClient.logout();// 退出FTP服务器
                if (reuslt) {
                    logger.info("成功退出服务器");
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.warn("退出FTP服务器异常！" + e.getMessage());
            } finally {
                try {
                    this.ftpClient.disconnect();// 关闭FTP服务器的连接
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.warn("关闭FTP服务器的连接异常！");
                }
            }
        }
    }

    private boolean ftpLogin() {
        boolean isLogin = false;
        FTPClientConfig ftpClientConfig = new FTPClientConfig();
        ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
        this.ftpClient.setControlEncoding("utf-8");
        this.ftpClient.configure(ftpClientConfig);
        try {
            if (this.intPort > 0) {
                this.ftpClient.connect(this.strIp, this.intPort);
            } else {
                this.ftpClient.connect(this.strIp);
            }
            // FTP服务器连接回答
            int reply = this.ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                this.ftpClient.disconnect();
                logger.error("登录FTP服务失败！");
                return isLogin;
            }
            this.ftpClient.login(this.user, this.password);
            // 设置传输协议
            this.ftpClient.enterLocalPassiveMode();
            this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            logger.info("恭喜" + this.user + "成功登陆FTP服务器");
            isLogin = true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(this.user + "登录FTP服务失败！" + e.getMessage());
        }
        this.ftpClient.setBufferSize(1024 * 2);
        this.ftpClient.setDataTimeout(30 * 1000);
        return isLogin;
    }


    private void downloadFile(String remoteFileName, String localDirs, String remoteDownLoadPath) {
        String strFilePath = localDirs + remoteFileName;
        BufferedOutputStream outStream = null;
        boolean success = false;
        try {
            this.ftpClient.changeWorkingDirectory(remoteDownLoadPath);
            outStream = new BufferedOutputStream(new FileOutputStream(strFilePath));
            logger.info(remoteFileName + "开始下载....");
            success = this.ftpClient.retrieveFile(remoteFileName, outStream);
            if (success) {
                logger.info(remoteFileName + "成功下载到" + strFilePath);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(remoteFileName + "下载失败");
        } finally {
            if (null != outStream) {
                try {
                    outStream.flush();
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!success) {
            logger.error(remoteFileName + "下载失败!!!");
        }
    }


    public static void main(String[] args) throws IOException {
        FTPTest_04 ftp = new FTPTest_04("192.168.32.129", 21, "ftpUser", "123456");
        boolean b = ftp.ftpLogin();
        System.out.println("ftp服务器 登录" + b);
        //上传文件夹
        //boolean uploadFlag = ftp.uploadDirectory("D:\\test02", "/"); //如果是admin/那么传的就是所有文件，如果只是/那么就是传文件夹
        // System.out.println("uploadFlag : " + uploadFlag);
        //下载文件夹
        ftp.downLoadDirectory("D:" + File.separator, "/home/ftpUser");
        //单个文件下载
        //ftp.downloadFile("test.txt","D:" + File.separator, File.separator + "study" +File.separator);
        ftp.ftpLogOut();

    }
}

