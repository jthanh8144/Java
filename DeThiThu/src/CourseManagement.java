import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CourseManagement extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnAdd = new JButton("Add a new course");
	JButton btnView = new JButton("Display all courses");
	JButton btnSearch = new JButton("Search course by Course code");
	JButton btnExit = new JButton("Exit Application");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseManagement frame = new CourseManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			AddCourse addFrame = new AddCourse();
			addFrame.setVisible(true);
		}
		if (e.getSource() == btnView) {
			ListCourse viewFrame = new ListCourse();
			viewFrame.setVisible(true);
		}
		if (e.getSource() == btnSearch) {
			SearchCourse searchFrame = new SearchCourse();
			searchFrame.setVisible(true);
		}
		if (e.getSource() == btnExit) {
			System.exit(0);
		}
	}

	public CourseManagement() {
		setResizable(false);
		setTitle("Courses management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Management");
		lblNewLabel.setBounds(168, 27, 115, 21);
		contentPane.add(lblNewLabel);
		
		btnAdd.setBounds(90, 68, 243, 28);
		contentPane.add(btnAdd);

		btnView.setBounds(90, 120, 243, 28);
		contentPane.add(btnView);

		btnSearch.setBounds(90, 171, 243, 28);
		contentPane.add(btnSearch);

		btnExit.setBounds(90, 225, 243, 28);
		contentPane.add(btnExit);
		
		btnAdd.addActionListener(this);
		btnView.addActionListener(this);;
		btnSearch.addActionListener(this);;
		btnExit.addActionListener(this);
	}
}
