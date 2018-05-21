package TowerDefenseProject;

import android.graphics.Point;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by guth2 on 2018. 05. 21..
 */
public class MapGeneratorTemplateTest {
    @Test
    public void contains() throws Exception {
        Point p = new Point(10,10);
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(12,12));
        points.add(new Point(10,10));
        points.add(new Point(10,10));
        points.add(new Point(10,10));
        points.add(new Point(10,10));
        points.add(new Point(10,10));
        points.add(new Point(10,10));
        points.add(new Point(10,10));

        MapGenerator m = new MapGenerator();
        assertEquals(true, points.contains(p));
    }

}