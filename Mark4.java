import java.util.Scanner;
class Mark4{
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		
		String[][]studentDetails = new String[1][2];
		int [][] marks = new int[studentDetails.length][2];
		int [] total = new int [marks.length];

		while(true){
			int option = homePage(input);
			clearConsole();
			
			switch(option){
			case 1:
				writeLine();
				System.out.println("\n|\t\t\t\t"+"ADD NEW STUDENT"+"\t\t\t\t\t|");
				writeLine();
				System.out.println("");
					
				boolean moreStd =true;
				while(moreStd){
					boolean duplicate =true;
					while(duplicate){
						System.out.print("\nEnter Student ID\t: ");
						String stId = input.next();
	
						if(studentDetails.length == 1){
							studentDetails[studentDetails.length-1][0] = stId;
							break;
						}else{
							duplicate =duplicateCheck(stId , studentDetails);
						}
			
					studentDetails [studentDetails.length-1][0]= stId;
					}
						
					System.out.print("Enter Student Name\t: ");
					studentDetails [studentDetails.length-1][1]= input.next(); 
				
					System.out.print("Student has been added successfully. ");
					
					studentDetails=extendArray(studentDetails);
					
					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("Do you want to add a new student[Y/N] : ");
						char choise =input.next().charAt(0);
						
						if(choise =='y' || choise == 'Y'){
							choiseWhat = false;
							continue;
						}else if(choise =='n' || choise == 'N'){
							moreStd = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}
					}
				}
	
			break;
			
			case 2:
				writeLine();
				System.out.println("\n|\t\t\t"+"ADD NEW STUDENT WITH MARKS"+"\t\t\t\t\t\t|");
				writeLine();
				System.out.println("");
					
				boolean stdWithMarks =true;
				while(stdWithMarks){
					boolean duplicate =true;
					while(duplicate){
						System.out.print("\nEnter Student Id\t: ");
						String stId = input.next();
	
						if(studentDetails.length == 1){
							studentDetails[studentDetails.length-1][0] = stId;
							break;
						}else{
							duplicate =duplicateCheck(stId , studentDetails);
						}
						studentDetails [studentDetails.length-1][0]= stId;
					}
						
					System.out.print("Enter Student Name\t: ");
					studentDetails [studentDetails.length-1][1]= input.next(); 
					System.out.println("");
						
					studentDetails=extendArray(studentDetails);
						
					marks= extendArray(studentDetails , marks);
						
					boolean markTrue =true;
					while(markTrue){
						System.out.print("Programming Fundamentals Marks\t\t: ");
						int prfMarks = input.nextInt();
							
						if(prfMarks >=0 && prfMarks <101){
							marks [marks.length-2][0] = prfMarks;
							markTrue=false;
						}else{
							System.out.println("Invalied marks. Plese enter correct marks.");
						}
					}

					markTrue = true;
					while(markTrue){
						System.out.print("Database Management System Marks\t: ");
						int dbmsMarks = input.nextInt();
							
						if(dbmsMarks >=0 && dbmsMarks <101){
							marks [marks.length-2][1] = dbmsMarks;
							markTrue=false;
						}else{
							System.out.println("Invalied marks. Plese enter correct marks.");
						}
					}
					System.out.print("\nStudent has been added successfully. ");

					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("Do you want to add a new student[Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='y' || choise == 'Y'){
							choiseWhat = false;
							continue;
						}else if(choise =='n' || choise == 'N'){
							stdWithMarks = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}
					}
						
				}
			break;
			
			case 3:
				writeLine();
				System.out.println("\n|\t\t\t\t"+"ADD MARKS"+"\t\t\t\t\t\t|");
				writeLine();
				System.out.println("");
				
				boolean marksAdd =true;
				while(marksAdd){
					boolean trueStd = true;
					
					System.out.print("\nEnter Student Id\t: ");
					String stId = input.next();
					
					int search = searchStd(studentDetails, stId);
					marks =extendArray(studentDetails,marks);
					if(search == -1){
						System.out.print("Invalied Student Id. ");
					} else {
						System.out.print("Student Name\t\t: "+studentDetails[search][1]+"\n");
						
						if(marks[search][0] != 0 && marks[search][1] != 0){
							System.out.println("This student's marks have been already added.");
							System.out.println("If you want to update the marks, plese use [4] update marks option.");
						
						}else{
							boolean markTrue =true;
							while(markTrue){
								System.out.print("Programming Fundermental Marks :");
								int prfMarks = input.nextInt();
								
								if(prfMarks >=0 && prfMarks <101){
									marks [search][0] = prfMarks;
									markTrue=false;
								}else{
									System.out.println("Invalied marks. Plese enter correct marks.");
								}
							}
					
							markTrue = true;
							while(markTrue){
								System.out.print("Database Management System Marks :");
								int dbmsMarks = input.nextInt();
								
								if(dbmsMarks >=0 && dbmsMarks <101){
									marks [search][1] = dbmsMarks;
									markTrue=false;
								}else{
									System.out.println("Invalied marks. Plese enter correct marks.");
								}
							}
							System.out.print("Marks have been added. ");
						}
					}
					
					
					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("Do you want to search again[Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='y' || choise == 'Y'){
							choiseWhat = false;
							continue;
						}else if(choise =='n' || choise == 'N'){
							marksAdd = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}	
					}
				}
				
			break;
			
			case 4 :
				writeLine();
				System.out.println("|\t\t\t"+"UPDATE STUDENT DETAILS"+"\t\t\t\t\t|");
				writeLine();
				System.out.println("");

				boolean updateTrue= true;
				while (updateTrue){
					System.out.print("\nEnter Student Id : ");
					String stId = input.next();
					
					int search = searchStd(studentDetails, stId);
					if(search == -1){
						System.out.print("Invalied Student Id. ");
					}else {
						System.out.print("Student Name : "+studentDetails[search][1]+"\n");
						System.out.print("\nEnter the new Student name : ");
						String newName = input.next();
						
						studentDetails[search][1] = newName;
					}
					
					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("Do you want to update another student details [Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='y' || choise == 'Y'){
							choiseWhat = false;
							continue;
						}else if(choise =='n' || choise == 'N'){
							updateTrue = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}	
					}
				}
			break;
			
			case 5:
				writeLine();
				System.out.println("|\t\t\t\t"+"UPDATE MARKS"+"\t\t\t\t\t|");
				writeLine();
				System.out.println("");
				
				boolean markUpdate = true;
				while(markUpdate){
					
					System.out.print("\nEnter Student Id\t: ");
					String stId = input.next();
					
					int search = searchStd(studentDetails, stId);
					if(search == -1){
						System.out.print("Invalied Student Id. ");
					}else {
						System.out.print("Student Name\t\t: "+studentDetails[search][1]+"\n");
						
						if(marks[search][0] != 0 && marks[search][1] != 0){
							System.out.println("\nProgramming fundermental marks\t\t: "+marks[search][0]);
							System.out.println("Detabase management system marks\t: "+marks[search][1]);
							
							boolean markTrue =true;
							while(markTrue){
								System.out.print("\nEnter new Programming Fundermental Marks\t:");
								int prfMarks = input.nextInt();
								
								if(prfMarks >=0 && prfMarks <101){
									marks [search][0] = prfMarks;
									markTrue=false;
								}else{
									System.out.println("Invalied marks. Plese enter correct marks.");
								}
							}
							
							markTrue = true;
							while(markTrue){
								System.out.print("Enter new Database Management System Marks\t:");
								int dbmsMarks = input.nextInt();
								
								if(dbmsMarks >=0 && dbmsMarks <101){
									marks [search][1] = dbmsMarks;
									markTrue=false;
								}else{
									System.out.println("Invalied marks. Plese enter correct marks.");
								}
							}
							System.out.println("Marks have been update successfully. ");
							
							
						}else{
							System.out.println("\nThis student's marks yet to be added.");
						}
						
					}
					
					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("Do you want to update marks for anouther student? [Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='y' || choise == 'Y'){
							choiseWhat = false;
							continue;
						}else if(choise =='n' || choise == 'N'){
							markUpdate = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}	
					}
				}
			break;
			
			case 6:
				writeLine();
				System.out.println("|\t\t\t\t"+"DELETE STUDENT"+"\t\t\t\t\t|");
				writeLine();
				System.out.println("");
				
				boolean delete = true;
				while(delete){
					
					System.out.print("\nEnter Student Id : ");
					String stId = input.next();
					
					int search = searchStd(studentDetails, stId);
					if(search == -1){
						System.out.print("Invalied Student Id. ");
					}else {
						studentDetails = deleteStDetails(studentDetails,stId);
						marks = deleteStDetails(marks, search);
					}
					
					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("Do you want to delete anouther student [Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='y' || choise == 'Y'){
							choiseWhat = false;
							continue;
						}else if(choise =='n' || choise == 'N'){
							delete = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}	
					}
				}
			
			break;
			
			case 7:
				writeLine();
				System.out.println("\n|\t\t\t"+"PRINT STUDENT DETAILS"+"\t\t\t\t\t\t|");
				writeLine();
				System.out.println("");
				
				boolean printDetails = true;
				while(printDetails){

					System.out.print("\nEnter Student Id\t: ");
					String stId = input.next();
					
					int search = searchStd(studentDetails, stId);
					if(search == -1){
						System.out.print("Invalied Student Id. ");
					}else {
						System.out.print("Student Name\t: "+studentDetails[search][1]+"\n");
						
						if(marks[search][0] == 0 && marks[search][1]==0){
							System.out.println("\nMarks yet to be added. ");
						}else{
							total=extendArray(total,marks);
							System.out.println("+-----------------------------------+------------+");
							System.out.printf("|%-35s|%12d|","Programming Fundermental marks",marks[search][0]);
							System.out.printf("\n|%-35s|%12d|","Database Management System marks",marks[search][1]);
							System.out.printf("\n|%-35s|%12d|","Total marks",total[search]);
							System.out.printf("\n|%-35s|%12.2f|","AVG marks",(double)total[search]/2);
							
							int tempTot = total[search];
							total = sortTotal(total);
							int studentRank = rank(total, tempTot)+1;
							
							switch(studentRank){
								case 1:
									System.out.printf("\n|%-35s|%5d%7s|","Rank",studentRank,"(First)");
									break;
								case 2:
									System.out.printf("\n|%-35s|%4d%8s|","Rank",studentRank,"(Second)");
									break;
								case 3:
									System.out.printf("\n|%-35s|%5d%7s|","Rank",studentRank,"(Third)");
									break;
								default:
									System.out.printf("\n|%-35s|%12d|","Rank",studentRank);
							}
							System.out.println("\n+-----------------------------------+------------+");
							
						}
					}

					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("\nDo you want to search anouther student details? [Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='y' || choise == 'Y'){
							choiseWhat = false;
							continue;
						}else if(choise =='n' || choise == 'N'){
							printDetails = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}	
					}
				}
			break;
			
			case 8:
				writeLine();
				System.out.println("\n|\t\t\t\t"+"PRINT STUDENTS' RANKS"+"\t\t\t\t\t|");
				writeLine();
				System.out.println("");
				
				boolean printRanks = true;
				while(printRanks){

					total=extendArray(total,marks);
					int[] tempTot = new int[total.length];
					for(int i =0; i<total.length;i++){
						tempTot[i]=total[i];
					}
					total = sortTotal(total);
					
					System.out.println("+-----+------+--------------------+-----------+-----------+");
					System.out.printf("|%-5s|%-6s|%-20s|%11s|%11s|","Rank","ID","Name","Total Marks","Avg.Marks");
					System.out.println("\n+-----+------+--------------------+-----------+-----------+");
					for(int i =0; i<total.length-1; i++){
						int sortTot = total[i];
	
						int index= rank(tempTot,sortTot);

						System.out.printf("|%-5d|%-6s|%-20s|%11d|%11.2f|\n",(i+1) , studentDetails[index][0] ,studentDetails[index][1], tempTot[index], (double)tempTot[index]/2);
					}
					System.out.println("+-----+------+--------------------+-----------+-----------+");

					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("\nDo you want to go back to main menu? [Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='n' || choise == 'N'){
							choiseWhat = false;
							continue;
						}else if(choise =='y' || choise == 'Y'){
							printRanks = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}	
					}
				}
				
			break;
			
			case 9:
				writeLine();
				System.out.println("\n|\t\t\t"+"BEST IN PROGRAMMING FUNDAMENTALS"+"\t\t\t\t\t\t|");
				writeLine();
				System.out.println("");
				
				int markIndex =0;
				boolean printPrf = true;
				while(printPrf){
					
					int[] tempPrf = new int[marks.length];
					for(int i =0; i<marks.length;i++){
						tempPrf[i]=marks[i][0];
					}
					tempPrf = sortTotal(tempPrf);
					
					System.out.println("+------+--------------------+-----------+-----------+");
					System.out.printf("|%-6s|%-20s|%11s|%11s|","ID","Name","PRF Marks","DBMS Marks");
					System.out.println("\n+------+--------------------+-----------+-----------+");
					
					for(int i =0; i<marks.length-1; i++){
						int sortPrf = tempPrf[i];
						int index= rank(marks,sortPrf,markIndex);
						
						System.out.printf("|%-6s|%-20s|%-11d|%-11d|\n", studentDetails[index][0] ,studentDetails[index][1], marks[index][0], marks[index][1]);

					}
					System.out.println("+------+--------------------+-----------+-----------+");
					
					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("\nDo you want to go back to main menu? [Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='n' || choise == 'n'){
							choiseWhat = false;
							continue;
						}else if(choise =='Y' || choise == 'y'){
							printPrf = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}	
					}
				}
			break;
			
			case 10:
				writeLine();
				System.out.println("\n|\t\t\t"+"BEST IN DATABASE MANAGEMENT SYSTEM"+"\t\t\t\t\t\t|");
				writeLine();
				System.out.println("");
				markIndex =1;
				boolean printDbms = true;
				while(printDbms){
					
					int[] tempPrf = new int[marks.length];
					for(int i =0; i<marks.length;i++){
						tempPrf[i]=marks[i][1];
					}
					tempPrf = sortTotal(tempPrf);
					
					System.out.println("+------+--------------------+-----------+-----------+");
					System.out.printf("|%-6s|%-20s|%11s|%11s|","ID","Name","DBMS Marks","PRF Marks");
					System.out.println("\n+------+--------------------+-----------+-----------+");
					for(int i =0; i<marks.length-1; i++){
						int sortPrf = tempPrf[i];
						int index= rank(marks,sortPrf,markIndex);
						
						System.out.printf("|%-6s|%-20s|%-11d|%-11d|\n", studentDetails[index][0] ,studentDetails[index][1], marks[index][1], marks[index][0]);
						
					}
					System.out.println("+------+--------------------+-----------+-----------+");
					
					boolean choiseWhat = true;
					while(choiseWhat){
						System.out.print("\nDo you want to go back to main menu? [Y/N] : ");
						char choise =input.next().charAt(0);
							
						if(choise =='n' || choise == 'N'){
							choiseWhat = false;
							continue;
						}else if(choise =='y' || choise == 'Y'){
							printDbms = false;
							choiseWhat = false;
							clearConsole();
						}else{
							System.out.println("Wrong input");
						}	
					}
				}
			break;
			}
		}		
	}
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
			} catch (final Exception e) {
				e.printStackTrace();
			}
	}
	public static void writeLine(){
		for(int i=0; i<80; i++){
			System.out.print("-");
		}
	}
	public static int homePage(Scanner input){
		writeLine();
		System.out.println("\n|\t\t"+"WELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t\t"+"|");
		writeLine();
		System.out.println("");

		System.out.println("\n[1] Add New Student\t\t\t[2] Add New Student With Marks");
		System.out.println("[3] Add Marks\t\t\t\t[4] Update Student Details");
		System.out.println("[5] Update Marks\t\t\t[6] Delete Student");
		System.out.println("[7] Print Student Details\t\t[8] Print Student Ranks");
		System.out.println("[9] Best in Programming Fundermental\t[10] Best in Detabase Management System");
		int option=0;
		boolean opLoop = true;
		while(opLoop){
			System.out.print("\nEnter an option to continue > ");
			option = input.nextInt();
				if(option<11){
					opLoop = false;
				}else{
					System.out.println("Invalied Option Input. Try Again!");
				}
		}
		return option;
	}
	
	public static boolean duplicateCheck(String stId , String[][]studentDetails){
			for(int i=0; i<studentDetails.length-1; i++){
				if(studentDetails[i][0].equals(stId)){
					System.out.println("The Student ID already exists.");
					return true;
				}
		}	
		return false;
	}
	public static String[][] extendArray(String [][] studentDetais){
		String [][]temp = new String[studentDetais.length+1][2];
		
		for(int i=0; i< studentDetais.length; i++){
			for(int a=0; a<2; a++){
				temp[i][a] = studentDetais [i][a];
			}
		}
		return temp;
	}
	public static int[][] extendArray(String [][] studentDetails, int[][] marks){
		int [][]temp = new int [studentDetails.length][2];
		
		for(int i=0; i< marks.length; i++){
			for(int a=0; a<2; a++){
				temp[i][a] = marks [i][a];
			}
		}
		return temp;
	}
	public static int[] extendArray(int [] total, int[][] marks){
		int []temp = new int [marks.length];
		
		for(int i=0; i< marks.length; i++){
				temp[i] = marks [i][0] + marks [i][1];
		}
		return temp;	
	}
	public static int searchStd(String[][] studentDetails, String stId){
		for (int i =0; i<studentDetails.length-1; i++){
			if(studentDetails[i][0].equals(stId)){
				return i;
			}
		}
		return -1;
	}
	public static String [][] deleteStDetails(String [][] studentDetails , String stId){
		String [][] newStudentDetails = new String[studentDetails.length-1][2];
		
		for (int i =0, x =0; i<studentDetails.length-1; i++){
			if(! studentDetails[i][0].equals (stId)){
				newStudentDetails[x][0] = studentDetails[i][0];
				newStudentDetails[x][1] = studentDetails[i][1];
				x++;
			}
		}
		return newStudentDetails;
	}
	public static int [][] deleteStDetails(int [][] marks , int search){
		int [][] newMarks = new int[marks.length-1][2];
		
		for (int i =0, x =0; i<marks.length-1; i++){
			if(i != search){
				newMarks[x][0] = marks[i][0];
				newMarks[x][1] = marks[i][1];
				x++;
			}
		}
		return newMarks;
	}
	public static int[] sortTotal(int[] arr){
		for (int i = 0; i < arr.length; i++){  
			for (int j = i + 1; j < arr.length; j++){  
				int tmp = 0;  
				if (arr[i] < arr[j]){  
					tmp = arr[i];  
					arr[i] = arr[j];  
					arr[j] = tmp;  
				}  
			}
		}
		return arr;
	}
	public static int rank(int []total, int tempTot){
		for(int i=0; i<total.length-1; i++){
			if(total[i]==tempTot){
				return i;
			}
		}
		return 0;
	}
	public static int rank(int [][]marks, int sortPrf,int markIndex){
		for(int i=0; i<marks.length-1; i++){
			if(marks[i][markIndex]==sortPrf){
				return i;
			}
		}
		return 0;
	}

}










