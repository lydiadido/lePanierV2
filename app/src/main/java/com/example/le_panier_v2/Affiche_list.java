package com.example.le_panier_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Affiche_list extends AppCompatActivity {
private ListView list;
private Button btnVC;
private TextView titre;

String titre_cat;
private ArrayList<Produit> listProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_list);

        this.list = (ListView) findViewById(R.id.list);
        this.btnVC = (Button) findViewById(R.id.btnviewCard);
        titre_cat = (String) getIntent().getSerializableExtra("categorie");
        titre=(TextView) findViewById(R.id.nom_cat);
        titre.setText(titre_cat);

        listProduct=new ArrayList<Produit>();
        MyDbAdapter myDbAdapter = new MyDbAdapter(getApplicationContext());
        myDbAdapter.Open();
        myDbAdapter.InsertNewCat();
        myDbAdapter.InsertNewProduit();
        listProduct=new ArrayList<Produit>();
        listProduct=myDbAdapter.ProdByCategory(titre_cat);
        //listProduct=myDbAdapter.AllProducts();
        ProduitArrayAdapter adapter = new ProduitArrayAdapter(this,R.layout.produit_layout,listProduct);
        this.list.setAdapter(adapter);
        myDbAdapter.DeleteAllProduit();


        //***********intent vers le panier*******************//
        this.btnVC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCard();
            }
        });

    }
    private void viewCard(){

        Intent intent = new Intent(this, Panier.class);
//      intent.putExtra("categorie", item.getTitle());
        startActivity(intent);

    }
}


//        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(Affiche_list.this,((TextView)view).getText().toString(),Toast.LENGTH_LONG).show();
//            }
//        });
//        this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//                listProduct.remove(position);
//                adapter.notifyDataSetChanged();
//                return false;
//            }
//        });
