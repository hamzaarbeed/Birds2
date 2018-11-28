package com.test.birds;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context = this;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calc = (Button) findViewById(R.id.button);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<BirdSet> mDataset = new ArrayList<>();

                int TN = Integer.parseInt(((TextInputEditText)findViewById(R.id.totalBirds)).getText().toString());

                int TP = Integer.parseInt(((TextInputEditText)findViewById(R.id.totalPrice)).getText().toString());
                double P1 = Double.parseDouble(((TextInputEditText)findViewById(R.id.fBirdPrice)).getText().toString());
                double P2 = Double.parseDouble(((TextInputEditText)findViewById(R.id.sBirdPrice)).getText().toString());
                double P3 = Double.parseDouble(((TextInputEditText)findViewById(R.id.tBirdPrice)).getText().toString());
                Log.v("Birds", "error5.5");
                double N1, N2, N3;
                for (N3 = 1; N3 * P3 < TP && N3 < TN; N3++) {
                    N2 = (TP - TN * P1 - N3 * (P3 - P1)) / (P2 - P1);
                    N1 = TN - N2 - N3;
                    if (N2 % 1 == 0 && N2 > 0 && N1 % 1 == 0 && N1 > 0)
                        mDataset.add(new BirdSet((int) N1 , (int) N2 , (int) N3));
                }
                if (mDataset.size() == 0)
                    mDataset.add(new BirdSet( 0,0,0));
                mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
                mLayoutManager = new LinearLayoutManager(context);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new MyAdapter(context,mDataset);
                mRecyclerView.setAdapter(mAdapter);

            }
        });
    }

}
