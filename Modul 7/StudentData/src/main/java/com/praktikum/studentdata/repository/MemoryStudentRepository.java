package com.praktikum.studentdata.repository;

import com.praktikum.studentdata.model.StudentData;

import java.util.ArrayList;
import java.util.List;

public class MemoryStudentRepository implements StudentRepository {

    private final List<StudentData> studentData = new ArrayList<>();

    @Override
    public List<StudentData> getAll() {
        return List.copyOf(studentData);
    }

    @Override
    public void add(StudentData data) {
        studentData.add(data);
    }

    @Override
    public void update(String oldId, String newId, String newName) {
        for (int i = 0; i < studentData.size(); i++) {
            StudentData s = studentData.get(i);
            if (s.getId().equals(oldId)) {
                StudentData newStudentData = new StudentData(newId, newName);
                studentData.set(i, newStudentData);
                return;
            }
        }
    }

    @Override
    public boolean delete(String id) {
        return studentData.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public boolean exists(String id) {
        return studentData.stream().anyMatch(s -> s.getId().equals(id));
    }
}
