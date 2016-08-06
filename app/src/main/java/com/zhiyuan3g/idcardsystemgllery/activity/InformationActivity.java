package com.zhiyuan3g.idcardsystemgllery.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.zhiyuan3g.idcardsystemgllery.R;
import com.zhiyuan3g.idcardsystemgllery.adapter.InformationAdapter;
import com.zhiyuan3g.idcardsystemgllery.entity.Information;
import com.zhiyuan3g.idcardsystemgllery.utils.Util;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    ListView listShow;
    InformationAdapter adapter;
    String[]data;
    Context context=InformationActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        listShow= (ListView) findViewById(R.id.listShow);
        List<Information>informations=getData();
        adapter=new InformationAdapter(informations,context);
        listShow.setAdapter(adapter);
        getData();

    }
    private List<Information> getData(){
        List<Information>informations=new ArrayList<>();
        String allData= Util.ReadData();

        allData=allData.substring(0,allData.length()-1);
        data=allData.split("/");

        for (int i=0;i<data.length;i++){
            String []stringsData=data[i].split(";");

            Information information=new Information(stringsData[0],stringsData[1],stringsData[2],
                    stringsData[3],stringsData[4],Integer.parseInt(stringsData[5]));

            informations.add(information);
        }

        return informations;
    }
}
