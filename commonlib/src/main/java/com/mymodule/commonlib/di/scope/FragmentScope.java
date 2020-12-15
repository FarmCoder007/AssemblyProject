package com.mymodule.commonlib.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * author : xu
 * date : 2020/12/14 16:46
 * description :
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {}