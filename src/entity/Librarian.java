package entity;

public class Librarian {
    private String name;
    private String id;
    private String password;

    public Librarian(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
