package com.example.homework411;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrollingActivity extends AppCompatActivity {
    private ListView list;
    public static final String KEY_NAME = "name";
    public static final String KEY_COUNT = "count";
    private String[] array_from = {KEY_NAME, KEY_COUNT};
    private int[] array_to = {R.id.text_desc, R.id.count};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //работа со списком
        list = findViewById(R.id.list);
        List<Map<String, String>> result = prepareContent();
        SimpleAdapter listContentAdapter = createAdapter(result);
        list.setAdapter(listContentAdapter);

    }
    //создаем адаптер
    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> result) {
        return new SimpleAdapter(this, result, R.layout.list_item, array_from, array_to);
    }

    //работа с исходным файлом текста, заполняем справочник
    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> resultList = new ArrayList<>();
        String[] result = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < result.length; i++) {
            Map<String, String> RowMap = new HashMap<>();
            RowMap.put(KEY_NAME, result[i]);
            RowMap.put(KEY_COUNT, Integer.toString(result[i].length()));
            resultList.add(RowMap);
        }
        return resultList;
    }
}
