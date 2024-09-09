package demo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.model.Publisher;
import demo.example.model.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository pr;

	@Override
	public List<Publisher> getAllPublisher() {
		List<Publisher> publishers = pr.findAll();
		return publishers;
	}

	@Override
	public Publisher createPublisher(Publisher publisher) {
		return pr.save(publisher);
	}

	@Override
	public Publisher getPublisherById(String publisherId) {
		return pr.findById(publisherId).get();
	}

	@Override
	public Publisher updatePublisher(String publisherId, Publisher publisher) {
		Publisher p = pr.findById(publisherId).get();
		p.setPublisherName(publisher.getPublisherName());
		p.setPhone(publisher.getPhone());
		return pr.save(p);
	}

	@Override
	public void deletePublisher(String publisherId) {
		pr.deleteById(publisherId);

	}

	@Override
	public List<String> getAllPublisherName() {
		return pr.getAllPublisherName();
	}

	@Override
	public String getPublisherNameById(String publisherId) {
		return pr.getPublisherNameById(publisherId);
	}

}
