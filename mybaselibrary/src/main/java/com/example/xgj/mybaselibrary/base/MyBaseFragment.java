package com.example.xgj.mybaselibrary.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class MyBaseFragment extends Fragment {


    private View mView;

    //    Unbinder unbinder;

    public MyBaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(getLayoutRes(), container, false);
        //        View inflate = inflater.inflate(R.layout.fragment_base, container, false);
        //        unbinder = ButterKnife.bind(this, mView);
        getButterKnifeBind(mView);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //        unbinder.unbind();
        unbindButterKnife();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutRes();

    protected abstract void getButterKnifeBind(View view);

    protected abstract void unbindButterKnife();
}
