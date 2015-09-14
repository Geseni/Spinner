package com.example.geseni_pc.tareaspinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    Spinner spMarca, spModelo;
    ArrayAdapter<String> aaMarca, aaModelo, aaClear;
    String[] opMarca=new String[]{"Lamborghini", "Ferrari", "Toyota","Mercedes-Benz"};
    String[] opModelo=new String[]{"Focus", "Fusion", "Taurus","Escape","Edge","Expedition","Flex"};
    String[] opClear=new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMarca=(Spinner)findViewById(R.id.spMarca);
        spModelo=(Spinner)findViewById(R.id.spModelo);

        spMarca.setOnItemSelectedListener(this);
        spModelo.setOnItemSelectedListener(this);

        aaMarca=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opMarca);
        aaModelo=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opModelo);
        aaClear=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opClear);

        spMarca.setAdapter(aaMarca);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        switch (arg0.getId()){
            case R.id.spMarca:
                int seleccionado=spMarca.getSelectedItemPosition();
                if (seleccionado==2)
                    spModelo.setAdapter(aaModelo);
                else
                    spModelo.setAdapter(aaClear);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
