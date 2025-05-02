package repository;

import entity.User;

public class UserRepository {
    private User[] users = new User[100];
    private int count = 0;

    public void addUser(User user) {
        if (count < users.length) {
            users[count++] = user;
        }
    }

    public User getUserById(String id) {
        for (int i = 0; i < count; i++) {
            if (users[i] != null && users[i].id.equals(id)) {
                return users[i];
            }
        }
        return null;
    }

    public User[] getAllUsers() {
        User[] result = new User[count];
        System.arraycopy(users, 0, result, 0, count);
        return result;
    }

    public void deleteUser(String id) {
        for (int i = 0; i < count; i++) {
            if (users[i] != null && users[i].id.equals(id)) {
                users[i] = users[count - 1];
                users[--count] = null;
                break;
            }
        }
    }
}