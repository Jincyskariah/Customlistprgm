package com.example.customlistprgm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
ListView lst;
CircleImageView imgs;
TextView txt,phno;
ArrayList<String> fine;
ArrayList<String> number;
RelativeLayout relative;
int[] image={R.drawable.anju,R.drawable.ann,R.drawable.emaya,R.drawable.eva,R.drawable.jiz,R.drawable.kripa,R.drawable.ammu,R.drawable.eee,R.drawable.fhgg,R.drawable.gang,R.drawable.remya};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst=findViewById(R.id.list);
        fine=new ArrayList<String>();
        fine.add("Anju");
        fine.add("Remya");
        fine.add("Divya");
        fine.add("Liz");
        fine.add("Ammu");
        fine.add("Ann");
        fine.add("Geetha");
        fine.add("Jiz");
        fine.add("Annu");
        fine.add("Eva");
        fine.add("Emaya");

        number=new ArrayList<String>();
        number.add("9400756454");
        number.add("7567384646");
        number.add("9847466437");
        number.add("8746483908");
        number.add("9545678098");
        number.add("9644788874");
        number.add("9342625788");
        number.add("8726251076");
        number.add("9785994489");
        number.add("9857949363");
        number.add("8675893937");

        adapt adp=new adapt(number,fine);
        lst.setAdapter(adp);




    }

    class adapt extends BaseAdapter{
        LayoutInflater inflater;
        ArrayList<String> fine;
        ArrayList<String> number;

        public adapt(ArrayList<String> fine, ArrayList<String> number) {
            this.fine = fine;
            this.number = number;
        }

        @Override
        public int getCount() {
            //entering datas
            return fine.size();

        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {
            inflater=(LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE) ;
            view=inflater.inflate(R.layout.listitem,null);
            txt=(TextView) view.findViewById(R.id.txtname);
            phno=(TextView) view.findViewById(R.id.txtphno);
            imgs= view.findViewById(R.id.img);
            imgs.setImageResource(image[position]);
            txt.setText(fine.get(position));
            phno.setText(number.get(position));


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +number.get(position)));
                    startActivity(intent);
                }
            });

            return view;
        }


    }



}
