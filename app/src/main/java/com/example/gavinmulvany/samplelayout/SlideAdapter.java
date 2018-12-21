package com.example.gavinmulvany.samplelayout;
//created by Gavin Mulvany - x15448892

//refs: https://www.youtube.com/watch?v=R_AIUy7tFVA&t=10s

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

    //declare vars
   Context context;
   LayoutInflater inflater;

   //setting up my array images
   public int[] images = {

           R.drawable.chips,
           R.drawable.burger,
           R.drawable.pizza,
           R.drawable.steak,
           R.drawable.salad,
           R.drawable.brunch
    };

   //setting up my title
   public String[] titles = {

           "Where to Eat?",
           "Ruby's",
           "Pomodorino",
           "The Old School House",
           "Green Straw",
           "The Gourmet Food Parlour"
   };

   //setting up my desc
   public String[] descriptions = {
           "Swords is a multi-cultural Town with lots to offer, especially in restaurants."+ "\n\n" + "We've put together a list of the best places to eat in Swords" + "\n\n" + "SWIPE RIGHT",
           "Ruby’s award winning restaurants are relaxed and informal serving the finest Pizzas, Burgers, Wings, Ribs, Steaks, Pastas and more. \n" + " Cocktails are a speciality, lunch is great value and you don’t need to book."+"\n\n"+"Where is it: Pavilions Shopping Centre",
           "Authentic  Italian Eatery, Pomodorino offers customers Wood-fired Pizzas, pasta dishes,appetizers,wines & coffee.\n" + "Open for Lunch & Dinner. Eat-in- Take-Away & Collection/Delivery available" + "\n\n" + "Where is it: Unit 3, 14 Main Street ",
           "A traditional but modern Irish pub which specialise in locally sourced steak and seafood.\n\n" + "Extensive menu, with great early bird and daily specials available.\n\n" +"Downstairs in the bar you can sit and enjoy a great pint of Guinness, watch all sporting events on their big screens, take in some live music, enjoy a burger or steak from their barfood menu or simply just sit outside in our beautiful all year round beer garden" +"\n\n"+"Where is it: Coolbanagher, Church Road",
           "Healthy Cafe serving only homemade food from local suppliers, organic fruits and veg among their ingredients.\n\n" + "Dishes include our signature Protein pancakes with peanut butter sauce, Cloud Picker Coffee, full selection of breakfast, lunch and desert items." +"\n\n" + "Where is it: Unit 3, 32-36 Main Street",
           "Their restaurant is light & bright and their team is warm, friendly & efficient. Whether you are looking for a bite to eat for breakfast, lunch or dinner or somewhere to host a celebratory meal, it’s the perfect spot." + "\n\n" + "Where is it: North Street, Swords Village"

   };

   //setting up a background colour
   public int[] backgroundcolor = {
           Color.rgb(255,255,255),
           Color.rgb(255,255,255),
           Color.rgb(255,255, 255),
           Color.rgb(255,255,255),
           Color.rgb(255,255, 255),
           Color.rgb(255,255, 255)

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

    //everytime we swipe the old page gets destroyed
    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
