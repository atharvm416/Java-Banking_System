import mypkg.AD;
import mypkg.aAdd;
import mypkg.aMod;
import mypkg.aDel;
import mypkg.Deposit;
import mypkg.Withdraw;
import mypkg.ADisplay;
import mypkg.ATrnDisplay;
import mypkg.ACDisplay;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;
class Bank extends JFrame
{
	aAdd dlgAdd;
	aMod dlgMod;
	aDel dlgDel;
	Deposit dlgDep;
	Withdraw dlgWith;
	ADisplay dlgADisplay;
	ATrnDisplay dlgTrnDisplay;
	ACDisplay dlgACDisplay;
	DefaultMutableTreeNode top,acc,trn,disp;
	DefaultMutableTreeNode oAdd,oMod,oDel;
	DefaultMutableTreeNode odepo,owith;
	DefaultMutableTreeNode dacc,dtrn,dbq;
	JTree tree;
	Bank()
	{
		super("Bank Saving");
		top=new DefaultMutableTreeNode("Saving");
		acc=new DefaultMutableTreeNode("Account");
		trn=new DefaultMutableTreeNode("Transaction");
		disp=new DefaultMutableTreeNode("Display");		
		top.add(acc);
		top.add(trn);
		top.add(disp);
		oAdd=new DefaultMutableTreeNode("Add");
		oMod=new DefaultMutableTreeNode("Mod");
		oDel=new DefaultMutableTreeNode("Del");
		acc.add(oAdd);
		acc.add(oMod);
		acc.add(oDel);
		odepo=new DefaultMutableTreeNode("Deposite");
		owith=new DefaultMutableTreeNode("Withdraw");
		trn.add(odepo);
		trn.add(owith);
		dacc=new DefaultMutableTreeNode("A/c");
		dtrn=new DefaultMutableTreeNode("Transaction");
		dbq=new DefaultMutableTreeNode("Balance Enq");
		disp.add(dacc);
		disp.add(dtrn);
		disp.add(dbq);
		tree=new JTree(top);
		try
		{
			dlgAdd=new aAdd(this,"Add",true);
			dlgMod=new aMod(this,"Mod",true);
			dlgDel=new aDel(this,"Del",true);
			dlgDep=new Deposit(this,"Deposit",true);
			dlgWith=new Withdraw(this,"Withdraw",true);
			dlgADisplay=new ADisplay(this,"Display",true);
			dlgTrnDisplay=new ATrnDisplay(this,"Transaction",true);
			dlgACDisplay=new ACDisplay(this,"Balance",true);
		}
		catch(Exception e)
		{}
		tree.addTreeSelectionListener(new TreeSelectionListener()
		{
			public void valueChanged(TreeSelectionEvent e)
			{
				DefaultMutableTreeNode node=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if(node!=null)
				{
					Object nodeinfo=node.getUserObject();
					if(node.isLeaf() && node==oAdd)
						dlgAdd.setVisible(true);
					if(node.isLeaf() && node==oMod)
						dlgMod.setVisible(true);
					if(node.isLeaf() && node==oDel)
						dlgDel.setVisible(true);
					if(node.isLeaf() && node==odepo)
						dlgDep.setVisible(true);
					if(node.isLeaf() && node==owith)
						dlgWith.setVisible(true);
					if(node.isLeaf() && node==dacc)
						dlgADisplay.setVisible(true);
					if(node.isLeaf() && node==dtrn)
						dlgTrnDisplay.setVisible(true);
					if(node.isLeaf() && node==dbq)
						dlgACDisplay.setVisible(true);
				}
			}
		});
		add(tree);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		Bank a=new Bank();
	}
}