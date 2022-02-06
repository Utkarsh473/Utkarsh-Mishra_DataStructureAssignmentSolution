package question1.app.greatlearning.main;

import java.util.Scanner;

import question1.app.greatlearning.services.ConstructionOrder;

public class DriverClass {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Take inputs from the user

		// Input number of floors
		int numOfFloors;
		System.out.println("Enter the total no of floors in the building");
		numOfFloors = sc.nextInt();

		// Input floor size constructed on each day
		int[] floor = new int[numOfFloors];
		for (int i = 0; i < numOfFloors; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			floor[i] = sc.nextInt();
		}

		// Compute order by invoking methods in ConstructionOrder class
		ConstructionOrder obj = new ConstructionOrder();

		// print order using printOrder method()
		System.out.println("The order of construction is as follows \n");
		obj.printOrder(floor);

	}

}
