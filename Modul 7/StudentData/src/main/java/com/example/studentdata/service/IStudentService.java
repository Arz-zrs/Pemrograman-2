package com.example.studentdata.service;

import com.example.studentdata.util.OperationResult;
import com.example.studentdata.dto.StudentDTO;
import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAll();
    OperationResult add(String id, String name);
    OperationResult update(String oldId, String newId, String newName);
    OperationResult delete(String id);
}
