package com.xmj.vo;

import java.util.Date;

public class Manager {
    private int man_autoid;
    private String man_account ;
    private String man_pwd;
    private String man_id;
    private String man_sex;
    private String man_telnumber;
    private String man_email;
    private Date   man_time;//注册时间
    private boolean flag;

    public int getMan_autoid() {
        return man_autoid;
    }

    public void setMan_autoid(int man_autoid) {
        this.man_autoid = man_autoid;
    }

    public String getMan_account() {
        return man_account;
    }

    public void setMan_account(String man_account) {
        this.man_account = man_account;
    }

    public String getMan_pwd() {
        return man_pwd;
    }

    public void setMan_pwd(String man_pwd) {
        this.man_pwd = man_pwd;
    }

    public String getMan_id() {
        return man_id;
    }

    public void setMan_id(String man_id) {
        this.man_id = man_id;
    }

    public String getMan_sex() {
        return man_sex;
    }

    public void setMan_sex(String man_sex) {
        this.man_sex = man_sex;
    }

    public String getMan_telnumber() {
        return man_telnumber;
    }

    public void setMan_telnumber(String man_telnumber) {
        this.man_telnumber = man_telnumber;
    }

    public String getMan_email() {
        return man_email;
    }

    public void setMan_email(String man_email) {
        this.man_email = man_email;
    }

    public Date getMan_time() {
        return man_time;
    }

    public void setMan_time(Date man_time) {
        this.man_time = man_time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
