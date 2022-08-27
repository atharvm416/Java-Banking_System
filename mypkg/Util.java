package mypkg;
import javax.swing.*;
public class Util
{
	public static int iInput(String msg)
	{
		int d=0;
		try
		{
			d=Integer.parseInt(JOptionPane.showInputDialog(null,msg));
		}
		catch(Exception e)
		{}
		return d;
	}
	public static double dInput(String msg)
	{
		double d=0.0;
		try
		{
			d=Double.parseDouble(JOptionPane.showInputDialog(null,msg));
		}
		catch(Exception e)
		{}
		return d;
	}
	public static String sInput(String msg)
	{
		String s="";
		try
		{
			s=JOptionPane.showInputDialog(null,msg);
		}
		catch(Exception e)
		{}
		return s;
	}
	public static void display(String msg)
	{
		JOptionPane.showMessageDialog(null,msg);
	}
	public static int oInput(String[] option,String msg,String title)
	{
		int opt=0;
		opt=JOptionPane.showOptionDialog(null,msg,title,JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,option,0);
		return opt;
	}
}