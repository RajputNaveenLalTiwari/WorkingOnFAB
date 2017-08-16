package com.examples.workingonfab;

import android.animation.Animator;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private RelativeLayout circularRevealAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circularRevealAnimationView = (RelativeLayout) findViewById(R.id.circularRevealAnimationViewID);
        circularRevealAnimationView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.circularRevealAnimationViewID)
        {
            int finalRadius = (int) Math.hypot(v.getWidth()/2,v.getHeight()/2);
            circularRevealAnimation(v,(int) v.getWidth()/2,(int) v.getHeight()/2,0,finalRadius);
        }
    }

    private void circularRevealAnimation(View view,int centerX,int centerY,float startX,float endY)
    {
        Animator animator = ViewAnimationUtils.createCircularReveal(view,centerX,centerY,startX,endY);
        animator.start();
    }
}
