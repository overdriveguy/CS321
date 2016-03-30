
public class MakeReservation {
	private static void run(){
		String x=Framework.getNextInstruction();
		Customer newCust= new Customer();
		
		Reservation newRes= new Reservation();
		newCust.setName(x);
		
		x=Framework.getNextInstruction();
		newCust.setAddress(x);
		
		x=Framework.getNextInstruction();
		int startDate=Integer.parseInt(x);
		x=Framework.getNextInstruction();
		int stopDate=Integer.parseInt(x);
		x=Framework.getNextInstruction();
		int roomType=Integer.parseInt(x);
		//check with calendar
		if(!Calendar.checkDays(startDate,stopDate,roomType)){
			System.out.println("cant stay this day");
			
		}
		//handle what to do no idea where to print errors too, could just ignore rest and iterate till next thing
		Calendar.addReservation(startDate, stopDate, roomType);
		newRes.setStartDate(startDate);
		newRes.setEndDate(stopDate);
		newRes.setRoomType(roomType);
		
		x=Framework.getNextInstruction();
		int numOccs=Integer.parseInt(x);
		newRes.setNumOccupants(numOccs);
		
		x=Framework.getNextInstruction();
		int guaranteed=Integer.parseInt(x);
		newRes.setGuaranteed(guaranteed);
		
		if(guaranteed==1){
			x=Framework.getNextInstruction();
			newCust.setCCType(x);
			
			x=Framework.getNextInstruction();
			newCust.setCCExpiration(x);
			
			x=Framework.getNextInstruction();
			newCust.setCCNumber(x);
		}
		
		//customer ID and Res ID
		int custID=Framework.storeCustomer(newCust);
		newRes.setCustomerID(custID);
		//can find cust by name, get cust id, then find reservation...  i think
		int resID=Framework.storeReservation(newRes);
	}
}
