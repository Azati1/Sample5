package com.azati.sample50;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azati on 19.03.2018.
 */



public class Main extends AppCompatActivity{

    private RecyclerView recyclerView;
    private LinearLayoutManager verticalLinearLayoutManager;
    private LinearLayoutManager horizontalLinearLayoutManager;
    private RecyclerAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigationView;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        verticalLinearLayoutManager = new LinearLayoutManager(this);

        horizontalLinearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(verticalLinearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addAll(ModelItem.getFakeItems());

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_logout:
                        Intent intent = new Intent(Main.this, Welcome.class);
                        startActivity(intent);
                }

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
        private ArrayList<ModelItem> items = new ArrayList<>();

        public void addAll(List<ModelItem> fakeItems) {
            int pos = getItemCount();
            this.items.addAll(fakeItems);
            notifyItemRangeInserted(pos, this.items.size());
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.bind(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private TextView price;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            price = (TextView) itemView.findViewById(R.id.price);
        }


        public void bind(ModelItem modelItem) {
            image.setImageBitmap(BitmapFactory.decodeResource(itemView.getResources(), modelItem.getImgId()));
            title.setText(modelItem.getAuthor());
            price.setText(modelItem.getPriceInRub());
        }
    }

    public void exitFromAccount(View view) {
        Intent intent = new Intent(Main.this, Welcome.class);
        startActivity(intent);
    }

    public void showAccountData() {}

    public void showShoppingCart() {}

    public void showSettings() {}

}
