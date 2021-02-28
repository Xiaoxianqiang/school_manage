package com.halfsummer.baseframework.vo;

import lombok.Data;

import java.util.List;

/**
 * @author BestClever
 * @title: Meun
 * @projectName book-manage
 * @description: TODO
 * @date 2020-11-01 15:25
 */
@Data
public class Menu {

    /*主键*/
    private Integer id;
    /*标题*/
    private String title;
    /*图标*/
    private String icon;
    /*url链接*/
    private String href;
    /*是否展开*/
    private boolean spread;
    /*目标*/
    private String target;
    /*子数组*/
    private List<Menu> children;
    /*是否选中*/
    private String checkArr;
    /*父节点id*/
    private Integer parentId;

//    public static Menu adapt(SysResources resouces) {
//        Menu menu = new Menu();
//        menu.id = resouces.getId();
//        menu.title = resouces.getResouceName();
//        return menu;
//    }
}
