package com.iroshan.library.author;

import com.iroshan.library.author.web.AuthorBaseReq;
import com.iroshan.library.author.web.AuthorView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

public interface AuthorServiceInf {
    public Author findAuthorOrThrow(Long id);
    public AuthorView getAuthor(@PathVariable Long id);
    public Page<AuthorView> findAllAuthors(Pageable pageable);
    public AuthorView create(AuthorBaseReq req);
    public AuthorView update(Author author, AuthorBaseReq req);
    @Transactional
    public void delete(Long id);
    Author prepareForCreate(Author author, AuthorBaseReq req);
    Author prepareForUpdate(Author author, AuthorBaseReq req);
}
