package lab8.exercise2;


public class TextPrinterApp {
	public static void main(String[] args) {

		Runnable textPrinter1 = new TextPrinter();
		Runnable textPrinter2 = new TextPrinter();
		Runnable textPrinter3 = new TextPrinter();
		
		Thread printerThread1 = new Thread(textPrinter1, "text");
		Thread printerThread2 = new Thread(textPrinter2, "word1");
		Thread printerThread3 = new Thread(textPrinter3);
		printerThread3.setName("word2");
		
		printerThread1.start();
		printerThread2.start();
		printerThread3.start();

	}
}
