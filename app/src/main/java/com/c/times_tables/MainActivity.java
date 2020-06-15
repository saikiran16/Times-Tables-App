package com.c.times_tables;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView myListView ;
    ArrayAdapter arrayAdapter ;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         myListView = findViewById(R.id.mylistview);

        SeekBar seekbar = (SeekBar)findViewById(R.id.seekBar);
        generateTable(1);
        seekbar.setMax(20);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int number, boolean b) {
                generateTable(number);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public  void generateTable( int number)
    {
        ArrayList<String > arraylist  = new ArrayList<String>();
        //Toast.makeText(MainActivity.this , Integer.toString(number) , Toast.LENGTH_LONG).show();
        for(int i = 1 ; i <= 20 ; i++) {
            arraylist.add(number + "   \t\t  *    \t\t " + i + "   \t\t  =    \t\t " + number * i );
        }
         arrayAdapter  = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , arraylist){
             @Override
             public View getView(int position, View convertView, ViewGroup parent){
                 /// Get the Item from ListView
                 View view = super.getView(position, convertView, parent);

                 TextView tv = (TextView) view.findViewById(android.R.id.text1);

                 // Set the text size 25 dip for ListView each item
                 tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);

                 // Return the view
                 return view;
             }

         } ;
        myListView.setAdapter(arrayAdapter);
    }

}
