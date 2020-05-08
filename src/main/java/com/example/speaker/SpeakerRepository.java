package com.example.speaker;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

	Speaker findByTwitter(String twitter);

	Speaker findByGithub(String github);

	Collection<Speaker> findByLastName(String lastName);

}
