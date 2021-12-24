package com.dio.sawcunha.beercontrol.specification.service;

import java.util.Set;

public interface UserService {

    Set<String> permissions(String login);
    boolean validIdentifier(String identifier);
}
