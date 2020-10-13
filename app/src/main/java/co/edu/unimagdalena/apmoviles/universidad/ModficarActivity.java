package co.edu.unimagdalena.apmoviles.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ModficarActivity extends AppCompatActivity implements View.OnClickListener  {
    TextView codigo;
    EditText Nom,Prom;
    Button mod,elim;
    Bundle Datos;
    String cod,Nombre,Programa;
    EstudianteController e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modficar);
        codigo = findViewById(R.id.Tcod);
        Nom = findViewById(R.id.txtEnom);
        Prom = findViewById(R.id.txtEprom);
        mod = findViewById(R.id.btnMod);
        elim = findViewById(R.id.btnElim);
        e = new EstudianteController(this);
        mod.setOnClickListener(this);
        elim.setOnClickListener(this);
        Datos = getIntent().getExtras();
        cod = Datos.getString("cod");
        Nombre = Datos.getString("nom");
        Programa = Datos.getString("prog");
        codigo.setText(cod);
        Nom.setText(Nombre);
        Prom.setText(Programa);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnMod:
                e.Mod(codigo.getText().toString(),Nom.getText().toString(),Prom.getText().toString());
                Intent lanzar = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(lanzar);
                break;
            case R.id.btnElim:
                e.Elim(codigo.getText().toString());
                lanzar = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(lanzar);
                break;
        }
    }
}