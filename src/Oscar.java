
import java.util.ArrayList;

public class Oscar {
    public static void main(String[] args) throws Exception {
        // [TESZTELÉSHEZ!] System.out.println("Működik..");
        
        // ArrayList<Movie> movieList = new ArrayList<>();
        // FReader fileToRead = new FReader("filmek.txt");
        // FReader fileToRead = new FReader(args[0]);
        // System.out.println("Az adatbázis ebből a fájlból kerül feltöltésre: " + args[0]);

        // movieList = fileToRead.readFile();

        // for devtest - checking movieList array size
        // System.out.println("movieList.size(): " + movieList.size());
        
        DataBase dataBase = new DataBase("jdbc:mariadb://localhost/", "oscar", "root", "Mf2Hd6574");
        // dataBase.showAll();
        // dataBase.showTables();

        // dataBase.addItem("null", "peti");
        // dataBase.createTable();
        if(dataBase.isDBExist("oscar3")){
            System.out.println("Az adatbázis létezik");
        } else {
            System.out.println("Az adatbázis nem létezik");
        }
        
        
        


        if (dataBase.isTableExist("filmek")){
            System.out.println("Az adattábla létezik");
        } else {
            System.out.println("Az adattábla nem létezik");
        }


        

        // for (String s: args){
        //     System.out.println(s);
        // }

        // [TESZTELÉSHEZ!] Bejárom a movieList elemeit és kiiratom őket. A get(n) a Movie osztály toString metóduisát használja.
        // for (int n = 1; n < movieList.size(); n++){
        //     System.out.println(movieList.get(n));
        // }
        
        // [TESZTELÉSHEZ!] System.out.println(movieList.get(178));
       
        // for (int n = 1; n < movieList.size(); n++){
        //     dataBase.addItem(movieList.get(n).toString());
        //     // System.out.println(movieList.get(n));
        // }
        
       
    }

    
   
  
}
