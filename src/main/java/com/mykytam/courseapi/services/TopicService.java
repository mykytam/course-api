package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.TopicResponseDto;
import com.mykytam.courseapi.exceptions.TopicNotFoundException;
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
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new TopicNotFoundException("Topic not found"));
        return conversionService.convert(topic, TopicResponseDto.class);
    }

    public Topic addTopic(Topic topic) {
        Topic saved = topicRepository.save(topic);

        return Topic.builder()
                .id(saved.getId())
                .build();
    }

    public Topic updateTopic(Topic topic, Integer id) {
        Topic topicToUpdate = topicRepository.findById(id).orElseThrow();
        topicToUpdate.setName(topic.getName());
        topicToUpdate.setDescription(topic.getDescription());

        Topic saved = topicRepository.save(topicToUpdate);

        return Topic.builder()
                .id(saved.getId())
                .build();
    }

    public void deleteTopic(Integer id) {
        topicRepository.deleteById(id);
    }
}
