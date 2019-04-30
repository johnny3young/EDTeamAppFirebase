package com.edteam.app.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Plataforma extends AppCompatActivity {
    RecyclerView recyclerview;
    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plataforma);

        //Creamos un MÉTODO para llamar a la lista. Como no existe lo creamos mas abajo, acá solamente lo llamamos
        createData();

        recyclerview = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
    }

    public void createData () {
        notesList = new ArrayList<>();
        notesList.add(new Notes("001", "Calabazas", 6));
        notesList.add(new Notes("002", "Calabazas", 9));
        notesList.add(new Notes("003", "Calabazas", 3));
        notesList.add(new Notes("004", "Calabazas", 4));
        notesList.add(new Notes("005", "Calabazas", 1));
        notesList.add(new Notes("006", "Calabazas", 2));
        notesList.add(new Notes("007", "Calabazas", 5));
        notesList.add(new Notes("008", "Calabazas", 2));
        notesList.add(new Notes("009", "Calabazas", 7));
        notesList.add(new Notes("010", "Calabazas", 10));
        notesList.add(new Notes("011", "Calabazas", 20));

    }
}
