import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SearchCourse extends JFrame implements ActionListener, TextListener {

	private JPanel contentPane;
	JTextField txtCode = new JTextField();
	JTextField txtName = new JTextField();
	JTextField txtCredit = new JTextField();
	JButton btnSearch = new JButton("Search");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCourse frame = new SearchCourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public void textValueChanged(TextEvent e) {
		if (e.getSource() == txtCode) {
			txtCredit.enable(false);
			txtName.enable(false);
		}
		if (e.getSource() == txtName) {
			txtCredit.enable(false);
			txtCode.enable(false);
		}
		if (e.getSource() == txtCredit) {
			txtCode.enable(false);
			txtName.enable(false);
		}
	}

	/**
	 * Create the frame.
	 */
	public SearchCourse() {
		setResizable(false);
		setTitle("Search course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setBounds(40, 42, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setBounds(40, 80, 45, 13);
		contentPane.add(lblCourseName);
		
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(40, 122, 45, 13);
		contentPane.add(lblCredit);
		
		txtCode.setBounds(116, 39, 200, 19);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		txtName.setColumns(10);
		txtName.setBounds(116, 77, 200, 19);
		contentPane.add(txtName);

		txtCredit.setColumns(10);
		txtCredit.setBounds(116, 119, 200, 19);
		contentPane.add(txtCredit);

		
		btnSearch.setBounds(128, 160, 85, 21);
		contentPane.add(btnSearch);
		
		btnSearch.addActionListener(this);
//		txtCode.addTextListener(this);
//		txtCredit.addTextListener(this);
//		txtName.addTextListener(this);
	}

}
