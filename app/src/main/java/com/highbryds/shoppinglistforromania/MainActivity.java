package com.highbryds.shoppinglistforromania;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.highbryds.shoppinglistforromania.Adapters.ShoppingListAdapter;
import com.highbryds.shoppinglistforromania.Components.DaggerShoppingComponent;
import com.highbryds.shoppinglistforromania.Components.ShoppingComponent;
import com.highbryds.shoppinglistforromania.Contract.ShoppingListContract;
import com.highbryds.shoppinglistforromania.MVP.ModelImpl;
import com.highbryds.shoppinglistforromania.MVP.PresenterImpl;
import com.highbryds.shoppinglistforromania.Modules.ContextModule;
import com.highbryds.shoppinglistforromania.Modules.DbRepoModule;
import com.highbryds.shoppinglistforromania.Modules.ShoppingPresenterModule;
import com.highbryds.shoppinglistforromania.Room.DbRepository;
import com.highbryds.shoppinglistforromania.Room.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ShoppingListContract.view {

    @BindView(R.id.itemname)
    EditText itemname;

    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.shoppinglist)
    RecyclerView shoppinglist;
    @Inject
    PresenterImpl presenter;
    ShoppingListAdapter adapter;
    List<ShoppingItem> list;
    @Inject
    DbRepository repo;
    @BindView(R.id.cat)
    AutoCompleteTextView cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Clothings");
        categories.add("Shoes");
        categories.add("Utilities");



        ButterKnife.bind(this);
        populateEditText(categories);
       // repo = App.getApp().getTestComponent().getrepo();



       ShoppingComponent component = DaggerShoppingComponent.builder()
                .shoppingPresenterModule(new ShoppingPresenterModule(this))
               .contextModule(new ContextModule(this))
               .dbRepoModule(new DbRepoModule())
                .build();
        component.inject(this);

       // presenter = new PresenterImpl(new ModelImpl(repo), this);


        shoppinglist.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShoppingListAdapter(this, list);
        shoppinglist.setAdapter(adapter);


        final Observer<List<ShoppingItem>> ShoppingItemobserver = new Observer<List<ShoppingItem>>() {
            @Override
            public void onChanged(@Nullable List<ShoppingItem> ShoppingItem) {
                adapter.loadItems(ShoppingItem);
                adapter.notifyDataSetChanged();
            }
        };
        repo.getAllShoppingItems().observe(this, ShoppingItemobserver);

    }



    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    public void populateEditText(ArrayList<String> categories) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, categories);
        //Getting the instance of AutoCompleteTextView

        cat.setThreshold(1);//will start working from first character
        cat.setAdapter(adapter);//setting the adapter data

    }

    @OnClick({R.id.cat, R.id.submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cat:
                break;
            case R.id.submit:
                presenter.submitDataToModel(itemname.getText().toString(), cat.getText().toString());

                break;
        }
    }
}
