package com.example.dunkindonuts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderDelailActivity extends AppCompatActivity {

    private static final String EXTRA_USER_NAME = "userName";
    private static final String EXTRA_DRINK = "drink";
    private static final String EXTRA_DRINK_TYPE = "drinkType";
    private static final String EXTRA_ADDITIVES = "additives";

    private TextView textViewName;                                                                  // Инициализация объектов
    private TextView textViewDrink;                                                                 // Инициализация объектов
    private TextView textViewDrinkType;                                                             // Инициализация объектов
    private TextView textViewAdditives;                                                             // Инициализация объектов



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_delail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();                                                                                // Не забываем Вызвать метод в onCreate

        Intent intent = getIntent();
        textViewName.setText(intent.getStringExtra(EXTRA_USER_NAME));                               // Установка значений в инициализированные TextView,
        textViewDrink.setText(intent.getStringExtra(EXTRA_DRINK));                                  // по соответсвующим ключам.
        textViewDrinkType.setText(intent.getStringExtra(EXTRA_DRINK_TYPE));
        textViewAdditives.setText(intent.getStringExtra(EXTRA_ADDITIVES));

    }

    public static Intent newIntent(Context context,
                                   String userName,
                                   String drink,
                                   String additives,
                                   String drinkType) {                                              // Фабричный метод создания Intent'ов
        Intent intent = new Intent(context, OrderDelailActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        intent.putExtra(EXTRA_DRINK, drink);
        intent.putExtra(EXTRA_DRINK_TYPE, additives);
        intent.putExtra(EXTRA_ADDITIVES, drinkType);
        return (intent);
    }
     private void initViews () {
        textViewName = findViewById(R.id.textViewName);                                             // Присвоение значений всем переменным, в отдельном методе
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewDrinkType = findViewById(R.id.textViewDrinkType);
        textViewAdditives = findViewById(R.id.textViewAdditives);
     }
}