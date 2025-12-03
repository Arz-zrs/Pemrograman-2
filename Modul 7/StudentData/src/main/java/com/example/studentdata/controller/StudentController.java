package com.example.studentdata.controller;

import com.example.studentdata.model.Student;
import com.example.studentdata.repository.MemoryStudentRepository;
import com.example.studentdata.service.StudentService;
import com.example.studentdata.util.AlertUtils;
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

    private final StudentService service =
            new StudentService(new MemoryStudentRepository());

    private final ObservableList<Student> observableList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getId()));
        colName.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));

        tableStudent.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtId.setText(newSel.getId());
                txtName.setText(newSel.getName());
            }
        });

        refreshTable();
    }

    private void refreshTable() {
        observableList.setAll(service.getAll());
        tableStudent.setItems(observableList);
    }

    @FXML
    private void addStudent() {
        String id = txtId.getText();
        String name = txtName.getText();

        if (id.isBlank() || name.isBlank()) {
            AlertUtils.error("NIM dan Nama tidak boleh kosong!");
            return;
        }

        if (!service.addStudent(id, name)) {
            AlertUtils.error("NIM sudah digunakan atau input tidak valid.");
            return;
        }

        AlertUtils.info("Mahasiswa berhasil ditambahkan.");
        refreshTable();
    }

    @FXML
    private void updateStudent() {
        Student selected = tableStudent.getSelectionModel().getSelectedItem();
        if (selected == null) {
            AlertUtils.warning("Pilih data mahasiswa dulu.");
            return;
        }

        boolean confirm = AlertUtils.confirm("Konfirmasi Update",
                "Perbarui data mahasiswa?");
        if (!confirm) return;

        boolean success = service.updateStudent(
                selected.getId(),
                txtId.getText(),
                txtName.getText()
        );

        if (!success) {
            AlertUtils.error("Update gagal: input tidak valid atau NIM duplikat.");
            return;
        }

        AlertUtils.info("Data mahasiswa berhasil diperbarui.");
        refreshTable();
    }

    @FXML
    private void deleteStudent() {
        Student selected = tableStudent.getSelectionModel().getSelectedItem();
        if (selected == null) {
            AlertUtils.warning("Pilih data mahasiswa dulu.");
            return;
        }

        boolean confirm = AlertUtils.confirm("Konfirmasi Hapus",
                "Yakin ingin menghapus mahasiswa ini?");
        if (!confirm) return;

        if (!service.deleteStudent(selected.getId())) {
            AlertUtils.error("Gagal menghapus: data tidak ditemukan.");
            return;
        }

        AlertUtils.info("Mahasiswa berhasil dihapus.");
        refreshTable();
    }
}
