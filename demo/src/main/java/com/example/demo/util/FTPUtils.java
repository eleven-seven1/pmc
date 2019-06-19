package com.example.demo.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/4 14:33
 * @description: FTP 文件上传下载
 */
public class FTPUtils {

    /**
     * 日志对象
     */
    private static  final Logger log = LoggerFactory.getLogger(FTPUtils.class);
    /**
     * FTP 登录
     * @param address，FTP服务IP
     * @param port，FTP服务端口
     * @param userName，FTP用户名
     * @param password，FTP密码
     * @return
     */
    public static FTPClient getFTPClient(String address, int port, String userName, String password){
        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(address, port);
            ftpClient.login(userName, password);
            if(!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())){
                if(log.isErrorEnabled()){
                    log.error("未连接到FTP，用户名或密码异常, userName = [" + userName + "],password = [" + password + "]");
                }
                ftpClient.disconnect();
                return null;
            }else{
                if(log.isInfoEnabled()){
                    log.info("FTP连接成功 IP : PORT [" + address + ":" + port);
                }
                return ftpClient;
            }
        } catch (SocketException e) {

            e.printStackTrace();
            if(log.isErrorEnabled()){
                log.error("未连接到FTP, address = [" + address + "],port = [" + port + "]");
            }
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if(log.isErrorEnabled()){
                log.error("未连接到FTP, address = [" + address + "],port = [" + port + "]");
            }
            return null;
        }
    }

    /**
     * 关闭FTP
     * @param ftpClient
     */
    public static void FTPClose(FTPClient ftpClient){
        if(ftpClient != null && ftpClient.isConnected()){
            try {
                ftpClient.logout();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * FTP 单个文件下载
     * @param ftpClient ftp对象
     * @param localPath 本地路径
     * @param localFileName 本地文件名
     * @param remotePath 远程路径
     * @param remoteFileName 远程文件名
     * @return
     */
    public static String FTPdownFile(FTPClient ftpClient,String localPath,String localFileName,String remotePath,String remoteFileName){

        OutputStream os = null;
        try {
            ftpClient.setConnectTimeout(60000);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            boolean b = ftpClient.changeWorkingDirectory(remotePath);
            if(!b){
                if(log.isErrorEnabled()){
                    log.error("查询申请文件未找到 : " + remotePath);
                }
                return "000143";
            }
            // 判断本地文件夹是否存在
            if(!new File(localPath).isDirectory()){
                new File(localPath).mkdirs();
            }
            File localFile = new File(localPath + File.separator + localFileName);
            os = new FileOutputStream(localFile);
            b = ftpClient.retrieveFile(remoteFileName, os);
            if(!b){
                if(log.isErrorEnabled()){
                    log.error("下载文件失败 : " + localPath + File.separator + localFileName);
                }
                return "000142";
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            if(log.isErrorEnabled()){
                log.error("查询申请文件未找到 : " + localPath + File.separator + localFileName);
            }
            return "000143";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if(log.isErrorEnabled()){
                log.error("下载文件失败 : " + localPath + File.separator + localFileName);
            }
            return "000142";

        }finally{
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "00000";
    }

    public static FTPFile[] getFTPFile(FTPClient ftpClient, String remotePath){

        try {
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            boolean b = ftpClient.changeWorkingDirectory(remotePath);
            if(!b){
                if(log.isErrorEnabled()){
                    log.error("查询申请文件未找到 : " + remotePath);
                }
            }
            FTPFile[] remoteFiles = ftpClient.listFiles();
            return remoteFiles;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * FTP 批量文件下载
     * @param ftpClient ftp对象
     * @param localPath 本地路径
     * @param remotePath 远程路径
     * @return
     */
    public static String FTPdownDir(FTPClient ftpClient,String localPath,String remotePath){
        OutputStream os = null;
        try {
            ftpClient.setConnectTimeout(600000);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            boolean b = ftpClient.changeWorkingDirectory(remotePath);
            if(!b){
                if(log.isErrorEnabled()){
                    log.error("查询申请文件未找到 : " + remotePath);
                }
                return "000143";
            }

            File localFilePath = new File(localPath);
            /**判断本地文件夹是否存在*/
            if(!localFilePath.isDirectory()){
                localFilePath.mkdirs();
            }
            //ftpClient.listNames();
            FTPFile[] remoteFiles = ftpClient.listFiles();
            for(FTPFile remoteFile : remoteFiles){
                try{
                    File localFile = new File(localPath + File.separator + remoteFile.getName());
                    os = new FileOutputStream(localFile);
                    b = ftpClient.retrieveFile(remoteFile.getName(), os);
                }finally{
                    if(os != null){
                        try {
                            os.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

            }
            if(!b){
                if(log.isErrorEnabled()){
                    log.error("下载文件失败 : " + localPath + File.separator + remotePath);
                }
                return "000142";
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            if(log.isErrorEnabled()){
                log.error("查询申请文件未找到 : " + localPath + File.separator + remotePath);
            }
            return "000143";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if(log.isErrorEnabled()){
                log.error("下载文件失败 : " + localPath + File.separator + remotePath);
            }
            return "000142";

        }finally{
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "00000";
    }


    public static void main(String[] args) {
        FTPClient ftpClient = getFTPClient("192.168.32.129", 21, "sunyard", "123456");

        String s = FTPdownDir(ftpClient, "D://", File.separator + "study");

        System.out.println(s);
    }

}
