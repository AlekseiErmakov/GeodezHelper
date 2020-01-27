package com.example.geodezhelper.round;

import androidx.annotation.NonNull;

public class RoundCenter extends RoundPoint{
    @NonNull
    @Override
    public String toString() {
        return getName() + "\n" +
                getX() + "\n" + getY();
    }
}
