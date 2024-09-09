package demo.example.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import demo.example.model.Activity;
import demo.example.model.Shoppingcart;
import demo.example.model.ShoppingcartPK;
import demo.example.model.ShoppingcartView;
import demo.example.model.ShoppingcartViewWithActivityDTO;
import demo.example.service.ActivityService;
import demo.example.service.ShoppingcartService;
import demo.example.service.ShoppingcartViewService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/shoppingcarts")
public class ShoppingcartController {

	
	@Autowired
	private ShoppingcartViewService shoppingcartViewService;
	@Autowired
	private ShoppingcartService shoppingcartService;
	@Autowired
	private ActivityService activityService;

	    @GetMapping
	    public ResponseEntity<ShoppingcartViewWithActivityDTO> getAllShoppingcartView() {
	        List<ShoppingcartView> shoppingcartViews = shoppingcartViewService.getAllShoppingcartView();
	        List<Activity> activities = ((Activity) activityService.getActivityByStatus(true)).orElse(Collections.emptyList()); 
	        ShoppingcartViewWithActivityDTO dto = new ShoppingcartViewWithActivityDTO(shoppingcartViews, activities);
	        return ResponseEntity.ok(dto);
	    }
	

		@GetMapping("{id}")
		public ResponseEntity<ShoppingcartViewWithActivityDTO> getShoppingcartViewById(@PathVariable("id") String memberId) {
			List<ShoppingcartView> sv = shoppingcartViewService.getShoppingcartViewByMemberId(memberId);
			List<Activity> activities = activityService.getActivityByStatus(true);
	        ShoppingcartViewWithActivityDTO dto = new ShoppingcartViewWithActivityDTO(sv, activities);
	        System.out.println(sv.get(0).getBookId());
	        return ResponseEntity.ok(dto);
		}
		
		@PostMapping("/{mid}/{bid}")
		public ResponseEntity<Shoppingcart> creatShoppingcart(@PathVariable("mid") String mid,@PathVariable("bid") String bid, @RequestBody Shoppingcart shoppingcart) {
			ShoppingcartPK sp = new ShoppingcartPK(mid, bid);
		    shoppingcart.setId(sp);
		    
		    // Set the quantity from the request body
		    int quantity = shoppingcart.getQuantity();
		    shoppingcart.setQuantity(quantity);

		    Shoppingcart sc = shoppingcartService.createShoppingcart(shoppingcart);
		    return new ResponseEntity<>(sc, HttpStatus.CREATED);
		}
	    // build delete shoppingcart REST API
	    @DeleteMapping("/{mid}/{bid}")
	    public ResponseEntity<String> deleteShoppingcart(@PathVariable("mid") String mid,@PathVariable("bid") String bid){
	    	ShoppingcartPK sp = new ShoppingcartPK(mid,bid);
	    	shoppingcartService.deleteShoppingcart(sp);
	        return ResponseEntity.ok("Shoppingcart deleted successfully!");
	    }
}
