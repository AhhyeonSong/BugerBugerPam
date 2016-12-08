package burgerpop.emirim.hs.kr.burgerpop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    ImageView result_image;
    Intent result_intent;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result_image = (ImageView)findViewById(R.id.result);
        score=(TextView)findViewById(R.id.result_text);
        result_intent = getIntent();
        int result = 0;
        result = result_intent.getIntExtra("sc",0);
        Log.d("ds",""+result);
        //int result=9100;
        String result_text = String.valueOf(result) ;

        if(0<=result&&result<=10)
            result_image.setImageResource(R.drawable.result01);
        else if(result<=20)
            result_image.setImageResource(R.drawable.result02);
        else if(result>30)
            result_image.setImageResource(R.drawable.result03);
        score.setText("  SCORE "+result_text);
    }
    @Override
    public void onBackPressed() {
        Intent intentHome = new Intent(this, MainActivity.class);
        intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intentHome);
        super.onBackPressed();
    }
}

