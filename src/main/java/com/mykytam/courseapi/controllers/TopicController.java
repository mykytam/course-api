package com.mykytam.courseapi.controllers;

import com.mykytam.courseapi.dto.TopicResponseDto;
import com.mykytam.courseapi.models.Topic;
import com.mykytam.courseapi.services.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public List<TopicResponseDto> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("{id}")
    public TopicResponseDto getTopic(@PathVariable Integer id) {
        return topicService.getTopic(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Topic addTopic(@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    @PutMapping("{id}")
    public Topic updateTopic(@RequestBody Topic topic, @PathVariable Integer id) {
        return topicService.updateTopic(topic, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopic(@PathVariable Integer id) {
        topicService.deleteTopic(id);
    }
}
