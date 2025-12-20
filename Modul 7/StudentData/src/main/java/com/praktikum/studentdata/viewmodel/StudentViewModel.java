package com.praktikum.studentdata.viewmodel;

import com.praktikum.studentdata.model.StudentData;
import com.praktikum.studentdata.service.IStudentService;
import com.praktikum.studentdata.util.OperationResult;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class StudentViewModel {

    private final IStudentService service;

    private final StringProperty id = new SimpleStringProperty("");
    private final StringProperty name = new SimpleStringProperty("");

    private final ObservableList<StudentData> studentData = FXCollections.observableArrayList();

    public StudentViewModel(IStudentService service) {
        this.service = service;
    }

    public ObservableList<StudentData> getStudents() {
        return studentData;
    }

    public void loadAll() {
        List<StudentData> list = service.getAll();
        studentData.setAll(list);
    }

    public OperationResult add() {
        return service.add(id.get(), name.get());
    }

    public OperationResult update(String oldId) {
        return service.update(oldId, id.get(), name.get());
    }

    public OperationResult delete(String idToDelete) {
        return service.delete(idToDelete);
    }

    public void setFromModel(StudentData s) {
        if (s == null) {
            clearForm();
        } else {
            id.set(s.getId());
            name.set(s.getName());
        }
    }

    public void clearForm() {
        id.set("");
        name.set("");
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }
}
