import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;	
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWordCountApplication {
	public static void main(String[] args) throws IOException {
		// Launch the server frame
		ServerWordCountFrame serverFrame = new ServerWordCountFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port 
		int portNo = 4222;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		WordCounter counter =  new WordCounter();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// Server needs to be alive forever
		while (true) {
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Update conn status
			serverFrame.updateServerStatus(clientSocket.isConnected());
			
			// Get input stream from connected socket
	        InputStream inputStream = clientSocket.getInputStream();
	        
	        // create a DataInputStream to read data 
	        DataInputStream dataInputStream = new DataInputStream(inputStream);
	        
	        // Read input from client
	        String clientText = dataInputStream.readUTF();
	        String wordCount = counter.getWordCount(clientText);
			
			// Create stream to write data on the network
			DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
			
			// Send current date back to the client
			outputStream.writeBytes(wordCount);
			
			outputStream.flush();
		
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus("Data sent to the client: " + wordCount + " words.");
			serverFrame.updateRequestStatus("Accepted connection to from the " + "client. Total request = " + ++totalRequest );
		}
	}
}	
