package com.example.semana2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivilegedExceptionAction;

public class ConfirmarDatos extends AppCompatActivity implements View.OnClickListener {
    TextView tvNombre,tvfNacimiento,tvTelefono,tvCorreo,tvDescripcion;
    Button btnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        tvNombre=findViewById(R.id.tvNombre);
        tvfNacimiento=findViewById(R.id.tvfNacimiento);
        tvTelefono=findViewById(R.id.tvTelefono);
        tvCorreo=findViewById(R.id.tvCorreo);
        tvDescripcion=findViewById(R.id.tvDescripcion);
        btnEditar=findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(this);

        try {
            Bundle bundle = new Bundle();
            bundle = getIntent().getExtras();

            tvNombre.setText(bundle.getString(getResources().getString(R.string.pedir_nombre))==null?"":bundle.getString(getResources().getString(R.string.pedir_nombre)));
            tvfNacimiento.setText(bundle.getString(getResources().getString(R.string.pedir_fnacimiento))==null?"":getResources().getString(R.string.fnacimiento)+" "+bundle.getString(getResources().getString(R.string.pedir_fnacimiento)));
            tvTelefono.setText(bundle.getString(getResources().getString(R.string.pedir_telefono))==null?"":getResources().getString(R.string.tel)+" "+bundle.getString(getResources().getString(R.string.pedir_telefono)));
            tvCorreo.setText(bundle.getString(getResources().getString(R.string.pedir_email))==null?"":getResources().getString(R.string.email)+" "+bundle.getString(getResources().getString(R.string.pedir_email)));
            tvDescripcion.setText(bundle.getString(getResources().getString(R.string.pedir_desccripcion))==null?"":getResources().getString(R.string.descripcion)+" "+bundle.getString(getResources().getString(R.string.pedir_desccripcion)));

        }catch(Exception e){
            Toast.makeText(this, "Viene Vacio los datos", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEditar:
                onBackPressed();
                break;
        }
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
