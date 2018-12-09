package com.highbryds.shoppinglistforromania.Modules;

import com.highbryds.shoppinglistforromania.Contract.ShoppingListContract;
import com.highbryds.shoppinglistforromania.MVP.ModelImpl;
import com.highbryds.shoppinglistforromania.MVP.PresenterImpl;
import com.highbryds.shoppinglistforromania.Room.DbRepository;
import com.highbryds.shoppinglistforromania.Scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;


@Module(includes = {ContextModule.class,DbRepoModule.class})
public class ShoppingPresenterModule {
    ShoppingListContract.view v;

    public ShoppingPresenterModule(ShoppingListContract.view v) {
        this.v = v;
    }

    @ActivityScope
    @Provides
    public ShoppingListContract.view provideHomePresenterView() {

        return v;
    }

    @ActivityScope
    @Provides
    public ModelImpl providePrayerDataManager(DbRepository dr) {

        return new ModelImpl(dr);
    }

    @ActivityScope
    @Provides
    public PresenterImpl provideHomePresenter(ModelImpl pdm, ShoppingListContract.view v) {


        return new PresenterImpl(pdm,v);
    }



   /* @ActivityScope
    @Provides
    public PrayTime providePrayTime() {

        return new PrayTime();
    }*/

}
