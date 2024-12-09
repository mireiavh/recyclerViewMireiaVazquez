package com.mireia.recyclerejercicio;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

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

        //Conjunto de datos
        ArrayList<Food> foodList = new ArrayList<>(Arrays.asList(new Food[]{
                new Food(R.drawable.pan, "Pan", true),
                new Food(R.drawable.patatas, "Patatas", true),
                new Food(R.drawable.lechuga, "Lechuga", true)
        }));

        //crear el adaptador
        MiAdaptador foodAdaptor = new MiAdaptador(foodList);

        //Instanciar el RecyclerView
        RecyclerView rvList = findViewById(R.id.rv_list);

        //Modificar el tipo de LayoutManager
        rvList.setLayoutManager(new LinearLayoutManager(this));

        //Asignar el adaptador al RecyclerView
        rvList.setAdapter(foodAdaptor);
    }
}