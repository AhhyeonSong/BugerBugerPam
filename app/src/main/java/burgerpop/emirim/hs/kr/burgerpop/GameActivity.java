 package burgerpop.emirim.hs.kr.burgerpop;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    ImageButton cheese, lettuce, meat, tomato, fbread, sbread;
    ImageView img1,img2,img3,img4,img5,img6,img7;


    static int levelCount=1;
    static int level=0;
    int limit=0;
    Intent score_intent;
    // int score=7680;
    private TimerTask second;
    private TextView timer_text;
    private final Handler handler = new Handler();
    NotificationManager notiManager;
    //진동을 줘보자 진동객체
    Vibrator vibrator;
    //알림 식별값
    final static int MyNoti=0;
    int timer_sec;
    int count;
    //String time_str;
    int score=10;
    //시은이
    TextView show;
    CountDownT timer;
    ProgressBar progressBar  = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        onResume();
        // comparison();
        //testStart();//???
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        //show = (TextView)findViewById(R.id.timer);
        timer = new CountDownT(100000,1000);
        //show.setText("40");
        //testStart();
        timer.start();
    }


    static int check[]=new int[8];
    static int correct_cout=0;

    @Override
    protected void onResume() {
        super.onResume();
        cheese = (ImageButton)findViewById(R.id.cheese);
        lettuce = (ImageButton)findViewById(R.id.lettuce);
        meat = (ImageButton)findViewById(R.id.meat);
        tomato = (ImageButton)findViewById(R.id.tomato);
        fbread = (ImageButton)findViewById(R.id.firstbread);
        sbread = (ImageButton)findViewById(R.id.secondbread);

        img7 = (ImageView)findViewById(R.id.img7);
        img6 = (ImageView)findViewById(R.id.img6);
        img5 = (ImageView)findViewById(R.id.img5);
        img4 = (ImageView)findViewById(R.id.img4);
        img3 = (ImageView)findViewById(R.id.img3);
        img2 = (ImageView)findViewById(R.id.img2);
        img1 = (ImageView)findViewById(R.id.img1);

        final ImageView burger[] = {img1, img2, img3, img4, img5,img6,img7};


        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(level == 0) {
                    Log.d("성공", "" + level);
                    for (int i = 0; i < 7; i++) {
                        burger[i].setImageResource(R.drawable.sample);
                        Log.d("성공2", "" + i);
                    }
                }
                burger[level].setImageResource(R.drawable.game_cheese);
                check[level]=4;
                Log.d("cheese",""+check[level]);
                checkLevel();
            }
        });
        lettuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level == 0) {
                    Log.d("성공", "" + level);
                    for (int i = 0; i < 7; i++) {
                        burger[i].setImageResource(R.drawable.sample);
                        Log.d("성공2", "" + i);
                    }
                }
                burger[level].setImageResource(R.drawable.game_lettuce);
                check[level]=3;
                Log.d("lettuce",""+check[level]);
                checkLevel();
            }
        });
        tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level == 0) {
                    Log.d("성공", "" + level);
                    for (int i = 0; i < 7; i++) {
                        burger[i].setImageResource(R.drawable.sample);
                        Log.d("성공2", "" + i);
                    }
                }
                burger[level].setImageResource(R.drawable.game_tomato);
                check[level]=5;
                Log.d("tomato",""+check[level]);
                checkLevel();
            }
        });
        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level == 0) {
                    Log.d("성공", "" + level);
                    for (int i = 0; i < 7; i++) {
                        burger[i].setImageResource(R.drawable.sample);
                        Log.d("성공2", "" + i);
                    }
                }
                burger[level].setImageResource(R.drawable.game_meat);
                check[level]=2;
                Log.d("meat",""+check[level]);
                checkLevel();
            }
        });
        fbread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level == 0) {
                    Log.d("성공", "" + level);
                    for (int i = 0; i < 7; i++) {
                        burger[i].setImageResource(R.drawable.sample);
                        Log.d("성공2", "" + i);
                    }
                }
                burger[level].setImageResource(R.drawable.game_bread_up);
                check[level]=1;
                Log.d("fbread",""+check[level]);
                checkLevel();
            }});
        sbread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level == 0) {
                    Log.d("성공", "" + level);
                    for (int i = 0; i < 7; i++) {
                        burger[i].setImageResource(R.drawable.sample);
                        Log.d("성공2", "" + i);
                    }
                }
                burger[level].setImageResource(R.drawable.game_bread_under);
                check[level]=6;
                Log.d("sbread",""+check[level]);
                checkLevel();
            }
        });
    }
    void checkLevel() {
        if(levelCount==1) {
            if (level >= 4) {
                level = 0;
                comparison();
            } else level++;
            Log.d("sd", level + "");
        }
        else if(levelCount==2) {
            if (level >= 5) {
                level = 0;
                comparison();
            } else level++;
            Log.d("sd", level + "");
        }
        else if(levelCount==3) {
            if (level >= 6) {
                level = 0;
                comparison();
            } else level++;
            Log.d("sd", level + "");
        }
        if(levelCount==1){
            limit=5;
        }else if(levelCount==2){
            limit=6;
        }else if(levelCount==2){
            limit=7;
        }

    }

    ImageView result;
    //int mission[]=new int[5];
    static int random=1;
    static int stage_count=0;
    int mission[];
    ImageView example;
    Stage s1 = new Stage();
    public void comparison(){
        img7 = (ImageView)findViewById(R.id.img7);
        img6 = (ImageView)findViewById(R.id.img6);
        img5 = (ImageView)findViewById(R.id.img5);
        img4 = (ImageView)findViewById(R.id.img4);
        img3 = (ImageView)findViewById(R.id.img3);
        img2 = (ImageView)findViewById(R.id.img2);
        img1 = (ImageView)findViewById(R.id.img1);

        final ImageView burger[] = {img1, img2, img3, img4, img5,img6,img7};
        if(levelCount==1) {
            s1.stage1();
        }
        else if(levelCount==2){
            s1.stage2();
        }
        else if(levelCount==3){
            s1.stage3();
        }
        int flag=0;
        result=(ImageView)findViewById(R.id.result_sample);
        example = (ImageView)findViewById(R.id.example);
        if(levelCount==1) {
            switch (random) {
                case 1: mission = new int[]{6, 5, 2, 4, 1}; break;
                case 2: mission = new int[]{6, 3, 5, 4, 1}; break;
                case 3: mission = new int[]{6, 5, 4, 2, 1}; break;
                case 4: mission = new int[]{6, 2, 4, 3, 1}; break;
                case 5: mission = new int[]{6, 4, 3, 5, 1}; break;
                case 6: mission = new int[]{6, 5, 3, 4, 1}; break;
                case 7: mission = new int[]{6, 5, 3, 2, 1}; break;
                case 8: mission = new int[]{6, 3, 2, 5, 1}; break;
            }
            for(int i=0;i<5;i++){
                if(mission[i]!=check[i]) {
                    flag=1;
                    break;
                }
                else {
                    flag = 0;
                }
            }
            if(flag==1){
                result.setImageResource(R.drawable.bad);
            }
            else if(flag==0){
                result.setImageResource(R.drawable.good);
                correct_cout++;
                stage_count++;
                if( stage_count==8){
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    Toast.makeText(getApplication(),"2단계 시작!",Toast.LENGTH_SHORT).show();
                    levelCount++;
                    stage_count=0;
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    img6.setVisibility(View.VISIBLE);
                    if(level == 0) {
                        Log.d("성공", "" + level);
                        for (int i = 0; i < limit; i++) {
                            burger[i].setImageResource(R.drawable.sample);
                            Log.d("성공2", "" + i);
                        }
                    }
                }
            }
        }else if(levelCount==2){
            switch(random){
                case 1: mission=new int[]{6,5,3,2,4,1}; break;
                case 2: mission=new int[]{6,2,4,2,4,1}; break;
                case 3: mission=new int[]{6,2,5,4,2,1}; break;
                case 4: mission=new int[]{6,5,3,5,4,1}; break;
                case 5: mission=new int[]{6,5,2,4,5,1}; break;
                case 6: mission=new int[]{6,2,3,4,3,1}; break;
                case 7: mission=new int[]{6,2,3,5,3,1}; break;
                case 8: mission=new int[]{6,2,5,2,5,1}; break;
            }
            for(int i=0;i<6;i++){
                if(mission[i]!=check[i]) {
                    flag=1;
                    break;
                }
                else {
                    flag = 0;
                }
            }
            if(flag==1){
                result.setImageResource(R.drawable.bad);
            }
            else if(flag==0){
                result.setImageResource(R.drawable.good);
                correct_cout++;
                stage_count++;
                if( stage_count==8){

                    Toast.makeText(getApplication(),"3단계 시작!",Toast.LENGTH_SHORT).show();
                    levelCount++;
                    stage_count=0;
                    timer_sec=0;

                    img7.setVisibility(View.VISIBLE);
                    if(level == 0) {
                        Log.d("성공", "" + level);
                        for (int i = 0; i < 7; i++) {
                            burger[i].setImageResource(R.drawable.sample);
                            Log.d("성공2", "" + i);
                        }
                    }
                }
            }
        }else if(levelCount==3){
            switch(random){
                case 1: mission=new int[]{6,4,5,3,4,2,1}; break;
                case 2: mission=new int[]{6,4,2,5,3,2,1}; break;
                case 3: mission=new int[]{6,2,3,5,3,4,1}; break;
                case 4: mission=new int[]{6,3,4,3,2,5,1}; break;
                case 5: mission=new int[]{6,3,4,2,2,4,1}; break;
                case 6: mission=new int[]{6,4,2,4,3,5,1}; break;
                case 7: mission=new int[]{6,2,5,2,4,3,1}; break;
                case 8: mission=new int[]{6,4,5,5,2,3,1}; break;
            }
            for(int i=0;i<7;i++){
                if(mission[i]!=check[i]) {
                    flag=1;
                    break;
                }
                else {
                    flag = 0;
                }
            }
            if(flag==1){
                result.setImageResource(R.drawable.bad);
            }
            else if(flag==0){
                result.setImageResource(R.drawable.good);
                correct_cout++;
                /*if(correct_cout==8){
                    correct_cout=0;
                    levelCount++;
                    timer_sec=0;
                    s1.stage3();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }
        switch (levelCount){
            case 1: s1.stage1(); break;
            case 2: s1.stage2(); break;
            case 3: s1.stage3(); break;
        }
        random =  (int) (Math.random() * 8 )+ 1;
        Log.d("random",":"+random);
        example.setImageResource(s1.burger[random-1]);
        Log.d("log",correct_cout+","+stage_count+","+levelCount);
    }

    protected void Update() {
        //time_str="";
        /*Runnable updater = new Runnable() {
            public void run() {
                if(timer_sec>0 && timer_sec<10)
                    time_str="0"+timer_sec;
                else
                    time_str=String.valueOf(timer_sec);
                timer_text.setText(time_str);
            }
        };
        handler.post(updater);*/
    }

    //맨 처음 버튼(빵)을 눌렀을때 실행되는 메소드
    /*public void push(View v){
        //버튼을 눌렀을 때 테스트 하기
        handler.sendEmptyMessageDelayed(0, 20000); //20초 후에 알람울림

    }*/
    //일정 시간 후에 알림을 발생시킬 핸들러
    /*Handler handler = new Handler(){*/
    public void handleMessage() {
        //score=7680;
        score_intent=new Intent(this,ResultActivity.class);
        score_intent.putExtra("sc",correct_cout);
        //Intent result = new Intent(this,ResultActivity.class);
        Log.d("d2",""+correct_cout);
        timer_sec=0;
        correct_cout=0;
        stage_count=0;
        startActivity(score_intent);
        timer.cancel();
        // super.handleMessage();
    }
    public void start(View view){
        timer.start();
    }
    public void stop(View view)
    {
        timer.cancel();
    }
    public class CountDownT extends CountDownTimer {
        public CountDownT(long InMillisSeconds, long TimeGap)
        {
            super(InMillisSeconds,TimeGap);
        }
        public void onTick(long l)
        {
            /*if(l/1000<10)
                time_str="0"+(l/1000);
            else
                time_str=(l/1000)+"";//ㅣ이 점점 작아지나보다.
            show.setText(time_str);*/
            progressBar.setProgress((int)l/1000);//(int)(100* l)
        }
        public void onFinish()
        {
            progressBar.setProgress(0);
            handleMessage();
            timer = new CountDownT(100000,1000);
        }
    }
    public void timeMessage() {
        //score=7680;
       /* score_intent=new Intent(this,ResultActivity.class);
        score_intent.putExtra("sc",score);
        startActivity(score_intent);
        timer.cancel();*/
        //Intent result = new Intent(this,ResultActivity.class);
        // super.handleMessage();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        level=0;
        correct_cout=0;
    }
}