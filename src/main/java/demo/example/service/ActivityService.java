package demo.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.example.model.Activity;

@Service
public interface ActivityService {

	List<Activity> showAllActivity();
	
	List<Activity> getActivityByStatus(boolean status);
	
	Activity getActivityById(String activityId);
	
	Activity createActivity(Activity activity);
	
	Activity updateActivity(String activityId, Activity activity);

	void deleteActivity(String activityId);
}
