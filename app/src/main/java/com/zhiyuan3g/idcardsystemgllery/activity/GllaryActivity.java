package com.zhiyuan3g.idcardsystemgllery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;

import com.zhiyuan3g.idcardsystemgllery.R;
import com.zhiyuan3g.idcardsystemgllery.adapter.GallaryAdapter;

import java.util.ArrayList;
import java.util.List;

public class GllaryActivity extends AppCompatActivity {
    Gallery gallery;

    private int RESULT_CODE = 2;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gllary);

        gallery = (Gallery) findViewById(R.id.gallery);

        final List<Integer> list = getPic();
        GallaryAdapter adapter = new GallaryAdapter(list, this);
        gallery.setAdapter(adapter);

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GllaryActivity.this, MainActivity.class);
                a = list.get(position);
                intent.putExtra("imageView",a);
                setResult(RESULT_CODE,intent);
                finish();

            }
        });

    }

    private List<Integer> getPic() {
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.dg);
        list.add(R.drawable.ls);
        list.add(R.drawable.ly);
        return list;
    }

}
