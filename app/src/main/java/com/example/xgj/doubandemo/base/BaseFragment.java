package com.example.xgj.doubandemo.base;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.xgj.mybaselibrary.base.MyBaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends MyBaseFragment {
    Unbinder unbinder;

    @Override
    protected void getButterKnifeBind(View v) {
        unbinder = ButterKnife.bind(this, v);
    }

    @Override
    protected void unbindButterKnife() {
        unbinder.unbind();
    }

    //    public BaseFragment() {
    //        // Required empty public constructor
    //    }
    //
    //
    //    @Override
    //    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    //                             Bundle savedInstanceState) {
    //        // Inflate the layout for this fragment
    //        return inflater.inflate(R.layout.fragment_base, container, false);
    //    }

}
