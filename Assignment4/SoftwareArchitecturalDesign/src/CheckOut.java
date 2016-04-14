public class CheckOut {

	public static String checkOut(String[] instr) {
		//initalize variables
		Customer cust=Framework.getCustomerByName(instr[1]); // the customer data retrieved by customer's name
		Reservation userRes= Framework.getReservationByCID(cust.getCustomerID()); // the reservation for the customer retrieved by customer ID

		//update the money based on start_Date and end_date rates (rate differs by single and double rates)
		//charge credit card
		int days = end_Date - start_Date;
		int rate = userRes.getRoomType(); //single_rate or double_rate
		int charge = days * rate;
		//check card through proxy
		if(proxy(charge) == false){
			return "Invalid Card.";
		}
		UserRes.chargeCard(charge);
		
		userRes.setStatus(1); // change status of reservation to checked out
		//assign room# to res, 0-MAX_singles is singles and max singles-max doubles is doubles
		roomNum = userRes.getRoomNumber();
		Rooms.emptyRoom(roomNum);
		userRes.emptyRoom(roomNum);
		
		//update Report to free the room and add money to report object
		report.decrementOccupancy(0);
		report.addRevenue(charge);
		
		// OUTPUT GOES HERE
	}
}
