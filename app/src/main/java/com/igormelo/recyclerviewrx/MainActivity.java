package com.igormelo.recyclerviewrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerListView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerListView=(RecyclerView) findViewById(R.id.recylerview_list);
        recyclerListView.setHasFixedSize(true);
        recyclerListView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this);
        recyclerListView.setAdapter(myAdapter);
        observable();
    }
    public List<String> getNameList(){
        List<String> list = new ArrayList<>();
        list.add("lord");
        list.add("dani");
        list.add("john");
        list.add("igor");
        list.add("pisk");
        list.add("jonathan");
        return list;
    }
    private void observable(){
        final Observable <List<String>> listObservable = Observable.just(getNameList());
        listObservable.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(List<String> strings) {
                myAdapter.setData(strings);
            }
        });
    }
}
