/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopyfinal;

public class datem15 {
    //public static void main(String[] arg) throws FileNotFoundException, IOException{
    public static String mainn(String str){
    //str = "01/01/2019";
    String str2 = "01/07/2019";
    String day =String.valueOf(str.charAt(0))+String.valueOf(str.charAt(1) );
    //TextIO.putln(day);
    String month =String.valueOf(str.charAt(3))+String.valueOf(str.charAt(4) );
    //TextIO.putln(month);
    String year = String.valueOf(str.charAt(6))+String.valueOf(str.charAt(7) )+String.valueOf(str.charAt(8))+String.valueOf(str.charAt(9));
    //TextIO.putln(year);
    //Day updation
    //if(day.equals("16"))
        day="01";
    //else day ="16";
    //month updation
    
        if(month.equals("01")){
            month ="12";
            year =  Integer.toString(Integer.valueOf(year)- 1);
            }
    else{
        month= Integer.toString(Integer.valueOf(month)-1);
        if(Integer.valueOf(month)<10)   month = "0"+month;
    }
   
    

    str2 = day+"/"+month+"/"+year;
    //TextIO.putln(str2);
    return str2;


    }
}