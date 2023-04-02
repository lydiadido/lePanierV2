package com.example.le_panier_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuItem elmList1 =  menu.add(Menu.NONE,Menu.FIRST,0,"Fruit&Legume");
        MenuItem elmList2 =  menu.add(Menu.NONE,Menu.FIRST +1,1,"Dairy&Oeuf");
        MenuItem elmList3 =  menu.add(Menu.NONE,Menu.FIRST +2,2,"Brevages");
        MenuItem elmList4 =  menu.add(Menu.NONE,Menu.FIRST +3,3,"Bierre&Vin");
        MenuItem elmList5 =  menu.add(Menu.NONE,Menu.FIRST +4,4,"Viande&Volail");
        MenuItem elmList6 =  menu.add(Menu.NONE,Menu.FIRST +5,5,"Vegan");
        MenuItem elmList7 =  menu.add(Menu.NONE,Menu.FIRST +6,6,"Snacks");
        MenuItem elmList8 =  menu.add(Menu.NONE,Menu.FIRST +7,7,"Surgeler");
        MenuItem elmList9 =  menu.add(Menu.NONE,Menu.FIRST +8,8,"Boulangerie");
        MenuItem elmList10 = menu.add(Menu.NONE,Menu.FIRST +9,9,"Livraison&Precuit");
        MenuItem elmList11 = menu.add(Menu.NONE,Menu.FIRST +10,10,"Poisson&Repas");
        MenuItem elmList12 = menu.add(Menu.NONE,Menu.FIRST +11,11,"Cuisine_du_monde");
        MenuItem elmList13 = menu.add(Menu.NONE,Menu.FIRST +12,12,"Entretien_maison");
        MenuItem elmList14 = menu.add(Menu.NONE,Menu.FIRST +13,13,"Animaux");
        MenuItem elmList15 = menu.add(Menu.NONE,Menu.FIRST +14,14,"Pharmacie");

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        Intent intent = null;

        switch (item.getItemId()) {
            case Menu.FIRST:
            case Menu.FIRST + 1:
            case Menu.FIRST + 2:
            case Menu.FIRST + 3:
            case Menu.FIRST + 4:
            case Menu.FIRST + 5:
            case Menu.FIRST + 6:
            case Menu.FIRST + 7:
            case Menu.FIRST + 8:
            case Menu.FIRST + 9:
            case Menu.FIRST + 10:
            case Menu.FIRST + 11:
            case Menu.FIRST + 12:
            case Menu.FIRST + 13:
            case Menu.FIRST + 14:
            case Menu.FIRST + 15:

                intent = new Intent(this, Affiche_list.class);
                intent.putExtra("categorie", item.getTitle());
                intent.putExtra("database_name", "PRODUITS.db");
        }
        startActivity(intent);
        return true;
    }
}


