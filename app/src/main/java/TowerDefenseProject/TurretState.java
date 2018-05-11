package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public abstract class TurretState {
    public abstract int GetDamage(String turretType);
    public abstract int GetRange(String turretType);
    public abstract void DrawTurret(Canvas canvas, Rect base, Rect middle, Rect outline, boolean hasoutline, String turretType);
}
