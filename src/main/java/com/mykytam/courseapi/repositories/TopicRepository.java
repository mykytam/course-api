package com.mykytam.courseapi.repositories;

import com.mykytam.courseapi.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {

}
