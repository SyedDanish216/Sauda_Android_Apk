package com.example.sauda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  EditText txt; //=findViewById(R.id.editText);
//    String
    ListView list; //findViewById(R.id.listView);
    Button button;
    ArrayList<String> sauda; //= new ArrayList<>();

    ArrayAdapter<String>arrAdaptor; //=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sauda);
//        list.setAdapter(arrAdaptor);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button=findViewById(R.id.button);
        txt=findViewById(R.id.editText);
        list=findViewById(R.id.listView);
        sauda=new ArrayList<>();
        arrAdaptor=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sauda);
        list.setAdapter(arrAdaptor);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String item=txt.getText().toString();
                sauda.add(item);
                arrAdaptor.notifyDataSetChanged();
                txt.setText("");
            }


        });
//        sauda.add("Banana");
//        sauda.add("Apple");
//        sauda.add("Mango");
//        sauda.add("Grapes");
//        sauda.add("Watermelon");
//        sauda.add("MuskMelon");
//        ArrayAdapter<String>  arrAdaptor=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sauda);
//        list.setAdapter(arrAdaptor);


        // ListView listView = findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Deleting Item");
                builder.setMessage("Do you want to delete the selected item");
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sauda.remove(position);
                                //list.setAdapter(arrAdaptor);
                                arrAdaptor.notifyDataSetChanged();
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    }
