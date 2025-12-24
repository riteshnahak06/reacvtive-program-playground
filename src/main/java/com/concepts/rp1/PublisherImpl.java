package com.concepts.rp1;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/*
* Publisher to give the random mail requested by subscriber
* */
public class PublisherImpl implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        var subscriber1=new SubscriberImpl();
        subscriber.onSubscribe(subscriber1.getSubscription());
    }
}
