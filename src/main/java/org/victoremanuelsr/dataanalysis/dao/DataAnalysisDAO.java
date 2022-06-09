package org.victoremanuelsr.dataanalysis.dao;

import org.victoremanuelsr.dataanalysis.models.Item;
import org.victoremanuelsr.dataanalysis.services.DataAnalysisService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataAnalysisDAO {
    private static final DataAnalysisService service = new DataAnalysisService();
    public static String PATH;
    public static void input(){
        try(BufferedReader br = new BufferedReader(new FileReader(PATH))){
            String line = br.readLine();
            System.out.println("Processing.");
            while (line != null){
                String[] split = line.split("ç");
                int id = Integer.parseInt(split[0]);
                switch (id){
                    case 001:
                        service.newSeller(Long.parseLong(split[1]), split[2], Double.parseDouble(split[3]));
                        line = br.readLine();
                        break;
                    case 002:
                        service.newCustomer(Long.parseLong(split[1]), split[2], split[3]);
                        line = br.readLine();
                        break;
                    case 003:
                        String items = split[2].replace("[", "").replace("]", "");
                        String[] item = items.split(",");
                        List<Item> itemList = new ArrayList<>();
                        for(int i = 0; i < Arrays.stream(item).count(); i++){
                            String[] itemAttributes = item[i].split("-");
                            itemList.add(new Item(Long.parseLong(itemAttributes[0]), Long.parseLong(itemAttributes[1]),
                                    Double.parseDouble(itemAttributes[2])));
                        }
                        Double total = service.getTotalValueItems(itemList);
                        service.newSales(Long.parseLong(split[1]), itemList, split[3], total);
                        line = br.readLine();
                        break;
                }
            }
            output();
            service.cleanStates();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void output(){
        String[] path = PATH.split("\\.");
        String way = path[0].replace("in", "out") + ".done.dat";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(way))){
            bw.write(service.output());
            bw.newLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Finished.");
    }
}
