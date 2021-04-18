package tcpobjectdatastream.server;

public class TCPODSServerModel {
	/**
	 * Validate the name of name of the product. 
	 * The name should contain only alphanumeric characters and spaces.
	 * @param name of product
	 * @return valid or not
	 */
	public boolean validateName(String name) {
		boolean bool = false;
		bool = name.matches("[a-zA-Z0-9\\s]*");

		return bool;
	}
	
}
