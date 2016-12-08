package burgerpop.emirim.hs.kr.burgerpop;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

/**
 * Created by LG on 2016-11-22.
 */

public class RuleActivity extends Activity{
    ViewPager pager;
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_rule);
        pager=(ViewPager)findViewById(R.id.pager);

        CustomAdapter adapter= new CustomAdapter(getLayoutInflater());
        pager.setAdapter(adapter);



    }
}
