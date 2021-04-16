package tcpclientwordcount;

import java.io.IOException;

import java.net.UnknownHostException;

public class ClientWordCountApplication {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientWordCountFrame clientWCFrame = new ClientWordCountFrame();
		clientWCFrame.setVisible(true);
		
		// Interaction between client and server happens while button in the client frame is clicked 
	}
}
