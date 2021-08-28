/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

/**
 *
 * @author suthar
 */
public class User {
    private static String UserID="D:/Shopy/Shopy";
    private static String logo_url="src/Icons/logo.png";
    private static String BaseAdd;
    private static String YearID;


    public static String getLogo_url() {
        return logo_url;
    }

    public static void setLogo_url(String logo_url) {
        User.logo_url = logo_url;
    }

    public static String getYearID() {
        return YearID;
    }

    public static void setYearID(String YearID) {
        User.YearID = YearID;
    }

    

    public static String getUserID() {
        return UserID;
    }

    public static void setUserID(String UserID) {
        User.UserID = UserID;
    }

    public static String getBaseAdd() {
        return BaseAdd;
    }

    public static void setBaseAdd(String BaseAdd) {
        User.BaseAdd = BaseAdd;
    }
    
    
    
}
