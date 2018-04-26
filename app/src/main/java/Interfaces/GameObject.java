package Interfaces;

import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by guth2 on 2018. 04. 22..
 */

public interface GameObject {
    void Draw(Canvas canvas);
    void Update();
    void OnDestroy();
    String GetLabel();
    void Start();
   // boolean BetweenBoundaries(int x, int y);
   // void SetGameObjectPoint(int x, int y);
}
