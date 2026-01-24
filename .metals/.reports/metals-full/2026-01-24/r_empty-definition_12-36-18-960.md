error id: file:///C:/Projects/LearnJava/Liabrary/src/main/java/com/example/Liabrary/Controller/BookController.java:java/lang/Long#
file:///C:/Projects/LearnJava/Liabrary/src/main/java/com/example/Liabrary/Controller/BookController.java
empty definition using pc, found symbol in pc: java/lang/Long#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1370
uri: file:///C:/Projects/LearnJava/Liabrary/src/main/java/com/example/Liabrary/Controller/BookController.java
text:
```scala
package com.example.Liabrary.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Liabrary.Entity.Book;
import com.example.Liabrary.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        // return bookService.addBook(book);
        return ResponseEntity.status(201).body("Book created");
    }

    // READ ALL
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Book getBook(@PathVariable @@Long id) {
        return bookService.getBookById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
            @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Long#