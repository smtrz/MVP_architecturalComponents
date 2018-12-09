package com.highbryds.shoppinglistforromania.Components;

import android.content.Context;

import com.highbryds.shoppinglistforromania.Modules.ContextModule;
import com.highbryds.shoppinglistforromania.Modules.DbRepoModule;
import com.highbryds.shoppinglistforromania.Modules.ShoppingPresenterModule;
import com.highbryds.shoppinglistforromania.Room.DbRepository;
import com.highbryds.shoppinglistforromania.Scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {ContextModule.class, DbRepoModule.class})
public interface AppLevelComponent {

    Context getContet();
    DbRepository getrepo();
}
