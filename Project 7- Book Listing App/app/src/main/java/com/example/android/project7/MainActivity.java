package com.example.android.project7;


import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import static com.example.android.project7.QueryUtils.flag;


public class MainActivity extends AppCompatActivity {

    private BookAdapter mAdapter;
    EditText editText;
    Button button;
    ArrayList<Book> books;
    String url = "https://www.googleapis.com/books/v1/volumes?q=";
    BookAsyncTask  bookAsynctask;
    Boolean connectionFlag = false;


    public void getTheurl() {
        editText = (EditText) findViewById(R.id.text_input);
        String key = editText.getText().toString().replaceAll("\\s","");
        url = url + key;
        Log.e(QueryUtils.class.getSimpleName(),url );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context k = this;
        button = (Button) findViewById(R.id.enter_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag) {
                    books = new ArrayList<Book>();
                    getTheurl();
                    bookAsynctask = new BookAsyncTask();
                    bookAsynctask.execute(url);
                    final ListView BooksList = (ListView) findViewById(R.id.list);
                    mAdapter = new BookAdapter(k, books);
                    BooksList.setAdapter(mAdapter);
                }

            }
        });
    }

     class BookAsyncTask extends AsyncTask<String,Void,List<Book>>   {

        @Override
        protected List<Book> doInBackground(String... strings) {
            List<Book> result = QueryUtils.fetchBookData(url);
            return result;
        }

        @Override
        protected void onPostExecute(List<Book> data) {
            if (flag) {
                Toast NoConnectionToast = Toast.makeText(getApplicationContext(), "No connection, please try again", Toast.LENGTH_SHORT);
                NoConnectionToast.show();
                TextView noDatatxt = (TextView) findViewById(R.id.noData);
                noDatatxt.setText("No connection, please try again");
                RelativeLayout noDataParent = (RelativeLayout) findViewById(R.id.noDataParent);
                noDataParent.setVisibility(View.VISIBLE);
                url = "https://www.googleapis.com/books/v1/volumes?q=";
                flag = false;
                connectionFlag = true;
            }

            if(!connectionFlag ) {
                TextView noDatatxt2 = (TextView) findViewById(R.id.noData);
                noDatatxt2.setText("No Books was found by the entered word");
                RelativeLayout noDataParent2 = (RelativeLayout) findViewById(R.id.noDataParent);
                noDataParent2.setVisibility(View.VISIBLE);
                url = "https://www.googleapis.com/books/v1/volumes?q=";
            }
                mAdapter.clear();
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
            url="https://www.googleapis.com/books/v1/volumes?q=";
            connectionFlag = false;
        }
    }
}
