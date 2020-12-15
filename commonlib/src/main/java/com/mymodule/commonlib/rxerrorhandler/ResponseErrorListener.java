package com.mymodule.commonlib.rxerrorhandler;

import android.content.Context;

/**
 * author : xu
 * date : 2020/12/14 17:19
 * description :
 */
public interface ResponseErrorListener {
    void hanlderResponseError(Context context, Exception e);
}
