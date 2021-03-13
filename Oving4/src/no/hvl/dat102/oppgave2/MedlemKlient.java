package no.hvl.dat102.oppgave2;

import java.util.Scanner;

public class MedlemKlient {

	public static void main(String[] args) {
		Medlem medlem = new Medlem("Torstein");
		
	}
	public static void klientLeggTilHobby(Medlem medlem) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hva er navnet på hobbyen du vil legge til?");
		medlem.leggTilHobby(scan.nextLine());
	}

}
