package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistWorkers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.EmptyStackException;


import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.BuildConfig;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.PermissoesHandler;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;
import static br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.LogUtils.LOGE;
import static br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.LogUtils.LOGD;


public class WorkersActivity extends AppCompatActivity {

    public final String ROOT_DIRECTORY = "/storage/emulated/0/AquaSafe/";
    public final String PATTERN_DIRECTORY = "/storage/emulated/0/AquaSafe/";

    public static final String SEPARATOR = ";";

    EditText txtResponsable;
    EditText txtData;

    Button btnShareCSV;
    Button btnSharePDF;

    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;

    String justWorker1;
    String justWorker2;
    String justWorker3;
    String justWorker4;
    String justWorker5;

    Calendar calendar;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_worker_checklist);

        defaultValues();
        txtData = findViewById(R.id.dateInspection);

        txtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(WorkersActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        String format_data = mDay +"-" + (mMonth+1)+ "-" + mYear;
                        txtData.setText(format_data);
                    }
                }, day, month, year);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
        txtResponsable = findViewById(R.id.responsable);

//        onRadioButtonClickedWorker1();
//        onRadioButtonClickedWorker2();
//        onRadioButtonClickedWorker3();
//        onRadioButtonClickedWorker4();
//        onRadioButtonClickedWorker5();

        contentEnd();

    }

    private void defaultValues() {
        EditText just_q1 = findViewById(R.id.justWorker_q1);
        EditText just_q2 = findViewById(R.id.justWorker_q2);
        EditText just_q3 = findViewById(R.id.justWorker_q3);
        EditText just_q4 = findViewById(R.id.justWorker_q4);
        EditText just_q5 = findViewById(R.id.justWorker_q5);

        just_q1.setVisibility(View.GONE);
        just_q2.setVisibility(View.GONE);
        just_q3.setVisibility(View.GONE);
        just_q4.setVisibility(View.GONE);
        just_q5.setVisibility(View.GONE);
    }

    public void contentEnd(){
        btnShareCSV = findViewById(R.id.btnShareCSV);
        btnSharePDF = findViewById(R.id.btnSharePDF);
        onRadioButtonClickedWorker1();
        onRadioButtonClickedWorker2();
        onRadioButtonClickedWorker3();
        onRadioButtonClickedWorker4();
        onRadioButtonClickedWorker5();

        btnShareCSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissoesHandler permissoes = new PermissoesHandler(WorkersActivity.this);
                    if (permissoes.verifyFilePermission()) {
                        try {
                            checkRadios();

                            if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                txtData.setError(getResources().getString(R.string.required_field));
                                txtResponsable.setError(getResources().getString(R.string.required_field));
                            } else {
                                txtData.setError(null);
                                txtResponsable.setError(null);
                                createDirectory();
                                exportWorkerCSV();
                            }
                        } catch (NullPointerException e) {
                            Toast.makeText(getApplicationContext(),"Check if you select all radio buttons.", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        permissoes.askPermissionFile();
                    }
                }
        });

        btnSharePDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissoesHandler permissoes = new PermissoesHandler(WorkersActivity.this);
                    if (permissoes.verifyFilePermission()) {
                        try {
                            checkRadios();

                            if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                txtData.setError(getResources().getString(R.string.required_field));
                                txtResponsable.setError(getResources().getString(R.string.required_field));
                                checkRadios();
                            } else {
                                txtData.setError(null);
                                txtResponsable.setError(null);
                                checkRadios();
                                createDirectory();
                                exportWorkerPDF();
                            }

                        } catch (NullPointerException e) {
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        permissoes.askPermissionFile();
                    }

            }
        });

    }

    public void checkRadios() {
        RadioGroup group1 = findViewById(R.id.groupWorker_question1);
        RadioButton radioButton1 = findViewById(R.id.rdbtn1_no);
        checkMissingRadio(group1, radioButton1);
        RadioGroup group2 = findViewById(R.id.groupWorker_question2);
        RadioButton radioButton2 = findViewById(R.id.rdbtn2_no);
        checkMissingRadio(group2, radioButton2);
        RadioGroup group3 = findViewById(R.id.groupWorker_question3);
        RadioButton radioButton3 = findViewById(R.id.rdbtn3_no);
        checkMissingRadio(group3, radioButton3);
        RadioGroup group4 = findViewById(R.id.groupWorker_question4);
        RadioButton radioButton4 = findViewById(R.id.rdbtn4_no);
        checkMissingRadio(group4, radioButton4);
        RadioGroup group5 = findViewById(R.id.groupWorker_question5);
        RadioButton radioButton5 = findViewById(R.id.rdbtn5_no);
        checkMissingRadio(group5, radioButton5);
    }

    private boolean checkMissingRadio(RadioGroup radioGroup, RadioButton radioButton) {
        boolean checked = false;
        if (radioGroup.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            //Toast.makeText(getApplicationContext(),"Check if you select all radio buttons.", Toast.LENGTH_SHORT).show();
            radioButton.setError("Missing this..");
            checked = false;
        }
        else
        {
            // one of the radio buttons is checked
            //Toast.makeText(getApplicationContext(),"Processing...", Toast.LENGTH_SHORT).show();
            radioButton.setError(null);
            checked = true;
        }
        return checked;
    }

    private File createDirectory() {
        Log.d("File Created","Directory created.");
        File root = new File(ROOT_DIRECTORY);
        root.mkdir();
        String check_name = getResources().getString(R.string.worker_name);
        File dir = new File(PATTERN_DIRECTORY.concat(check_name+"/"));
        dir.mkdir();
        return dir;
    }

    private void exportWorkerCSV() {
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustDivingQ1 = findViewById(R.id.justWorker_q1);
        EditText txtJustDivingQ2 = findViewById(R.id.justWorker_q2);
        EditText txtJustDivingQ3 = findViewById(R.id.justWorker_q3);
        EditText txtJustDivingQ4 = findViewById(R.id.justWorker_q4);
        EditText txtJustDivingQ5 = findViewById(R.id.justWorker_q5);
        justWorker1 = checkJust(txtJustDivingQ1);
        justWorker2 = checkJust(txtJustDivingQ2);
        justWorker3 = checkJust(txtJustDivingQ3);
        justWorker4 = checkJust(txtJustDivingQ4);
        justWorker5 = checkJust(txtJustDivingQ5);

        Log.d("Values:","D:"+data+", R:"+responsable);
        String fileName = responsable.replace(" ", "").toLowerCase() + "-" +data+ ".csv";
        File directory = createDirectory();
        File file = new File(directory, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(R.string.worker_name)+": Dados\n")
                .append(getResources().getString(R.string.inspection_data)).append(SEPARATOR).append(data).append(SEPARATOR).append("\n")
                .append(getResources().getString(R.string.responsable)).append(SEPARATOR).append(responsable).append(SEPARATOR).append("\n");

        stringBuilder.append("PERGUNTA;RESPOSTA;AÇÃO CORRETIVA;\n")
                .append(getResources().getString(R.string.worker_q1)).append(SEPARATOR).append(answer1).append(SEPARATOR).append(justWorker1).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.worker_q2)).append(SEPARATOR).append(answer2).append(SEPARATOR).append(justWorker2).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.worker_q3)).append(SEPARATOR).append(answer3).append(SEPARATOR).append(justWorker3).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.worker_q4)).append(SEPARATOR).append(answer4).append(SEPARATOR).append(justWorker4).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.worker_q5)).append(SEPARATOR).append(answer5).append(SEPARATOR).append(justWorker5).append(SEPARATOR+"\n").append("\n");

        try {
            Log.d("StringBuilder:".concat("\n"),stringBuilder.toString());
            Files.asCharSink(file, Charsets.UTF_8).write(stringBuilder.toString());
            createExportDialog(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Falha ao salvar arquivo " + file.getPath(), Toast.LENGTH_LONG).show();
        }


    }

    public void onRadioButtonClickedWorker1() {
        final RadioGroup group_question = findViewById(R.id.groupWorker_question1);
        final EditText just = findViewById(R.id.justWorker_q1);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q1:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn1_yes:
                        Log.d("YES","YES Q1:"+R.id.rdbtn1_yes);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer1 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn1_no:
                        Log.d("NO","NO Q1:"+R.id.rdbtn1_no);
                        // No rules
                        answer1 = getResources().getString(R.string.no_rdbtn);
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWorker_question1));
//                            just.setVisibility(View.VISIBLE);
//                        }
                        just.setVisibility(View.VISIBLE);

                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWorker2() {
        final RadioGroup group_question = findViewById(R.id.groupWorker_question2);
        final EditText just = findViewById(R.id.justWorker_q2);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q2:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn2_yes:
                        Log.d("YES","YES Q2:"+R.id.rdbtn2_yes);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer2 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn2_no:
                        Log.d("NO","NO Q2:"+R.id.rdbtn2_no);
                        // No rules
                        answer2 = getResources().getString(R.string.no_rdbtn);
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWorker_question2));
//                            just.setVisibility(View.VISIBLE);
//                        }
                        just.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWorker3() {
        final RadioGroup group_question = findViewById(R.id.groupWorker_question3);
        final EditText just = findViewById(R.id.justWorker_q3);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q3:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn3_yes:
                        Log.d("YES","YES Q3:"+R.id.rdbtn3_yes);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer3 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn3_no:
                        Log.d("NO","NO Q3:"+R.id.rdbtn3_no);
                        // No rules
                        answer3 = getResources().getString(R.string.no_rdbtn);
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWorker_question3));
//                            just.setVisibility(View.VISIBLE);
//                        }
                        just.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWorker4() {
        final RadioGroup group_question = findViewById(R.id.groupWorker_question4);
        final EditText just = findViewById(R.id.justWorker_q4);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q4:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn4_yes:
                        Log.d("YES","YES Q4:"+R.id.rdbtn4_yes);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer4 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn4_no:
                        Log.d("NO","NO Q4:"+R.id.rdbtn4_no);
                        // No rules
                        answer4 = getResources().getString(R.string.no_rdbtn);
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWorker_question4));
//                            just.setVisibility(View.VISIBLE);
//                        }
                        just.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWorker5() {
        final RadioGroup group_question = findViewById(R.id.groupWorker_question5);
        final EditText just = findViewById(R.id.justWorker_q5);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q5:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn5_yes:
                        Log.d("YES","YES Q5:"+R.id.rdbtn5_yes);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer5 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no:
                        Log.d("NO","NO Q5:"+R.id.rdbtn5_no);
                        // No rules
                        answer5 = getResources().getString(R.string.no_rdbtn);
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWorker_question5));
//                            just.setVisibility(View.VISIBLE);
//                        }
                        just.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    private String checkJust(EditText editText) {
        String corrective_action = editText.getText().toString();
        Log.d("PRECHECK JUST ",corrective_action);
        try{
            if (corrective_action.isEmpty()){
                corrective_action = "NA";
            }
        } catch (EmptyStackException e){
            e.printStackTrace();
        }
        Log.d("POSCHECK JUST ",corrective_action);
        return corrective_action;
    }

    public void shareCSV(File file) {
        Intent intentShareFile = new Intent(Intent.ACTION_SEND);
        if (file.exists()) {
            intentShareFile.setType("application/csv");
//            intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:/" + file.getPath()));
            Uri fileURI = FileProvider.getUriForFile(WorkersActivity.this,BuildConfig.APPLICATION_ID+".provider",file);
            intentShareFile.putExtra(Intent.EXTRA_STREAM, fileURI);
            String assunto = "Checklist Trabalhador de " + txtResponsable.getText().toString();
            intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                    assunto);
            intentShareFile.putExtra(Intent.EXTRA_TEXT, file.getName());

            startActivity(Intent.createChooser(intentShareFile, getResources().getString(R.string.export_csv_file)));
        }
    }

    public void sharePDF(File file) {
        Intent intentShareFile = new Intent(Intent.ACTION_SEND);
        if (file.exists()) {
            intentShareFile.setType("application/pdf");

//            intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:/" + file.getPath()));
            Uri fileURI = FileProvider.getUriForFile(WorkersActivity.this,BuildConfig.APPLICATION_ID+".provider",file);
            intentShareFile.putExtra(Intent.EXTRA_STREAM, fileURI);
            String assunto = "Checklist Trabalhadores de " + txtResponsable.getText().toString();
            intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                    assunto);
            intentShareFile.putExtra(Intent.EXTRA_TEXT, file.getName());

            startActivity(Intent.createChooser(intentShareFile, getResources().getString(R.string.export_pdf_file)));
        }
    }

    private void createExportDialog(final File file) {
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
                shareCSV(file);
                dialog.dismiss();
            }
        });
        dialog.show();
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

    public void exportWorkerPDF() {

        // Data
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustQ1 = findViewById(R.id.justWorker_q1);
        EditText txtJustQ2 = findViewById(R.id.justWorker_q2);
        EditText txtJustQ3 = findViewById(R.id.justWorker_q3);
        EditText txtJustQ4 = findViewById(R.id.justWorker_q4);
        EditText txtJustQ5 = findViewById(R.id.justWorker_q5);
        justWorker1 = checkJust(txtJustQ1);
        justWorker2 = checkJust(txtJustQ2);
        justWorker3 = checkJust(txtJustQ3);
        justWorker4 = checkJust(txtJustQ4);
        justWorker5 = checkJust(txtJustQ5);

        String check_name = getResources().getString(R.string.worker_name);
        String dest = PATTERN_DIRECTORY.concat(check_name+"/")+responsable.replace(" ", "").toLowerCase() + "-" +data+ ".pdf";
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
            document.addAuthor(responsable);
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.worker_name), mTitleFont);
            Paragraph mTitleParagraph = new Paragraph(mTitleChunk);
            mTitleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(mTitleParagraph);

            // Adding Chunks for Title and value
            Font mResponsableFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mResponsableChunk = new Chunk(getResources().getString(R.string.responsable), mResponsableFont);
            Paragraph mResponsableParagraph = new Paragraph(mResponsableChunk);
            document.add(mResponsableParagraph);

            Font mResponsableValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mResponsableValueChunk = new Chunk(responsable, mResponsableValueFont);
            Paragraph mResponsableValueParagraph = new Paragraph(mResponsableValueChunk);
            document.add(mResponsableValueParagraph);

            // Adding Line Breakable Space....
            document.add(new Paragraph(""));
            // Adding Horizontal Line...
            document.add(new Chunk(lineSeparator));
            // Adding Line Breakable Space....
            document.add(new Paragraph(""));

            // Fields of Checklists Details...
            Font mDateFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mDateChunk = new Chunk(getResources().getString(R.string.inspection_data), mDateFont);
            Paragraph mDateParagraph = new Paragraph(mDateChunk);
            document.add(mDateParagraph);

            Font mDateValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mDateValueChunk = new Chunk(data, mDateValueFont);
            Paragraph mDateValueParagraph = new Paragraph(mDateValueChunk);
            document.add(mDateValueParagraph);

            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            addQuestions(document,getResources().getString(R.string.worker_q1),answer1,justWorker1);
            addQuestions(document,getResources().getString(R.string.worker_q2),answer2,justWorker2);
            addQuestions(document,getResources().getString(R.string.worker_q3),answer3,justWorker3);
            addQuestions(document,getResources().getString(R.string.worker_q4),answer4,justWorker4);
            addQuestions(document,getResources().getString(R.string.worker_q5),answer5,justWorker5);

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

    private void addQuestions(Document doc, String question, String answer, String justWorker) throws DocumentException {
        /***
         * Variables for further use....
         */
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
        Font mQuestionWorker1Font = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
        Chunk mQuestionWorker1Chunk = new Chunk(question, mQuestionWorker1Font);
        Paragraph mQuestionWorker1Paragraph = new Paragraph(mQuestionWorker1Chunk);
        doc.add(mQuestionWorker1Paragraph);

        Font mQuestionWorker1ValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
        Chunk mQuestionWorker1ValueChunk = new Chunk(answer, mQuestionWorker1ValueFont);
        Paragraph mQuestionWorker1ValueParagraph = new Paragraph(mQuestionWorker1ValueChunk);
        doc.add(mQuestionWorker1ValueParagraph);

        Font mJustWorker1ValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
        Chunk mJustWorker1ValueChunk = new Chunk(justWorker, mJustWorker1ValueFont);
        Paragraph mJustWorker1ValueParagraph = new Paragraph(mJustWorker1ValueChunk);
        doc.add(mJustWorker1ValueParagraph);

        doc.add(new Paragraph(""));
        doc.add(new Chunk(lineSeparator));
        doc.add(new Paragraph(""));
    }
}