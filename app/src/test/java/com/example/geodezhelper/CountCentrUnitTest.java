package com.example.geodezhelper;

import com.example.geodezhelper.interfaces.forbeans.MySimplePoint;
import com.example.geodezhelper.round.CountInRound;
import com.example.geodezhelper.round.RoundPoint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CountCentrUnitTest  {
    @Test
    public void addition_isCorrect() {

        CountInRound count  = new CountInRound();

        List<Double> xCoords = new ArrayList<>();
        List<Double> yCoords = new ArrayList<>();

        Random r = new Random();

        for (int i = 1  ; i <400; i ++) {

            xCoords.add(r.nextDouble()*1000);
            yCoords.add(r.nextDouble()*1000);
        }
        List<MySimplePoint> points = new ArrayList<>();
        for (int i = 0; i < xCoords.size(); i++){
            MySimplePoint p = new RoundPoint();
            p.setX(xCoords.get(i));
            p.setY(yCoords.get(i));
            points.add(p);
        }

        System.out.println(count.getResult(points));

    }

}