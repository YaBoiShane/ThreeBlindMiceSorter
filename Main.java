import java.awt.List;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static boolean S1 = true;
	public static boolean Running = false;
	public static boolean Swap = true;
	public static long Start;
	public static long Stop;
	
	
	public static void Main(String[] args) {
		while(true) {
		Scanner input = new Scanner(System.in);
		System.out.println("Pick which sorting algorithm to use");
		System.out.println("1) Cocktail Shaker Sort \n2) Sort Algorithm 2 \n3) Exit");
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			CockShakeSort(input);
			break;
		case 2:
			System.out.println("Coming soon?");
			break;
		case 3:
			System.out.println("Exiting...");
			System.exit(0);
		default:
			System.out.println("Try again with a valid choice");
		}
		}
		

	}
	public static void stopwatchStart() {
		Start = System.currentTimeMillis();
		Running = true;
	}
	public static void stopwatchStop() {
		Stop = System.currentTimeMillis();
		if (Running) {
			long difference = Stop - Start, diffSecs = difference / 1000, diffMin = diffSecs / 60;
			System.out.println("The sort took " + diffMin + " minutes and "+ diffSecs + " seconds");
			Running = false;
		}
	}
	
	public static void Options(Scanner input) {
		System.out.println("Show steps: " + S1);
		System.out.println("Edit variables? (Y)/(N)");
		char Choice = input.next().charAt(0);
		Choice = Character.toUpperCase(Choice);
			if(Choice != 'Y' && Choice != 'N') {
	
			}
			else if (Choice == 'Y') {
				System.out.println("Would you like to see the individual steps of the sorter? (Y)/(N)");
				char Choice2 = input.next().charAt(0);
				Choice2 = Character.toUpperCase(Choice2);
				if(Choice2 == 'N') {
					System.out.println("Disabling steps");
					S1 = false;
				}
				else {
					System.out.println("Returning...");
					
				}
			}
		
	}
	
	public static void CockShakeSort(Scanner input) {
		boolean retry = true;
		while (retry) {
		System.out.println("Would you like to sort integers or doubles? \n 1) integers \n 2) doubles \n 3) Options");
		
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			int[] list1 = makeIntList(input);
			for(int j : list1) {
				System.out.print(j + ", ");
			}
			System.out.println();
			intSorter(list1);
			retry = false;
			break;
		case 2:
			double[] list2 = makeDoubleList(input);
			for(int i = 0; i < list2.length; i++) {
				System.out.print(list2[i] + " ");
			}
			doubleSorter(list2);
			retry = false;
			break;
		case 3:
			Options(input);
			continue;
		default:
			System.out.println("Invalid input");
			}
		}
	}
	
	public static int[] makeIntList(Scanner input) {
		Random r1 = new Random();
		int hold;
		System.out.println("How big of an array?");
		int listLength = input.nextInt();
		System.out.println("Between what range?");
		System.out.print("Low end: ");
		int Low = input.nextInt();
		System.out.println("High end: ");
		int High = input.nextInt();
		if(Low > High) {
			hold = Low;
			Low = High;
			High = hold;
		}
		else if(Low == High) {
			System.out.println("Range can not be the same values");
			High++;
		}
		System.out.println("Creating a new list of length " + listLength + " filled with numbers between " + Low + " and " + High);
		int[] list1 = new int[listLength];
		for(int i = 0; i < list1.length; i++) {
			list1[i] = r1.nextInt(Low, High);
		}
		
		return list1;
	}
	
	public static double[] makeDoubleList(Scanner input) {
		Random r1 = new Random();
		double hold;
		System.out.println("How big of an array?");
		int listLength = input.nextInt();
		System.out.println("Between what range?");
		System.out.print("Low end: ");
		double Low = input.nextDouble();
		System.out.println("High end: ");
		double High = input.nextDouble();
		if(Low > High) {
			hold = Low;
			Low = High;
			High = hold;
		}
		else if(Low == High) {
			System.out.println("Range can not be the 0");
			High++;
		}
		System.out.println("Creating a new list of length " + listLength + " filled with numbers between " + Low + " and " + High);
		double[] list1 = new double[listLength];
		for(int i = 0; i < list1.length; i++) {
			double num =(r1.nextDouble(Low, High));
			String formatted = String.format("%.2f", num);
			num = Double.parseDouble(formatted);
			list1[i] = num;
		}
		return list1;
	}
	
	public static void intSorter(int[] list1) {
			//needed variables
				int indexHigh = list1.length-1,
					indexLow = 0,
					holder,
					tMax = list1.length;
				
				//sorter
				stopwatchStart();
					Swap = true;
				while(Swap) {
					Swap = false;
				for(int i = 0; i <= tMax; i++) {
					if(S1) {
						System.out.println();
						System.out.println("indexHigh = " + indexHigh + "\n indexLow = " + indexLow);
					}
					if(list1[indexLow] > list1[indexHigh]) {
						holder = list1[indexLow];
						list1[indexLow] = list1[indexHigh];
						list1[indexHigh] = holder;
						tMax++;
						Swap = true;
					}
					
					if(list1[indexHigh] < list1[indexHigh-1]) {
						holder = list1[indexHigh];
						list1[indexHigh] = list1[indexHigh-1];
						list1[indexHigh-1] = holder;
						tMax++;
						Swap = true;
					}
					else if(list1[indexHigh] >= list1[indexHigh-1]) {
						//tMax--;
					}
					
					if(list1[indexLow] > list1[indexLow+1]) {
						holder = list1[indexLow];
						list1[indexLow] = list1[indexLow+1];
						list1[indexLow+1] = holder;
						tMax++;
						Swap = true;
					}
					else if(list1[indexLow] >= list1[indexLow+1]) {
						//tMax--;
					}
					
					indexHigh--;
					indexLow++;
					
					//resets the indexes to maintain the 'bubbler' logic
					if(indexLow == indexHigh) {
						indexLow = 0;
						indexHigh = list1.length-1;
					}
					else if(indexLow - indexHigh >= 0) {
						indexLow = 0;
						indexHigh = list1.length-1;
					}
					
					
					if(S1) {
					for(int l= 0; l < list1.length; l ++) {
						if(l == indexHigh) {
							System.out.println(list1[l] + " <");
						}
						else if(l == indexLow) {
							System.out.println(list1[l] + " <");
						}
						else {
						System.out.println(list1[l]);
						}
					}
					System.out.println();
					}
					else {
						continue;
					}
					
					if(!Swap) {
						break;
					}
				}
				boolean fc = true;
				System.out.println("Checking list...");
				for(int i = 0; i < list1.length-1; i++) {
					
					if(list1[i] <= list1[i+1]) {
						
					}
					else {
						fc = false;
					}
				}
				if(!fc) {
					System.out.println("Found a hidden unsort");
					Swap = true;
				}
				}
				stopwatchStop();
				System.out.println("Number of loops: " + tMax);
				System.out.println("====Final Sorted List of " + list1.length +" elements ====");
				System.out.print("-->");
				for(int k = 0; k < list1.length; k++) {
					System.out.printf("%-10s", list1[k]);
					if((k+1) % 10 == 0) {
						System.out.println("-->");
						System.out.print("-->");
					}
				}
				System.out.println("\n");
				
	}

	public static void doubleSorter(double[] list1) {
		int indexHigh = list1.length-1,
				indexLow = 0,
				tMax = list1.length;
		double holder;
			
			//sorter
			stopwatchStart();
				Swap = true;
			while(Swap) {
				Swap = false;
			for(int i = 0; i <= tMax; i++) {
				if(S1) {
					System.out.println();
					System.out.println("indexHigh = " + indexHigh + "\n indexLow = " + indexLow);
				}
				if(list1[indexLow] > list1[indexHigh]) {
					holder = list1[indexLow];
					list1[indexLow] = list1[indexHigh];
					list1[indexHigh] = holder;
					tMax++;
					Swap = true;
				}
				
				if(list1[indexHigh] < list1[indexHigh-1]) {
					holder = list1[indexHigh];
					list1[indexHigh] = list1[indexHigh-1];
					list1[indexHigh-1] = holder;
					tMax++;
					Swap = true;
				}
				else if(list1[indexHigh] >= list1[indexHigh-1]) {
					//tMax--;
				}
				
				if(list1[indexLow] > list1[indexLow+1]) {
					holder = list1[indexLow];
					list1[indexLow] = list1[indexLow+1];
					list1[indexLow+1] = holder;
					tMax++;
					Swap = true;
				}
				else if(list1[indexLow] >= list1[indexLow+1]) {
					//tMax--;
				}
				
				indexHigh--;
				indexLow++;
				
				//resets the indexes to maintain the 'bubbler' logic
				if(indexLow == indexHigh) {
					indexLow = 0;
					indexHigh = list1.length-1;
				}
				else if(indexLow - indexHigh >= 0) {
					indexLow = 0;
					indexHigh = list1.length-1;
				}
				
				
				if(S1) {
				for(int l= 0; l < list1.length; l ++) {
					if(l == indexHigh) {
						System.out.println(list1[l] + " <");
					}
					else if(l == indexLow) {
						System.out.println(list1[l] + " <");
					}
					else {
					System.out.println(list1[l]);
					}
				}
				System.out.println();
				}
				else {
					continue;
				}
				
				if(!Swap) {
					break;
				}
			}
			boolean fc = true;
			System.out.println("Checking list...");
			for(int i = 0; i < list1.length-1; i++) {
				
				if(list1[i] <= list1[i+1]) {
					
				}
				else {
					fc = false;
				}
			}
			if(!fc) {
				System.out.println("Found a hidden unsort");
				Swap = true;
			}
			}
			stopwatchStop();
			System.out.println("Number of loops: " + tMax);
			System.out.println("====Final Sorted List of " + list1.length +" elements ====");
			System.out.print("-->");
			for(int k = 0; k < list1.length; k++) {
				System.out.printf("%-10s", list1[k]);
				if((k+1) % 10 == 0) {
					System.out.println("-->");
					System.out.print("-->");
				}
			}
			System.out.println("\n");
	}
}
