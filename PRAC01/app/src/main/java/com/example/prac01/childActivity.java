package com.example.prac01;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class childActivity extends AppCompatActivity {

    private EditText nameInput;
    private EditText gpaInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        nameInput = findViewById(R.id.nameInput);
        gpaInput = findViewById(R.id.gpaInput);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            double gpa = Double.parseDouble(gpaInput.getText().toString());

            Intent resultIntent = new Intent();
            resultIntent.putExtra("Họ và tên", name);
            resultIntent.putExtra("gpa", gpa);

            setResult(RESULT_OK, resultIntent);
            finish(); // End the child activity and return to the parent activity.
        });
    }
}
