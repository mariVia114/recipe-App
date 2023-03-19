package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Event;
import net.javaguides.springboot.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
//
	public void save(Event event/*, String userId*/) {
//		event.setUserid(userId);
//		event.setCreatedAt(new Date());
		eventRepository.save(event);
	}
	public void delete(Long id) {
		eventRepository.deleteById(id);
	}
//
//	public Meal findByCreatedBy(String createdBy) {
//		return eventRepository.findTopByCreatedByOrderByCreatedAtDesc(createdBy);
//	}

	public Event findById(Long id) {
		return eventRepository.findById(id).get();
	}

	public ResponseEntity<List<Event>> getAllEvents(@RequestParam(required = false) String title) {
		try {
			List<Event> tutorials = new ArrayList<Event>();

			if (title == null)
				eventRepository.findAll().forEach(tutorials::add);
			else
				eventRepository.findByTitleContaining(title).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Event> getEventById(@PathVariable("id") long id) {
		Optional<Event> tutorialData = eventRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Event> createEvent(@RequestBody Event tutorial) {
		try {
			Event _tutorial = eventRepository
					.save(new Event(tutorial.getTitle(), tutorial.getDescription(), false));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Event> updateEvent(@PathVariable("id") long id, @RequestBody Event tutorial) {
		Optional<Event> tutorialData = eventRepository.findById(id);

		if (tutorialData.isPresent()) {
			Event _tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());
			return new ResponseEntity<>(eventRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<HttpStatus> deleteEvent(long id) {
		try {
			eventRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deleteAllEvents() {
		try {
			eventRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<List<Event>> findByPublished() {
		try {
			List<Event> tutorials = eventRepository.findByPublished(true);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
