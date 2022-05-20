package source_code;

public class Main {
    public static void main(String[] args) {
        Boormachine boormachine = new Boormachine("merk", "type");
        Vrachtwagen vrachtwagen = new Vrachtwagen(500, 1000);

        System.out.println(boormachine.getVerhuurPrijs(3, false));
        System.out.println(vrachtwagen.getVerhuurPrijs(3, false));

        System.out.println(boormachine);

    }
}
