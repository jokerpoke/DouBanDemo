package com.example.xgj.doubandemo.mvp.latest;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.xgj.doubandemo.R;

public class LatestActivity extends AppCompatActivity {
    //    @BindView(R.id.LatestActivity_tv_testId)
    //    TextView tv_testid;

    private LatestPresenter latestPresenter;

    private Button btn_huan;
    private LinearLayout llayout;
    private ImageView iv_img;
    private static final String url = "http://vipfacaiflvbceshi.com/captcha?t=1499735813380";
    //
    //    @Override
    //    protected int getResLayoutId(Bundle savedInstanceState) {
    //        return R.layout.activity_latest;
    //    }
    //
    //
    //    @Override
    //    protected void onPresenter() {
    //        latestPresenter = new LatestPresenter();
    //
    //    }
    //
    //    @Override
    //    protected void initView() {
    //
    //    }
    //
    //    @Override
    //    protected void initData() {
    //
    //    }
    //
    //    @Override
    //    protected void initIntentData() {
    //
    //    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest);
        btn_huan = (Button) this.findViewById(R.id.btn_huan);
        iv_img = (ImageView) this.findViewById(R.id.iv_img);
        llayout = (LinearLayout) this.findViewById(R.id.llayout);
        Glide.with(this).load(Uri.parse(url)).into(iv_img);
        btn_huan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                    iv_img.setBackground(null);
                llayout.removeAllViews();
                String innurl=url;
                ImageView img = new ImageView(LatestActivity.this);
                Glide.with(LatestActivity.this).load(Uri.parse(innurl))
                        .skipMemoryCache( true )
                        .diskCacheStrategy( DiskCacheStrategy.NONE )
                        .into(img);

                llayout.addView(img);
            }
        });

    }
}
