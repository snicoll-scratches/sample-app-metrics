package com.example;

import java.util.Optional;

import com.example.speaker.Speaker;
import com.example.speaker.SpeakerRepository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Stephane Nicoll
 */
@RestController
public class DemoController {

	private final SpeakerRepository speakerRepository;

	private final RestTemplate restTemplate;

	public DemoController(SpeakerRepository speakerRepository, RestTemplateBuilder restTemplateBuilder) {
		this.speakerRepository = speakerRepository;
		this.restTemplate = restTemplateBuilder.build();
	}

	@GetMapping("/speakers")
	public Iterable<Speaker> allSpeakers() {
		return this.speakerRepository.findAll();
	}

	@GetMapping("/speakers/{id}")
	public ResponseEntity<?> speakerById(@PathVariable Long id) {
		Optional<Speaker> speaker = this.speakerRepository.findById(id);
		if (speaker.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(speaker);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/initializr-info")
	public ResponseEntity<String> initializrInfo() {
		return this.restTemplate.getForEntity("https://start.spring.io/actuator/info", String.class);
	}
}
