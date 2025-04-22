package service;

import entity.User;
import repository.UserRepository;

public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void registerUser(User user) {
        userRepo.addUser(user);
    }

    public User getUserById(String id) {
        return userRepo.getUserById(id);
    }

    public User[] getAllUsers() {
        return userRepo.getAllUsers();
    }

    public void deleteUser(String id) {
        userRepo.deleteUser(id);
    }
}
