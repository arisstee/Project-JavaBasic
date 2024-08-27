package finance.main;
import finance.models.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestProject {
    public static void main(String[] args) {
        System.err.println("☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ WELCOME ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆");
        final double EUR_TO_LEK = 101.19;
        final double USD_TO_LEK = 92.94;
         Scanner scanner = new Scanner(System.in);
         boolean continueShopping = true;
         System.out.println("The products that we offer: \nApple 119 LEK/KG, \nEggs 14 LEK/COPE, \nSauce 129 LEK/Cope, \nSpaghetti 109 LEK/COPE" +
                "\nFlour 69 LEK/COPE, \nGlasses 174.75 LEK/COPE, \nSmart Tv 1500 EURO/COPE, \nHeadphones 34.99 EURO/COPE, \nLaptop 900 USD/COPE" +
                "\nTable 432 EURO/COPE");

        do {

         System.out.println();
         Artikull artikull = new Artikull();
         List<Artikull> selectedArticles = artikull.selectedArticlesFromList();
         for (Artikull article : selectedArticles) {
             System.out.println("Choosen article: " + article.getEmri() + "\nQuanity: " + article.getSasia());
         }

         System.out.println();
         System.out.println("INVOICE LOADING...➠");
         System.out.println();
         Fatura fatura = new Fatura(001);
         for (Artikull article : selectedArticles) {
             fatura.shtoArtikull(article);
         }
         fatura.printoFaturen();

         Date currentDate = new Date();
         LlogariBankare llogariBankare = new LlogariBankare("Intessa SanPaolo Bank", "A1765273868719LIN");
         Furnitor furnitor = new Furnitor("Hassan", "K87654321K", "Tirane", llogariBankare);
            System.out.println();
         MandatPagese mandatPagese = new MandatPagese(fatura, currentDate, fatura.shumaFatures(), furnitor);
         mandatPagese.printoHeader();
         mandatPagese.printo();

         System.out.println();
         KerkeseBlerje kerkeseBlerje = new KerkeseBlerje("Tea Gagushi", currentDate, fatura);
         kerkeseBlerje.printKerkesenBlerje();

         System.out.println();
         System.out.print("Do you want to continue shopping? (yes/no): ");
         String userInput = scanner.nextLine();

         if (!userInput.equalsIgnoreCase("yes")) {
             continueShopping = false;
         }
         System.out.println("Thank you!");

     }while (continueShopping);
        System.out.println("Thank you!");

    }
}