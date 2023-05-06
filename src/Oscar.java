import java.util.ArrayList;

public class Oscar {
    public static void main(String[] args) throws Exception {
        System.out.println("Működik..");
        
        ArrayList<Movie> movieList = new ArrayList<>();
        FReader fileToRead = new FReader("filmek.txt");

        movieList = fileToRead.readFile();

        // for devtest - checking movieList array size
        // System.out.println("movieList.size(): " + movieList.size());
        
        DataBase dataBase = new DataBase("jdbc:mariadb://localhost/", "oscar2", "root", "Mf2Hd6574");
        dataBase.showAll();
        dataBase.addItem("null", "peti");
       
    }

   
  
}
