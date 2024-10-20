package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = findViewById(R.id.resultView);
        Button startNewActivityButton = findViewById(R.id.startNewActivityButton);

        startNewActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, childActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("Họ và tên");
            double gpa = data.getDoubleExtra("gpa", 0.0);

            // Display the received data (name and GPA).
            resultView.setText("Họ và tên: " + name + "\nĐiểm GPA: " + gpa);
        }
    }
}