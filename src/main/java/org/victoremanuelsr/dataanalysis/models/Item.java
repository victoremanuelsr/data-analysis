package org.victoremanuelsr.dataanalysis.models;

public class Item {
    private Long id;
    private Long quantity;
    private Double price;

    private Double total;


    public Item() {
    }

    public Item(Long id, Long quantity, Double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.total = total();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal(){
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public Double total(){
        setTotal(getQuantity() * getPrice());
        return getTotal();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
