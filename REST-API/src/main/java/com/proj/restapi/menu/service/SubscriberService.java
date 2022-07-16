package com.proj.restapi.menu.service;
import general.Subscriber;
import general.User;

public class SubscriberService {
    public static Subscriber getSubscriberById(int id){
        //TODO - get from DB
        Subscriber subscriber = new Subscriber(id, "Shlomi", "Baruch", "052-2517171", "Shlomi@gmail.com",
                 27, 1.70f, 89f, 3, 27f, 76f, 56f);
        return subscriber;
    }
}
