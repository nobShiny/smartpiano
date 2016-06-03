package com.lsj.smartpiano.common.bean;

/**
 * Created by shiny_jia
 * on 2016-06-02 22:36.
 */
public class KeyValueBean {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public KeyValueBean(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public KeyValueBean() {
        super();
    }
}
