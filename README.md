# GUI Based Banking System
## Overview
* The system contains three sections: Account, Transaction, and Display for creating, deleting, and modifying accounts, and for the amount transfer and presenting the data in the JDialog 
window.
* The application includes ten packages: One package contains a JOptionPane window for small messages to display and another to connect the Java with the Microsoft Access database using JDBC and an ODBC driver.
* Eight packages include JDialog windows that assist the user in entering specified labeled values into the text field. The main file holds all eight packages under Default Mutable Tree Node a pre-defined method in the package javax.swing.tree.

## Let's have a look at the images/screenshots below to learn more about:
### 1. Initial window:
* The initial window of our system contains the main saving tab, which has three sub-tabs: Accounts, Transaction, and Display. The following code defines how to achieve a proper link between DefaultMutableTreeNodes.
 ```
    top=new DefaultMutableTreeNode("Saving");
		acc=new DefaultMutableTreeNode("Account");
		trn=new DefaultMutableTreeNode("Transaction");
		disp=new DefaultMutableTreeNode("Display");		
		top.add(acc);
		top.add(trn);
		top.add(disp);
```
* Here in our programme, we have already declared DefaultMutableTreeNode and formed the objects top,acc, trn, and disp. Our main class is extended by a JFrame, so the window that appears on the screen is a JFrame of the swing package.
* The "top" is added to the JTree as follows: "tree=new JTree(top)" as JTree only accepts the parameter of DefaultMutableTreeNode and the "top" is the one where we added all the other DefaultMutableTreeNodes. We add JTree to our JFrame by using add(tree).
![1](https://user-images.githubusercontent.com/112277897/213777980-fd8879ed-ea68-4f20-a9c8-3e158ea077fa.png)
### 2. User-Defined packages Options:
* When we tap on all three tabs, we achieve the following result, shown in the below image. These are the user-defined packages where every option is a JDialog window and it is set to false on visibility. To activate the window, we use the following set of operations to get a better user interface:
 ```
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
```
![2](https://user-images.githubusercontent.com/112277897/213778018-0cf4aa4e-9f86-468e-aed9-a4156f73331c.png)
### 3. Account window:
* In the Account section, we get three JDialog windows: one to add an account, one to modify, and the last one to delete an account. This JDialog window shown below is to add an account.
* To add an account, we require three things: an account number, a name, and an opening balance. Our system checks if the same account number is present in the database or not. If it's present, a JOptionpane window appears, and the contents in the text field are cleared. Otherwise, the data is saved to the database with the state "active" or "true".
![3](https://user-images.githubusercontent.com/112277897/213778060-8365a3bd-d908-40e8-b468-b37d39c5fec7.png)
* Similar to the Add option, we have the Modify and Delete options. In both cases, we require only the account number. When the user presses tab, the name and the opening balance are set directly. When you hit "Save," the account gets modified or deleted, depending on what you have selected.
### 4. Transaction window:
* In the transaction section, which is similar to the Account section, only the amount to deposit and withdraw is present. It checks if the account is valid or not; it also checks if the amount is more than the threshold or not, or if the amount asked for in a withdrawal is more than the account has or not. If everything is satisfactory, then it is added to the transaction database.
![4](https://user-images.githubusercontent.com/112277897/213779801-9128219e-5c30-4099-8e18-68db12bc2f39.png)
### 5. Display window:
* In Java, we can get the database information in the form of a PDF to share the data with others. I have used this approach to display the entire system's data. For that, I have used the following code:
```
      ResultSet rs;
      String[] colname=new String[] {"A/c No","Name","Opn Bal","State"};
	Object[][] arr=null;
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
```
* We have used DefaultTabelModel, which is for JTable, as it holds DefaultTabelModel. Two ResultSet are used, out of which "rs" is used to achieve the next element and insert it in the table row-wise. The second ResultSet "rs2," which has been executed in the AD.java file, helps to get all the elements in the table.
* The following code is used to let you know the specific part of AD.java that we used to get the data.
```
      ResultSet rs2
      
      PreparedStatement padisp=con.prepareStatement("select * from Account");
      
      public static void aDisplay() throws Exception
	{
		rs2=padisp.executeQuery();
	}
```
![5](https://user-images.githubusercontent.com/112277897/213779816-e0039a9d-169b-4791-a1b3-84e6fa1dcadd.png)
![6](https://user-images.githubusercontent.com/112277897/213779828-bca13aa0-3cb9-45d4-a246-c0a1df0e7b0f.png)
![7](https://user-images.githubusercontent.com/112277897/213779845-79d03bb4-93ca-47d4-863a-8792e4390c83.png)
### 5. Microsoft Access Database:
* MS Access is connected to Java by using JDBC (Java DataBase Connector) and ODBC (Open DataBase Connector) connections. I have used two tables, one for the account section and one for the transaction section. The data gets stored, modified, or deleted in this database, and we can also change or alter the data directly from MS Access as well.
* First, we created MS Access, then we added the (.mdb/.accdb) ODBC (64-bit) file, which is available and used in many Windows applications. Then, by using JDBC, we formed a connection between them, which forms a strong Java application.
![10](https://user-images.githubusercontent.com/112277897/213779855-b0ede485-f316-4d4d-8067-cb9827bfd4d0.png)
![11](https://user-images.githubusercontent.com/112277897/213779864-5e2c475c-a19d-4519-88d0-ab48d292e36f.png)
