package com.iroshan.library.returnbook;

import com.iroshan.library.lending.Lending;
import com.iroshan.library.lending.web.LendingBaseReq;
import com.iroshan.library.lending.web.LendingView;
import com.iroshan.library.returnbook.web.ReturnBookBaseReq;
import com.iroshan.library.returnbook.web.ReturnBookView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

public interface ReturnServiceInf {
    public ReturnBook findLendingOrThrow(Long id);
    public ReturnBookView getLending(@PathVariable Long id);
    public Page<ReturnBookView> findAllLending(Pageable pageable);
    public ReturnBookView create(ReturnBookBaseReq req);
    public ReturnBookView update(ReturnBook lending, ReturnBookBaseReq req);
    ReturnBookView delete(ReturnBook returnBook, ReturnBookBaseReq req);
    ReturnBook prepareForCreate(ReturnBook returnBook, ReturnBookBaseReq req);
    ReturnBook prepareForUpdate(ReturnBook returnBook, ReturnBookBaseReq req);
    ReturnBook prepareForDelete(ReturnBook returnBook, ReturnBookBaseReq req);
}
