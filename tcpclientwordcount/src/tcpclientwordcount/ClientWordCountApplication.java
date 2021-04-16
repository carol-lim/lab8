package tcpclientwordcount;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientWordCountApplication {
	static ClientWordCountFrame clientWCFrame = new ClientWordCountFrame();
		
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// Launch client-side frame
		clientWCFrame.setVisible(true);
		
		// Interaction between client and server happens while button in the client frame is clicked 
	}
	
	public static void run(String clientText) {
		try{
			// Connect to the server @ localHost, port 4222
			Socket socket = new Socket(InetAddress.getLocalHost(), 4222);
			
			// Update the status of the connection
			clientWCFrame.updateConnectionStatus(socket.isConnected());
			
			// Read from network
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// Get the output stream from the socket
	        OutputStream outputStream = socket.getOutputStream();
	        
			// Create data output stream to write data on netw
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			
			// Get the input of the client
			//String clientText = clientWCFrame.;
		    dataOutputStream.writeUTF(clientText);
		    
			// Output the word count
		    String wordCount = bufferedReader.readLine();
		    clientWCFrame.updateWordCount(wordCount);
			
			// Close everything
			dataOutputStream.flush();
			dataOutputStream.close();
			bufferedReader.close();
			socket.close();
			
		}catch(Exception error){
			error.printStackTrace();
		}
	}
}
