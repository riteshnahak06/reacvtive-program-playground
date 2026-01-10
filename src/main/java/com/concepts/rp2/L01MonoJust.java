package com.concepts.rp2;

import com.concepts.rp1.SubscriberImpl;
import reactor.core.publisher.Mono;

public class L01MonoJust {
    public static void main(String[] args) {
        var mono= Mono.just("Hello Reactive");// publisher
        System.out.println(mono.toString()); //MonoJust -> it wont give publisher object as it is not subscribed
        var subscriber=new SubscriberImpl();
        mono.subscribe(subscriber); // this wont print as u have only subscribed but not requested
        subscriber.getSubscription().request(10);
        /*Received email Hello Reactive
        Completed !!!*/

        // with Consumer
        mono.subscribe(value -> System.out.println(value));


    }
}
