package com.example.animalwhatsappstickers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ToDo: Customize Action Bar
        //ToDo: Localization for Spanish, French, English (UK)
        //ToDo: Upload this project via git

        //Get a spinner, gridView
        Spinner animalSpinner = (Spinner) findViewById(R.id.selectAnimalSpinner);


        //Use arrayadapter to feed XML Array into spinner
        ArrayAdapter<CharSequence> animalAdapter = ArrayAdapter.createFromResource(this,
                R.array.animals_array, android.R.layout.simple_spinner_item);
        animalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animalSpinner.setAdapter(animalAdapter);

        //Put a listener on the spinner
        animalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                TextView animalSelected = (TextView) findViewById(R.id.selectedAnimal);
                String[] animalsArray = getResources().getStringArray(R.array.animals_array);
                animalSelected.setText(animalsArray[pos]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast announce = Toast.makeText(getApplicationContext(), "nothing was selected 😿", Toast.LENGTH_SHORT);
                announce.show();
            }
        });

        //Gridview stuff



    }
}