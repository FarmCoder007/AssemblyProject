package com.mymodule.commonlib.base;

import android.app.Activity;

import androidx.fragment.app.Fragment;

/**
 * author : xu
 * date : 2020/12/14 16:36
 * description :
 */
public class BasePresenter<T> {

    private T IView;
    private BaseApplication app;

    public BasePresenter(T IView) {
        this.IView = IView;
        try {
            this.app = (BaseApplication) ((Activity) IView).getApplication();
        } catch (ClassCastException ignored) {
            this.app = (BaseApplication) (((Fragment) IView).getActivity()).getApplication();
        }
    }

    public T getIView() {
        return IView;
    }

    public BaseApplication getApp() {
        return app;
    }

}
