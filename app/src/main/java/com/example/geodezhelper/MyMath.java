package com.example.geodezhelper;

import com.example.geodezhelper.interfaces.forbeans.MyBaseLineData;
import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.Pojo.Point;
import com.example.geodezhelper.interfaces.forbeans.MyBaseLineData;
import com.example.geodezhelper.interfaces.forbeans.MySimplePoint;
import com.example.geodezhelper.round.RoundCenter;
import com.example.geodezhelper.round.RoundPoint;

public class MyMath {

        private static Double x1, y1, h1, pk1, x2, y2, h2, pk2, x, y, h;
        private static Double pOneEl;
        private static Double pOneRep;
        private static Double pTwoEl;
        private static Double pTwoRep;
        private static final int kv=2;

        public static void coords(MyBaseLineData LN, Point P){
            x1=LN.getPone().getX();
            y1=LN.getPone().getY();
            h1=LN.getPone().getH();

            x2=LN.getPtwo().getX();
            y2=LN.getPtwo().getY();
            h2=LN.getPtwo().getH();

            x=P.getX();
            y=P.getY();
            h=P.getH();

        }
        public static void nivPoints(NivPoint pOne, NivPoint pTwo){
             pOneEl = pOne.getHeight();
             pOneRep = pOne.getReport();
             pTwoRep = pTwo.getReport();
             pTwoEl = pTwo.getHeight();
        }

        public static Double blRad(MyBaseLineData LN, Point P) {
            if (LN!=null && P!=null){
                coords(LN,P);
            }

            Double result = null;
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
               result = Math.sqrt(Math.pow(((y1 - y) * (h2 - h1) - (h1 - h) * (y2 - y1)), kv)
                        + Math.pow(((x1 - x) * (h2 - h1) - (h1 - h) * (x2 - x1)), kv)
                        + Math.pow(((x1 - x) * (y2 - y1) - (y1 - y) * (x2 - x1)), kv))
                        / Math.sqrt(Math.pow((x2 - x1), kv) + Math.pow((y2 - y1), kv) + Math.pow((h2 - h1), kv));
            }
            return result;
        }

        public static Double blDev(MyBaseLineData LN,Point P) {
            if (LN!=null && P!=null){
                coords(LN,P);
            }
            Double result = null;
            if (x1!=null && y1!=null && x2!=null && y2!=null) {
               result = ((y2 - y1) * x - (x2 - x1) * y + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, kv) + Math.pow(x2 - x1, kv));
            }
            return result;
        }

        public static Double blGorizontalLength(MyBaseLineData LN,Point P) {
            if (LN!=null && P!=null){
                coords(LN,P);
            }
            Double result = null;
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                result = Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv) - Math.pow(blDev(LN, P), kv));
            }
            return result;
        }

        public static Double blAbsolutLength(MyBaseLineData LN,Point P){
            if (LN!=null && P!=null){
                coords(LN,P);
            }
            Double result = null;
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                result =  Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv) +
                        Math.pow(h - h1, kv) - Math.pow(blRad(LN, P), kv));
            }
            return result;
        }

        public static Double blDeltaH(MyBaseLineData LN,Point P){
            if (LN!=null && P!=null){
                coords(LN,P);
            }
            Double result = null;
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                result = h - (h1 + (h2 - h1) * Math.sqrt(Math.pow(x - x1, kv) +
                        Math.pow(y - y1, kv) - Math.pow(blDev(LN, P), kv)) /
                        Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv)));
            }
            return result;
        }
        public static Double nivElevation(NivPoint pOne,NivPoint pTwo, Double pointRep){
            Double result = null;

            if (pOne!=null && pTwo!=null) {
                nivPoints(pOne, pTwo);
            }
            if (pOneEl!=null && pOneRep!=null && pointRep!=null){
                result = pOneEl + pOneRep/1000 - pointRep/1000;
            }
            System.out.println(result);
            return result;
        }
        public static Double nivElevation(Double pOneEl, Double pOneRep, Double pTwoRep){
            Double result = null;
            if (pOneEl!=null && pOneRep!=null && pTwoRep!=null){
                result = pOneEl+pOneRep/1000-pTwoRep/1000;
                return result;
            }
            return result;
        }
        public static Integer nivRep(NivPoint pOne, NivPoint pTwo){
            Integer result = null;
            if (pOne!=null && pTwo!=null) {
                nivPoints(pOne, pTwo);
            }
            if (pOneEl!=null && pOneRep!=null && pTwoEl!=null){
                result = 1000*(int)(pOneEl + pOneRep/1000 - pTwoEl);
            }
            return result;
        }
        public static Integer nivRep(Double pOneEl, Double pOneRep, Double pTwoEl){
            Integer result = null;
            if (pOneEl!=null && pOneRep!=null && pTwoEl!=null){
                result = 1000*(int)(pOneEl + pOneRep/1000 - pTwoEl);
                return result;
            }
            return result;
        }
        public static MySimplePoint countCenter(MySimplePoint p1, MySimplePoint p2, MySimplePoint p3){
            Double x1 = p1.getX();
            Double y1 = p1.getY();
            Double x2 = p2.getX();
            Double y2 = p2.getY();
            Double x3 = p3.getX();
            Double y3 = p3.getY();
            MySimplePoint rc = null;

            double A = x2 - x1;
            double B = y2 - y1;
            double C = x3 - x1;
            double D = y3 - y1;
            double E = A * (x1 + x2) + B * (y1 + y2);
            double F = C * (x1 + x3) + D * (y1 + y3);
            double G = 2 * (A * (y3 - y2) - B * (x3 - x2));

             if (G == 0){
                 return rc;
             }else {
                 rc = new RoundCenter();
                 rc.setName(p1.getName() + " " + p2.getName() + " " + p3.getName());
                 Double x = (D * E - B * F) / G;
                 Double y = (A * F - C * E) / G;
                 rc.setX(x);
                 rc.setY(y);
             }

               return rc;

        }
        public static double countDim(MySimplePoint pOne, MySimplePoint pTwo){
            Double x1 = pOne.getX();
            Double y1 = pOne.getY();
            Double x2 = pTwo.getX();
            Double y2 = pTwo.getY();

            return Math.sqrt(Math.pow((x2-x1),kv)+Math.pow((y2-y1),kv));
        }



}
