package com.example.afreen.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static android.R.id.progress;

public class MainActivity extends AppCompatActivity {

    ListView listView;


    public void generateTimesTable(int timesTable)
    {

        ArrayList<String> timesTableContent= new ArrayList<String>();

        for(int i=2; i<=10; i++)
        {
            timesTableContent.add(Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar= (SeekBar) findViewById(R.id.seekBar);
        listView= (ListView) findViewById(R.id.listView);

        seekBar.setMax(20);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTable;
                if (i<min){
                    timesTable=min;
                    seekBar.setProgress(min);
                }else{
                    timesTable=i;
                }

                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);





    }
}
