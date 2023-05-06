import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.ClassNotFoundException;

public class DataBase {
    private String url;
    private String database;
    private String user;
    private String password;
    private Connection kapcsolat;

    public DataBase(String url, String database, String user, String password) {
       
        this.url = url;
        this.database = database;
        this.user = user;
        this.password = password;
        this.kapcsolat = null;
    
    try {    
        Class.forName("org.mariadb.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        System.out.println("Baj van! Nem találom a driver-t!"+ ex);
    }
    
    try { 
        this.kapcsolat = DriverManager.getConnection(url+database, user, password);
    } catch (SQLException ex) {
        System.out.println("Baj van! Hiba az adatbázis csatlakozásnban!"+ ex);
    }
    
    if (kapcsolat !=null)
    {
        System.out.println("Sikeresen kapcsolódtunk");
    }
}

public void showAll()
    {
        if (kapcsolat!= null)
        {
            Statement createStatement = null;        
            ResultSet rs= null;
            String sql="select * from teszt";

            try {
                createStatement = kapcsolat.createStatement();
            } catch (SQLException ex) {
               System.out.println("Baj van! Hiba a Statement létrehozásában!"+ ex);
            }
            
            if (createStatement!=null)
            {
                try {
                    rs=createStatement.executeQuery(sql);
                    
                    while(rs.next())
                    {
                        System.out.println(rs.getInt("ID")+" | "
                                +rs.getString("Name"));
                    }
                    
                } catch (SQLException ex) {
                   System.out.println("Baj van! Hiba a Query futtatásánál!"+ ex);
                }
            }
        }
    }

public void addItem(String id, String name){    
    if (kapcsolat!= null)
        {
            Statement createStatement = null;        
            String sql="insert into teszt values(null,'"+name+"');";

            try {
                createStatement = kapcsolat.createStatement();
            } catch (SQLException ex) {
                System.out.println("Baj van! Hiba a Statement létrehozásában!"+ ex);
            }
            
            if (createStatement!=null)
            {
                try {
                    createStatement.execute(sql);                    
                                        
                } catch (SQLException ex) {
                    System.out.println("Baj van! Hiba a Create-nél!"+ ex);
                }
            }
        }
    }
}
