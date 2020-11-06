package drawable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final static int LINE = 1, RECT=2;
    static int curShape = LINE, curColor = Color.RED;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "사각형 그리기");
        menu.add(0, 3, 0, "빨강");
        menu.add(0, 4, 0, "파랑");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = RECT;
                return true;
            case 3:
                curColor = Color.RED;
                return true;
            case 4:
                curColor = Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView(MainActivity context) {
            super(context);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();
                    break;
            }
            return true;
        }
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(curColor);

            switch (curShape) {
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case RECT:
                    canvas.drawRect(startX, startY, stopX, stopY, paint);
                    break;
            }
        }
    }
}





public class MainActivity extends AppCompatActivity {
        Button btn;
        ImageView img;
        float angle = 0;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                setTitle("4장 실습문제");

                btn = (Button) findViewById(R.id.btn);
                img = (ImageView) findViewById(R.id.img);

                btn.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                                angle += 10;
                                img.setRotation(angle);

                        }

                });

        }
}