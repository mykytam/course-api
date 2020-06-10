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
        if (topicRepository.existsById(topicDto.getId())) {
            throw new RuntimeException();
        }

        Topic topic = conversionService.convert(topicDto, Topic.class);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(Integer id) {
        topicRepository.deleteById(id);
    }
}
