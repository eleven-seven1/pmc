package com.example.demo.common;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/4 15:16
 * @description: TODO
 */
public enum ContractTypeEnum {

    //合同性质(2 贷款合同 1 征信授权协议 3 注册协议 4 代扣协议 5 绑卡协议)
    CONTRACTTYPEONE("征信授权协议",1),
    CONTRACTTYPETWO("借款借据合同",2),
    CONTRACTTYPETHREE("借款额度合同",3),
    CONTRACTTYPEFOUR("投保单合同",4);
    Integer index;
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    ContractTypeEnum(String name,Integer index){
        this.index=index;
        this.name=name;
    }
    public static ContractTypeEnum getContractTypeEnum(Integer index){
        if(index==null){
            return null;
        }
        for (ContractTypeEnum e : ContractTypeEnum.values()) {
            if (index.equals(e.getIndex())) {
                return e;
            }
        }
        return null;
    }

}
