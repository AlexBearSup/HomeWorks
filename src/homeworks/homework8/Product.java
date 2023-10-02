package homeworks.homework8;
import java.time.LocalDate;

public class Product {
    String type;
    Integer price;
    Boolean discountPossible;
    LocalDate added;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getDiscountPossible() {
        return discountPossible;
    }

    public void setDiscountPossible(Boolean discountPossible) {
        this.discountPossible = discountPossible;
    }

    public LocalDate getAdded() {
        return added;
    }

    public void setAdded(LocalDate added) {
        this.added = added;
    }

    public Product(String type, Integer price, Boolean discountPossible, LocalDate added) {
        this.type = type;
        this.price = price;
        this.discountPossible = discountPossible;
        this.added = added;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discountPossible=" + discountPossible +
                ", date of added=" + added +
                '}';
    }

}
