package org.javaone.stockStream;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class GoogleFinance {
    public static double getPrice(final String ticker) {
        try {
            double price=0;
            final URL url =
                    new URL("https://finance.google.com/finance?q=NASDAQ:"+ticker);
            final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(url.openStream()));
            //final String data = reader.lines().limit(1).findFirst().get();
            String line;
            Integer lineNo=0;
            while ((line = reader.readLine()) != null && lineNo != 5) {
                if(line.contains("id-price-panel goog-inline-block")) {
                    lineNo = 1;
                }
                if(lineNo != 0) {
                    lineNo=lineNo+1;
                }
                if(lineNo == 5) {
                    price = Double.parseDouble(line.split(">")[1].split("<")[0].replaceAll(",",""));

                }
            }
            //final String[] dataItems = data.split(",");
            return price;
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}