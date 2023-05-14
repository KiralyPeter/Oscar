/*
* File: Oscar.java
* Author: Király Péter
* Copyright: 2023, Király Péter
* Group: Szoft 1/2/E
* Date: 2023-05-13
* Github: https://github.com/KiralyPeter/Oscar.git
* Licenc: GNU GPL
*/


import java.util.ArrayList;

public class Oscar {
    public static void main(String[] args) throws Exception {
        
        DataBase dataBase = new DataBase(
            "jdbc:mariadb://localhost/", 
            "oscar", 
            "", 
            "");

        ArrayList<Movie> movieList = new ArrayList<>();

        if (args.length == 2) {

            FReader fileToRead = new FReader(args[0]);
            movieList = fileToRead.readFile();

            if ((dataBase.isTableExist("filmek")) && (args[1].equals("--force") || args[1].equals("-f"))) {
                System.out.println("Létezik az adattábla és --force vagy -f kapcsoló meg volt adva, így törlöm a meglévő adattáblát és újat hozok létre.");
                dataBase.dropTable();
                dataBase.createTable();
                for (int n = 1; n < movieList.size(); n++){
                    dataBase.addItem(movieList.get(n).toString());
                    // System.out.println(movieList.get(n));
                }
            } else if (!dataBase.isTableExist("filmek")){
                System.out.println("Nem létezik az adattábla, ezért létrehozom és feltöltöm...");
                dataBase.createTable();
                for (int n = 1; n < movieList.size(); n++){
                    dataBase.addItem(movieList.get(n).toString());
                    // System.out.println(movieList.get(n));
                }
            } else {
                System.out.println("A \"filmek\" adattábla már létezik. Használja a --force vagy -f kapcsolókat a meglévő adattábla törléséhez.");
            }

        } else if (args.length == 1){

            FReader fileToRead = new FReader(args[0]);
            movieList = fileToRead.readFile();
            
            if (!dataBase.isTableExist("filmek")){
                System.out.println("Nem létezik az adattábla, ezért létrehozom és feltöltöm...");
                dataBase.createTable();
                for (int n = 1; n < movieList.size(); n++){
                    dataBase.addItem(movieList.get(n).toString());
                    // System.out.println(movieList.get(n));
                }
            } else {
                System.out.println("A \"filmek\" adattábla már létezik. Használja a --force vagy -f kapcsolókat a meglévő adattábla törléséhez.");
            }
            
        } else if (args.length == 0){
            System.out.println("Hiba, nem adott meg paramétert.");
        }

       
    }
}

   

