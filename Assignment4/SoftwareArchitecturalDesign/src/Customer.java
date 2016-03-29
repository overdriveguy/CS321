
public class Customer {
	
	///////////////////////////////////////////////////////////////
	// FIELDS
	///////////////////////////////////////////////////////////////
	
	private int customerID; 		// A unique identifier for the customer, assigned by the Framework
	private String name;			// The customer�s full name
	private String address;			// The customer's address
	private String ccType;			// The type of credit card (Mastercard, Visa, etc)
	private String ccNumber;		// The credit card number
	private String ccExpiration;	// The expiration date of the credit card
	
	
	///////////////////////////////////////////////////////////////
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////
	
	// Default Constructor
	Customer() {
		customerID = 0;
		name = address = ccType = ccNumber = ccExpiration = "";
	}
	
	///////////////////////////////////////////////////////////////
	// GETTERS & SETTERS
	///////////////////////////////////////////////////////////////
	
	// Sets customerID for this object to the value of the parameter �id�.
	void setCustomerID(int id) {
		this.customerID = id;
	} // STUB
	
	// Sets name for this object to the value of the parameter �name�.
	void setName(String name) {
		this.name = name;
	} // STUB
	
	// Sets the address for this object to �address�.
	void setAddress(String address) {
		this.address = address;
	} // STUB
	
	// Sets ccType for this object to the value of the parameter �ccType�.
	void setCCType(String ccType) {
		this.ccType = ccType;
	} // STUB
	
	// Sets ccNumber for this object to the value of the parameter �ccNumber�.
	void setCCNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	} // STUB
	
	// Sets the CCExpiration for this object to the value of the parameter �ccExpiration�.
	void setCCExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	} // STUB
	
	// Retrieves the instance variable �customerID� for this object.
	int getCustomerID() {return this.customerID;} // STUB
	
	// Retrieves the instance variable �name� for this object.
	String getName() {return this.name;} // STUB
	
	// Retrieves the instance variable �address� for this object.
	String getAddress() {return this.address;} // STUB
	
	// Retrieves the instance variable �ccType� for this object.
	String getCCType() {return this.ccType;} // STUB
	
	// Retrieves the instance variable �ccNumber� for this object.
	String getCCNumber() {return this.ccNumber;} // STUB
	
	// Retrieves the instance variable �ccExpiration� for this object.
	String getCCExpiration() {return this.getCCExpiration();} // STUB
	
	
	///////////////////////////////////////////////////////////////
	// METHODS
	///////////////////////////////////////////////////////////////
	
	// Stores a new customer with the data contained in the given Customer object. 
	// Assigns a new customer ID to the customer and returns the generated ID. 
	int storeCustomer(Customer cus) {return 0;} // STUB
	
	// Removes the customer with the given customerID from the system. Returns 
	// true if successful, or false if no customer with the given customerID exists. 
	boolean deleteCustomer(int customerID) {return false;} // STUB
	
	// Returns the customer with the given customerID. Returns null if no customer 
	// with the given customerID exists.
	Customer getCustomerByID(int customerID) {return null;} // STUB
	
	// Returns the customer with the given name. Returns null if no customer with 
	// the given name exists.
	Customer getCustomerByName(String name) {return null;} // STUB
	
	// Replaces the stored customer with the given customerID with the customer
	// data contained in cus. Returns true if successful, otherwise returns false
	// if customer with given customerID does not exist. 
	boolean modifyCustomer(int customerID, Customer cus) {return false;} // STUB
}