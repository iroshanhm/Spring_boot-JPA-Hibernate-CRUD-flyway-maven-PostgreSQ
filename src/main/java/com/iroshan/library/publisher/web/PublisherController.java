package com.iroshan.library.publisher.web;

import com.iroshan.library.author.Author;
import com.iroshan.library.author.web.AuthorBaseReq;
import com.iroshan.library.author.web.AuthorView;
import com.iroshan.library.publisher.Publisher;
import com.iroshan.library.publisher.PublisherServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherServiceInf publisherServiceInf;

    @GetMapping("/{id}")
    @ResponseBody
    public PublisherView getPublisher(@PathVariable Long id){
        return publisherServiceInf.getPublisher(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public Page<PublisherView> getAllPublisher(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        return publisherServiceInf.findAllPublishers(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PublisherView create(@Valid @RequestBody PublisherBaseReq req) {
        return publisherServiceInf.create(req);
    }

    @PutMapping("/{id}")
    public PublisherView updatePublisher(@PathVariable(name = "id") Long id,
                                   @Valid @RequestBody PublisherBaseReq req) {
        Publisher publisher = publisherServiceInf.findPublisherOrThrow(id);
        return publisherServiceInf.update(publisher, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable Long id){
        publisherServiceInf.delete(id);
    }

}
