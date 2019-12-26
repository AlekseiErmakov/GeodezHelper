package com.example.geodezhelper;

import com.example.geodezhelper.BL.Baseline;
import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.Pojo.Point;

public class MyMath {

        private static Double x1, y1, h1, pk1, x2, y2, h2, pk2, x, y, h;
        private static Double pOneEl;
        private static Double pOneRep;
        private static Double pTwoEl;
        private static Double pTwoRep;
        private static final int kv=2;

        public static void coords(Baseline LN, Point P){
            x1=LN.getpOne().getX();
            y1=LN.getpOne().getY();
            h1=LN.getpOne().getH();

            x2=LN.getpTwo().getX();
            y2=LN.getpTwo().getY();
            h2=LN.getpTwo().getH();

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

        public static Double blRad(Baseline LN,Point P) {
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

        public static Double blDev(Baseline LN,Point P) {
            if (LN!=null && P!=null){
                coords(LN,P);
            }
            Double result = null;
            if (x1!=null && y1!=null && x2!=null && y2!=null) {
               result = ((y2 - y1) * x - (x2 - x1) * y + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, kv) + Math.pow(x2 - x1, kv));
            }
            return result;
        }

        public static Double blGorizontalLength(Baseline LN,Point P) {
            if (LN!=null && P!=null){
                coords(LN,P);
            }
            Double result = null;
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                result = Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv) - Math.pow(blDev(LN, P), kv));
            }
            return result;
        }

        public static Double blAbsolutLength(Baseline LN,Point P){
            if (LN!=null && P!=null){
                coords(LN,P);
            }
            Double result = null;
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                result =  Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv) + Math.pow(h - h1, kv) - Math.pow(blRad(LN, P), kv));
            }
            return result;
        }

        public static Double blDeltaH(Baseline LN,Point P){
            if (LN!=null && P!=null){
                coords(LN,P);
            }
            Double result = null;
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                result = h - (h1 + (h2 - h1) * Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv) - Math.pow(blDev(LN, P), kv)) / Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv)));
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
            System.out.println(result);
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


}
