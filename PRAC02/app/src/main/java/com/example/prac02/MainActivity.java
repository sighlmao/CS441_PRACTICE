package com.example.prac02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etStaffId = findViewById(R.id.etStaffId);
        EditText etFullName = findViewById(R.id.etFullName);
        EditText etBirthDate = findViewById(R.id.etBirthDate);
        EditText etSalary = findViewById(R.id.etSalary);
        Button btnAddEmployee = findViewById(R.id.btnAddEmployee);
        TextView tvResults = findViewById(R.id.tvResults);

        // Initialize the ViewModel
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        // Observe changes in the employee list
        employeeViewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                if (employees.isEmpty()) {
                    tvResults.setText("No Result!");
                } else {
                    StringBuilder result = new StringBuilder();
                    for (Employee employee : employees) {
                        result.append(employee.getId())
                                .append("-")
                                .append(employee.getName())
                                .append("-")
                                .append(employee.getBirthDate())
                                .append("-")
                                .append(employee.getSalary())
                                .append("\n");
                    }
                    tvResults.setText(result.toString());
                }
            }
        });

        // Add a new employee when the button is clicked
        btnAddEmployee.setOnClickListener(v -> {
            String id = etStaffId.getText().toString();
            String name = etFullName.getText().toString();
            String birthDate = etBirthDate.getText().toString();
            double salary = Double.parseDouble(etSalary.getText().toString());

            Employee newEmployee = new Employee(id, name, birthDate, salary);
            employeeViewModel.addEmployee(newEmployee);

            // Clear the input fields
            etStaffId.setText("");
            etFullName.setText("");
            etBirthDate.setText("");
            etSalary.setText("");
        });
    }
}
