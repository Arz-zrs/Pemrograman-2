package com.praktikum.studentdata.service;

import com.praktikum.studentdata.model.StudentDTO;
import com.praktikum.studentdata.repository.StudentRepository;
import com.praktikum.studentdata.util.OperationResult;
import com.praktikum.studentdata.validation.StudentValidator;

import java.util.List;

public class StudentService implements IStudentService {

    private final StudentRepository repository;
    private final StudentValidator validator;

    public StudentService(StudentRepository repository, StudentValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<StudentDTO> getAll() {
        return repository.getAll();
    }

    @Override
    public OperationResult add(String id, String name) {
        String error = validator.validate(id, name);
        if (error != null)
            return OperationResult.fail(error);

        if (repository.exists(id))
            return OperationResult.fail("NIM sudah digunakan.");

        repository.add(new StudentDTO(id, name));
        return OperationResult.success("Mahasiswa berhasil ditambahkan.");
    }

    @Override
    public OperationResult update(String oldId, String newId, String newName) {
        String error = validator.validate(newId, newName);
        if (error != null)
            return OperationResult.fail(error);

        if (!repository.exists(oldId))
            return OperationResult.fail("Data tidak ditemukan.");

        if (!oldId.equals(newId) && repository.exists(newId))
            return OperationResult.fail("NIM sudah digunakan.");

        repository.update(oldId, newId, newName);
        return OperationResult.success("Data mahasiswa berhasil diperbarui.");
    }

    @Override
    public OperationResult delete(String id) {
        if (!repository.delete(id))
            return OperationResult.fail("Data tidak ditemukan.");

        return OperationResult.success("Data mahasiswa berhasil dihapus.");
    }
}
