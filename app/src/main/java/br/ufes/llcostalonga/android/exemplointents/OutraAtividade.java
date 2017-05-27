package br.ufes.llcostalonga.android.exemplointents;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class OutraAtividade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra_atividade);

        //todo exemplo 6
        FrameLayout f = (FrameLayout)findViewById(R.id.frameOutraAtividade);
        Intent intent = getIntent();
        String cor = (String) intent.getSerializableExtra("cor");
        f.setBackgroundColor( Color.parseColor(cor));

    }



}
