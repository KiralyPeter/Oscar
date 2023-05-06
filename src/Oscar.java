import java.util.ArrayList;

public class Oscar {
    public static void main(String[] args) throws Exception {
        System.out.println("Működik..");
        
        ArrayList<Movie> movieList = new ArrayList<>();
        FReader fileToRead = new FReader("filmek.txt");

        movieList = fileToRead.readFile();
        System.out.println("movieList.size(): " + movieList.size());
        
        
       
    }

   
  
}
