package blog;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlogGUI{
	
	private JFrame mainFrame;
	private JLabel inputCharLabel;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	public BlogGUI(){
		
	}
	
	public void setWindow(int width, int height){
		
		mainFrame = new JFrame("Your Name");
		mainFrame.setSize(width, height);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setLocationByPlatform(true);
		
		Container contentPane;
		contentPane = mainFrame.getContentPane();
		
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		inputCharLabel = new JLabel("You can still input ??? Characters");
		top.add("North", inputCharLabel);
		postTextArea = new JTextArea();
		postTextArea.setRows(15);
		top.add("South", postTextArea);
		contentPane.add("North", top);
		
		//mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args){
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow(600, 800);
	}
	
}
