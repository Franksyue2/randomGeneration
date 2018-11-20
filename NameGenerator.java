package utility;

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

public class NameGenerator {
	// class variable
	final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	final static java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
	final static Set<String> identifiers = new HashSet<String>();
	
	public static void main (String args[]) throws ParseException{
		System.out.println(randomIdentifier());
		randomTime();
		randomLocation();
		randomResult();
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
	
	//
	private static String randomName() {
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
    public static void randomTime() throws ParseException{
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
        Calendar cal=Calendar.getInstance();
        String str_date1="17-June-07 02:10:15";
        String str_date2="27-June-07 02:10:20";

        cal.setTime(formatter.parse(str_date1));
        Long value1 = cal.getTimeInMillis();

        cal.setTime(formatter.parse(str_date2));
        Long value2 = cal.getTimeInMillis();

        long value3 = (long)(value1 + Math.random()*(value2 - value1));
        cal.setTimeInMillis(value3);
        System.out.println(formatter.format(cal.getTime()));
    }
    
    //We only consider three types of location here.
    enum Location 
    { 
        FAR, MIDUM, ARRIVE, HOME, GYM, DINNINGHALL, COFFEESHOP;
    } 
    private static final List<Location> VALUES =
    Collections.unmodifiableList(Arrays.asList(Location.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Location randomLetter()  {
    	return VALUES.get(RANDOM.nextInt(SIZE));
    }
    
    public static void randomLocation(){
    	System.out.println(VALUES.get(RANDOM.nextInt(SIZE)));
    	
    }
    
    //either take(the elevator) or pass(the elevator) 
    enum RESULT 
    { 
        TAKE, PASS; 
    } 
    private static final List<RESULT> VALUES2 =
    Collections.unmodifiableList(Arrays.asList(RESULT.values()));
    private static final int SIZE2 = VALUES2.size();
    
    public static void randomResult(){
    	System.out.println(VALUES2.get(RANDOM.nextInt(SIZE2)));
    }

    

}
