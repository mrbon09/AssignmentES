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
    Button b1,b2,b3,b4,b5;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_layout, container, false); // call layout
        /*Button title1 = view.findViewById(R.id.button1);
        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Fragment1());
                fr.commit();
            }
        });*/
        TextView text= view.findViewById(R.id.editText3);
        String t="WeLcoMe!!!!!!!";
        SpannableString ss=new SpannableString(t);
        StyleSpan boldIta=new StyleSpan(Typeface.BOLD_ITALIC);
        ss.setSpan(boldIta,0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setText(ss);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstances){
        super.onActivityCreated(savedInstances);
        b1=getActivity().findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.theguardian.com/books/2014/oct/22/being-mortal-medicine-what-matters-atul-gawande-review"));
                startActivity(browser1);
            }
        });
        b2=getActivity().findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.scientificamerican.com/article/book-review-pandemic/"));
                startActivity(browser2);
            }
        });
        b3=getActivity().findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.huffpost.com/entry/book-review_n_3773370"));
                startActivity(browser3);
            }
        });
        b4=getActivity().findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nyjournalofbooks.com/book-review/" +
                        "brave-new-world-healthcare-revisited-what-every-american-needs-know-about-our-healthcare"));
                startActivity(browser4);
            }
        });
        b5=getActivity().findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.goodreads.com/book/show/763331.Flu"));
                startActivity(browser5);
            }
        });
    }

}

