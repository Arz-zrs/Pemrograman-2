package com.example.studentdata.controller;

import com.example.studentdata.mapper.StudentMapper;
import com.example.studentdata.model.Student;
import com.example.studentdata.service.StudentService;
import com.example.studentdata.ui.Feedback;
import com.example.studentdata.util.OperationResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {

    @FXML private TableView<Student> tableStudent;
    @FXML private TableColumn<Student, String> colId;
    @FXML private TableColumn<Student, String> colName;

    @FXML private TextField txtId;
    @FXML private TextField txtName;

    private final ObservableList<Student> observableList =
            FXCollections.observableArrayList();

    private StudentService service;
    private Feedback feedback;

    public void setDependencies(StudentService service, Feedback feedback) {
        this.service = service;
        this.feedback = feedback;
        refreshTable();
    }

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getId()));
        colName.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));

        tableStudent.getSelectionModel().selectedItemProperty().addListener((_, _, newSel) -> {
            if (newSel != null)
                StudentMapper.toFields(newSel, txtId, txtName);
        });
    }

    private void refreshTable() {
        observableList.setAll(service.getAll());
        tableStudent.setItems(observableList);
    }

    @FXML
    private void addStudent() {
        Student form = StudentMapper.fromFields(txtId, txtName);
        OperationResult result = service.add(form.getId(), form.getName());

        if (result.isFailed()) {
            feedback.error(result.getMessage());
            return;
        }

        feedback.info(result.getMessage());
        refreshTable();
    }

    @FXML
    private void updateStudent() {
        Student selected = tableStudent.getSelectionModel().getSelectedItem();
        if (selected == null) {
            feedback.warning("Pilih data mahasiswa dulu.");
            return;
        }

        if (feedback.isCancelled("Konfirmasi Update", "Perbarui data mahasiswa?"))
            return;

        OperationResult result = service.update(
                selected.getId(),
                txtId.getText(),
                txtName.getText()
        );

        if (result.isFailed()) {
            feedback.error(result.getMessage());
            return;
        }

        feedback.info(result.getMessage());
        refreshTable();
    }

    @FXML
    private void deleteStudent() {
        Student selected = tableStudent.getSelectionModel().getSelectedItem();
        if (selected == null) {
            feedback.warning("Pilih data dulu.");
            return;
        }

        if (feedback.isCancelled("Konfirmasi Hapus", "Yakin ingin menghapus mahasiswa ini?"))
            return;

        OperationResult result = service.delete(selected.getId());

        if (result.isFailed()) {
            feedback.error(result.getMessage());
            return;
        }

        feedback.info(result.getMessage());
        refreshTable();
    }
}
