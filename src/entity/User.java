package entity;

public abstract class User {
    public String name;
    public String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract void showUserInfo();
}