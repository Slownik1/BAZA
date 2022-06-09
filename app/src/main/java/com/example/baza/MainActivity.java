package com.example.baza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.util.Log;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public Button buttonInsert;
    public Button buttonSearch;
    public Button buttonDelete;
    public Button buttonSelect;
    public EditText editTextImie;
    public EditText editTextNazwisko;
    public EditText editTextMiejscowosc;
    public EditText editTextDataUrodzenia;
    public EditText editTextPhone;

    Baza dm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsert = (Button)findViewById(R.id.ButtonInsert);
        buttonDelete = (Button)findViewById(R.id.buttonDelete);
        buttonSearch = (Button)findViewById(R.id.buttonSearch);
        buttonSelect = (Button)findViewById(R.id.buttonSelect);
        editTextImie = (EditText)findViewById(R.id.editTextImie);
        editTextNazwisko = (EditText)findViewById(R.id.editTextNazwisko);
        editTextMiejscowosc = (EditText)findViewById(R.id.editTextTextMiejscowosc);
        editTextDataUrodzenia = (EditText)findViewById(R.id.editTextDataUrodzenia);
        editTextPhone = (EditText)findViewById(R.id.editTextPhone);

        dm = new Baza(this);

        buttonSelect.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonInsert.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);

    }

    public void showData(Cursor c){

        while (c.moveToNext()){
            Log.i(c.getString(1), c.getString( 2));
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.ButtonInsert:
                dm.insert(editTextImie.getText(), editTextNazwisko.getText(),
                        editTextDataUrodzenia.getText(), editTextPhone.getText());
                break;

            case R.id.buttonSelect:
                break;

            case R.id.buttonSearch:
                break;

            case R.id.buttonDelete:
                break;

        }

    }
}