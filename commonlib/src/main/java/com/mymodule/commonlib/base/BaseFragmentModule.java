package com.mymodule.commonlib.base;

/**
 * author : xu
 * date : 2020/12/14 16:35
 * description :
 */
public abstract class BaseFragmentModule<E> {

    private E e;

    public BaseFragmentModule(E e) {
        this.e = e;
    }

    public E providerView(E e) {
        return e;
    }
}
