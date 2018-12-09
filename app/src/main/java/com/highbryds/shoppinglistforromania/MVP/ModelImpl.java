package com.highbryds.shoppinglistforromania.MVP;

import android.support.v7.widget.RecyclerView;

import com.highbryds.shoppinglistforromania.Contract.ShoppingListContract;
import com.highbryds.shoppinglistforromania.Room.DbRepository;
import com.highbryds.shoppinglistforromania.Room.ShoppingItem;

public class ModelImpl implements ShoppingListContract.model {

    DbRepository dr;
    public ModelImpl(DbRepository dr){
        this.dr = dr;

    }
    @Override
    public void insertData(String productName, String Category) {

        ShoppingItem si = new ShoppingItem();
        si.setCategoryName(Category);
        si.setProductName(productName);
        dr.insertItems(si);

    }
}
