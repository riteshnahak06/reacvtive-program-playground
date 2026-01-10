package com.concepts.rp1;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {


    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private boolean isCancelled;
    private int count;
    private  int MAX_REQ=10;
    private final Faker faker;

    private Subscriber<? super String> subscriber;
    public SubscriptionImpl(Subscriber<? super String> subscriber){
        this.subscriber=subscriber;
        this.faker=Faker.instance();
    }
    @Override
    public void request(long l) {
        if (isCancelled){
            return;
        }
        log.info("Subscriber requested  {} item",l);
        for (int i = 0; i < l && count<MAX_REQ; i++) {
            count++;
            subscriber.onNext(this.faker.internet().emailAddress());
        }
        if (count==MAX_REQ){
            subscriber.onComplete();
            isCancelled=true;
        }
    }

    @Override
    public void cancel() {
        log.info("Subscriber Cancelled");
        this.isCancelled=true;
    }
}
