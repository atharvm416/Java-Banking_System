# GUI Based Banking System
## Illustration
* The system contains three sections: Account, Transaction, and Display for creating, deleting, and modifying accounts, and for the amount transfer and presenting the data in the JDialog 
window.
* The application includes ten packages: One package contains a JOptionPane window for small messages to display and another to connect the Java with the Microsoft Access database using JDBC and an ODBC driver.
* Eight packages include JDialog windows that assist the user in entering specified labeled values into the text field. The main file holds all eight packages under Default Mutable Tree Node a pre-defined method in the package javax.swing.tree.

# Let's have a look at the images/screenshots below to learn more about:
## 1. Initial window:
* The initial page of our system contains main saving tab which has three sub-tabs Accounts, Transaction, and Display. The following code defines the call to achieve as shown in the image.
 ```
    top=new DefaultMutableTreeNode("Saving");
		acc=new DefaultMutableTreeNode("Account");
		trn=new DefaultMutableTreeNode("Transaction");
		disp=new DefaultMutableTreeNode("Display");		
		top.add(acc);
		top.add(trn);
		top.add(disp);
```
Here in our program we have already declared DefaultMutableTreeNode and form the object of top,acc,trn,disp. Our main class is extended by a JFrame so, the window appeared on the screen is a JFrame of the swing package. The "top" is added to the JTree as follows "tree=new JTree(top)" as JTree only accepts the parameter of DefaultMutableTreeNode and the "top" is the one where we added all the other DefaultMutableTreeNode. We add JTree to our JFrame by using add(tree).
![1](https://user-images.githubusercontent.com/112277897/213777980-fd8879ed-ea68-4f20-a9c8-3e158ea077fa.png)
## 2. User-Defined packages Options:
* When we tap on all the 3 tabs we achieve the following result. These are the User-define packages where every option is a Jdialog window and it is set to false on visiblity. To activate the window we use the following set of operation to get better user interface.
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
## 3. Add account window:
* The initial page of our system contains main saving tab which has three sub-tabs Accounts, Transaction, and Display. The following code defines the call to achieve as shown in the image.
The following window appears when the user wants to add a new account to our database:
![3](https://user-images.githubusercontent.com/112277897/213778060-8365a3bd-d908-40e8-b468-b37d39c5fec7.png)
## 4. Deposit window:
* The initial page of our system contains main saving tab which has three sub-tabs Accounts, Transaction, and Display. The following code defines the call to achieve as shown in the image.
![4](https://user-images.githubusercontent.com/112277897/213779801-9128219e-5c30-4099-8e18-68db12bc2f39.png)
## 5. Display All account window:
* The initial page of our system contains main saving tab which has three sub-tabs Accounts, Transaction, and Display. The following code defines the call to achieve as shown in the image.
![5](https://user-images.githubusercontent.com/112277897/213779816-e0039a9d-169b-4791-a1b3-84e6fa1dcadd.png)
When the user presses the print button to convert it to pdf format, the following popup is displayed:
![6](https://user-images.githubusercontent.com/112277897/213779828-bca13aa0-3cb9-45d4-a246-c0a1df0e7b0f.png)
Our database elements in PDF format are shown in the following image:
![7](https://user-images.githubusercontent.com/112277897/213779845-79d03bb4-93ca-47d4-863a-8792e4390c83.png)
## 5. Microsoft Access Database:
* The initial page of our system contains main saving tab which has three sub-tabs Accounts, Transaction, and Display. The following code defines the call to achieve as shown in the image.
![10](https://user-images.githubusercontent.com/112277897/213779855-b0ede485-f316-4d4d-8067-cb9827bfd4d0.png)
The following displays our MS Access database for the Transaction table:***
![11](https://user-images.githubusercontent.com/112277897/213779864-5e2c475c-a19d-4519-88d0-ab48d292e36f.png)
