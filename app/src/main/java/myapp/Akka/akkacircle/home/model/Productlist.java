package myapp.Akka.akkacircle.home.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Productlist implements Serializable {
    @SerializedName("cate_id")
    String cate_id;

    @SerializedName("subcate_id")
    String subcate_id;

    @SerializedName("product_id")
    String product_id;

    @SerializedName("product_name")
    String product_name;

    @SerializedName("product_sku")
    String product_sku;

    @SerializedName("price")
    String price;

    @SerializedName("product_description")
    String product_description;

    @SerializedName("pro_discount")
    String pro_discount;

    @SerializedName("product_img")
    String product_img;

    public Productlist() {
    }

    public Productlist(String cate_id, String subcate_id, String product_id, String product_name, String product_sku, String price, String product_description, String pro_discount, String product_img) {
        this.cate_id = cate_id;
        this.subcate_id = subcate_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_sku = product_sku;
        this.price = price;
        this.product_description = product_description;
        this.pro_discount = pro_discount;
        this.product_img = product_img;
    }


    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getSubcate_id() {
        return subcate_id;
    }

    public void setSubcate_id(String subcate_id) {
        this.subcate_id = subcate_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(String product_sku) {
        this.product_sku = product_sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getPro_discount() {
        return pro_discount;
    }

    public void setPro_discount(String pro_discount) {
        this.pro_discount = pro_discount;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

}
