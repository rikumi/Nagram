package xyz.nextalone.nagram;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.ColorUtils;
import org.telegram.messenger.AndroidUtilities;

/** Process snapshot: changing structural options takes effect after restarting the app. */
public final class ClassicUi {
    private ClassicUi() {}
    public static final boolean ClassicHeader = NaConfig.INSTANCE.getClassicHeader().Bool();
    public static final boolean ClassicTopPanels = NaConfig.INSTANCE.getClassicTopPanels().Bool();
    public static final boolean ClassicInput = NaConfig.INSTANCE.getClassicInput().Bool();
    public static final boolean ClassicTabs = NaConfig.INSTANCE.getClassicTabs().Bool();
    public static final boolean ClassicTabColors = NaConfig.INSTANCE.getClassicTabColors().Bool();
    public static final boolean ClassicSettingsIcons = NaConfig.INSTANCE.getClassicSettingsIcons().Bool();

    public static int dividerColor(int background) {
        float[] hsl = new float[3];
        ColorUtils.colorToHSL(background, hsl);
        hsl[2] = hsl[2] < 0.5f ? Math.min(1f, hsl[2] + 0.12f) : Math.max(0f, hsl[2] - 0.12f);
        return ColorUtils.HSLToColor(hsl);
    }

    public static void clearHorizontalInsets(View view) {
        if (view.getPaddingLeft() != 0 || view.getPaddingRight() != 0) {
            view.setPadding(0, view.getPaddingTop(), 0, view.getPaddingBottom());
        }
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (lp.leftMargin != 0 || lp.rightMargin != 0) {
                lp.leftMargin = lp.rightMargin = 0;
                view.setLayoutParams(lp);
            }
        }
    }

    public static void drawPanel(Canvas canvas, Paint paint, int color, float top, float right, float bottom, boolean divider) {
        paint.setColor(color);
        canvas.drawRect(0, top, right, bottom, paint);
        if (divider) {
            paint.setColor(dividerColor(color));
            canvas.drawRect(0, top, right, top + AndroidUtilities.dp(1), paint);
        }
    }
}
