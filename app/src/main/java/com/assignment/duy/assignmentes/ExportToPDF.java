package com.assignment.duy.assignmentes;

import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.annotation.Documented;

public class ExportToPDF extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.export_pdf, container, false);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPDF();
                Toast.makeText(getContext(),"Export to PDF successfully",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    public void createPDF(){
        //EditText txt = (EditText)getView().findViewById(R.id.choose_feature);
        TextView head = (TextView)getView().findViewById(R.id.heading_s);
        TextView name = (TextView)getView().findViewById(R.id.textView5);
        TextView bd = (TextView)getView().findViewById(R.id.textView7);
        Font headFont = new Font(Font.FontFamily.TIMES_ROMAN, 50,
                Font.BOLD, BaseColor.BLACK);
        Paragraph paragraph_h = new Paragraph(head.getText().toString(), headFont);
        paragraph_h.setAlignment(Element.ALIGN_CENTER);
        paragraph_h.setSpacingAfter(25);

        /*CompoundButton.OnCheckedChangeListener m_listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        }; */

        Font inforFont = new Font(Font.FontFamily.TIMES_ROMAN, 36,
                Font.NORMAL, BaseColor.BLACK);

        Paragraph paragraph_name = new Paragraph(name.getText().toString(), inforFont);
        paragraph_name.setSpacingAfter(15);
        Paragraph paragraph_bd = new Paragraph(bd.getText().toString(), inforFont);
        paragraph_bd.setSpacingAfter(15);

        CheckBox checkbox1 = getView().findViewById(R.id.checkBox2);
        CheckBox checkbox2 = getView().findViewById(R.id.checkBox3);
        CheckBox checkbox3 = getView().findViewById(R.id.checkBox4);
        CheckBox checkbox4 = getView().findViewById(R.id.checkBox5);
        CheckBox checkbox5 = getView().findViewById(R.id.checkBox6);
        CheckBox checkbox6 = getView().findViewById(R.id.checkBox7);
        CheckBox checkbox7 = getView().findViewById(R.id.checkBox8);
        CheckBox checkbox8 = getView().findViewById(R.id.checkBox9);
        CheckBox checkbox9 = getView().findViewById(R.id.checkBox10);
        CheckBox checkbox10 = getView().findViewById(R.id.checkBox11);

        Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN, 26,
                Font.NORMAL, BaseColor.BLACK);
        Paragraph paragraph_c1 = new Paragraph(checkbox1.getText().toString(), contentFont);
        Paragraph paragraph_c2 = new Paragraph(checkbox2.getText().toString(), contentFont);
        Paragraph paragraph_c3 = new Paragraph(checkbox3.getText().toString(), contentFont);
        Paragraph paragraph_c4 = new Paragraph(checkbox4.getText().toString(), contentFont);
        Paragraph paragraph_c5 = new Paragraph(checkbox5.getText().toString(), contentFont);
        Paragraph paragraph_c6 = new Paragraph(checkbox6.getText().toString(), contentFont);
        Paragraph paragraph_c7 = new Paragraph(checkbox7.getText().toString(), contentFont);
        Paragraph paragraph_c8 = new Paragraph(checkbox8.getText().toString(), contentFont);
        Paragraph paragraph_c9 = new Paragraph(checkbox9.getText().toString(), contentFont);
        Paragraph paragraph_c10 = new Paragraph(checkbox10.getText().toString(), contentFont);

        paragraph_c1.setAlignment(Element.ALIGN_LEFT);
        paragraph_c1.setSpacingAfter(5);
        paragraph_c2.setAlignment(Element.ALIGN_LEFT);
        paragraph_c2.setSpacingAfter(5);
        paragraph_c3.setAlignment(Element.ALIGN_LEFT);
        paragraph_c3.setSpacingAfter(5);
        paragraph_c4.setAlignment(Element.ALIGN_LEFT);
        paragraph_c4.setSpacingAfter(5);
        paragraph_c5.setAlignment(Element.ALIGN_LEFT);
        paragraph_c5.setSpacingAfter(5);
        paragraph_c6.setAlignment(Element.ALIGN_LEFT);
        paragraph_c6.setSpacingAfter(5);
        paragraph_c7.setAlignment(Element.ALIGN_LEFT);
        paragraph_c7.setSpacingAfter(5);
        paragraph_c8.setAlignment(Element.ALIGN_LEFT);
        paragraph_c8.setSpacingAfter(5);
        paragraph_c9.setAlignment(Element.ALIGN_LEFT);
        paragraph_c9.setSpacingAfter(5);
        paragraph_c10.setAlignment(Element.ALIGN_LEFT);

        Document doc = new Document();

        String outPath = Environment.getExternalStorageDirectory()+"/healthsheet.pdf";
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(outPath));
            doc.open();
            doc.add(paragraph_h);
            doc.add(paragraph_name);
            doc.add(paragraph_bd);
            doc.add(paragraph_c1);
            doc.add(paragraph_c2);
            doc.add(paragraph_c3);
            doc.add(paragraph_c4);
            doc.add(paragraph_c5);
            doc.add(paragraph_c6);
            doc.add(paragraph_c7);
            doc.add(paragraph_c8);
            doc.add(paragraph_c9);
            doc.add(paragraph_c10);
            doc.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
