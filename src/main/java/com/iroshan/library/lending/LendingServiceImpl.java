package com.iroshan.library.lending;

import com.iroshan.library.error.EntityNotFoundException;
import com.iroshan.library.lending.converter.LendingToLendingViewConverter;
import com.iroshan.library.lending.dao.LendingBooksRepo;
import com.iroshan.library.lending.dao.LendingRepo;
import com.iroshan.library.lending.web.LendingBaseReq;
import com.iroshan.library.lending.web.LendingView;
import com.iroshan.library.returnbook.web.ReturnBookBaseReq;
import com.iroshan.library.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class LendingServiceImpl implements LendingServiceInf{

    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private LendingRepo lendRepo;
    @Autowired
    private LendingBooksRepo lendingBooksRepo;
    @Autowired
    private LendingToLendingViewConverter lendingToLendingViewConverter;

    @Override
    public Lending findLendingOrThrow(Long id) {
        return lendRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("lending.NotFound", id)));
    }



    @Override
    public LendingView getLending(@PathVariable Long id){
        Lending lending =   findLendingOrThrow(id);
        return lendingToLendingViewConverter.convert(lending);
    }

    @Override
    public Page<LendingView> findAllLending(Pageable pageable) {
        Page<Lending> lendings = lendRepo.findAll(pageable);
        List<LendingView> lendingViews = new ArrayList<>();
        lendings.forEach(lending -> {
            LendingView lendingView = lendingToLendingViewConverter.convert(lending);
            lendingViews.add(lendingView);
        });
        return new PageImpl<>(lendingViews, pageable, lendings.getTotalElements());
    }

    @Override
    public LendingView create(LendingBaseReq req) {
        Lending lending = new Lending();
        this.prepareForCreate(lending,req);
        Lending lendingSave = lendRepo.save(lending);
        return lendingToLendingViewConverter.convert(lendingSave);
    }

    @Override
    public LendingView update(Lending lending, LendingBaseReq req) {
        Lending newLending = this.prepareForUpdate(lending, req);
        lendingBooksRepo.deleteAllByLending(newLending);
        Lending lendingSave = lendRepo.save(newLending);
        return lendingToLendingViewConverter.convert(lendingSave);
    }


    @Override
    public LendingView delete(Lending lending, LendingBaseReq req) {
        try {
            Lending newLending = this.prepareForDelete(lending, req);
            Lending lendingSave =lendRepo.save(newLending);
            return lendingToLendingViewConverter.convert(lendingSave);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(messageUtil.getMessage("lending.NotFound", lending.getId()));
        }
    }



    @Override
    public Lending prepareForCreate(Lending lending, LendingBaseReq req) {
        List lendingBooksList = new ArrayList();
        lending.setMember_id(req.getMember_id());
        lending.setLendingDate(req.getLendingDate());
        lending.setCreatedBy(req.getCreatedBy());
        lending.setCreatedOn(req.getCreatedOn());
        req.getLendingBooks().forEach(lendingBooksBaseReq->{
            LendingBooks lendingBooks = new LendingBooks();
            lendingBooks.setBook_ISBN(lendingBooksBaseReq.getBook_ISBN());
            lendingBooks.setBook_tag(lendingBooksBaseReq.getBook_tag());
            lendingBooks.setLending(lending);
            lendingBooksList.add(lendingBooks);
        });
        lending.setLendingBooks(lendingBooksList);
        return lending;
    }

    @Override
    public Lending prepareForUpdate(Lending lending, LendingBaseReq req) {
        List lendingBooksList = new ArrayList();
        lending.setId(req.getId());
        lending.setMember_id(req.getMember_id());
//        lending.setLendingDate(req.getLendingDate());
        lending.setUpdatedBy(req.getUpdatedBy());
        lending.setUpdatedOn(req.getUpdatedOn());
        req.getLendingBooks().forEach(lendingBooksBaseReq->{
            LendingBooks lendingBooks = new LendingBooks();
            lendingBooks.setBook_ISBN(lendingBooksBaseReq.getBook_ISBN());
            lendingBooks.setBook_tag(lendingBooksBaseReq.getBook_tag());
            lendingBooks.setLending(lending);
            lendingBooksList.add(lendingBooks);
        });
        lending.setLendingBooks(lendingBooksList);
        return lending;
    }


    @Override
    public Lending prepareForDelete(Lending lending, LendingBaseReq req) {
        lending.setIsRemove(1);
        lending.setRemoveBy(req.getRemoveBy());
        lending.setRemoveOn(req.getRemoveOn());
        return lending;
    }

}
