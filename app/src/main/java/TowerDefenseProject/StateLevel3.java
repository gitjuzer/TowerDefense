package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public class StateLevel3 extends TurretState {
    @Override
    public int GetDamage(String turretType) {
        if(turretType.equals("Simple")) return 12;
        else if(turretType.equals("Shotgun")) return 7;
        else return 25;
    }

    @Override
    public int GetRange(String turretType) {
        if(turretType.equals("Simple")) return 700;
        else if(turretType.equals("Shotgun")) return 500;
        else return 600;
    }

    @Override
    public void DrawTurret(Canvas canvas, Rect base, Rect middle, Rect outline, boolean hasoutline, String turretType) {
        Paint paint = new Paint();
        if(hasoutline){
            paint.setColor(Color.LTGRAY);
            canvas.drawRect(outline, paint);
        }
        if(turretType.equals("Simple")){
            paint.setARGB(255,0, 140, 28);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        } else if(turretType.equals("Shotgun")){
            paint.setARGB(255,0, 188, 174);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        }else{
            paint.setARGB(255,209, 98, 12);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        }
    }
}
