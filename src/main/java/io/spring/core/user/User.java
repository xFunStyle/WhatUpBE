package io.spring.core.user;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.UUID;

public class User {
    private String name;
    private String email;
    private String password;
    private String id;

    public User(String name, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }
}
