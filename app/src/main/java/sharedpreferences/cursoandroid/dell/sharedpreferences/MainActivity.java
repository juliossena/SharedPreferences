package sharedpreferences.cursoandroid.dell.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView resultado;
    private Button botao;
    private EditText edtTexto;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView) findViewById(R.id.texto_resultado_id);
        botao = (Button) findViewById(R.id.btn_salvar_id);
        edtTexto = (EditText) findViewById(R.id.edit_nome_id);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (edtTexto.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Por favor, preencha um nome", Toast.LENGTH_LONG).show();
                } else {
                    editor.putString("nome", edtTexto.getText().toString());
                    editor.commit();
                    resultado.setText("Olá, " + edtTexto.getText().toString());
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (sharedPreferences.contains("nome")) {
            String nomeUsuario = sharedPreferences.getString("nome", "Usuário não definido");
            resultado.setText("Olá, " + nomeUsuario);
        } else {
            resultado.setText("Olá usuário não definido");
        }
    }
}
