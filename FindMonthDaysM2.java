class FindMonthDaysM2{
	public static void main (String args[]){
		int weekNum=4;
		switch(weekNum){
			case 1:case 3:case 5:case 7:case 8:case 10:case 12
			:System.out.println("31 Days");
			break;
			case 2:System.out.println("28 Days");
			break;
			case 4:case 6:case 9:case 11:
			default :System.out.println("This not month number");
		}
	}
}