package com.example.studentdata.controller;

import com.example.studentdata.dto.StudentDTO;
import com.example.studentdata.ui.Feedback;
import com.example.studentdata.util.OperationResult;
import com.example.studentdata.viewmodel.StudentViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {

    @FXML private TableView<StudentDTO> tableStudent;
    @FXML private TableColumn<StudentDTO, String> colId;
    @FXML private TableColumn<StudentDTO, String> colName;

    @FXML private TextField txtId;
    @FXML private TextField txtName;

    private StudentViewModel viewModel;
    private Feedback feedback;

    public void setDependencies(StudentViewModel viewModel, Feedback feedback) {
        this.viewModel = viewModel;
        this.feedback = feedback;

        tableStudent.setItems(viewModel.getStudents());
        txtId.textProperty().bindBidirectional(viewModel.id);
        txtName.textProperty().bindBidirectional(viewModel.name);

        tableStudent.getSelectionModel().selectedItemProperty()
                .addListener((_, _, newSel)
                        -> viewModel.setFromModel(newSel));

        viewModel.loadAll();
    }

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        colName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
    }

    @FXML
    private void addStudent() {
        OperationResult r = viewModel.add();
        if (r.isFailed()) {
            feedback.error(r.message());
            return;
        }
        feedback.info(r.message());
        viewModel.loadAll();
        viewModel.clearForm();
    }

    @FXML
    private void updateStudent() {
        StudentDTO selected = tableStudent.getSelectionModel().getSelectedItem();
        if (selected == null) {
            feedback.warning("Pilih data mahasiswa dulu.");
            return;
        }

        if (feedback.isCancelled("Konfirmasi Update", "Perbarui data mahasiswa?")) {
            return;
        }

        OperationResult r = viewModel.update(selected.getId());
        if (r.isFailed()) {
            feedback.error(r.message());
            return;
        }
        feedback.info(r.message());
        viewModel.loadAll();
        viewModel.clearForm();
    }

    @FXML
    private void deleteStudent() {
        StudentDTO selected = tableStudent.getSelectionModel().getSelectedItem();
        if (selected == null) {
            feedback.warning("Pilih data mahasiswa dulu.");
            return;
        }

        if (feedback.isCancelled("Konfirmasi Hapus", "Yakin ingin menghapus mahasiswa ini?")) {
            return;
        }

        OperationResult r = viewModel.delete(selected.getId());
        if (r.isFailed()) {
            feedback.error(r.message());
            return;
        }
        feedback.info(r.message());
        viewModel.loadAll();
        viewModel.clearForm();
    }
}
