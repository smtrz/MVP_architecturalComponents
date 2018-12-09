package com.highbryds.shoppinglistforromania;

import android.app.Application;

import com.highbryds.shoppinglistforromania.Components.AppLevelComponent;
import com.highbryds.shoppinglistforromania.Components.DaggerAppLevelComponent;
import com.highbryds.shoppinglistforromania.Modules.ContextModule;
import com.highbryds.shoppinglistforromania.Modules.DbRepoModule;


public class App extends Application {
    public static App app;
    public AppLevelComponent appComponent;


    public static App getApp() {
        return app;
    }


    public AppLevelComponent getAppLevelComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
// we only have to set constructor modules or context modules.
        appComponent = DaggerAppLevelComponent.builder()
                .contextModule(new ContextModule(this))
               .dbRepoModule(new DbRepoModule())

                .build();


    }


}
