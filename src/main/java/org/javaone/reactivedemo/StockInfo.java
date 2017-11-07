package org.javaone.reactivedemo;
import org.javaone.stockStream.GoogleFinance;

import java.io.IOException;
import java.math.BigDecimal;
public class StockInfo {
    public final String stockName;
    public final double price;



    public StockInfo(final String stock,final double value){
        price = value;
        stockName = stock;
    }

    @Override
    public String toString() {
        return "Latest stream {" +
                "stockName='" + stockName + '\'' +
                ", price=" + price +
                '}';
    }

    public static StockInfo fetch(String stockName) throws IOException {
     return new StockInfo(stockName, GoogleFinance.getPrice(stockName));
     //return new StockInfo(stockName,12);
     }

}
