public class ReservationSystem{
	public static void main(String[] args){
		//need calander for day
		try{
			Framework.init(args[0]);
			Calendar.init();
			Rooms.init();
			while(Framework.hasNextInstruction){
					String[] instructions=Framework.nextInstruction();
					int next=Integer.parseInt(instructions[0]);
					switch(next){
						case 1: //call  make reservation
								break;
						case 2: //call check in
								break;
						case 3: //call check out
								break;
						case 4: //call print management report
								break;
						case 5: //day change
								break;
						case 6: //6pm alarm
								break;
					}
			}
		}
		catch(Exception IOException){
			System.out.println("No such file found");
		}
	}
	
}
