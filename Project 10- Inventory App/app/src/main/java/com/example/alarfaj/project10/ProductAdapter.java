package com.example.alarfaj.project10;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CursorAdapter;


/**
 * Created by Alarfaj on 10/13/17.
 */

public class ProductAdapter extends  CursorAdapter {

    private final MainActivity activity;

    public ProductAdapter(MainActivity context, Cursor c) {
        super(context, c, 0);
        this.activity = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView img = (ImageView) view.findViewById(R.id.image_view);
        TextView nameTextView = (TextView) view.findViewById(R.id.nameOfProduct);
        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        TextView priceTextView = (TextView) view.findViewById(R.id.price);
        Button sale = (Button) view.findViewById(R.id.sale);
        String name = cursor.getString(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_NAME));
        final int quantity = cursor.getInt(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_QUANTITY));
        String price = cursor.getString(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_PRICE));
        String imge = cursor.getString(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_IMAGE));
        nameTextView.setText(name);
        img.setImageURI(Uri.parse(imge));
        quantityTextView.setText("Quantity: "+ String.valueOf(quantity));
        priceTextView.setText("Price: " + price);
        final long id = cursor.getLong(cursor.getColumnIndex(ProductConract.ProductEntry._ID));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.clickOnViewItem(id);
            }
        });

        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.clickOnSale(id,
                        quantity);
            }
        });
    }
}