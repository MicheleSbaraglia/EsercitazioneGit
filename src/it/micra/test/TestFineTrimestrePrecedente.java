package it.micra.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestFineTrimestrePrecedente {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	public static void main(String[] args) {
		
		Calendar dtContabile = Calendar.getInstance();
		dtContabile.set(2006, 0, 21);
		Date dataContabile = dtContabile.getTime();
		
		System.out.println("DATA CONTABILE: " + sdf.format(dataContabile) + "\n\n");
		
		Date trimestre = calcolaTrimestre(dataContabile);
		
		if(trimestre != null){
			System.out.println("\n\nTRIMESTRE DI RIFERIMENTO: " + sdf.format(trimestre));
		}

		
	}
	
	private static Date calcolaTrimestre(Date dataContabile){
		Date result = null;
		
		//DICEMBRE
		Calendar primoTrimestre = Calendar.getInstance();
		primoTrimestre.setTime(dataContabile);
		primoTrimestre.add(Calendar.YEAR, -1);
		primoTrimestre.set(Calendar.MONTH,primoTrimestre.getActualMaximum(Calendar.MONTH));	
		primoTrimestre.set(Calendar.DATE,primoTrimestre.getActualMaximum(Calendar.DAY_OF_MONTH));
		primoTrimestre.clear(Calendar.HOUR);
		primoTrimestre.clear(Calendar.MINUTE);
		primoTrimestre.clear(Calendar.SECOND);
		primoTrimestre.clear(Calendar.MILLISECOND);
		System.out.println("PRIMO TRIMESTRE: " + sdf.format(primoTrimestre.getTime()));
		
		//MARZO
		Calendar secondoTrimestre = Calendar.getInstance();
		secondoTrimestre.setTime(dataContabile);
		secondoTrimestre.set(Calendar.MONTH,Calendar.MARCH);	
		secondoTrimestre.set(Calendar.DATE,secondoTrimestre.getActualMaximum(Calendar.DAY_OF_MONTH));
		secondoTrimestre.clear(Calendar.HOUR);
		secondoTrimestre.clear(Calendar.MINUTE);
		secondoTrimestre.clear(Calendar.SECOND);
		secondoTrimestre.clear(Calendar.MILLISECOND);
		System.out.println("SECONDO TRIMESTRE: " + sdf.format(secondoTrimestre.getTime()));
		
		//GIUGNO
		Calendar terzoTrimestre = Calendar.getInstance();
		terzoTrimestre.setTime(dataContabile);
		terzoTrimestre.set(Calendar.MONTH,Calendar.JUNE);	
		terzoTrimestre.set(Calendar.DATE,terzoTrimestre.getActualMaximum(Calendar.DAY_OF_MONTH));
		terzoTrimestre.clear(Calendar.HOUR);
		terzoTrimestre.clear(Calendar.MINUTE);
		terzoTrimestre.clear(Calendar.SECOND);
		terzoTrimestre.clear(Calendar.MILLISECOND);
		System.out.println("TERZO TRIMESTRE: " + sdf.format(terzoTrimestre.getTime()));
		
		//SETTEMBRE
		Calendar quartoTrimestre = Calendar.getInstance();
		quartoTrimestre.setTime(dataContabile);
		quartoTrimestre.set(Calendar.MONTH,Calendar.SEPTEMBER);	
		quartoTrimestre.set(Calendar.DATE,quartoTrimestre.getActualMaximum(Calendar.DAY_OF_MONTH));
		quartoTrimestre.clear(Calendar.HOUR);
		quartoTrimestre.clear(Calendar.MINUTE);
		quartoTrimestre.clear(Calendar.SECOND);
		quartoTrimestre.clear(Calendar.MILLISECOND);
		System.out.println("QUARTO TRIMESTRE: " + sdf.format(quartoTrimestre.getTime()));
		
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
