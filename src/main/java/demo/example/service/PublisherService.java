package demo.example.service;

import java.util.List;

import demo.example.model.Publisher;

public interface PublisherService {
	List<Publisher> getAllPublisher();

	Publisher createPublisher(Publisher publisher);

	Publisher getPublisherById(String publisherId);

	Publisher updatePublisher(String publisherId, Publisher publisher);

	void deletePublisher(String publisherId);
	
	List<String> getAllPublisherName();
	
	String getPublisherNameById(String publisherId);
}
