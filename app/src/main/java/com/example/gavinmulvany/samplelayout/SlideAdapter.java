package com.example.gavinmulvany.samplelayout;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

   Context context;
   LayoutInflater inflater;

   public int[] images = {

           R.drawable.code_icon,
           R.drawable.eat_icon,
           R.drawable.sleep_icon
    };

   public String[] titles = {

           "Activities",
           "Places to Wine and Dine",
           "Hotels and B&Bs"
   };

   public String[] descriptions = {
           "Check out everything Swords has to offer!. From Viking History to Shopping Centres, Swords has everything you need.",
           "With an abundance of restaurants and bars, you will be spoiled for choice. Check out what Swords has to offer.",
           "Why not stay the night, with a variety of Hotels and B&Bs you'll never want to leave"

   };

   public int[] backgroundcolor = {
           Color.rgb(255,150,0),
           Color.rgb(255,150,0),
           Color.rgb(255,150, 0)
   };

   public SlideAdapter(Context context){
       this.context = context;
   }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return (view==(LinearLayout)object);
    }


    @Override
    public Object instantiateItem( ViewGroup container, int position) {
       inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view = inflater.inflate(R.layout.slide,container,false);
       LinearLayout layoutslide = view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txttitle = (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(backgroundcolor[position]);
        imgslide.setImageResource(images[position]);
        txttitle.setText(titles[position]);
        description.setText(descriptions[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
