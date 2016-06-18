package com.autotextview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.autotextview2.DbHelper.ProductDBHelper;

import java.util.ArrayList;

public class AutoTextView extends AppCompatActivity {

    private ArrayList<String> mArray;
    private AutoCompleteTextView mAutoCompleteTextView;
    private ProductDBHelper mProductDBHelper;
    private ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_text_view);

        mProductDBHelper = new ProductDBHelper(getApplicationContext());

        mProductDBHelper.insertData("H P Laserjet Printer ");
        mProductDBHelper.insertData("H P Inkjet Printer ");
        mProductDBHelper.insertData("Canon Laserjet Printer ");
        mProductDBHelper.insertData("Canon Inkjet Printer ");
        mProductDBHelper.insertData("H P All in one Printer ");
        mProductDBHelper.insertData("Canon All in one Printer ");

        mArray = new ArrayList<>();

        mArray = mProductDBHelper.getData();

        mArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mArray);

        mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.auto_product_name);

        mAutoCompleteTextView.setAdapter(mArrayAdapter);

        mAutoCompleteTextView.setThreshold(1);

    }
}
