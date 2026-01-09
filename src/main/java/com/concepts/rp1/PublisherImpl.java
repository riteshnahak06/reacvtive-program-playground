package com.concepts.rp1;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/*
* Publisher to give the random mail requested by subscriber
* */
public class PublisherImpl implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        var subscription=new SubscriptionImpl(subscriber); // let subscriber have subscription obj
        // make connection with subscriber through subscription
        subscriber.onSubscribe(subscription);
    }
}
