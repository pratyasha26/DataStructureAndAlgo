package com.company.StringRelated;

import com.sun.deploy.util.StringUtils;

public class BlackHawkQuestion {

    public static void main (String args[]){
        String str ="1x - 2 = 2";
        String[] strings = StringUtils.splitString(str, "=");
        String lhs=strings[0];
        double res;
        double n = 0.0;
        int index=0;
        String[] lhsString = null;
        double num=0.0;
        String operator=null;
        boolean lflag=false;
        String rhs=strings[1];
        String[] op = lhs.split(" ");
        //check if lhs has x;
        for(int i=0;i<op.length;i++){
            if(op[i].contains("+") ||op[i].contains("-")||op[i].contains("/")||op[i].contains("*")) {
                 lhsString   = StringUtils.splitString(lhs, op[i]);
                 operator=op[i];// 1  : 2x
                if(operator.equals("-")){
                    num=-1;
                }
                else{
                    num=1;
                }
            }
            if(op[i].contains("x")){
                lflag=true;
            }
        }
        if(lflag){  //if  x is in left side
            for(int i=0;i<lhsString.length;i++) {
                if(lhsString[i].contains("x")){
                    //call switch (1,+)
                    if(lhsString.length>1) {
                        n = Double.parseDouble(lhsString[i].trim().substring(0, 1));
                    }
                    else{
                        n=1;
                    }
                }
                else{
                    index=i;
                }
            }
            if(index==0) {
               res=  getResult(Double.parseDouble(lhsString[index]),Double.parseDouble(rhs),"-");
                res=res/getResult(n ,num, "*");
            }
            else {
                 res=  getResult(Double.parseDouble(lhsString[index]),Double.parseDouble(rhs),"+");

                res=res/getResult(n ,1.0, "*");
            }

        }
        else{
            //if x is in rh
            res=getResult(Double.parseDouble(lhsString[0]),Double.parseDouble(lhsString[1]),operator);
            if(rhs.trim().length()>1){
                n=Double.parseDouble(rhs.trim().substring(0,1));
            }
           else{
               n=1;
            }
            res = res / n;
        }
        System.out.println(res);
    }


    public static  double getResult(double s, double rhs, String operator){
        double res=0;
        switch ( operator) {
            case "+":
                res =  rhs +s;
                break;
            case "-":
                res =  rhs-s;
                break;
            case "/":
                res =  rhs/s;
                break;
            case "*":
                res =  rhs * s;
                break;
        }
      return  res;
    }


}
