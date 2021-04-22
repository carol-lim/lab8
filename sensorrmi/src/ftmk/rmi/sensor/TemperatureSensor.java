package ftmk.rmi.sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface represents temperature sensor
 * @author emalianakasmuri
 *
 */
public interface TemperatureSensor extends Remote {
	/**
	 * This method gets current temperature
	 * @return current temperature
	 * @throws RemoteException
	 */
	public int getTemperature() throws RemoteException;
	
	// Lab6Exercise4: New interface method to retrieve a temperature for a	specified day
	public int getTemperatureSpecifiedDay(String day) throws RemoteException;
	
	// Lab6Exercise8: New interface method to retrieve average temperature in a week
	public int getAverageTemperature() throws RemoteException;
}

