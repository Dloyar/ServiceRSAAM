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
    Button btnAdd, btndel, btnListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_profile);

        serviceName = getIntent().getStringExtra("SERVICE");

        serviceNameView = findViewById((R.id.ServiceName));

        serviceNameView.setText(serviceName);

        btnAdd = findViewById(R.id.buttonAddService);
        btndel = findViewById(R.id.buttonDeleteService);
        btnListView = findViewById(R.id.buttonServiceList);

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addServiceProfile.this, ServiceList.class);
                startActivity(i);
            }
        });



    }
}
