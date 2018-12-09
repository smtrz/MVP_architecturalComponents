package com.highbryds.shoppinglistforromania.Modules;

import android.content.Context;

import com.highbryds.shoppinglistforromania.Room.DbRepository;
import com.highbryds.shoppinglistforromania.Scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;
@Module(includes = ContextModule.class)

public class DbRepoModule {



    @ActivityScope
    @Provides
    public DbRepository getRepository(Context c) {

        return new DbRepository(c);

    }
}
