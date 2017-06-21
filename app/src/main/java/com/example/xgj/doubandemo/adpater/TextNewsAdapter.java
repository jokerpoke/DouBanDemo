package com.example.xgj.doubandemo.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by chen on 2017/6/21.
 */

public class TextNewsAdapter extends RecyclerView.Adapter {
    private List<String> datas;
    private LayoutInflater layoutInflater;
    private Context context;

    public TextNewsAdapter(List<String> datas, Context context) {
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size() > 0 ? datas.size() : 0;
    }
}
