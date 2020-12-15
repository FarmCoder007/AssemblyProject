package com.mymodule.commonlib.base;

/**
 * author : xu
 * date : 2020/12/14 16:35
 * description :
 */
public class BaseModel<T> {

    private T t;

    public BaseModel(T t) {
        this.t = t;
    }

    public T getService() {
        return t;
    }

}
