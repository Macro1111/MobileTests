package com.globant.webdriver.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for managing test user credentials.
 * <p>
 * Provides a list of predefined users and a method to retrieve a random user for testing purposes.
 */
public class CredentialsFactory {

    /**
     * Represents a user with an email and password.
     * <p>
     * This record is used to encapsulate user credentials for testing purposes.
     *
     * @param email    the user's email address
     * @param password the user's password
     */
    public record User(String email, String password){ }

    /**
     * Initializes a list of predefined users with their email and password.
     * <p>
     * This method is used to create a static list of users that can be used in tests.
     *
     * @return a list of predefined {@link User} objects
     */
    private static List<User> userInit(){
        return Arrays.asList(
                new User("rickg.deckard@bladerunner.com","VoightKampff_2019!"),
                new User("case.n@neuromancer.net", "ICEbreaker_AI.2021"),
                new User("thomas.anderson@zion.org", "WakeUp_Neo1999!"),
                new User("hiro.katana@snowcrash.io", "SwordRider_20XX!"),
                new User("molly.millions@freelance.zone", "MirrorShades_808!")
        );
    }

    /**
     * Returns a random user from the predefined list of users.
     * <p>
     * This method shuffles the list of users and returns one at random, which can be useful for testing scenarios
     * that require different user credentials.
     *
     * @return a randomly selected {@link User} object
     */
    public static User randomUser() {
        List<User> usersList = userInit();
        Collections.shuffle(usersList);
        return usersList.getFirst();
    }
}
