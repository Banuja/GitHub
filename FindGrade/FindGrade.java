class FindGrade{
	public static void main (String args[]){
		int marks = 32;
		if (marks>=75){
			System.out.println("Grade A");
		}else if(75> marks && marks>=65){
			System.out.println("Grade B");
		}else if(65> marks && marks>=55){
			System.out.println("Grade C");
		}else if(55> marks && marks>=35){
			System.out.println("Grade S");
		}else{
			System.out.println("Grade F");
		}
				
	}
}