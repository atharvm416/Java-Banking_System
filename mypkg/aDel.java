package mypkg;
import mypkg.AD;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mypkg.Util;
public class aDel extends JDialog implements ActionListener,FocusListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2;
	JPanel p1,p2;
	int no,opn;
	String nm;
	public aDel(JFrame frm, String title,boolean state)
	{
		super(frm,title,state);
		l1=new JLabel("A/c No");
		l2=new JLabel("Name");
		l3=new JLabel("Opn Amt");
		l4=new JLabel("State");
		t1=new JTextField(10);
		t2=new JTextField(30);
		t3=new JTextField(10);
		t4=new JTextField("True");
		
		t2.setEditable(false);
		t3.setEditable(false);
		t1.addFocusListener(this);
		t4.setEditable(false);
		p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,5,5));
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		
		b1=new JButton("Save");
		b2=new JButton("Clear");
		b1.addActionListener(this);
		b2.addActionListener(this);
		p2=new JPanel();
		p2.add(b1);
		p2.add(b2);
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		setSize(400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void focusGained(FocusEvent e)
	{
		JTextField t=(JTextField)e.getSource();
		if(t==t1)
			b1.setEnabled(false);
	}
	public void focusLost(FocusEvent e)
	{
		JTextField t=(JTextField)e.getSource();
		if(t==t1)
		{
			try
			{
				no=Integer.parseInt(t1.getText());
			}
			catch(Exception e1)
			{
				t1.requestFocus();
				return;
			}
			boolean res=true;
			try
			{
				res=AD.aSearch(no);
			}
			catch(Exception e3)
			{}
			if(res==false)
			{
				Util.display("Record Not Exists");
				t1.requestFocus();
				return;
			}
			else
			{
				try
				{
					t2.setText(AD.rs1.getString(2));
					t3.setText(""+AD.rs1.getInt(3));
					if(AD.rs1.getBoolean(4)==false)
					{
						Util.display("Record Deleted...\n");
						t1.requestFocus();
						return;
					}
				}
				catch(Exception e4)
				{}
			}
		}
		b1.setEnabled(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton b=(JButton)e.getSource();
		if(b==b1)
		{
			nm=t2.getText();
			try
			{
				AD.aDel(no);
			}
			catch(Exception e2)
			{}
		}
		t1.requestFocus();
	}
}