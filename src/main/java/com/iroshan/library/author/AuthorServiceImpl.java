package com.iroshan.library.author;

import com.iroshan.library.author.converter.AuthorToAuthorViewConverter;
import com.iroshan.library.author.web.AuthorBaseReq;
import com.iroshan.library.author.web.AuthorView;
import com.iroshan.library.error.EntityNotFoundException;
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
public class AuthorServiceImpl implements AuthorServiceInf{

    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private AuthorToAuthorViewConverter authorToAuthorViewConverter;

    @Override
    public Author findAuthorOrThrow(Long id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("author.NotFound", id)));
    }

    @Override
    public AuthorView getAuthor(@PathVariable Long id){
        Author author =   findAuthorOrThrow(id);
        return authorToAuthorViewConverter.convert(author);
    }

    @Override
    public Page<AuthorView> findAllAuthors(Pageable pageable) {
        Page<Author> authors = authorRepo.findAll(pageable);
        List<AuthorView> authorViews = new ArrayList<>();
        authors.forEach(author -> {
            AuthorView authorView = authorToAuthorViewConverter.convert(author);
            authorViews.add(authorView);
        });
        return new PageImpl<>(authorViews, pageable, authors.getTotalElements());
    }

    @Override
    public AuthorView create(AuthorBaseReq req) {
        System.out.println(req.getId());
        Author author = new Author();
        this.prepareForCreate(author,req);
        Author authorSave = authorRepo.save(author);
        return authorToAuthorViewConverter.convert(authorSave);
    }

    @Override
    public AuthorView update(Author author, AuthorBaseReq req) {
        Author newAuthor = this.prepareForUpdate(author, req);
        Author authorForSave = authorRepo.save(newAuthor);
        return authorToAuthorViewConverter.convert(authorForSave);
    }

    @Override
    public void delete(Long id) {
        try {
            authorRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(messageUtil.getMessage("author.NotFound", id));
        }
    }

    @Override
    public Author prepareForCreate(Author author, AuthorBaseReq req) {
        author.setAuthor_name(req.getName());
        author.setAuthor_description(req.getDescription());
        return author;
    }

    @Override
    public Author prepareForUpdate(Author author, AuthorBaseReq req) {
        author.setId(req.getId());
        author.setAuthor_name(req.getName());
        author.setAuthor_description(req.getDescription());
        return author;
    }
}
