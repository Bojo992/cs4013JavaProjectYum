package Gui;

import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    IDandPasswords() {
        loginInfo.put("boris", "password");
        loginInfo.put("italo", "password");
        loginInfo.put("craig", "password");
        loginInfo.put("simon", "password");
    }

    protected HashMap getLoginInfo () {
        return loginInfo;
    }
}

