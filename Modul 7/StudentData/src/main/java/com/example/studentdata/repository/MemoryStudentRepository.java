package com.example.studentdata.repository;

import com.example.studentdata.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class MemoryStudentRepository implements StudentRepository {

    private final List<StudentDTO> studentDTOS = new ArrayList<>();

    @Override
    public List<StudentDTO> getAll() {
        return List.copyOf(studentDTOS);
    }

    @Override
    public void save(StudentDTO studentDTO) {
        studentDTOS.add(studentDTO);
    }

    @Override
    public void update(String oldId, String newId, String newName) {
        for (StudentDTO s : studentDTOS) {
            if (s.getId().equals(oldId)) {
                s.setId(newId);
                s.setName(newName);
                return;
            }
        }
    }

    @Override
    public boolean delete(String id) {
        return studentDTOS.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public boolean exists(String id) {
        return studentDTOS.stream().anyMatch(s -> s.getId().equals(id));
    }
}
