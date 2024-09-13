

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class UiDesign extends JFrame implements ActionListener{

	static JPanel contentPane;
	static JTextField textField;
	static JTextField textField_1;
	static JTextField textField_2;
	static JTextField textField_3;
	static JDateChooser dateChooser ;
	static JDateChooser dateChooser_1 ;
	static JComboBox comboBox;
	static JSpinner spinner;
	static JComboBox comboBox_1;

	static String formatChanger;
	static String formatChanger1;
	private JTable table;
	private JTable table_1;
	 List<String[]> filteredData ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiDesign frame = new UiDesign();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UiDesign() {

		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setBounds(100, 100, 850, 550);
		  contentPane = new JPanel();
		  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setContentPane(contentPane);
		  contentPane.setLayout(null);
		  ImageIcon img = new ImageIcon(this.getClass().getResource("ami.jpeg"));
		  
		  
		  filteredData = new ArrayList<>();
		  JList list = new JList();
		  list.setBounds(401, 474, 100, -100);
		  contentPane.add(list);
		  
		     comboBox = new JComboBox(); 
		  comboBox.setModel(new DefaultComboBoxModel(new String[] {"London", "Tokyo", "Amsterdam", "Bangkok", "Calro", 
				  "Delhi", "Dubai", "Hong Kong", "Johannesburg", "Lagos", "LasVegas", "Lisbon", "London", "Madrid", "Marrakesh", 
				  "Mexico", "Moscow", "New York", "Rome ", "San Paulo", "Sweden ", "Sydney", "Texas", "Tokyo"}));
		  comboBox.setBounds(88, 182, 212, 22);
		  contentPane.add(comboBox);
		  
		   comboBox_1 = new JComboBox();
		  comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"London", "Tokyo", "Amsterdam", "Bangkok", "Calro", 
				  "Delhi", "Dubai", "Hong Kong", "Johannesburg", "Lagos", "LasVegas", "Lisbon", "London", "Madrid", "Marrakesh",
				  "Mexico", "Moscow", "New York", "Rome ", "San Paulo", "Sweden ", "Sydney", "Texas", "Tokyo"}));
		  comboBox_1.setBounds(96, 313, 204, 22);
		  contentPane.add(comboBox_1);
		  
		  JButton Search = new JButton("Search");

		  Search.setBounds(314, 283, 89, 23);
		  Search.addActionListener(this);
		  contentPane.add(Search);
		  
		  JScrollPane ak = new JScrollPane();
		  ak.setBounds(361, 521, 204, -173);
		  contentPane.add(ak);
		  
		  JList list_1 = new JList();
		  list_1.setBounds(361, 498, 162, -154);
		  contentPane.add(list_1);
		  
		  JLabel lblNewLabel = new JLabel("From");
		  lblNewLabel.setBounds(32, 186, 46, 14);
		  contentPane.add(lblNewLabel);
		  
		  JLabel lblNewLabel_1 = new JLabel("To");
		  lblNewLabel_1.setBounds(32, 316, 27, 14);
		  contentPane.add(lblNewLabel_1);
		  
		  JScrollPane scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBounds(42, 472, 146, -137);
		  contentPane.add(scrollPane_1);
		  
		  dateChooser = new JDateChooser();
		  dateChooser.setBounds(93, 238, 207, 26);
		  contentPane.add(dateChooser);
		  
		  dateChooser_1 = new JDateChooser();
		  dateChooser_1.setBounds(106, 362, 194, 26);
		  contentPane.add(dateChooser_1);
		  
		  JLabel lblNewLabel_2 = new JLabel("Return");
		  lblNewLabel_2.setBounds(24, 372, 61, 16);
		  contentPane.add(lblNewLabel_2);
		  
		  JLabel lblNewLabel_3 = new JLabel("Depart");
		  lblNewLabel_3.setBounds(24, 248, 61, 16);
		  contentPane.add(lblNewLabel_3);
		  
		  JLabel lblNewLabel_4 = new JLabel("ASFAND-Airport ");
		  lblNewLabel_4.setForeground(SystemColor.controlHighlight);
		  lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		  lblNewLabel_4.setBounds(42, 16, 258, 58);
		  contentPane.add(lblNewLabel_4);
		  
		  table = new JTable();
		  table.setModel(new DefaultTableModel(
	                new Object[][] {
	                },
	                new String[] {
	                        "Departure", "time", "Return", "date", "code", "New column", "New column", "New column", "New column", "New column"
	                }
	        ));
		  table.setBounds(401, 139, 423, 151);
		  contentPane.add(table);
		  
		  table_1 = new JTable();
		  table_1.setModel(new DefaultTableModel(
	                new Object[][] {
	                },
	                new String[] {
	                        "Departure", "time", "Return", "date", "code", "New column", "New column", "New column", "New column", "New column"
	                }
	        ));
		  table_1.setBounds(401, 302, 423, 151);
		  contentPane.add(table_1);
		  
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LocalDate JdatechooserTime1 = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate JdatechooserTime2 = dateChooser_1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        if (JdatechooserTime2.isBefore(JdatechooserTime1)) {
            JOptionPane.showMessageDialog(null,"Return time must be after departure time.","Error",JOptionPane.PLAIN_MESSAGE);
        } else if (JdatechooserTime2.equals(JdatechooserTime1)) {
            JOptionPane.showMessageDialog(null,"Your return and departure time are same","Error",JOptionPane.PLAIN_MESSAGE);
        } else if (comboBox.getSelectedItem() == comboBox_1.getSelectedItem()) {
            JOptionPane.showMessageDialog(null,"your data is same, Please chake it","Error",JOptionPane.PLAIN_MESSAGE);
        } else{
        	DateFormat df=new SimpleDateFormat("dd/MM/YYYY");
            java.util.Date p = dateChooser_1.getDate();
            java.util.Date q= dateChooser.getDate();
            formatChanger=df.format(p);
            formatChanger1=df.format(p);

        }
        String fileNanme = "Flights.csv";

        List<String[]> csv = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileNanme))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                csv.add(row);
            }
        } catch (IOException ye) {
            ye.printStackTrace();
        }
        
        
        
       
        for (String[] CsvRow : csv) {
            if ( CsvRow[7].equals(UiDesign.comboBox.getSelectedItem()) && CsvRow[9].equals(UiDesign.comboBox_1.getSelectedItem()) &&CsvRow[0].equals(UiDesign.formatChanger) ){
                filteredData.add(CsvRow);
            }
        }
        DefaultTableModel tableErrange = (DefaultTableModel) table_1.getModel();
        List<String[]> filteredData2 = new ArrayList<>();
        
       
        
        for (String[] CsvRow1 : csv) {
            if ( CsvRow1[7].equals(UiDesign.comboBox_1.getSelectedItem()) && CsvRow1[9].equals(UiDesign.comboBox.getSelectedItem()) &&CsvRow1[0].equals(UiDesign.formatChanger1) ) {
                    filteredData2.add(CsvRow1);
            }
        }
        
        DefaultTableModel tableErrange2 = (DefaultTableModel) table.getModel();
        
        for (String[] CsvRow1 : filteredData) {
        	tableErrange2.addRow(CsvRow1);
        } 
       
        for (String[] CsvRow : filteredData2) {
        	tableErrange.addRow(CsvRow);	        
        }
        

       
        
        
        
        
        
	   
	

	}
}
