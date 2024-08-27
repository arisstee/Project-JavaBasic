package finance.models;
import java.util.Date;

public class KerkeseBlerje {
    private String bleresi;
    private Date data;
    private Fatura fatura;

    public KerkeseBlerje(String bleresi, Date data, Fatura fatura) {
        this.bleresi = bleresi;
        this.data = data;
        this.fatura = fatura;
    }
    public void printKerkesenBlerje() {
        // prints 80 *
        for (int i = 0; i < 80; i++) {
            System.out.print("*");
        }
        System.out.println(); // Shko në rreshtin e ri pas headerit

        // Printimi i informacioneve të kërkesës
        System.out.println("Kërkesa Blerje:");
        System.out.println("Blerësi: " + bleresi);
        System.out.println("Data: " + data);
        System.out.println("Fatura:");
        fatura.printoFaturen();

        for (int i = 0; i < 80; i++) {
            System.out.print("*");
        }
        System.out.println();
    }


}