package com.example.dunkindonuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonSign_in;



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
        initViews();

        buttonSign_in.setOnClickListener(new View.OnClickListener() {            // Слушаем кнопку
            @Override
            public void onClick(View v) {
                String userName = editTextName.getText().toString().trim();      // записывваем данныей из поля ввода в переменную
                String password = editTextPassword.getText().toString().trim();  // записывваем данныей из поля ввода в переменную

                if (userName.isEmpty()|| password.isEmpty()) {
                    Toast.makeText(                                             // метод для вывода сообщения в приложении
                            MainActivity.this,
                            R.string.error_fields_emty,                         // Получение строки из ресурсов в MainActivity
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    launchNextScreen(userName);                                  // Запуск следующего экрана
                }


            }
        });
    }
    private void launchNextScreen (String userName) {                                                  // Метод запуска следующего экрана
        Intent intent = MakeOrderActivity.newIntent(this,userName);                             // Способ создания Intent'ов
        startActivity(intent);
    }

    private void initViews(){
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSign_in = findViewById(R.id.buttonSign_in);

    }
}