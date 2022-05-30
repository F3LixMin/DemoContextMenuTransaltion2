package com.example.democontextmenutransaltion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tvTransalatedText;
TextView getTvTransalatedText2;
String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTransalatedText = findViewById(R.id.textView);
        registerForContextMenu(tvTransalatedText);
        getTvTransalatedText2 = findViewById(R.id.textView2);
        registerForContextMenu(getTvTransalatedText2);


    }@Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInufo){
        super.onCreateContextMenu(menu, v, menuInufo);

        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");
        if(v == tvTransalatedText){
            wordClicked = "hello";
        }
        else if(v == getTvTransalatedText2){
            wordClicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("Hello")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                tvTransalatedText.setText("Hello");
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                tvTransalatedText.setText("Ciao");
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                return true;  //menu item successfully handled
            } else if (wordClicked.equalsIgnoreCase("bye")) {
                if (item.getItemId() == 0) {
                    getTvTransalatedText2.setText("Bye");
                } else if (item.getItemId() == 1) {
                    getTvTransalatedText2.setText("Addio");
                    return true;
                }
            }
        }


        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }



}