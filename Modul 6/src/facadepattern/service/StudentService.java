package facadepattern.service;

import facadepattern.data.DataManager;

public class StudentService {
    private final DataManager data;

    public StudentService(DataManager data) {
        this.data = data;
    }

    public void insertData(String name, String id) {
        data.insertData(name, id);
    }

    public void removeData(String id) {
        data.removeData(id);
    }

    public void searchData(String id) {
        data.findData(id);
    }

    public void displayAllData() {
        data.displayAllData();
    }
}