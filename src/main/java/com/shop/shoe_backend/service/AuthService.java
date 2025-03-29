package com.shop.shoe_backend.service;

public interface AuthService {

    /**
     * Retrieves the email from the current authenticated user's JWT.
     * @return the email or null if not found
     */
    String getCurrentUserEmail();
}
