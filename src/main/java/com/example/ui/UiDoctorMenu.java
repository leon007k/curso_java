package com.example.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.example.poo.Doctor;

public class UiDoctorMenu {
	
	//Array de doctores que tienen espacio para citas
	public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

	public static void showDoctorMenu() {
		int response = 0;
		
		do {
			System.out.println("\n\n");
			System.out.println("Welcome");
			System.out.println("Doctor " + UiMenu.doctorLogged.getName());
			System.out.println("1. Add Available Appointment");
			System.out.println("2. My scheduled appointment");
			System.out.println("0. Logout");
			
			Scanner sc = new Scanner(System.in);
			response = Integer.valueOf(sc.nextLine());
			
			switch(response) {
			case 1:
				showAvailableAppointmentsMenu();
				break;
			case 2:
				break;
			case 0:
				UiMenu.showMenu();
				break;
			}
			
		}while(response != 0);
	}
	
	private static void showAvailableAppointmentsMenu() {
		int response = 0;
		do {
			System.out.println();
			System.out.println("::Add Available Appointment");
			System.out.println("::Select a Month");
			
			for (int i = 0; i < 3; i++) {
				int j = i + 1;
				System.out.println(j + ". " + UiMenu.MONTHS[i]);
			}
			System.out.println("0. Return");
			
			Scanner sc = new Scanner(System.in);
			response = Integer.valueOf(sc.nextLine());
			
			if(response > 0 && response < 4) {
				//opciones 1,2,3
				 int monthSelected = response;
				 System.out.println(monthSelected + " . "+UiMenu.MONTHS[monthSelected-1]);
				 
				 System.out.println("Insert the date available: [dd/mm/yyyy]");
				 String date = sc.nextLine();
				 
				 System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
				 int responseDate = Integer.valueOf(sc.nextLine());
				 if (responseDate == 2) continue;
				 
				 int responseTime = 0;
				 String time="";
				 do {
					 System.out.println("Insert the time available for date: " + date + "  [16:00]");
					 time = sc.nextLine();
					 System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
					 responseTime = Integer.valueOf(sc.nextLine());
				 }while(responseTime == 2);
				 
				 UiMenu.doctorLogged.addAvailableAppointment(date, time);
				 //*Verificamos si el doctor no tiene citas
				 checkDoctorAvailableAppointment(UiMenu.doctorLogged);
			}else if(response == 0) {
				showDoctorMenu();
			}
			
		}while(response != 0);
	} 

	private static void checkDoctorAvailableAppointment(Doctor doctor) {
		if(doctor.getAvailableAppointments().size() > 0 && 
				!doctorsAvailableAppointments.contains(doctor)) {
			doctorsAvailableAppointments.add(doctor);
		}
	}
}
