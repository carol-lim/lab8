import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;
/**
 * Lab6Exercise3: A New RMI Client: display the current temperature in Ayer Keroh
 * @author carol
 *
 */
public class TemperatureClient2RMIApp {
	public static void main(String[] args) {
		try {
			// Get registry, returns registry object
			Registry rmiRegistry = LocateRegistry.getRegistry("localhost");
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("AyerKeroh");
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorAyerKeroh.getTemperature();
			
			System.out.println("Current temperature in Ayer Keroh is "+ currentTemperature + " Celcius");
			System.out.println("");
			
			// Lab6Exercise7: invoke getTemperatureSpecifiedDay(day), display the temperature
			String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
			int tempSpecDay;
			for (int i =0; i< day.length; i++) {
				tempSpecDay = remoteSensorAyerKeroh.getTemperatureSpecifiedDay(day[i]);
				System.out.println("Temperature in Melaka on "+day[i]+" is "+ tempSpecDay + " Celcius");
			}
			System.out.println("");
			
			// Lab6Exercise8: invoke getAverageTemperature(), display average temperature
			int avgTemp= remoteSensorAyerKeroh.getAverageTemperature();
			System.out.println("Average Temperature in Melaka is "+ avgTemp + " Celcius");
			System.out.println("");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
