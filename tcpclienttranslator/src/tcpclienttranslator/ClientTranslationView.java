package tcpclienttranslator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientTranslationView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	ClientTranslationModel ctm = new ClientTranslationModel();
	
	private JLabel lblStatusValue;
	private JLabel lblEnglish;
	private JLabel lblLanguage;
	private JLabel lblTranslated;
	private JLabel lblTransTxt;
	final JComboBox<String> cbEng = new JComboBox<String>(ctm.english);
	final JComboBox<String> cbLang = new JComboBox<String>(ctm.languages);
	protected JButton btnSubmit;
	
	private int width = 850;
	private int height = 200;
	
	public ClientTranslationView () {
		
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Translator: Client Side");
		this.setSize(width, height);
		
		this.lblStatusValue = new JLabel("-");
		this.lblEnglish = new JLabel("English:");
		this.lblLanguage = new JLabel("Translate to:");
		this.btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        this.lblTranslated = new JLabel("Translation:");
        this.lblTransTxt = new JLabel("-");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        loadComponent();
	}
	
	public void updateConnectionStatus (boolean connStatus) {

		String status = "No connection to server.";
		if (connStatus)
			status = "Connection has established.";
		this.lblStatusValue.setText(status);
	}
	
	private JPanel getConnectionStatusPanel(Font font) {
		
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection status: ");
		
		lblConnStatus.setFont(font);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setFont(font);
		lblStatusValue.setOpaque(true);

		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
		
		return panel;
	}	
	
	private Font getFontStyle() {
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
	}

	private JPanel getComboEng(Font font){
		JPanel panel = new JPanel();
		lblEnglish.setFont(font);
		lblEnglish.setOpaque(true);
		cbEng.setFont(font);
		cbEng.setOpaque(true);
		panel.add(lblEnglish);
		panel.add(cbEng);
		return panel;
	}
	
	private JPanel getComboLang(Font font){
		JPanel panel = new JPanel();
		lblLanguage.setFont(font);
		lblLanguage.setOpaque(true);
		cbLang.setFont(font);
		cbLang.setOpaque(true);
		panel.add(lblLanguage);
		panel.add(cbLang);
		
		return panel;
	}
	
	
	private JPanel getButtonSubmit(Font font){
		JPanel panel = new JPanel();
		
		btnSubmit.setFont(font);
		btnSubmit.setOpaque(true);
		
		panel.add(btnSubmit);
		
		return panel;
	}
	
	private JPanel getTranslatedPanel(Font font){
		JPanel panel = new JPanel();
		
		lblTranslated.setFont(font);
		lblTranslated.setOpaque(true);
		lblTransTxt.setFont(font);
		lblTransTxt.setOpaque(true);
		
		panel.add(lblTranslated);
		panel.add(lblTransTxt);
		
		return panel;
	}

	public void updateTranslatedText(String trans){
		if(cbLang.getSelectedIndex() == 2) {
			lblTransTxt.setFont(new Font ("Malgun Gothic", Font.PLAIN, 30));
		}
		this.lblTransTxt.setText(trans);
	}
	
	private void loadComponent() {
		Font font = this.getFontStyle();
		
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		this.add(northPanel, BorderLayout.NORTH);
		
		JPanel center = getComboEng(font);
		this.add(center, BorderLayout.BEFORE_LINE_BEGINS);
				
		JPanel center2 = getComboLang(font);
		this.add(center2, BorderLayout.CENTER);
		
		JPanel center3 = getButtonSubmit(font);
		this.add(center3, BorderLayout.AFTER_LINE_ENDS );
		
		JPanel southPanel = getTranslatedPanel(font);
		this.add(southPanel, BorderLayout.SOUTH);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSubmit) {
			
			
			ClientTranslationController.run(cbEng.getSelectedItem().toString(), cbLang.getSelectedIndex());
			
		}
	}
	
}
