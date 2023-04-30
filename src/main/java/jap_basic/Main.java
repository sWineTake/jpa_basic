package jap_basic;

import hello.Adress;

public class Main {
	public static void main(String[] args) {
		Adress adress1 = new Adress("city1","street1", "zipcode1");
		Adress adress2 = new Adress("city1","street1", "zipcode1");

		System.out.println("adress1 equals adress2 : " + adress1.equals(adress2));

	}
}
