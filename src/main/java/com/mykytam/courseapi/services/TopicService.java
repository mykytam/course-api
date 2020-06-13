package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.TopicResponseDto;
import com.mykytam.courseapi.models.Topic;
import com.mykytam.courseapi.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final ConversionService conversionService;

    public List<TopicResponseDto> getAllTopics() {
        return topicRepository.findAll()
                .stream()
                .map(topics -> conversionService.convert(topics, TopicResponseDto.class))
                .collect(Collectors.toList());
    }

    public TopicResponseDto getTopic(Integer id) {
        Topic topic = topicRepository.findById(id).orElseThrow();
        return conversionService.convert(topic, TopicResponseDto.class);
    }

    public Topic addTopic(Topic topic) {
        topicRepository.save(topic);
        return Topic.builder()
                .id(topic.getId())
                .build();
    }

    public Topic updateTopic(Topic topic, Integer id) {
        Topic old = topicRepository.findById(id).orElseThrow();
        old.setName(topic.getName());
        old.setDescription(topic.getDescription());
        topicRepository.save(old);
        return Topic.builder()
                .id(old.getId())
                .build();
    }

    public void deleteTopic(Integer id) {
        topicRepository.deleteById(id);
    }
}
