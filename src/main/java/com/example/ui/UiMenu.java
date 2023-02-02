package com.example.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.poo.Doctor;
import com.example.poo.Patient;

public class UiMenu {
	  public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	    public static Doctor doctorLogged;
	    public static Patient patientLogged;

	    public static void showMenu(){
	        System.out.println("Welcome to My Appointments");
	        System.out.println("Selecciona la opción deseada");

	        int response = 0;
	        do {
	            System.out.println("1. Doctor");
	            System.out.println("2. Patient");
	            System.out.println("0. Exit");

	            Scanner sc = new Scanner(System.in);
	            response = Integer.valueOf(sc.nextLine());

	            switch (response){
	                case 1:
	                    System.out.println("Doctor");
	                    response = 0;
	                    authUser(1);
	                    break;
	                case 2:
	                    response = 0;
	                    authUser(2);
	                    break;
	                case 0:
	                    System.out.println("Thank you for you visit");
	                    break;
	                default:
	                    System.out.println("Please select a correct answer");
	            }
	        }while (response != 0);
	    }
	    
	    private static void authUser(int userType) {
	    	//userType == 1 --> es Doctor
	    	//userType == 2 --> es Paciente
	    	ArrayList<Doctor> doctors = new ArrayList<>();
	    	doctors.add(new Doctor("Alejandro Martinez","alejandro@gmail.com"));
	    	doctors.add(new Doctor("Karen Sosa","karens@gmail.com"));
	    	doctors.add(new Doctor("Esmeralda Ochoa","esme8a@gmail.com"));
	    	
	    	ArrayList<Patient> patient = new ArrayList<>();
	    	patient.add(new Patient("Leonardo Andrade","leo@gmail.com"));
	    	patient.add(new Patient("Carlos Andrade","carlos@gmail.com"));
	    	patient.add(new Patient("Anahi Salgado","ana@gmail.com"));
	    	
	    	boolean emailCorrect = false;
	    	do {
	    		System.out.println("Insert your email: [a@gmail.com]");
	    		Scanner sc = new Scanner(System.in);
	    		String email = sc.nextLine();
	    		switch(userType) {
	    			case 1:
	    				for(Doctor d: doctors) {
	    					if(d.getEmail().equals(email)) {
	    						emailCorrect = true;
	    						// Obtenemos usuario logeado
	    						doctorLogged = d;
	    						//showDoctorMenu
	    						UiDoctorMenu.showDoctorMenu();
	    					}
	    				}
	    			break;
	    			case 2:
	    				for (Patient patients : patient) {
							if(patients.getEmail().equals(email)) {
								emailCorrect = true;
								patientLogged = patients;
								//showPatientMenu
								UiPatientMenu.showPatientMenu();
							}
						}
	    			break;
	    		}
	    	}while(!emailCorrect);
	    }
	    
	    static void showPatientMenu(){
	        int response = 0;
	        do {
	            System.out.println("\n\n");
	            System.out.println("model.Patient");
	            System.out.println("1. Book an appointment");
	            System.out.println("2. My appointments");
	            System.out.println("0. Return");

	            Scanner sc = new Scanner(System.in);
	            response = Integer.valueOf(sc.nextLine());

	            switch (response){
	                case 1:
	                    System.out.println("::Book an appointment");
	                    for (int i = 1; i < 4; i++) {
	                        System.out.println(i +". " + MONTHS[i]);
	                    }
	                    break;
	                case 2:
	                    System.out.println("::My appointments");
	                    break;
	                case 0:
	                    showMenu();
	                    break;
	            }
	        }while (response != 0);
	    }
}
