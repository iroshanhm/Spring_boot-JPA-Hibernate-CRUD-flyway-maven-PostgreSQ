package com.iroshan.library.publisher.converter;

import com.iroshan.library.author.web.AuthorView;
import com.iroshan.library.publisher.Publisher;
import com.iroshan.library.publisher.web.PublisherView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublisherToPublisherViewConverter implements Converter<Publisher, PublisherView> {
    @Override
    public PublisherView convert(Publisher source) {
        PublisherView publisherView = new PublisherView();
        publisherView.setId(source.getId());
        publisherView.setName(source.getPublisher_name());
        publisherView.setDescription(source.getPublisher_description());
        return publisherView;
    }
}
