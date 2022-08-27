package mypkg;
import mypkg.AD;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
public class ATrnDisplay extends JDialog implements FocusListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JPanel p1,p2,p3;
	ResultSet rs;
	JTable jt;
	DefaultTableModel dtm;
	String[] colname=new String[] {"Trn Amount"};
	Object[][] arr=null;
	int no=0,opn=0,amt=0;
	String nm="";
	public ATrnDisplay(JFrame frm,String title,boolean bstate)
	{
		super(frm,title,bstate);
		l1=new JLabel("A/c No :");
		l2=new JLabel("Name :");
		l3=new JLabel("Opn Balance :");
		t1=new JTextField(10);
		t1.addFocusListener(this);
		t2=new JTextField(20);
		t3=new JTextField(10);
		t2.setEditable(false);
		t3.setEditable(false);
		p1=new JPanel();
		p1.setLayout(new GridLayout(3,2,5,5));
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		add(p1,BorderLayout.NORTH);
		
		l4=new JLabel("Closing Balance :");
		t4=new JTextField(10);
		t4.setEditable(false);
		p3=new JPanel();
		p3.add(l4);
		p3.add(t4);
		add(p3,BorderLayout.SOUTH);
		
		dtm=new DefaultTableModel(arr,colname);
		jt=new JTable(dtm);
		p2=new JPanel();
		p2.add(new JScrollPane(jt));
		add(p2,BorderLayout.CENTER);
		setSize(600,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void focusLost(FocusEvent e)
	{
		try
		{
			no=Integer.parseInt(t1.getText());
		}
		catch(Exception e1)
		{
			t1.setText("0");
			t1.requestFocus();
			return;
		}
		int i=0,n=dtm.getRowCount()-1;
		try
		{
			while(n>=0)
			{
				dtm.removeRow(n);
				n--;
			}
			if(AD.aSearch(no)==false)
			{
				Util.display("Record Not Found");
				t1.requestFocus();
				return;
			}
			nm=AD.rs1.getString(2);
			opn=amt=AD.rs1.getInt(3);
			t2.setText(nm);
			t3.setText(""+opn);
			AD.tdisplay(no);
			rs=AD.rs3;
			int tamt=0;
			while(rs.next())
			{
				tamt=rs.getInt(2);
				dtm.insertRow(i,new String[] {""+tamt});
				amt+=tamt;
				i++;
			}
			t4.setText(""+amt);
		}
		catch(Exception e2)
		{}
	}
	public void focusGained(FocusEvent e)
	{}
}
