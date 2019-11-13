package myapp.Akka.akkacircle.Model;

public class Gridlist {
    public Gridlist(int images, String text) {
        Images = images;
        Text = text;
    }

    public Gridlist(){

    }
    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        Images = images;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    private int Images;
    private String Text;

}
