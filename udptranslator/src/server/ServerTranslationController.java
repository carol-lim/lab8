package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerTranslationController {
	public static void main(String[] args) throws IOException{
		
		// Server UDP socket runs at this port
		final int serverPort=50001;
				
		ServerTranslationView serverView = new ServerTranslationView();
		serverView.setVisible(true);
				
		try {
			int totalRequest = 0;
			int portNo = 4229;
			
			ServerTranslationModel stm = new ServerTranslationModel();
			
			// Instantiate a new DatagramSocket to receive responses from the client
		    DatagramSocket serverSocket = new DatagramSocket(serverPort);
		    
			while(true) {
				
				// Create buffers to hold receiving data.
			    byte receivingDataBuffer1[] = new byte[1024];
			    byte receivingDataBuffer2[] = new byte[1024];
			    
			    // Instantiate a UDP packet to store the client data using the buffer for receiving data
			    DatagramPacket inputPacket1 = new DatagramPacket(receivingDataBuffer1, receivingDataBuffer1.length);
			    DatagramPacket inputPacket2 = new DatagramPacket(receivingDataBuffer2, receivingDataBuffer2.length);
			    
			    // Receive data from the client and store in inputPacket
			    serverSocket.receive(inputPacket1);
			    serverSocket.receive(inputPacket2);

			    // Update server status on view
			    serverView.updateServerStatus(true);
				
			    // Printing out the client sent data
			    String clientEng = new String(inputPacket1.getData());
			    serverView.updateRequestStatus("Sent from the client: " + clientEng);
			    
			    String input2 = new String(inputPacket2.getData());
			    int transTo = Integer.parseInt(input2.trim());
								
				String translated = stm.translate(clientEng, transTo);
				
				 // Creating corresponding buffer to send data
				
			    byte sendingDataBuffer[] = translated.getBytes("UTF8");
			    
			    // Get client's address
			    InetAddress senderAddress = inputPacket1.getAddress();
			    int senderPort = inputPacket1.getPort();
			    
			    // Create new UDP packet with data to send to the client
			    DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, senderAddress,senderPort);
			    
			    // Send the created packet to client
			    serverSocket.send(outputPacket);
			    
				serverView.updateRequestStatus("Data sent to the client: " + translated);
				serverView.updateRequestStatus("Accepted connection to from the " + "client. Total request = " + ++totalRequest );
			
			}			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
