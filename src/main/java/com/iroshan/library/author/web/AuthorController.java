package com.iroshan.library.author.web;

import com.iroshan.library.author.Author;
import com.iroshan.library.author.AuthorServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorServiceInf authorService;

    @GetMapping("/{id}")
    @ResponseBody
    public AuthorView getAuthor(@PathVariable Long id){
        return authorService.getAuthor(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public Page<AuthorView> getAllAuthors(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return authorService.findAllAuthors(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AuthorView create(@Valid @RequestBody AuthorBaseReq req) {
        return authorService.create(req);
    }

    @PutMapping("/{id}")
    public AuthorView updateAuthor(@PathVariable(name = "id") Long id,
                                 @Valid @RequestBody AuthorBaseReq req) {
        Author author = authorService.findAuthorOrThrow(id);
        return authorService.update(author, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long id){
        authorService.delete(id);
    }

}
