package demo.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.model.Activity;
import demo.example.model.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired 
	private ActivityRepository ar;
	@Override
	public List<Activity> showAllActivity() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

    @Override
    public List<Activity> getActivityByStatus(boolean status) {
        return ar.findByStatus(status);
    }

	@Override
	public Activity getActivityById(String activityId) {
		// TODO Auto-generated method stub
		return ar.findById(activityId).get();
	}

	@Override
	public Activity createActivity(Activity activity) {
		// TODO Auto-generated method stub
		return ar.save(activity);
	}

	@Override
	public Activity updateActivity(String activityId, Activity activity) {
		// TODO Auto-generated method stub
		Activity a = ar.findById(activityId).get();
		a.setActivityId(activity.getActivityId());
		a.setCategory(activity.getCategory());
		a.setInfo(activity.getInfo());
		a.setActivityName(activity.getActivityName());
		a.setDiscountRate(activity.getDiscountRate());
		a.setDiscountAmount(activity.getDiscountAmount());
		a.setBeginTime(activity.getBeginTime());
		a.setEndTime(activity.getEndTime());
		a.setStatus(activity.isStatus());
		return ar.save(a);
	}

	@Override
	public void deleteActivity(String activityId) {
		// TODO Auto-generated method stub
		ar.deleteById(activityId);
	}
}

