package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * This class is used to generate random context and situation
 * @author syue2
 *
 */
public class RandomGenerator {
	// class variable
	final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	final static java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
	final static Set<String> identifiers = new HashSet<String>();
	
	public static void main (String args[]) throws ParseException, IOException{

		BufferedWriter writer = new BufferedWriter(new FileWriter("config/samplefile1.txt"));
		//System.out.println(randomIdentifier());
		TimeHelper th = new TimeHelper("17-Jan-18 02:10:15");
		for(int i=0; i<5000; i++){
			 writer.write(th.getNextDate()+", "+
					randomLocation()+", "+randomResult()
			+", "+randomName());
			 writer.newLine();
		}
		writer.close();
	}

	//https://stackoverflow.com/questions/5025651/java-randomly-generate-distinct-names
	private static String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	

	//http://wcstitbits.blogspot.com/2012/05/generating-random-datetime-between-two.html
    public static String randomTime() throws ParseException{
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
        Calendar cal=Calendar.getInstance();
        String str_date1="17-Nov-18 02:10:15";
        String str_date2="27-Nov-18 02:10:20";

        cal.setTime(formatter.parse(str_date1));
        Long value1 = cal.getTimeInMillis();

        cal.setTime(formatter.parse(str_date2));
        Long value2 = cal.getTimeInMillis();

        long value3 = (long)(value1 + Math.random()*(value2 - value1));
        cal.setTimeInMillis(value3);
        return formatter.format(cal.getTime());
    }
    
    //We only consider three types of location here.
    enum Location 
    { 
        FAR, MIDUM, ARRIVE, HOME, GYM, DINNINGHALL, COFFEESHOP, ElevatorBuilding;
    } 
    private static final List<Location> VALUES =
    Collections.unmodifiableList(Arrays.asList(Location.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    
    public static Location randomLocation(){
    	return VALUES.get(RANDOM.nextInt(SIZE));
    	
    }
    
    //either take(the elevator) or pass(the elevator) 
    enum RESULT 
    { 
        TAKE, PASS; 
    } 
    private static final List<RESULT> VALUES2 =
    Collections.unmodifiableList(Arrays.asList(RESULT.values()));
    private static final int SIZE2 = VALUES2.size();
    
    public static RESULT randomResult(){
    	return VALUES2.get(RANDOM.nextInt(SIZE2));
    }
    
  //either take(the elevator) or pass(the elevator) 
    enum NAME 
    { 
        Mike, Frank, Joshua, Ted, Alice; 
    } 
    private static final List<NAME> VALUES3 =
    Collections.unmodifiableList(Arrays.asList(NAME.values()));
    private static final int SIZE3 = VALUES3.size();
    
    public static NAME randomName(){
    	return VALUES3.get(RANDOM.nextInt(SIZE3));
    }

    //to insert a record to a CSM, the program need to 

}
