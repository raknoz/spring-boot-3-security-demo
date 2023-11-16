package com.example.demo.servicies;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.requests.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repository;

  public void save(BookRequest request) {
    var book = Book.builder()
        .id(request.getId())
        .author(request.getAuthor())
        .isbn(request.getIsbn())
        .build();
    repository.save(book);
  }

  public List<Book> findAll() {
    return repository.findAll();
  }
}
