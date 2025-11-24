package commandpattern.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class DataManager {
    private final ArrayList<Student> studentList = new ArrayList<>();

    public boolean insertData(String name, String id) {
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                return false;
            }
        }
        studentList.add(new Student(name, id));
        return true;
    }

    public boolean removeData(String id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Optional<Student> findData(String id) {
        return studentList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public List<Student> displayAllData() {
        return List.copyOf(studentList);
    }
}