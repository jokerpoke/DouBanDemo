package com.example.xgj.doubandemo.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xgj.doubandemo.R;
import com.example.xgj.doubandemo.bean.Ship;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chen on 2017/6/21.
 */

public class TextNewsAdapter extends RecyclerView.Adapter {
    private List<Ship> datas = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public TextNewsAdapter(List<Ship> datas, Context context) {
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TextNewsViewHolder(layoutInflater.inflate(R.layout.item_textnews, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //        Jinmimi itemsBean = (Jinmimi) datas;
        Ship jinmimi = datas.get(position);
        TextNewsViewHolder textNewsViewHolder = (TextNewsViewHolder) holder;
        textNewsViewHolder.tv_content.setText(jinmimi.getTitle());
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    class TextNewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_textnews_iv_user)
        ImageView iv_user;
        @BindView(R.id.item_textnews_tv_content)
        TextView tv_content;

        public TextNewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void addAll(List<Ship> jinmimiList) {
        datas.addAll(jinmimiList);
        notifyDataSetChanged();
    }
}
