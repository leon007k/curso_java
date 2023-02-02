package com.example.ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.example.poo.Doctor;

public class UiPatientMenu {

	public static void showPatientMenu() {
		int response = 0;
		do {
			System.out.println("\n\n");
			System.out.println("Welcome");
			System.out.println("Patient " + UiMenu.patientLogged.getName());
			System.out.println("1. Book an appointment");
			System.out.println("2. My appointments");
			System.out.println("0. Logout");
			
			Scanner sc = new Scanner(System.in);
			response = Integer.valueOf(sc.nextLine());
			
			switch(response) {
			case 1:
				showBookAppointmentMenu();
				break;
			case 2:
				showPatientMyAppointments();
				break;
			case 0:
				UiMenu.showMenu();
				break;
			}
			
		}while(response != 0);
	}
	
	public static void showBookAppointmentMenu() {
		int response = 0;
		do {
			System.out.println("::Book an appointment");
			System.out.println("::Select a Date:");
			/*Recorremos el arreglo de las citas para poder agendar en el espacio libre
			 * que tenga el doctor.
			 * El primer valor, integer, es para indicar el doctor
			 * El primer valor del otro map,integer es para indicar las fechas
			 * El segundo valor del otro map, Doctor, regresara todo el array de fechas
			 * Ejemplo estructura array:
			 * [doctors]
			 * 1.- doctors1
			 * 	1.- Fecha1
			 * 	2.- Fecha2
			 * 2.- doctors2
			 * 	1.- Fecha1
			 * 3.- doctors3
			 * */
			Map<Integer,Map<Integer,Doctor>> doctors = new TreeMap<>();
			int k = 0;
			// Recorremos array de citas registradas por doctores
			for (int i = 0; i < UiDoctorMenu.doctorsAvailableAppointments.size(); i++) {
				//creamos un arreglo que va a contener las citas disponibles
				ArrayList<Doctor.AvailableAppointment> availableAppointments = 
						UiDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
				Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
				for (int j = 0; j < availableAppointments.size(); j++) {
					// Este nos permitira obtener el posicionamiento para el primer Integer del map
					k++;
					System.out.println(k + ".- " + availableAppointments.get(j).getDate());
					//Capturamos Integer y Doctor del segundo Map de doctors
					doctorAppointments.put(Integer.valueOf(j), UiDoctorMenu.doctorsAvailableAppointments.get(i));
					//Capturamos Integer y Map<Integer,Doctor> del map principal
					doctors.put(Integer.valueOf(k), doctorAppointments);
				}
			}
			Scanner sc = new Scanner(System.in);
			int responseDateSelected = Integer.valueOf(sc.nextLine());
			
			//Obtenemos los datos de la cita, para confirmar la
			// Creamos otro map donde guardaremos los datos de la cita a confirmar
			Map<Integer,Doctor> doctorAvaliableSelected = doctors.get(responseDateSelected);
			Integer indexDate = 0;
			Doctor doctorSelected = new Doctor("","");
			//Recorremos el map que se creo para obtener los datos
			for(Map.Entry<Integer,Doctor> doc : doctorAvaliableSelected.entrySet()) {
				indexDate = doc.getKey();
				doctorSelected = doc.getValue();
			}
			
			System.out.println("Doctor: " + doctorSelected.getName() +
					". Date: " +
					doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
					". Time: " +
					doctorSelected.getAvailableAppointments().get(indexDate).getTime());
			System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
			response = Integer.valueOf(sc.nextLine());
			
			// Una vez confirmada la cita, se registra
			if(response == 1) {
				UiMenu.patientLogged.addAppointmentDoctors(doctorSelected, 
						doctorSelected.getAvailableAppointments().get(indexDate).getDate(null), 
						doctorSelected.getAvailableAppointments().get(indexDate).getTime());
				showPatientMenu();
			}
			
		}while(response != 0);
	}
	
	public static void showPatientMyAppointments() {
		int response = 0;
		do {
			System.out.println("::My Appointments");
			if(UiMenu.patientLogged.getAppointmentDoctors().size() == 0) {
				System.out.println("Don't have appointments");
				break;
			}
			
			for (int i = 0; i < UiMenu.patientLogged.getAppointmentDoctors().size(); i++) {
				int j = i + 1;
				System.out.println(j + ". " +
				"Date: "	+ UiMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
				"Time: " + UiMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
				"\n Doctor: " + UiMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
			}
			
			System.out.println("0. Return");
		}while(response!=0);
	}
}
