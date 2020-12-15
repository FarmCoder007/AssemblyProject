package com.mymodule.commonlib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author : xu
 * date : 2020/12/14 16:34
 * description :
 */
public abstract class BaseFragment<p extends BasePresenter> extends Fragment {
    private BaseApplication application;
    private View rootView;
    private Activity mainActivity;
    private Unbinder bind;

    @Override
    public void onAttach(Context context) {
        if (context instanceof Activity) {
            mainActivity = (Activity) getActivity();
        } else {
            throw new ClassCastException("Activity can't cast to MainActivity");
        }
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        application = (BaseApplication) (getActivity().getApplication());
        if (null == rootView) {//如果缓存中有rootView则直接使用
            rootView = inflater.inflate(getContentViewId(), container, false);
            bind = ButterKnife.bind(this, rootView);
            //在OnCreate方法中调用下面方法，然后再使用线程，就能在uncaughtException方法中捕获到异常
            if (isAdded()) {
                initData();
                initView();
            }
        }
        return rootView;
    }

    protected abstract void initView();

    public Activity getMainActivity() {
        return mainActivity;
    }

    protected abstract void initData();

    protected abstract int getContentViewId();

    @Override
    public void onDestroy() {
        if (bind != Unbinder.EMPTY) {
            bind.unbind();
        }
        super.onDestroy();
    }

    public View getRootView() {
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootView != null) {//为rootView做缓存，在viewpager中使用fragment时可以提升切换流畅度
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }

}