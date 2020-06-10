package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.FiveWhys;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


public class FiveWhysActivity extends AppCompatActivity {

    public final String ROOT_DIRECTORY = "/storage/emulated/0/AquaSafe/";
    public final String PATTERN_DIRECTORY = "/storage/emulated/0/AquaSafe/";

    EditText problem;
    String cause;
    EditText solution_5whys;
    View end;

    EditText justFive_q1;
    TextView textFive_q1;
    RadioGroup group_q1;

    EditText justFive_q2;
    TextView textFive_q2;
    RadioGroup group_q2;

    EditText justFive_q3;
    TextView textFive_q3;
    RadioGroup group_q3;

    EditText justFive_q4;
    TextView textFive_q4;
    RadioGroup group_q4;

    EditText justFive_q5;
    TextView textFive_q5;
    RadioGroup group_q5;

    EditText justFive_q6;
    TextView textFive_q6;
    RadioGroup group_q6;

    EditText justFive_q7;
    TextView textFive_q7;
    RadioGroup group_q7;

    EditText justFive_q8;
    TextView textFive_q8;
    RadioGroup group_q8;

    TextView root_cause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_whys);
        defaultValues();

        ImageButton help = findViewById(R.id.help_five);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(FiveWhysActivity.this).create();
                alertDialog.setTitle(R.string.five_name);
                alertDialog.setMessage(getResources().getString(R.string.help_five));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        Button confirmProblem = findViewById(R.id.btn_confirm_problem);
        problem = findViewById(R.id.main_problem);
        showQuestions(confirmProblem, problem);

        group_q1 = findViewById(R.id.groupFive_question1);
        justFive_q1 = findViewById(R.id.justFive_q1);
        textFive_q1 = findViewById(R.id.textFive_q1);

        group_q2 = findViewById(R.id.groupFive_question2);
        justFive_q2 = findViewById(R.id.justFive_q2);
        textFive_q2 = findViewById(R.id.textFive_q2);

        group_q3 = findViewById(R.id.groupFive_question3);
        justFive_q3 = findViewById(R.id.justFive_q3);
        textFive_q3 = findViewById(R.id.textFive_q3);

        group_q4 = findViewById(R.id.groupFive_question4);
        justFive_q4 = findViewById(R.id.justFive_q4);
        textFive_q4 = findViewById(R.id.textFive_q4);

        group_q5 = findViewById(R.id.groupFive_question5);
        justFive_q5 = findViewById(R.id.justFive_q5);
        textFive_q5 = findViewById(R.id.textFive_q5);

        justFive_q6 = findViewById(R.id.justFive_q6);
        textFive_q6 = findViewById(R.id.textFive_q6);
        group_q6 = findViewById(R.id.groupFive_question6);

        justFive_q7 = findViewById(R.id.justFive_q7);
        textFive_q7 = findViewById(R.id.textFive_q7);
        group_q7 = findViewById(R.id.groupFive_question7);

        justFive_q8 = findViewById(R.id.justFive_q8);
        textFive_q8 = findViewById(R.id.textFive_q8);
        group_q8 = findViewById(R.id.groupFive_question8);

        testCondition(group_q1,findViewById(R.id.rdbtn1_yes_five), justFive_q1, justFive_q2, textFive_q2, group_q2);
        testCondition(group_q2,findViewById(R.id.rdbtn2_yes_five), justFive_q2, justFive_q3, textFive_q3, group_q3);
        testCondition(group_q3,findViewById(R.id.rdbtn3_yes_five), justFive_q3, justFive_q4, textFive_q4, group_q4);
        testCondition(group_q4,findViewById(R.id.rdbtn4_yes_five), justFive_q4, justFive_q5, textFive_q5, group_q5);
        testCondition(group_q5,findViewById(R.id.rdbtn5_yes_five), justFive_q5, justFive_q6, textFive_q6, group_q6);
        testCondition(group_q6,findViewById(R.id.rdbtn6_yes_five), justFive_q6, justFive_q7, textFive_q7, group_q7);
        testCondition(group_q7,findViewById(R.id.rdbtn7_yes_five), justFive_q7, justFive_q8, textFive_q8, group_q8);
        testFinalCondition(group_q8, justFive_q8);
    }

    private void defaultValues() {
        View questions = findViewById(R.id.questions_five);
        end = findViewById(R.id.end_five);

        questions.setVisibility(View.GONE);
        end.setVisibility(View.GONE);
    }

    private void hideTextEditGroup(EditText editText, TextView textView, RadioGroup group) {
        editText.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);
        group.setVisibility(View.GONE);
    }

    private void showQuestions(Button button, EditText info) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (info.getText().length() == 0){
                    info.setError(getResources().getString(R.string.required_field));
                }
                else {
                    info.setEnabled(false);
                    View questions = findViewById(R.id.questions_five);
                    questions.setVisibility(View.VISIBLE);

                    justFive_q2 = findViewById(R.id.justFive_q2);
                    textFive_q2 = findViewById(R.id.textFive_q2);
                    group_q2 = findViewById(R.id.groupFive_question2);

                    justFive_q3 = findViewById(R.id.justFive_q3);
                    textFive_q3 = findViewById(R.id.textFive_q3);
                    group_q3 = findViewById(R.id.groupFive_question3);

                    justFive_q4 = findViewById(R.id.justFive_q4);
                    textFive_q4 = findViewById(R.id.textFive_q4);
                    group_q4 = findViewById(R.id.groupFive_question4);

                    justFive_q5 = findViewById(R.id.justFive_q5);
                    textFive_q5 = findViewById(R.id.textFive_q5);
                    group_q5 = findViewById(R.id.groupFive_question5);

                    justFive_q6 = findViewById(R.id.justFive_q6);
                    textFive_q6 = findViewById(R.id.textFive_q6);
                    group_q6 = findViewById(R.id.groupFive_question6);

                    justFive_q7 = findViewById(R.id.justFive_q7);
                    textFive_q7 = findViewById(R.id.textFive_q7);
                    group_q7 = findViewById(R.id.groupFive_question7);

                    justFive_q8 = findViewById(R.id.justFive_q8);
                    textFive_q8 = findViewById(R.id.textFive_q8);
                    group_q8 = findViewById(R.id.groupFive_question8);

                    hideTextEditGroup(justFive_q2,textFive_q2,group_q2);
                    hideTextEditGroup(justFive_q3,textFive_q3,group_q3);
                    hideTextEditGroup(justFive_q4,textFive_q4,group_q4);
                    hideTextEditGroup(justFive_q5,textFive_q5,group_q5);
                    hideTextEditGroup(justFive_q6,textFive_q6,group_q6);
                    hideTextEditGroup(justFive_q7,textFive_q7,group_q7);
                    hideTextEditGroup(justFive_q8,textFive_q8,group_q8);
                }

            }
        });
    }

    private void testCondition(RadioGroup actualGroup, RadioButton yesValue, EditText actualEdit, EditText editText, TextView textView, RadioGroup nextGroup){

        root_cause = findViewById(R.id.root_cause);


        actualGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("testCondition","Checked ID:"+checkedId);
                int id = group.getCheckedRadioButtonId();
                if (yesValue.getId() == id){
                    // Yes rules
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        end = findViewById(R.id.end_five);
                        TransitionManager.beginDelayedTransition((ViewGroup) end);
                        nextGroup.setVisibility(View.GONE);
                        editText.setVisibility(View.GONE);
                        textView.setVisibility(View.GONE);

                        end.setVisibility(View.VISIBLE);

                        cause = " ".concat(actualEdit.getText().toString());
                        //Toast.makeText(getApplicationContext(),cause,Toast.LENGTH_SHORT).show();
                        root_cause = findViewById(R.id.root_cause);
                        root_cause.setText(getResources().getString(R.string.root_text).concat(cause));

                        contentEnd();
                    }
                }
                else {
                    // No rules
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        end = findViewById(R.id.end_five);
                        end.setVisibility(View.GONE);

                        editText.setVisibility(View.VISIBLE);
                        textView.setVisibility(View.VISIBLE);
                        nextGroup.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
    }

    private void testFinalCondition(RadioGroup finalGroup, EditText actualEdit) {
        finalGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("testCondition","Checked ID:"+checkedId);
                switch (checkedId){
                    case R.id.rdbtn8_yes_five:
                        // Yes rules
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            end = findViewById(R.id.end_five);
                            TransitionManager.beginDelayedTransition((ViewGroup) end);
                            end.setVisibility(View.VISIBLE);

                            cause = " ".concat(actualEdit.getText().toString());
                            //Toast.makeText(getApplicationContext(),cause,Toast.LENGTH_SHORT).show();
                            root_cause = findViewById(R.id.root_cause);
                            root_cause.setText(getResources().getString(R.string.root_text).concat(cause));

                            contentEnd();
                        }
                        break;
                    case R.id.rdbtn8_no_five:
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.review_method), Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

    }

    private File createDirectory() {
        Log.d("File Created","Directory created.");
        File root = new File(ROOT_DIRECTORY);
        root.mkdir();
        String check_name = getResources().getString(R.string.five_name);
        File dir = new File(PATTERN_DIRECTORY.concat(check_name+"/"));
        dir.mkdir();
        return dir;
    }

    private void contentEnd() {
        Button share = findViewById(R.id.btnSharePDF);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissoesHandler permissoes = new PermissoesHandler(FiveWhysActivity.this);
                if (permissoes.verifyFilePermission()) {
                    createDirectory();
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

//            intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:/" + file.getPath()));
            Uri fileURI = FileProvider.getUriForFile(FiveWhysActivity.this,BuildConfig.APPLICATION_ID+".provider",file);
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

        EditText problem = findViewById(R.id.main_problem);

        String check_name = getResources().getString(R.string.five_name);
        String dest = PATTERN_DIRECTORY.concat(check_name+"/")+getResources().getString(R.string.five_name)+"-"+currentTime+".pdf";
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.five_name), mTitleFont);
            Paragraph mTitleParagraph = new Paragraph(mTitleChunk);
            mTitleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(mTitleParagraph);

            // Adding Chunks for Title and value
            Font mProblemFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mProblemChunk = new Chunk(getResources().getString(R.string.problem), mProblemFont);
            Paragraph mProblemParagraph = new Paragraph(mProblemChunk);
            document.add(mProblemParagraph);

            Font mProblemValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mProblemValueChunk = new Chunk(problem.getText().toString(), mProblemValueFont);
            Paragraph mProblemValueParagraph = new Paragraph(mProblemValueChunk);
            document.add(mProblemValueParagraph);

            // Adding Line Breakable Space....
            document.add(new Paragraph(""));
            // Adding Horizontal Line...
            document.add(new Chunk(lineSeparator));
            // Adding Line Breakable Space....
            document.add(new Paragraph(""));

            solution_5whys = findViewById(R.id.solution_5whys);
            String solution = solution_5whys.getText().toString();
            if (solution.isEmpty()){
                solution = "NA";
            }

            addDetails(document, root_cause.getText().toString(), solution);

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

    private void addDetails(Document doc, String root_cause, String just) throws DocumentException {

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

        Font mRootCauseFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
        Chunk mRootCauseChunk = new Chunk(getResources().getString(R.string.root_text), mRootCauseFont);
        Paragraph mRootCauseParagraph = new Paragraph(mRootCauseChunk);
        doc.add(mRootCauseParagraph);

        Font mRootCauseValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
        Chunk mRootCauseValueChunk = new Chunk(root_cause, mRootCauseValueFont);
        Paragraph mRootCauseValueParagraph = new Paragraph(mRootCauseValueChunk);
        doc.add(mRootCauseValueParagraph);

        doc.add(new Paragraph(""));
        doc.add(new Chunk(lineSeparator));
        doc.add(new Paragraph(""));

        Font mJustFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
        Chunk mJustChunk = new Chunk(getResources().getString(R.string.solution), mJustFont);
        Paragraph mJustParagraph = new Paragraph(mJustChunk);
        doc.add(mJustParagraph);

        Font mJustValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
        Chunk mJustValueChunk = new Chunk(just, mJustValueFont);
        Paragraph mJustValueParagraph = new Paragraph(mJustValueChunk);
        doc.add(mJustValueParagraph);

        doc.add(new Paragraph(""));
        doc.add(new Chunk(lineSeparator));
        doc.add(new Paragraph(""));
    }
}
