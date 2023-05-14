/*
* File: DataBase.java
* Author: Király Péter
* Copyright: 2023, Király Péter
* Group: Szoft 1/2/E
* Date: 2023-05-13
* Github: https://github.com/KiralyPeter/Oscar.git
* Licenc: GNU GPL
*/

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
    private Connection connection;

public DataBase(String url, String database, String user, String password) {
       
        this.url = url;
        this.database = database;
        this.user = user;
        this.password = password;
        this.connection = null;
    
    try {    
        Class.forName("org.mariadb.jdbc.Driver");        
    } catch (ClassNotFoundException ex) {
        System.out.println("Nem találom a driver-t!"+ ex);
        

    }
    
    try { 
        this.connection = DriverManager.getConnection(url+database, user, password);

    } catch (SQLException ex) {
        System.out.println("Hiba az adatbázis csatlakozásnban!"+ ex);
    }
    
    if (connection !=null)
    {
        System.out.println("Sikeresen kapcsolódtunk az adatbázishoz");
    }
}

public void createTable(){

    Statement createStatement = null;        
    ResultSet rs= null;
    String sql="CREATE TABLE `oscar`.`filmek` (`id` INT NOT NULL AUTO_INCREMENT , `azon` CHAR(6) NOT NULL , `cim` VARCHAR(1024) NOT NULL , `ev` INT NOT NULL , `dij` INT NOT NULL , `jelol` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";

    try {
        createStatement = connection.createStatement();
    } catch (SQLException ex) {
       System.out.println("Hiba a Statement létrehozásában!"+ ex);
    }

    if (createStatement!=null)
    {
        try {
            createStatement.execute(sql);                    
                                
        } catch (SQLException ex) {
            System.out.println("Hiba a Create-nél!"+ ex);
        }
    }
}

public void createDatabase(){

    Statement createStatement = null;        
    ResultSet rs= null;
    String sql="CREATE DATABASE oscar CHARACTER SET utf8 COLLATE utf8_hungarian_ci;";

    try {
        createStatement = connection.createStatement();
    } catch (SQLException ex) {
       System.out.println("Hiba a Statement létrehozásában!"+ ex);
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
        if (connection!= null)
        {
            Statement createStatement = null;        
            ResultSet rs= null;
            String sql="select * from filmek";

            try {
                createStatement = connection.createStatement();
            } catch (SQLException ex) {
               System.out.println("Baj van! Hiba a Statement létrehozásában!"+ ex);
            }
            
            if (createStatement!=null)
            {
                try {
                    rs=createStatement.executeQuery(sql);
                    
                    while(rs.next())
                    // "azon";"cim";"ev";"dij";"jelol"
                    {
                        System.out.println(rs.getInt("id")+" | "
                                +rs.getString("azon")+" | "
                                +rs.getString("cim")+" | "
                                +rs.getString("ev")+" | "
                                +rs.getString("dij")+" | "
                                +rs.getString("jelol")                                
                                );
                    }
                    
                } catch (SQLException ex) {
                   System.out.println("Baj van! Hiba a Query futtatásánál!"+ ex);
                }
            }
        }
    }

public void showTables()
    {
        if (connection!= null)
        {
            Statement createStatement = null;        
            ResultSet rs= null;
            String sql="SHOW TABLES FROM oscar";

            try {
                createStatement = connection.createStatement();
            } catch (SQLException ex) {
               System.out.println("Baj van! Hiba a Statement létrehozásában!"+ ex);
            }
            
            if (createStatement!=null)
            {
                try {
                    rs=createStatement.executeQuery(sql);
                    
                    while(rs.next())
                    
                    {
                        System.out.println(rs.getString("tables_in_oscar"));
                    }
                    
                } catch (SQLException ex) {
                   System.out.println("Baj van! Hiba a Query futtatásánál!"+ ex);
                }
            }
        }
    }

public void dropTable(){
    Statement createStatement = null;        
    ResultSet rs= null;
    String sql="DROP TABLE IF EXISTS filmek;";

    try {
        createStatement = connection.createStatement();
    } catch (SQLException ex) {
       System.out.println("Hiba a Statement létrehozásában!"+ ex);
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
// public void addItem(String id, String name){    
public void addItem(String movie){    
    if (connection!= null)
        {
            Statement createStatement = null;        
            // String sql="insert into 'filmek' values(null,'"+movie+"');";
            String sql="insert into filmek values(null, " + movie + ");";

            try {
                createStatement = connection.createStatement();
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

public boolean isDBExist(String databaseName){

    boolean exists = false;
    String database = databaseName;

    if (connection!= null)
    {
        Statement createStatement = null;        
        ResultSet rs= null;
        String sql="SHOW DATABASES";

        try {
            createStatement = connection.createStatement();
        } catch (SQLException ex) {
           System.out.println("Hiba a Statement létrehozásában!"+ ex);
        }
        
        if (createStatement!=null){
            try {
                rs=createStatement.executeQuery(sql);

                
                
                while(rs.next())
                // "azon";"cim";"ev";"dij";"jelol"
                {
                    if(rs.getString(1).equals(databaseName)){
                        System.out.println("A "+ databaseName + " adatbázis létezik");
                        exists = true;
                    } 

                    // System.out.println(rs.getString(1));
                }
                
            } catch (SQLException ex) {
               System.out.println("Hiba a Query futtatásánál!"+ ex);
            }
        }
    }
    return exists;

}


public boolean isTableExist(String table){
    
    boolean exists = false;
    String tableName = table;

    if (connection!= null)
    {
        Statement createStatement = null;        
        ResultSet rs= null;
        String sql="SHOW TABLES FROM oscar";

        try {
            createStatement = connection.createStatement();
        } catch (SQLException ex) {
           System.out.println("Hiba a Statement létrehozásában!"+ ex);
        }
        
        if (createStatement!=null){
            try {
                rs=createStatement.executeQuery(sql);

                
                
                while(rs.next())
                // "azon";"cim";"ev";"dij";"jelol"
                {
                    if(rs.getString(1).equals(tableName)){
                        // System.out.println("A "+ tableName + " tábla létezik");
                        exists = true;
                    } 

                    // System.out.println(rs.getString(1));
                }
                
            } catch (SQLException ex) {
               System.out.println("Hiba a Query futtatásánál!"+ ex);
            }
        }
    }
    return exists;
}



}
