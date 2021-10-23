package com.example.animalwhatsappstickers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animalwhatsappstickers.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    //ToDo: Customize Action Bar
    //ToDo: Localization for Spanish, French, English (UK)
    //ToDo: Upload this project via git


    //Get a spinner, gridView
    Spinner animalSpinner;
    GridView animalGridView;
    ActivityMainBinding activityMainBinding;
    GridAdapter gridAdapter;

    //ToDo; This array is going to have a format of {r.drawable.NAME1, R.drawable.NAME2, etc}
    //Todo: In choosing a new array (read: theme of stickers like dog, cheems, etc) how could I go
    // about reusing a previously loaded array?

    //Todo: Drawable folder heirchy is flat. Prefix the image names inside of your folder before
    // adding to drawable folder 😢


    //EXTRA CREDIT: Make a python program that takes a folder, and prints out the array syntax
    //  for you, loaded with the name of the file images inside.
    // EXTRA EXTRA CREDIT: Make the python folder resources-folder friendly. Auto convert to png,
    //  and name each image file in a folder sequentially (1,2,3,etc) or (a,b,c,etc) whatever works.
    //Todo: TEST
    int[] animalImages = {R.drawable.random_1 ,R.drawable.random_3,R.drawable.random_4,
            R.drawable.random_5,R.drawable.random_6,R.drawable.random_7, R.drawable.random_8,
            R.drawable.random_9,R.drawable.random_10,R.drawable.random_11,R.drawable.random_12};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Binder
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //Create spinner
        animalSpinner = (Spinner) findViewById(R.id.selectAnimalSpinner);
        ArrayAdapter<CharSequence> animalAdapter = ArrayAdapter.createFromResource(this,
                R.array.animals_array, android.R.layout.simple_spinner_item);
        animalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animalSpinner.setAdapter(animalAdapter);

        //Put a listener on the spinner
        animalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                TextView animalSelected = (TextView) findViewById(R.id.selectedAnimal_Test);
                String[] animalsArray = getResources().getStringArray(R.array.animals_array);
                animalSelected.setText(animalsArray[pos]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast announce = Toast.makeText(getApplicationContext(), "nothing was selected 😿", Toast.LENGTH_SHORT);
                announce.show();
            }
        });

        //Gridview reference and load w/adapter
        animalGridView = findViewById(R.id.gridView_DisplayStickers);
        gridAdapter = new GridAdapter(MainActivity.this, animalImages);
        activityMainBinding.gridViewDisplayStickers.setAdapter(gridAdapter);
        //Gridview listener
        activityMainBinding.gridViewDisplayStickers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You clicked on " + animalImages[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}