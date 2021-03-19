package Lab1.HumanWeightOnMars;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class WeightList {
	public static ArrayList<HumanWeightOnMars> weightList = new ArrayList<HumanWeightOnMars>();
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public void addToList(HumanWeightOnMars w) {
		weightList.add(w);
		display();
	}
	
	public static void display() {
		System.out.println("In list:");
		for (int i=0; i < weightList.size(); i++  ) {
			HumanWeightOnMars record = weightList.get(i);
			
			System.out.println(i+1+") "+record.getWeightOnEarth()+"kg on Earth = "+df.format(record.getWeightOnMars())+"kg on Mars");
			
		}
		
		System.out.println();
		HumanWeightOnMars.start();
	}
	
	
}
