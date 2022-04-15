package com.iroshan.library.publisher;


import com.iroshan.library.publisher.web.PublisherBaseReq;
import com.iroshan.library.publisher.web.PublisherView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

public interface PublisherServiceInf {
    public Publisher findPublisherOrThrow(Long id);
    public PublisherView getPublisher(@PathVariable Long id);
    public Page<PublisherView> findAllPublishers(Pageable pageable);
    public PublisherView create(PublisherBaseReq req);
    public PublisherView update(Publisher Publisher, PublisherBaseReq req);
    @Transactional
    public void delete(Long id);
    Publisher prepareForCreate(Publisher Publisher, PublisherBaseReq req);
    Publisher prepareForUpdate(Publisher Publisher, PublisherBaseReq req);
}
