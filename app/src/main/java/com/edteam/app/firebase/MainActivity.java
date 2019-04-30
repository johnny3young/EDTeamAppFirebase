package com.edteam.app.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login, register;

    //Declare an instance of FirebaseAuth
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = email.getText().toString();
                String passwordUser = password.getText().toString();

                if (TextUtils.isEmpty(emailUser)) {
                    Toast.makeText(MainActivity.this, "Digita un correo", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(passwordUser)) {
                    Toast.makeText(MainActivity.this, "Coloca una contraseña", Toast.LENGTH_SHORT).show();
                }

                mAuth.signInWithEmailAndPassword(emailUser, passwordUser).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Ingresando....", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(MainActivity.this,Plataforma.class);
                            startActivity(myIntent);
                            finish();

                        }else {
                            Toast.makeText(MainActivity.this, "Correo o Password incorrectos", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(myIntent);
            }
        });

        //When initializing your Activity, check to see if the user is currently signed in.

    }
}
