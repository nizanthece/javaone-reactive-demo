package org.javaone.reactivedemo;


import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class demoTest {
public static void main(String[] args){

    List<String> symbols = Arrays.asList("GOOG","AMZN","COF","TSLA");
   // List<String> symbols = Arrays.asList("COF");
   Observable<StockInfo> feed = StockServer.getFeed(symbols);
   System.out.println("got observable ...");

       feed.subscribe(
               stockInfo -> System.out.println(stockInfo)
       );




}

}
