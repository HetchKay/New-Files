import java.text.DateFormat;  
import java.time.LocalDate;  
import java.text.SimpleDateFormat;  
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.GregorianCalendar;
public class AWTCounter extends Frame implements ActionListener
{
private Label lblCount;
private TextField tfCounts;
private TextField tfdate;
private TextField tfmon;
private TextField tfyear;
private TextField tfCounte;
private TextField tfCount;
private TextField tfOutput;
private TextField tfOpen;
private TextField tfC;
private Button btnCount;
private Button btnadd;
private Button exit;
private Date date;
private int count = 0;
private int da;
private int mon;
private int year;
public AWTCounter ()
{
setLayout(new FlowLayout());
add(new Label("Search From Directory:"));
tfCounts = new TextField(count + "", 15);
add(tfCounts); 
add(new Label("Date:      "));
tfdate = new TextField(count + "", 15);
add(tfdate);
add(new Label("Month:      "));
tfmon = new TextField(count + "", 15);
add(tfmon);
add(new Label("Year:      "));
tfyear = new TextField(count + "", 15);
add(tfyear);

tfCounte = new TextField(count + "", 15);

lblCount = new Label("HOSTName :");
add(lblCount); 
tfCount = new TextField(30);
tfCount.setEditable(false);
add(tfCount); 

tfOutput = new TextField(10);
tfOutput.setEditable(false);
 

tfOpen = new TextField(15);
tfOpen.setEditable(false);
 

tfC = new TextField(15); 
tfC.setEditable(false);

btnCount = new Button("HostName");
add(btnCount); 
btnadd= new Button("Detailed Report");
add(btnadd);
exit= new Button("EXIT");
add(exit);
btnCount.addActionListener(this);
btnadd.addActionListener(this);
exit.addActionListener(this);
setTitle("PROJECT");
setSize(250, 400);
setVisible(true);}
private static boolean isPortInUse(String hostName, int portNumber) 
{
boolean result;
try 
{
Socket s = new Socket(hostName, portNumber);
s.close();
result = true;
}
catch(Exception e)
{
result = false;
}
return(result);
}
public class MyTable extends JFrame implements ActionListener 
{
private JTable table;
private DefaultTableModel model;
private JButton addButton; 
public MyTable() {
table = new JTable(0,4); 
model = (DefaultTableModel) table.getModel();
JScrollPane tablePanel = new JScrollPane(table);
addButton = new JButton("Get LIVE Data");
addButton.addActionListener(this);
JPanel buttonPanel = new JPanel();
buttonPanel.add(addButton); 
setLayout(new BorderLayout());
add(tablePanel);
add(buttonPanel, BorderLayout.PAGE_END);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
pack();
setVisible(true);
}
public void actionPerformed(ActionEvent et) 
{
if(et.getSource() == addButton) 
{
boolean a;
InetAddress ip ;
String hostname="null";
try 
{
ip = InetAddress.getLocalHost();
hostname = ip.getHostName();
System.out.println("Your current IP address : " + ip);
System.out.println("Your current Hostname : " + hostname);
} 
catch (UnknownHostException e) 
{
e.printStackTrace();
}
String sv=tfCounts.getText();
da=Integer.parseInt(tfdate.getText());
mon=Integer.parseInt(tfmon.getText());
year=Integer.parseInt(tfyear.getText());
tfCount.setText(hostname + ""); 
File directory = new File(sv);

		System.out.println("All Files");
		
displayFiles(directory, null);                            
}
}
public void displayFiles(File directory, FileFilter fileFilter) {
                      date=new Date(year-1900,mon-1,da,0,0,0);
		File[] files = directory.listFiles(fileFilter);
		for (File file : files) {
			Date lastMod = new Date(file.lastModified());
                        DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
                        String abc = dateFormat.format(lastMod);  
			 if(date.before(lastMod)){
                          model.addRow(new String[] {file.getName() ,abc,date.toString()});}
		}
	}

}
public static void main(String[] args) 
{
AWTCounter app = new AWTCounter();
}
@Override
   public void actionPerformed(ActionEvent evt)
  { if(evt.getSource()==btnCount)
     {     boolean a;
        InetAddress ip ;


        String hostname="null";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
            } 
        catch (UnknownHostException e) 
           {

            e.printStackTrace();
           }

tfCount.setText(hostname + ""); }
if(evt.getSource()==btnadd)
     { new MyTable();

}
if(evt.getSource()==exit)
     { System.exit(0);

}

}    
}
