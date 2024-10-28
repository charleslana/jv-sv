package com.example.jv_sv;

import java.util.Random;

public class RunTest {
    public static void main(String[] args) {
        Long randomNumber = 1000000000L + new Random().nextLong(9000000000L);
        System.out.println("Número aleatório: " + randomNumber);
    }
}
