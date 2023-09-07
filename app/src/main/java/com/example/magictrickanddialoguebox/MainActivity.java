package com.example.magictrickanddialoguebox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.magictrickanddialoguebox.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextView textView,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String str = intent.getStringExtra("message_key");
        String str2 = intent.getStringExtra("email");
        // display the string into textView


        binding.RIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.mybox);
                EditText editText = dialog.findViewById(R.id.R_id_name);
                EditText editText2 = dialog.findViewById(R.id.R_id_email);
//                TextView textView=dialog.findViewById(R.id.R_id_tvname);
//                TextView textView2=dialog.findViewById(R.id.R_id_email);
                Button button = dialog.findViewById(R.id.R_id_submit);

                textView= findViewById(R.id.R_id_tvname);
                textView2= findViewById(R.id.R_id_tvemail);
                // create the get Intent object
                Intent intent = getIntent();
                // receive the value by getStringExtra() method and
                // key must be same which is send by first activity
                String str = intent.getStringExtra("message_key");
                String str2 = intent.getStringExtra("email");
                // display the string into textView
                textView.setText(str);
                textView2.setText(str2);


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("Alert");
                        alert.setMessage("Are you sure entered data send");
                        alert.setIcon(R.drawable.ic_errror);
                        Toast.makeText(MainActivity.this, "Submit Data", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String str = editText.getText().toString();
                                String str2 = editText2.getText().toString();
                                // Create the Intent object of this class Context() to Second_activity class
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                // now by putExtra method put the value in key, value pair key is
                                // message_key by this key we will receive the value, and put the string
                                intent.putExtra("message_key", str);
                                intent.putExtra("email", str2);
                                // start the Intent
                                startActivity(intent);

//                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                                String str = editText.getText().toString();
//                                String str2 = editText2.getText().toString();
//                                Intent intent = getIntent();
//                                String str = intent.getStringExtra("message_key");
//
//                                startActivity(intent);

                            }

                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                    @Override
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        });
                            alert.show();

                    }


                });
                    dialog.show();
            }
        });




    }
}