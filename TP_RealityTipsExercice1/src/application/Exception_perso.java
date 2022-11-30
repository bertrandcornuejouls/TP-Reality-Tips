package application;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception_perso {

	public static String isPositive(int nb) throws IndexOutOfBoundsException {
		if ((nb <= 0)) {
		throw new IndexOutOfBoundsException(
		"le nombre entré qui est "
		+ nb
		+ " doit être > 0");
		}
		else return "Tout fonctionne";	
	}
	
	

	
	/*
	public void check(String date) throws ParseException {
       SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
       format.setLenient(false);
       try
       {
           Date d = format.parse(date); 
           System.err.println(date+" est une date valide");
       }
       // Date invalide
       catch (ParseException e)
       {
           System.err.println(date+" est une date invalide");
       }
	}
*/
		
	
	
	
	
	
}
