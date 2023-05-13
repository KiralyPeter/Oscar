import java.sql.*;
import java.lang.ClassNotFoundException;

public class OscarDB {
    private String url;    
    private String database;
    private String user;
    private String password;
    private Connection connection;

    public OscarDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    public void createMariaDBConnection(){

        try {    
            Class.forName("org.mariadb.jdbc.Driver");        
        } catch (ClassNotFoundException ex) {
            System.out.println("Baj van! Nem találom a driver-t!"+ ex);
            
    
        }
        
        try { 
            this.connection = DriverManager.getConnection(url+database, user, password);
    
        } catch (SQLException ex) {
            System.out.println("Baj van! Hiba az adatbázis csatlakozásnban!"+ ex);
        }
        
        if (connection !=null)
        {
            System.out.println("Sikeresen kapcsolódtunk");
        }

    }
    
}
