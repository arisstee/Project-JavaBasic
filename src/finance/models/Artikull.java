package finance.models;
import finance.enumerations.Njesia;
import finance.enumerations.Valuta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Artikull {
    private int id;
    private String emri;
    private double cmimi;
    private Valuta valuta;
    private Njesia njesia;
    private int sasia;
    final double TVSH = 0.20;

    public Artikull() {
    }

    public Artikull(int id, String emri, double cmimi, Valuta valuta, Njesia njesia, int sasia) {
        this.id = id;
        this.emri = emri;
        this.cmimi = cmimi;
        this.valuta = valuta;
        this.njesia = njesia;
        if (sasia > 0) {
            this.sasia = sasia;
        } else {
            System.err.println("Sasia duhet të jetë numër më i madh se zero.");
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(double cmimi) {
        if (cmimi > 0) {
            this.cmimi = cmimi;
        } else {
            System.err.println("Çmimi duhet të jetë numër më i madh se zero.");
        }
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public Njesia getNjesia() {
        return njesia;
    }

    public void setNjesia(Njesia njesia) {
        this.njesia = njesia;
    }

    public int getSasia() {
        return sasia;
    }

    public void setSasia(int sasia) {
        if (sasia > 0) {
            this.sasia = sasia;
        } else {
            System.out.println("Sasia duhet të jetë numër më i madh se zero.");
        }
    }


    public double cmimiTotal() {
        double cmimiTotal = cmimi * sasia;
        if (njesia == Njesia.PAKO && sasia == 6) {
            cmimiTotal = 6 * cmimi;
        } else if (njesia == Njesia.KOLI && sasia == 20) {
            cmimiTotal = 20 * cmimi;
        }
        return cmimiTotal;
    }

    public double cmimiTotalMeTVSH() {
        return cmimiTotal() + (cmimi * TVSH);
    }

    public void printoArtikull() {
        System.out.println("ID e Artikullit: " + id);
        System.out.println("Emri i Artikullit: " + emri);
        System.out.println("Cmimi i Artikullit: " + cmimi);
        System.out.println("Valuta e Artikullit: " + valuta);
        System.out.println("Njesia e Artikulli: " + njesia);
        System.out.println("Sasia e Artikullit: " + sasia);
    }


    public List<Artikull> selectedArticlesFromList()  {
        Scanner scanner = new Scanner(System.in);
        List<Artikull> availableArticles = new ArrayList<>();
        availableArticles.add(new Artikull(1, "Apple", 119, Valuta.LEK, Njesia.KG, 35));
        availableArticles.add(new Artikull(2, "Eggs", 14, Valuta.LEK, Njesia.COPE, 100));
        availableArticles.add(new Artikull(3, "Sauce", 129, Valuta.LEK, Njesia.COPE, 90));
        availableArticles.add(new Artikull(4, "Spaghetti", 109, Valuta.LEK, Njesia.COPE, 232));
        availableArticles.add(new Artikull(5, "Flour", 69, Valuta.LEK, Njesia.COPE, 57));
        availableArticles.add(new Artikull(6, "Glasses", 174.75, Valuta.LEK, Njesia.COPE, 50));
        availableArticles.add(new Artikull(7, "Smart TV", 1500, Valuta.EURO, Njesia.COPE, 60));
        availableArticles.add(new Artikull(8, "Headphones", 34.99, Valuta.EURO, Njesia.COPE, 246));
        availableArticles.add(new Artikull(9, "Laptop", 900, Valuta.USD, Njesia.COPE, 125));
        availableArticles.add(new Artikull(10, "Table", 432, Valuta.EURO, Njesia.COPE, 152));

        List<Artikull> selectedArticles = new ArrayList<>();

        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("Enter the name of the article to add to the invoice or type 'done' to finish):");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("done")) {
                continueAdding = false;
            } else {
                boolean found = false;

                for (Artikull article : availableArticles) {
                    if (article.getEmri().toLowerCase().equals(userInput)) {
                        found = true;
                        System.out.println("Enter the quantity for '" + article.getEmri() + "':");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        if (quantity > 0 && quantity <= article.getSasia()) {
                            article.setSasia(article.getSasia() - quantity);

                            Artikull selectedArticle = new Artikull(
                                    article.getId(), article.getEmri(), article.getCmimi(),
                                    article.getValuta(), article.getNjesia(), quantity
                            );
                            selectedArticles.add(selectedArticle);
                        } else {
                            System.out.println("Invalid quantity or insufficient stock.");
                        }
                        break;
                    }
                }
            }
        }
        return selectedArticles;
    }

}
