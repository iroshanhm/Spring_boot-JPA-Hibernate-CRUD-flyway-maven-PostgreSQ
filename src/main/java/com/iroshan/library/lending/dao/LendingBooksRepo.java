package com.iroshan.library.lending.dao;

import com.iroshan.library.lending.Lending;
import com.iroshan.library.lending.LendingBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LendingBooksRepo extends JpaRepository<LendingBooks, Long> {

    @Transactional
    List<LendingBooks> deleteAllByLending(Lending lending);

}
