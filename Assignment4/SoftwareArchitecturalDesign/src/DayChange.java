
public class DayChange {

	public static String change_day(String[] args) {
		
		StringBuilder op = new StringBuilder();
		
		Day today = Calendar.getInfo();
		int[] cur_reservs = today.getResIDs();
		
		for(int i=0; i<cur_reservs.length; i++){
			Reservation temp = Framework.getReservationByID(cur_reservs[i]);
			if((temp.getGuaranteed()==1)&&((temp.getStatus()!=Framework.STATUS_CHECKED_IN)&&(temp.getStatus()!=Framework.STATUS_CHECKED_OUT))){
				//no show condition.
				Customer no_show = Framework.getCustomerByID(temp.getCustomerID());
				op.append(no_show.getName()+" did not show.\n");
				temp.setStatus(Framework.STATUS_NO_SHOW);
			} continue;
		}
		
		Report.day_change();
		Calendar.nextDay();
		op.append("==================January "+Calendar.get_cur_Day()+", 2016==================\n");
		
		return op.toString();
	}

}
