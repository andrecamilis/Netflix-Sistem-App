package com.example.testenetflix.View;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;


import com.example.testenetflix.R;

public class TelaCheiaGtaSeis extends AppCompatActivity implements View.OnTouchListener, ScaleGestureDetector.OnScaleGestureListener, View.OnClickListener {


RelativeLayout zoomLayout;
boolean isOpen = true;
ScaleGestureDetector scaleDetector;
GestureDetectorCompat gestureDetector;
private static final float MIN_ZOOM = 1.0f;
private static final float MAX_ZOOM = 5.0f;
boolean intLeft, intRight;
private Display display;
private Point size;
private Mode mode = Mode.NONE;



    private enum Mode {
        NONE,
        DRAG,
        ZOOM
    }
    int device_width;
private int sWidth;
private boolean isEnable = true;
private float scale = 1.0f;
private float lastScaleFactor = 0f;

// PT - Onde seu primeiro dedo toca na tela para aplicar o zoom
// EN - Where your finger first touches on sceen and apply the zoom

    private float startX = 0f;
    private float startY = 0f;

// PT - O quanto havera a transição no Canvas
// EN - How much to translate the canvas

    private float dx = 0f;
    private float dy = 0f;
    private float prevDx = 0f;
    private float prevDy = 0f;

    int position = -1;

    VideoView videoView;
    LinearLayout one, two, three, four;
    ImageButton goBack, rewind, forward, playPause;
    TextView title, endTime;
    SeekBar videoSeekBar;


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                hideDefaultControls();
                if (scale > MIN_ZOOM){
                    mode = Mode.DRAG;
                    startX = event.getX() - prevDx;
                    startY = event.getY() - prevDy;

                }
                break;
            case MotionEvent.ACTION_MOVE:
                hideDefaultControls();
                isEnable = false;
                if (mode == Mode.DRAG){
                    dx = event.getX() - startX;
                    dy = event.getY() - startY;
                }
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                mode = Mode.ZOOM;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                mode = Mode.DRAG;
                break;
            case MotionEvent.ACTION_UP:
                mode = Mode.NONE;
                prevDx = dx;
                prevDy = dy;
                break;

        }
        scaleDetector.onTouchEvent(event);
        gestureDetector.onTouchEvent(event);
        if ((mode == Mode.DRAG && scale >= MIN_ZOOM) || mode == Mode.ZOOM){
            zoomLayout.requestDisallowInterceptTouchEvent(true);
            float maxDx = (child().getWidth() - (child().getWidth()/scale)) / 2 * scale;
            float maxDy = (child().getHeight() - (child().getHeight()/scale)) / 2 * scale;
            dx = Math.min(Math.max(dx, -maxDx), maxDx);
            dy = Math.min(Math.max(dy, -maxDy), maxDy);
            applyScaleAndTranslation();
        }
        return true;
    }
    private void applyScaleAndTranslation() {
        child().setScaleX(scale);
        child().setScaleY(scale);
        child().setTranslationX(dx);
        child().setTranslationY(dy);
    }

    private View child() {
        return zoomLayout(0);
    }

    private View zoomLayout(int i) {
        return videoView;
    }

    @Override
    public boolean onScale(@NonNull ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleDetector.getScaleFactor();
        if (lastScaleFactor == 0 || (Math.signum(scaleFactor) == Math.signum(lastScaleFactor))){
            scale *= scaleFactor;
            scale = Math.max(MIN_ZOOM, Math.min(scale,MAX_ZOOM));
            lastScaleFactor = scaleFactor;
        } else {
            lastScaleFactor = 0;
        }

        return true;
    }

    @Override
    public boolean onScaleBegin(@NonNull ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override
    public void onScaleEnd(@NonNull ScaleGestureDetector scaleGestureDetector) {}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tela_cheia_gta6);
        videoView =     findViewById(R.id.videoGta6TC);
        zoomLayout =    findViewById(R.id.zoom_layout);
        one =           findViewById(R.id.videoView_one_layout);
        two =           findViewById(R.id.videoView_two_layout);
        three =         findViewById(R.id.videoView_three_layout);
        four =          findViewById(R.id.videoView_four_layout);
        goBack =        findViewById(R.id.videoView_go_back);
        playPause =     findViewById(R.id.videoView_play_pause_btn);
        forward =       findViewById(R.id.videoView_forward);
        rewind =        findViewById(R.id.videoView_rewind);
        endTime =       findViewById(R.id.videoView_endtime);
        title =         findViewById(R.id.videoView_title);
        videoSeekBar =  findViewById(R.id.videoView_seekbar);

       goBack.setOnClickListener(this);
       rewind.setOnClickListener(this);
       playPause.setOnClickListener(this);
       forward.setOnClickListener(this);

        position = getIntent().getIntExtra("p", -1);
        videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName() + "/"+ R.raw.gta_seis_trailer));
        MediaController mediaController = new MediaController( TelaCheiaGtaSeis.this);
        mediaController.setAnchorView(videoView);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoSeekBar.setMax(videoView.getDuration());
                videoView.start();
            }
        });

        if (videoView!=null){
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                @Override
                public void onPrepared(MediaPlayer mp) {
                    videoSeekBar.setMax(videoView.getDuration());
                    videoView.start();
                }});
            };



        zoomLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen){
                    hideDefaultControls();
                    isOpen = false;
                }else{
                    showDefaultControls();
                    isOpen = true;
                }
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);




        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        sWidth = size.x;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        device_width = displayMetrics.widthPixels;
        zoomLayout.setOnTouchListener(this);
        scaleDetector = new ScaleGestureDetector(getApplicationContext(), this);
        gestureDetector = new GestureDetectorCompat(getApplicationContext(), new GestureDetector());


        initalizeSeekBars();
        setHandler();


    }





    private void initalizeSeekBars(){
        videoSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(videoSeekBar.getId() == R.id.videoView_seekbar){
                if (fromUser){
                    videoView.seekTo(progress);
                    videoView.start();
                    int curresntPosition = videoView.getCurrentPosition();
                    endTime.setText(""+convertIntoTime(videoView.getDuration()-curresntPosition));
                }
            }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private String convertIntoTime(int ms){
        String time;
        int x, seconds, minutes, hours;
        x = ms /1000;
        seconds = x % 60;
        x /= 60;
        minutes = x % 60;
        x /= 60;
        hours = x % 24;
        if (hours !=0)
            time = String.format("%02d",hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
        else time = String.format("%02d", minutes) + ":" + String.format("%02d", seconds);

        return time;
    }

    private void setHandler(){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (videoView.getDuration()>0){
                    int curresntPosition = videoView.getCurrentPosition();
                    videoSeekBar.setProgress(curresntPosition);
                    endTime.setText(""+convertIntoTime(videoView.getDuration()-curresntPosition));
                }
            handler.postDelayed(this,0);
            }

        };
handler.postDelayed(runnable, 500);
    }

    @Override
    public void onClick(View view) {
        int itemId = view.getId();
        if (itemId == R.id.videoView_go_back){
            onBackPressed();
        }
        else if(itemId == R.id.videoView_forward){
            //1000 = 1sec
            videoView.seekTo(videoView.getCurrentPosition() +10000);
        }
        else if(itemId == R.id.videoView_play_pause_btn){
            if (videoView.isPlaying()){
                videoView.pause();
                playPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_play));

            }else {
                videoView.start();
                playPause.setImageDrawable(getResources().getDrawable(R.drawable.netflix_pause_button));
            }
        }


    }


    private class GestureDetector extends android.view.GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            if (isEnable){
                hideDefaultControls();
                isEnable = false;
            }else {
                showDefaultControls();
                isEnable = true;
            }
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent event) {
            // PT - Nesse momento estamos colocando um evento, determinado que quando clicar 2x na tela o vídeo volta 10 segundos.
            // EN - In this part we put a event, if a user put a finger on the screen 2 times the video back 10 seconds.
            if(event.getX()< (sWidth / 2)){
                intLeft = true;
                intRight = false;
                videoView.seekTo(videoView.getCurrentPosition() - 10000);
                Toast.makeText(TelaCheiaGtaSeis.this, "-10 segundos", Toast.LENGTH_SHORT).show();
            }

            // PT - Nesse momento estamos colocando um evento novamente, se o usuario não voltou o vídeo então ele irá adiantar 10 segundos
            // EN - In this part we put a event again, if a user don't want back the video, he go rise duration of video 10 seconds
            else if (event.getX() >(sWidth / 2)) {
                intLeft = false;
                intRight = true;
                videoView.seekTo(videoView.getCurrentPosition() + 10000);
                Toast.makeText(TelaCheiaGtaSeis.this, "+ 10 segundos", Toast.LENGTH_SHORT).show();

            }

            return super.onDoubleTap(event);
        }


    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            );
        }
    }
    private void hideDefaultControls(){
        one.setVisibility(View.GONE);
        two.setVisibility(View.GONE);
        three.setVisibility(View.GONE);
        four.setVisibility(View.GONE);

        // PT - Esconderá os status e navegação da tela caso alguem clique na tela
        // EN - Also hide status and navegation when we click on screen

        final  Window window = this.getWindow();
        if (window ==null){
            return;
        }

        window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        //window.addFlags(WindowManager.LayoutParams.);
        final View decorView = window.getDecorView();

        if (decorView !=null){
            int uiOption = decorView.getWindowSystemUiVisibility();

            if (Build.VERSION.SDK_INT >= 14) {
                uiOption |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            }
            decorView.setSystemUiVisibility(uiOption);
        }
    }

    private void showDefaultControls(){
        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);

        // PT - Mostrara os status e navegação da tela caso alguem clique na tela
        // EN - Also show status and navegation when we click on screen

        final  Window window = this.getWindow();
        if (window ==null){
            return;
        }

        window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        //window.addFlags(WindowManager.LayoutParams.);
        final View decorView = window.getDecorView();

        if (decorView !=null){
            int uiOption = decorView.getWindowSystemUiVisibility();

            if (Build.VERSION.SDK_INT >= 14) {
                uiOption |= ~View.SYSTEM_UI_FLAG_LOW_PROFILE;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                uiOption |= ~View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                uiOption |= ~View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            }
            decorView.setSystemUiVisibility(uiOption);
        }
    }

}
