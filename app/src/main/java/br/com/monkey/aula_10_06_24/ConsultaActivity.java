package br.com.monkey.aula_10_06_24;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
                    leituraBD(username);
                } else {
                    Toast.makeText(ConsultaActivity.this, "Digite Username válido!", Toast.LENGTH_SHORT).show();;
                }
            }

        });
    }

    private void leituraBD(String username) {
        reference = FirebaseDatabase.getInstance().getReference("Usuario");
        reference.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    if(task.getResult().exists()){
                        Toast.makeText(ConsultaActivity.this, "Consulta realizada com sucesso!", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String nome = String.valueOf(dataSnapshot.child("nome").getValue());
                        String sobrenome = String.valueOf(dataSnapshot.child("sobrenome").getValue());
                        String idade = String.valueOf(dataSnapshot.child("idade").getValue());

                        TextView tvNome = findViewById(R.id.tvNome);
                        TextView tvSobrenome = findViewById(R.id.tvSobrenome);
                        TextView tvIdade = findViewById(R.id.tvIdade);

                        tvNome.setText(nome);
                        tvSobrenome.setText(sobrenome);
                        tvIdade.setText(idade);
                    } else {
                        Toast.makeText(ConsultaActivity.this, "Usuario não existe", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ConsultaActivity.this, "ERROR!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
