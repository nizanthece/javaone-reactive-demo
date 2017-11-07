package org.javaone.reactivedemo;




import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.io.IOException;
import java.util.List;

public class StockServer {
    public static Observable<StockInfo> getFeed(List<String> symbols) {
        System.out.println("created...");
        return Observable.create(emitter -> emitPrice(emitter, symbols));

    }

    private static void emitPrice(ObservableEmitter<StockInfo> emitter, List<String> symbols) throws IOException {
        System.out.println("Ready to emit ....");

        while (true) {
            for (String symbol : symbols) {
                emitter.onNext(StockInfo.fetch(symbol));
            }
        }


    }
}
