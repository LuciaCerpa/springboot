package com.company.books.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	Calculadora calc;//aqui se declara el objeto
	
	@BeforeAll//se puede utilizar para hacer una conexion a la base de datos y abrir la conexion
	//ya que este metodo se ejecuta una sola vez antes de todo el test
	public static void primero() {
		System.out.println("primero");
	}
	
	@AfterAll//este se puede utilizar para el cierre de la conexion
	public static void ultimo() {
		System.out.println("ultimo");
	}
	
	@BeforeEach //cada que inicia el metodo unitario
	public void instanciaObjeto() {
		calc = new Calculadora();//aqui se instancia
		System.out.println("@BeforeEach");
	}
	
	@AfterEach // cada que termine la prueba unitario
	public void despuesTest() {		
		System.out.println("@AfterEach");
	}
	
	
	@Test
	@DisplayName("prueba que ocupa assertEqual")//muestra el nombre
	@Disabled("esta prueba no se ejecuta")//deshabilita la prueba
	public void calculadoraAssertEqualTest() {
				
		assertEquals(2, calc.sumar(1,1));
		assertEquals(3, calc.restar(4, 1));
		assertEquals(9, calc.multiplicar(3, 3));
		assertEquals(2, calc.dividir(4, 2));
	}
	
	@Test
	public void calculadoraTrueFalse() {		
		//Calculadora calc = new Calculadora(); ya está instanciado arriba
		assertTrue(calc.sumar(1,1) == 2);
		assertTrue(calc.restar(4,1) == 3);
		assertFalse(calc.multiplicar(3,3) == 8);
		assertFalse(calc.dividir(4,2) == 1);
	}
}
