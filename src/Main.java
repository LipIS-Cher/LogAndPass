class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }
}
class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
}
public class Main {
    public static void validate(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20 || !login.matches("^[A-Za-z0-9_]+$")) {
                throw new WrongLoginException("Неверный логин");
            }
            if (password.length() > 20 || !password.matches("^[A-Za-z0-9_]+$")) {
                throw new WrongPasswordException("Неверный пароль");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        String login = "java_skypro_go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";
        validate(login, password, confirmPassword);
    }
}