package asus.com.bwie.day0215rk.presenter;

import java.util.Map;

import asus.com.bwie.day0215rk.callback.MyCallBack;
import asus.com.bwie.day0215rk.model.ModelImpl;
import asus.com.bwie.day0215rk.view.IView;

public class PresenterImpl implements Ipresenter{

    private ModelImpl model;
    private IView iView;

    public PresenterImpl(IView iView) {
        this.model = new ModelImpl();
        this.iView = iView;
    }

    @Override
    public void Request(String url, Map<String, String> map, Class clazz) {

        model.RequestData(url, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }

            @Override
            public void onFails(Exception e) {
                iView.onFailsData(e);
            }
        });

    }
}
