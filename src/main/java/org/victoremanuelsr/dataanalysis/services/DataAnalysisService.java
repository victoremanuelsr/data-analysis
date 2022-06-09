package org.victoremanuelsr.dataanalysis.services;

import org.victoremanuelsr.dataanalysis.dao.DataAnalysisDAO;
import org.victoremanuelsr.dataanalysis.exceptions.DataAnalysisException;
import org.victoremanuelsr.dataanalysis.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataAnalysisService {
    public List<Seller> sellers = new ArrayList<>();
    public List<Customer> customers = new ArrayList<>();
    public List<Sales> sales = new ArrayList<>();

    public void startDataAnalysis(){
        DataAnalysisDAO.input();
    }
    public void setPath(String path){
        if(!path.isEmpty()){
            DataAnalysisDAO.PATH = path;
        }
    }

    public Optional<Customer> newCustomer(Long cnpj, String name, String area ){
        if(cnpj != null && !name.isEmpty() && !area.isEmpty()){
            Customer customer = new Customer(cnpj, name, area);
            customers.add(customer);
            return Optional.of(customer);
        }
        throw new DataAnalysisException("Check customer details.");
    }
    public Optional<Seller> newSeller(Long cpf, String name, Double salary){
        if(cpf != null && !name.isEmpty() && salary != null){
            Seller seller = new Seller(cpf, name, salary);
            sellers.add(seller);
            return Optional.of(seller);
        }
        throw new DataAnalysisException("Check seller details.");
    }
    public Optional<Sales> newSales(Long id, List<Item> items, String salesName, Double total){
        if(id != null && !items.isEmpty() && !salesName.isEmpty() && total != null){
            Sales sale = new Sales(id, items, salesName, total);
            sales.add(sale);
            return Optional.of(sale);
        }
        throw new DataAnalysisException("Check the sales data");
    }
    public Double getTotalValueItems(List<Item> itemList){
        double total = 0;
        for(Item item : itemList){
            total += item.getTotal();
        }
        return total;
    }
    public String output(){
        Stream<Sales> sorted = sales.stream().sorted(Comparator.comparing(Sales::getTotal).reversed());
        List<Sales> orderedSales = sorted.collect(Collectors.toList());
        Long customerCount = Long.parseLong(String.valueOf((long) customers.size()));
        Long sellerCount = Long.parseLong(String.valueOf((long) sellers.size()));
        Long expansiveSale = orderedSales.stream().map(Sales::getId).max(Comparator.naturalOrder()).get();
        String worstSeller = orderedSales.stream().map(Sales::getSellerName).max(Comparator.naturalOrder()).get();
        Output output = new Output(customerCount, sellerCount, expansiveSale, worstSeller);
        return output.toString();
    }
    public void cleanStates(){
        customers.clear();
        sellers.clear();
        sales.clear();
    }
}
