package com.example.myapplication2.app;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    public String [] arr;
    private ListView lv;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr =  new String[5];
        arr[0]="kidaa";
        arr[1]="malkit";
        arr[2]="malkit2";
        arr[3]="malkit3";
        arr[4]="malkit4";

        lv = (ListView)findViewById(R.id.listView);


        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(arrayAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                a.setTitle(arr[i]);
                arr[i]="pressed";
                arrayAdapter.notifyDataSetChanged();
                a.setPositiveButton("OK",null);
                a.show();

                SharedPreferences sharedPreferences = getSharedPreferences("Defaults",MODE_PRIVATE);
                sharedPreferences.edit().putString("hello",arr[i]).commit();




            }
        });

    }


    public void aglaPage(View v) {
//        Intent i = new Intent(MainActivity.this,MainActivity2Activity.class);
//        i.putExtra("First","1");
//        startActivity(i);

        MySQLiteHelper s1 = new MySQLiteHelper(MainActivity.this);
//        SharedPreferences sharedPreferences = getSharedPreferences("Defaults",MODE_PRIVATE);
//        AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
//        a.setTitle(sharedPreferences.getString("hello","nothing123"));
//        a.setPositiveButton("OK",null);
//        a.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
