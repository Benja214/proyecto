package com.example.evaluacion;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rut extends AppCompatActivity {

    private EditText txtRut;
    private TextView txtRespuesta;
    private Button btnRevisar, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rut);

        txtRut = findViewById(R.id.txtRUT);
        btnRevisar = findViewById(R.id.btnRevisar);
        txtRespuesta = findViewById(R.id.txtRespuesta);
        btnVolver =findViewById(R.id.btnVolver);

        btnRevisar.setOnClickListener(view -> {
            String rut = txtRut.getText().toString().trim();
            if (esRutValido(rut)) {
                txtRespuesta.setText("El RUT es válido");
            } else {
                txtRespuesta.setText("El RUT es inválido");
            }
        });
        btnVolver.setOnClickListener(view -> {
            finish();
        });
    }

    // Método para validar el RUT
    private boolean esRutValido(String rut) {
        try {
            rut = rut.toUpperCase().replace(".", "").replace("-", "");
            int rutNumerico = Integer.parseInt(rut.substring(0, rut.length() - 1));
            char dvIngresado = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutNumerico != 0; rutNumerico /= 10) {
                s = (s + rutNumerico % 10 * (9 - m++ % 6)) % 11;
            }
            char dvCalculado = (s != 0) ? (char) (s + 47) : 'K';

            return dvCalculado == dvIngresado;
        } catch (Exception e) {
            return false;
        }
    }
}
