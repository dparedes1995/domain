package com.projElektra.domain.services;

import com.projElektra.domain.models.User;

/**
 * Service interface for User related operations.
 */
public interface UserService {

    /**
     * Create a new user.
     *
     * @param user the user to create
     */
    void createUser(User user);
}