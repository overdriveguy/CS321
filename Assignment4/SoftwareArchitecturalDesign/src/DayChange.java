/* CLASS INTERFACE SPECIFICATION
 * 
 * Information hiding class: DayChange;
 * Author: Krishna Kanakapua.
 * 
 * Operations Provided:
 * 
 *  -change_day:
 *    -function: -critical object that is responsible for simulating day change.
 *               -cancels all of todays no show guaranteed reservations.
 *               - initiates day change in report and calendar.
 *    -precondition: system has been initiated.
 *    -postcondition: succesful and coherent day change occurs throughout the system.
 *    -input parameters: none
 *    -output parameters: none
 */
import java.util.*;
public class DayChange {

 public static String change_day(String[] args) {
  
  StringBuilder op = new StringBuilder();
  
  Day today = Calendar.getInfo();
  ArrayList<Integer> cur_reservs = today.getResIDs();
  
  for(int i=cur_reservs.size()-1; i>=0; i--){
    
   Reservation temp = Framework.getReservationByID(cur_reservs.get(i));
   if((temp.getStatus())!=(Framework.STATUS_CHECKED_IN)){
    //no show condition.
    Customer no_show = Framework.getCustomerByID(temp.getCustomerID());
    op.append(no_show.getName()+" did not show.\n");
    temp.setStatus(Framework.STATUS_NO_SHOW);
    
    Calendar.removeReservation(cur_reservs.get(i));
    
    
   }
  }
  
  Report.day_change();
  Calendar.nextDay();
  op.append("==================January "+Calendar.get_cur_Day()+", 2016==================\n");
  
  return op.toString();
 }

}
