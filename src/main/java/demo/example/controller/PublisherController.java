package demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.example.model.Publisher;
import demo.example.service.PublisherService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/publisher")
public class PublisherController {

	@Autowired
	private PublisherService ps;

	@GetMapping
	public ResponseEntity<List<Publisher>> getAllPublishers() {
		List<Publisher> publishers = ps.getAllPublisher();
		return ResponseEntity.ok(publishers);
	}

	@GetMapping(value = "/test")
	public List<Publisher> getPublishers() {
		List<Publisher> publishers = ps.getAllPublisher();
		return publishers;
	}

	// build create publisher REST API
	@PostMapping
	public ResponseEntity<Publisher> creatPublisher(@RequestBody Publisher publisher) {
		Publisher p = ps.createPublisher(publisher);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

	// build get publisher by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Publisher> getPublisherById(@PathVariable("id") String publisherId) {
		Publisher p = ps.getPublisherById(publisherId);
		return ResponseEntity.ok(p);
	}

	// build update publisher REST API
	@PutMapping("{id}")
	public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") String publisherId,
			@RequestBody Publisher publisher) {
		Publisher p = ps.updatePublisher(publisherId, publisher);
		return ResponseEntity.ok(p);
	}

	// build delete publisher REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePublisher(@PathVariable("id") String publisherId) {
		ps.deletePublisher(publisherId);
		return ResponseEntity.ok("Publisher：" + publisherId + " deleted successfully!");
	}

	// build get publisherName REST API
	@GetMapping("/publisherName")
	public ResponseEntity<List<String>> getAllPublisherName() {
		return ResponseEntity.ok(ps.getAllPublisherName());
	}

	@GetMapping("/publisherName/{id}")
	public ResponseEntity<String> getPublisherNameById(@PathVariable("id") String publisherId) {
		return ResponseEntity.ok(ps.getPublisherNameById(publisherId));
	}

}
