package com.highbryds.shoppinglistforromania.MVP;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.highbryds.shoppinglistforromania.Contract.ShoppingListContract;
import com.highbryds.shoppinglistforromania.Room.ShoppingItem;

import java.util.List;

public class PresenterImpl implements ShoppingListContract.presenter {
    ShoppingListContract.model model;
    ShoppingListContract.view view;


    public PresenterImpl(ShoppingListContract.model model,
                         ShoppingListContract.view view) {

        this.model = model;
        this.view = view;
    }

    @Override
    public void submitDataToModel(String productName, String categoryName) {
        if(!TextUtils.isEmpty(productName) && !TextUtils.isEmpty(categoryName) && productName.length()>2) {

            model.insertData(productName, categoryName);
        }
        else{

            view.showError("type some valid values");
        }
    }

  /*  @Override
    public void sendError(String error) {
        view.showError(error);
    }*/
}
