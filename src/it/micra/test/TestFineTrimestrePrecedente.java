package it.micra.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestFineTrimestrePrecedente {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	public static void main(String[] args) {
			
		Date dataContabile = null;
		try {
			dataContabile = sdf.parse("01/01/2015");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("DATA CONTABILE: " + sdf.format(dataContabile) + "\n\n");
		
		Date trimestre = calcolaTrimestre(dataContabile);
		
		if(trimestre != null){
			System.out.println("\n\nTRIMESTRE DI RIFERIMENTOccc: " + sdf.format(trimestre));
		}	
		
	}
	
	private static Date calcolaTrimestre(Date dataContabile){
		Date result = null;
		
		//DICEMBRE
		Calendar primoTrimestre = Calendar.getInstance();
		primoTrimestre.setTime(dataContabile);
		primoTrimestre.add(Calendar.YEAR, -1);
		primoTrimestre.set(Calendar.DATE,primoTrimestre.getActualMinimum(Calendar.DAY_OF_MONTH));
		primoTrimestre.set(Calendar.MONTH,Calendar.DECEMBER);	
		primoTrimestre.set(Calendar.DATE,primoTrimestre.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("PRIMO TRIMESTRE: " + sdf.format(primoTrimestre.getTime()));
		
		//MARZO
		Calendar secondoTrimestre = Calendar.getInstance();
		secondoTrimestre.setTime(dataContabile);	
		secondoTrimestre.set(Calendar.DATE,secondoTrimestre.getActualMinimum(Calendar.DAY_OF_MONTH));
		secondoTrimestre.set(Calendar.MONTH,Calendar.MARCH);
		secondoTrimestre.set(Calendar.DATE,secondoTrimestre.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("SECONDO TRIMESTRE: " + sdf.format(secondoTrimestre.getTime()));
		
		//GIUGNO
		Calendar terzoTrimestre = Calendar.getInstance();
		terzoTrimestre.setTime(dataContabile);
		terzoTrimestre.set(Calendar.DATE,terzoTrimestre.getActualMinimum(Calendar.DAY_OF_MONTH));
		terzoTrimestre.set(Calendar.MONTH,Calendar.JUNE);
		terzoTrimestre.set(Calendar.DAY_OF_MONTH,terzoTrimestre.getActualMaximum(Calendar.DAY_OF_MONTH));		
		System.out.println("TERZO TRIMESTRE: " + sdf.format(terzoTrimestre.getTime()));
		
		//SETTEMBRE
		Calendar quartoTrimestre = Calendar.getInstance();		
		quartoTrimestre.setTime(dataContabile);
		quartoTrimestre.set(Calendar.DATE,quartoTrimestre.getActualMinimum(Calendar.DAY_OF_MONTH));
		quartoTrimestre.set(Calendar.MONTH,Calendar.SEPTEMBER);
		quartoTrimestre.set(Calendar.DATE,quartoTrimestre.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("QUARTO TRIMESTRE4: " + sdf.format(quartoTrimestre.getTime()));
		
		if(dataContabile.before(secondoTrimestre.getTime())){
			result = primoTrimestre.getTime();
		}else if(dataContabile.before(terzoTrimestre.getTime())){
			result = secondoTrimestre.getTime();
		}else if(dataContabile.before(quartoTrimestre.getTime())){
			result = terzoTrimestre.getTime();
		}else{
			result = quartoTrimestre.getTime();
		}	
		
		return result;
		
	}

}
