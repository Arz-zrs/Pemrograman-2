package com.example.studentdata.service;

import com.example.studentdata.model.Student;
import com.example.studentdata.repository.StudentRepository;
import com.example.studentdata.util.OperationResult;
import com.example.studentdata.validation.StudentValidator;

import java.util.List;

public class StudentService {

    private final StudentRepository repository;
    private final StudentValidator validator;

    public StudentService(StudentRepository repository, StudentValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public List<Student> getAll() {
        return repository.getAll();
    }

    public OperationResult add(String id, String name) {
        String error = validator.validate(id, name);
        if (error != null)
            return OperationResult.fail(error);

        if (repository.exists(id))
            return OperationResult.fail("NIM sudah digunakan.");

        repository.save(new Student(id, name));
        return OperationResult.success("Mahasiswa berhasil ditambahkan.");
    }

    public OperationResult update(String oldId, String newId, String newName) {
        String error = validator.validate(newId, newName);
        if (error != null)
            return OperationResult.fail(error);

        if (!repository.exists(oldId))
            return OperationResult.fail("Data tidak ditemukan.");

        if (!oldId.equals(newId) && repository.exists(newId))
            return OperationResult.fail("NIM baru sudah digunakan.");

        repository.update(oldId, newId, newName);
        return OperationResult.success("Data mahasiswa berhasil diperbarui.");
    }

    public OperationResult delete(String id) {
        if (!repository.delete(id))
            return OperationResult.fail("Data tidak ditemukan.");

        return OperationResult.success("Data mahasiswa berhasil dihapus.");
    }
}
