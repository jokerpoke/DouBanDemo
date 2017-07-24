package com.example.xgj.doubandemo.mvp.textnews;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.xgj.doubandemo.R;
import com.example.xgj.doubandemo.adpater.TextNewsAdapter;
import com.example.xgj.doubandemo.base.BaseActivity;
import com.example.xgj.doubandemo.bean.Jinmimi;
import com.example.xgj.doubandemo.bean.Ship;
import com.example.xgj.doubandemo.bean.TextNewsEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TextNewsActivity extends BaseActivity implements TextNewsContract.View {
    @BindView(R.id.TextActivity_rvlist)
    RecyclerView rv_list;
    @BindView(R.id.TextActivity_srflayout)
    SwipeRefreshLayout srf_layout;

    int page = 1;

    private TextNewsAdapter textNewsAdapter;

    //    @BindView(R.id.tv_text)
    //    TextView tv_text;

    private static final String TAG = "TextNewsActivity";


    private TextNewsPresenter textNewsPresenter;
    private TextNewsContract.Presenter presenter;
    private List<Jinmimi> list = new ArrayList<>();
    private List<TextNewsEntity> items;
    private List<Ship> o1 = new ArrayList<>();




    @Override
    protected void onPresenter() {
        textNewsPresenter = new TextNewsPresenter(this);
        textNewsPresenter.upModel(page);
    }



    @Override
    protected int addChildView() {
        return R.layout.activity_text;
    }

    @Override
    protected void initChildContentView() {
        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        textNewsAdapter = new TextNewsAdapter(o1, TextNewsActivity.this);
        rv_list.setAdapter(textNewsAdapter);


        srf_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (srf_layout.isRefreshing()) {
                    textNewsPresenter.upModel(++page);
                }
            }
        });

    }

    @Override
    protected CharSequence getPageTitle() {
        return "标题";
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initIntentData() {

    }

    @Override
    protected void relievePresenter() {
        if (textNewsPresenter != null) {
            textNewsPresenter = null;
        }
        if (presenter != null) {
            presenter = null;
        }
    }

    //得到presenter解析回调的数据
    @Override
    public void getModel(Object o) {

        o1 = (List<Ship>) o;
        textNewsAdapter.addAll(o1);
        Log.d(TAG, "getModel: " + o1.get(0).getTitle());
        //pd.dismiss();
    }

    @Override
    public void setPresenter(TextNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }


}
