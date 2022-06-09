package org.victoremanuelsr.dataanalysis.test.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.victoremanuelsr.dataanalysis.exceptions.DataAnalysisException;
import org.victoremanuelsr.dataanalysis.models.Customer;
import org.victoremanuelsr.dataanalysis.models.Item;
import org.victoremanuelsr.dataanalysis.models.Sales;
import org.victoremanuelsr.dataanalysis.models.Seller;
import org.victoremanuelsr.dataanalysis.services.DataAnalysisService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataAnalysisServiceTest {
    private DataAnalysisService service = new DataAnalysisService();

    @Test
    public void newCustomerTest(){
        Optional<Customer> customer = service.newCustomer(1L, "Victor", "Rural");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("Victor", customer.get().getName());
        Assertions.assertEquals(1L, customer.get().getCnpj());
        Assertions.assertEquals("Rural", customer.get().getBusinessArea());
    }
    @Test
    public void newCustomerErrorTest(){
        DataAnalysisException exception = Assertions.assertThrows(DataAnalysisException.class, () -> {
            service.newCustomer(null, "", "");
        });
        Assertions.assertEquals("Check customer details.", exception.getMessage());
    }
    @Test
    public void newSellerTest(){
        Optional<Seller> seller = service.newSeller(2L, "Maria", 3000D);
        Assertions.assertNotNull(seller);
        Assertions.assertEquals("Maria",seller.get().getName());
        Assertions.assertEquals(2L, seller.get().getCpf());
        Assertions.assertEquals(3000D, seller.get().getSalary());
    }
    @Test
    public void newSellerErrorTest(){
        DataAnalysisException exception = Assertions.assertThrows(DataAnalysisException.class, () -> {
            service.newSeller(null, "", null);
        });
        Assertions.assertEquals("Check seller details.", exception.getMessage());
    }
    @Test
    public void newSalesTest(){
        Item item = new Item(1L, 1L, 1D);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Double total = service.getTotalValueItems(items);
        Optional<Sales> sales = service.newSales(1L, items, "Lucas", total);
        Assertions.assertNotNull(sales);
    }
    @Test
    public void newSalesErrorTest(){
        DataAnalysisException exception = Assertions.assertThrows(DataAnalysisException.class, () -> {
            service.newSales(null, null, "", null);
        });
        Assertions.assertEquals("Check the sales data", exception.getMessage());
    }
}
