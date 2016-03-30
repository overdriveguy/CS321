import java.util.ArrayList;

//hold what rooms are in use
public class Rooms {
	//list of rooms, location in array goes to room #. Double is location+size of singles 
	private static ArrayList<Integer> sigRoomsInUse = new ArrayList<Integer>();
	private static ArrayList<Integer> doubRoomsInUse = new ArrayList<Integer>();
	private static int numSig;
	private static int numDob;
	
	public static void init(){
		numSig=Framework.NUM_SINGLE_ROOMS;
		numDob=Framework.NUM_DOUBLE_ROOMS;
		//set all to 0, meaning empty
		for(int i=0; i<numSig;i++){
			sigRoomsInUse.add(0);
		}
		for(int x=0; x<numDob;x++){
			doubleRoomsInUse.add(0);
		}
	}
	
	public static void fillRoom(int roomNum) {
		if(roomNum>numSig){
			doubRoomsInUse.set(roomNum-numSig-1, 1);
		}
		else{
			sigRoomsInUse.set(roomNum-1, 1);
		}
	}

	public static int getEmpty(int roomType) {
		// TODO Auto-generated method stub
		if(roomType==1){
			for(int i=0; i<numSig; i++){
				int t=sigRoomsInUse.get(i);
				if(t==0){
					return i+1;
				}
			}
		}
		else{
			for(int i=0; i<numDob; i++){
				int t=doubRoomsInUse.get(i);
				if(t==0){
					return i+numSig+1;
				}
			}
		}
		return 0;
	}
	
	public static void emptyRoom(int room){
		if(roomNum>numSig){
			doubRoomsInUse.set(roomNum-numSig-1, 0);
		}
		else{
			sigRoomsInUse.set(roomNum-1, 0);
		}
	}
}