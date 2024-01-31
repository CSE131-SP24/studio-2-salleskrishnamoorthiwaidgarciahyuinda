package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("What will be the starting amount? ");
		double startAmount = in.nextDouble();
		System.out.println("What wil be the win probability, between 0 and 1? ");
		double winChance = in.nextDouble();
		System.out.println("What will be the win limit? ");
		double winLimit = in.nextDouble();
		System.out.println("How many days would you like to simulate? ");
		int totalSimulations = in.nextInt();
		int count = 0;
		int count1 = 0;
		double ruinrate = 0.0;
		if (winChance == 0.5) {
			ruinrate = 1 - (startAmount/winLimit);
		}
		if (winChance < 0.5 || winChance > 0.5) {
			double a = (1-winChance)/winChance;
			double b = Math.pow(a, startAmount);
			double c = Math.pow(a, winLimit);
			ruinrate = ( ( (b)-(c) ) / ( 1-(c)) );
		}
		for(int i = 1; i <= totalSimulations; i++) {
			double temp = startAmount;
			while(temp < winLimit && temp > 0) {
				double x = (double)(Math.random());
				if (x <= winChance) {
					temp = temp + 1;
					}
				if (x > winChance) {
					temp = temp - 1;
				}
				if (temp == 0) {
					count++;
				}
				if (temp == winLimit) {
					count1++;
				}
				
			}
		}
		System.out.println("Days lost: " + count);
		double x = (count/totalSimulations);
		System.out.println("Days won: " + count1);
		System.out.println("Expected ruin rate: " + ruinrate);
		System.out.println("Ruin rate from simulation: " + x);
	}
}
