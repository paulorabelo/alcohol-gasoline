package br.com.mrgsoft.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPriceAlcohol, editPriceGasoline;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPriceAlcohol    = findViewById(R.id.editPriceAlcohol);
        editPriceGasoline   = findViewById(R.id.editPriceGasoline);
        textResult          = findViewById(R.id.textResult);

    }

    public void priceCalculate(View view) {

        //Recuperar valores digitados.
        String alcoholPrice = editPriceAlcohol.getText().toString();
        String gasolinePrice = editPriceGasoline.getText().toString();

        //Validar os campos digitados
        Boolean validatedFields = validateFields( alcoholPrice, gasolinePrice );
        if ( validatedFields ){

            //Convertendo string para números (Double)
            Double alcoholValue = Double.parseDouble( alcoholPrice );
            Double gasolineValue = Double.parseDouble( gasolinePrice );

            /*  Cálculo de melhor preço álcool ou gasolina --> simple conversor
                Se (alcoholValue / gasolineValue) >= 0.7 é melhor utilizar gasolina
                senão é melhr utilizar álcool
             */
            Double result = alcoholValue / gasolineValue;
            if ( result >= 0.7){
                textResult.setText("Melhor utilizar Gasolina");
            }else {
                textResult.setText("Melhor utilizar Etanol");
            }

        }else {
            textResult.setText("Preencha os campos primeiro!");
        }

    }

    public Boolean validateFields( String alcoholP, String gasolineP ){

        Boolean validatedFields = true;
        String field = "preenchido";

        if ( alcoholP == null || alcoholP.equals("") ) {
            validatedFields = false;
        }else if ( gasolineP == null || gasolineP.equals("")) {
            validatedFields = false;
        }

        return validatedFields;

    }

}