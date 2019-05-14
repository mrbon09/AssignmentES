package com.assignment.duy.assignmentes;

import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

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
            }
        });
        return view;
    }

    public void createPDF(){
        //EditText txt = (EditText)getView().findViewById(R.id.choose_feature);
        TextView head = (TextView)getView().findViewById(R.id.heading_s);
        Paragraph paragraph1 = new Paragraph(head.getText().toString());
        Document doc = new Document();
        String outPath = Environment.getExternalStorageDirectory()+"/healthsheet.pdf";
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(outPath));
            doc.open();
            doc.add(paragraph1);
            doc.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
