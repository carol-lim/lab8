package tcpclientwordcount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ClientWordCountFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel lblServerWordCount;
	private JLabel lblStatusValue;
	private JTextArea taClientText;
	private JButton btnSubmit;
	
	// Private attributes for frame size
	private int width = 700;
	private int height = 500;
	
	public ClientWordCountFrame () {
		
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side");
		this.setSize(width, height);
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label, text area, button
        this.lblStatusValue = new JLabel("-");
        this.taClientText = new JTextArea(10,10);
        this.btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        this.lblServerWordCount = new JLabel("-");
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
	}

	/**
	 * A method to update number of words counted by server
	 * @param serverWordCount
	 */
	public void updateWordCount(String serverWordCount) {
		this.lblServerWordCount.setText(serverWordCount+" words.");
	}
	
	public void updateConnectionStatus (boolean connStatus) {

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
				
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
	
	private JPanel getConnectionStatusPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection status: ");
		
		// Style the component
		lblConnStatus.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setFont(font);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);

		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
		
		return panel;
	}	
	
	private JPanel getServerWordCountPanel(Font font) {
		
		// Create component to display word count retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblWordCount = new JLabel ("Word Count (from Server): ");

		// Style the component
		lblWordCount.setFont(font);
		lblWordCount.setBackground(Color.WHITE);
		lblWordCount.setOpaque(true);
		lblServerWordCount.setFont(font);
		lblServerWordCount.setBackground(Color.WHITE);
		lblServerWordCount.setOpaque(true);

		// Organize components into panel
		panel.add(lblWordCount);
		panel.add(lblServerWordCount);
		
		return panel;
	} 
	
	private JPanel getClientTextPanel(Font font) {
		
		// Create component 
		JPanel panel = new JPanel();
		JLabel lblText = new JLabel ("Type a sentence: ");
		
		// Style the component
		lblText.setFont(font);
		lblText.setBackground(Color.WHITE);
		lblText.setOpaque(true);
		taClientText.setFont(font);
		taClientText.setBackground(Color.WHITE);
		taClientText.setOpaque(true);
		taClientText.setLineWrap(true);

		// Organize components into panel
		panel.add(lblText);
		panel.add(taClientText);
		
		return panel;
	}
	
	private JPanel getButtonSubmit(Font font)
	{
		// Create component 
		JPanel panel = new JPanel();
		
		// Style the component
		btnSubmit.setFont(font);
		btnSubmit.setOpaque(true);
		
		// Organize components into panel
		panel.add(btnSubmit);
		
		return panel;
	}
	
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get client status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		this.add(northPanel, BorderLayout.NORTH);
		
		// Get client text area's panel and add to frame
		JPanel center = getClientTextPanel(font);
		this.add(center, BorderLayout.CENTER);
		
		// Get client button's panel and add to frame
		JPanel center2 = getButtonSubmit(font);
		this.add(center2, BorderLayout.LINE_END);
		
		// Get client word count's panel and add to frame
		JPanel southPanel = getServerWordCountPanel(font);
		this.add(southPanel, BorderLayout.SOUTH);
		
	}
	
	private Font getFontStyle() {
		Font font = new Font ("Serif", Font.PLAIN, 30);
		return font;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSubmit) {
			
			ClientWordCountApplication.run(taClientText.getText());
			
		}
	}
}
