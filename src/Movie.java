public class Movie {
    
    private String id;
    private String title;
    private String year;
    private Integer oscarAwards;
    private Integer oscarNominated;

    
    // public Movie(String id, String title, String year, int oscarAwards, int oscarNominated) {
    public Movie() {
        this.id = "";
        this.title = "";
        this.year = "";
        this.oscarAwards = null;
        this.oscarNominated = null;
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

    public int getOscarAwards() {
        return oscarAwards;
    }

    public void setOscarAwards(int oscarAwards) {
        this.oscarAwards = oscarAwards;
    }

    public int getOscarNominated() {
        return oscarNominated;
    }

    public void setOscarNominated(int oscarNominated) {
        this.oscarNominated = oscarNominated;
    }

    @Override
    public String toString() {
        return "Filmek{" + "id=" + id + ", Cím=" + title + ", Év=" + year + ", Oscar jelölések= " + oscarNominated + ", Elynert Oscar díjak=" + oscarAwards +"}";
    }

    
}

