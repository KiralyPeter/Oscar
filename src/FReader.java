import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FReader {

    String fileName;

    public FReader(String fileName){
        this.fileName = fileName;
    }

    public ArrayList<Movie> readFile(){

        ArrayList<Movie> movieList = new ArrayList<>();
        FileReader fileReader = null;

        try {

            // A "fileReader" példánynak átadja a fájl nevét
            fileReader = new FileReader(fileName );
            
            // Ha nem sikerül a fájlt átadni, akkor a kivétel kezelve van...
            } catch ( FileNotFoundException ex ) {
                System.out.println( "Nincs meg a fájl" );
                ex.printStackTrace();
            }

        Scanner scanner = new Scanner(fileReader);
        

        while(scanner.hasNextLine()){
            String record = scanner.nextLine();
            
            // for devtest...
            // System.out.println(record);

            String[] recordSp = record.split(";");           
            

            Movie movie = new Movie();

            movie.setId(recordSp[0]);            
            movie.setTitle(recordSp[1]);            
            movie.setYear(recordSp[2]);            
            movie.setOscarAwards(recordSp[3]);            
            movie.setOscarNominated(recordSp[4]);
            
            movieList.add(movie);
        }

        scanner.close();

        return movieList;
    }
    
}
