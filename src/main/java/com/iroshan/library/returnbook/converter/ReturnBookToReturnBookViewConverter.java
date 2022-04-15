package com.iroshan.library.returnbook.converter;

import com.iroshan.library.lending.Lending;
import com.iroshan.library.lending.web.LendingView;
import com.iroshan.library.returnbook.ReturnBook;
import com.iroshan.library.returnbook.web.ReturnBookView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReturnBookToReturnBookViewConverter implements Converter<ReturnBook, ReturnBookView> {
    @Override
    public ReturnBookView convert(ReturnBook source) {
        ReturnBookView returnBookView = new ReturnBookView();

        returnBookView.setId(source.getId());
        returnBookView.setReturnDate(source.getReturnDate());
        returnBookView.setIsRemove(source.getIsRemove());
        returnBookView.setLending(source.getLending());

        returnBookView.setCreatedBy(source.getCreatedBy());
        returnBookView.setCreatedOn(source.getCreatedOn());
        returnBookView.setUpdatedBy(source.getUpdatedBy());
        returnBookView.setUpdatedOn(source.getUpdatedOn());
        returnBookView.setIsRemove(source.getIsRemove());
        returnBookView.setRemoveBy(source.getRemoveBy());
        returnBookView.setRemoveOn(source.getRemoveOn());

        return returnBookView;
    }

}
