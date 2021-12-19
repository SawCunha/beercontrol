package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.entity.Permissions;
import com.dio.sawcunha.beercontrol.repository.UserRepository;
import com.dio.sawcunha.beercontrol.specification.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserImplementationService implements UserService {

    private UserRepository userRepository;

    @Override
    public Set<String> permissions(String login) {
        Set<Permissions> permissions = userRepository.findPermissionsByLogin(login);
        return permissions.stream().map(Permissions::toString).collect(Collectors.toSet());
    }
}
