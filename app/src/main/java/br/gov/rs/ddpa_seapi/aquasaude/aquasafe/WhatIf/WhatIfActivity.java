package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.WhatIf;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.BuildConfig;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.PermissoesHandler;

import static br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.LogUtils.LOGE;

public class WhatIfActivity extends AppCompatActivity {

    public final String ROOT_DIRECTORY = "/storage/emulated/0/AquaSafe/";
    public final String PATTERN_DIRECTORY = "/storage/emulated/0/AquaSafe/";

    Button confirm_activity;
    Button confirm_question;
    Button confirm_cause;
    Button confirm_consequences;
    Button confirm_measures;

    TextInputEditText edit_activity_what;
    TextInputEditText edit_question_what;
    TextInputEditText edit_cause_what;
    TextInputEditText edit_consequences_what;
    TextInputEditText edit_measures_what;

    TextView text_activity;
    TextView text_question;
    TextView text_cause;
    TextView text_consequences;
    TextView text_measures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_if);
        defaultValues(findViewById(R.id.txt_question_what), findViewById(R.id.txtInput_question_what),findViewById(R.id.btn_confirm_question));
        defaultValues(findViewById(R.id.txt_cause_what), findViewById(R.id.txtInput_cause_what),findViewById(R.id.btn_confirm_cause));
        defaultValues(findViewById(R.id.txt_consequences_what), findViewById(R.id.txtInput_consequences_what),findViewById(R.id.btn_confirm_consequences));
        defaultValues(findViewById(R.id.txt_measures_what), findViewById(R.id.txtInput_measures_what),findViewById(R.id.btn_confirm_measures));

        edit_activity_what = findViewById(R.id.edit_activity_what);
        edit_activity_what.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        edit_question_what = findViewById(R.id.edit_question_what);
        edit_question_what.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        edit_cause_what = findViewById(R.id.edit_cause_what);
        edit_cause_what.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        edit_consequences_what = findViewById(R.id.edit_consequences_what);
        edit_consequences_what.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        edit_measures_what = findViewById(R.id.edit_measures_what);
        edit_measures_what.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);

        ImageButton help = findViewById(R.id.help_what_if);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(WhatIfActivity.this).create();
                alertDialog.setTitle(R.string.what_if);
                alertDialog.setMessage(getResources().getString(R.string.help_what_if));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        confirm_activity = findViewById(R.id.btn_confirm_activity);
        confirm_question = findViewById(R.id.btn_confirm_question);
        confirm_cause = findViewById(R.id.btn_confirm_cause);
        confirm_consequences = findViewById(R.id.btn_confirm_consequences);
        confirm_measures = findViewById(R.id.btn_confirm_measures);

        text_activity = findViewById(R.id.activity_what);
        text_question = findViewById(R.id.question_what);
        text_cause = findViewById(R.id.cause_what);
        text_consequences = findViewById(R.id.consequences_what);
        text_measures = findViewById(R.id.measures_what);

        confirm_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_activity_what.getText().length() == 0){
                    edit_activity_what.setText("NA");
                } else
                    showNext(findViewById(R.id.txt_question_what), findViewById(R.id.txtInput_question_what),findViewById(R.id.btn_confirm_question));
            }
        });

        confirm_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_question_what.getText().length() == 0){
                    edit_question_what.setText("NA");
                } else
                    showNext(findViewById(R.id.txt_cause_what), findViewById(R.id.txtInput_cause_what),findViewById(R.id.btn_confirm_cause));
            }
        });

        confirm_cause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_cause_what.getText().length() == 0){
                    edit_cause_what.setText("NA");
                } else
                    showNext(findViewById(R.id.txt_consequences_what), findViewById(R.id.txtInput_consequences_what),findViewById(R.id.btn_confirm_consequences));
                }
        });

        confirm_consequences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_consequences_what.getText().length() == 0){
                    edit_consequences_what.setText("NA");
                } else
                    showNext(findViewById(R.id.txt_measures_what), findViewById(R.id.txtInput_measures_what),findViewById(R.id.btn_confirm_measures));
            }
        });

        confirm_measures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_measures_what.getText().length() == 0){
                    edit_measures_what.setText("NA");
                } else {
                    String activity, question, cause, consequences, measures;
                    // Get text from editText to String
                    activity = edit_activity_what.getText().toString();
                    question = edit_question_what.getText().toString();
                    cause = edit_cause_what.getText().toString();
                    consequences = edit_consequences_what.getText().toString();
                    measures = edit_measures_what.getText().toString();

                    View end = findViewById(R.id.end_what);
                    end.setVisibility(View.VISIBLE);
                    end.requestFocus();
                    end.setFocusableInTouchMode(true);
                    end.setFocusable(true);

                    // Set text to TextView
                    text_activity.setText(getResources().getString(R.string.activity_what).concat(": \n" + activity + "\n"));
                    text_question.setText(getResources().getString(R.string.question_what).concat(": \n" + question + "\n"));
                    text_cause.setText(getResources().getString(R.string.cause_what).concat(": \n" + cause + "\n"));
                    text_consequences.setText(getResources().getString(R.string.consequences_what).concat(": \n" + consequences + "\n"));
                    text_measures.setText(getResources().getString(R.string.measures_what).concat(": \n" + measures + "\n"));
                }
            }
        });

        contentEnd();
    }

    private void defaultValues(TextView textView, TextInputLayout textInputLayout, Button button) {
        textView.setVisibility(View.GONE);
        textInputLayout.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        View end = findViewById(R.id.end_what);
        end.setVisibility(View.GONE);
    }

    private void showNext(TextView textView, TextInputLayout textInputLayout, Button button) {
        textView.setVisibility(View.VISIBLE);
        textInputLayout.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
    }

    private File createDirectory() {
        Log.d("File Created","Directory created.");
        File root = new File(ROOT_DIRECTORY);
        root.mkdir();
        String check_name = getResources().getString(R.string.question_what);
        File dir = new File(PATTERN_DIRECTORY.concat(check_name+"/"));
        dir.mkdir();
        return dir;
    }

    private void contentEnd() {
        Button share = findViewById(R.id.btnShareWhatPDF);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissoesHandler permissoes = new PermissoesHandler(WhatIfActivity.this);
                if (permissoes.verifyFilePermission()) {
                    createDirectory();
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.processing),Toast.LENGTH_SHORT).show();
                    exportPDF();
                } else {
                    permissoes.askPermissionFile();
                }
            }
        });
    }

    public void sharePDF(File file) {
        Intent intentShareFile = new Intent(Intent.ACTION_SEND);
        if (file.exists()) {
            intentShareFile.setType("application/pdf");
            Uri fileURI = FileProvider.getUriForFile(WhatIfActivity.this,BuildConfig.APPLICATION_ID+".provider",file);
            intentShareFile.putExtra(Intent.EXTRA_STREAM, fileURI);
            String assunto = getResources().getString(R.string.five_name);
            intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                    assunto);
            intentShareFile.putExtra(Intent.EXTRA_TEXT, file.getName());

            startActivity(Intent.createChooser(intentShareFile, getResources().getString(R.string.export_pdf_file)));
        }
    }

    private void createExportPDFDialog(final File file) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_export);

        View btAparelho = dialog.findViewById(R.id.layout_device);
        View btShare = dialog.findViewById(R.id.layout_share);

        btAparelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "O arquivo foi salvo em: " + file.getPath(), Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePDF(file);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void exportPDF() {
        String currentTime = String.valueOf(Calendar.getInstance().getTime());

        String check_name = getResources().getString(R.string.question_what);
        String dest = PATTERN_DIRECTORY.concat(check_name+"/")+getResources().getString(R.string.question_what)+"-"+currentTime+".pdf";
        if (new File(dest).exists()) {
            new File(dest).delete();
        }

        try {
            /**
             * Creating Document
             */
            Document document = new Document();

            // Location to save
            PdfWriter.getInstance(document, new FileOutputStream(dest));

            // Open to write
            document.open();

            // Document Settings
            document.setPageSize(PageSize.A4);
            document.addCreationDate();
            document.addAuthor("AquaSafe");
            document.addCreator("AquaSafe");

            /***
             * Variables for further use....
             */
            BaseColor mColorAccent = new BaseColor(0, 153, 204, 255);
            float mHeadingFontSize = 10.0f;
            float mValueFontSize = 16.0f;

            /**
             * How to USE FONT....
             */
            BaseFont urName = BaseFont.createFont("assets/fonts/didactGothic-Regular.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            // LINE SEPARATOR
            LineSeparator lineSeparator = new LineSeparator();
            lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

            // Checklist Details...

            // Adding Description...
            Font mDescriptionFont = new Font(urName,mHeadingFontSize,Font.NORMAL, mColorAccent);
            Chunk mDescriptionChunk = new Chunk(getResources().getString(R.string.license), mDescriptionFont);
            Paragraph mDescriptionParagraph = new Paragraph(mDescriptionChunk);
            mDescriptionParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(mDescriptionParagraph);

            // Adding Title....
            Font mTitleFont = new Font(urName, 26.0f, Font.NORMAL, BaseColor.BLACK);
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.question_what), mTitleFont);
            Paragraph mTitleParagraph = new Paragraph(mTitleChunk);
            mTitleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(mTitleParagraph);



            // Adding Line Breakable Space....
            document.add(new Paragraph(""));
            // Adding Horizontal Line...
            document.add(new Chunk(lineSeparator));
            // Adding Line Breakable Space....
            document.add(new Paragraph(""));

            addDetails(document, text_activity);
            addDetails(document, text_question);
            addDetails(document, text_cause);
            addDetails(document, text_consequences);
            addDetails(document, text_measures);

            document.close();

            //Toast.makeText(getApplicationContext(), "Criado :)", Toast.LENGTH_SHORT).show();
            File file = new File(dest);
            Files.asCharSink(file, Charsets.UTF_8);
            createExportPDFDialog(file);

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Erro " + ie.getLocalizedMessage());
            LOGE("dir: "+dest);
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Nenhuma aplicação encontrada para abrir este arquivo.", Toast.LENGTH_SHORT).show();
        }
    }

    private void addDetails(Document doc, TextView title) throws DocumentException {

        BaseColor mColorAccent = new BaseColor(0, 153, 204, 255);
        float mHeadingFontSize = 10.0f;
        float mValueFontSize = 16.0f;

        /**
         * How to USE FONT....
         */
        BaseFont urName = null;
        try {
            urName = BaseFont.createFont("assets/fonts/didactGothic-Regular.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // LINE SEPARATOR
        LineSeparator lineSeparator = new LineSeparator();
        lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

        Font mRootCauseValueFont = new Font(urName, mValueFontSize, Font.NORMAL, mColorAccent);
        String value_title = title.getText().toString();
        Chunk mRootCauseValueChunk = new Chunk(value_title, mRootCauseValueFont);
        Paragraph mRootCauseValueParagraph = new Paragraph(mRootCauseValueChunk);
        doc.add(mRootCauseValueParagraph);

        doc.add(new Paragraph(""));
        doc.add(new Chunk(lineSeparator));
        doc.add(new Paragraph(""));
    }

}
