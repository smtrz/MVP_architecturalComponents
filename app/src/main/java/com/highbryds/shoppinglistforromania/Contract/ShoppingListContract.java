package com.highbryds.shoppinglistforromania.Contract;

import android.support.v7.widget.RecyclerView;

import com.highbryds.shoppinglistforromania.Room.ShoppingItem;

import java.util.List;

public interface ShoppingListContract {

    interface view {
        void showError(String error);
    }

    interface presenter {

        void submitDataToModel(String productName, String categoryName);
     //  void sendError( String error);
    }

    interface model {

        void insertData(String productName, String Category);
    }
}
