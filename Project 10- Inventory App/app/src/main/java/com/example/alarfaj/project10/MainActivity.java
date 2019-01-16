package com.example.alarfaj.project10;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ProductDBHelper dbHelper;
    ProductAdapter adapter;
    RelativeLayout noData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new ProductDBHelper(this);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        Cursor cursor = dbHelper.readDB();
        noData = (RelativeLayout) findViewById(R.id.no_data);
        listView.setEmptyView(noData);
        adapter = new ProductAdapter(this, cursor);
        listView.setAdapter(adapter);
        Log.v(".MainActivity", "Test" + String.valueOf(cursor.getCount()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(dbHelper.readDB());
    }

    public void clickOnViewItem(long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("itemId", id);
        startActivity(intent);
    }

    public void clickOnSale(long id, int quantity) {
        dbHelper.sell(id, quantity);
        adapter.swapCursor(dbHelper.readDB());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this , DetailsActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
