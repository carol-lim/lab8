package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {
	
	// Lab6Exercise5: Create HashMap
	HashMap<String, Integer> melakaWeekTemp = new HashMap<>();
	
	// Lab6Exercise5: Load HashMap
	public void loadHashMap() {
		
		melakaWeekTemp.put("Monday", 32);
		melakaWeekTemp.put("Tuesday", 31);
		melakaWeekTemp.put("Wednesday", 33);
		melakaWeekTemp.put("Thursday", 35);
		melakaWeekTemp.put("Friday", 36);
		melakaWeekTemp.put("Saturday", 33);
		melakaWeekTemp.put("Sunday", 33);
	}
	
	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		return 35;
	}

	// Lab6Exercise6: Override method getTemperatureSpecifiedDay(String), return the temperature from HashMap
	@Override
	public int getTemperatureSpecifiedDay(String day) throws RemoteException {
		loadHashMap();
		
		int temp = melakaWeekTemp.get(day);
		
		return temp;
	}

	// Lab6Exercise8: Override method getAverageTemperature(), return the average temperature in a week
	@Override
	public int getAverageTemperature() throws RemoteException {
		loadHashMap();
		int total =0;
		
		for (Integer temp : melakaWeekTemp.values()) {
			total = total+temp;
		}
		int avg = total/7;
		return avg;
	}

	
}


