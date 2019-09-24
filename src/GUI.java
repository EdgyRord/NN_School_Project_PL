import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

	 JFrame frame;
	 JTextField textField;
	 static JTextArea textArea;
	 NeuronNetwork network;

	/**
	 * Create the application.
	 */
	public GUI(NeuronNetwork network) {
		this.network = network; 
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 26, 473, 171);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblLig = new JLabel("Log");
		lblLig.setHorizontalAlignment(SwingConstants.CENTER);
		lblLig.setBounds(189, 11, 46, 14);
		frame.getContentPane().add(lblLig);
		
		JLabel lblEnterData = new JLabel("Enter data:");
		lblEnterData.setBounds(189, 208, 72, 14);
		frame.getContentPane().add(lblEnterData);
		
		textField = new JTextField();
		textField.setBounds(10, 230, 414, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(428, 229, 55, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblProjekt = new JLabel("");
		lblProjekt.setBounds(437, 26, 46, 14);
		frame.getContentPane().add(lblProjekt);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetClass testSet = new SetClass(textField.getText());
				network.solve(testSet);
				textField.setText("");
				
			}
			
		});
		
		frame.setVisible(true);
	}
	
	
	public static void displayLog(String text){
		textArea.append(text);
	}
}
