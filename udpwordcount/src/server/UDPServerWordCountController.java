package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UDPServerWordCountController {
	public static void main(String[] args) {
		// Server UDP socket runs at this port
		final int serverPort=50001;
		
		// Launch the server GUI
		UDPServerWordCountView serverView= new UDPServerWordCountView();
		serverView.setVisible(true);
		
		// Instantiate server model
		UDPServerWordCountModel serverModel = new UDPServerWordCountModel();
		
		int totalRequest = 0;
		
		try {
			
			// Instantiate a new DatagramSocket to receive responses from the client
		    DatagramSocket serverSocket = new DatagramSocket(serverPort);
		    while (true) {
			    // Create buffers to hold receiving data.
			    byte receivingDataBuffer[] = new byte[1024];
			    
			    // Instantiate a UDP packet to store the client data using the buffer for receiving data
			    DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
			    
			    // Receive data from the client and store in inputPacket
			    serverSocket.receive(inputPacket);

			    // Update server status on view
			    serverView.updateServerStatus(true);
			    
			    // Printing out the client sent data
			    String receivedData = new String(inputPacket.getData());
			    serverView.updateRequestStatus("Sent from the client: " + receivedData);
			    
			    // Process data - count word
			    String sendingData = serverModel.getWordCount(receivedData);
			    serverView.updateRequestStatus("Number of words: " + sendingData);
			    
			    // Creating corresponding buffer to send data
			    byte sendingDataBuffer[] = sendingData.getBytes();
			    
			    // Get client's address
			    InetAddress senderAddress = inputPacket.getAddress();
			    int senderPort = inputPacket.getPort();
			    
			    // Create new UDP packet with data to send to the client
			    DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, senderAddress,senderPort);
			    
			    // Send the created packet to client
			    serverSocket.send(outputPacket);
			    
			    serverView.updateRequestStatus("Accepted connection to from the " + "client. Total request = " + ++totalRequest );
		    }
		} catch (Exception ex) {
			
			System.out.println("Durian Tunggal... we got problem");
			ex.printStackTrace();
		}
	}
}
