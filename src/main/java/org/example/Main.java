package org.example;

public class Main {
    public static void main(String[] args) {
        PasswordVerifier passwordVerifier = new PasswordVerifier();

        try {
            passwordVerifier.varifiedParssword("12345678");// проверяем
            System.out.println("password is suitable");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}