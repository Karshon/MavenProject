package com.xmj.vo;

import java.util.Date;

public class Customer {
    private int cus_autoid;
    private String  cus_account;
    private String  cus_pwd;
    private String    cus_id;
    private String  cus_sex;
    private String  cus_telnumber;
    private String  cus_email;
    private String     cus_time;
    private int     cus_integral;
    private boolean flag;

    public int getCus_autoid() {
        return cus_autoid;
    }

    public void setCus_autoid(int cus_autoid) {
        this.cus_autoid = cus_autoid;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_time() {
        return cus_time;
    }

    public void setCus_time(String cus_time) {
        this.cus_time = cus_time;
    }

    public String getCus_sex() {
        return cus_sex;
    }

    public void setCus_sex(String cus_sex) {
        this.cus_sex = cus_sex;
    }

    public String getCus_telnumber() {
        return cus_telnumber;
    }

    public void setCus_telnumber(String cus_telnumber) {
        this.cus_telnumber = cus_telnumber;
    }

    public String getCus_email() {
        return cus_email;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    public int getCus_integral() {
        return cus_integral;
    }

    public void setCus_integral(int cus_integral) {
        this.cus_integral = cus_integral;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getCus_account() {
        return cus_account;
    }

    public void setCus_account(String cus_account) {
        this.cus_account = cus_account;
    }

    public String getCus_pwd() {
        return cus_pwd;
    }

    public void setCus_pwd(String cus_pwd) {
        this.cus_pwd = cus_pwd;
    }
}
