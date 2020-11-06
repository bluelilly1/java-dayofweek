/**
 * 
 */
package dayOfWeekFinder;
import java.util.Scanner;

public class DayOfWeekFinder {
	
	
	public static void main(String[] args) {
		//user interface
		Scanner check = new Scanner(System.in);
		System.out.println("Enter the date: ");
		String date = check.nextLine();
		String[] dateSplit = date.split("/");
		int Month = Integer.parseInt(dateSplit[0]);
		int Days = Integer.parseInt(dateSplit[1]);
		int Year = Integer.parseInt(dateSplit[2]);
		
		//System.out.println(year);
		System.out.println("Day is " + Days + "Month is " + Month + "Year is " + Year);
		
		//odd days in the year
		Year -= 1;
		Year = Year % 400;
		int OddDays = Year / 300;
		System.out.println("OddDays 1:" + OddDays);			
		Year = Year % 300;
		OddDays += 3 * (Year / 200);
		Year %= 200;
		OddDays += 5 * (Year / 100);
		Year %= 100;
		// every year we have one odd day
		int leapYears=0;
		if (Month>2) {
			leapYears = ((Year+1) / 4) % 7;
		}
		else {
			leapYears = (Year / 4) % 7;			
		}
		Year %= 7; 
		OddDays += Year;
		OddDays += leapYears;
		System.out.println("OddDays in a Year is:" + OddDays);
		//String YearOddDays = String.valueOf(OddDays);
		//System.out.println(YearOddDays);
		
		//months
		int OddDaysM = 0;
		Month -= 1; // equals the num of months from january
		int value1 = 31 % 7;
		int value2 = 30 % 7; 
		int [] MonthOddValues = {value1, 0, value1, value2, value1, value2, value1, value1, value2, value1, value2, value1};
		//OddDaysM = MonthOddValues[Month - 1];
		//add all the odd days for each month until we reach the final month
		for (int count = 0; count < Month; count++) {
			OddDaysM += MonthOddValues[count];
		}
		System.out.println("OddDays in a Month is:" + OddDaysM);
		
		//days
		Days %= 7;
		
		// totals
		int totalOddDays = (Days + OddDaysM + OddDays) % 7;
		System.out.println(totalOddDays);
		
	}

}
