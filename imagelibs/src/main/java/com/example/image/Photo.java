package com.example.image;

import java.io.Serializable;

public class Photo extends Media implements Serializable {
    public Photo(String path) {
        super(path);
    }
}
