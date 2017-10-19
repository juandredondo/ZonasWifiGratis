package com.example.juan_pc.zonaswifigratis;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class DiagolosActivity extends AppCompatActivity {

    // vistas de tipo global
     Button btnOpciones,btnDialogPersonalizado,btnPlay,btnPause,btnDialogoSimple;
     TextView tv;

    //  declaracion  de todas las vistas que se van a usar en esta actividad
//     EditText etUsuario,etPassword;
//



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos);


        btnOpciones=(Button)findViewById(R.id.btnOpciones);

        //seteo de las diferentes vistas que se usan en esta actividad
        tv=(TextView)findViewById(R.id.tvOpciones);
        btnDialogPersonalizado=(Button)findViewById(R.id.btnPersonalizacion);

        btnPlay =(Button) findViewById(R.id.btnPlay) ;
        btnPause=(Button) findViewById(R.id.btnPause) ;
        btnDialogoSimple=(Button) findViewById(R.id.btnDialogoSimple);

        final  MediaPlayer media= MediaPlayer.create(DiagolosActivity.this,R.raw.audio);



//---------------------------------------------------------------------------------------------------------
        //haciendo un dialogo modal mostrando opciones de tipo lista
        // Boolean array for initial selected items


        btnOpciones.setOnClickListener  (new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // colocar esta  arreglo como  private y globl para que se concerven los check seleccionados cada ves que se ejecute
                 final boolean[] checkedColors = new boolean[]{
                        false, // Red
                        false, // Green
                        false, // Blue
                        false, // Purple
                        false // Olive

                };


                // String array for alert dialog multi choice items
                String[] colors = new String[]{
                        "normal",
                        "medicado",
                        "basiado de glandulas",
                        "desparacitacion",
                        "peluqueria"
                };


                // Convert the color array to list
                final List<String> colorsList = Arrays.asList(colors);

                AlertDialog.Builder alert2 = new AlertDialog.Builder(DiagolosActivity.this);
                alert2.setTitle("Dialogo con opciones");
//                alert2.setMessage(" este cuadro tiene botones de acceso");Q

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

                        for (int j = 0; j < checkedColors.length; j++) {
                            boolean checked = checkedColors[j];
                            if (checked) {
                                tv.setText(tv.getText() + colorsList.get(j) + "\n");
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

        //-----------------------------------------------------------------------------------------------------------------------
        //AGREGANDO EL LISTENER AL BOTON PARA DIALOGOS PERSONALIZADOS

        btnDialogPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // agregando un alert dialog  personalizado, es decir con la ayuda de un layout
                //1. declaramos el objeto de la clase AlertDialog.Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(DiagolosActivity.this);

                //2.declaramos como una vista el layout que se va a mostrar
              View vista =getLayoutInflater().inflate(R.layout.dialogo_personalizado,null);

                myBuilder.setView( vista);
                AlertDialog dialog = myBuilder.create();
                dialog.show();// agregado comentario

            }

        });

//--------------------------------------------------------------------
//        agregando reproducio audio  or fi
        //creamos el objeto de tipo media plaer
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                media.start();
            } });

        // boton de pause
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.pause();//

            }
        });

        //----------------------------------------------------------------

        //agregando alert dialog simple
        btnDialogoSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creando un alert dialog simple son sweet alert
                new SweetAlertDialog(DiagolosActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {

                                Toast.makeText(DiagolosActivity.this, "realizando aciones ", Toast.LENGTH_SHORT).show();
                                sweetAlertDialog
                                        .setTitleText("Deleted!")
                                        .setContentText("Your imaginary file has been deleted!")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            }
                        })
                        .show();
            }
        });//******************************-=================----------------

    }


}
