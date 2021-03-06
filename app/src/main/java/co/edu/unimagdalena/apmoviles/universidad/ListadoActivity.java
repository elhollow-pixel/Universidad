package co.edu.unimagdalena.apmoviles.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListadoActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listado;
    EstudianteController estudianteController;
    Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        agregar = findViewById(R.id.btnAgregar);
        listado = findViewById(R.id.lstlistado);
        estudianteController = new EstudianteController(this);
        Cursor c = estudianteController.allEstudiantes2();
        EstudianteCursorAdapter ecursor = new EstudianteCursorAdapter(this,c,false);
        listado.setAdapter(ecursor);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView cod = view.findViewById(R.id.txtcodigo);
                TextView nom = view.findViewById(R.id.txtnombre);
                TextView prom = view.findViewById(R.id.txtprograma);
                Intent l = new Intent(getApplicationContext(),ModficarActivity.class);
                l.putExtra("cod",cod.getText().toString());
                l.putExtra("nom",nom.getText().toString());
                l.putExtra("prog",prom.getText().toString());
                startActivity(l);
            }
        });
        agregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregar:
                Intent lanzar  = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(lanzar);
                break;
        }
    }
}
