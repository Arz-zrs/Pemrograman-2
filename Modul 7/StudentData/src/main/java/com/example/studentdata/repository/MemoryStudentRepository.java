package com.example.studentdata.repository;

import com.example.studentdata.model.StudentDTO;

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
        for (int i = 0; i < studentDTOS.size(); i++) {
            StudentDTO s = studentDTOS.get(i);
            if (s.id().equals(oldId)) {
                StudentDTO newVersion = new StudentDTO(newId, newName);
                studentDTOS.set(i, newVersion);
                return;
            }
        }
    }

    @Override
    public boolean delete(String id) {
        return studentDTOS.removeIf(s -> s.id().equals(id));
    }

    @Override
    public boolean exists(String id) {
        return studentDTOS.stream().anyMatch(s -> s.id().equals(id));
    }
}
