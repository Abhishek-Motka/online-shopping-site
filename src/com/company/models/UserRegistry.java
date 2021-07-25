package com.company.models;

import com.company.exceptions.InvalidUserException;
import com.company.exceptions.InvalidUserIdException;
import com.company.exceptions.UserAlreadyRegisteredException;
import com.company.exceptions.UserNotExistException;

import java.util.*;

public class UserRegistry
{
    private static UserRegistry userRegistry;

    private Map<UUID, User> users;
    private Map<String, User> emailAddressMap;

    private UserRegistry() {
        users = new HashMap<>();
        emailAddressMap = new HashMap<>();
    }

    public static UserRegistry getInstance() {
        if (Objects.nonNull(userRegistry)) return userRegistry;
        synchronized (UserRegistry.class) {
            if (Objects.isNull(userRegistry))
                userRegistry = new UserRegistry();
        }
        return userRegistry;
    }

    public void addUser(User user) {
        if (!user.isMember()) throw new InvalidUserException(user, "Can't add guest user");
        if (users.containsKey(user.getUserId())) throw new UserAlreadyRegisteredException(user);
        users.put(user.getUserId(), user);
        emailAddressMap.put(user.getContactInfo().getEmailAddress(), user);
    }

    public User removeUser(String userId) {
        try {
            return removeUser(UUID.fromString(userId));
        } catch (IllegalArgumentException ex) {
            throw new InvalidUserIdException(userId);
        }
    }

    public User removeUser(UUID userId) {
        Optional<User> userOptional = getUser(userId);
        if (!userOptional.isPresent()) throw new UserNotExistException(userId);
        emailAddressMap.remove(userOptional.get().getContactInfo().getEmailAddress());
        return users.remove(userId);
    }

    public Optional<User> getUser(String userId) {
        try {
            UUID uuid = UUID.fromString(userId);
            return getUser(uuid);
        } catch (IllegalArgumentException ex) {
            throw new InvalidUserIdException(userId);
        }
    }

    public Optional<User> getUser(UUID userId) {
        return Optional.ofNullable(users.get(userId));
    }

    public Optional<User> getUserByEmail(String emailAddress) {
        return Optional.ofNullable(emailAddressMap.get(emailAddress));
    }
}
