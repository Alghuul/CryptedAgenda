
package com.fr.uha.ensisa.gjdbc.dbconnection;
// mvn install:install-file -Dfile=C:\Users\amine\Downloads\ojdbc10.jar -DgroupId=com.oracle -DartifactId=ojdbc10 -Dversion=11.2.0 -Dpackaging=jar
/**
 *
 * @author amine
 */
import com.fr.uha.ensisa.gjdbc.gui.RegisterForm;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class MyConnection {
    private static final String dbname = "jdbc:mysql://localhost:3306/java_crypted_agenda"; 
    private static final String user = "root";
    private static PreparedStatement st;
    private static ResultSet rs;
    
    public static Connection getConnection()
            {
                Connection con = null;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection(dbname,user,"");
                    
                    
                }catch(ClassNotFoundException | SQLException ex)
                {
                   ex.printStackTrace();
                }
                return con;
            }
    public static boolean checkMail(String mail)
    {
        boolean isfound = false;
        String query = "Select * From `users` Where `Mail`= ?";
        
        try {
            st= MyConnection.getConnection().prepareStatement(query);
            st.setString(1, mail);
            rs = st.executeQuery();
            if (rs.next()) {
                isfound = true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        return isfound;
    }
    
    public static DefaultTableModel displayAgenda()
    {
		
		DefaultTableModel dp =new DefaultTableModel();
		dp.addColumn("ID");
		dp.addColumn("Date");
		dp.addColumn("Hour");
		dp.addColumn("Duration");
		dp.addColumn("Event");
		try
		{
                    String query = "SELECT * FROM `agenda`";
                    st = MyConnection.getConnection().prepareStatement(query);
                    rs = st.executeQuery(query);
                    while (rs.next())
                    {
                        String id=rs.getString(1);
                        String date=rs.getString(2);
                        String hour=rs.getString(3);
                        String duration=rs.getString(4);
                        String event=rs.getString(5);
                        String[] s= {id,date,hour,duration,event};
                        dp.addRow(s);

                    }
		

	}catch(SQLException e)
	{
		e.printStackTrace();
	}
		return dp;

    }
    public static boolean addEvent(String date,String hour,String duration,String Event)
    {
        String query = "INSERT INTO `agenda`(`Date`, `Hour`, `Duration`, `Event`) VALUES(?,?,?,?)";
        try {
            st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, date);
            st.setString(2, hour);
            st.setString(3, duration);
            st.setString(4, Event);
         
            if (st.executeUpdate()>0) {
                
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    public static boolean deleteEvent(String id)
    {
        try {
			
			String query="DELETE FROM `agenda` WHERE `id` ='"+id+"' ";
			st = MyConnection.getConnection().prepareStatement(query);
			st.executeUpdate();
			return true;
			
		}catch(SQLException e)
		{
			return false;
		}
        
    }
    
    public static DefaultTableModel searchAgenda(String d)
    {
		
		DefaultTableModel dp =new DefaultTableModel();
		dp.addColumn("ID");
		dp.addColumn("Date");
		dp.addColumn("Hour");
		dp.addColumn("Duration");
		dp.addColumn("Event");
		try
		{
                    String query = "SELECT * FROM `agenda` WHERE `Date` ='"+d+"'";
                    st = MyConnection.getConnection().prepareStatement(query);
                    rs = st.executeQuery(query);
                    while (rs.next())
                    {
                        String id=rs.getString(1);
                        String date=rs.getString(2);
                        String hour=rs.getString(3);
                        String duration=rs.getString(4);
                        String event=rs.getString(5);
                        String[] s= {id,date,hour,duration,event};
                        dp.addRow(s);

                    }
		

	}catch(SQLException e)
	{
		e.printStackTrace();
	}
		return dp;

    }
    public static boolean updateEvent(String id,String date,String hour,String duration,String Event)
    {
		try {
			String query="UPDATE agenda SET Date='"+date+"',Hour='"+hour+"',Duration='"+duration+"',Event='"+Event+"'WHERE id ="+id;
			PreparedStatement st= MyConnection.getConnection().prepareStatement(query);
			st.executeUpdate(query);
			return true;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
        
    }
}
