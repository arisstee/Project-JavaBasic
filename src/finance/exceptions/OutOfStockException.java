package finance.exceptions;

public class OutOfStockException extends Exception {
    private String articleName;

    public OutOfStockException(String articleName) {
        this.articleName = articleName;
    }
    public String getMessage(){
        return articleName+" is out of stock!!";
}
}
