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

public void createTable(String tableName, String column1, String col){

}

public void createTable(){

    Statement createStatement = null;        
    ResultSet rs= null;
    String sql="CREATE TABLE `oscar`.`teszt` (`ID` INT NOT NULL AUTO_INCREMENT , `Name` TEXT NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;";

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

// public void addItem(String id, String name){    
public void addItem(String movie){    
    if (kapcsolat!= null)
        {
            Statement createStatement = null;        
            // String sql="insert into 'filmek' values(null,'"+movie+"');";
            String sql="insert into filmek values(null, " + movie + ");";

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

public void isDBExist(){

    Connection con = null;
		ResultSet rs = null;

		
		try{

			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
			
			String dbName = "oscar";

			if(con != null){
				
				System.out.println("check if a database exists using java");

				rs = con.getMetaData().getCatalogs();

				while(rs.next()){
					String catalogs = rs.getString(1);
					
					if(dbName.equals(catalogs)){
						System.out.println("the database "+dbName+" exists");
					}
				}

			}
			else{
				System.out.println("unable to create database connection");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if( rs != null){
				try{
				    rs.close();
				}
				catch(SQLException ex){
					ex.printStackTrace();
				}
			}
			if( con != null){
				try{
				    con.close();
				}
				catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}


}


public void isTableExist(){

    Connection con = null;
	ResultSet rs = null;

		
		try{

			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
			
			String dbName = "oscar";

			if(con != null){
				
				System.out.println("check if a databaseTable exists using java");

				rs = con.getMetaData().getTables(null, null, "teszt", null);

				while(rs.next()){
					String catalogs = rs.getString(1);
					
					if(dbName.equals(catalogs)){
						System.out.println("the database table "+dbName+" exists");
					}
				}

			}
			else{
				System.out.println("unable to create database connection");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if( rs != null){
				try{
				    rs.close();
				}
				catch(SQLException ex){
					ex.printStackTrace();
				}
			}
			if( con != null){
				try{
				    con.close();
				}
				catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}


}
}
