package com.example.rayold.servicersaam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class addServiceProfile extends AppCompatActivity {
    String serviceName;
    TextView serviceNameView;
    Button btnAdd, btnFSList,btnSLView;
    DatabaseHelper db;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_profile);
        db = new DatabaseHelper(this);
        serviceName = getIntent().getStringExtra("SERVICE");

        serviceNameView = findViewById((R.id.ServiceName));

        serviceNameView.setText(serviceName);

        btnAdd = findViewById(R.id.btnAdd);
        btnSLView = findViewById(R.id.btnServiceList);
        btnFSList = findViewById(R.id.btnFournisseurService);

        btnSLView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addServiceProfile.this, FournisseurServiceFromAdmin.class);
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Boolean insert = db.insertServiceFournisseur("",serviceName);
                if (insert == true) {
                    Toast.makeText(getApplicationContext(), "Service Adding Successful", Toast.LENGTH_SHORT).show();
                } else {
                Toast.makeText(getApplicationContext(), "Service Adding Failed", Toast.LENGTH_SHORT).show();
            }
        }
    });





    }
}
