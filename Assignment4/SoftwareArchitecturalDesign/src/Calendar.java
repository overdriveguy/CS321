import java.util.ArrayList;

public class Calendar {
	private static int curDay=0;
	private static ArrayList<Hotel> dayInfo=new ArrayList<Hotel>();
	//2d array of signed in customers
	
	public static void init(){
		for(int i=0; i<31; i++){
			dayInfo.add(new Hotel());
		}
	}
	
	public static boolean checkDays(int start, int end, int roomType){
		if(roomType==1){
			for(int i=0; i<=end-start; i++){
				if(dayInfo.get(start+i).getSingleRoom()==0){
					return false;
				}
			}
		}
		else if(roomType==2){
			for(int i=0; i<=end-start; i++){
				if(dayInfo.get(start+i).getDoubleRoom()==0){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean addReservation(int start, int end, int type){
		if(type==1){
			for(int i=0; i<=end-start; i++){
				dayInfo.get(start+i).addSingleRoom();
			}
		}
		else if(type==2){
			for(int i=0; i<=end-start; i++){
				dayInfo.get(start+i).addDoubleRoom();			
			}
		}
		return true;
	}
	
	public static int nextDay(){
		curDay++;
		return curDay;
	}
}

