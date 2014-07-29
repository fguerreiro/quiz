package br.unifor.ads.pin.utils;

/**
 * 
 * @author Guerreiro
 * Driver used for testing purposes
 */
public class Programa {
	
	public static void main(String[] args) {
		try {
			ConnectionTest.checkLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
