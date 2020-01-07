package solid.s;

class UserLogin {

    private final DataBase db;

    UserLogin(DataBase db) {
        this.db = db;
    }

    void login(String userName, String password) {
        User user = db.findUserByUserName(userName);
        if (user == null) {
            // do something
        }
        // login process..
    }

//    void sendEmail(User user, String msg) {
//         sendEmail email to user
//    }

}
