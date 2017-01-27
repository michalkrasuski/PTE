package pl.edu.pw.ii.pte.junit.money;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest2 {
	private Money m12CHF;
	private Money m14CHF;

	@Before
	public void setUp() throws Exception {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14, "CHF");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleAdd2() {
		Money expected = new Money(26, "CHF");
		Money result = m12CHF.add(m14CHF); //
		assertTrue(expected.equals(result)); //
	}

	@Test
	public void testEquals2() {
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
		assertEquals(m12CHF.amount(), 12);
		assertEquals(m12CHF.currency(), "CHF");
		assertTrue(!m12CHF.currency().equals("PLN"));
		
	}

	////////	ZADANIE A  ////////////////
	
	@Test
	public void testMultiplication(){
		assertEquals(m12CHF.mul(3), new Money(36, "CHF"));
		assertEquals(m12CHF.mul(3).amount(), 36);
	}
	
	@Test
	public void testAddingDifferentCurrencies(){
		Money m6PLN = new Money(6, "PLN");
		assertEquals(m12CHF.addDifCurrency(m6PLN), new Money(15, "CHF"));
		assertEquals(m6PLN.addDifCurrency(m12CHF), new Money(30, "PLN"));
	}
	
	@Test
	public void testisSameValue(){
		Money m24PLN = new Money(24, "PLN");
		Money m6PLN = new Money(6, "PLN");
		assertTrue(m12CHF.isSameValue(m24PLN));
		assertFalse(m12CHF.isSameValue(m6PLN));
	}
	
	@Test
	public void testExchangeRate(){
		Money m6PLN = new Money(6, "PLN");
		Money m6USD = new Money(6, "USD");
		assertTrue(m12CHF.exchangeRate() == 4.0);
		assertFalse(m12CHF.exchangeRate() == 3.0);
		assertTrue(m6PLN.exchangeRate() == 2);
		assertTrue(m6USD.exchangeRate() == 0);
		
	}

}
