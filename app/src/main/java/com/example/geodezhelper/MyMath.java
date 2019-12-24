package com.example.geodezhelper;

import com.example.geodezhelper.BL.Baseline;
import com.example.geodezhelper.Pojo.Point;

public class MyMath {

        private static Double x1, y1, h1, pk1, x2, y2, h2, pk2, x, y, h;
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

        public static Double Rad(Baseline LN,Point P) {
            coords(LN,P);
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                return Math.sqrt(Math.pow(((y1 - y) * (h2 - h1) - (h1 - h) * (y2 - y1)), kv)
                        + Math.pow(((x1 - x) * (h2 - h1) - (h1 - h) * (x2 - x1)), kv)
                        + Math.pow(((x1 - x) * (y2 - y1) - (y1 - y) * (x2 - x1)), kv))
                        / Math.sqrt(Math.pow((x2 - x1), kv) + Math.pow((y2 - y1), kv) + Math.pow((h2 - h1), kv));
            }
            return null;
        }

        public static Double Dev(Baseline LN,Point P) {
            coords(LN,P);
            if (x1!=null && y1!=null && x2!=null && y2!=null) {
                return ((y2 - y1) * x - (x2 - x1) * y + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, kv) + Math.pow(x2 - x1, kv));
            }
            return null;
        }

        public static Double gorizontalLength(Baseline LN,Point P) {
            coords(LN,P);
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                return Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv) - Math.pow(Dev(LN, P), kv));
            }
            return null;
        }

        public static Double absolutLength(Baseline LN,Point P){
            coords(LN,P);
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                return Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv) + Math.pow(h - h1, kv) - Math.pow(Rad(LN, P), kv));
            }
            return null;
        }

        public static Double DeltaH(Baseline LN,Point P){
            coords(LN,P);
            if (x1!=null && y1!=null && h1!=null && x2!=null && y2!=null && h2!=null) {
                return h - (h1 + (h2 - h1) * Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv) - Math.pow(Dev(LN, P), kv)) / Math.sqrt(Math.pow(x - x1, kv) + Math.pow(y - y1, kv)));
            }
            return null;
        }


}
