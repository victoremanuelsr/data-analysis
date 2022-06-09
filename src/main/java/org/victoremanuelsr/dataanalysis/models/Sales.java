package org.victoremanuelsr.dataanalysis.models;

import java.util.List;

public class Sales {
    private Long id;
    private List<Item> items;
    private String sellerName;
    private Double total;

    public Sales(Long id, List<Item> items, String sellerName, Double total) {
        this.id = id;
        this.items = items;
        this.sellerName = sellerName;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        total += getTotal();
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", items=" + items +
                ", sellerName='" + sellerName + '\'' +
                ", total=" + total +
                '}';
    }
}
