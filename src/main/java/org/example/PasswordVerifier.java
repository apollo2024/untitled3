package org.example;

public class PasswordVerifier {

    public void varifiedParssword(String password) throws Exception { // создаем один большой метод varifiedParssword
        if (password.length() < 8) {
            throw new Exception("password has to contain mare then 8 symbols");
        }
        boolean containsDigit = false;

        for (int i = 0; i < password.length(); i++) { // создаем цикл для проверки на цифры
            char ch = password.charAt(i);
            // проверяем являетсяли символ числом если нет то containsDigit останется false и выкинет ошибку в 18 строке
            if (Character.isDigit(ch)) {
                containsDigit = true;
                break;
            }
        }
        if (!containsDigit) {
            throw new Exception("password has to contain at least 1 number");
        }
        boolean containsUpperCase = false;

        for (int i = 0; i < password.length(); i++) { // делаем аналогичное с наличием заглавных букв
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                containsUpperCase = true;
                break;
            }
        }
        if(!containsUpperCase){
            throw new Exception("password must keep at least 1 capital letter");
        }
    }
}