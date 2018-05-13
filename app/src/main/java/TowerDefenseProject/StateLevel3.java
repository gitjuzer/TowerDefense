package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.guth27.progtech.Info;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public class StateLevel3 extends TurretState {
    @Override
    public int GetDamage(String turretType) {
        if(turretType.equals("Simple")) return 22;
        else if(turretType.equals("Shotgun")) return 8;
        else return 50;
    }

    @Override
    public int GetRange(String turretType) {
        if(turretType.equals("Simple")) return (int)((Info.GetScreenWidth() / MapGenerator.piecesWidth) * 4);
        else if(turretType.equals("Shotgun")) return (int)((Info.GetScreenWidth() / MapGenerator.piecesWidth) * 2.5);
        else return (int)((Info.GetScreenWidth() / MapGenerator.piecesWidth) * 2.7);
    }

    @Override
    public void DrawTurret(Canvas canvas, Rect base, Rect middle, Rect outline, boolean hasoutline, String turretType) {
        Paint paint = new Paint();
        Paint range = new Paint();

        range.setColor(Color.RED);
        range.setStrokeWidth(10);
        range.setStyle(Paint.Style.STROKE);

        if(hasoutline){
            paint.setColor(Color.LTGRAY);
            canvas.drawRect(outline, paint);
            canvas.drawCircle(base.centerX(),base.centerY(),GetRange(turretType),range);

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
