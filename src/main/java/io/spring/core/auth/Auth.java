package io.spring.core.auth;

public class Auth {
    private String userId;
    private String authKey;

    public Auth(String userId, String authKey) {
        this.userId = userId;
        this.authKey = authKey;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuthKey() {
        return authKey;
    }
}
