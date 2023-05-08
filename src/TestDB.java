import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {
    
    public void testDB(){

        Connection con = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "";

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
			
			String dbName = "test";

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
}
