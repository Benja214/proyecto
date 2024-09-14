package com.example.evaluacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class sorteo extends AppCompatActivity {

    private EditText txtMax, txtMin;
    private Button btnSorteo, btnVolver;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteo_aleatorio);

        txtMin = findViewById(R.id.txtMin);
        txtMax = findViewById(R.id.txtMax);
        btnSorteo = findViewById(R.id.btnSorteo);
        txtResultado = findViewById(R.id.txtResultado);
        btnVolver = findViewById(R.id.btnVolver);

        btnSorteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = Integer.parseInt(txtMin.getText().toString());
                int max = Integer.parseInt(txtMax.getText().toString());

                if (min >= max) {
                    txtResultado.setText("Rango inválido");
                } else {
                    Random random = new Random();
                    int randomNumber = random.nextInt((max - min) + 1) + min;

                    txtResultado.setText("Número generado: " + randomNumber);
                }
            }
        });
        btnVolver.setOnClickListener(view -> {
            finish();
        });
    }
}
