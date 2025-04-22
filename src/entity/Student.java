package entity;

public class Student extends User {
    private String section;

    public Student(String name, String id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void showUserInfo() {
        System.out.println("Student Name: " + name + ", ID: " + id + ", Section: " + section);
    }
}