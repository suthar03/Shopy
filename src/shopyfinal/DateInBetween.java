/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopyfinal;

public class DateInBetween {
   // public static void main(String[] arg) {
    public static boolean mainn(String LowerLimit , String Tocheckbetween,String UpperLimit  ){
        boolean res = false;
    String str1 = LowerLimit;
    String str3 = UpperLimit;
    //TextIO.putln(str1+"  to  "+ str3);
    
    String str2 = Tocheckbetween;
    //System.out.println("Dates Getted : "+LowerLimit+" "+Tocheckbetween+" "+UpperLimit);
    
    
    String day1 =String.valueOf(str1.charAt(0))+String.valueOf(str1.charAt(1) );
    String month1 =String.valueOf(str1.charAt(3))+String.valueOf(str1.charAt(4) );
    String year1 = String.valueOf(str1.charAt(6))+String.valueOf(str1.charAt(7) )+String.valueOf(str1.charAt(8))+String.valueOf(str1.charAt(9));

    String day2 =String.valueOf(str2.charAt(0))+String.valueOf(str2.charAt(1) );
    String month2 =String.valueOf(str2.charAt(3))+String.valueOf(str2.charAt(4) );
    String year2 = String.valueOf(str2.charAt(6))+String.valueOf(str2.charAt(7) )+String.valueOf(str2.charAt(8))+String.valueOf(str2.charAt(9));

    String day3 =String.valueOf(str3.charAt(0))+String.valueOf(str3.charAt(1) );
    String month3 =String.valueOf(str3.charAt(3))+String.valueOf(str3.charAt(4) );
    String year3 = String.valueOf(str3.charAt(6))+String.valueOf(str3.charAt(7) )+String.valueOf(str3.charAt(8))+String.valueOf(str3.charAt(9));
  
   String d1 = year1+month1+day1;
   String d2 = year2+month2+day2;
   String d3 = year3+month3+day3;
   //System.out.println(d1+"##"+d2+"##"+d3);
   if((Integer.valueOf(d1)<=Integer.valueOf(d2))&&(Integer.valueOf(d2)<=Integer.valueOf(d3)))
       res =true;
   else 
       res= false;
    //TextIO.putln(str2 +"    "+res);
    //str2 =datep15.mainn(str2);
    return res;
    
    }


    
}