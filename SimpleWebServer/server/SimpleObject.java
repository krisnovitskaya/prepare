package ru.krisnovitskaya.SimpleWebServer.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleObject {

    private String title;
    private int count;
    private Date timestamp;

    public SimpleObject(String title, int count) {
        this.title = title;
        this.count = count;
        this.timestamp = new Date(System.currentTimeMillis());
    }
}
