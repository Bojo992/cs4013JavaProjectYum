package Gui;

import People.Person;
import utils.DataStorage;

import java.util.HashMap;

public class IDandPasswords {
    private Person user;
    private String type;
    private static HashMap<String, Person> loginInfo = DataStorage.getAllUsernamesAndPasswords();

    public IDandPasswords(Person user, String type) {
        this.user = user;
        this.type = type;
    }

    public static void createAcc(String user, Person person) {
        loginInfo.put(user, person);
    }

    public void setType(String type) {
        this.type = type;
    }

    protected HashMap getLoginInfo () {
        return loginInfo;
    }
}

