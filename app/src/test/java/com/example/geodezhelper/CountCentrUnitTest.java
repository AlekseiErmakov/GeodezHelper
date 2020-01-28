package com.example.geodezhelper;

import com.example.geodezhelper.Pojo.Point;
import com.example.geodezhelper.interfaces.forbeans.MySimplePoint;
import com.example.geodezhelper.round.CountInRound;
import com.example.geodezhelper.round.RoundCenter;
import com.example.geodezhelper.round.RoundPoint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CountCentrUnitTest {
    @Test
    public void addition_isCorrect() {

        CountInRound count  = new CountInRound();

        List<Double> xCoords = new ArrayList<>();
        List<Double> yCoords = new ArrayList<>();
        xCoords.add(3599.550);
        yCoords.add(5147.032);

        xCoords.add(3489.417);
        yCoords.add(4941.615);

        xCoords.add(3599.550);
        yCoords.add(5147.032);

        xCoords.add(3440.957);
        yCoords.add(4610.274);

        xCoords.add(3486.113);
        yCoords.add(4386.250);

        xCoords.add(3619.164);
        yCoords.add(4146.018);

        xCoords.add(3743.679);
        yCoords.add(4020.413);

        xCoords.add(3919.158);
        yCoords.add(3911.310);

        MySimplePoint cen = new RoundCenter();
        cen.setX(4262.573);
        cen.setY(4659.324);

//Координата X: 4262.572888259726
//Координата Y: 4659.324161901672
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