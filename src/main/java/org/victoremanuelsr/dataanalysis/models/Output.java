package org.victoremanuelsr.dataanalysis.models;

public class Output {
    private Long customers;
    private Long sellers;
    private Long idSale;
    private String worstSeller;

    public Output() {
    }

    public Output(Long customers, Long sellers, Long idSale, String worstSeller) {
        this.customers = customers;
        this.sellers = sellers;
        this.idSale = idSale;
        this.worstSeller = worstSeller;
    }

    public Long getCustomers() {
        return customers;
    }

    public void setCustomers(Long customers) {
        this.customers = customers;
    }

    public Long getSellers() {
        return sellers;
    }

    public void setSellers(Long sellers) {
        this.sellers = sellers;
    }

    public Long getIdSale() {
        return idSale;
    }

    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }

    public String getWorstSeller() {
        return worstSeller;
    }

    public void setWorstSeller(String worstSeller) {
        this.worstSeller = worstSeller;
    }

    @Override
    public String toString() {
        return "Output{" +
                "Amount of clients in the input file: " + customers +
                ", Amount of salesman in the input file: " + sellers +
                ", ID of the most expensive sale: " + idSale +
                ", Worst salesman ever: '" + worstSeller + '\'' +
                '}';
    }
}
