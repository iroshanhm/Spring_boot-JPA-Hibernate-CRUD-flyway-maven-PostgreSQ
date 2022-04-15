package com.iroshan.library.lending;

import com.iroshan.library.lending.web.LendingBaseReq;
import com.iroshan.library.lending.web.LendingView;
import com.iroshan.library.publisher.Publisher;
import com.iroshan.library.publisher.web.PublisherBaseReq;
import com.iroshan.library.publisher.web.PublisherView;
import com.iroshan.library.returnbook.ReturnBook;
import com.iroshan.library.returnbook.web.ReturnBookBaseReq;
import com.iroshan.library.returnbook.web.ReturnBookView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

public interface LendingServiceInf {
    Lending findLendingOrThrow(Long id);
    LendingView getLending(@PathVariable Long id);
    Page<LendingView> findAllLending(Pageable pageable);
    LendingView create(LendingBaseReq req);
    LendingView update(Lending lending, LendingBaseReq req);
    LendingView delete(Lending lending, LendingBaseReq req);
    Lending prepareForCreate(Lending lending, LendingBaseReq req);
    Lending prepareForUpdate(Lending lending, LendingBaseReq req);
    Lending prepareForDelete(Lending lending, LendingBaseReq req);
}
