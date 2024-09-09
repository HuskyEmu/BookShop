package demo.example.model;

import java.io.Serializable;

import jakarta.persistence.*;


/**
 * The primary key class for the shoppingcart database table.
 * 
 */
@Embeddable
public class ShoppingcartPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String memberID;

	@Column(insertable=false, updatable=false)
	private String bookID;

	public ShoppingcartPK(String memberID, String bookID) {
		super();
		this.memberID = memberID;
		this.bookID = bookID;
	}
	public ShoppingcartPK() {
	}
	public String getMemberID() {
		return this.memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getBookID() {
		return this.bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ShoppingcartPK)) {
			return false;
		}
		ShoppingcartPK castOther = (ShoppingcartPK)other;
		return 
			this.memberID.equals(castOther.memberID)
			&& this.bookID.equals(castOther.bookID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.memberID.hashCode();
		hash = hash * prime + this.bookID.hashCode();
		
		return hash;
	}
}