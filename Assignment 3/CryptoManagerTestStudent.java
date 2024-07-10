/*
 * Class: CMSC203 	
 * Instructor: Eivazi
 * Description: Write a Java program to encrypt and decrypt a phrase using two similar approaches, each insecure by modern standards.  
 * Due: 07/08/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Isaiah Byrd
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@Test
	void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("PYTHON"));
		assertTrue(CryptoManager.isStringInBounds("\"PYTHON IS FUN\""));
		assertFalse(CryptoManager.isStringInBounds("python"));
		assertFalse(CryptoManager.isStringInBounds("{python"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	void testCaesarEncryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hi", 2));
		assertEquals("YZ[", CryptoManager.caesarEncryption("WXY", 2));
		assertEquals("$%&", CryptoManager.caesarEncryption("DEF", 96));
		assertEquals("088-+B.", CryptoManager.caesarEncryption("GOODBYE", 105));
		assertEquals("YJXYNSL", CryptoManager.caesarEncryption("TESTING", 5));
		assertEquals("XLMW$MW$ERSXLIV$VYR", CryptoManager.caesarEncryption("THIS IS ANOTHER RUN", 4));
	}

	@Test
	void testBellasoEncryption() {
		assertEquals("KJ\\TT)$N!", CryptoManager.bellasoEncryption("HALLOWEEN", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("OT[PQ!J", CryptoManager.bellasoEncryption("GOODBYE", "HELLO"));
		assertEquals("WU\\U6PHH '", CryptoManager.bellasoEncryption("THIRD TEST", "CMSC204"));
	}

	@Test
	void testCaesarDecryption() {
		assertEquals("DEF", CryptoManager.caesarDecryption("$%&", 96));
		assertEquals("GOODBYE", CryptoManager.caesarDecryption("088-+B.", 105));
		assertEquals("TESTING", CryptoManager.caesarDecryption("YJXYNSL", 5));
		assertEquals("THIS IS ANOTHER RUN", CryptoManager.caesarDecryption("XLMW$MW$ERSXLIV$VYR", 4));
	}

	@Test
	void testBellasoDecryption() {
		assertEquals("HALLOWEEN", CryptoManager.bellasoDecryption("KJ\\TT)$N!", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("GOODBYE", CryptoManager.bellasoDecryption("OT[PQ!J", "HELLO"));
		assertEquals("THIRD TEST", CryptoManager.bellasoDecryption("WU\\U6PHH '", "CMSC204"));
	}

}
