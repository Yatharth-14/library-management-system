package service;

import entity.Librarian;
import repository.LibrarianRepository;

public class LibrarianService {
    private LibrarianRepository librarianRepo;

    public LibrarianService(LibrarianRepository librarianRepo) {
        this.librarianRepo = librarianRepo;
    }

    public boolean login(String id, String password) {
        return librarianRepo.verifyLibrarian(id, password);
    }

    public void addLibrarian(Librarian librarian) {
        librarianRepo.addLibrarian(librarian);
    }
}