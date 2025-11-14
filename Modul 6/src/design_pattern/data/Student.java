package design_pattern.data;

public class Student {
    private final String name;
    private final String id;

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