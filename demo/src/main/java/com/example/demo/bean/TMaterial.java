package com.example.demo.bean;

import lombok.Data;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/4 15:10
 * @description: TODO
 */
@Data
public class TMaterial {

    private Integer id;//   资料编号
    private String m_type;//   所属类型(暂未启用)
    private String big_code;//   大类编号
    private String big_name;//   大类名称
    private String small_code;//   小类编号
    private String small_name;//   小类名称
    private String meterial_name;//   资料名称
    private java.util.Date regist_date;//   登记时间
    private String regist_user;//   登记人员
    private Integer img_id;//   对应影像编号
    private Integer apply_id;//   申请编号
    private Integer customer_id;//   客户编号
    private String img_plat_result;
    private String img_current_date;
}
