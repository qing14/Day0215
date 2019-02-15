package asus.com.bwie.day0215rk.model;

import java.util.Map;

import asus.com.bwie.day0215rk.callback.MyCallBack;
import asus.com.bwie.day0215rk.utils.OkhttpUtils;

public class ModelImpl implements Imodel {
    @Override
    public void RequestData(String url, Map<String, String> map, Class clazz, final MyCallBack myCallBack) {
        OkhttpUtils.getOkhttpUtils().Eneuque(url, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                myCallBack.onSuccess(data);
            }

            @Override
            public void onFails(Exception e) {
                myCallBack.onFails(e);
            }
        });
    }
}
