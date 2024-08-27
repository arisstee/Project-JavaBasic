package finance.models;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private int nrFatures;
    private List<Artikull> artikuj;

    public Fatura(int nrFatures) {
        this.nrFatures = nrFatures;
        this.artikuj = new ArrayList<>(); // Initialize the list
    }

    public int getNrFatures() {
        return nrFatures;
    }

    public void shtoArtikull(Artikull article) {
        artikuj.add(article);
    }

    public double shumaFatures() {
        double total = 0;
        for(Artikull a : artikuj) {
            total += a.cmimiTotalMeTVSH();
        }
        return total;
    }

    public void printoFaturen() {
        System.out.println("Nr. Fatures: " + nrFatures);
        for(Artikull a : artikuj) {
            a.printoArtikull();
        }
        System.out.println("Shuma: " + shumaFatures());
    }
}