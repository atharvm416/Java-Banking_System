package mypkg;
import java.sql.*;
public class AD//Account data
{
	public static ResultSet rs1,rs2,rs3;
	public static PreparedStatement paa;//add A/c
	public static PreparedStatement pam;//modify A/c
	public static PreparedStatement pad;//delete A/c
	public static PreparedStatement pas;//search A/c
	public static PreparedStatement padisp;// display A/c
	public static PreparedStatement ptd;//deposite Transaction
	public static PreparedStatement ptw;//Withdraw Transaction
	public static PreparedStatement ptbq;//Balance Enquiry
	public static PreparedStatement ptdisp;//Transaction display
	public static Connection con;
	static
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:mybank");
			paa=con.prepareStatement("insert into Account values (?,?,?,?)");
			pam=con.prepareStatement("update Account set acnm=?, acopn=? where acno=?");
			pad=con.prepareStatement("update Account set acstate=false where acno=?");
			pas=con.prepareStatement("select * from Account where acno=?");
			padisp=con.prepareStatement("select * from Account");
			ptd=con.prepareStatement("insert into Transaction values(?,?)");
			ptw=con.prepareStatement("insert into Transaction values(?,?)");
			ptbq=con.prepareStatement("select sum(amt) from Transaction where tno=?");
			ptdisp=con.prepareStatement("select * from Transaction where tno=?");
		}
		catch(Exception e)
		{}
	}
	public static void aAdd(int no,String nm,int opn) throws Exception
	{
		paa.setInt(1,no);
		paa.setString(2,nm);
		paa.setInt(3,opn);
		paa.setBoolean(4,true);
		paa.executeUpdate();
	}
	public static void aMod(int no,String nm,int opn) throws Exception
	{
		pam.setString(1,nm);
		pam.setInt(2,opn);
		pam.setInt(3,no);
		pam.executeUpdate();
	}
	public static void aDel(int no) throws Exception
	{
		pad.setInt(1,no);
		pad.executeUpdate();
	}
	public static boolean aSearch(int no)throws Exception
	{
		pas.setInt(1,no);
		rs1=pas.executeQuery();
		boolean res=rs1.next();
		return(res);
	}
	public static void aDisplay() throws Exception
	{
		rs2=padisp.executeQuery();
	}
	public static void depo(int no,int amt)throws Exception
	{
		ptd.setInt(1,no);
		ptd.setInt(2,amt);
		ptd.executeUpdate();
	}
	public static void with(int no,int amt)throws Exception
	{
		ptw.setInt(1,no);
		ptw.setInt(2,-amt);
		ptw.executeUpdate();
	}
	public static int balenq(int no)throws Exception
	{
		int amt=0;
		if(aSearch(no)==true)
			amt=rs1.getInt(3);
		int tamt=0;
		ptbq.setInt(1,no);
		rs3=ptbq.executeQuery();
		if(rs3.next())
			tamt=rs3.getInt(1);
		return amt+tamt;
	}
	public static void tdisplay(int no)throws Exception
	{
		ptdisp.setInt(1,no);
		rs3=ptdisp.executeQuery();
	}
}