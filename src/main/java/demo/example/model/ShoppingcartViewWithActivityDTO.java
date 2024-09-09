package demo.example.model;

import java.util.List;
import demo.example.model.Activity;
import demo.example.model.ShoppingcartView;

public class ShoppingcartViewWithActivityDTO {
    private List<ShoppingcartView> shoppingcartViews;
    private List<Activity> activities;

    // Constructors, getters, and setters
    public ShoppingcartViewWithActivityDTO(List<ShoppingcartView> shoppingcartViews, List<Activity> activities) {
        this.shoppingcartViews = shoppingcartViews;
        this.activities = activities;
    }

    public List<ShoppingcartView> getShoppingcartViews() {
        return shoppingcartViews;
    }

    public void setShoppingcartViews(List<ShoppingcartView> shoppingcartViews) {
        this.shoppingcartViews = shoppingcartViews;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
