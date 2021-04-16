package tcpclienttranslator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTranslationController {
	
	static ClientTranslationView clientView = new ClientTranslationView();
	
	public static void main(String[] args) {
		clientView.setVisible(true);
	}
	
	public static void run(String eng, int lang) {
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(), 4229);
			
			clientView.updateConnectionStatus(socket.isConnected());
			
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(outputStream);
			
			dos.writeUTF(eng);
			dos.write(lang);
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
		    String trans = dis.readUTF();
		    clientView.updateTranslatedText(trans);
			
			dos.flush();
			dos.close();
			dis.close();
			socket.close();
							
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
