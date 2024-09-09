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

import demo.example.model.Activity;
import demo.example.service.ActivityService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService as;

	@GetMapping
	public ResponseEntity<List<Activity>> getAllActivities() {
		List<Activity> activities = as.showAllActivity();
		return ResponseEntity.ok(activities);
	}

	// build create activity REST API
	@PostMapping
	public ResponseEntity<Activity> creatActivity(@RequestBody Activity activity) {
		Activity a = as.createActivity(activity);
		return new ResponseEntity<>(a, HttpStatus.CREATED);
	}

	// build get activity by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Activity> getActivityById(@PathVariable("id") String activityId) {
		Activity a = as.getActivityById(activityId);
		return ResponseEntity.ok(a);
	}

	// build update activity REST API
	@PutMapping("{id}")
	public ResponseEntity<Activity> updateActivity(@PathVariable("id") String activityId,
			@RequestBody Activity activity) {
		Activity a = as.updateActivity(activityId, activity);
		return ResponseEntity.ok(a);
	}

	// build delete activity REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteActivity(@PathVariable("id") String activityId) {
		as.deleteActivity(activityId);
		return ResponseEntity.ok("Activity：" + activityId + " deleted successfully!");
	}
	
	@GetMapping("/Info/{id}")
	public ResponseEntity<String> getInfoById(@PathVariable("id") String activityId) {
		Activity a = as.getActivityById(activityId);
		return ResponseEntity.ok(a.getInfo());
	}
}
