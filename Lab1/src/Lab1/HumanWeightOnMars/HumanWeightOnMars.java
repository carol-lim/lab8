package Lab1.HumanWeightOnMars;

import java.text.DecimalFormat;
public class HumanWeightOnMars {
	private static DecimalFormat df = new DecimalFormat("0.00");

	public static double calculate(double kg) {
		double mars = kg/9.81*3.711;
		return mars;
	}
	
	public static void main(String args[]) {
		double weigth = 58;
		System.out.println(weigth+"kg on Earth = "+df.format(calculate(weigth))+"kg on Mars");
	}
	
}
