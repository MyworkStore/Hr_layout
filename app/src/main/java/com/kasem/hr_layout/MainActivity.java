package com.kasem.hr_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.kasem.hr_layout.HR_Services.HRDAO.HRDAO;
import com.kasem.hr_layout.HR_Services.HR_Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    private HR_Services service;
    private TextView heading_data;
    private TextView child_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ExpandableListView
        /*
        expandableListView = (ExpandableListView) findViewById(R.id.exp_listview);
        List<String> Headings = new ArrayList<String>();
        List<String> L1 = new ArrayList<String>();
        List<String> L2 = new ArrayList<String>();
        HashMap<String, List<String>> ChildList = new HashMap<String, List<String>>();
        String heading_items[] = getResources().getStringArray(R.array.header_titles);
        String l1[] = getResources().getStringArray(R.array.h1_items);
        String l2[] = getResources().getStringArray(R.array.h2_items);
        for (String title : heading_items) {
            Headings.add(title);
        }
        for (String title : l1) {
            L1.add(title);
        }
        for (String title : l2) {
            L2.add(title);
        }
        ChildList.put(Headings.get(0), L1);
        ChildList.put(Headings.get(1), L2);
        MyAdapter myAdapter = new MyAdapter(this, Headings, ChildList);
        expandableListView.setAdapter(myAdapter);
        */
        // ExpandableListView

        List<String> Headings = new ArrayList<String>();
        List<String> L1 = new ArrayList<String>();
        HashMap<String, List<String>> ChildList = new HashMap<String, List<String>>();

        //service start
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/PCK")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(HR_Services.class);
        service.getData().enqueue(new Callback<HRDAO>() {

            @Override
            public void onResponse(Call<HRDAO> call, Response<HRDAO> response) {
                Log.d("response", "sssss");
                if (response.isSuccessful()) {
                    Log.d("response", "success");

                    for (int i = 0; i < response.body().skill.size(); i++) {
                        Headings.add(response.body().skill.get(i).skill_title);
                        L1.add(response.body().skill.get(i).skill_title);

                        ChildList.put(Headings.get(i), L1);
//                        Log.d("response", response.body().details.get(i).pf_name);

                    }
                    MyAdapter myAdapter = new MyAdapter(this, Headings, ChildList);
                    expandableListView.setAdapter(myAdapter);
                } else {
                    Log.d("response", "error");
                }// if else
            }

            @Override
            public void onFailure(Call<HRDAO> call, Throwable t) {
                Log.d("Response", t.getMessage());
            }
        });
        //service end


    }
}
