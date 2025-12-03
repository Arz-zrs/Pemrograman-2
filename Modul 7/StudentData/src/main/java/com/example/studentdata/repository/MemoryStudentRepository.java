package com.example.studentdata.repository;

import com.example.studentdata.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryStudentRepository implements StudentRepository {
    private final List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAll() {
        return List.copyOf(students);
    }

    @Override
    public boolean add(Student student) {
        if (students.stream().
                anyMatch(s -> s.getId().equals(student.getId()))
        ) return false;
        return students.add(student);
    }

    @Override
    public boolean update(String oldId, Student updated) {
        Optional<Student> target = students.stream()
                .filter(s -> s.getId().equals(oldId))
                .findFirst();

        if (target.isEmpty()) return false;

        boolean hasDuplicate = students.stream()
                .anyMatch(s -> s.getId().equals(updated.getId()) && !s.getId().equals(oldId));

        if (!hasDuplicate) {
            Student s = target.get();
            s.setId(updated.getId());
            s.setName(updated.getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }
}