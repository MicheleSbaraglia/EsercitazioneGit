package it.micra.testgit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) {

		for (int i = 0; i < Utility.getCount(); i++) {
			System.out.println(Utility.getTitle()+" - " + i + "!!!!");
		}
		System.out.println(Utility.getTitle2());
		System.out.println("babone!!");
		System.out.println("Valeriotticchionaa");
		System.out.println("Valeriottacciabu");
		System.out.println("ValeriottacciaBis");
		System.out.println("ValeriottacciaBis3");
		
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Date date = sdf.parse("29/02/2016");
			
			Calendar c = Calendar.getInstance();
			System.out.println(sdf.format(c.getTime()));
			c.setTime(date);
			System.out.println(sdf.format(c.getTime()));
			c.add(Calendar.YEAR, -1);
			
			
			
			System.out.println(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
