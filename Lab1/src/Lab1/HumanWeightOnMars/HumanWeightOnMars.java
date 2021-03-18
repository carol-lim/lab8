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

	public static double calculate(double weightOnEarth) {
		return weightOnEarth/9.81*3.711;
	}
	
	public static void main(String args[]) {
		Scanner sr = new Scanner(System.in);
		System.out.println("Enter your weight on Earth (kg): ");
		double woe = sr.nextDouble();
		HumanWeightOnMars human1 = new HumanWeightOnMars();
		human1.weightOnEarth = woe;
		System.out.println(human1.weightOnEarth+"kg on Earth = "+df.format(calculate(human1.weightOnEarth))+"kg on Mars");
	}
	
}

