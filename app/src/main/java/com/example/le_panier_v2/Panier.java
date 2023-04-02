package com.example.le_panier_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Panier extends AppCompatActivity {
    private ListView list_panier;
    private ArrayAdapter<Produit> array_list_panier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        this.list_panier=(ListView) findViewById(R.id.listpanier);

    }
}