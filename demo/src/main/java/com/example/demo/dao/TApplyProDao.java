package com.example.demo.dao;

import com.example.demo.bean.TApplyPro;
import com.example.demo.bean.TContract;
import com.example.demo.bean.TImage;
import com.example.demo.bean.TMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/4 15:00
 * @description: TODO
 */
@Mapper()
@Component("tApplyProDao")
public interface TApplyProDao {

    List<TApplyPro> queryAll();

    List<TContract> queryByApplyNo(String apply_no);

    List<TMaterial> queryByApplyId(Integer apply_id);

    List<TImage> queryByImageIdList(List<Integer> id);

    int updateByApplyId(TMaterial tMaterial);
}
