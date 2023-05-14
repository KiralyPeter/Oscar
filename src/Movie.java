/*
* File: Movie.java
* Author: Király Péter
* Copyright: 2023, Király Péter
* Group: Szoft 1/2/E
* Date: 2023-05-13
* Github: https://github.com/KiralyPeter/Oscar.git
* Licenc: GNU GPL
*/

public class Movie {
    
    private String id;
    private String title;
    private String year;
    private String oscarAwards;
    private String oscarNominated;

    
    // public Movie(String id, String title, String year, int oscarAwards, int oscarNominated) {
    public Movie() {
        id = "";
        title = "";
        year = "";
        oscarAwards = null;
        oscarNominated = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOscarAwards() {
        return oscarAwards;
    }

    public void setOscarAwards(String oscarAwards) {
        this.oscarAwards = oscarAwards;
    }

    public String getOscarNominated() {
        return oscarNominated;
    }

    public void setOscarNominated(String oscarNominated) {
        this.oscarNominated = oscarNominated;
    }

    @Override
    public String toString() {
        // return "Filmek{" + "id=" + id + ", Cím=" + title + ", Év=" + year + ", Oscar jelölések= " + oscarNominated + ", Elynert Oscar díjak=" + oscarAwards +"}";
        return id + ", " + title + ", " + year + ", " + oscarNominated + ", " + oscarAwards ;
    }

    
}

