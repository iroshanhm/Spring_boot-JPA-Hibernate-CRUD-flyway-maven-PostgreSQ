package com.iroshan.library.returnbook.dao;

import com.iroshan.library.returnbook.ReturnBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnBookRepo extends JpaRepository<ReturnBook, Long> {
}
