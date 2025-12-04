package com.example.studentdata.mapper;

import com.example.studentdata.model.Student;
import javafx.scene.control.TextField;
import java.util.Objects;

public class StudentMapper {
    public Student fromFields(TextField txtId, TextField txtName) {
        String id = txtId == null ? null : txtId.getText();
        String name = txtName == null ? null : txtName.getText();
        return new Student(id, name);
    }

    public void toFields(Student s, TextField txtId, TextField txtName) {
        if (s == null) {
            if (txtId != null) txtId.clear();
            if (txtName != null) txtName.clear();
            return;
        }
        if (txtId != null) txtId.setText(Objects.toString(s.getId(), ""));
        if (txtName != null) txtName.setText(Objects.toString(s.getName(), ""));
    }
}