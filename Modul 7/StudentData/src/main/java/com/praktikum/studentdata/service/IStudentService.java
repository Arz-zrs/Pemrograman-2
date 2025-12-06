package com.praktikum.studentdata.service;

import com.praktikum.studentdata.util.OperationResult;
import com.praktikum.studentdata.model.StudentDTO;
import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAll();
    OperationResult add(String id, String name);
    OperationResult update(String oldId, String newId, String newName);
    OperationResult delete(String id);
}
