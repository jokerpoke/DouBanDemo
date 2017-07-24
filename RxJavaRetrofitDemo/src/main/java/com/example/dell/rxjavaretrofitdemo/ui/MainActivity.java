package com.example.dell.rxjavaretrofitdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.dell.rxjavaretrofitdemo.R;
import com.example.dell.rxjavaretrofitdemo.adapter.RvAdapter;
import com.example.dell.rxjavaretrofitdemo.model.entity.TextEntity;
import com.example.dell.rxjavaretrofitdemo.model.service.RetrofitService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new RvAdapter(this);
        recyclerView.setAdapter(adapter);
        loadData();
    }

    private void loadData() {
        RetrofitService.getInstance()
                .getTextData(1)
                .subscribe(new Observer<List<TextEntity.ItemsBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<TextEntity.ItemsBean> itemsBeen) {
                        adapter.addAll(itemsBeen);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("info",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        //执行完成
                    }
                });
    }

    public void btn_jumo(View view) {
        Intent intent=null;
        try{
         intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);

        }catch(Exception e){

        }
        startActivity(intent);
        Log.d("MainActivity", "btn_jumo: "+"MainActivity");
    }
}
