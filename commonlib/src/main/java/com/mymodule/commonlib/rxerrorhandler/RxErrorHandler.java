package com.mymodule.commonlib.rxerrorhandler;

import android.content.Context;

/**
 * author : xu
 * date : 2020/12/14 17:21
 * description :
 */
public class RxErrorHandler {
    private ResponseErrorListener responseErrorListener;
    private Context context;

    public RxErrorHandler(Builder builder) {
        this.responseErrorListener = builder.responseErrorListener;
        this.context = builder.context;
    }

    public static Builder builder() {

        return new Builder();
    }

    public void handleError(Throwable throwable)

    {
        responseErrorListener.hanlderResponseError(context, ((Exception) throwable));
    }

    public static class Builder {
        private ResponseErrorListener responseErrorListener;

        private Context context;

        public Builder() {
        }

        public Builder with(Context context) {
            this.context = context;
            return this;
        }

        public Builder responseErrorListener(ResponseErrorListener responseErrorListener) {
            this.responseErrorListener = responseErrorListener;
            return this;
        }

        public RxErrorHandler build() {
            if (context == null)
                throw new IllegalStateException("context is required");

            if (responseErrorListener == null)
                throw new IllegalStateException("responseErrorListener is required");
            return new RxErrorHandler(this);
        }

    }

}
