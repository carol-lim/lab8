package tcpservertranslator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationController {
	public static void main(String[] args) throws IOException{
		ServerTranslationView serverView = new ServerTranslationView();
		serverView.setVisible(true);
				
		try {
			int totalRequest = 0;
			int portNo = 4229;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			ServerTranslationModel stm = new ServerTranslationModel();
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				boolean conn = clientSocket.isConnected();
				serverView.updateServerStatus(conn);
				
				DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
				
				String clientEng = dis.readUTF();
				int transTo = dis.read();
				
				String translated = stm.translate(clientEng, transTo);
				
				DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
				
				dos.writeUTF(translated);
				
				dos.flush();
				clientSocket.close();
				
				serverView.updateRequestStatus("Data sent to the client: " + translated);
				serverView.updateRequestStatus("Accepted connection to from the " + "client. Total request = " + ++totalRequest );
			
			}			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
