package tcpobjectdatastream.client;

public class TCPODSClientModel {
	public void displayMsg(boolean validateName, String name, int id, float price) {
		String msg;
		if (validateName == true) {
			System.out.println ("Id for " + name + " is " + id+". The price is RM"+ price);
			msg = "(Product name is valid. New ID is assigned.)";
		} else {
			msg = "(Invalid product name. Unable to assign new ID. The name should contain only alphanumeric characters and spaces.)";
		}
		System.out.println(msg);
	}
}
