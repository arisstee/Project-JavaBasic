package finance.models;

import java.util.Date;

public class MandatPagese {
    private Fatura fatura;
    private Date dataPagese;
    private double shumaPagese;
    private Furnitor furnitori;
    private boolean deliveredSuccessfully;

    public MandatPagese(Fatura fatura, Date dataPagese, double shumaPagese, Furnitor furnitori)
    {
        this.fatura = fatura;
        this.dataPagese = dataPagese;
        this.shumaPagese = shumaPagese;
        this.furnitori = furnitori;

    }
    public boolean isDeliveredSuccessfully() {
        return deliveredSuccessfully;
    }
    public void printo() {
        // Print mandate details
        System.out.println("Fatura ID: " + fatura.getNrFatures()+fatura);
        System.out.println("Data e Pageses: " + dataPagese);
        System.out.println("Shuma e Pagese: " + shumaPagese);
        System.out.println("Furnitori: " + furnitori.getEmri());
    }

    public boolean validateWithMagazineStock(Magazina magazine) {
        int[][] articles = magazine.getArtikuj();

        for (int[] article : articles) {
            int articleId = article[0];
            int quantityNeeded = article[1];

            int[][] artikujMagazine = magazine.getArtikuj();
            boolean articleFound = false;

            for (int[] magazineArticle : artikujMagazine) {
                if (magazineArticle[0] == articleId && magazineArticle[1] >= quantityNeeded) {
                    articleFound = true;
                    break;
                }
            }
            if (!articleFound) {
                return false;
            }
        }
        return true;
    }

    public void printoMandatin() {
        printoHeader();
        System.out.println("Informacioni i Mandatit të Pagesës:");
        printo();
    }

    public void printoHeader() {
        System.out.println("**************************************");
        System.out.println("******** Mandati i Pagesës ***********");
        System.out.println("**************************************");
    }
}
