package source_code.people;

public record Klant(String naam, String achternaam) {
    @Override
    public String toString() {
        return String.format("%s, %s", achternaam, naam);
    }
}
