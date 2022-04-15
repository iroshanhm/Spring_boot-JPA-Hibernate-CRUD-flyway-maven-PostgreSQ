package com.iroshan.library.book.converter;

import com.iroshan.library.book.Book;
import com.iroshan.library.book.web.BookView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookViewConverter implements Converter<Book, BookView> {

    @Override
    public BookView convert(Book source) {
        BookView bookView = new BookView();
        bookView.setId(source.getId());
        bookView.setName(source.getBook_name());
        return bookView;
    }
}
