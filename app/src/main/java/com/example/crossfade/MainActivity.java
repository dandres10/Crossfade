package com.example.crossfade;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tvContenido;
    ProgressBar pbLoding;
    private int duracionAnimacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContenido = findViewById(R.id.textViewContenido);
        pbLoding = findViewById(R.id.progressBarLoading);

        duracionAnimacion = getResources().getInteger(android.R.integer.config_shortAnimTime);

        //ocultar el texto
        tvContenido.setVisibility(View.GONE);
        pbLoding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossfadeAnimation();
            }
        });

    }


    private void crossfadeAnimation() {
        tvContenido.setAlpha(0f);
        tvContenido.setVisibility(View.VISIBLE);

        //Mostramos progresivamente la barra de carga
        tvContenido.animate()
                .alpha(1f)
                .setDuration(duracionAnimacion);
        //Ocultamos progresivamente la barra de carga.
        pbLoding.animate()
                .alpha(0f)
                .setDuration(duracionAnimacion)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        pbLoding.setVisibility(View.GONE);
                    }
                });
    }


}
