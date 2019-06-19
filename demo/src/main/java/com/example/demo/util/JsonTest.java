package com.example.demo.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/19 11:38
 * @description: TODO
 */
public class JsonTest {


    private static final String str = "{\n" +
            "\t\"success\": true,\n" +
            "\t\"id\": \"WF2019061817081089771413\",\n" +
            "\t\"result_desc\": {\n" +
            "\t\t\"PERSONASPRELOAN\": {\n" +
            "\t\t\t\"criminal_info\": {\n" +
            "\t\t\t\t\"result\": 0,\n" +
            "\t\t\t\t\"success\": true,\n" +
            "\t\t\t\t\"message\": {\n" +
            "\t\t\t\t\t\"is_criminal\": 0,\n" +
            "\t\t\t\t\t\"criminal_msg\": \"未比中\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"params\": {\n" +
            "\t\t\t\t\"id_number\": \"370404199006301915\",\n" +
            "\t\t\t\t\"account_name\": \"?????′??′\",\n" +
            "\t\t\t\t\"account_mobile\": \"13333333333\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"indicatrix\": [{\n" +
            "\t\t\t\t\"feature_level2\": \"个人信贷名单库\",\n" +
            "\t\t\t\t\"feature_level1\": \"信贷名单库\",\n" +
            "\t\t\t\t\"description\": \"最近90天身份证是否命中风险类型为法院执行，主体类型为个人的名单\",\n" +
            "\t\t\t\t\"feature_level3\": \"个人法院执行\",\n" +
            "\t\t\t\t\"i_is_per_all_all_courtcease_all_90day\": null\n" +
            "\t\t\t}, {\n" +
            "\t\t\t\t\"feature_level2\": \"个人信贷名单库\",\n" +
            "\t\t\t\t\"feature_level1\": \"信贷名单库\",\n" +
            "\t\t\t\t\"description\": \"最近360天身份证是否命中风险类型为法院执行，主体类型为个人的名单\",\n" +
            "\t\t\t\t\"feature_level3\": \"个人法院执行\",\n" +
            "\t\t\t\t\"i_is_per_all_all_courtcease_all_360day\": 1.0,\n" +
            "\t\t\t\t\"list_library\": {\n" +
            "\t\t\t\t\t\"reason_code\": null,\n" +
            "\t\t\t\t\t\"result\": [{\n" +
            "\t\t\t\t\t\t\"evidence_time\": \"2018-10\",\n" +
            "\t\t\t\t\t\t\"case_no\": \"(2018)浙0209执1692\",\n" +
            "\t\t\t\t\t\t\"risk_type\": \"court_zhixing\",\n" +
            "\t\t\t\t\t\t\"exec_amount\": 2476260.5,\n" +
            "\t\t\t\t\t\t\"role\": \"self\",\n" +
            "\t\t\t\t\t\t\"subject_type\": \"individual\",\n" +
            "\t\t\t\t\t\t\"case_character\": \"others\",\n" +
            "\t\t\t\t\t\t\"case_type\": \"job_related_crimes\",\n" +
            "\t\t\t\t\t\t\"industry\": \"p2p\"\n" +
            "\t\t\t\t\t}],\n" +
            "\t\t\t\t\t\"reason_desc\": null\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}, {\n" +
            "\t\t\t\t\"feature_level2\": \"个人信贷名单库\",\n" +
            "\t\t\t\t\"feature_level1\": \"信贷名单库\",\n" +
            "\t\t\t\t\"i_is_per_all_all_courtcease_all_all\": 1.0,\n" +
            "\t\t\t\t\"description\": \"身份证是否命中风险类型为法院执行，主体类型为个人的名单\",\n" +
            "\t\t\t\t\"feature_level3\": \"个人法院执行\",\n" +
            "\t\t\t\t\"list_library\": {\n" +
            "\t\t\t\t\t\"reason_code\": null,\n" +
            "\t\t\t\t\t\"result\": [{\n" +
            "\t\t\t\t\t\t\"evidence_time\": \"2018-10\",\n" +
            "\t\t\t\t\t\t\"case_no\": \"(2018)浙0209执1692\",\n" +
            "\t\t\t\t\t\t\"risk_type\": \"court_zhixing\",\n" +
            "\t\t\t\t\t\t\"exec_amount\": 2476260.5,\n" +
            "\t\t\t\t\t\t\"role\": \"self\",\n" +
            "\t\t\t\t\t\t\"subject_type\": \"individual\",\n" +
            "\t\t\t\t\t\t\"case_character\": \"others\",\n" +
            "\t\t\t\t\t\t\"case_type\": \"job_related_crimes\",\n" +
            "\t\t\t\t\t\t\"industry\": \"p2p\"\n" +
            "\t\t\t\t\t}],\n" +
            "\t\t\t\t\t\"reason_desc\": null\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}, {\n" +
            "\t\t\t\t\"i_is_per_all_all_courtdefault_all_90day\": null,\n" +
            "\t\t\t\t\"feature_level2\": \"个人信贷名单库\",\n" +
            "\t\t\t\t\"feature_level1\": \"信贷名单库\",\n" +
            "\t\t\t\t\"description\": \"最近90天身份证是否命中风险类型为法院失信，主体类型为个人的名单\",\n" +
            "\t\t\t\t\"feature_level3\": \"个人法院失信\"\n" +
            "\t\t\t}, {\n" +
            "\t\t\t\t\"feature_level2\": \"个人信贷名单库\",\n" +
            "\t\t\t\t\"feature_level1\": \"信贷名单库\",\n" +
            "\t\t\t\t\"description\": \"最近360天身份证是否命中风险类型为法院失信，主体类型为个人的名单\",\n" +
            "\t\t\t\t\"feature_level3\": \"个人法院失信\",\n" +
            "\t\t\t\t\"list_library\": {\n" +
            "\t\t\t\t\t\"reason_code\": null,\n" +
            "\t\t\t\t\t\"result\": [{\n" +
            "\t\t\t\t\t\t\"evidence_time\": \"2018-09\",\n" +
            "\t\t\t\t\t\t\"case_no\": \"(2018)浙0109执1691\",\n" +
            "\t\t\t\t\t\t\"risk_type\": \"court_shixin\",\n" +
            "\t\t\t\t\t\t\"role\": \"self\",\n" +
            "\t\t\t\t\t\t\"subject_type\": \"individual\",\n" +
            "\t\t\t\t\t\t\"case_status\": \"case_shixin\",\n" +
            "\t\t\t\t\t\t\"industry\": \"bank\"\n" +
            "\t\t\t\t\t}],\n" +
            "\t\t\t\t\t\"reason_desc\": null\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"i_is_per_all_all_courtdefault_all_360day\": 1.0\n" +
            "\t\t\t}, {\n" +
            "\t\t\t\t\"feature_level2\": \"个人信贷名单库\",\n" +
            "\t\t\t\t\"feature_level1\": \"信贷名单库\",\n" +
            "\t\t\t\t\"description\": \"身份证是否命中风险类型为法院失信，主体类型为个人的名单\",\n" +
            "\t\t\t\t\"feature_level3\": \"个人法院失信\",\n" +
            "\t\t\t\t\"i_is_per_all_all_courtdefault_all_all\": 1.0,\n" +
            "\t\t\t\t\"list_library\": {\n" +
            "\t\t\t\t\t\"reason_code\": null,\n" +
            "\t\t\t\t\t\"result\": [{\n" +
            "\t\t\t\t\t\t\"evidence_time\": \"2018-09\",\n" +
            "\t\t\t\t\t\t\"case_no\": \"(2018)浙0109执1691\",\n" +
            "\t\t\t\t\t\t\"risk_type\": \"court_shixin\",\n" +
            "\t\t\t\t\t\t\"role\": \"self\",\n" +
            "\t\t\t\t\t\t\"subject_type\": \"individual\",\n" +
            "\t\t\t\t\t\t\"case_status\": \"case_shixin\",\n" +
            "\t\t\t\t\t\t\"industry\": \"bank\"\n" +
            "\t\t\t\t\t}],\n" +
            "\t\t\t\t\t\"reason_desc\": null\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}, {\n" +
            "\t\t\t\t\"feature_level2\": \"借贷全流程\",\n" +
            "\t\t\t\t\"feature_level1\": \"信贷风险\",\n" +
            "\t\t\t\t\"description\": \"身份证关联到的365天内全行业下申贷事件中最近第1个完整自然月不同平台个数\",\n" +
            "\t\t\t\t\"feature_level3\": \"借贷多头风险\",\n" +
            "\t\t\t\t\"i_cnt_partner_last1stmth_Loan_all_365day\": null\n" +
            "\t\t\t}, {\n" +
            "\t\t\t\t\"i_cnt_partner_last2ndmth_Loan_all_365day\": null,\n" +
            "\t\t\t\t\"feature_level2\": \"借贷全流程\",\n" +
            "\t\t\t\t\"feature_level1\": \"信贷风险\",\n" +
            "\t\t\t\t\"description\": \"身份证关联到的365天内全行业下申贷事件中最近第2个完整自然月不同平台个数\",\n" +
            "\t\t\t\t\"feature_level3\": \"借贷多头风险\"\n" +
            "\t\t\t}]\n" +
            "\t\t}\n" +
            "\t}\n" +
            "}";
    public static void main(String[] args) {

        JSONObject jsonObject = JSON.parseObject(str);

        System.out.println("jsonObject" + jsonObject);

        JSONObject result_desc = jsonObject.getJSONObject("result_desc");

        System.out.println("result_desc : "  + result_desc);

        JSONObject PERSONASPRELOAN = result_desc.getJSONObject("PERSONASPRELOAN");

        System.out.println("PERSONASPRELOAN : " + PERSONASPRELOAN);

        JSONArray indicatrix = PERSONASPRELOAN.getJSONArray("indicatrix");



        System.out.println("indicatrix : " + indicatrix.size());

    }
}
