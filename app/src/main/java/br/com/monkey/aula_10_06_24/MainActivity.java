package br.com.monkey.aula_10_06_24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button cadastrar, consultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastrar = findViewById(R.id.buttonCadastro);
        consultar = findViewById(R.id.buttonConsulta);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsultaActivity.class);
                startActivity(intent);
            }
        });
    }
}