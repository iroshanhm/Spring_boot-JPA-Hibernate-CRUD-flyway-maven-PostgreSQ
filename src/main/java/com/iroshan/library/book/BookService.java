package com.iroshan.library.book;

import com.iroshan.library.author.Author;
import com.iroshan.library.book.converter.BookToBookViewConverter;
import com.iroshan.library.book.web.BookBaseReq;
import com.iroshan.library.book.web.BookView;
import com.iroshan.library.error.EntityNotFoundException;
import com.iroshan.library.publisher.Publisher;
import com.iroshan.library.util.MessageUtil;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    private final MessageUtil messageUtil;
    private final BookRepo bookRepo;
    private final BookToBookViewConverter bookToBookViewConverter;

    public BookService(BookRepo bookRepo, MessageUtil messageUtil, BookToBookViewConverter bookToBookViewConverter) {
        this.bookRepo = bookRepo;
        this.messageUtil = messageUtil;
        this.bookToBookViewConverter = bookToBookViewConverter;
    }

    public Book findBookOrThrow(Long id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("book.NotFound", id)));
    }

    public BookView getBook(@PathVariable Long id){
        Book book =   findBookOrThrow(id);
        return bookToBookViewConverter.convert(book);
    }

    public Page<BookView> findAllBooks(Pageable pageable) {
        Page<Book> books = bookRepo.findAll(pageable);
        List<BookView> bookViews = new ArrayList<>();
        books.forEach(book -> {
            BookView bookView = bookToBookViewConverter.convert(book);
            bookViews.add(bookView);
        });
        return new PageImpl<>(bookViews, pageable, books.getTotalElements());
    }

    public BookView create(BookBaseReq req) {

        Book book = new Book();
        this.prepareForCreate(book,req);
        Book bookSave = bookRepo.save(book);
        return bookToBookViewConverter.convert(bookSave);
    }

    public BookView update(Book book, BookBaseReq req) {
        Book newBook = this.prepareForUpdate(book, req);
        System.out.println(newBook.getAuthors().toString());
        Book bookForSave = bookRepo.save(newBook);
        return bookToBookViewConverter.convert(bookForSave);
    }

    @Transactional
    public void delete(Long id) {
        try {
            bookRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(messageUtil.getMessage("book.NotFound", id));
        }
    }
    private Book prepareForCreate(Book book, BookBaseReq req) {
        book.setBook_name(req.getName());
        book.setIsbn(req.getIsbn());
//        AUTHOR
        List<Author> authorList = new ArrayList<>();
        req.getAuthors().forEach(AuthorBaseReq-> {
            Author newAuthor = new Author();
            newAuthor.setAuthor_name(AuthorBaseReq.getName());
            newAuthor.setAuthor_description(AuthorBaseReq.getDescription());
            authorList.add(newAuthor);
        });
        book.setAuthors(authorList);

//        PUBLISHER
        List<Publisher> publisherList = new ArrayList<>();
        req.getPublishers().forEach(PublisherBaseReq-> {

//            System.out.println(newPublisher.getPublisher_name());
            Publisher newPublisher = new Publisher();
            newPublisher.setPublisher_name(PublisherBaseReq.getName());
            newPublisher.setPublisher_description(PublisherBaseReq.getDescription());
            publisherList.add(newPublisher);
        });
        book.setPublishers(publisherList);
//        book.setPublishers(newPu);

        return book;
    }
    private Book prepareForUpdate(Book book, BookBaseReq req) {
        book.setId(req.getId());
        book.setIsbn(req.getIsbn());
        book.setBook_name(req.getName());
        return book;
    }
}
