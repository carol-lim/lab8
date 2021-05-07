package lab8.exercise1;


public class CurrentTimePrinterApp {
	public static void main(String[] args) {
		
		Thread currentTimePrinter1 = new CurrentTime();
		Thread currentTimePrinter2 = new CurrentTime();
		
		currentTimePrinter1.setName("Printer Thread 1");
		currentTimePrinter2.setName("Printer Thread 2");
		
		currentTimePrinter1.start();
		currentTimePrinter2.start();

	}
}
