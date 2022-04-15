package com.iroshan.library.returnbook;

import com.iroshan.library.error.EntityNotFoundException;
import com.iroshan.library.lending.Lending;
import com.iroshan.library.lending.converter.LendingToLendingViewConverter;
import com.iroshan.library.lending.dao.LendingBooksRepo;
import com.iroshan.library.lending.dao.LendingRepo;
import com.iroshan.library.lending.web.LendingView;
import com.iroshan.library.returnbook.converter.ReturnBookToReturnBookViewConverter;
import com.iroshan.library.returnbook.dao.ReturnBookRepo;
import com.iroshan.library.returnbook.web.ReturnBookBaseReq;
import com.iroshan.library.returnbook.web.ReturnBookView;
import com.iroshan.library.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReturnServiceImpl implements ReturnServiceInf{

    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private ReturnBookRepo returnBookRepo;
    @Autowired
    LendingRepo lendingRepo;
    @Autowired
    private ReturnBookToReturnBookViewConverter returnBookToReturnBookViewConverter;

    @Override
    public ReturnBook findLendingOrThrow(Long id) {
        return returnBookRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("return_book.NotFound", id)));
    }

    @Override
    public ReturnBookView getLending(Long id) {
        ReturnBook returnBook =   findLendingOrThrow(id);
        return returnBookToReturnBookViewConverter.convert(returnBook);
    }

    @Override
    public Page<ReturnBookView> findAllLending(Pageable pageable) {
        Page<ReturnBook> returnBooks = returnBookRepo.findAll(pageable);
        List<ReturnBookView> returnBookViews = new ArrayList<>();
        returnBooks.forEach(returnBook -> {
            ReturnBookView returnBookView = returnBookToReturnBookViewConverter.convert(returnBook);
            returnBookViews.add(returnBookView);
        });
        return new PageImpl<>(returnBookViews, pageable, returnBooks.getTotalElements());
    }

    @Override
    public ReturnBookView create(ReturnBookBaseReq req) {
        ReturnBook returnBook = new ReturnBook();
        this.prepareForCreate(returnBook,req);
        ReturnBook returnBookSave = returnBookRepo.save(returnBook);
        return returnBookToReturnBookViewConverter.convert(returnBookSave);
    }

    @Override
    public ReturnBookView update(ReturnBook returnBook, ReturnBookBaseReq req) {
        ReturnBook newReturnBook = this.prepareForUpdate(returnBook, req);
        ReturnBook returnBookSaved = returnBookRepo.save(newReturnBook);
        return returnBookToReturnBookViewConverter.convert(returnBookSaved);
    }

    @Override
    public ReturnBookView delete(ReturnBook returnBook, ReturnBookBaseReq req) {
        try {
            ReturnBook newReturnBook = this.prepareForDelete(returnBook, req);
            ReturnBook returnBookSaved = returnBookRepo.save(newReturnBook);
            return returnBookToReturnBookViewConverter.convert(returnBookSaved);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(messageUtil.getMessage("return_book.NotFound", returnBook.getId()));
        }
    }
//    delete(returnBook, req);

    @Override
    public ReturnBook prepareForCreate(ReturnBook returnBook, ReturnBookBaseReq req) {
//        .findById(id).get()
        returnBook.setLending(lendingRepo.findById(req.getLending_id()).get());
        returnBook.setCreatedBy(req.getCreatedBy());
        returnBook.setCreatedOn(req.getCreatedOn());
        return returnBook;
    }

    @Override
    public ReturnBook prepareForUpdate(ReturnBook returnBook, ReturnBookBaseReq req) {
//        returnBook.setId(req.getId());
        returnBook.setLending(lendingRepo.findById(req.getLending_id()).get());
//        returnBook.setCreatedBy(req.getCreatedBy());
//        returnBook.setCreatedOn(req.getCreatedOn());
        returnBook.setUpdatedBy(req.getUpdatedBy());
        returnBook.setUpdatedOn(req.getUpdatedOn());
        returnBook.setIsRemove(req.getIsRemove());
        returnBook.setRemoveBy(req.getRemoveBy());
        returnBook.setRemoveOn(req.getRemoveOn());
        return returnBook;
    }

    @Override
    public ReturnBook prepareForDelete(ReturnBook returnBook, ReturnBookBaseReq req) {
//        returnBook.setId(req.getId());
//        returnBook.setLending(lendingRepo.findById(req.getLending_id()).get());
//        returnBook.setCreatedBy(req.getCreatedBy());
//        returnBook.setCreatedOn(req.getCreatedOn());
//        returnBook.setUpdatedBy(req.getUpdatedBy());
//        returnBook.setUpdatedOn(req.getUpdatedOn());
        returnBook.setIsRemove(1);
        returnBook.setRemoveBy(req.getRemoveBy());
        returnBook.setRemoveOn(req.getRemoveOn());
        return returnBook;
    }
}
