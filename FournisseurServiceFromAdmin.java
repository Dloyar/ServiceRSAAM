package com.example.rayold.servicersaam;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FournisseurServiceFromAdmin extends AppCompatActivity {
    DatabaseHelper db;
    String serviceName;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseur_service_from_admin);
        final ListView listView = (ListView) findViewById(R.id.serviceFromAdminView);
        db = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = db.getService();
        if(data.getCount() == 0) {
            Toast.makeText(this, "There are no service available. Admin didn't add any yet", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                serviceName =(String) listView.getItemAtPosition(position);
               // user = db.findUser(getIntent().getStringExtra("EMAIL"));
                Intent j = new Intent (FournisseurServiceFromAdmin.this,addServiceProfile.class );
                //j.putExtra("EMAIL", user.getEmail());
                j.putExtra("SERVICE", serviceName);
                startActivity(j);
            }
        });
    }
}

