package utils.excel;

public class GlobalData {
    private static String sessionId;

    public static String getSessionId() {
        return sessionId;
    }

    public static void setSessionId(String sessionId) {
        GlobalData.sessionId = sessionId;
    }
}
