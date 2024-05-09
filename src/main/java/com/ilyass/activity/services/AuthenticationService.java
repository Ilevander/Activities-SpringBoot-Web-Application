package com.ilyass.activity.services;

import com.ilyass.activity.models.User;

public interface AuthenticationService {

    /**
     * Authenticate a user based on username and password.
     * 
     * @param username The username of the user
     * @param password The password of the user
     * @return The authenticated user object if successful, null otherwise
     */
    User login(String username, String password);

    /**
     * Perform logout actions for the user.
     * 
     * @param user The user to logout
     */
    void logout(User user);

    /**
     * Hashes the provided password for storage in the database.
     * 
     * @param password The password to hash
     * @return The hashed password
     */
    /*
    scrum modif
    */
    String hashPassword(String password);
}
