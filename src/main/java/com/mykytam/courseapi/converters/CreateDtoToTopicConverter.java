package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.TopicCreateDto;
import com.mykytam.courseapi.models.Topic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateDtoToTopicConverter implements Converter<TopicCreateDto, Topic> {

    @Override
    public Topic convert(TopicCreateDto source) {
        return Topic.builder()
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
