package source_code.people;

import source_code.products.Product;

import java.util.ArrayList;

public class Medewerker {
    private String naam;
    private String username;
    private String password;
    private ArrayList<Product> verhuurdeProducten = new ArrayList<>();

    public Medewerker(String naam, String username, String password) {
        this.naam = naam;
        this.username = username;
        this.password = password;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Product> getVerhuurdeProducten() {
        return verhuurdeProducten;
    }

    public void setVerhuurdeProducten(ArrayList<Product> verhuurdeProducten) {
        this.verhuurdeProducten = verhuurdeProducten;
    }

    public void addVerhuurdeProducten(Product product) {
        this.verhuurdeProducten.add(product);
    }

    public boolean checkMedewerker(String username, String password) {
        if (getUsername().equals(username)) {
            return getPassword().equals(password);
        }
        return false;
    }
}
