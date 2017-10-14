package com.example.juan_pc.zonaswifigratis;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class DiagolosActivity extends AppCompatActivity {

    // vistas de tipo global
     Button btnOpciones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos);

        final CharSequence myList[] = { "Tea", "Coffee", "Milk" };
        btnOpciones=(Button)findViewById(R.id.btnOpciones);

        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert2= new AlertDialog.Builder(DiagolosActivity.this);
                alert2.setTitle("Dialogo con opciones");
                alert2.setMessage(" este cuadro tiene botones de acceso");

                //agregando las opciones del chekbox
                alert2.setMultiChoiceItems(myList, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        });


                        //agrega el boton ok al cuadro de dialogo y aplica un listener
                        alert2.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DiagolosActivity.this, "presionado boton ok", Toast.LENGTH_SHORT).show();
                            }
                        });

                //agrega el boton cancelar al listener y implementa un listener
                alert2.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DiagolosActivity.this, "Presionado Boton cancel", Toast.LENGTH_SHORT).show();

                    }
                });
                alert2.show();//se muestra el  dialogo

            }


        });



    }
}
