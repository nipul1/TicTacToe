package com.example.tictactoe;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer count=0;
    Integer[][] choice = new Integer[3][3];
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    boolean turnOfCross = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                choice[i][j]=0;
            }
        }
        img1=findViewById(R.id.imageView1);
        img2=findViewById(R.id.imageView2);
        img3=findViewById(R.id.imageView3);
        img4=findViewById(R.id.imageView4);
        img5=findViewById(R.id.imageView5);
        img6=findViewById(R.id.imageView6);
        img7=findViewById(R.id.imageView7);
        img8=findViewById(R.id.imageView8);
        img9=findViewById(R.id.imageView9);
    }
    public void clearfun(){
        img1.setImageResource(R.drawable.blank);
        img2.setImageResource(R.drawable.blank);
        img3.setImageResource(R.drawable.blank);
        img4.setImageResource(R.drawable.blank);
        img5.setImageResource(R.drawable.blank);
        img6.setImageResource(R.drawable.blank);
        img7.setImageResource(R.drawable.blank);
        img8.setImageResource(R.drawable.blank);
        img9.setImageResource(R.drawable.blank);
        turnOfCross=true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                choice[i][j]=0;
            }
        }
    }
    public void mark(ImageView img){
        if(turnOfCross)
            img.setImageResource(R.drawable.cross);
        else
            img.setImageResource(R.drawable.zero);
    }
    public Boolean isWinner(int desiredNumber,int i,int j){
        Boolean result=false;
        if(choice[i][0]==desiredNumber && choice[i][1]==desiredNumber && choice[i][2]==desiredNumber)
            result = true;
        if(choice[0][j]==desiredNumber && choice[1][j]==desiredNumber && choice[2][j]==desiredNumber)
            result = true;
        if(choice[0][0]==desiredNumber && choice[1][1]==desiredNumber && choice[2][2]==desiredNumber)
            result = true;
        if(choice[0][2]==desiredNumber && choice[1][1]==desiredNumber && choice[2][0]==desiredNumber)
            result = true;
        return result;
    }
    public void imgClicked(int i,int j,ImageView img){
        if(choice[i][j]==0){
            mark(img);
            int desiredNumber = (turnOfCross)?2:1;
            choice[i][j]=desiredNumber;
            if(isWinner(desiredNumber,i,j)){
                String winner = (turnOfCross)?"Cross Wins ":"Zero Wins";
                Toast.makeText(getApplicationContext(),winner,Toast.LENGTH_LONG).show();
                clearfun();
            }
            else{
                turnOfCross=!turnOfCross;
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Please make a valid move",Toast.LENGTH_LONG).show();
        }
    }
    public void resetTheGame(View view){
        clearfun();
    }
    public void generalClickedfun(View view){
        int i=0,j=0;
        ImageView img=findViewById(R.id.imageView1);
        switch(view.getId()) {
            case R.id.imageView1:
                img=findViewById(R.id.imageView1);
                i=0;
                j=0;
                break;
            case R.id.imageView2:
                img=findViewById(R.id.imageView2);
                i=0;
                j=1;
                break;
            case R.id.imageView3:
                img=findViewById(R.id.imageView3);
                i=0;
                j=2;
                break;
            case R.id.imageView4:
                img=findViewById(R.id.imageView4);
                i=1;
                j=0;
                break;
            case R.id.imageView5:
                img=findViewById(R.id.imageView5);
                i=1;
                j=1;
                break;
            case R.id.imageView6:
                img=findViewById(R.id.imageView6);
                i=1;
                j=2;
                break;
            case R.id.imageView7:
                img=findViewById(R.id.imageView7);
                i=2;
                j=0;
                break;
            case R.id.imageView8:
                img=findViewById(R.id.imageView8);
                i=2;
                j=1;
                break;
            case R.id.imageView9:
                img=findViewById(R.id.imageView9);
                i=2;
                j=2;
        }

        imgClicked(i,j,img);
    }
}
