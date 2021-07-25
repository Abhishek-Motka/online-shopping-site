package com.company.models;

import com.company.exceptions.UserAlreadyLoggedInException;
import com.company.exceptions.UserNotExistException;

import java.util.Objects;
import java.util.Optional;

public class SessionManager
{
    private static SessionManager sessionManager;

    private User loggedInUser;

    private SessionManager()
    {
        this.loggedInUser = null;
    }

    public static SessionManager getInstance() {
        if (Objects.nonNull(sessionManager)) return sessionManager;
        synchronized (SessionManager.class) {
            if (Objects.isNull(sessionManager))
                sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void login() {
        Guest guest = new Guest("Guest User");
        login(Optional.of(guest), "Guest User");
    }

    public void login(String userId) {
        Optional<User> userOptional = UserRegistry.getInstance().getUser(userId);
        login(userOptional, userId);
    }

    public void loginWithEmail(String emailAddress) {
        Optional<User> userOptional = UserRegistry.getInstance().getUserByEmail(emailAddress);
        login(userOptional, emailAddress);
    }

    private void login(Optional<User> userOptional, String identifier) {
        if (Objects.nonNull(loggedInUser)) throw new UserAlreadyLoggedInException(loggedInUser);
        if (!userOptional.isPresent()) throw new UserNotExistException(identifier);
        loggedInUser = userOptional.get();
        System.out.println("Loggd in as user: " + loggedInUser.getName());
    }

    public Optional<User> getLoggedInUser() {
        return Optional.ofNullable(loggedInUser);
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Logged Out!");
    }
}
