package demo.example.model;

import java.io.Serializable;

import java.util.Date;

import jakarta.persistence.*;


/**
 * The persistent class for the shoppingcart database table.
 * 
 */

@Entity
@NamedQuery(name="Shoppingcart.findAll", query="SELECT s FROM Shoppingcart s")
public class Shoppingcart implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShoppingcartPK id;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date addedDateTime;

	private boolean cartStatus;

	private int quantity;

	public Shoppingcart() {
	}
	
	
	public Shoppingcart(ShoppingcartPK id, boolean cartStatus, int quantity) {
		super();
		this.id = id;
		this.cartStatus = cartStatus;
		this.quantity = quantity;
	}


	public ShoppingcartPK getId() {
		return this.id;
	}

	public void setId(ShoppingcartPK id) {
		this.id = id;
	}

//	public Date getAddedDateTime() {
//		return this.addedDateTime;
//	}
//
//	public void setAddedDateTime(Date addedDateTime) {
//		this.addedDateTime = addedDateTime;
//	}

	public boolean getCartStatus() {
		return this.cartStatus;
	}

	public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



}