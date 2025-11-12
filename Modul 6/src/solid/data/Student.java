package solid.data;

public class Student {
    private String name;
    private String id;

    public Student(String name, String ID) {
        this.name = name;
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}