package com.concepts.rp1;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriberImpl implements Subscriber<String> {

    private static final Logger log=LoggerFactory.getLogger(SubscriberImpl.class);
    /*
    Subscription is:
	• The remote control of the stream
    It allows:
        subscription.request(n);   // ask for data
        subscription.cancel();     // stop stream
     */
    private Subscription subscription;


    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        // 	onSubscribe() is where the Subscriber receives control over the data flow.
        this.subscription=subscription;
    }

    // This will be called by published to send data
    @Override
    public void onNext(String s) {
        //onSubscribe() receives the control, and onNext() receives the data.
        log.info("Received email {} ",s);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("Error ",throwable);
    }

    @Override
    public void onComplete() {
        log.info("Completed !!!");
    }
}
