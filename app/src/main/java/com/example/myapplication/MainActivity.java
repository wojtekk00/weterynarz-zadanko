package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> zwierzeta;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private SeekBar seekBar;
    private int[] wiek;
    private TextView textViewWiek;
    private EditText editTextImieNazwisko;
    private EditText editTextCelWizyty;
    private EditText editTextGodzina;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        wiek = new int[]{18, 20, 9};
        zwierzeta = new ArrayList<>();
        zwierzeta.add("Pies");
        zwierzeta.add("Kot");
        zwierzeta.add("Świnka morska");
        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, zwierzeta);
        listView.setAdapter(arrayAdapter);
        seekBar = findViewById(R.id.seekBar);
        textViewWiek = findViewById(R.id.textView4);
        editTextImieNazwisko = findViewById(R.id.editTextText);
        editTextCelWizyty = findViewById(R.id.editTextText2);
        editTextGodzina = findViewById(R.id.editTextTime);
        button = findViewById(R.id.button);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //i kliknieta pozycja na liscie
                        Toast.makeText(MainActivity.this, zwierzeta.get(i), Toast.LENGTH_SHORT).show();
                        seekBar.setMax(wiek[i]);
                    }
                }
        );
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        textViewWiek.setText("Ile ma lat? "+i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String imieNazwisko = editTextImieNazwisko.getText().toString();
                        String celWizyty = editTextCelWizyty.getText().toString();
                        String godzina = editTextGodzina.getText().toString();
                        Toast.makeText(MainActivity.this, imieNazwisko)
                    }
                }
        );
    }
}