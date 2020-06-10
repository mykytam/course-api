package com.mykytam.courseapi.controllers;

import com.mykytam.courseapi.dto.TopicCreateDto;
import com.mykytam.courseapi.models.Topic;
import com.mykytam.courseapi.services.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("{id}")
    public Topic getTopic(@PathVariable Integer id) {
        return topicService.getTopic(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTopic(@RequestBody @Valid TopicCreateDto topic) {
        topicService.addTopic(topic);
    }

    @PutMapping("{id}")
    public void updateTopic(@RequestBody Topic topic) {
        topicService.updateTopic(topic);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopic(@PathVariable Integer id) {
        topicService.deleteTopic(id);
    }
}
