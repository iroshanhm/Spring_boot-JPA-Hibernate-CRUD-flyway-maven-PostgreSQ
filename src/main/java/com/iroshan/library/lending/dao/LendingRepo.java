package com.iroshan.library.lending.dao;

import com.iroshan.library.lending.Lending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingRepo extends JpaRepository<Lending, Long> {
}
