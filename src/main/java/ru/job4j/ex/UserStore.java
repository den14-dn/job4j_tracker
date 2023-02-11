package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                rsl = user;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Denis Shubko", true)
        };
        try {
            User user = findUser(users, "Denis Shubko");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException eui) {
            eui.printStackTrace();
        } catch (UserNotFoundException enf) {
            enf.printStackTrace();
        }
    }
}
