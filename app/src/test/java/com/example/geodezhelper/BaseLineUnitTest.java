package com.example.geodezhelper;

import android.content.Context;

import com.example.geodezhelper.BL.Baseline;
import com.example.geodezhelper.BL.DataBaseLine;
import com.example.geodezhelper.Count.StringResult;
import com.example.geodezhelper.Pojo.Point;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BaseLineUnitTest {
    @Test
    public void addition_isCorrect() {

        Baseline baseline = new Baseline();
        String basename = "Моя базовая линия";
        baseline.setName(basename);
        Point point1 = new Point();
        Point point2 = new Point();
        Point point = new Point();
        double x1 = 3847.237;
        double y1 = 695.405;
        double h1 = 34.226;
        double x2 = 3677.572;
        double y2 = 864.560;
        double h2 = 34.945;
        double x = 3741.435;
        double y = 804.802;
        double h = 31.988;
        String result = "3.865";
        point1.setX(x1);
        point1.setY(y1);
        point1.setH(h1);
        point2.setX(x2);
        point2.setY(y2);
        point2.setH(h2);
        point.setX(x);
        point.setY(y);
        point.setH(h);
        baseline.setpOne(point1);
        baseline.setpTwo(point2);
        double x1T = baseline.getpOne().getX();
        double y1T = baseline.getpOne().getY();
        double h1T = baseline.getpOne().getH();
        double x2T = baseline.getpTwo().getX();
        double y2T = baseline.getpTwo().getY();
        double h2T = baseline.getpTwo().getH();
        assertEquals(String.valueOf(x1),String.valueOf(x1T));
        assertEquals(String.valueOf(y1),String.valueOf(y1T));
        assertEquals(String.valueOf(h1),String.valueOf(h1T));
        assertEquals(String.valueOf(x2),String.valueOf(x2T));
        assertEquals(String.valueOf(y2),String.valueOf(y2T));
        assertEquals(String.valueOf(h2),String.valueOf(h2T));
        StringResult stringResult = new StringResult(baseline,point);
        assertEquals(result,stringResult.getRadius());


    }
}