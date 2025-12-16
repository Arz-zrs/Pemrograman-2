package com.praktikum.studentdata.controller;

import com.praktikum.studentdata.model.StudentData;
import com.praktikum.studentdata.manager.IAppManager;
import com.praktikum.studentdata.ui.Feedback;
import com.praktikum.studentdata.util.OperationResult;
import com.praktikum.studentdata.viewmodel.StudentViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {

    @FXML private TableView<StudentData> tableStudent;
    @FXML private TableColumn<StudentData, String> colId;
    @FXML private TableColumn<StudentData, String> colName;

    @FXML private TextField txtId;
    @FXML private TextField txtName;

    private StudentViewModel viewModel;
    private Feedback feedback;
    private IAppManager app;

    public void setDependencies(StudentViewModel viewModel, Feedback feedback, IAppManager app) {
        this.viewModel = viewModel;
        this.feedback = feedback;
        this.app = app;

        tableStudent.setItems(viewModel.getStudents());
        txtId.textProperty().bindBidirectional(viewModel.idProperty());
        txtName.textProperty().bindBidirectional(viewModel.nameProperty());

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
        OperationResult res = viewModel.add();
        if (res.isFailed()) {
            feedback.error(res.message());
            return;
        }
        feedback.info(res.message());
        viewModel.loadAll();
        viewModel.clearForm();
    }

    @FXML
    private void updateStudent() {
        StudentData selected = tableStudent.getSelectionModel().getSelectedItem();
        if (selected == null) {
            feedback.warning("Pilih data mahasiswa dulu.");
            return;
        }

        if (feedback.isCancelled("Konfirmasi Update", "Perbarui data " + selected.getDisplayInfo() + "?")) {
            return;
        }

        OperationResult res = viewModel.update(selected.getId());
        if (res.isFailed()) {
            feedback.error(res.message());
            return;
        }
        feedback.info(res.message());
        viewModel.loadAll();
        viewModel.clearForm();
    }

    @FXML
    private void deleteStudent() {
        StudentData selected = tableStudent.getSelectionModel().getSelectedItem();
        if (selected == null) {
            feedback.warning("Pilih data mahasiswa dulu.");
            return;
        }

        if (feedback.isCancelled("Konfirmasi Hapus", "Yakin ingin menghapus " + selected.getDisplayInfo() + "?")) {
            return;
        }

        OperationResult res = viewModel.delete(selected.getId());
        if (res.isFailed()) {
            feedback.error(res.message());
            return;
        }
        feedback.info(res.message());
        viewModel.loadAll();
        viewModel.clearForm();
    }

    @FXML
    public void exitProgram() {
        app.close();
    }
}
