package io.spring.util;

import io.spring.core.auth.Auth;
import io.spring.core.message.Message;
import io.spring.core.user.User;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseUtil {


    public static Map<String, Object> createUserResponse(User user) {
        return new HashMap<String, Object>() {{
            put("user", user);
        }};
    }

    public static Map<String, Object> createUserAuthResponse(User user, Auth auth) {
        return new HashMap<String, Object>() {{
            put("user", user);
            put("auth", auth);
        }};
    }

    public static Map<String, Object> createIndexResponse() {
        return new HashMap<String, Object>() {{
            put("time", DateTimeFormatter.ISO_TIME);
        }};
    }

    public static Map<String, String> createGetUsersResponse(List<User> list) {
        return new HashMap<String, String>() {{
            for (User u : list) {
                put(u.getId(), u.getName());
            }
        }};
    }

    public static Map<String, Message> createMessageSendResponse(Message message){
        return new HashMap<String, Message>(){{
            put("msg", message);
        }};
    }

    public static Map<String, String> createMessageUnauthorizedResponse(){
        return new HashMap<String, String>(){{
            put("error", "Authentication required");
        }};
    }

    public static Map<String, Object> createMessageFetchResponse(List<Message> list, String blockId){
        return new HashMap<String, Object>(){{
            put("messages", list);
            put("blockId", blockId);
        }};
    }
}
