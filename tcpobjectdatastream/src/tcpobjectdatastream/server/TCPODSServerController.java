package tcpobjectdatastream.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import data.model.ItemProduct;

public class TCPODSServerController {
	
	public static void main(String[] args) {
		try {
			
			// Port to receive and respond to request
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			System.out.println("Ready for request");
			
			// Server need to be alive forever thus the while(true)
			while (true) {
				
				// Accept client request for connection
				Socket socket = serverSocket.accept();
				
				// Create input stream to read object
				ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
				
				// Read object from stream and cast to ItemProduct
				ItemProduct itemProd = (ItemProduct) objectIS.readObject();
				
				// Create output stream to send object
				ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
				DataOutputStream dataOS = new DataOutputStream(socket.getOutputStream());
				
				TCPODSServerModel serverModel = new TCPODSServerModel();
				
				// Process object
				boolean validateName = serverModel.validateName(itemProd.getName());
				
				// Assign a new id for the new object.
				if (validateName == true) {
					itemProd.setItemProductId(2021);
				}
				
				objectOS.writeObject(itemProd);
				dataOS.writeBoolean(validateName);
				
				System.out.println("Ready for next request");
				
				// Close all streams
				objectIS.close();
				objectOS.close();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
