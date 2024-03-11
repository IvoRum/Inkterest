package com.ink.service;

import com.ink.auth.UserLogIn;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.UUID;

public class UserAuthenticationService {
    @Channel("log-in")
    Emitter<UserLogIn> quoteRequestEmitter;
    @Channel("user")
    Multi<UserLogIn> user;

    void sendAuthRequest(UserLogIn userLogIn){
        quoteRequestEmitter.send(userLogIn);
    }
}
