/*Information Hiding Class: Calendar
 Author: Sean Gamble
 Operations Provided:
 1) init()
 2) checkDays(int start, int end, int roomType)
 Function: Checks each day bewteen start and end to see if rooms of the given type are free
 Precondition: Init has been ran
 Input: start-the first end-last day of stay  type-type of room 
 Output parameters: Boolean
 3)addReservation(int start, int end, int type, int resID)
 Function: Adds reservation to days. Adds ID to list in day
 Precondition: Init has been ran
 Input: start-the first end-last day of stay  type-type of room  resID-reservation id 
 Post condition: Reservation has been added
 4) nextDay()
 Function:Incrments current day
 Precondition: Init has been ran
 Input: None
 Output parameters: None
 5) getInfo()
 Function:returns the day stored at current day
 Precondition: Init has been ran
 Input: None
 Output parameters:Day
 6) get_cur_Day()
 Function: returns current day
 Precondition: Init has been ran
 Input: None
 Output parameters: int*/
import java.util.ArrayList;

public class Calendar {
  private static int curDay=1;
  private static ArrayList<Day> dayInfo=new ArrayList<Day>();
  
  //Initializes static class to hold reservations, current day, and days
  public static void init(){
    for(int i=0; i<31; i++){
      dayInfo.add(new Day(Framework.NUM_DOUBLE_ROOMS,Framework.NUM_SINGLE_ROOMS));
    }
  }
  
  //Check if requested reservation is a valid choice, or if days are full
  public static boolean checkDays(int start, int end, int roomType){
    if(start>end){
      return false;
    }
    if(start<curDay || end>31){
      return false;
    }
    if(roomType==1){
      for(int i=0; i<=end-start; i++){
        if(dayInfo.get(start+i).getSingAvail()==0){
          return false;
        }
      }
    }
    else if(roomType==2){
      for(int i=0; i<=end-start; i++){
        if(dayInfo.get(start+i-1).getDoubAvail()==0){
          return false;
        }
      }
    }
    return true;
  }
  
  //add a reservation start to the proper day so it can be charged if needed
  public static boolean addReservation(int start, int end, int type, int resID){
    //if single room
    if(type==1){
      for(int i=0; i<=end-start; i++){
        dayInfo.get(start+i-1).decSingAvail();
        //(dayInfo.get(start+i-1)).addReservation(resID);
      }
    }
    //if double room
    else if(type==2){
      for(int i=0; i<=end-start; i++){
        dayInfo.get(start+i-1).decDoubAvail();
        //(dayInfo.get(start+i-1)).addReservation(resID);
      }
    }
    (dayInfo.get(start-1)).addReservation(resID);
    return true;
  }
  
  public static boolean removeReservation(int resID){
    Reservation res = Framework.getReservationByID(resID);
    int start = res.getStartDate();
    int end = res.getEndDate();
    int type = res.getRoomType();
    
    if(type==1){
      for(int i=0; i<=end-start; i++){
        dayInfo.get(start+i-1).incSingAvail();
        //(dayInfo.get(start+i-1)).addReservation(resID);
      }
    }
    //if double room
    else if(type==2){
      for(int i=0; i<=end-start; i++){
        dayInfo.get(start+i-1).incDoubAvail();
        //(dayInfo.get(start+i-1)).addReservation(resID);
      }
    }
    (dayInfo.get(start-1)).removeReservation(resID);
    return true;
  }
  
  //increments day
  public static int nextDay(){
    curDay++;
    return curDay;
  }
  
  //returns the day object of current day
  public static Day getInfo(){
    //System.out.print(curDay);
    return dayInfo.get(curDay-1);
  }
  //returns current date
  public static int get_cur_Day(){
    return curDay;
  }
}

