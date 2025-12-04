package com.example.studentdata.mapper;

import com.example.studentdata.model.Student;
import javafx.scene.control.TextField;

public class StudentMapper {
    public static Student fromFields(TextField txtId, TextField txtName) {
        return new Student(txtId.getText(), txtName.getText());
    }

    public static void toFields(Student s, TextField txtId, TextField txtName) {
        txtId.setText(s.getId());
        txtName.setText(s.getName());
    }
}