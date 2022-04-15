package com.iroshan.library.lending.converter;

import com.iroshan.library.lending.Lending;
import com.iroshan.library.lending.LendingBooks;
import com.iroshan.library.lending.web.LendingView;
import com.iroshan.library.publisher.Publisher;
import com.iroshan.library.publisher.web.PublisherView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Component
public class LendingToLendingViewConverter implements Converter<Lending, LendingView> {
    @Override
    public LendingView convert(Lending source) {
        LendingView lendingView = new LendingView();

        lendingView.setId(source.getId());
        lendingView.setLendingBooks(source.getLendingBooks());
        lendingView.setMember_id(source.getMember_id());
        lendingView.setLendingDate(source.getLendingDate());

        lendingView.setCreatedBy(source.getCreatedBy());
        lendingView.setCreatedOn(source.getCreatedOn());
        lendingView.setUpdatedBy(source.getUpdatedBy());
        lendingView.setUpdatedOn(source.getUpdatedOn());
        lendingView.setIsRemove(source.getIsRemove());
        lendingView.setRemoveBy(source.getRemoveBy());
        lendingView.setRemoveOn(source.getRemoveOn());

//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println(source.getMember_id());
//        lendingView.getLendingBooks().forEach(lendingBooks->{
//            System.out.println(lendingBooks.getBook_id());
//        });
//        System.out.println("-----------------------------------------------------------------------------------------");

        return lendingView;
    }
}
