package com.example.demo.bean;

import lombok.Data;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/4 15:02
 * @description: TODO
 */
@Data
public class TApplyPro {

    private Integer id;//   申请业务ID
    private String apply_no;//   申请编号
    private Integer custom_id;//   客户ID
    private String custom_no;//   客户编号
    private String custom_name;//   客户名
    private String card_no;//   证件号码
    private Integer prd_id;//   贷款产品ID
    private String prd_code;//   贷款产品编号
    private String prd_name;//   贷款产品名称
    private String buss_type_id;//   业务类型(0 单笔贷款 1 循环贷款 2 非循环贷款)
    private String buss_type_name;//   业务类型名
    private Integer apply_dep_id;//   申请部门ID
    private String apply_dep_name;//   申请部门名称
    private String apply_state;//   业务状态(0：审核中，1：同意，2：拒绝)
    private java.math.BigDecimal credit_amount;//   授信金额
    private java.math.BigDecimal loan_amount;//   贷款金额
    private java.math.BigDecimal rate_value;//   利率值
    private Integer period;//   期数
    private Integer repay_id;//   还款方式编号(1等额本息2等额本金3先息后本4一次性利随本清5只还本金6等本等息)
    private String repay_name;//   还款方式名
    private Integer loan_type_id;//   放款方式编号(0 单笔贷款1 循环贷款2非循环贷款)
    private String loan_type_name;//   放款方式名
    private String rec_account;//   收款帐号
    private String in_dep_id;//   收款银行ID
    private String in_dep_name;//   收款银行名
    private String repay_account;//   扣款帐号
    private String repay_dep_id;//   扣款银行ID
    private String repay_dep_name;//   扣款银行名
    private String approach;//   申请途径
    private String gps_location;//   GPS定位
    private Integer merchant_id;//   合作商家
    private Integer fund_id;//   合作资金方
    private Integer guarantee_id;//   合作担保方
    private Integer platform_id;//   合作资产方
    private String loan_way;//   贷款用途
    private java.util.Date apply_time;//   申请时间
    private String finance_channel;//   资金渠道
    private String json;//   可变数据
    private String discount_rate;//   利率折扣
    private String advise_discount;//   建议折扣
    private String final_rate;//   最终利率
    private String advise_result;//   建议结论
    private java.math.BigDecimal advise_amount;//   建议授信金额
    private String warning_status;//   预警标志
    private String flag;//   不同流程申请的标志
    private Integer user_id;//   归属客户经理编号
    private String serial_no;//   流水号
    private String kkzq;//   扣款周期(0日 1 周 2 月 3 年)
    private java.math.BigDecimal per_amount;//   每期总还款金额
    private java.math.BigDecimal per_service_charge;//   每期交易手续费
    private String comerchant_apply_no;//   商户申请编号
    private String comerchant_order_no;//   商户订单编号
    private String receive_url;//   贷款申请结果异步通知地址
    private String approval_note;//   审批结论，拒绝时原因描述
    private Integer surplus_receive_count;//   贷款申请结果异步通知剩余次数
    private String second_account_no;//   二类账号或电子账号
    private String rent_receive_url;//   代扣租金结果异步通知地址
    private String prod_type;//   产品类型：1委托类，2租赁类，3自营类，4助贷类
    private String auth_receive_url;//
    private Integer auth_receive_count;//
    private String is_agriculture;//   是否涉农贷款（0：否 1：是）
    private String is_poverty1_flag;//   精准扶贫贷款标识（0：否 1：是）
    private String is_school_flag;//   校园消费贷款标识（0：否 1：是）
    private String is_study_flag;//   助学贷款类型（0：非助学贷款 1：高校政策性助学贷款 2：高校商业助学贷款 3：生源地政策性助学贷款 4：生源地商业助学贷款 5：其他政策性助学贷款 6：其他商业助学贷款）
    private String is_poverty2_flag;//   扶贫小额贷款标识（0：否 1：是）
    private String is_pratt_flag;//   普惠型贷款类型（0：否 1：是）
    private String is_unemployment_flag;//   下岗失业贷款（0：否 1：是）
    private String is_pioneer_flag;//   创业富民贷款（0：否 1：是）
    private String investing_area;//   投向地区
    private String investing_major_in;//   投向行业
    private String buss_type;//   业务种类（1：流动资金贷款，2：项目贷款，3：一般固定资产贷款，4：住房贷款，5：商用房贷款，6：公积金贷款，7：汽车贷款，8：助学贷款，9：消费贷款，10：个人经营性贷款，11：农户贷款，12：其他贷款）
    private String loan_mode;//   放款方式（1：自主支付，2：受托支付，3：混合支付）
    private String rate_type;//   利率类型（1：固定 2：浮动）
    private java.math.BigDecimal rate_float;//   利率浮动
    private String main_guarantee;//   主要担保方式（0：其他，1：质押，2：抵押，3：保证，4：信用）
    private String is_limit_major;//   是否国家限制行业（0：否 1：是）
    private String decision_tags;//   决策拒绝标签信息
    private String decision_note;//   决策拒绝标签详细信息
}
