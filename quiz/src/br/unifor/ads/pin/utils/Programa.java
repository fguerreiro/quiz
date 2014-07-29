package br.unifor.ads.pin.utils;

public class Programa {

	public static void main(String[] args) {

		try {
			ConnectionTest.checkLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
