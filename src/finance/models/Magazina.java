package finance.models;

public class Magazina {
    public static int[][] artikujMagazine;
    public int[][] artikujtMagazine = {
            {1, 35},
            {2, 50},
            {3, 90},
            {4, 52},
            {5, 25},
            {6, 50},
            {7, 60},
            {8, 125},
            {9, 246},
            {10, 400},
    };

    private int[][] artikujt;

    public Magazina(int[][] artikujt) {
        this.artikujt = artikujt;
    }
    public int[][] getArtikuj() {
        return artikujt;
    }

}

