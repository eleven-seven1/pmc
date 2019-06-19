package com.example.demo.bean;

import lombok.Data;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/4 15:12
 * @description: TODO
 */
@Data
public class TContract {

    private Long id;//   合同编号ID
    private String contract_no;//   合同编号
    private String contract_name;//   合同名称
    private String contract_type;//   合同性质(0 授权合同 2 借款借据合同 1 征信授权协议 3 额度合同 4 代扣协议 5 绑卡协议)
    private Long contract_model_id;//   合同模板ID
    private Long custom_id;//   客户号
    private Long apply_id;//   业务申请ID
    private String apply_no;//   业务申请编号
    private String prd_code;//   贷款产品编号
    private Long prd_id;//   贷款产品ID
    private java.util.Date begin_date;//   合同签订日
    private java.util.Date end_date;//   合同到期日
    private Integer deadline;//   合同期限
    private String save_path;//   合同存放目录
    private Long flow_id;//   流程编号
    private Long user_id;//   客户经理ID
    private String user_name;//   客户经理名字
    private java.math.BigDecimal contract_amount;//   合同金额
    private String bank_no;//   签订银行编号
    private String belong_bank;//   签订银行
    private String rec_account;//   收款帐号
    private String in_dep_id;//   收款银行ID
    private String in_dep_name;//   收款银行名
    private String repay_account;//   扣款帐号
    private String repay_dep_id;//   扣款银行ID
    private String repay_dep_name;//   扣款银行名
    private String t_state;//   合同状态(0：审核中，1：同意，2：拒绝)
    private String pro_overdue_time;//   产品逾期宽限期设定
    private Integer pro_period;//   产品周期
    private String org_no;//
}
