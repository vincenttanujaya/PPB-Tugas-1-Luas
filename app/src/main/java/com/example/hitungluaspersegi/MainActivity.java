package com.example.hitungluaspersegi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valPanjang, valLebar;
    private Button btn;
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valPanjang = findViewById(R.id.valuePanjang);
        valLebar = findViewById(R.id.valueLebar);
        btn = findViewById(R.id.tombolId);
        hasil = findViewById(R.id.hasilId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang, lebar;
                panjang = valPanjang.getText().toString();
                lebar = valLebar.getText().toString();
                if (TextUtils.isEmpty(panjang)){
                    valPanjang.setError("Masukan nilai panjang!");
                    valPanjang.requestFocus();
                }
                else if(TextUtils.isEmpty(lebar)){
                    valLebar.setError("Masukan nilai lebar");
                    valLebar.requestFocus();
                }else if(TextUtils.equals(panjang,".")){
                    valPanjang.setError("Masukan bukan desimal!");
                    valPanjang.requestFocus();
                }else if(TextUtils.equals(lebar,".")){
                    valLebar.setError("Masukan bukan desimal");
                    valLebar.requestFocus();
                }
                else{
                    double p = Double.parseDouble(panjang), l = Double.parseDouble(lebar);
                    double hasilnya = p*l;
                    hasil.setText("Luas: "+hasilnya);
                }

            }
        });
    }
}
