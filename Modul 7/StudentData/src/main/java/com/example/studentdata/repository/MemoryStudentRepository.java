package com.example.studentdata.repository;

import com.example.studentdata.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MemoryStudentRepository implements StudentRepository {

    private final List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAll() {
        return List.copyOf(students);
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void update(String oldId, String newId, String newName) {
        for (Student s : students) {
            if (s.getId().equals(oldId)) {
                s.setId(newId);
                s.setName(newName);
                return;
            }
        }
    }

    @Override
    public boolean delete(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public boolean exists(String id) {
        return students.stream().anyMatch(s -> s.getId().equals(id));
    }
}
