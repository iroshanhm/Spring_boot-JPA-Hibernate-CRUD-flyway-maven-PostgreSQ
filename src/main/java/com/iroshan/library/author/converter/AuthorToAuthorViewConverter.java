package com.iroshan.library.author.converter;


import com.iroshan.library.author.Author;
import com.iroshan.library.author.web.AuthorView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorViewConverter implements Converter<Author, AuthorView> {

    @Override
    public AuthorView convert(Author source) {
        AuthorView authorView = new AuthorView();
        authorView.setId(source.getId());
        authorView.setName(source.getAuthor_name());
        authorView.setDescription(source.getAuthor_description());
        return authorView;
    }
}
