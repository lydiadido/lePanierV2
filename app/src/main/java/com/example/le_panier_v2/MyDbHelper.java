package com.example.le_panier_v2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCategorie = "CREATE TABLE IF NOT EXISTS CATEGORIE(" +
                "id integer PRIMARY KEY, " +
                "nom text);";
        db.execSQL(queryCategorie);

        String query = "CREATE TABLE IF NOT EXISTS PRODUITS(" +
                "id integer PRIMARY KEY AUTOINCREMENT, " +
                "nom text," +
                "categorie_id integer," +
                "prix double," +
                "description text," +
                "image integer," +
                "FOREIGN KEY (categorie_id) REFERENCES CATEGORIE(id));";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS CATEGORIE;";
        db.execSQL(query);
        query = "DROP TABLE IF EXISTS PRODUITS;";
        db.execSQL(query);
        onCreate(db);

    }
}
