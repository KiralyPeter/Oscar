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

            // A "reader" példánynak átadja a fájl nevét
            fileReader = new FileReader(fileName );
            
        // Ha nem sikerül a fájlt átadni, akkor a kivétel kezelve van...
        } catch ( FileNotFoundException ex ) {
            
            System.out.println( "Nincs meg a fájl" );
        }

        Scanner scanner = new Scanner(fileReader);
        String record = scanner.nextLine();

        while(scanner.hasNext()){
            record = scanner.nextLine();

            String[] recordSp = record.split(";");
            
            // Movie(String id, 
            // String title, 
            // String year, 
            // int oscarAwards, 
            // int oscarNominated)

            Movie movie = new Movie();

            movie.setId(recordSp[0]);
            movie.setTitle(recordSp[1]);
            movie.setYear(recordSp[2]);
            movie.setOscarAwards(Integer.valueOf(recordSp[3]));
            movie.setOscarNominated(Integer.valueOf(recordSp[4]));
        }

        scanner.close();

        return movieList;
    }
    
}
