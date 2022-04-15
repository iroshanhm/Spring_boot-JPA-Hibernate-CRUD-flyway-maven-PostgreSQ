package com.iroshan.library.book.web;

import com.iroshan.library.book.Book;
import com.iroshan.library.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    @ResponseBody
    public BookView getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public Page<BookView> getAllBooks(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return bookService.findAllBooks(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BookView create(@Valid @RequestBody BookBaseReq req) {
        return bookService.create(req);
    }

    @PutMapping("/{id}")
    public BookView updateBook(@PathVariable(name = "id") Long id,
                               @Valid @RequestBody BookBaseReq req) {
        Book book = bookService.findBookOrThrow(id);
        return bookService.update(book, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }

}
