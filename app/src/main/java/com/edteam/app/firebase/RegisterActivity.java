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
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password;
    Button register;

    //Declare an instance of FirebaseAuth
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailUser = email.getText().toString();
                String passwordUser = password.getText().toString();

                //Usamos un IF para revisar que los campos no estén vacíos
                if (TextUtils.isEmpty(emailUser)) {
                    Toast.makeText(RegisterActivity.this, "Digita un correo", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(passwordUser)) {
                    Toast.makeText(RegisterActivity.this, "Coloca una contraseña", Toast.LENGTH_SHORT).show();
                }

                //SignUp new Users
                mAuth.createUserWithEmailAndPassword(emailUser, passwordUser)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this, "Se ha creado el usuario", Toast.LENGTH_SHORT).show();
                                    Intent myIntent = new Intent(RegisterActivity.this,Plataforma.class);
                                    startActivity(myIntent);
                                    finish();

                                }else {
                                    Toast.makeText(RegisterActivity.this, "No se pudo crear el usuario", Toast.LENGTH_SHORT).show();
                                }


                            }
                        });

            }
        });

        //When initializing your Activity, check to see if the user is currently signed in.

    }
}
