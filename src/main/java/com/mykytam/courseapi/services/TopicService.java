package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.TopicCreateDto;
import com.mykytam.courseapi.models.Topic;
import com.mykytam.courseapi.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final ConversionService conversionService;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopic(Integer id) {
        return topicRepository.findById(id).orElseThrow();
    }

    public void addTopic(TopicCreateDto topicDto) {
        Topic topic = conversionService.convert(topicDto, Topic.class);
        topicRepository.save(topic);
    }

    public void updateTopic(TopicCreateDto topicDto, Integer id) {
        Topic old = topicRepository.findById(id).orElseThrow();
        old.setName(topicDto.getName());
        old.setDescription(topicDto.getDescription());
        topicRepository.save(old);
    }

    public void deleteTopic(Integer id) {
        topicRepository.deleteById(id);
    }
}
