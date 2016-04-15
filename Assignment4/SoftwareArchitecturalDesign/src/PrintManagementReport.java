
public class PrintManagementReport {
	
	public static String viewReport(String[] input){
		
		int given_date = (int)input[1];
		
		if (given_date == Calendar.get_cur_Day()){
			return Report.makeReport_curDay();
		}else{
			if((given_date > 0)&&(given_date < Calendar.get_cur_Day())){
				return Report.get_report(given_date);
			}else{
				return "INVALID DATE\n";
			}
		}
	}
}
