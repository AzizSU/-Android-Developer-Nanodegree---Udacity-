package com.example.alarfaj.project10;



import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class DetailsActivity extends AppCompatActivity {

    EditText nameEdit;
    EditText priceEdit;
    EditText quantityEdit;
    EditText supplierEmailEdit;
    long currentItemId;
    Button decreaseQuantity;
    Button deletbtn;
    Uri imgUri;
    Button savebtn;
    Button order;
    Button uploadImg ;
    ImageView imageView;
    Button increaseQuantity;
    private ProductDBHelper mDbHelper;
    private static final int SELECT_PICTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_layout);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        imageView = (ImageView) findViewById(R.id.image_view);
        nameEdit = (EditText) findViewById(R.id.product_name);
        priceEdit = (EditText) findViewById(R.id.price_product);
        quantityEdit = (EditText) findViewById(R.id.quant_product);
        supplierEmailEdit = (EditText) findViewById(R.id.suplier_name);
        decreaseQuantity = (Button) findViewById(R.id.decrease_product);
        increaseQuantity = (Button) findViewById(R.id.increas_product);
        mDbHelper = new ProductDBHelper(this);
        currentItemId = getIntent().getLongExtra("itemId", 0);
        if (currentItemId != 0) {
            retriveProduct(currentItemId);
        }
        savebtn = (Button) findViewById(R.id.add);
        savebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addItemToDb();
            }
        });

        deletbtn = (Button) findViewById(R.id.delete);
        deletbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showDialogM(currentItemId);
            }
        });

        order = (Button) findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String body = "Hello\n" + "We would like to place a new order of " + nameEdit.getText().toString()+ " as soon as possible.\n" + "Best regards";
                String subject = "New order of " + nameEdit.getText().toString();
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{ supplierEmailEdit.getText().toString() });
                i.putExtra(Intent.EXTRA_SUBJECT, subject);
                i.putExtra(Intent.EXTRA_TEXT, body );
                startActivity(i);
            }
        });

        decreaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtOnefromQuant();
            }
        });

        increaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOneToQuant();
            }
        });

        uploadImg = (Button) findViewById(R.id.select_image);
        uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);

            }
        });
    }

    private void subtOnefromQuant() {
        int currentQuant;
        if(TextUtils.isEmpty(quantityEdit.getText().toString()))
            return;
        else {
            currentQuant = Integer.parseInt(quantityEdit.getText().toString());
            if (currentQuant == 0) {
                return;
            }
            else {
                quantityEdit.setText(String.valueOf(currentQuant-1));
            }
        }
    }

    private void addOneToQuant() {
        int currentQuant;
        if(TextUtils.isEmpty(quantityEdit.getText().toString()))
            quantityEdit.setText(String.valueOf(1));
        else {
            currentQuant = Integer.parseInt(quantityEdit.getText().toString());
            quantityEdit.setText(String.valueOf(currentQuant+1));
        }
    }

    private boolean addItemToDb() {
        boolean noErrors = false;
        boolean flag = true;
        if (TextUtils.isEmpty(nameEdit.getText())) {
            flag = false;
            Toast.makeText(getApplicationContext(),
                    "Please enter the name of the product : ) ", Toast.LENGTH_LONG).show();
            nameEdit.setError("invalid value");
        }
        if (TextUtils.isEmpty(priceEdit.getText())) {
            flag = false;
            Toast.makeText(getApplicationContext(),
                    "Please enter the price of the product : ) ", Toast.LENGTH_LONG).show();
            priceEdit.setError("invalid value");
        }
        if (TextUtils.isEmpty(quantityEdit.getText())) {
            flag = false;
            Toast.makeText(getApplicationContext(),
                    "Please enter the quantity of the product : ) ", Toast.LENGTH_LONG).show();
            quantityEdit.setError("invalid value");
        }
        if (TextUtils.isEmpty(supplierEmailEdit.getText())) {
            flag = false;
            Toast.makeText(getApplicationContext(),
                    "Please enter the supplier's Email ", Toast.LENGTH_LONG).show();
            supplierEmailEdit.setError("invalid value");
        }

        if (imgUri == null && currentItemId == 0) {
            flag = false;
            Toast.makeText(getApplicationContext(),
                    "Please choose an image ", Toast.LENGTH_LONG).show();
        }

        if (!flag) {
            return false;
        }

        int price=0;
        int quantity = 0;

        try {
            price = Integer.parseInt(priceEdit.getText().toString());
            noErrors=true;
        }
        catch (Exception e ) {
            noErrors=false;
            priceEdit.setError("invalid value");
            Toast.makeText(getApplicationContext(),
                    "Please enter only numbers for the price of the product", Toast.LENGTH_LONG).show();
        }
        try {
            quantity = Integer.parseInt(quantityEdit.getText().toString());
            if(noErrors)
                noErrors=true;
        }
        catch (Exception e ) {
            noErrors=false;
            quantityEdit.setError("invalid value");
            Toast.makeText(getApplicationContext(),
                    "Please enter only numbers for the quantity of the product", Toast.LENGTH_LONG).show();
        }

        if (currentItemId == 0) {
            if(noErrors) {
                Product item = new Product(
                        nameEdit.getText().toString(),
                        price,
                        quantity,
                        supplierEmailEdit.getText().toString(),
                        imgUri.toString());
                mDbHelper.insertItem(item);
                this.onBackPressed();
            }

        } else {
            if(noErrors) {
                mDbHelper.updateItem(currentItemId, quantity);
                this.onBackPressed();
            }
        }
        return true;
    }

    private void retriveProduct(long current) {
        Cursor cursor = mDbHelper.readProduct(current);
        cursor.moveToFirst();
        nameEdit.setText(cursor.getString(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_NAME)));
        priceEdit.setText(cursor.getString(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_PRICE)));
        quantityEdit.setText(cursor.getString(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_QUANTITY)));
        supplierEmailEdit.setText(cursor.getString(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_SUPPLIER)));
        imageView.setImageURI(Uri.parse(cursor.getString(cursor.getColumnIndex(ProductConract.ProductEntry.COLUMN_IMAGE))));
    }

    private void delete(long current) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String currentString = ""+ current;
        String selection = ProductConract.ProductEntry._ID + "=?";
        String[] selectionArgs = {currentString};
        db.delete(ProductConract.ProductEntry.TABLE_NAME, selection, selectionArgs);
    }

    public void showDialogM(long current) throws Resources.NotFoundException {
         final long currentt = current;
        new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Are you sure you want to delete this product?")
                .setIcon(getResources().getDrawable(android.R.drawable.ic_dialog_alert))
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                delete(currentt);
                                finish();
                            }
                        })
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                            }
                        }).show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK && resultData != null) {
                imgUri = resultData.getData();
                imageView.setImageURI(imgUri);
                imageView.invalidate();
        }
    }
}
