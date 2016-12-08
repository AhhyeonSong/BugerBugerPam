package burgerpop.emirim.hs.kr.burgerpop;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by LG on 2016-11-22.
 */

public class CustomAdapter extends PagerAdapter{
    LayoutInflater inflater;
    public CustomAdapter(LayoutInflater inflater){
        this.inflater=inflater;
    }
    public int getCount(){
        return 2;
    }
    public Object  instantiateItem(ViewGroup container, int position){
        View view= null;
        view= inflater.inflate(R.layout.viewpager_childview, null);
        ImageView img= (ImageView )view.findViewById(R.id.img_viewpager_childimage);
        img.setImageResource(R.drawable.explain1+position);//+position//
        container.addView(view);
        return view;
    }
    public boolean isViewFromObject(View v, Object obj) {
        // TODO Auto-generated method stub
        return v==obj;
    }
}
