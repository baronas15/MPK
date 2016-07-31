package lt.mpk.mpk;


    import android.content.Context;
    import android.graphics.Canvas;
    import android.graphics.Rect;
    import android.util.AttributeSet;
    import android.widget.TextView;

    /**
     * Text view that auto adjusts text size to fit within the view.
     * If the text size equals the minimum text size and still does not
     * fit, append with an ellipsis.
     *
     * @author Chase Colburn
     * @since Apr 4, 2011
     */
    public class FontFitTextView extends TextView {

        static final String TAG = "TextFitTextView";
        boolean fit = false;

        public FontFitTextView(Context context) {
            super(context);
        }

        public FontFitTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public FontFitTextView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        public void setFitTextToBox( Boolean fit ) {
            this.fit = fit;
        }

        protected void onDraw (Canvas canvas) {
            super.onDraw(canvas);
            if (fit) _shrinkToFit();
        }

        protected void _shrinkToFit() {

            int height = this.getHeight();
            int lines = this.getLineCount();
            Rect r = new Rect();
            int y1 = this.getLineBounds(0, r);
            int y2 = this.getLineBounds(lines-1, r);

            float size = this.getTextSize();
            if (y2 > height && size >= 8.0f) {
                this.setTextSize(size - 2.0f);
                _shrinkToFit();
            }

        }

    }