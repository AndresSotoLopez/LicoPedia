package com.app.licopedia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Licor_Seleccionado extends AppCompatActivity {

    private ImageView licor_image;
    private TextView licor_link1,licor_link2 , licor_name;

    Context context=this;

    /**Detail Activity muesta el detalle del licor escogido,este contendrá imagen, nombre del licor
     * y un link clicabel que llevará a la preaparación**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licor_seleccionado);
        licor_image= findViewById(R.id.licorImagen);
        licor_link1 = findViewById(R.id.licorLink1);
        licor_link2 = findViewById(R.id.licorLink2);
        licor_name = findViewById(R.id.licorName);

         /** @ActionBar es para la flecha de retorno a la actividad anterior **/
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        /** @intent lo utilizo para cargar la actividad **/

        Intent intent = getIntent();
        String  name = intent.getStringExtra("name");
        String image_url = intent.getStringExtra("image_url");


        /**Ulizo glide para mostrar la imagen**/
        Glide.with(Licor_Seleccionado.this).load(image_url).into(licor_image);
        licor_name.setText(name);



        /** @licor_link: al clicar en el, lleva a la pantalla 8 que es la de preparación  **/
        licor_link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent intent =  new Intent(context, pantalla_preparacion.class);
                context.startActivity(intent);*/
            }
        });

        licor_link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent =  new Intent(context, pantalla_preparacion.class);
                context.startActivity(intent);*/
            }
        });

    }
}