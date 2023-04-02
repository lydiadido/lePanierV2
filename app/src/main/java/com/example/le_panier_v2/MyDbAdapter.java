package com.example.le_panier_v2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MyDbAdapter {
    private Context context;
    private final String db_name="MaBb";
    private MyDbHelper dbHelper;
    private final int db_version = 1;
    private SQLiteDatabase db;

    public MyDbAdapter(Context context) {
        this.context = context;
        this.dbHelper = new MyDbHelper(context,db_name,null,db_version);
    }
    public void Open(){
        this.db = this.dbHelper.getWritableDatabase();
    }
    public void Close(){
        this.db.close();
    }

    public void InsertNewCat(){

        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(1,'Fruit&Legume');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(2,'Dairy&Oeuf');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(3,'Brevages');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(4,'Bierre&Vin');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(5,'Viande&Volail');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(6,'Vegan');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(7,'Snacks');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(8,'Surgeler');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(9,'Boulangerie');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(10,'Livraison&Precuit');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(11,'Poisson&Repas');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(12,'Cuisine_du_monde');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(13,'Entretien_maison');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(14,'Animaux');");
        this.db.execSQL("INSERT INTO CATEGORIE (id, nom) values(15,'Pharmacie');");
    }

    public void InsertNewProduit(){

        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p1',1,11 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p2',2,22 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p3',3,33 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p4',4,44 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p5',5,55 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p6',6,66 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p7',7,77 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p8',8,88 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p9',9,99 , 'jhgfcxfghcategorie ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p10',10,100  , ' ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p11',11,111 , ' ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p12',12,112 , ' ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p13',13,113 , ' ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p14',14,114 , ' ');");
        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description) values('p15',15,115, ' ');");
//        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description,image) values(' ',  ,  , ' ',  );");
//        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description,image) values(' ',  ,  , ' ',  );");
//        this.db.execSQL("INSERT INTO PRODUITS (nom, categorie_id, prix, description,image) values(' ',  ,  , ' ',  );");
    }
    public void DeleteAllProduit(){
        this.db.delete("CATEGORIE",null,null);
        this.db.delete("PRODUITS",null,null);
    }
    public ArrayList<Produit> AllProducts()
    {
        ArrayList<Produit> arrayprod = new ArrayList<Produit>();
        Cursor cursor = this.db.rawQuery("SELECT*FROM PRODUITS",null);
        int id =cursor.getColumnIndex("id");
        int nom =cursor.getColumnIndex("nom");
        int cat =cursor.getColumnIndex("categorie_id");
        int prix=cursor.getColumnIndex("prix");
        int desc=cursor.getColumnIndex("description");
        int img=cursor.getColumnIndex("image");

        if((cursor !=null)&& cursor.moveToFirst())
        {
            do {
                arrayprod.add(new Produit(cursor.getInt(id),cursor.getString(nom),cursor.getInt(cat),cursor.getString(desc),cursor.getInt(prix),cursor.getInt(img)));
            }
            while (cursor.moveToNext());
        }
        return arrayprod;
    }
    public ArrayList<Produit> ProdByCategory(String titre){
        ArrayList<Produit> arrayprod = new ArrayList<Produit>();
        Cursor cursor = this.db.rawQuery("SELECT PRODUITS.id, PRODUITS.nom, PRODUITS.categorie_id, PRODUITS.prix, PRODUITS.description,PRODUITS.image  FROM PRODUITS, CATEGORIE " +
                                                "WHERE " +
                                                "PRODUITS.categorie_id=CATEGORIE.id and CATEGORIE.nom=?",new String[]{(titre)});
        int id_prod =cursor.getColumnIndex("id");
        int nom =cursor.getColumnIndex("nom");
        int cat =cursor.getColumnIndex("categorie_id");
        int prix=cursor.getColumnIndex("prix");
        int desc=cursor.getColumnIndex("description");
        int img=cursor.getColumnIndex("image");

        if((cursor !=null)&& cursor.moveToFirst())
        {
            do {
                arrayprod.add(new Produit(cursor.getInt(id_prod),cursor.getString(nom),cursor.getInt(cat),cursor.getString(desc),cursor.getInt(prix),cursor.getInt(img)));
            }
            while (cursor.moveToNext());
        }
        return arrayprod;
    }

}
