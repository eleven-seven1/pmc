package com.example.demo.service.impl;

import com.example.demo.bean.TApplyPro;
import com.example.demo.bean.TContract;
import com.example.demo.bean.TImage;
import com.example.demo.bean.TMaterial;
import com.example.demo.common.ContractTypeEnum;
import com.example.demo.dao.TApplyProDao;
import com.example.demo.service.ImageUploadService;
import com.example.demo.util.FTPUtils;
import com.sunyard.client.SunEcmClientApi;
import com.sunyard.client.bean.ClientBatchBean;
import com.sunyard.client.bean.ClientBatchFileBean;
import com.sunyard.client.bean.ClientBatchIndexBean;
import com.sunyard.client.bean.ClientFileBean;
import com.sunyard.client.impl.SunEcmClientSocketApiImpl;
import org.apache.commons.net.ftp.FTPClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/4 14:46
 * @description: TODO
 */
@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    /**
     * 日志对象
     */
    private final Logger log = LoggerFactory.getLogger(ImageUploadServiceImpl.class);

    @Autowired
    private TApplyProDao tApplyProDao;

    private static final String MODEL_CODE = "WD";
    private static final String PART_CODE = "WDYX_PART";
    private static final String IP = "179.169.14.67";
    private static final int PORT = 8021;
    private static final String USER = "wdadmin";
    private static final String PWD = "wd111111";
    private static final String GROUP_DM_NAME = "";
    private static final String LOCAL_PATH = File.separator + "home" + File.separator + "vftpuser" + File.separator;

    @Override
    public void add() throws Exception {
        //获取当前日期
        Date currentWorkDate = new Date();
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = DateFormat.format(currentWorkDate);

        List<TApplyPro> tApplyPros = tApplyProDao.queryAll();

        if (tApplyPros.size() > 0) {

            for (TApplyPro tApplyPro : tApplyPros) {

                SunEcmClientApi api = new SunEcmClientSocketApiImpl(IP, PORT);
                String resultMsg1 = api.login(USER, PWD);
                log.info("#######登陆返回的信息[" + resultMsg1 + "]#######");

                ClientBatchBean clientBatchBean = new ClientBatchBean();
                clientBatchBean.setModelCode(MODEL_CODE);
                clientBatchBean.setUser(USER);
                clientBatchBean.setPassWord(PWD);
                //clientBatchBean.setBreakPoint(false);
                clientBatchBean.setOwnMD5(false);// 是否为批次下的文件添加MD5码

                ClientBatchIndexBean clientBatchIndexBean = new ClientBatchIndexBean();
                clientBatchIndexBean.addCustomMap("CREATEDATE", currentDate);

                TMaterial tMaterial1 = new TMaterial();
                tMaterial1.setImg_current_date(currentDate);

                String busiSeriallNo = UUID.randomUUID().toString().replace("-", "");
                clientBatchIndexBean.addCustomMap("BUSI_SERIAL_NO", busiSeriallNo);

                ClientBatchFileBean clientBatchFileBean = new ClientBatchFileBean();
                clientBatchFileBean.setFilePartName(PART_CODE);
                //根据申请编号查询合同
                String apply_no = tApplyPro.getApply_no();
                List<TContract> tContracts = tApplyProDao.queryByApplyNo(apply_no);
                if (tContracts.size() > 0) {
                    for (TContract tContract : tContracts) {
                        String save_path = tContract.getSave_path();
                        String contract_name = tContract.getContract_name();
                        String local_path = LOCAL_PATH + "local" + File.separator + UUID.randomUUID().toString().replace("-", "");
                        //TODO 增加 ftp获取文件
                        FTPClient ftpClient = FTPUtils.getFTPClient("179.169.8.153", 21, "vftpuser", "bdJZ*5%^3vek^6E5");
                           /**
                             * @param ftpClient ftp对象
                             * @param localPath 本地路径
                             * @param localFileName 本地文件名
                             * @param remotePath 远程路径
                             * @param remoteFileName 远程文件名
                             * @return
                             */
                        FTPUtils.FTPdownFile(ftpClient, local_path, contract_name, save_path, contract_name);

                        ClientFileBean fileBean1 = new ClientFileBean();
                        fileBean1.setFileName(local_path + File.separator + contract_name);
                        fileBean1.setFileFormat("pdf");
                        switch (ContractTypeEnum.getContractTypeEnum(Integer.valueOf(tContract.getContract_type()))) {
                            case CONTRACTTYPEONE:
                                fileBean1.addOtherAtt("RESEVER", "C1");
                                break;
                            case CONTRACTTYPETWO:

                                fileBean1.addOtherAtt("RESEVER", "C2");
                                break;
                            case CONTRACTTYPETHREE:
                                fileBean1.addOtherAtt("RESEVER", "C3");
                                break;
                            case CONTRACTTYPEFOUR:
                                fileBean1.addOtherAtt("RESEVER", "C4");
                                break;
                            default:
                                break;
                        }
                        clientBatchFileBean.addFile(fileBean1);

                    }
                }

                Integer id = tApplyPro.getId();
                tMaterial1.setApply_id(id);
                //根据申请id查询清单表
                List<TMaterial> tMaterials = tApplyProDao.queryByApplyId(id);
                ArrayList<Integer> list = new ArrayList<>();
                if (tMaterials.size() > 0) {
                    //遍历清单表
                    for (TMaterial tMaterial : tMaterials) {
                        //获取影像id
                        Integer img_id = tMaterial.getImg_id();
                        list.add(img_id);
                    }
                }

                List<TImage> tImages = tApplyProDao.queryByImageIdList(list);
                if (tImages.size() > 0) {
                    for (TImage tImage1 : tImages) {
                        ClientFileBean fileBean = new ClientFileBean();
                        String img_path = tImage1.getImg_path();
                        String img_file = tImage1.getImg_file();

                        FTPClient ftpClient = FTPUtils.getFTPClient("179.169.8.153", 21, "vftpuser", "bdJZ*5%^3vek^6E5");
                        /**
                         * @param ftpClient ftp对象
                         * @param localPath 本地路径
                         * @param localFileName 本地文件名
                         * @param remotePath 远程路径
                         * @param remoteFileName 远程文件名
                         * @return
                         */
                        String local_path = LOCAL_PATH + "local" + File.separator + UUID.randomUUID().toString().replace("-", "");
                        FTPUtils.FTPdownFile(ftpClient, local_path, img_file, LOCAL_PATH + img_path, img_file);

                        fileBean.setFileName(local_path  + File.separator + img_file);
                        //fileBean1.setFileName("/home/bips/BIPS_08_A/workspace/voucher/20440107/601103/606642/T606642201811200024/497b4bc2-3bff-46b3-93eb-a01f247f2796_sign.pdf");
                        fileBean.setFileFormat("png");
                        String img_name = tImage1.getImg_name();
                        switch (img_name) {
                            case "1":
                                fileBean.addOtherAtt("RESEVER", "p1");
                                break;
                            case "2":
                                fileBean.addOtherAtt("RESEVER", "p2");
                                break;
                            case "3":
                                fileBean.addOtherAtt("RESEVER", "p3");
                                break;
                            case "4":
                                fileBean.addOtherAtt("RESEVER", "p4");
                                break;
                            case "5":
                                fileBean.addOtherAtt("RESEVER", "p5");
                                break;
                            case "6":
                                fileBean.addOtherAtt("RESEVER", "p6");
                            default:
                                break;
                        }
                        clientBatchFileBean.addFile(fileBean);
                    }
                }

                clientBatchBean.setIndex_Object(clientBatchIndexBean);
                clientBatchBean.addDocument_Object(clientBatchFileBean);

                try {
                    log.info("---> 开始批次上传文件 ");
                    String resultMsg = api.upload(clientBatchBean, GROUP_DM_NAME);
                    log.info("---> 上传批次返回的信息 " + resultMsg);
                    //tMaterial1.setImg_plat_result(resultMsg.substring(13));
                } catch (Exception e) {
                    log.info("---> 上传批次异常!", e.fillInStackTrace());
                    return;
                }
                log.info("-----> 开始更新清单表");
                //tApplyProDao.updateByApplyId(tMaterial1);
                log.info("-----> 更新清单表成功");
                break;
            }
        }
    }

    @Override
    public void query() {


    }

}
