package com.highbryds.shoppinglistforromania.Room;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class DbRepository {
    ShoppingItemsDao ShoppingItemsdao;
    LiveData<List<ShoppingItem>> ListShoppingItems;

    public DbRepository(Context application) {
        AppDB db = DbObject.getInstance(application);
        ShoppingItemsdao = db.shoppingDAO();
        ListShoppingItems = ShoppingItemsdao.getallItems();

    }


    public LiveData<List<ShoppingItem>> getAllShoppingItems() {
        return ListShoppingItems;

    }


    public void setListOfReceicve() {
        ListShoppingItems = ShoppingItemsdao.getallItems();


    }

    public void insertItems(ShoppingItem sms) {
        new insertAsyncTask(ShoppingItemsdao).execute(sms);
    }

    private static class insertAsyncTask extends AsyncTask<ShoppingItem, Void, Void> {

        private ShoppingItemsDao mAsyncTaskDao;

        insertAsyncTask(ShoppingItemsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ShoppingItem... params) {
            mAsyncTaskDao.insertItem(params[0]);
            return null;
        }
    }
}
