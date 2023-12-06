package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        if (daftar_nama.isEmpty()) {
            daftar_nama.add("data masih kosong");
        } else {
            // Add index numbers to each item in the list
            for (int i = 0; i < daftar_nama.size(); i++) {
                String item = daftar_nama.get(i);
                daftar_nama.set(i, "Angka Index " + (i + 1) + ": " + item);
            }
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);

        lvNama.setAdapter(ad_nama);
    }
}