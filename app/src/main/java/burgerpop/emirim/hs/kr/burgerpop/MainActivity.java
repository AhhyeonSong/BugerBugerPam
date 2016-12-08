package burgerpop.emirim.hs.kr.burgerpop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton start, rule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        start = (ImageButton) findViewById(R.id.game_start);
        rule = (ImageButton) findViewById(R.id.game_rule);

        start.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View view) {
                intent = new Intent( getApplicationContext(), GameActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);
            }
        });
        rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(), RuleActivity.class);
                startActivity(in);
            }
        });
    }

}
