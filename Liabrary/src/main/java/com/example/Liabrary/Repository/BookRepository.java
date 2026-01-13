package com.example.Liabrary.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Liabrary.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}