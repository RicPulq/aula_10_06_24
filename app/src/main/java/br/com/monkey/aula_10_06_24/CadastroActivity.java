package br.com.monkey.aula_10_06_24;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.monkey.aula_10_06_24.model.Usuario;

public class CadastroActivity extends AppCompatActivity {
    String nome, sobrenome, idade, username;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EditText nomeEdit = findViewById(R.id.Nome);
        EditText sobrenomeEdit = findViewById(R.id.Sobrenome);
        EditText idadeEdit = findViewById(R.id.idade);
        EditText usernameEdit = findViewById(R.id.userName);
        Button registerBTN = findViewById(R.id.registerBtn);

        registerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = nomeEdit.getText().toString();
                sobrenome = sobrenomeEdit.getText().toString();
                idade = idadeEdit.getText().toString();
                username = usernameEdit.getText().toString();

                if (!nome.isEmpty() && !username.isEmpty()) {
                    Usuario usuario = new Usuario(nome, sobrenome, idade, username);

                    databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");
                    databaseReference.child(username).setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            nomeEdit.setText("");
                            sobrenomeEdit.setText("");
                            idadeEdit.setText("");
                            usernameEdit.setText("");

                            Toast.makeText(CadastroActivity.this,"Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}
