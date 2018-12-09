package com.highbryds.shoppinglistforromania.Components;

import android.content.Context;

import com.highbryds.shoppinglistforromania.MainActivity;
import com.highbryds.shoppinglistforromania.Modules.ContextModule;
import com.highbryds.shoppinglistforromania.Modules.DbRepoModule;
import com.highbryds.shoppinglistforromania.Modules.ShoppingPresenterModule;
import com.highbryds.shoppinglistforromania.Room.DbRepository;
import com.highbryds.shoppinglistforromania.Scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {ShoppingPresenterModule.class,ContextModule.class, DbRepoModule.class})
public interface ShoppingComponent {

void inject(MainActivity ma);
Context getContext();
DbRepository getrepo();
}


