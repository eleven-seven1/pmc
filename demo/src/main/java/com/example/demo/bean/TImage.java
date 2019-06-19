package com.example.demo.bean;

import lombok.Data;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/4 15:18
 * @description: TODO
 */
@Data
public class TImage {

    private String img_id;//   影像名称
    private Integer id;//   影像编号
    private String img_name;//   影像名称
    private String img_fat;//   影像格式
    private String img_path;//   影像路径
    private String img_file;//   影像文件名
}
