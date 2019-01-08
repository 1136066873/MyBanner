package com.hegd.mybanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.hegd.mybanner.R;

import com.hegd.mybanner.echelon.EchelonLayoutManager;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private EchelonLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);

        initData();
    }

    private void initData() {
        mLayoutManager = new EchelonLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter());

    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private int[] bgs = {R.mipmap.bg_1,R.mipmap.bg_2,R.mipmap.bg_3,R.mipmap.bg_4};
        private String[] nickNames = {"左耳近心","凉雨初夏","稚久九栀","半窗疏影"};
        private String[] descs = {
                "回不去的地方叫故乡 没有根的迁徙叫流浪...",
                "人生就像迷宫，我们用上半生找寻入口，用下半生找寻出口",
                "原来地久天长，只是误会一场",
                "不是故事的结局不够好，而是我们对故事的要求过多",
                "只想优雅转身，不料华丽撞墙"
        };
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_echelon,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.bg.setImageResource(bgs[position%4]);
            holder.bg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "00000", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return 60;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView bg;
            public ViewHolder(View itemView) {
                super(itemView);
                bg = itemView.findViewById(R.id.img_bg);
            }
        }
    }
}
