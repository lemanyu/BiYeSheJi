package com.zhaogui.biyesheji.fragment;

/**
 * Created by gui on 2017/8/18.
 */

public class Data {
    private  String type;
    private String title;
    private int icon;
     public Data(String title,int icon){
         this.title=title;
         this.icon=icon;
     }
    public Data(String title,int icon,String type){
        this.title=title;
        this.icon=icon;
        this.type=type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
