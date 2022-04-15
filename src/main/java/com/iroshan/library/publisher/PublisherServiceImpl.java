package com.iroshan.library.publisher;

import com.iroshan.library.author.Author;
import com.iroshan.library.author.web.AuthorView;
import com.iroshan.library.error.EntityNotFoundException;
import com.iroshan.library.publisher.converter.PublisherToPublisherViewConverter;
import com.iroshan.library.publisher.dao.PublisherRepo;
import com.iroshan.library.publisher.web.PublisherBaseReq;
import com.iroshan.library.publisher.web.PublisherView;
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
public class PublisherServiceImpl implements PublisherServiceInf{
    
    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private PublisherRepo publisherRepo;
    @Autowired
    private PublisherToPublisherViewConverter publisherToPublisherViewConverter;

    @Override
    public Publisher findPublisherOrThrow(Long id) {
        return publisherRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("publisher.NotFound", id)));
    }

    @Override
    public PublisherView getPublisher(@PathVariable Long id){
        Publisher publisher =   findPublisherOrThrow(id);
        return publisherToPublisherViewConverter.convert(publisher);
    }

    @Override
    public Page<PublisherView> findAllPublishers(Pageable pageable) {
        Page<Publisher> publishers = publisherRepo.findAll(pageable);
        List<PublisherView> publisherViews = new ArrayList<>();
        publishers.forEach(publisher -> {
            PublisherView publisherView = publisherToPublisherViewConverter.convert(publisher);
            publisherViews.add(publisherView);
        });
        return new PageImpl<>(publisherViews, pageable, publishers.getTotalElements());

    }

    @Override
    public PublisherView create(PublisherBaseReq req) {
        System.out.println(req.getId());
        Publisher publisher = new Publisher();
        this.prepareForCreate(publisher,req);
        Publisher publisherSave = publisherRepo.save(publisher);
        return publisherToPublisherViewConverter.convert(publisherSave);
    }

    @Override
    public PublisherView update(Publisher publisher, PublisherBaseReq req) {
        Publisher newpublisher = this.prepareForUpdate(publisher, req);
        Publisher publisherForSave = publisherRepo.save(newpublisher);
        return publisherToPublisherViewConverter.convert(publisherForSave);
    }

    @Override
    public void delete(Long id) {
        try {
            publisherRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(messageUtil.getMessage("publisher.NotFound", id));
        }
    }

    @Override
    public Publisher prepareForCreate(Publisher publisher, PublisherBaseReq req) {
        publisher.setPublisher_name(req.getName());
        publisher.setPublisher_description(req.getDescription());
        return publisher;
    }

    @Override
    public Publisher prepareForUpdate(Publisher publisher, PublisherBaseReq req) {
        publisher.setId(req.getId());
        publisher.setPublisher_name(req.getName());
        publisher.setPublisher_description(req.getDescription());
        return publisher;
    }
}
