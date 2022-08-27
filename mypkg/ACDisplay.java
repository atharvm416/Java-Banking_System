package mypkg;
import mypkg.AD;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ACDisplay extends JDialog implements ActionListener
{
	JTable jt;
	JScrollPane jsp;
	DefaultTableModel dtm;
	String[][] arr;
	JButton b1;
	JPanel p1,p2,p3;
	JLabel l1;
	int no,amt,i;
	String nm,state;
	ResultSet rs;
	public ACDisplay(JFrame frm,String title,boolean st)
	{
		super(frm,title,st);
		i=0;
		l1=new JLabel("A/c List :");
		p1=new JPanel();
		p1.add(l1);
		add(p1,BorderLayout.NORTH);
		String[] chead=new String[] {"A/c No ","Name ","Balance ","State "};
		dtm=new DefaultTableModel(arr,chead);
		b1=new JButton("Print");
		b1.addActionListener(this);
		p3=new JPanel();
		p3.add(b1);
		add(p3,BorderLayout.SOUTH);
		try
		{
			AD.aDisplay();
			rs=AD.rs2;
			while(rs.next())
			{
				no=rs.getInt(1);
				nm=rs.getString(2);
				amt=AD.balenq(no);
				state=((rs.getBoolean(4))? "Valid" : "Invalid");
				dtm.insertRow(i,new String[] {""+no,nm,""+amt,state});
				i++;
			}
			jt=new JTable(dtm);
		}
		catch(Exception e1)
		{}
		jsp=new JScrollPane(jt);
		p2=new JPanel();
		p2.add(jsp);
		add(p2,BorderLayout.CENTER);
		setSize(600,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			jt.print();
		}
		catch(Exception e1)
		{}
	}
}