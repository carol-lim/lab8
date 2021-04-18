package tcpobjectdatastream.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import data.model.ItemProduct;

public class TCPODSClientController {

	public static void main(String[] args) {

		// Request data
		ItemProduct itemProd = new ItemProduct();
		itemProd.setName("Apieu_Hand_Cream");
		itemProd.setPrice(18.80f);

		try {

			// Data to establish connection to server
			int portNo = 4228;
			InetAddress serverAddress = InetAddress.getLocalHost();

			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);

			// Open stream to send object
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

			// Send request to server
			System.out.println("Send object to server: " + itemProd.getName());
			objectOS.writeObject(itemProd);
			objectOS.flush();
			
			// Open stream to receive object
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			DataInputStream dataIS = new DataInputStream(socket.getInputStream());
			
			TCPODSClientModel clientModel = new TCPODSClientModel();
			
			// Get object from stream and display details
			itemProd = (ItemProduct) objectIS.readObject();
			
			boolean validateName = dataIS.readBoolean() ;
			String name = itemProd.getName();
			int id = itemProd.getItemProductId();
			float price = itemProd.getPrice();
			
			clientModel.displayMsg(validateName, name, id, price);
			
			// Close all closeable objects
			objectOS.close();
			objectIS.close();
			dataIS.close();
			socket.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nClientSideApp: End of application.\n");

	}

}
