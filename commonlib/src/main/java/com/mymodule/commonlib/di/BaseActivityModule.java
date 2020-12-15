package com.mymodule.commonlib.di;

import com.mymodule.commonlib.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * author : xu
 * date : 2020/12/14 16:39
 * description :
 */
@Module
public abstract class BaseActivityModule<E> {

    private E view;

    public BaseActivityModule(E view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    E providerModel() {
        return view;
    }

}
