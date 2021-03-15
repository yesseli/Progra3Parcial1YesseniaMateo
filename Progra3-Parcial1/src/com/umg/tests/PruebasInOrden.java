package com.umg.tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.umg.parcial.Arboles;

public class PruebasInOrden {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void when_opcion_salir() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
		System.setIn(in);
		
		Arboles.main(null);
		String expected = new String("1. MOSTRAR\r\n"
				+ "2. GUARDAR\r\n"
				+ "0. SALIR\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "0\r\n"
				+ "FIN");
		assertEquals(expected.trim(), outContent.toString().trim());
	}
	
	@Test
	public void when_opcion_guardar() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("2\r\n1\r\n0".getBytes());
		System.setIn(in);
		
		Arboles.main(null);
		String expected = new String("1. MOSTRAR\r\n"
				+ "2. GUARDAR\r\n"
				+ "0. SALIR\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "2\r\n"
				+ "INGRESE VALOR\r\n"
				//+ "1\r\n"
				+ "guardar 1\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "0\r\n"
				+ "FIN");
		assertEquals(expected.trim(), outContent.toString().trim());
	}
	
	@Test
	public void when_opcion_mostar() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in2 = new ByteArrayInputStream("1\r\n0".getBytes());
		System.setIn(in2);
		
		Arboles.main(null);
		String expected = new String("1. MOSTRAR\r\n"
				+ "2. GUARDAR\r\n"
				+ "0. SALIR\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "1\r\n"
				+ "2\r\n"
				+ "4\r\n"
				+ "5\r\n"
				+ "6\r\n"
				+ "7\r\n"
				+ "8\r\n"
				+ "9\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "0\r\n"
				+ "FIN");
		assertEquals(expected.trim(), outContent.toString().trim());
	}
	
	@Test
	public void when_guardar_y_mostar() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in2 = new ByteArrayInputStream("2\r\n1\r\n1\r\n0".getBytes());
		System.setIn(in2);
		
		Arboles.main(null);
		String expected = new String("1. MOSTRAR\r\n"
				+ "2. GUARDAR\r\n"
				+ "0. SALIR\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "2\r\n"
				+ "INGRESE VALOR\r\n"
				//+ "1\r\n"
				+ "guardar 1\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "1\r\n"
				+ "1\r\n"
				+ "2\r\n"
				+ "4\r\n"
				+ "5\r\n"
				+ "6\r\n"
				+ "7\r\n"
				+ "8\r\n"
				+ "9\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "0\r\n"
				+ "FIN");
		assertEquals(expected.trim(), outContent.toString().trim());
	}
	
	@Test
	public void when_guardar_muchos_y_mostar() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in2 = new ByteArrayInputStream("2\r\n3\r\n2\r\n1\r\n2\r\n14\r\n2\r\n15\r\n2\r\n13\r\n1\r\n0".getBytes());
		System.setIn(in2);
		
		Arboles.main(null);
		String expected = new String("1. MOSTRAR\r\n"
				+ "2. GUARDAR\r\n"
				+ "0. SALIR\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "2\r\n"
				+ "INGRESE VALOR\r\n"
				//+ "3\r\n"
				+ "guardar 3\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "2\r\n"
				+ "INGRESE VALOR\r\n"
				//+ "1\r\n"
				+ "guardar 1\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "2\r\n"
				+ "INGRESE VALOR\r\n"
				//+ "14\r\n"
				+ "guardar 14\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "2\r\n"
				+ "INGRESE VALOR\r\n"
				//+ "15\r\n"
				+ "guardar 15\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "2\r\n"
				+ "INGRESE VALOR\r\n"
				//+ "13\r\n"
				+ "guardar 13\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "1\r\n"
				+ "1\r\n"
				+ "2\r\n"
				+ "3\r\n"
				+ "4\r\n"
				+ "5\r\n"
				+ "6\r\n"
				+ "7\r\n"
				+ "8\r\n"
				+ "9\r\n"
				+ "13\r\n"
				+ "14\r\n"
				+ "15\r\n"
				+ "INGRESE OPCION\r\n"
				//+ "0\r\n"
				+ "FIN");
		assertEquals(expected.trim(), outContent.toString().trim());
	}



}
