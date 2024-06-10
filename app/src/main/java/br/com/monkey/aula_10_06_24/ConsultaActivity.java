package br.com.monkey.aula_10_06_24;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class ConsultaActivity extends AppCompatActivity {
    DatabaseReference reference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        EditText etUsername = findViewById(R.id.etusername);
        Button result = findViewById(R.id.readdataBtn);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();

                if(!username.isEmpty()){


                } else {
                    Toast.makeText(ConsultaActivity.this, "Digite Username válido!", Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }
}
