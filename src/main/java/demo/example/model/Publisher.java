package demo.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher {

	@Id
	@Column(name = "publisherID")
	private String publisherId;
	
	@Column(name = "publisherName")
	private String publisherName;
	
	@Column(name = "phone")
	private String phone;

	public Publisher() {
		super();
	}

	public Publisher(String publisherId, String publisherName, String phone) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.phone = phone;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", phone=" + phone + "]";
	}
}
