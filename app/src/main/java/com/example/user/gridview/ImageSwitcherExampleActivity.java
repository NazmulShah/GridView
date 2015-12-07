package com.example.user.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

/**
 * Created by User on 12/7/2015.
 */
public class ImageSwitcherExampleActivity extends Activity implements ViewSwitcher.ViewFactory {
    ImageSwitcher is;
    int flag =1;
    Button prev, next;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher_example);

        is = (ImageSwitcher)findViewById(R.id.imageSwitcher1);
        prev = (Button)findViewById(R.id.button1);
        next = (Button)findViewById(R.id.button2);
        is.setFactory(this);
        is.setInAnimation(this, android.R.anim.slide_in_left);
        is.setOutAnimation(this, android.R.anim.slide_out_right);

        Intent i =getIntent();
        int position = i.getExtras().getInt("id");

        count = position;
        is.setImageResource(mThumbIds[count]);

        Toast.makeText(ImageSwitcherExampleActivity.this, "count number :" + count, Toast.LENGTH_LONG).show();




        prev.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

               /* if(flag==1){
                    count--;
                    flag = 0;

                }
*/


                // TODO Auto-generated method stub
                if(count>0)
                {
                    count--;
                    try{
                        is.setImageResource(mThumbIds[count]);

                        Toast.makeText(ImageSwitcherExampleActivity.this, "count number :"+ count, Toast.LENGTH_LONG).show();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Toast.makeText(ImageSwitcherExampleActivity.this, "First", Toast.LENGTH_LONG).show();
                }
            }
        });


        next.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

              /*  if(flag==1){
                    count++;
                    flag = 0;
                }
*/

                count++;

                // TODO Auto-generated method stub
                if(count<mThumbIds.length)
                {


                    try{
                        is.setImageResource(mThumbIds[count]);

                        Toast.makeText(ImageSwitcherExampleActivity.this, "count number :"+ count, Toast.LENGTH_LONG).show();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    //count++;

                }
                else
                {
                    Toast.makeText(ImageSwitcherExampleActivity.this, "Last", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    public View makeView() {
        // TODO Auto-generated method stub
        ImageView iv = new ImageView(this);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        return iv;
    }


    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j,
            R.drawable.k, R.drawable.l,
            R.drawable.m, R.drawable.n,



    };

}