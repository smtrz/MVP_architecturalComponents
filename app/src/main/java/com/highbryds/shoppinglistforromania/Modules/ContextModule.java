package com.highbryds.shoppinglistforromania.Modules;

import android.content.Context;


import com.highbryds.shoppinglistforromania.Scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context c;

    public ContextModule(Context c) {
        this.c = c;
    }

    @ActivityScope
    @Provides
    public Context provideContext() {

        return c;
    }
}
