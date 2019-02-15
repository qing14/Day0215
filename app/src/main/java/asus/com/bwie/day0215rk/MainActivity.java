package asus.com.bwie.day0215rk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import asus.com.bwie.day0215rk.adapter.NewsAdapter;
import asus.com.bwie.day0215rk.bean.Newsbean;
import asus.com.bwie.day0215rk.presenter.PresenterImpl;
import asus.com.bwie.day0215rk.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView recyclerView;
    private PresenterImpl presente;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        presente = new PresenterImpl(this);
        newsAdapter = new NewsAdapter(this);
        initData();
    }

    private void initData() {
        Map<String,String> map=new HashMap<>();
        map.put("page",1+"");
        presente.Request(Apis.path,map,Newsbean.class);
    }

    @Override
    public void onSuccessData(Object data) {
        Newsbean newsbean= (Newsbean) data;

    }

    @Override
    public void onFailsData(Exception e) {

    }
}
