package com.example.samhan.app.sharelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_paper, b_scissor;
    ImageView iv_cpu, iv_me;

    String playerChoice, cpuChoice, result;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_rock= (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissor = (Button) findViewById(R.id.b_scissor);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        r = new Random();

        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = "rock";
                iv_me.setImageResource(R.drawable.scissors);
                calculate();
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = "paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();

            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = "scissors";
                iv_me.setImageResource(R.drawable.rock);
                calculate();
            }
        });

    }

    public void calculate(){
        int cpu = r.nextInt(3);
        result = cpu+"";
        if(cpu == 0)
        {cpuChoice = "rock";
        iv_cpu.setImageResource(R.drawable.rock);
            }
        else if(cpu == 1)
        {cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if(cpu == 2)
        {cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }


        if(playerChoice.equals("rock") && cpuChoice.equals("paper"))
        {
            result = "You Lose";
        }
        if(playerChoice.equals("rock") && cpuChoice.equals("scissors"))
        {
            result = "You win";
        }
        if(playerChoice.equals("paper") && cpuChoice.equals("rock"))
        {
            result = "You lose";
        }
        if(playerChoice.equals("paper") && cpuChoice.equals("scissors"))
        {
            result = "You Lose";
        }
        if(playerChoice.equals("scissors") && cpuChoice.equals("paper"))
        {
            result = "You win";
        }
        if(playerChoice.equals("scissors") && cpuChoice.equals("rock"))
        {
            result = "You Lose";
        }
        if(playerChoice.equals("rock") && cpuChoice.equals("rock"))
        {
            result = "draw";
        }
        if(playerChoice.equals("paper") && cpuChoice.equals("paper"))
        {
            result = "draw";
        }
        if(playerChoice.equals("scissors") && cpuChoice.equals("scissors"))
        {
            result = "draw";
        }


        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }

}
