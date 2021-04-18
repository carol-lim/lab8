package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ClientTranslationController {
	// The server port to which the client socket is going to connect
	protected final static int SERVERPORT = 50001;

	protected static int bufferSize = 1024;

	static ClientTranslationView clientView = new ClientTranslationView();
	
	public static void main(String[] args) {
		clientView.setVisible(true);
	}
	
	public static void run(String eng, String lang) {
		try {
			
			// Instantiate client socket
			DatagramSocket clientSocket = new DatagramSocket();
	
			// Get the IP address of the server
			InetAddress serverAddress = InetAddress.getByName("localhost");
	
			// Create buffer to send data
			byte sendingDataBuffer1[] = new byte[bufferSize];
			byte sendingDataBuffer2[] = new byte[bufferSize];
			
			// Convert data to bytes and store data in the buffer
			
			sendingDataBuffer1 = eng.getBytes();
			sendingDataBuffer2 = lang.getBytes();
			
			// Creating a UDP packet 
			DatagramPacket sendingPacket1 = new DatagramPacket(sendingDataBuffer1, sendingDataBuffer1.length, serverAddress, SERVERPORT);
			DatagramPacket sendingPacket2 = new DatagramPacket(sendingDataBuffer2, sendingDataBuffer2.length, serverAddress, SERVERPORT);
			// Sending UDP packet to the server
			clientSocket.send(sendingPacket1);
			clientSocket.send(sendingPacket2);
			
			// Create buffer to receive data
			byte receivingDataBuffer [] = new byte[bufferSize];
			
			// Receive data packet from server
		    DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
		    clientSocket.receive(receivingPacket);
		    
		    // Unpack packet
		    String translated = new String(receivingPacket.getData(), 0, receivingPacket.getLength(), "UTF8");
		    clientView.updateTranslatedText(translated);

			// Closing the socket connection with the server
			clientSocket.close();
		  
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
