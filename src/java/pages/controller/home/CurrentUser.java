package pages.controller.home;

public class CurrentUser {
    
    private static long userId;
    private static String logoutValue;
    
    public static long getUserId() {
        return userId;
    }

    public static void setUserId(long saveId) {
        userId = saveId;
    }
    public static String getLogoutValue() {
        return logoutValue;
    }

    public static void setLogoutValue(String saveLogoutValue) {
        logoutValue = saveLogoutValue;
    }

}
