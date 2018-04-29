package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public class StateLevel2 extends TurretState {
    @Override
    public int GetDamage(String turretType) {
        if(turretType.equals("Simple")) return 8;
        else if(turretType.equals("Shotgun")) return 4;
        else return 15;
    }

    @Override
    public int GetRange(String turretType) {
        if(turretType.equals("Simple")) return 600;
        else if(turretType.equals("Shotgun")) return 425;
        else return 500;
    }

    @Override
    public void DrawTurret(Canvas canvas, Rect base, Rect middle, Rect outline, boolean hasoutline, String turretType) {
        Paint paint = new Paint();
        if(hasoutline){
            paint.setColor(Color.LTGRAY);
            canvas.drawRect(outline, paint);
        }
        if(turretType.equals("Simple")){
            paint.setARGB(255,47, 145, 67);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        } else if(turretType.equals("Shotgun")){
            paint.setARGB(255,44, 165, 156);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        }else{
            paint.setARGB(255,178, 113, 62);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        }
    }
}