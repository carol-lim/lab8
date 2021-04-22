import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side RMI application
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		try {
			// Get registry, returns registry object
			Registry rmiRegistry = LocateRegistry.getRegistry("localhost");
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin = (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorJasin.getTemperature();
			
			System.out.println("Current temperature in Jasin is "+ currentTemperature + " Celcius");
			System.out.println("");
			
			// Lab6Exercise8: invoke getAverageTemperature(), display average temperature
			int avgTemp= remoteSensorJasin.getAverageTemperature();
			System.out.println("Average Temperature in Melaka is "+ avgTemp + " Celcius");
			System.out.println("");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
