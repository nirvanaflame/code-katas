package com.demo;


import java.util.ArrayList;
import java.util.Collections;

public class Main {

    enum Signal {
        WINK, BLINK
    }

    public static void main(String[] args) {
        int x = 31;
        var s = Integer.toBinaryString(x);
        var c = s.charAt(1);
        var signals = new ArrayList<Signal>();
        signals.add(Signal.BLINK);
        signals.add(Signal.WINK);

        Collections.reverse(signals);

        System.out.println(c);
        System.out.println(s);
    }
}