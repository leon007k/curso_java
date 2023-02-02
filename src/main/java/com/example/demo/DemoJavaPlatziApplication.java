package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.poo.Doctor;
import com.example.ui.UiMenu;

import temasvistos.Incremento;
import temasvistos.MathematicOperations;
import temasvistos.SwitchJavaDoc;
import temasvistos.doWhile;

@SpringBootApplication
public class DemoJavaPlatziApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoJavaPlatziApplication.class, args);
		
		//Incremento de valores
		/*Incremento inc = new Incremento();
		inc.setLives(5);
		inc.setScore(0);
		inc.MarioGame();*/
		
		//Operaciones Matemacias
		/*MathematicOperations mat = new MathematicOperations();
		mat.setW(12);
		mat.setZ(5);
		mat.setX(12.5);
		mat.setY(5.5);
		mat.NumberCeil();
		mat.NumberFloor();
		mat.NumberPow();
		mat.NumberMax();
		mat.NumExact();
		mat.NumSubExact();*/
		
		//Uso del swithCase
		//SwitchJavaDoc sjd = new SwitchJavaDoc(5,"EUO");
		//double convertDolar = sjd.converToDolar(sjd.getQuantity(), sjd.getCurrency());
		//System.out.println(sjd.messageConvertToDolar(convertDolar));
		
		//Uso de do-while
		//doWhile dw = new doWhile();
		//dw.selectCinema();
		
		//Uso de POO
		UiMenu.showMenu();
	}
}
