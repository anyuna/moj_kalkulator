package kalkulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.lang3.CharUtils;

public class kal {
	/**
	 * Funkcja sprawdzaj�ca czy dany znak jest operatorem matematycznym.
	 *
	 * @return true je�li znak jest operatorem matematycznym, w przeciwnym razie
	 *         false
	 */
	static boolean czyoperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		} else
			return false;
	}

	/**
	 * Funkcja przetwarzaj�ca pojedyncze wyra�enie matematyczne.
	 *
	 * @param s Wyra�enie matematyczne do przetworzenia.
	 */
	static void przetworz(String s) {

		char pom;
		char ope = ' ';
		String b = ""; // nie moze pusty, nie moze byc nullem
		int c;
		int wynik = 0;

		for (int i = 0; i < s.length(); i++) {

			pom = s.charAt(i);

			if (CharUtils.isAsciiNumeric(pom)) {
				b = b + pom;

			}

			else if (czyoperator(pom)) {
				if (ope != ' ') {
					c = Integer.parseInt(b);
					switch (ope) {

					case '+': {
						wynik += c;
						break;
					}
					case '-': {
						wynik -= c;
						break;
					}
					case '*': {
						wynik *= c;
						break;
					}
					case '/': {
						wynik /= c;
						break;
					}
					}
					b = "";
					ope = pom;
				} else {

					ope = pom;

					c = Integer.parseInt(b);

					wynik += c;

					b = "";
				}

			}

			// }//konczy pierwszego if
			else {
				System.out.println("To nie jest poprawne dzia�anie. Linia pomini�ta");

				return;

			}

		} // for

		if (ope != ' ') {
			c = Integer.parseInt(b);
			switch (ope) {

			case '+': {
				wynik += c;
				break;
			}
			case '-': {
				wynik -= c;
				break;
			}
			case '*': {
				wynik *= c;
				break;
			}
			case '/': {
				wynik /= c;
				break;
			}
			}

		}

		System.out.println(s + "=" + wynik);
	}

	/**
	 * Funkcja startowa aplikacji.
	 *
	 * @param args
	 *            Argumenty.
	 */
	public static void main(String[] args) throws FileNotFoundException {

		String a;
		String linia;
		Scanner sc;

		while (true) {
			System.out.println("Menu.");
			System.out.println("Wybierz jedn� opcj�:");
			System.out.println("1. Wprowadzenie dzia�a� z linii polece�.");
			System.out.println("2. Wprowadzenie dzia�a� z pliku.");
			System.out.println("3. Koniec programu.");
			sc = new Scanner(System.in);
			a = sc.nextLine();

			switch (a) {

			case "1": {

				System.out.println("Wprowad� dzia�anie lub by powr�ci� wpisz \"koniec\".");
				sc = new Scanner(System.in);
				break;
			}
			case "2": {

				sc = new Scanner(new File("my.txt"));

				break;
			}
			case "3": {
				return;

			}
			default: {
				sc = null;
				System.out.println("B��dne dane. To nie jest dzia�anie.");
				break;

			}
			}

			while (sc != null && sc.hasNextLine()) {
				linia = sc.nextLine();
				if (a.equalsIgnoreCase("1") && (linia.equalsIgnoreCase("koniec"))) {
					break;
				}
				przetworz(linia);
			}

		} // while

	}// main

} // kal
