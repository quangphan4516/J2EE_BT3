package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public BookService() {
        // Thêm một số sách mẫu
        books.add(new Book(nextId++, "Spring Boot in Action", "Craig Walls"));
        books.add(new Book(nextId++, "Java Programming", "James Gosling"));
    }

    // Lấy tất cả sách
    public List<Book> getAllBooks() {
        return books;
    }

    // Lấy sách theo ID
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm sách mới
    public Book addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    // Cập nhật sách
    public Book updateBook(int id, Book updatedBook) {
        Book book = getBookById(id);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return book;
        }
        return null;
    }

    // Xóa sách
    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
