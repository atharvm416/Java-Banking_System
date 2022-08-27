package mypkg;
import mypkg.AD;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
public class ADisplay extends JDialog implements ActionListener
{
	JButton b1;
	ResultSet rs;
	JTable jt;
	DefaultTableModel dtm;
	String[] colname=new String[] {"A/c No","Name","Opn Bal","State"};
	Object[][] arr=null;
	public ADisplay(JFrame frm,String title,boolean bstate)
	{
		super(frm,title,bstate);
		dtm=new DefaultTableModel(arr,colname);
		int i=0;
		try
		{
			AD.aDisplay();
			rs=AD.rs2;
			while(rs.next())
			{
				dtm.insertRow(i,new String[] {""+rs.getInt(1),rs.getString(2),""+rs.getInt(3),""+rs.getBoolean(4)});
				i++;
			}
		}
		catch(Exception e1)
		{}
		jt=new JTable(dtm);
		add(new JScrollPane(jt));
		b1=new JButton("Print");
		add(b1,BorderLayout.SOUTH);
		b1.addActionListener(this);
		setSize(400,300);
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
