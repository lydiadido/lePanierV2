package com.example.le_panier_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class ProduitArrayAdapter extends ArrayAdapter<Produit> {
    private Context context;
    private ArrayList<Produit> prodArray;
    private Integer ressource;
    public ProduitArrayAdapter( Context context, int resource, List<Produit> objects) {
        super(context, resource, objects);
        this.context=context;
        this.ressource=resource;
        prodArray=new ArrayList<Produit>();
        prodArray=(ArrayList<Produit>)objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produit ptemp = this.prodArray.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.ressource, parent,false);
        TextView nom =(TextView)convertView.findViewById(R.id.lblnom);
        TextView prix = (TextView)convertView.findViewById(R.id.lblprix);
        TextView desc = (TextView)convertView.findViewById(R.id.lbldesc);
        ImageView img = (ImageView)convertView.findViewById(R.id.img);
        //Button btnAddCard =null;z
        nom.setText(ptemp.getNom()+" : ");
        prix.setText(ptemp.getPrix()+"$");
        desc.setText("Description : \n"+ptemp.getDescription());
       // img.setImageResource(ptemp.getImage());
//        btnAddCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ptemp.setQuantite(ptemp.getQuantite()+1);
//                Toast.makeText(view.getContext(), "produit ajouteee", Toast.LENGTH_LONG).show();
//            }
//        });
        return convertView;
    }

}
