package com.example.rayold.servicersaam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedIn extends AppCompatActivity {
    Button logout;
    String email,a,b;
    TextView name, role, textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        email = getIntent().getStringExtra("EMAIL");
        a = getIntent().getStringExtra("NAME");
        b = getIntent().getStringExtra("ROLE");
        textView = (TextView)findViewById(R.id.Email);
        name = (TextView)findViewById(R.id.Name);
        role = (TextView)findViewById(R.id.Role);
        textView.setText(email);
        name.setText(a);
        role.setText(b);


        logout = (Button)findViewById(R.id.bLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoggedIn.this, Login.class);
                startActivity(i);
            }
        });
    }
}
