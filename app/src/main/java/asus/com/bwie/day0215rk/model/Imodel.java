package asus.com.bwie.day0215rk.model;

import java.util.Map;

import asus.com.bwie.day0215rk.callback.MyCallBack;

public interface Imodel {

    void RequestData(String url, Map<String,String> map, Class clazz, MyCallBack myCallBack);
}
