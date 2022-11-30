package application;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ApplicationController {

	
	
	
	@FXML
	private Label bill;
	
	@FXML
	private Label tip;
	
	@FXML
	private Label nbpeople;
	
	@FXML
	private Label tipperson;
	
	@FXML
	private Label totalperson;
	
	@FXML
	private Label affichage_tipperson;
	
	@FXML
	private Label affichage_totalperson;
	
	@FXML
	private Button calculate;
	
	@FXML
	private TextField tfbill;
	
	@FXML
	private TextField tftip;
	
	@FXML
	private TextField tfnbpeople;
	
	@FXML
	private TextField tfdate;
	
	@FXML
	private Label isDate;
	
	/*
	Date d = Calendar.getInstance().getTime();  
    DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
    String sDate = df.format(d); 
    date.setText(sDate);
    */
    
    //System.out.println("String in form of Date is : " + sDate);
	
	
	//DateTimeFormatter formatter = DateTimeFormat.forPattern( "MM/dd/yyyy" ); // Single `M` and `d` allows user to enter single or double digits.
	
	
	

	
	
	public void clickMe(ActionEvent e) throws IndexOutOfBoundsException, ParseException, IOException, ClassNotFoundException {
		
		try {

			
			int a = 0;
			int total = 0;
			
			
			String dateEntree = tfdate.getText();

			check(tfdate.getText(), isDate);
			

			
			Integer.parseInt(tfnbpeople.getText());
			Integer.parseInt(tfbill.getText());
			Integer.parseInt(tftip.getText());
			
			
			
			System.out.println(Exception_perso.isPositive(Integer.valueOf(tfnbpeople.getText())));
			System.out.println(Exception_perso.isPositive(Integer.valueOf(tfbill.getText())));
			System.out.println(Exception_perso.isPositive(Integer.valueOf(tftip.getText())));

			
			
			a = Integer.valueOf(tfbill.getText()) / Integer.valueOf(tfnbpeople.getText());
			a = a * Integer.valueOf(tftip.getText()) /100;
			
			affichage_tipperson.setText(String.valueOf(a));

			total = Integer.valueOf(tfbill.getText()) / Integer.valueOf(tfnbpeople.getText());
			total = total + (total * Integer.valueOf(tftip.getText()) /100);
			
			affichage_totalperson.setText(String.valueOf(total));
			
			
			
			File fichier = new File("monFichier.txt");
			//FileOutputStream flux = new FileOutputStream(fichier);
			FileWriter flux = new FileWriter(fichier, true);

			
			//Liste pour stocker les dates lues
			List<String> strList = new ArrayList<String>();			
			//String tableauDesDates[] = 
			//Pour lire un fichier
			
			File fichierLu = new File("monfichier.txt");
			
			FileInputStream fluxFIS = new FileInputStream(fichierLu);
			int c;
			
			while ((c = fluxFIS.read()) > -1) {
				
				/*
				if(c == '\n') {
					System.out.println("c == espace");
				}
				*/
				/*
				String sss = String.valueOf(c);
				if(sss.contains("10/10/2050")) {
					System.out.println("test");
				}
				*/
				
				//System.out.println(sss);
				System.out.write(c);
				
				//String s10 = String.valueOf(fluxFIS.read()); //Convert de int à string
				
				
				//strList.add(s10);
			}
			fluxFIS.close();
			
			/*
			Scanner fileScanner = new Scanner(new File("monfichier.txt"));
			while (fileScanner.hasNextLine()) {
				
				System.out.print(fileScanner.next());
			}
			*/ 
			//Fin de la lecture d'un fichier
			
			
			
			String s1 = tfbill.getText();
			String s2 = tftip.getText();;
			String s3 = tfnbpeople.getText();
			String smax = s1 + " " + s2 + " " + s3;
			String smaxEspace = smax + "\r\n";
			
			for (int y = 0; y < dateEntree.length(); y++) {
				flux.write(dateEntree.charAt(y));
			}
			flux.write(' ');
			for (int i = 0; i < smaxEspace.length(); i++) {
				flux.write(smaxEspace.charAt(i));				
			}
			flux.close();
			
		}
		catch (IndexOutOfBoundsException e1) {
			System.err.println("Numero incorrect : "+ e1.getMessage());
		}
		catch (NumberFormatException e2) {
			System.err.println("Il y a un caractère qui n'est pas un entier");
		}
		catch ( IllegalArgumentException e3) {
		    System.err.println("La date entrée n'est pas une date");
		}
		catch (FileNotFoundException e4) {
			e4.printStackTrace();
		}
		catch (IOException e5) {
			e5.printStackTrace();
		}


		//System.out.println("Voici la liste :");
		
		
		
		
		
		//System.out.println(strList); //Affichage de la liste		
	}//fin clickMe
	
	
	
	
	
	public static void check(String date, Label label) throws IndexOutOfBoundsException {
	       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	       format.setLenient(false);
	       try
	       {
	           Date d = format.parse(date); 
	           label.setText("Date valide");
	           System.err.println(date+" est une date valide");
	       }
	       // Date invalide
	       catch (ParseException e)
	       {
	    	   label.setText("Date invalide");
	    	   throw new IndexOutOfBoundsException("La date entrée n'est pas une date valide");
	    	   //System.err.println(date+" est une date invalide");
	       }
		}
	
	
	
}
