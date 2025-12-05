package com.example.studentdata.viewmodel;

import com.example.studentdata.model.StudentDTO;
import com.example.studentdata.service.IStudentService;
import com.example.studentdata.util.OperationResult;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class StudentViewModel {

    private final IStudentService service;

    public final StringProperty id = new SimpleStringProperty("");
    public final StringProperty name = new SimpleStringProperty("");

    private final ObservableList<StudentDTO> studentDTOS = FXCollections.observableArrayList();

    public StudentViewModel(IStudentService service) {
        this.service = service;
        loadAll();
    }

    public ObservableList<StudentDTO> getStudents() {
        return studentDTOS;
    }

    public void loadAll() {
        List<StudentDTO> list = service.getAll();
        studentDTOS.setAll(list);
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

    public void setFromModel(StudentDTO s) {
        if (s == null) {
            id.set("");
            name.set("");
        } else {
            id.set(s.id());
            name.set(s.name());
        }
    }

    public void clearForm() {
        id.set("");
        name.set("");
    }
}
