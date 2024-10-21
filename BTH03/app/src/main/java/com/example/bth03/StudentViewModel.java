package com.example.bth03;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends ViewModel {
    private final MutableLiveData<List<Student>> students = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Student>> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        List<Student> currentList = new ArrayList<>(students.getValue());
        currentList.add(student);
        students.setValue(currentList);
    }

    public void updateStudent(Student updatedStudent) {
        List<Student> currentList = new ArrayList<>(students.getValue());
        for (int i = 0; i < currentList.size(); i++) {
            if (currentList.get(i).getId().equals(updatedStudent.getId())) {
                currentList.set(i, updatedStudent);
                break;
            }
        }
        students.setValue(currentList);
    }

    public void removeStudent(String studentId) {
        List<Student> currentList = new ArrayList<>(students.getValue());
        currentList.removeIf(student -> student.getId().equals(studentId));
        students.setValue(currentList);
    }
}
