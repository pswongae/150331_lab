package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;

public class BlogGUI extends PlainDocument implements DocumentListener, ActionListener{
	
	private JFrame mainFrame;
	private JLabel inputCharLabel;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	private int maxTextLen = 140;
	
	public BlogGUI(){
		
	}
	
	public void setWindow(int width, int height){
		
		mainFrame = new JFrame("Micro Blog Demo");
		mainFrame.setSize(width, height);
		mainFrame.setLayout(new GridLayout(0, 1));
		mainFrame.setLocationByPlatform(true);
		
		Container contentPane;
		contentPane = mainFrame.getContentPane();
		
		int borderWidth = 8;
		
		JPanel top = new JPanel();
		top.setBorder(BorderFactory.createEmptyBorder(borderWidth, borderWidth, 0, borderWidth));
		top.setLayout(new BorderLayout());
		
		inputCharLabel = new JLabel("You can still input " + maxTextLen + " Characters");
		top.add(inputCharLabel, BorderLayout.NORTH);
		
		postTextArea = new JTextArea(1, 140);
		postTextArea.setBackground(new Color(255, 255, 204));
		postTextArea.setLineWrap(true);	
		postTextArea.setDocument(this);
		postTextArea.getDocument().addDocumentListener(this);
		JScrollPane scrollPane = new JScrollPane(postTextArea);
		top.add(scrollPane, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 2));
		refresh = new JButton("refresh");
		refresh.addActionListener(this);
		refresh.setBackground(new Color(153, 153, 255));
		buttonPanel.add(refresh);
		post = new JButton("post");
		post.addActionListener(this);
		post.setBackground(new Color(153, 204, 255));
		buttonPanel.add(post);
		top.add(buttonPanel, BorderLayout.SOUTH);
		
		contentPane.add(top);
		
		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createEmptyBorder(0, borderWidth, borderWidth, borderWidth));
		bottom.setLayout(new BorderLayout());
		postContent = new JTextField("Here is my Blog");
		postContent.setHorizontalAlignment(JTextField.CENTER);
		postContent.setEditable(false);
		bottom.add(postContent);
		
		contentPane.add(bottom);
		
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
	}
	
	private void updateTextArea(){
		int remTextLen = maxTextLen - postTextArea.getText().length();
		inputCharLabel.setText("You can still input " + remTextLen + " Characters");
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		updateTextArea();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		updateTextArea();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		updateTextArea();
	}
	
	@Override
	public void insertString(int offs, String str, AttributeSet attr) throws BadLocationException {
		if(getLength() + str.length() <= maxTextLen){
			super.insertString(offs, str, attr);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==refresh){
			postTextArea.setText("");
			postContent.setText("Refreshed!");
		} else if (e.getSource()==post){
			postContent.setText(!postTextArea.getText().equals("") ? postTextArea.getText() : "Empty Post!");
		}
	}

	public static void main(String[] args){
		
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow(400, 400);
		
	}
	
}
