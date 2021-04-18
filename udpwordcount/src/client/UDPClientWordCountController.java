package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientWordCountController {
	// The server port to which the client socket is going to connect
	protected final static int SERVERPORT = 50001;

	protected static int bufferSize = 1024;
	static UDPClientWordCountView clientView = new UDPClientWordCountView();
		
	public static void main(String[] args) {
		clientView.setVisible(true);
	}
	
	public static void run(String clientText) {
		try {

			// Instantiate client socket
			DatagramSocket clientSocket = new DatagramSocket();

			// Get the IP address of the server
			InetAddress serverAddress = InetAddress.getByName("localhost");

			// Create buffer to send data
			byte sendingDataBuffer[] = new byte[bufferSize];

			// Convert data to bytes and store data in the buffer
			sendingDataBuffer = clientText.getBytes();

			// Creating a UDP packet 
			DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, serverAddress, SERVERPORT);

			// Sending UDP packet to the server
			clientSocket.send(sendingPacket);
			
			// Create buffer to receive data
			byte receivingDataBuffer [] = new byte[bufferSize];
			
			// Receive data packet from server
		    DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
		    clientSocket.receive(receivingPacket);
		    
		    // Unpack packet
		    String counted = new String(receivingPacket.getData());
		    clientView.updateTotalWords(counted);

			// Closing the socket connection with the server
			clientSocket.close();
			
		} catch (Exception ex) {

			System.out.println("Durian Tunggal... we got problem");
			ex.printStackTrace();
		}
	}
}
