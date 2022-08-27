package mypkg;
import mypkg.AD;
import mypkg.Util;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Deposit extends JDialog implements ActionListener,FocusListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2;
	int no,amt;
	boolean res;
	public Deposit(JFrame frm, String title, boolean state) throws Exception
	{
		super(frm,title,state);
		l1=new JLabel("A?c No :");
		l2=new JLabel("Name :");
		l3=new JLabel("Dep Amount :");
		t1=new JTextField(10);
		t2=new JTextField(30);
		t3=new JTextField(10);
		t2.setEditable(false);
		t1.addFocusListener(this);
		t3.addFocusListener(this);
		b1=new JButton("Save");
		b2=new JButton("Back");
		b1.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new GridLayout(4,2,5,5));
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b1);
		add(b2);
		setSize(400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void focusGained(FocusEvent e)
	{		
	}
	public void focusLost(FocusEvent e)
	{
		JTextField t=(JTextField)e.getSource();
		if(t==t1)
		{
			try
			{
				no=Integer.parseInt(t.getText());
			}
			catch(Exception e1)
			{
				Util.display("Invalid Number");
				t1.requestFocus();
				return;
			}
			try
			{
				res=AD.aSearch(no);
			}
			catch(Exception e2)
			{}
			if(res==false)
			{
				Util.display("Account Number is Missing..");
				t1.requestFocus();
				return;
			}
			try
			{
				if(AD.rs1.getBoolean(4)==false)
				{
					Util.display("Account Deleted");
					t1.requestFocus();
					return;
				}
			}
			catch(Exception e3)
			{}
			try
			{
				t2.setText(AD.rs1.getString(2));
			}
			catch(Exception e4)
			{}
		}
		else
		{
			try
			{
				amt=Integer.parseInt(t3.getText());
				if(amt<100)
				{
					Util.display("Invalid Transaction Amount");
					t3.requestFocus();
					return;
				}
			}
			catch(Exception e1)
			{}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton b=(JButton)e.getSource();
		if(b==b1)
		{
			try
			{
				AD.depo(no,amt);
			}
			catch(Exception e1)
			{
			}
		}
		t1.requestFocus();
		return;
	}
}