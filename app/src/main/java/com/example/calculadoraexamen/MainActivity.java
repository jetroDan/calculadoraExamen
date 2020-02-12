package com.example.calculadoraexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ClassAbstract {

    private EditText longitud;
    private EditText anchura;
    private EditText altura;
    private EditText bascula;
    private EditText tarifa;
    private Button   calcular;
    private EditText totalPagar;
    private EditText tarifaBase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longitud = findViewById(R.id.lbLongitud);
        anchura = findViewById(R.id.lbAnchura);
        altura = findViewById(R.id.lbAltura);
        bascula = findViewById(R.id.lbPesoBascula);
        tarifa = findViewById(R.id.lbTarifa);
        calcular = findViewById(R.id.btnCalcular);
        totalPagar = findViewById(R.id.lbTotalPagar);
        tarifaBase = findViewById(R.id.lbEnbaseA);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totalPagar.setText(String.valueOf(calcularTarifamtd() + iva()));
                //tarifaBase.setText("Tarifa calculada en base a:" );

            }
        });


    }

    @Override
    public float pesoVolumenmtd() {
        float totalPesoV =0;
        float constante = 6000;
        float num1 = Float.parseFloat(longitud.getText().toString());
        float num2 = Float.parseFloat(anchura.getText().toString());
        float num3 = Float.parseFloat(altura.getText().toString());
        totalPesoV = num1*num2*num3/constante;
        return totalPesoV;
    }
    @Override
    public float iva() {
        double iva =0;
        iva = calcularTarifamtd() * 0.16;

        return (float) iva;
    }

    @Override
    public float calcularTarifamtd() {
        float totalTarifa =0;
        double iva=0.16;
        double resultado;
        float num1 = Float.parseFloat(tarifa.getText().toString());
        totalTarifa = num1 *  pesoVolumenmtd();
        iva = totalTarifa * 0.16;


        return totalTarifa;
    }
}

