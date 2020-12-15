package com.mymodule.commonlib.base;

import androidx.fragment.app.Fragment;

/**
 * author : xu
 * date : 2020/12/14 16:35
 * description :
 */
public class BaseFragmentPresenter<T, APP extends BaseApplication> {

    private T IView;
    private APP app;

    public BaseFragmentPresenter(T IView) {
        this.IView = IView;
        this.app = (APP) ((Fragment) IView).getActivity().getApplication();
    }

    public T getIView() {
        return IView;
    }

    public APP getApp() {
        return app;
    }

}