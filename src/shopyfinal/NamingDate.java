/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopyfinal;

public class NamingDate {
   // public static void main(String[] arg) {
    public static String mainn(String Daterr ){
       
    String str1 = Daterr;
    String str2 = "22/01/2019";
    
    
    
    
    String day1 =String.valueOf(str1.charAt(0))+String.valueOf(str1.charAt(1) );
    String month1 =String.valueOf(str1.charAt(3))+String.valueOf(str1.charAt(4) );
    String year1 = String.valueOf(str1.charAt(6))+String.valueOf(str1.charAt(7) )+String.valueOf(str1.charAt(8))+String.valueOf(str1.charAt(9));
    day1=Integer.toString(Integer.valueOf(day1));
    month1=Integer.toString(Integer.valueOf(month1));
    year1=Integer.toString(Integer.valueOf(year1));
        /*String smonth = Integer.toString(month);
        String year1 = Integer.toString(year);
        String sday = Integer.toString(day);*/
if(Integer.valueOf(month1)<10)
    month1 = "0"+month1;
if(Integer.valueOf(day1)<10)
    day1="0"+day1;
String namingday ="01";
//if(Integer.valueOf(day1)>15) namingday="16";

str2 = namingday+"/"+month1+"/"+year1;

//TextIO.putln(str2);

return str2;
    }
    
}