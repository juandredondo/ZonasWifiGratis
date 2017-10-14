package com.example.juan_pc.zonaswifigratis;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class DiagolosActivity extends AppCompatActivity {

    // vistas de tipo global
     Button btnOpciones;
    TextView tv;
    // Boolean array for initial selected items



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos);


        btnOpciones=(Button)findViewById(R.id.btnOpciones);
        tv=(TextView)findViewById(R.id.tvOpciones);

        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String array for alert dialog multi choice items
                String[] colors = new String[]{
                        "normal",
                        "medicado",
                        "basiado de glandulas",
                        "desparacitacion",
                        "peluqueria"
                };

                final  boolean[] checkedColors = new boolean[]{
                        false, // Red
                        false, // Green
                        false, // Blue
                        false, // Purple
                        false // Olive

                };




                // Convert the color array to list
                final List<String> colorsList = Arrays.asList(colors);



                AlertDialog.Builder alert2= new AlertDialog.Builder(DiagolosActivity.this);
                alert2.setTitle("Dialogo con opciones");
//                alert2.setMessage(" este cuadro tiene botones de acceso");

                //agregando las opciones del chekbox
                alert2.setMultiChoiceItems(colors, checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i, boolean isChecked) {

                                // Update the current focused item's checked status
                                checkedColors[i] = isChecked;

                                // Get the current focused item
                                String currentItem = colorsList.get(i);

                                // Notify the current action
                                Toast.makeText(getApplicationContext(),
                                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                            }
                        });


                        //agrega el boton ok al cuadro de dialogo y aplica un listener
                        alert2.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tv.setText("tus Baños son:  \n");



                                for ( int j= 0; j<checkedColors.length; j++){
                                    boolean checked = checkedColors[j];
                                    if (checked) {
                                        tv.setText(tv.getText() + colorsList.get(j) + "\n");
                                    }
                                    else
                                    {
                                        tv.setText("");
                                    }
                                }
                            }
                        });

                //agrega el boton cancelar al listener y implementa un listener
                alert2.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      dialogInterface.cancel();

                    }
                });
                alert2.show();//se muestra el  dialogo

            }


        });



    }
}
