package com.example.semana2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText tietNombre,tietfNacimiento,tietTelefono,tietCorreo,tietDescripcion;
    Button btnSiguiente;
    final private Calendar calendario= Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tietNombre=findViewById(R.id.tietNombre);
        tietfNacimiento=findViewById(R.id.tietfNacimiento);
        tietfNacimiento.setOnClickListener((View.OnClickListener) this);
        tietTelefono=findViewById(R.id.tietTelefono);
        tietCorreo=findViewById(R.id.tietCorreo);
        tietDescripcion=findViewById(R.id.tietDescripcion);
        btnSiguiente=findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(this);

    }
//TODO aRRGLAR
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSiguiente:
                Bundle bundle=new Bundle();
                bundle.putString(getResources().getString(R.string.pedir_nombre),tietNombre.getText().toString());
                bundle.putString(getResources().getString(R.string.pedir_fnacimiento),tietfNacimiento.getText().toString());
                bundle.putString(getResources().getString(R.string.pedir_telefono),tietTelefono.getText().toString());
                bundle.putString(getResources().getString(R.string.pedir_email),tietCorreo.getText().toString());
                bundle.putString(getResources().getString(R.string.pedir_desccripcion),tietDescripcion.getText().toString());
                Toast.makeText(this, " "+tietNombre.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,ConfirmarDatos.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.tietfNacimiento:
                showDatePickerDialog();
                break;
        }
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendario.set(Calendar.YEAR,year);
                calendario.set(Calendar.MONTH,month);
                calendario.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                String currentDateString = DateFormat.getDateInstance().format(calendario.getTime());
                tietfNacimiento.setText(currentDateString);
                Toast.makeText(MainActivity.this, " Fecha: " + currentDateString, Toast.LENGTH_SHORT).show();
            }
        }, 1900, calendario.MONTH, calendario.DAY_OF_MONTH);
        datePickerDialog.show();
    }

//        DatePickerDialog datePickerDialog= new DatePickerDialog(this,
//                new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        String currentDateString = DateFormat.getDateInstance().format(Calendar.getInstance());
//                        tietfNacimiento.setText(currentDateString);
//                    }
//                }, 1900,0,1);
//        datePickerDialog.show();
//    }

//    @Override
//    protected  void onResume(){
//        tietNombre.setText(tietNombre.getText().toString());
//        super.onResume();
//    }
//    @Override
//    protected  void onStart(){
//        tietTelefono.setText(tietTelefono.getText().toString());
//        super.onStart();
//    }
//    @Override
//    protected  void onRestart(){
//        tietNombre.setText(tietNombre.getText().toString());
//        super.onRestart();
//    }

}