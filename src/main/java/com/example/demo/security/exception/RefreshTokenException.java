package com.example.demo.security.exception;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class RefreshTokenException extends RuntimeException{
    TOKEN_ERROR tokenError;

    public enum TOKEN_ERROR {
        UNACCEPT(401, "Token is null or too short: refreshToken"),
        MALFORM(403, "Malformed Token: refreshToken"),
        BADSIGN(403, "BadSignatured Token: refreshToken"),
        EXPIRED(403, "Expired Token: refreshToken");
        private final int status;
        private final String msg;
        TOKEN_ERROR(int status, String msg) {
            this.status = status;
            this.msg = msg;
        }
        public int getStatus() {
            return this.status;
        }
        public String getMsg() {
            return this.msg;
        }
    }

    public RefreshTokenException(TOKEN_ERROR error) {
        super(error.name());
        this.tokenError = error;
    }

    public void sendResponseError(HttpServletResponse response) {
        response.setStatus(tokenError.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Gson gson = new Gson();
        String responseStr = gson.toJson(Map.of("msg", tokenError.getMsg(), "time", new Date()));

        try {
            response.getWriter().println(responseStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
