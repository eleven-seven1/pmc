package com.example.demo.util;

import com.sunyard.client.SunEcmClientApi;
import com.sunyard.client.bean.*;
import com.sunyard.client.impl.SunEcmClientSocketApiImpl;
import com.sunyard.util.OptionKey;


public class UploadFile {
	private String modelCode = "WD";
	private String partCode= "WDYX_PART";
	private String ip = "179.169.14.67";
	private int port = 8021;
	private String user = "wdadmin";
	private String pwd = "wd111111";
	private String groupDmName = "";
	private String busiSeriallNo = "56765765765 ";//业务系统的唯一码，不允许重复
	private String contentId = "20181119_1_1_5A07B8F2-D846-5826-80FE-5313FC053A11-1 ";//影像平台批次号,影像平台自动生成的
	private String currentDate = "20200101 ";//上传时间
	
	public static void main(String[] args) throws Exception {
		
		//new UploadFile().heightQueryExample();
		//new UploadFile().query();
		new UploadFile().add();
		//new UploadFile().updateExample();

	}
	
	//上传
	public void add() throws Exception{
		//先高级查询
		SunEcmClientApi api = new SunEcmClientSocketApiImpl(ip,port);
		String resultMsg1 = api.login("wdadmin", "wd111111");
		System.out.println("#######登陆返回的信息[" + resultMsg1 + "]#######");	
		ClientBatchBean clientBatchBean = new ClientBatchBean();
		clientBatchBean.setModelCode(modelCode);
		clientBatchBean.setUser(user);
		clientBatchBean.setPassWord(pwd);
		//clientBatchBean.setBreakPoint(false);
		clientBatchBean.setOwnMD5(false);// 是否为批次下的文件添加MD5码
		
		ClientBatchIndexBean clientBatchIndexBean = new ClientBatchIndexBean();
		//clientBatchIndexBean.setAmount("2");//个数
		clientBatchIndexBean.addCustomMap("CREATEDATE", currentDate);
		//clientBatchIndexBean.addCustomMap("BUSI_START_DATE", currentDate);
		clientBatchIndexBean.addCustomMap("BUSI_SERIAL_NO", busiSeriallNo);
		
		
		ClientBatchFileBean clientBatchFileBean = new ClientBatchFileBean();
		clientBatchFileBean.setFilePartName(partCode);
//		for(int i = 0 ; i < 2 ; i++){
//			ClientFileBean fileBean1 = new ClientFileBean();
//			if (i == 0){
//				fileBean1.setFileName("F:\\temp\\008.jpg");
//			}else{
//				fileBean1.setFileName("F:\\temp\\0002.jpg");
//			}
//			
//			fileBean1.setFileFormat("jpg");
//			//fileBean1.addOtherAtt("START_TIME", "20120612");
//			clientBatchFileBean.addFile(fileBean1);
//		}
		ClientFileBean fileBean1 = new ClientFileBean();
		fileBean1.setFileName("F:\\idea.jpg");
		//fileBean1.setFileName("/home/bips/BIPS_08_A/workspace/voucher/20440107/601103/606642/T606642201811200024/497b4bc2-3bff-46b3-93eb-a01f247f2796_sign.pdf");
		fileBean1.setFileFormat("jpg");
		//fileBean1.setReceived(new Long(2));
		
		
		//fileBean1.addOtherAtt("FILEFORM", "IMAGE");//所属类型
		//fileBean1.addOtherAtt("SHOWNAME", "你好你好");
		
		
		//文件名称
		//String fileNO = RandomGUID.getGUIDStr();
		//fileBean1.addOtherAtt("TRUENAME", fileNO + "." +fileBean1.getFileFormat());//文件名
		//FileMD5Verify fmd5 = new FileMD5Verify();
		//File file = new File("F:\\008.jpg");
		//String md5 = fmd5.getFileMD5String(file);
		//fileBean1.addOtherAtt("FILEMD5", md5);//文件MD5码
		//fileBean1.addOtherAtt("FILEATTR", "1"); //影像属性 图片为1，xml文件为2
		
		
		clientBatchFileBean.addFile(fileBean1);
		
		clientBatchBean.setIndex_Object(clientBatchIndexBean);
		clientBatchBean.addDocument_Object(clientBatchFileBean);
		
		try {
			String resultMsg = api.upload(clientBatchBean, groupDmName);
			//log.debug("#######上传批次返回的信息[" + resultMsg + "]#######");
			System.out.println(resultMsg);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    //查询
	public void query() throws Exception{
		SunEcmClientApi api = new SunEcmClientSocketApiImpl(ip,port);
		//api.login(user, pwd);
		
		ClientBatchBean clientBatchBean = new ClientBatchBean();
		clientBatchBean.setModelCode(modelCode);
		clientBatchBean.setUser(user);
		clientBatchBean.setPassWord(pwd);
		clientBatchBean.getIndex_Object().setContentID(contentId);
		clientBatchBean.getIndex_Object().addCustomMap("CREATEDATE", currentDate);
		ClientBatchFileBean documentObject = new ClientBatchFileBean();
		documentObject.setFilePartName(partCode);
		//documentObject.addFilter("FILE_FORMAT","pdf");
		clientBatchBean.addDocument_Object(documentObject);
		//clientBatchBean.getIndex_Object().setVersion("2");
		
		try {
			String resultMsg = api.queryBatch(clientBatchBean, groupDmName);
			//log.debug("#######上传批次返回的信息[" + resultMsg + "]#######");
			System.out.println(resultMsg);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//高级查询
	public void heightQueryExample() throws Exception {
		SunEcmClientApi api = new SunEcmClientSocketApiImpl(ip,port);
		//api.login(user, pwd);
		
		ClientHeightQuery heightQuery = new ClientHeightQuery();
		heightQuery.setUserName(user);
		heightQuery.setPassWord(pwd);
		heightQuery.setLimit(10);
		heightQuery.setPage(1);
		heightQuery.setModelCode(modelCode);

		heightQuery.addCustomAtt("CREATEDATE", currentDate);
		heightQuery.addCustomAtt("BUSI_SERIAL_NO", busiSeriallNo); // 根据条件查询
		// heightQuery.addfilters("VARCHARTYPE='varchartype'");
		try {
			String resultMsg = api.heightQuery(heightQuery, groupDmName);
			System.out.println("#######调用高级搜索返回的信息[" + resultMsg + "]#######");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//更新
	public void updateExample(){
		
		SunEcmClientApi api = new SunEcmClientSocketApiImpl(ip,port);
		ClientBatchBean clientBatchBean = new ClientBatchBean();
		//必选字段，设置索引对象英文名
		clientBatchBean.setModelCode(modelCode);
		//必选字段，设置登录用户名
		clientBatchBean.setUser(user);
		//必选字段，设置用户名密码
		clientBatchBean.setPassWord(pwd);
		//必选字段，设置文件传输是否需要MD5的校验。True 需要；false 不需要
		clientBatchBean.setOwnMD5(true);
		clientBatchBean.getIndex_Object().addCustomMap("CREATEDATE", currentDate);
		//必选字段，设置内容ID
		clientBatchBean.getIndex_Object().setContentID(contentId);
		
		
		//必选字段，创建文档对象Bean
		ClientBatchFileBean batchFileBean = new ClientBatchFileBean();
		//必选字段，设置文档对象英文名
		batchFileBean.setFilePartName(partCode);
		
		
		// 新增一个文件 
		ClientFileBean clientFileBean1 = new ClientFileBean();
		//必选字段，设置操作类型为追加
		clientFileBean1.setOptionType(OptionKey.U_ADD);
		//必选字段，设置文件路径
		clientFileBean1.setFileName("F:\\temp\\008.jpg");
		//必选字段，设置文件格式
		clientFileBean1.setFileFormat("jpg");
		//必选字段，将文档对象添加到索引对象中
		batchFileBean.addFile(clientFileBean1);
		
		
		/*// 替换一个文件 
		ClientFileBean clientFileBean2 = new ClientFileBean();
		//必选字段，设置操作类型为替换文件
		clientFileBean2.setOptionType(OptionKey.U_REPLACE);
		//必选字段，设置指定替换的文件ID
		clientFileBean2.setFileNO("297C51F7-2EA4-2DFE-9F8D-CC8396C6A2D3");
		//必选字段，设置替换后的文件路径
		clientFileBean2.setFileName("F:\\temp\\008.jpg");
		//必选字段，设置文件格式
		clientFileBean2.setFileFormat("jpg");
		//必选字段，将文档对象添加到索引对象中
		batchFileBean.addFile(clientFileBean2);
		*/
		
		
		/*// 删除一个文件 
		ClientFileBean clientFileBean3 = new ClientFileBean();
		//必选字段，设置操作类型为删除文件
		clientFileBean3.setOptionType(OptionKey.U_DEL);
		//必选字段，设置删除的文件ID
		clientFileBean3.setFileNO("7ADBDD09-DFC4-2A00-3503-51EEC95BBA39");
		//必选字段，将文档对象添加到索引对象中
		batchFileBean.addFile(clientFileBean3);*/
		
		
		
		/*// 修改文档部件字段，不替换文件
		ClientFileBean clientFileBean = new ClientFileBean();
		//必选字段，设置操作类型为修改属性
		clientFileBean.setOptionType(OptionKey.U_MODIFY);
		//必选字段，设置需要修改的文件ID
		clientFileBean.setFileNO("F13F8FBB-7213-270D-97EE-71DBB6696CA7");
		//必选字段，设置替换的文件格式
		clientFileBean.setFileFormat("jpg");
		//必选字段，设置需要替换的自定义属性
		clientFileBean.addOtherAtt("LOAN","opkqss");
		//必选字段，将文档对象添加到索引对象中
		batchFileBean.addFile(clientFileBean);*/
		clientBatchBean.addDocument_Object(batchFileBean);
		try {
		//调用更新接口
		String resultMsg = api.update(clientBatchBean, groupDmName, true);
		System.out.println("#######更新批次返回的信息[" + resultMsg + "]#######");
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	
	
	
	

}
