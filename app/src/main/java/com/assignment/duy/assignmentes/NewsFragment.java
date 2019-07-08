package com.assignment.duy.assignmentes;

package com.assignment.duy.assignmentes;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class NewsFragment extends Fragment {
    Button b1,b2,b3,b4,b6,b7,b9,b10,search;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_layout, container, false);    //call layout
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstances){
        super.onActivityCreated(savedInstances);
        b1=getActivity().findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tuoitre.vn/suc-khoe.htm"));
                startActivity(browser1);
            }
        });
        b2=getActivity().findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://thanhnien.vn/suc-khoe/"));
                startActivity(browser2);
            }
        });
        b3=getActivity().findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dantri.com.vn/suc-khoe.htm"));
                startActivity(browser3);
            }
        });
        b4=getActivity().findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vnexpress.net/suc-khoe"));
                startActivity(browser4);
            }
        });
        b6=getActivity().findViewById(R.id.button6);
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bbc.com/news/health"));
                startActivity(browser5);
            }
        });
        b7=getActivity().findViewById(R.id.button7);
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://edition.cnn.com/health"));
                startActivity(browser5);
            }
        });

        b9=getActivity().findViewById(R.id.button9);
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sciencedaily.com/news/top/health/"));
                startActivity(browser5);
            }
        });
        b10=getActivity().findViewById(R.id.button10);
        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.medicalnewstoday.com/"));
                startActivity(browser5);
            }
        });
        search=getActivity().findViewById(R.id.button5);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setClassName("com.assignment.duy.assignmentes","com.assignment.duy.assignmentes.HealthSearch");
                startActivity(intent);
            }
        });
    }
}
