package blog;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
		mainFrame.setLayout(new GridLayout(0, 1));
		mainFrame.setLocationByPlatform(true);
		
		Container contentPane;
		contentPane = mainFrame.getContentPane();
		
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		inputCharLabel = new JLabel("You can still input ??? Characters");
		top.add(inputCharLabel, BorderLayout.NORTH);
		postTextArea = new JTextArea();
		top.add(postTextArea, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		refresh = new JButton("refresh");
		refresh.setPreferredSize(new Dimension(width/2, 30));
		buttonPanel.add(refresh, BorderLayout.WEST);
		post = new JButton("post");
		post.setPreferredSize(new Dimension(width/2, 30));
		buttonPanel.add(post, BorderLayout.CENTER);
		top.add(buttonPanel, BorderLayout.SOUTH);
		
		contentPane.add(top);
		
		postContent = new JTextField();
		
		contentPane.add(postContent);
		
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args){
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow(600, 800);
	}
	
}
