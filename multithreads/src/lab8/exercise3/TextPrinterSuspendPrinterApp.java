package lab8.exercise3;

public class TextPrinterSuspendPrinterApp {
	public static void main(String[] args) {
		
		TextSuspendPrinter textPrinter1 = new TextSuspendPrinter();
		TextSuspendPrinter textPrinter2 = new TextSuspendPrinter();
		Thread printerThread1 = new Thread(textPrinter1, "word1");
		Thread printerThread2 = new Thread(textPrinter2, "word2");
		
		printerThread1.start();
		printerThread2.start();

	}
}
