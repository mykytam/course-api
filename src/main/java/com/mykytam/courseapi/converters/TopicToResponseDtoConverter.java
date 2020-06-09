package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.TopicResponseDto;
import com.mykytam.courseapi.models.Topic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TopicToResponseDtoConverter implements Converter<Topic, TopicResponseDto> {
    @Override
    public TopicResponseDto convert(Topic source) {
        return TopicResponseDto.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
