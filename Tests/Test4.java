package Tests;

public class Test4 {
    private String film;
    
    public Test4(String film) {
        this.film = film;
    }
   

    public String getCategory() {
        String result1;
        
        switch (film) {
            case "Star Wars":
                result1 = "Sci-fi";
                break;
            case "Blanche Neige":
            case "La petite sirène":
                result1 = "Disney";
                break;
            case "Indiana Jones":
                result1 = "Adventure";
                break;
            case "Tintin":
                result1 = "Animation";
                break;
            default:
                result1 = "Inconnu";
                break;
        }
        return result1;
    }
}
