package com.concepts.rp2;

import reactor.core.publisher.Mono;

public class L02MonoSubscribe {

    public static void main(String[] args) {
        var mono=Mono.just(1)
                .map(i->i+1); // u can map it for publisher
        mono.subscribe(i-> System.out.println(i));
        // how it work without request by taking consumer object

        mono.subscribe(i-> System.out.println(i),
                err-> System.out.println(err),
                ()-> System.out.println("Completed") // - As onComplete not available u can use runnable
        );

    }
}
