package application.model;

public class Year {

	Month[] months = new Month[12];
	int year;
	boolean isLeapYear;
	
	public Year() {
		
	}
	
	public Year( Month[] m, int yrNum, boolean lp ) {
		months = m;
		year = yrNum;
		isLeapYear = lp;
	}
	
	public boolean isLeap( int yearNum ) {
		
		// Every year that is exactly divisible by four is a leap year, 
		// except for years that are exactly divisible by 100, but these 
		// centurial years are leap years if they are exactly divisible by 400. 
		// For example, the years 1700, 1800, and 1900 are not leap years, but the years 1600 and 2000 are.
		
		if ( yearNum%4 == 0 ) {										// Leap year rules
			if ( yearNum%100 == 0 ) {								// Not a leap year if divisibile by 100, unless divisible by 400
				if ( yearNum%400 == 0 ) {							// If div by 400, it is a leap year
					return true;									// Changes year to leap year;
				}
			}
			else {													// If it isn't divisible by 100, then it is a leap year :)
				return true;										// Changes year to leap year
			}
		}
		return false;
	}
	
	
	public Year generateYear( int yr ) {							// This will generate a year and return a full calendar year
		
		Month[] monthsForYear = new Month[12];
		int numLeap = 0;											// Will not generate prior to 1995?
		int[] monthLengths = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if ( isLeap(yr) ) monthLengths[1] = 29;
		
		//First thing to deal with is figuring out which day of the week it starts on
		//1995 started on a sunday, going to use that as a reference
		
		//int firstLeap = 1995+(4-(1995%4));							// Will get the first year <-- change this line when implementing years before 1995 :)
		int firstLeap = 1996;
		if ( !isLeap(firstLeap) ) firstLeap+=4;									// Case where the first leap is not an actual leap year, and is %100 and not %400
		for ( int i = firstLeap; i < yr; i+=4 ) {
			if ( isLeap(i) ) numLeap++;
		}
		int start = (( yr - 1995 )+numLeap)%7;						// Gives the displacement, aka which day of the week that January 1 starts on
		int end = (start+30)%7;										// 31 - 1 = 30, used to get the ACTUAL last date and not the first day of the next month
		
		monthsForYear[0] = new Month(start,end,monthLengths[0]);	// Sets January to the first value in monthsForYear
		
		for ( int i = 1; i < 12; i++ ) {							// Loop to load in all of the 
			start = (end+1)%7;
			end = (start+monthLengths[i]-1)%7;
			monthsForYear[i] = new Month(start,end,monthLengths[i]);
		}
		
		return new Year(monthsForYear, yr, isLeap(yr) );
	}
	
	@Override
	public String toString() {
		String temp = year+"\n";
		String[] days = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
		for ( int i = 0; i < 12; i++ ) {
			temp+="Month: " + (i+1) + "\n";
			temp+="Month starts on a " + days[months[i].start] + " and ends on a " + days[months[i].end] + "\n";
		}
		return temp;
	}
	
	
	
}
