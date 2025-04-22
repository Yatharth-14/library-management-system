package repository;

import entity.Librarian;

public class LibrarianRepository {
    private Librarian[] librarians = new Librarian[10];
    private int count = 0;

    public void addLibrarian(Librarian librarian) {
        if (count < librarians.length) {
            librarians[count++] = librarian;
        }
    }
    public boolean verifyLibrarian(String id, String password) {
        for (int i = 0; i < count; i++) {
            if (librarians[i].getId().equals(id) && librarians[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}