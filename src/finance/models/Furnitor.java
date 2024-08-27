package finance.models;

public class Furnitor {
    private String emri;
    private String NIPT;
    private String adresa;
    private LlogariBankare llogariaBankare;

    public Furnitor(String emri, String NIPT, String adresa, LlogariBankare llogariaBankare) {
        this.emri = emri;
        this.NIPT = NIPT;
        this.adresa = adresa;
        this.llogariaBankare = llogariaBankare;
    }

    public String getEmri() {
        return emri;
    }

    @Override
    public String toString() {
        return "Furnitor{" +
                "emri='" + emri + '\'' +
                ", NIPT='" + NIPT + '\'' +
                ", adresa='" + adresa + '\'' +
                ", llogariaBankare=" + llogariaBankare +
                '}';
    }
}
