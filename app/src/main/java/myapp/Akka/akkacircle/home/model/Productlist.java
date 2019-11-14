package myapp.Akka.akkacircle.home.model;

public class Productlist {
    private int Image;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getMaintext() {
        return Maintext;
    }

    public void setMaintext(String maintext) {
        Maintext = maintext;
    }

    public String getDescribcation() {
        return Describcation;
    }

    public void setDescribcation(String describcation) {
        Describcation = describcation;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getWait() {
        return wait;
    }

    public void setWait(String wait) {
        this.wait = wait;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddlist() {
        return addlist;
    }

    public void setAddlist(String addlist) {
        this.addlist = addlist;
    }

    private String Maintext;
    private String Describcation;
    private String discount;
    private String wait;
    private String price;
    private String addlist;

    public String getPricessless() {
        return pricessless;
    }

    public void setPricessless(String pricessless) {
        this.pricessless = pricessless;
    }

    private String pricessless;
}
