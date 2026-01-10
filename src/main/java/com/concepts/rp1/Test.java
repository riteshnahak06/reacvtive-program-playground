package com.concepts.rp1;

public class Test {
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    // this only subscribe so nothing happen
    public static void demo1(){
        var publisher=new PublisherImpl();
        var subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
    }
    public static void demo2(){
        var publisher=new PublisherImpl();
        var subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(4);
    }
}
