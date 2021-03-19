package Lab1.HumanWeightOnMars;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HumanWeightOnMars {
	private static DecimalFormat df = new DecimalFormat("0.00");
	private double weightOnEarth;
	
	public void setWeightOnEarth(double woe) {
		this.weightOnEarth = woe;
	}
	
	public double getWeightOnEarth() {
		return weightOnEarth;
	}
	
	private double weightOnMars;

	public void setWeightOnMars(double wom) {
		this.weightOnMars = wom;
	}
	
	public double getWeightOnMars() {
		return weightOnMars;
	}

	public static double calculate(double weightOnEarth) {
		return weightOnEarth/9.81*3.711;
	}	
	
	public static void start() {
		HumanWeightOnMars human1 = new HumanWeightOnMars();
		
		Scanner sr = new Scanner(System.in);
		System.out.println("Enter your weight on Earth (kg): ");
		double woe = sr.nextDouble();
		human1.weightOnEarth = woe;		
		
		double wom = calculate(human1.weightOnEarth);
		human1.weightOnMars = wom;
		
		System.out.println(human1.weightOnEarth+"kg on Earth = "+df.format(wom)+"kg on Mars");
		System.out.println();
		
		WeightList wl = new WeightList();
		wl.addToList(human1);
		
	}
	
	public static void main(String args[]) {
		start();
			
	}
	
}

