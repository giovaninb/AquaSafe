package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistManagement;

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
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.PermissoesHandler;

import static br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.LogUtils.LOGE;

public class ActivityOne extends AppCompatActivity {

    public final String ROOT_DIRECTORY = "/storage/emulated/0/AquaSafe/ChecklistsGerenciamento/";
    public static final String PATTERN_DIRECTORY = "/storage/emulated/0/AquaSafe/ChecklistsGerenciamento/";
    public static final String SEPARATOR = ";";

    EditText txtResponsable;
    EditText txtData;

    Button btnShareCSV;
    Button btnSharePDF;

    String answer1, answer2, answer3, answer4, answer5, answer6, answer7;

    String justDiving1, justDiving2, justDiving3, justDiving4, justDiving5;
    String justProtection1, justProtection2, justProtection3, justProtection4, justProtection5, justProtection6;
    String justMachines1, justMachines2, justMachines3, justMachines4, justMachines5, justMachines6, justMachines7;
    String justEletrical1, justEletrical2, justEletrical3, justEletrical4, justEletrical5, justEletrical6, justEletrical7;
    String justBoating1, justBoating2, justBoating3, justBoating4, justBoating5, justBoating6;
    String justChemicals1, justChemicals2, justChemicals3, justChemicals4, justChemicals5;
    String justWomens1, justWomens2, justWomens3, justWomens4, justWomens5, justWomens6;

    Calendar calendar;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String tag = getIntent().getStringExtra("tag");
        createDirectory(getResources().getString(R.string.diving_name));
        createDirectory(getResources().getString(R.string.protection_name));
        createDirectory(getResources().getString(R.string.machines_name));
        createDirectory(getResources().getString(R.string.eletrical_name));
        createDirectory(getResources().getString(R.string.boating_name));
        createDirectory(getResources().getString(R.string.chemicals_name));
        createDirectory(getResources().getString(R.string.womens_name));
        switch (tag) {
            case "diving":
                // Diving Checklist
                if (getIntent() != null) {
                    setContentView(R.layout.activity_diving_checklist);
                    defaultValuesDiving();

                    txtData = findViewById(R.id.dateInspection);
                    txtData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int month = calendar.get(Calendar.MONTH);
                            int year = calendar.get(Calendar.YEAR);

                            datePickerDialog = new DatePickerDialog(ActivityOne.this, new DatePickerDialog.OnDateSetListener() {
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
                    onRadioButtonClickedDiving1();
                    onRadioButtonClickedDiving2();
                    onRadioButtonClickedDiving3();
                    onRadioButtonClickedDiving4();
                    onRadioButtonClickedDiving5();
                    contentEnd(tag);
                }

                break;
            case "protection":
                // Protection Equipament Checklist
                if (getIntent() != null) {
                    setContentView(R.layout.activity_protection_checklist);
                    defaultValuesProtection();

                    txtData = findViewById(R.id.dateInspection);
                    txtData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int month = calendar.get(Calendar.MONTH);
                            int year = calendar.get(Calendar.YEAR);

                            datePickerDialog = new DatePickerDialog(ActivityOne.this, new DatePickerDialog.OnDateSetListener() {
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
                    onRadioButtonClickedProtection1();
                    onRadioButtonClickedProtection2();
                    onRadioButtonClickedProtection3();
                    onRadioButtonClickedProtection4();
                    onRadioButtonClickedProtection5();
                    onRadioButtonClickedProtection6();
                    contentEnd(tag);
                }
                break;
            case "machines":
                if (getIntent() != null) {
                    // Machines and Equipment Checklist
                    setContentView(R.layout.activity_machines_checklist);
                    defaultValuesMachines();

                    txtData = findViewById(R.id.dateInspection);
                    txtData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int month = calendar.get(Calendar.MONTH);
                            int year = calendar.get(Calendar.YEAR);

                            datePickerDialog = new DatePickerDialog(ActivityOne.this, new DatePickerDialog.OnDateSetListener() {
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
                    onRadioButtonClickedMachines1();
                    onRadioButtonClickedMachines2();
                    onRadioButtonClickedMachines3();
                    onRadioButtonClickedMachines4();
                    onRadioButtonClickedMachines5();
                    onRadioButtonClickedMachines6();
                    onRadioButtonClickedMachines7();
                    contentEnd(tag);
                }
                break;
            case "eletrical":
                if (getIntent() != null) {
                    // Eletrical Checklist
                    setContentView(R.layout.activity_eletrical_checklist);
                    defaultValuesEletrical();

                    txtData = findViewById(R.id.dateInspection);
                    txtData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int month = calendar.get(Calendar.MONTH);
                            int year = calendar.get(Calendar.YEAR);

                            datePickerDialog = new DatePickerDialog(ActivityOne.this, new DatePickerDialog.OnDateSetListener() {
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
                    onRadioButtonClickedEletrical1();
                    onRadioButtonClickedEletrical2();
                    onRadioButtonClickedEletrical3();
                    onRadioButtonClickedEletrical4();
                    onRadioButtonClickedEletrical5();
                    onRadioButtonClickedEletrical6();
                    onRadioButtonClickedEletrical7();
                    contentEnd(tag);

                }
                break;
            case "boating":
                if (getIntent() != null) {
                    // Boating Checklist
                    setContentView(R.layout.activity_boating_checklist);
                    defaultValuesBoating();

                    txtData = findViewById(R.id.dateInspection);
                    txtData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int month = calendar.get(Calendar.MONTH);
                            int year = calendar.get(Calendar.YEAR);

                            datePickerDialog = new DatePickerDialog(ActivityOne.this, new DatePickerDialog.OnDateSetListener() {
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
                    onRadioButtonClickedBoating1();
                    onRadioButtonClickedBoating2();
                    onRadioButtonClickedBoating3();
                    onRadioButtonClickedBoating4();
                    onRadioButtonClickedBoating5();
                    onRadioButtonClickedBoating6();
                    contentEnd(tag);
                }
                break;
            case "chemicals":
                if (getIntent() != null) {
                    // Chemicals Checklist
                    setContentView(R.layout.activity_chemicals_checklist);
                    defaultValuesChemicals();

                    txtData = findViewById(R.id.dateInspection);
                    txtData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int month = calendar.get(Calendar.MONTH);
                            int year = calendar.get(Calendar.YEAR);

                            datePickerDialog = new DatePickerDialog(ActivityOne.this, new DatePickerDialog.OnDateSetListener() {
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
                    onRadioButtonClickedChemicals1();
                    onRadioButtonClickedChemicals2();
                    onRadioButtonClickedChemicals3();
                    onRadioButtonClickedChemicals4();
                    onRadioButtonClickedChemicals5();
                    contentEnd(tag);


                }
                break;
            case "womens":
                if (getIntent() != null) {
                    // Womens Health Checklist
                    setContentView(R.layout.activity_womens_checklist);
                    defaultValuesWomens();

                    txtData = findViewById(R.id.dateInspection);
                    txtData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            int month = calendar.get(Calendar.MONTH);
                            int year = calendar.get(Calendar.YEAR);

                            datePickerDialog = new DatePickerDialog(ActivityOne.this, new DatePickerDialog.OnDateSetListener() {
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
                    onRadioButtonClickedWomens1();
                    onRadioButtonClickedWomens2();
                    onRadioButtonClickedWomens3();
                    onRadioButtonClickedWomens4();
                    onRadioButtonClickedWomens5();
                    onRadioButtonClickedWomens6();
                    contentEnd(tag);

                }
                break;
        }

    }

    private void defaultValuesDiving() {
        EditText just_q1 = findViewById(R.id.justDiving_q1);
        EditText just_q2 = findViewById(R.id.justDiving_q2);
        EditText just_q3 = findViewById(R.id.justDiving_q3);
        EditText just_q4 = findViewById(R.id.justDiving_q4);
        EditText just_q5 = findViewById(R.id.justDiving_q5);

        just_q1.setVisibility(View.GONE);
        just_q2.setVisibility(View.GONE);
        just_q3.setVisibility(View.GONE);
        just_q4.setVisibility(View.GONE);
        just_q5.setVisibility(View.GONE);
    }

    private void defaultValuesProtection() {
        EditText just_q1 = findViewById(R.id.justProtection_q1);
        EditText just_q2 = findViewById(R.id.justProtection_q2);
        EditText just_q3 = findViewById(R.id.justProtection_q3);
        EditText just_q4 = findViewById(R.id.justProtection_q4);
        EditText just_q5 = findViewById(R.id.justProtection_q5);

        just_q1.setVisibility(View.GONE);
        just_q2.setVisibility(View.GONE);
        just_q3.setVisibility(View.GONE);
        just_q4.setVisibility(View.GONE);
        just_q5.setVisibility(View.GONE);
    }

    private void defaultValuesMachines() {
        EditText just_q1 = findViewById(R.id.justMachines_q1);
        EditText just_q2 = findViewById(R.id.justMachines_q2);
        EditText just_q3 = findViewById(R.id.justMachines_q3);
        EditText just_q4 = findViewById(R.id.justMachines_q4);
        EditText just_q5 = findViewById(R.id.justMachines_q5);
        EditText just_q6 = findViewById(R.id.justMachines_q6);
        EditText just_q7 = findViewById(R.id.justMachines_q7);

        just_q1.setVisibility(View.GONE);
        just_q2.setVisibility(View.GONE);
        just_q3.setVisibility(View.GONE);
        just_q4.setVisibility(View.GONE);
        just_q5.setVisibility(View.GONE);
        just_q6.setVisibility(View.GONE);
        just_q7.setVisibility(View.GONE);
    }

    private void defaultValuesEletrical() {
        EditText just_q1 = findViewById(R.id.justEletrical_q1);
        EditText just_q2 = findViewById(R.id.justEletrical_q2);
        EditText just_q3 = findViewById(R.id.justEletrical_q3);
        EditText just_q4 = findViewById(R.id.justEletrical_q4);
        EditText just_q5 = findViewById(R.id.justEletrical_q5);
        EditText just_q6 = findViewById(R.id.justEletrical_q6);
        EditText just_q7 = findViewById(R.id.justEletrical_q7);

        just_q1.setVisibility(View.GONE);
        just_q2.setVisibility(View.GONE);
        just_q3.setVisibility(View.GONE);
        just_q4.setVisibility(View.GONE);
        just_q5.setVisibility(View.GONE);
        just_q6.setVisibility(View.GONE);
        just_q7.setVisibility(View.GONE);
    }

    private void defaultValuesBoating() {
        EditText just_q1 = findViewById(R.id.justBoating_q1);
        EditText just_q2 = findViewById(R.id.justBoating_q2);
        EditText just_q3 = findViewById(R.id.justBoating_q3);
        EditText just_q4 = findViewById(R.id.justBoating_q4);
        EditText just_q5 = findViewById(R.id.justBoating_q5);
        EditText just_q6 = findViewById(R.id.justBoating_q6);

        just_q1.setVisibility(View.GONE);
        just_q2.setVisibility(View.GONE);
        just_q3.setVisibility(View.GONE);
        just_q4.setVisibility(View.GONE);
        just_q5.setVisibility(View.GONE);
        just_q6.setVisibility(View.GONE);
    }

    private void defaultValuesChemicals() {
        EditText just_q1 = findViewById(R.id.justChemicals_q1);
        EditText just_q2 = findViewById(R.id.justChemicals_q2);
        EditText just_q3 = findViewById(R.id.justChemicals_q3);
        EditText just_q4 = findViewById(R.id.justChemicals_q4);
        EditText just_q5 = findViewById(R.id.justChemicals_q5);

        just_q1.setVisibility(View.GONE);
        just_q2.setVisibility(View.GONE);
        just_q3.setVisibility(View.GONE);
        just_q4.setVisibility(View.GONE);
        just_q5.setVisibility(View.GONE);
    }

    private void defaultValuesWomens() {
        EditText just_q1 = findViewById(R.id.justWomens_q1);
        EditText just_q2 = findViewById(R.id.justWomens_q2);
        EditText just_q3 = findViewById(R.id.justWomens_q3);
        EditText just_q4 = findViewById(R.id.justWomens_q4);
        EditText just_q5 = findViewById(R.id.justWomens_q5);
        EditText just_q6 = findViewById(R.id.justWomens_q6);

        just_q1.setVisibility(View.GONE);
        just_q2.setVisibility(View.GONE);
        just_q3.setVisibility(View.GONE);
        just_q4.setVisibility(View.GONE);
        just_q5.setVisibility(View.GONE);
        just_q6.setVisibility(View.GONE);
    }

    public void checkRadiosDiving() {
        RadioGroup group1 = findViewById(R.id.groupDiving_question1);
        RadioButton radioButton1 = findViewById(R.id.rdbtn1_no_diving);
        checkMissingRadio(group1, radioButton1);
        RadioGroup group2 = findViewById(R.id.groupDiving_question2);
        RadioButton radioButton2 = findViewById(R.id.rdbtn2_no_diving);
        checkMissingRadio(group2, radioButton2);
        RadioGroup group3 = findViewById(R.id.groupDiving_question3);
        RadioButton radioButton3 = findViewById(R.id.rdbtn3_no_diving);
        checkMissingRadio(group3, radioButton3);
        RadioGroup group4 = findViewById(R.id.groupDiving_question4);
        RadioButton radioButton4 = findViewById(R.id.rdbtn4_no_diving);
        checkMissingRadio(group4, radioButton4);
        RadioGroup group5 = findViewById(R.id.groupDiving_question5);
        RadioButton radioButton5 = findViewById(R.id.rdbtn5_no_diving);
        checkMissingRadio(group5, radioButton5);
    }

    public void checkRadiosProtection() {
        RadioGroup group1 = findViewById(R.id.groupProtection_question1);
        RadioButton radioButton1 = findViewById(R.id.rdbtn1_no_protection);
        checkMissingRadio(group1, radioButton1);
        RadioGroup group2 = findViewById(R.id.groupProtection_question2);
        RadioButton radioButton2 = findViewById(R.id.rdbtn2_no_protection);
        checkMissingRadio(group2, radioButton2);
        RadioGroup group3 = findViewById(R.id.groupProtection_question3);
        RadioButton radioButton3 = findViewById(R.id.rdbtn3_no_protection);
        checkMissingRadio(group3, radioButton3);
        RadioGroup group4 = findViewById(R.id.groupProtection_question4);
        RadioButton radioButton4 = findViewById(R.id.rdbtn4_no_protection);
        checkMissingRadio(group4, radioButton4);
        RadioGroup group5 = findViewById(R.id.groupProtection_question5);
        RadioButton radioButton5 = findViewById(R.id.rdbtn5_no_protection);
        checkMissingRadio(group5, radioButton5);
        RadioGroup group6 = findViewById(R.id.groupProtection_question6);
        RadioButton radioButton6 = findViewById(R.id.rdbtn6_no_protection);
        checkMissingRadio(group6, radioButton6);
    }

    public void checkRadiosMachines() {
        RadioGroup group1 = findViewById(R.id.groupMachines_question1);
        RadioButton radioButton1 = findViewById(R.id.rdbtn1_no_machines);
        checkMissingRadio(group1, radioButton1);
        RadioGroup group2 = findViewById(R.id.groupMachines_question2);
        RadioButton radioButton2 = findViewById(R.id.rdbtn2_no_machines);
        checkMissingRadio(group2, radioButton2);
        RadioGroup group3 = findViewById(R.id.groupMachines_question3);
        RadioButton radioButton3 = findViewById(R.id.rdbtn3_no_machines);
        checkMissingRadio(group3, radioButton3);
        RadioGroup group4 = findViewById(R.id.groupMachines_question4);
        RadioButton radioButton4 = findViewById(R.id.rdbtn4_no_machines);
        checkMissingRadio(group4, radioButton4);
        RadioGroup group5 = findViewById(R.id.groupMachines_question5);
        RadioButton radioButton5 = findViewById(R.id.rdbtn5_no_machines);
        checkMissingRadio(group5, radioButton5);
        RadioGroup group6 = findViewById(R.id.groupMachines_question6);
        RadioButton radioButton6 = findViewById(R.id.rdbtn6_no_machines);
        checkMissingRadio(group6, radioButton6);
        RadioGroup group7 = findViewById(R.id.groupMachines_question7);
        RadioButton radioButton7 = findViewById(R.id.rdbtn7_no_machines);
        checkMissingRadio(group7, radioButton7);

    }

    public void checkRadiosEletrical() {
        RadioGroup group1 = findViewById(R.id.groupEletrical_question1);
        RadioButton radioButton1 = findViewById(R.id.rdbtn1_no_eletrical);
        checkMissingRadio(group1, radioButton1);
        RadioGroup group2 = findViewById(R.id.groupEletrical_question2);
        RadioButton radioButton2 = findViewById(R.id.rdbtn2_no_eletrical);
        checkMissingRadio(group2, radioButton2);
        RadioGroup group3 = findViewById(R.id.groupEletrical_question3);
        RadioButton radioButton3 = findViewById(R.id.rdbtn3_no_eletrical);
        checkMissingRadio(group3, radioButton3);
        RadioGroup group4 = findViewById(R.id.groupEletrical_question4);
        RadioButton radioButton4 = findViewById(R.id.rdbtn4_no_eletrical);
        checkMissingRadio(group4, radioButton4);
        RadioGroup group5 = findViewById(R.id.groupEletrical_question5);
        RadioButton radioButton5 = findViewById(R.id.rdbtn5_no_eletrical);
        checkMissingRadio(group5, radioButton5);
        RadioGroup group6 = findViewById(R.id.groupEletrical_question6);
        RadioButton radioButton6 = findViewById(R.id.rdbtn6_no_eletrical);
        checkMissingRadio(group6, radioButton6);
        RadioGroup group7 = findViewById(R.id.groupEletrical_question7);
        RadioButton radioButton7 = findViewById(R.id.rdbtn7_no_eletrical);
        checkMissingRadio(group7, radioButton7);
    }

    public void checkRadiosBoating() {
        RadioGroup group1 = findViewById(R.id.groupBoating_question1);
        RadioButton radioButton1 = findViewById(R.id.rdbtn1_no_boating);
        checkMissingRadio(group1, radioButton1);
        RadioGroup group2 = findViewById(R.id.groupBoating_question2);
        RadioButton radioButton2 = findViewById(R.id.rdbtn2_no_boating);
        checkMissingRadio(group2, radioButton2);
        RadioGroup group3 = findViewById(R.id.groupBoating_question3);
        RadioButton radioButton3 = findViewById(R.id.rdbtn3_no_boating);
        checkMissingRadio(group3, radioButton3);
        RadioGroup group4 = findViewById(R.id.groupBoating_question4);
        RadioButton radioButton4 = findViewById(R.id.rdbtn4_no_boating);
        checkMissingRadio(group4, radioButton4);
        RadioGroup group5 = findViewById(R.id.groupBoating_question5);
        RadioButton radioButton5 = findViewById(R.id.rdbtn5_no_boating);
        checkMissingRadio(group5, radioButton5);
        RadioGroup group6 = findViewById(R.id.groupBoating_question6);
        RadioButton radioButton6 = findViewById(R.id.rdbtn6_no_boating);
        checkMissingRadio(group6, radioButton6);
    }

    public void checkRadiosChemicals() {
        RadioGroup group1 = findViewById(R.id.groupChemicals_question1);
        RadioButton radioButton1 = findViewById(R.id.rdbtn1_no_chemicals);
        checkMissingRadio(group1, radioButton1);
        RadioGroup group2 = findViewById(R.id.groupChemicals_question2);
        RadioButton radioButton2 = findViewById(R.id.rdbtn2_no_chemicals);
        checkMissingRadio(group2, radioButton2);
        RadioGroup group3 = findViewById(R.id.groupChemicals_question3);
        RadioButton radioButton3 = findViewById(R.id.rdbtn3_no_chemicals);
        checkMissingRadio(group3, radioButton3);
        RadioGroup group4 = findViewById(R.id.groupChemicals_question4);
        RadioButton radioButton4 = findViewById(R.id.rdbtn4_no_chemicals);
        checkMissingRadio(group4, radioButton4);
        RadioGroup group5 = findViewById(R.id.groupChemicals_question5);
        RadioButton radioButton5 = findViewById(R.id.rdbtn5_no_chemicals);
        checkMissingRadio(group5, radioButton5);
    }

    public void checkRadiosWomens() {
        RadioGroup group1 = findViewById(R.id.groupWomens_question1);
        RadioButton radioButton1 = findViewById(R.id.rdbtn1_no_womens);
        checkMissingRadio(group1, radioButton1);
        RadioGroup group2 = findViewById(R.id.groupWomens_question2);
        RadioButton radioButton2 = findViewById(R.id.rdbtn2_no_womens);
        checkMissingRadio(group2, radioButton2);
        RadioGroup group3 = findViewById(R.id.groupWomens_question3);
        RadioButton radioButton3 = findViewById(R.id.rdbtn3_no_womens);
        checkMissingRadio(group3, radioButton3);
        RadioGroup group4 = findViewById(R.id.groupWomens_question4);
        RadioButton radioButton4 = findViewById(R.id.rdbtn4_no_womens);
        checkMissingRadio(group4, radioButton4);
        RadioGroup group5 = findViewById(R.id.groupWomens_question5);
        RadioButton radioButton5 = findViewById(R.id.rdbtn5_no_womens);
        checkMissingRadio(group5, radioButton5);
        RadioGroup group6 = findViewById(R.id.groupWomens_question6);
        RadioButton radioButton6 = findViewById(R.id.rdbtn6_no_womens);
        checkMissingRadio(group6, radioButton6);
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

    public void contentEnd(final String screen){
        btnShareCSV = findViewById(R.id.btnShareCSV);
        btnSharePDF = findViewById(R.id.btnSharePDF);
        btnShareCSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissoesHandler permissoes = new PermissoesHandler(ActivityOne.this);
                if (permissoes.verifyFilePermission()) {
                    switch (screen){
                        case "diving":
                            try {
                                checkRadiosDiving();

                                if (txtData.getText().length() == 0  || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectory(getResources().getString(R.string.diving_name));
                                    exportDivingCSV();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "protection":
                            try {
                                checkRadiosProtection();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectory(getResources().getString(R.string.protection_name));
                                    exportProtectionCSV();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "machines":
                            try {
                                checkRadiosMachines();
                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectory(getResources().getString(R.string.machines_name));
                                    exportMachinesCSV();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "eletrical":
                            try {
                                checkRadiosEletrical();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectory(getResources().getString(R.string.eletrical_name));
                                    exportEletricalCSV();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "boating":
                            try {
                                checkRadiosBoating();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectory(getResources().getString(R.string.boating_name));
                                    exportBoatingCSV();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "chemicals":
                            try {
                                checkRadiosChemicals();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectory(getResources().getString(R.string.chemicals_name));
                                    exportChemicalsCSV();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "womens":
                            try {
                                checkRadiosWomens();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectory(getResources().getString(R.string.womens_name));
                                    exportWomensCSV();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                    }
                } else {
                    permissoes.askPermissionFile();
                }
            }
        });

        btnSharePDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast testing = Toast.makeText(getApplicationContext(),"Exportação PDF em Desenvolvimento...", Toast.LENGTH_SHORT);
                // testing.show();
                PermissoesHandler permissoes = new PermissoesHandler(ActivityOne.this);
                if (permissoes.verifyFilePermission()) {
                    switch (screen){
                        case "diving":
                            try {
                                checkRadiosDiving();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectoryPDF(getResources().getString(R.string.diving_name));
                                    exportDivingPDF();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "protection":
                            try {
                                checkRadiosProtection();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectoryPDF(getResources().getString(R.string.protection_name));
                                    exportProtectionPDF();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "machines":
                            try {
                                checkRadiosMachines();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectoryPDF(getResources().getString(R.string.machines_name));
                                    exportMachinesPDF();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "eletrical":
                            try {
                                checkRadiosEletrical();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectoryPDF(getResources().getString(R.string.eletrical_name));
                                    exportEletricalPDF();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "boating":
                            try {
                                checkRadiosBoating();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectoryPDF(getResources().getString(R.string.boating_name));
                                    exportBoatingPDF();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "chemicals":
                            try {
                                checkRadiosChemicals();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectoryPDF(getResources().getString(R.string.chemicals_name));
                                    exportChemicalsPDF();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "womens":
                            try {
                                checkRadiosWomens();

                                if (txtData.getText().length() == 0 || txtResponsable.getText().length() == 0) {
                                    txtData.setError(getResources().getString(R.string.required_field));
                                    txtResponsable.setError(getResources().getString(R.string.required_field));
                                } else {
                                    createDirectoryPDF(getResources().getString(R.string.womens_name));
                                    exportWomensPDF();
                                }
                            } catch (NullPointerException e){
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.missing_radio), Toast.LENGTH_SHORT).show();
                            }

                            break;
                    }
                } else {
                    permissoes.askPermissionFile();
                }

            }
        });

    }


    public void onRadioButtonClickedDiving1() {
        final RadioGroup group_question = findViewById(R.id.groupDiving_question1);
        final EditText just = findViewById(R.id.justDiving_q1);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q1:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn1_yes_diving:
                        Log.d("YES","YES Q1:"+R.id.rdbtn1_yes_diving);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer1 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn1_no_diving:
                        Log.d("NO","NO Q1:"+R.id.rdbtn1_no_diving);
                        // No rules
                        answer1 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupDiving_question1));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedProtection1() {
        final RadioGroup group_question = findViewById(R.id.groupProtection_question1);
        final EditText just = findViewById(R.id.justProtection_q1);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q1:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn1_yes_protection:
                        Log.d("YES","YES Q1:"+R.id.rdbtn1_yes_protection);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer1 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn1_no_protection:
                        Log.d("NO","NO Q1:"+R.id.rdbtn1_no_protection);
                        // No rules
                        answer1 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupProtection_question1));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedMachines1() {
        final RadioGroup group_question = findViewById(R.id.groupMachines_question1);
        final EditText just = findViewById(R.id.justMachines_q1);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q1:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn1_yes_machines:
                        Log.d("YES","YES Q1:"+R.id.rdbtn1_yes_machines);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer1 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn1_no_machines:
                        Log.d("NO","NO Q1:"+R.id.rdbtn1_no_machines);
                        // No rules
                        answer1 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupMachines_question1));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedEletrical1() {
        final RadioGroup group_question = findViewById(R.id.groupEletrical_question1);
        final EditText just = findViewById(R.id.justEletrical_q1);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q1:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn1_yes_eletrical:
                        Log.d("YES","YES Q1:"+R.id.rdbtn1_yes_eletrical);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer1 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn1_no_eletrical:
                        Log.d("NO","NO Q1:"+R.id.rdbtn1_no_eletrical);
                        // No rules
                        answer1 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupEletrical_question1));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedBoating1() {
        final RadioGroup group_question = findViewById(R.id.groupBoating_question1);
        final EditText just = findViewById(R.id.justBoating_q1);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q1:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn1_yes_boating:
                        Log.d("YES","YES Q1:"+R.id.rdbtn1_yes_boating);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer1 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn1_no_boating:
                        Log.d("NO","NO Q1:"+R.id.rdbtn1_no_boating);
                        // No rules
                        answer1 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupBoating_question1));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedChemicals1() {
        final RadioGroup group_question = findViewById(R.id.groupChemicals_question1);
        final EditText just = findViewById(R.id.justChemicals_q1);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q1:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn1_yes_chemicals:
                        Log.d("YES","YES Q1:"+R.id.rdbtn1_yes_chemicals);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer1 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn1_no_chemicals:
                        Log.d("NO","NO Q1:"+R.id.rdbtn1_no_chemicals);
                        // No rules
                        answer1 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupChemicals_question1));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWomens1() {
        final RadioGroup group_question = findViewById(R.id.groupWomens_question1);
        final EditText just = findViewById(R.id.justWomens_q1);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q1:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn1_yes_womens:
                        Log.d("YES","YES Q1:"+R.id.rdbtn1_yes_womens);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer1 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn1_no_womens:
                        Log.d("NO","NO Q1:"+R.id.rdbtn1_no_womens);
                        // No rules
                        answer1 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWomens_question1));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedDiving2() {
        final RadioGroup group_question = findViewById(R.id.groupDiving_question2);
        final EditText just = findViewById(R.id.justDiving_q2);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q2:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn2_yes_diving:
                        Log.d("YES","YES Q2:"+R.id.rdbtn2_yes_diving);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer2 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn2_no_diving:
                        Log.d("NO","NO Q2:"+R.id.rdbtn2_no_diving);
                        // No rules
                        answer2 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupDiving_question2));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedProtection2() {
        final RadioGroup group_question = findViewById(R.id.groupProtection_question2);
        final EditText just = findViewById(R.id.justProtection_q2);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q2:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn2_yes_protection:
                        Log.d("YES","YES Q2:"+R.id.rdbtn2_yes_protection);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer2 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn2_no_protection:
                        Log.d("NO","NO Q2:"+R.id.rdbtn2_no_protection);
                        // No rules
                        answer2 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupProtection_question2));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedMachines2() {
        final RadioGroup group_question = findViewById(R.id.groupMachines_question2);
        final EditText just = findViewById(R.id.justMachines_q2);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q2:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn2_yes_machines:
                        Log.d("YES","YES Q2:"+R.id.rdbtn2_yes_machines);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer2 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn2_no_machines:
                        Log.d("NO","NO Q2:"+R.id.rdbtn2_no_machines);
                        // No rules
                        answer2 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupMachines_question2));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedEletrical2() {
        final RadioGroup group_question = findViewById(R.id.groupEletrical_question2);
        final EditText just = findViewById(R.id.justEletrical_q2);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q2:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn2_yes_eletrical:
                        Log.d("YES","YES Q2:"+R.id.rdbtn2_yes_eletrical);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer2 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn2_no_eletrical:
                        Log.d("NO","NO Q2:"+R.id.rdbtn2_no_eletrical);
                        // No rules
                        answer2 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupEletrical_question2));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedBoating2() {
        final RadioGroup group_question = findViewById(R.id.groupBoating_question2);
        final EditText just = findViewById(R.id.justBoating_q2);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q2:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn2_yes_boating:
                        Log.d("YES","YES Q2:"+R.id.rdbtn2_yes_boating);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer2 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn2_no_boating:
                        Log.d("NO","NO Q2:"+R.id.rdbtn2_no_boating);
                        // No rules
                        answer2 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupBoating_question2));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedChemicals2() {
        final RadioGroup group_question = findViewById(R.id.groupChemicals_question2);
        final EditText just = findViewById(R.id.justChemicals_q2);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q2:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn2_yes_chemicals:
                        Log.d("YES","YES Q2:"+R.id.rdbtn2_yes_chemicals);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer2 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn2_no_chemicals:
                        Log.d("NO","NO Q2:"+R.id.rdbtn2_no_chemicals);
                        // No rules
                        answer2 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupChemicals_question2));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWomens2() {
        final RadioGroup group_question = findViewById(R.id.groupWomens_question2);
        final EditText just = findViewById(R.id.justWomens_q2);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q2:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn2_yes_womens:
                        Log.d("YES","YES Q2:"+R.id.rdbtn2_yes_womens);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer2 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn2_no_womens:
                        Log.d("NO","NO Q2:"+R.id.rdbtn2_no_womens);
                        // No rules
                        answer2 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWomens_question2));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedDiving3() {
        final RadioGroup group_question = findViewById(R.id.groupDiving_question3);
        final EditText just = findViewById(R.id.justDiving_q3);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q3:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn3_yes_diving:
                        Log.d("YES","YES Q3:"+R.id.rdbtn3_yes_diving);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer3 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn3_no_diving:
                        Log.d("NO","NO Q3:"+R.id.rdbtn3_no_diving);
                        // No rules
                        answer3 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupDiving_question3));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedProtection3() {
        final RadioGroup group_question = findViewById(R.id.groupProtection_question3);
        final EditText just = findViewById(R.id.justProtection_q3);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q3:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn3_yes_protection:
                        Log.d("YES","YES Q3:"+R.id.rdbtn3_yes_protection);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer3 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn3_no_protection:
                        Log.d("NO","NO Q3:"+R.id.rdbtn3_no_protection);
                        // No rules
                        answer3 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupProtection_question3));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedMachines3() {
        final RadioGroup group_question = findViewById(R.id.groupMachines_question3);
        final EditText just = findViewById(R.id.justMachines_q3);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q3:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn3_yes_machines:
                        Log.d("YES","YES Q3:"+R.id.rdbtn3_yes_machines);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer3 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn3_no_machines:
                        Log.d("NO","NO Q3:"+R.id.rdbtn3_no_machines);
                        // No rules
                        answer3 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupMachines_question3));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedEletrical3() {
        final RadioGroup group_question = findViewById(R.id.groupEletrical_question3);
        final EditText just = findViewById(R.id.justEletrical_q3);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q3:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn3_yes_eletrical:
                        Log.d("YES","YES Q3:"+R.id.rdbtn3_yes_eletrical);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer3 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn3_no_eletrical:
                        Log.d("NO","NO Q3:"+R.id.rdbtn3_no_eletrical);
                        // No rules
                        answer3 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupEletrical_question3));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedBoating3() {
        final RadioGroup group_question = findViewById(R.id.groupBoating_question3);
        final EditText just = findViewById(R.id.justBoating_q3);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q3:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn3_yes_boating:
                        Log.d("YES","YES Q3:"+R.id.rdbtn3_yes_boating);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer3 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn3_no_boating:
                        Log.d("NO","NO Q3:"+R.id.rdbtn3_no_boating);
                        // No rules
                        answer3 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupBoating_question3));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedChemicals3() {
        final RadioGroup group_question = findViewById(R.id.groupChemicals_question3);
        final EditText just = findViewById(R.id.justChemicals_q3);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q3:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn3_yes_chemicals:
                        Log.d("YES","YES Q3:"+R.id.rdbtn3_yes_chemicals);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer3 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn3_no_chemicals:
                        Log.d("NO","NO Q3:"+R.id.rdbtn3_no_chemicals);
                        // No rules
                        answer3 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupChemicals_question3));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWomens3() {
        final RadioGroup group_question = findViewById(R.id.groupWomens_question3);
        final EditText just = findViewById(R.id.justWomens_q3);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q3:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn3_yes_womens:
                        Log.d("YES","YES Q3:"+R.id.rdbtn3_yes_womens);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer3 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn3_no_womens:
                        Log.d("NO","NO Q3:"+R.id.rdbtn3_no_womens);
                        // No rules
                        answer3 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWomens_question3));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedDiving4() {
        final RadioGroup group_question = findViewById(R.id.groupDiving_question4);
        final EditText just = findViewById(R.id.justDiving_q4);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q4:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn4_yes_diving:
                        Log.d("YES","YES Q4:"+R.id.rdbtn4_yes_diving);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer4 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn4_no_diving:
                        Log.d("NO","NO Q4:"+R.id.rdbtn4_no_diving);
                        // No rules
                        answer4 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupDiving_question4));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedProtection4() {
        final RadioGroup group_question = findViewById(R.id.groupProtection_question4);
        final EditText just = findViewById(R.id.justProtection_q4);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q4:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn4_yes_protection:
                        Log.d("YES","YES Q4:"+R.id.rdbtn4_yes_protection);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer4 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn4_no_protection:
                        Log.d("NO","NO Q4:"+R.id.rdbtn4_no_protection);
                        // No rules
                        answer4 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupProtection_question4));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedMachines4() {
        final RadioGroup group_question = findViewById(R.id.groupMachines_question4);
        final EditText just = findViewById(R.id.justMachines_q4);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q4:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn4_yes_machines:
                        Log.d("YES","YES Q4:"+R.id.rdbtn4_yes_machines);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer4 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn4_no_machines:
                        Log.d("NO","NO Q4:"+R.id.rdbtn4_no_machines);
                        // No rules
                        answer4 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupMachines_question4));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedEletrical4() {
        final RadioGroup group_question = findViewById(R.id.groupEletrical_question4);
        final EditText just = findViewById(R.id.justEletrical_q4);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q4:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn4_yes_eletrical:
                        Log.d("YES","YES Q4:"+R.id.rdbtn4_yes_eletrical);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer4 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn4_no_eletrical:
                        Log.d("NO","NO Q4:"+R.id.rdbtn4_no_eletrical);
                        // No rules
                        answer4 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupEletrical_question4));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedBoating4() {
        final RadioGroup group_question = findViewById(R.id.groupBoating_question4);
        final EditText just = findViewById(R.id.justBoating_q4);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q4:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn4_yes_boating:
                        Log.d("YES","YES Q4:"+R.id.rdbtn4_yes_boating);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer4 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn4_no_boating:
                        Log.d("NO","NO Q4:"+R.id.rdbtn4_no_boating);
                        // No rules
                        answer4 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupBoating_question4));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedChemicals4() {
        final RadioGroup group_question = findViewById(R.id.groupChemicals_question4);
        final EditText just = findViewById(R.id.justChemicals_q4);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q4:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn4_yes_chemicals:
                        Log.d("YES","YES Q4:"+R.id.rdbtn4_yes_chemicals);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer4 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn4_no_chemicals:
                        Log.d("NO","NO Q4:"+R.id.rdbtn4_no_chemicals);
                        // No rules
                        answer4 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupChemicals_question4));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWomens4() {
        final RadioGroup group_question = findViewById(R.id.groupWomens_question4);
        final EditText just = findViewById(R.id.justWomens_q4);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q4:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn4_yes_womens:
                        Log.d("YES","YES Q4:"+R.id.rdbtn4_yes_womens);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer4 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn4_no_womens:
                        Log.d("NO","NO Q4:"+R.id.rdbtn4_no_womens);
                        // No rules
                        answer4 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWomens_question4));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedDiving5() {
        final RadioGroup group_question = findViewById(R.id.groupDiving_question5);
        final EditText just = findViewById(R.id.justDiving_q5);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q5:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn5_yes_diving:
                        Log.d("YES","YES Q5:"+R.id.rdbtn5_yes_diving);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer5 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no_diving:
                        Log.d("NO","NO Q5:"+R.id.rdbtn5_no_diving);
                        // No rules
                        answer5 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupDiving_question1));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedProtection5() {
        final RadioGroup group_question = findViewById(R.id.groupProtection_question5);
        final EditText just = findViewById(R.id.justProtection_q5);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q5:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn5_yes_protection:
                        Log.d("YES","YES Q5:"+R.id.rdbtn5_yes_protection);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer5 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no_protection:
                        Log.d("NO","NO Q5:"+R.id.rdbtn5_no_protection);
                        // No rules
                        answer5 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupProtection_question5));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedMachines5() {
        final RadioGroup group_question = findViewById(R.id.groupMachines_question5);
        final EditText just = findViewById(R.id.justMachines_q5);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q5:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn5_yes_machines:
                        Log.d("YES","YES Q5:"+R.id.rdbtn5_yes_machines);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer5 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no_machines:
                        Log.d("NO","NO Q5:"+R.id.rdbtn5_no_machines);
                        // No rules
                        answer5 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupMachines_question5));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedEletrical5() {
        final RadioGroup group_question = findViewById(R.id.groupEletrical_question5);
        final EditText just = findViewById(R.id.justEletrical_q5);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q5:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn5_yes_eletrical:
                        Log.d("YES","YES Q5:"+R.id.rdbtn5_yes_eletrical);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer5 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no_eletrical:
                        Log.d("NO","NO Q5:"+R.id.rdbtn5_no_eletrical);
                        // No rules
                        answer5 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupEletrical_question5));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedBoating5() {
        final RadioGroup group_question = findViewById(R.id.groupBoating_question5);
        final EditText just = findViewById(R.id.justBoating_q5);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q5:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn5_yes_boating:
                        Log.d("YES","YES Q5:"+R.id.rdbtn5_yes_boating);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer5 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no_boating:
                        Log.d("NO","NO Q5:"+R.id.rdbtn5_no_boating);
                        // No rules
                        answer5 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupBoating_question5));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedChemicals5() {
        final RadioGroup group_question = findViewById(R.id.groupChemicals_question5);
        final EditText just = findViewById(R.id.justChemicals_q5);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q5:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn5_yes_chemicals:
                        Log.d("YES","YES Q5:"+R.id.rdbtn5_yes_chemicals);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer5 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no_chemicals:
                        Log.d("NO","NO Q5:"+R.id.rdbtn5_no_chemicals);
                        // No rules
                        answer5 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupChemicals_question5));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWomens5() {
        final RadioGroup group_question = findViewById(R.id.groupWomens_question5);
        final EditText just = findViewById(R.id.justWomens_q5);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q5:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn5_yes_womens:
                        Log.d("YES","YES Q5:"+R.id.rdbtn5_yes_womens);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer5 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no_womens:
                        Log.d("NO","NO Q5:"+R.id.rdbtn5_no_womens);
                        // No rules
                        answer5 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWomens_question5));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedProtection6() {
        final RadioGroup group_question = findViewById(R.id.groupProtection_question6);
        final EditText just = findViewById(R.id.justProtection_q6);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q6:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn6_yes_protection:
                        Log.d("YES","YES Q6:"+R.id.rdbtn6_yes_protection);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer6 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn5_no_protection:
                        Log.d("NO","NO Q6:"+R.id.rdbtn6_no_protection);
                        // No rules
                        answer6 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupProtection_question6));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedMachines6() {
        final RadioGroup group_question = findViewById(R.id.groupMachines_question6);
        final EditText just = findViewById(R.id.justMachines_q6);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q6:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn6_yes_machines:
                        Log.d("YES","YES Q6:"+R.id.rdbtn6_yes_machines);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer6 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn6_no_machines:
                        Log.d("NO","NO Q6:"+R.id.rdbtn6_no_machines);
                        // No rules
                        answer6 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupMachines_question6));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedEletrical6() {
        final RadioGroup group_question = findViewById(R.id.groupEletrical_question6);
        final EditText just = findViewById(R.id.justEletrical_q6);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q6:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn6_yes_eletrical:
                        Log.d("YES","YES Q6:"+R.id.rdbtn6_yes_eletrical);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer6 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn6_no_eletrical:
                        Log.d("NO","NO Q6:"+R.id.rdbtn6_no_eletrical);
                        // No rules
                        answer6 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupEletrical_question6));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedBoating6() {
        final RadioGroup group_question = findViewById(R.id.groupBoating_question6);
        final EditText just = findViewById(R.id.justBoating_q6);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q6:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn6_yes_boating:
                        Log.d("YES","YES Q6:"+R.id.rdbtn6_yes_boating);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer6 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn6_no_boating:
                        Log.d("NO","NO Q6:"+R.id.rdbtn6_no_boating);
                        // No rules
                        answer6 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupBoating_question6));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedWomens6() {
        final RadioGroup group_question = findViewById(R.id.groupWomens_question6);
        final EditText just = findViewById(R.id.justWomens_q6);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q6:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn6_yes_womens:
                        Log.d("YES","YES Q6:"+R.id.rdbtn6_yes_womens);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer6 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn6_no_womens:
                        Log.d("NO","NO Q6:"+R.id.rdbtn6_no_womens);
                        // No rules
                        answer6 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupWomens_question6));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedMachines7() {
        final RadioGroup group_question = findViewById(R.id.groupMachines_question7);
        final EditText just = findViewById(R.id.justMachines_q7);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q7:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn7_yes_machines:
                        Log.d("YES","YES Q7:"+R.id.rdbtn7_yes_machines);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer7 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn7_no_machines:
                        Log.d("NO","NO Q7:"+R.id.rdbtn7_no_machines);
                        // No rules
                        answer7 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupMachines_question7));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    public void onRadioButtonClickedEletrical7() {
        final RadioGroup group_question = findViewById(R.id.groupEletrical_question7);
        final EditText just = findViewById(R.id.justEletrical_q7);

        // Check which radio button was clicked
        group_question.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CheckedID","Checked ID Q7:"+checkedId);
                switch (checkedId) {
                    case R.id.rdbtn7_yes_eletrical:
                        Log.d("YES","YES Q7:"+R.id.rdbtn7_yes_eletrical);
                        // Yes rules
                        just.setVisibility(View.GONE);
                        answer7 = getResources().getString(R.string.yes_rdbtn);
                        break;
                    case R.id.rdbtn7_no_eletrical:
                        Log.d("NO","NO Q7:"+R.id.rdbtn7_no_eletrical);
                        // No rules
                        answer7 = getResources().getString(R.string.no_rdbtn);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.groupEletrical_question7));
                            just.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
    }

    private File createDirectory(String check_name) {
        Log.d("File PDF Created","Directory created.");
        File root = new File(ROOT_DIRECTORY);
        root.mkdir();
        File dir = new File(PATTERN_DIRECTORY.concat(check_name+"/"));
        dir.mkdir();
        return dir;
    }

    private void exportDivingCSV() {
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustDivingQ1 = findViewById(R.id.justDiving_q1);
        EditText txtJustDivingQ2 = findViewById(R.id.justDiving_q2);
        EditText txtJustDivingQ3 = findViewById(R.id.justDiving_q3);
        EditText txtJustDivingQ4 = findViewById(R.id.justDiving_q4);
        EditText txtJustDivingQ5 = findViewById(R.id.justDiving_q5);
        justDiving1 = checkJust(txtJustDivingQ1);
        justDiving2 = checkJust(txtJustDivingQ2);
        justDiving3 = checkJust(txtJustDivingQ3);
        justDiving4 = checkJust(txtJustDivingQ4);
        justDiving5 = checkJust(txtJustDivingQ5);

        Log.d("Values:","D:"+data+", R:"+responsable);
        // SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/AAAA", Locale.getDefault());
        // String fileName = responsable.replace(" ", "").toLowerCase() + "-" + sdf.format(txtData.getText().toString()) + ".csv";
        String fileName = responsable.replace(" ", "").toLowerCase() + "-" +data+ ".csv";
        File directory = createDirectory(getResources().getString(R.string.diving_name));
        File file = new File(directory, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checklist "+getResources().getString(R.string.diving_name)+"\n")
                .append(getResources().getString(R.string.inspection_data)).append(SEPARATOR).append(data).append(SEPARATOR).append("\n")
                .append(getResources().getString(R.string.responsable)).append(SEPARATOR).append(responsable).append(SEPARATOR).append("\n");

        stringBuilder.append(getResources().getString(R.string.question_csv)+";"+getResources().getString(R.string.answer_csv)+";"+getResources().getString(R.string.corrective_csv)+";\n")
                .append(getResources().getString(R.string.diving_q1)).append(SEPARATOR).append(answer1).append(SEPARATOR).append(justDiving1).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.diving_q2)).append(SEPARATOR).append(answer2).append(SEPARATOR).append(justDiving2).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.diving_q3)).append(SEPARATOR).append(answer3).append(SEPARATOR).append(justDiving3).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.diving_q4)).append(SEPARATOR).append(answer4).append(SEPARATOR).append(justDiving4).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.diving_q5)).append(SEPARATOR).append(answer5).append(SEPARATOR).append(justDiving5).append(SEPARATOR+"\n").append("\n");

        try {
            Log.d("StringBuilder:".concat("\n"),stringBuilder.toString());
            Files.asCharSink(file, Charsets.UTF_8).write(stringBuilder.toString());
            createExportDialog(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.fail_file)+ " " + file.getPath(), Toast.LENGTH_LONG).show();
        }
    }



    private void exportProtectionCSV() {
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustProtectionQ1 = findViewById(R.id.justProtection_q1);
        EditText txtJustProtectionQ2 = findViewById(R.id.justProtection_q2);
        EditText txtJustProtectionQ3 = findViewById(R.id.justProtection_q3);
        EditText txtJustProtectionQ4 = findViewById(R.id.justProtection_q4);
        EditText txtJustProtectionQ5 = findViewById(R.id.justProtection_q5);
        EditText txtJustProtectionQ6 = findViewById(R.id.justProtection_q6);

        justProtection1 = checkJust(txtJustProtectionQ1);
        justProtection2 = checkJust(txtJustProtectionQ2);
        justProtection3 = checkJust(txtJustProtectionQ3);
        justProtection4 = checkJust(txtJustProtectionQ4);
        justProtection5 = checkJust(txtJustProtectionQ5);
        justProtection6 = checkJust(txtJustProtectionQ6);


        Log.d("Values:","D:"+data+", R:"+responsable);
        // SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/AAAA", Locale.getDefault());
        // String fileName = responsable.replace(" ", "").toLowerCase() + "-" + sdf.format(txtData.getText().toString()) + ".csv";
        String fileName = responsable.replace(" ", "").toLowerCase() + "-" +data+ ".csv";
        File directory = createDirectory(getResources().getString(R.string.protection_name));
        File file = new File(directory, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checklist "+getResources().getString(R.string.protection_name)+" :\n")
                .append(getResources().getString(R.string.inspection_data)).append(SEPARATOR).append(data).append(SEPARATOR).append("\n")
                .append(getResources().getString(R.string.responsable)).append(SEPARATOR).append(responsable).append(SEPARATOR).append("\n");

        stringBuilder.append(getResources().getString(R.string.question_csv)+";"+getResources().getString(R.string.answer_csv)+";"+getResources().getString(R.string.corrective_csv)+";\n")
                .append(getResources().getString(R.string.protection_q1)).append(SEPARATOR).append(answer1).append(SEPARATOR).append(justProtection1).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.protection_q2)).append(SEPARATOR).append(answer2).append(SEPARATOR).append(justProtection2).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.protection_q3)).append(SEPARATOR).append(answer3).append(SEPARATOR).append(justProtection3).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.protection_q4)).append(SEPARATOR).append(answer4).append(SEPARATOR).append(justProtection4).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.protection_q4)).append(SEPARATOR).append(answer5).append(SEPARATOR).append(justProtection5).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.protection_q6)).append(SEPARATOR).append(answer6).append(SEPARATOR).append(justProtection6).append(SEPARATOR+"\n").append("\n");

        try {
            Log.d("StringBuilder:".concat("\n"),stringBuilder.toString());
            Files.asCharSink(file, Charsets.UTF_8).write(stringBuilder.toString());
            createExportDialog(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.fail_file)+ " " + file.getPath(), Toast.LENGTH_LONG).show();
        }
    }

    private void exportMachinesCSV() {
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustMachinesQ1 = findViewById(R.id.justMachines_q1);
        EditText txtJustMachinesQ2 = findViewById(R.id.justMachines_q2);
        EditText txtJustMachinesQ3 = findViewById(R.id.justMachines_q3);
        EditText txtJustMachinesQ4 = findViewById(R.id.justMachines_q4);
        EditText txtJustMachinesQ5 = findViewById(R.id.justMachines_q5);
        EditText txtJustMachinesQ6 = findViewById(R.id.justMachines_q6);
        EditText txtJustMachinesQ7 = findViewById(R.id.justMachines_q7);

        justMachines1 = checkJust(txtJustMachinesQ1);
        justMachines2 = checkJust(txtJustMachinesQ2);
        justMachines3 = checkJust(txtJustMachinesQ3);
        justMachines4 = checkJust(txtJustMachinesQ4);
        justMachines5 = checkJust(txtJustMachinesQ5);
        justMachines6 = checkJust(txtJustMachinesQ6);
        justMachines7 = checkJust(txtJustMachinesQ7);


        Log.d("Values:","D:"+data+", R:"+responsable);
        // SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/AAAA", Locale.getDefault());
        // String fileName = responsable.replace(" ", "").toLowerCase() + "-" + sdf.format(txtData.getText().toString()) + ".csv";
        String fileName = responsable.replace(" ", "").toLowerCase() + "-" +data+ ".csv";
        File directory = createDirectory(getResources().getString(R.string.machines_name));
        File file = new File(directory, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checklist "+getResources().getString(R.string.protection_name)+" :\n")
                .append(getResources().getString(R.string.inspection_data)).append(SEPARATOR).append(data).append(SEPARATOR).append("\n")
                .append(getResources().getString(R.string.responsable)).append(SEPARATOR).append(responsable).append(SEPARATOR).append("\n");

        stringBuilder.append(getResources().getString(R.string.question_csv)+";"+getResources().getString(R.string.answer_csv)+";"+getResources().getString(R.string.corrective_csv)+";\n")
                .append(getResources().getString(R.string.machines_q1)).append(SEPARATOR).append(answer1).append(SEPARATOR).append(justMachines1).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.machines_q2)).append(SEPARATOR).append(answer2).append(SEPARATOR).append(justMachines2).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.machines_q3)).append(SEPARATOR).append(answer3).append(SEPARATOR).append(justMachines3).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.machines_q4)).append(SEPARATOR).append(answer4).append(SEPARATOR).append(justMachines4).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.machines_q5)).append(SEPARATOR).append(answer5).append(SEPARATOR).append(justMachines5).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.machines_q6)).append(SEPARATOR).append(answer6).append(SEPARATOR).append(justMachines6).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.machines_q7)).append(SEPARATOR).append(answer7).append(SEPARATOR).append(justMachines7).append(SEPARATOR+"\n").append("\n");

        try {
            Log.d("StringBuilder:".concat("\n"),stringBuilder.toString());
            Files.asCharSink(file, Charsets.UTF_8).write(stringBuilder.toString());
            createExportDialog(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.fail_file)+ " " + file.getPath(), Toast.LENGTH_LONG).show();
        }
    }

    private void exportEletricalCSV() {
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustEletricalQ1 = findViewById(R.id.justEletrical_q1);
        EditText txtJustEletricalQ2 = findViewById(R.id.justEletrical_q2);
        EditText txtJustEletricalQ3 = findViewById(R.id.justEletrical_q3);
        EditText txtJustEletricalQ4 = findViewById(R.id.justEletrical_q4);
        EditText txtJustEletricalQ5 = findViewById(R.id.justEletrical_q5);
        EditText txtJustEletricalQ6 = findViewById(R.id.justEletrical_q6);
        EditText txtJustEletricalQ7 = findViewById(R.id.justEletrical_q7);

        justEletrical1 = checkJust(txtJustEletricalQ1);
        justEletrical2 = checkJust(txtJustEletricalQ2);
        justEletrical3 = checkJust(txtJustEletricalQ3);
        justEletrical4 = checkJust(txtJustEletricalQ4);
        justEletrical5 = checkJust(txtJustEletricalQ5);
        justEletrical6 = checkJust(txtJustEletricalQ6);
        justEletrical7 = checkJust(txtJustEletricalQ7);


        Log.d("Values:","D:"+data+", R:"+responsable);
        // SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/AAAA", Locale.getDefault());
        // String fileName = responsable.replace(" ", "").toLowerCase() + "-" + sdf.format(txtData.getText().toString()) + ".csv";
        String fileName = responsable.replace(" ", "").toLowerCase() + "-" +data+ ".csv";
        File directory = createDirectory(getResources().getString(R.string.eletrical_name));
        File file = new File(directory, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checklist "+getResources().getString(R.string.eletrical_name)+" :\n")
                .append(getResources().getString(R.string.inspection_data)).append(SEPARATOR).append(data).append(SEPARATOR).append("\n")
                .append(getResources().getString(R.string.responsable)).append(SEPARATOR).append(responsable).append(SEPARATOR).append("\n");

        stringBuilder.append(getResources().getString(R.string.question_csv)+";"+getResources().getString(R.string.answer_csv)+";"+getResources().getString(R.string.corrective_csv)+";\n")
                .append(getResources().getString(R.string.eletrical_q1)).append(SEPARATOR).append(answer1).append(SEPARATOR).append(justEletrical1).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.eletrical_q2)).append(SEPARATOR).append(answer2).append(SEPARATOR).append(justEletrical2).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.eletrical_q3)).append(SEPARATOR).append(answer3).append(SEPARATOR).append(justEletrical3).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.eletrical_q4)).append(SEPARATOR).append(answer4).append(SEPARATOR).append(justEletrical4).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.eletrical_q5)).append(SEPARATOR).append(answer5).append(SEPARATOR).append(justEletrical5).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.eletrical_q6)).append(SEPARATOR).append(answer6).append(SEPARATOR).append(justEletrical6).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.eletrical_q7)).append(SEPARATOR).append(answer7).append(SEPARATOR).append(justEletrical7).append(SEPARATOR+"\n").append("\n");

        try {
            Log.d("StringBuilder:".concat("\n"),stringBuilder.toString());
            Files.asCharSink(file, Charsets.UTF_8).write(stringBuilder.toString());
            createExportDialog(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.fail_file)+ " " + file.getPath(), Toast.LENGTH_LONG).show();
        }
    }

    private void exportBoatingCSV() {
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustBoatingQ1 = findViewById(R.id.justBoating_q1);
        EditText txtJustBoatingQ2 = findViewById(R.id.justBoating_q2);
        EditText txtJustBoatingQ3 = findViewById(R.id.justBoating_q3);
        EditText txtJustBoatingQ4 = findViewById(R.id.justBoating_q4);
        EditText txtJustBoatingQ5 = findViewById(R.id.justBoating_q5);
        EditText txtJustBoatingQ6 = findViewById(R.id.justBoating_q6);

        justBoating1 = checkJust(txtJustBoatingQ1);
        justBoating2 = checkJust(txtJustBoatingQ2);
        justBoating3 = checkJust(txtJustBoatingQ3);
        justBoating4 = checkJust(txtJustBoatingQ4);
        justBoating5 = checkJust(txtJustBoatingQ5);
        justBoating6 = checkJust(txtJustBoatingQ6);


        Log.d("Values:","D:"+data+", R:"+responsable);
        // SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/AAAA", Locale.getDefault());
        // String fileName = responsable.replace(" ", "").toLowerCase() + "-" + sdf.format(txtData.getText().toString()) + ".csv";
        String fileName = responsable.replace(" ", "").toLowerCase() + "-" +data+ ".csv";
        File directory = createDirectory(getResources().getString(R.string.boating_name));
        File file = new File(directory, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checklist "+getResources().getString(R.string.boating_name)+" :\n")
                .append(getResources().getString(R.string.inspection_data)).append(SEPARATOR).append(data).append(SEPARATOR).append("\n")
                .append(getResources().getString(R.string.responsable)).append(SEPARATOR).append(responsable).append(SEPARATOR).append("\n");

        stringBuilder.append(getResources().getString(R.string.question_csv)+";"+getResources().getString(R.string.answer_csv)+";"+getResources().getString(R.string.corrective_csv)+";\n")
                .append(getResources().getString(R.string.boating_q1)).append(SEPARATOR).append(answer1).append(SEPARATOR).append(justBoating1).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.boating_q2)).append(SEPARATOR).append(answer2).append(SEPARATOR).append(justBoating2).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.boating_q3)).append(SEPARATOR).append(answer3).append(SEPARATOR).append(justBoating3).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.boating_q4)).append(SEPARATOR).append(answer4).append(SEPARATOR).append(justBoating4).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.boating_q4)).append(SEPARATOR).append(answer5).append(SEPARATOR).append(justBoating5).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.boating_q6)).append(SEPARATOR).append(answer6).append(SEPARATOR).append(justBoating6).append(SEPARATOR+"\n").append("\n");

        try {
            Log.d("StringBuilder:".concat("\n"),stringBuilder.toString());
            Files.asCharSink(file, Charsets.UTF_8).write(stringBuilder.toString());
            createExportDialog(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.fail_file)+ " " + file.getPath(), Toast.LENGTH_LONG).show();
        }
    }

    private void exportChemicalsCSV() {
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustChemicalsQ1 = findViewById(R.id.justChemicals_q1);
        EditText txtJustChemicalsQ2 = findViewById(R.id.justChemicals_q2);
        EditText txtJustChemicalsQ3 = findViewById(R.id.justChemicals_q3);
        EditText txtJustChemicalsQ4 = findViewById(R.id.justChemicals_q4);
        EditText txtJustChemicalsQ5 = findViewById(R.id.justChemicals_q5);
        justChemicals1 = checkJust(txtJustChemicalsQ1);
        justChemicals2 = checkJust(txtJustChemicalsQ2);
        justChemicals3 = checkJust(txtJustChemicalsQ3);
        justChemicals4 = checkJust(txtJustChemicalsQ4);
        justChemicals5 = checkJust(txtJustChemicalsQ5);

        Log.d("Values:","D:"+data+", R:"+responsable);
        // SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/AAAA", Locale.getDefault());
        // String fileName = responsable.replace(" ", "").toLowerCase() + "-" + sdf.format(txtData.getText().toString()) + ".csv";
        String fileName = responsable.replace(" ", "").toLowerCase() + "-" +data+ ".csv";
        File directory = createDirectory(getResources().getString(R.string.chemicals_name));
        File file = new File(directory, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checklist "+getResources().getString(R.string.chemicals_name)+"\n")
                .append(getResources().getString(R.string.inspection_data)).append(SEPARATOR).append(data).append(SEPARATOR).append("\n")
                .append(getResources().getString(R.string.responsable)).append(SEPARATOR).append(responsable).append(SEPARATOR).append("\n");

        stringBuilder.append(getResources().getString(R.string.question_csv)+";"+getResources().getString(R.string.answer_csv)+";"+getResources().getString(R.string.corrective_csv)+";\n")
                .append(getResources().getString(R.string.chemicals_q1)).append(SEPARATOR).append(answer1).append(SEPARATOR).append(justChemicals1).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.chemicals_q2)).append(SEPARATOR).append(answer2).append(SEPARATOR).append(justChemicals2).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.chemicals_q3)).append(SEPARATOR).append(answer3).append(SEPARATOR).append(justChemicals3).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.chemicals_q4)).append(SEPARATOR).append(answer4).append(SEPARATOR).append(justChemicals4).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.chemicals_q5)).append(SEPARATOR).append(answer5).append(SEPARATOR).append(justChemicals5).append(SEPARATOR+"\n").append("\n");

        try {
            Log.d("StringBuilder:".concat("\n"),stringBuilder.toString());
            Files.asCharSink(file, Charsets.UTF_8).write(stringBuilder.toString());
            createExportDialog(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.fail_file)+ " " + file.getPath(), Toast.LENGTH_LONG).show();
        }
    }

    private void exportWomensCSV() {
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustWomensQ1 = findViewById(R.id.justWomens_q1);
        EditText txtJustWomensQ2 = findViewById(R.id.justWomens_q2);
        EditText txtJustWomensQ3 = findViewById(R.id.justWomens_q3);
        EditText txtJustWomensQ4 = findViewById(R.id.justWomens_q4);
        EditText txtJustWomensQ5 = findViewById(R.id.justWomens_q5);
        EditText txtJustWomensQ6 = findViewById(R.id.justWomens_q6);

        justWomens1 = checkJust(txtJustWomensQ1);
        justWomens2 = checkJust(txtJustWomensQ2);
        justWomens3 = checkJust(txtJustWomensQ3);
        justWomens4 = checkJust(txtJustWomensQ4);
        justWomens5 = checkJust(txtJustWomensQ5);
        justWomens6 = checkJust(txtJustWomensQ6);


        Log.d("Values:","D:"+data+", R:"+responsable);
        // SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/AAAA", Locale.getDefault());
        // String fileName = responsable.replace(" ", "").toLowerCase() + "-" + sdf.format(txtData.getText().toString()) + ".csv";
        String fileName = responsable.replace(" ", "").toLowerCase() + "-" +data+ ".csv";
        File directory = createDirectory(getResources().getString(R.string.womens_name));
        File file = new File(directory, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checklist "+getResources().getString(R.string.womens_name)+" :\n")
                .append(getResources().getString(R.string.inspection_data)).append(SEPARATOR).append(data).append(SEPARATOR).append("\n")
                .append(getResources().getString(R.string.responsable)).append(SEPARATOR).append(responsable).append(SEPARATOR).append("\n");

        stringBuilder.append(getResources().getString(R.string.question_csv)+";"+getResources().getString(R.string.answer_csv)+";"+getResources().getString(R.string.corrective_csv)+";\n")
                .append(getResources().getString(R.string.womens_q1)).append(SEPARATOR).append(answer1).append(SEPARATOR).append(justWomens1).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.womens_q2)).append(SEPARATOR).append(answer2).append(SEPARATOR).append(justWomens2).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.womens_q3)).append(SEPARATOR).append(answer3).append(SEPARATOR).append(justWomens3).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.womens_q4)).append(SEPARATOR).append(answer4).append(SEPARATOR).append(justWomens4).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.womens_q4)).append(SEPARATOR).append(answer5).append(SEPARATOR).append(justWomens5).append(SEPARATOR+"\n")
                .append(getResources().getString(R.string.womens_q6)).append(SEPARATOR).append(answer6).append(SEPARATOR).append(justWomens6).append(SEPARATOR+"\n").append("\n");

        try {
            Log.d("StringBuilder:".concat("\n"),stringBuilder.toString());
            Files.asCharSink(file, Charsets.UTF_8).write(stringBuilder.toString());
            createExportDialog(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.fail_file)+ " " + file.getPath(), Toast.LENGTH_LONG).show();
        }
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
            Uri fileURI = FileProvider.getUriForFile(ActivityOne.this,BuildConfig.APPLICATION_ID+".provider",file);
            intentShareFile.putExtra(Intent.EXTRA_STREAM, fileURI);
            String assunto = "Checklist Gerenciamento de " + txtResponsable.getText().toString();
            intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                    assunto);
            intentShareFile.putExtra(Intent.EXTRA_TEXT, file.getName());

            startActivity(Intent.createChooser(intentShareFile, getResources().getString(R.string.export_csv_file)));
        } else {
            Toast.makeText(this, getResources().getString(R.string.fail_file)+ " " + file.getPath(), Toast.LENGTH_LONG).show();
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

    public void sharePDF(File file) {
        Intent intentShareFile = new Intent(Intent.ACTION_SEND);
        if (file.exists()) {
            intentShareFile.setType("application/pdf");

//            intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:/" + file.getPath()));
            Uri fileURI = FileProvider.getUriForFile(ActivityOne.this,BuildConfig.APPLICATION_ID+".provider",file);
            intentShareFile.putExtra(Intent.EXTRA_STREAM, fileURI);
            String assunto = "Checklist Gerenciamento de " + txtResponsable.getText().toString();
            intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                    assunto);
            intentShareFile.putExtra(Intent.EXTRA_TEXT, file.getName());

            startActivity(Intent.createChooser(intentShareFile, getResources().getString(R.string.export_pdf_file)));
        }
    }

    private File createDirectoryPDF(String check_name) {
        Log.d("File PDF Created","Directory created.");
        File root = new File(ROOT_DIRECTORY);
        root.mkdir();
        File dir = new File(PATTERN_DIRECTORY.concat(check_name+"/"));
        dir.mkdir();
        return dir;
    }

    public void exportDivingPDF() {

        // Data
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustQ1 = findViewById(R.id.justDiving_q1);
        EditText txtJustQ2 = findViewById(R.id.justDiving_q2);
        EditText txtJustQ3 = findViewById(R.id.justDiving_q3);
        EditText txtJustQ4 = findViewById(R.id.justDiving_q4);
        EditText txtJustQ5 = findViewById(R.id.justDiving_q5);
        justDiving1 = checkJust(txtJustQ1);
        justDiving2 = checkJust(txtJustQ2);
        justDiving3 = checkJust(txtJustQ3);
        justDiving4 = checkJust(txtJustQ4);
        justDiving5 = checkJust(txtJustQ5);

        String check_name = getResources().getString(R.string.diving_name);
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.diving_name), mTitleFont);
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

            addQuestions(document,getResources().getString(R.string.diving_q1),answer1,justDiving1);
            addQuestions(document,getResources().getString(R.string.diving_q2),answer2,justDiving2);
            addQuestions(document,getResources().getString(R.string.diving_q3),answer3,justDiving3);
            addQuestions(document,getResources().getString(R.string.diving_q4),answer4,justDiving4);
            addQuestions(document,getResources().getString(R.string.diving_q5),answer5,justDiving5);

            document.close();

            //Toast.makeText(getApplicationContext(), "Criado :)", Toast.LENGTH_SHORT).show();
            File file = new File(dest);
            Files.asCharSink(file, Charsets.UTF_8);
            createExportPDFDialog(file);

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Erro " + ie.getLocalizedMessage());
            LOGE("dir: "+dest);
            Toast.makeText(this, getResources().getString(R.string.fail_file), Toast.LENGTH_LONG).show();
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Nenhuma aplicação encontrada para abrir este arquivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void exportChemicalsPDF() {

        // Data
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustQ1 = findViewById(R.id.justChemicals_q1);
        EditText txtJustQ2 = findViewById(R.id.justChemicals_q2);
        EditText txtJustQ3 = findViewById(R.id.justChemicals_q3);
        EditText txtJustQ4 = findViewById(R.id.justChemicals_q4);
        EditText txtJustQ5 = findViewById(R.id.justChemicals_q5);
        justChemicals1 = checkJust(txtJustQ1);
        justChemicals2 = checkJust(txtJustQ2);
        justChemicals3 = checkJust(txtJustQ3);
        justChemicals4 = checkJust(txtJustQ4);
        justChemicals5 = checkJust(txtJustQ5);

        String check_name = getResources().getString(R.string.chemicals_name);
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.chemicals_name), mTitleFont);
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

            addQuestions(document,getResources().getString(R.string.chemicals_q1),answer1,justChemicals1);
            addQuestions(document,getResources().getString(R.string.chemicals_q2),answer2,justChemicals2);
            addQuestions(document,getResources().getString(R.string.chemicals_q3),answer3,justChemicals3);
            addQuestions(document,getResources().getString(R.string.chemicals_q4),answer4,justChemicals4);
            addQuestions(document,getResources().getString(R.string.chemicals_q5),answer5,justChemicals5);

            document.close();

            //Toast.makeText(getApplicationContext(), "Criado :)", Toast.LENGTH_SHORT).show();
            File file = new File(dest);
            Files.asCharSink(file, Charsets.UTF_8);
            createExportPDFDialog(file);

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Erro " + ie.getLocalizedMessage());
            LOGE("dir: "+dest);
            Toast.makeText(this, getResources().getString(R.string.fail_file), Toast.LENGTH_LONG).show();
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Nenhuma aplicação encontrada para abrir este arquivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void exportProtectionPDF() {

        // Data
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustQ1 = findViewById(R.id.justProtection_q1);
        EditText txtJustQ2 = findViewById(R.id.justProtection_q2);
        EditText txtJustQ3 = findViewById(R.id.justProtection_q3);
        EditText txtJustQ4 = findViewById(R.id.justProtection_q4);
        EditText txtJustQ5 = findViewById(R.id.justProtection_q5);
        EditText txtJustQ6 = findViewById(R.id.justProtection_q6);

        justProtection1 = checkJust(txtJustQ1);
        justProtection2 = checkJust(txtJustQ2);
        justProtection3 = checkJust(txtJustQ3);
        justProtection4 = checkJust(txtJustQ4);
        justProtection5 = checkJust(txtJustQ5);
        justProtection6 = checkJust(txtJustQ6);

        String check_name = getResources().getString(R.string.protection_name);
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.protection_name), mTitleFont);
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

            addQuestions(document,getResources().getString(R.string.protection_q1),answer1,justProtection1);
            addQuestions(document,getResources().getString(R.string.protection_q2),answer2,justProtection2);
            addQuestions(document,getResources().getString(R.string.protection_q3),answer3,justProtection3);
            addQuestions(document,getResources().getString(R.string.protection_q4),answer4,justProtection4);
            addQuestions(document,getResources().getString(R.string.protection_q5),answer5,justProtection5);
            addQuestions(document,getResources().getString(R.string.protection_q6),answer6,justProtection6);

            document.close();

            //Toast.makeText(getApplicationContext(), "Criado :)", Toast.LENGTH_SHORT).show();
            File file = new File(dest);
            Files.asCharSink(file, Charsets.UTF_8);
            createExportPDFDialog(file);

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Erro " + ie.getLocalizedMessage());
            LOGE("dir: "+dest);
            Toast.makeText(this, getResources().getString(R.string.fail_file), Toast.LENGTH_LONG).show();
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Nenhuma aplicação encontrada para abrir este arquivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void exportBoatingPDF() {

        // Data
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustQ1 = findViewById(R.id.justBoating_q1);
        EditText txtJustQ2 = findViewById(R.id.justBoating_q2);
        EditText txtJustQ3 = findViewById(R.id.justBoating_q3);
        EditText txtJustQ4 = findViewById(R.id.justBoating_q4);
        EditText txtJustQ5 = findViewById(R.id.justBoating_q5);
        EditText txtJustQ6 = findViewById(R.id.justBoating_q6);

        justBoating1 = checkJust(txtJustQ1);
        justBoating2 = checkJust(txtJustQ2);
        justBoating3 = checkJust(txtJustQ3);
        justBoating4 = checkJust(txtJustQ4);
        justBoating5 = checkJust(txtJustQ5);
        justBoating6 = checkJust(txtJustQ6);

        String check_name = getResources().getString(R.string.boating_name);
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.boating_name), mTitleFont);
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

            addQuestions(document,getResources().getString(R.string.boating_q1),answer1,justBoating1);
            addQuestions(document,getResources().getString(R.string.boating_q2),answer2,justBoating2);
            addQuestions(document,getResources().getString(R.string.boating_q3),answer3,justBoating3);
            addQuestions(document,getResources().getString(R.string.boating_q4),answer4,justBoating4);
            addQuestions(document,getResources().getString(R.string.boating_q5),answer5,justBoating5);
            addQuestions(document,getResources().getString(R.string.boating_q6),answer6,justBoating6);

            document.close();

            //Toast.makeText(getApplicationContext(), "Criado :)", Toast.LENGTH_SHORT).show();
            File file = new File(dest);
            Files.asCharSink(file, Charsets.UTF_8);
            createExportPDFDialog(file);

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Erro " + ie.getLocalizedMessage());
            LOGE("dir: "+dest);
            Toast.makeText(this, getResources().getString(R.string.fail_file), Toast.LENGTH_LONG).show();
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Nenhuma aplicação encontrada para abrir este arquivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void exportWomensPDF() {

        // Data
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustQ1 = findViewById(R.id.justWomens_q1);
        EditText txtJustQ2 = findViewById(R.id.justWomens_q2);
        EditText txtJustQ3 = findViewById(R.id.justWomens_q3);
        EditText txtJustQ4 = findViewById(R.id.justWomens_q4);
        EditText txtJustQ5 = findViewById(R.id.justWomens_q5);
        EditText txtJustQ6 = findViewById(R.id.justWomens_q6);

        justWomens1 = checkJust(txtJustQ1);
        justWomens2 = checkJust(txtJustQ2);
        justWomens3 = checkJust(txtJustQ3);
        justWomens4 = checkJust(txtJustQ4);
        justWomens5 = checkJust(txtJustQ5);
        justWomens6 = checkJust(txtJustQ6);

        String check_name = getResources().getString(R.string.womens_name);
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.womens_name), mTitleFont);
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

            addQuestions(document,getResources().getString(R.string.womens_q1),answer1,justWomens1);
            addQuestions(document,getResources().getString(R.string.womens_q2),answer2,justWomens2);
            addQuestions(document,getResources().getString(R.string.womens_q3),answer3,justWomens3);
            addQuestions(document,getResources().getString(R.string.womens_q4),answer4,justWomens4);
            addQuestions(document,getResources().getString(R.string.womens_q5),answer5,justWomens5);
            addQuestions(document,getResources().getString(R.string.womens_q6),answer5,justWomens6);

            document.close();

            //Toast.makeText(getApplicationContext(), "Criado :)", Toast.LENGTH_SHORT).show();
            File file = new File(dest);
            Files.asCharSink(file, Charsets.UTF_8);
            createExportPDFDialog(file);

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Erro " + ie.getLocalizedMessage());
            LOGE("dir: "+dest);
            Toast.makeText(this, getResources().getString(R.string.fail_file), Toast.LENGTH_LONG).show();
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Nenhuma aplicação encontrada para abrir este arquivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void exportMachinesPDF() {

        // Data
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustQ1 = findViewById(R.id.justMachines_q1);
        EditText txtJustQ2 = findViewById(R.id.justMachines_q2);
        EditText txtJustQ3 = findViewById(R.id.justMachines_q3);
        EditText txtJustQ4 = findViewById(R.id.justMachines_q4);
        EditText txtJustQ5 = findViewById(R.id.justMachines_q5);
        EditText txtJustQ6 = findViewById(R.id.justMachines_q6);
        EditText txtJustQ7 = findViewById(R.id.justMachines_q7);

        justMachines1 = checkJust(txtJustQ1);
        justMachines2 = checkJust(txtJustQ2);
        justMachines3 = checkJust(txtJustQ3);
        justMachines4 = checkJust(txtJustQ4);
        justMachines5 = checkJust(txtJustQ5);
        justMachines6 = checkJust(txtJustQ6);
        justMachines7 = checkJust(txtJustQ7);

        String check_name = getResources().getString(R.string.machines_name);
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.machines_name), mTitleFont);
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

            addQuestions(document,getResources().getString(R.string.machines_q1),answer1,justMachines1);
            addQuestions(document,getResources().getString(R.string.machines_q2),answer2,justMachines2);
            addQuestions(document,getResources().getString(R.string.machines_q3),answer3,justMachines3);
            addQuestions(document,getResources().getString(R.string.machines_q4),answer4,justMachines4);
            addQuestions(document,getResources().getString(R.string.machines_q5),answer5,justMachines5);
            addQuestions(document,getResources().getString(R.string.machines_q6),answer6,justMachines6);
            addQuestions(document,getResources().getString(R.string.machines_q7),answer7,justMachines7);

            document.close();

            //Toast.makeText(getApplicationContext(), "Criado :)", Toast.LENGTH_SHORT).show();
            File file = new File(dest);
            Files.asCharSink(file, Charsets.UTF_8);
            createExportPDFDialog(file);

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Erro " + ie.getLocalizedMessage());
            LOGE("dir: "+dest);
            Toast.makeText(this, getResources().getString(R.string.fail_file), Toast.LENGTH_LONG).show();
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Nenhuma aplicação encontrada para abrir este arquivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void exportEletricalPDF() {

        // Data
        String responsable = txtResponsable.getText().toString();
        String data = txtData.getText().toString();
        EditText txtJustQ1 = findViewById(R.id.justEletrical_q1);
        EditText txtJustQ2 = findViewById(R.id.justEletrical_q2);
        EditText txtJustQ3 = findViewById(R.id.justEletrical_q3);
        EditText txtJustQ4 = findViewById(R.id.justEletrical_q4);
        EditText txtJustQ5 = findViewById(R.id.justEletrical_q5);
        EditText txtJustQ6 = findViewById(R.id.justEletrical_q6);
        EditText txtJustQ7 = findViewById(R.id.justEletrical_q7);

        justEletrical1 = checkJust(txtJustQ1);
        justEletrical2 = checkJust(txtJustQ2);
        justEletrical3 = checkJust(txtJustQ3);
        justEletrical4 = checkJust(txtJustQ4);
        justEletrical5 = checkJust(txtJustQ5);
        justEletrical6 = checkJust(txtJustQ6);
        justEletrical7 = checkJust(txtJustQ7);

        String check_name = getResources().getString(R.string.eletrical_name);
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
            Chunk mTitleChunk = new Chunk(getResources().getString(R.string.eletrical_name), mTitleFont);
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

            addQuestions(document,getResources().getString(R.string.eletrical_q1),answer1,justEletrical1);
            addQuestions(document,getResources().getString(R.string.eletrical_q2),answer2,justEletrical2);
            addQuestions(document,getResources().getString(R.string.eletrical_q3),answer3,justEletrical3);
            addQuestions(document,getResources().getString(R.string.eletrical_q4),answer4,justEletrical4);
            addQuestions(document,getResources().getString(R.string.eletrical_q5),answer5,justEletrical5);
            addQuestions(document,getResources().getString(R.string.eletrical_q6),answer6,justEletrical6);
            addQuestions(document,getResources().getString(R.string.eletrical_q7),answer7,justEletrical7);

            document.close();

            //Toast.makeText(getApplicationContext(), "Criado :)", Toast.LENGTH_SHORT).show();
            File file = new File(dest);
            Files.asCharSink(file, Charsets.UTF_8);
            createExportPDFDialog(file);

        } catch (IOException | DocumentException ie) {
            LOGE("createPdf: Erro " + ie.getLocalizedMessage());
            LOGE("dir: "+dest);
            Toast.makeText(this, getResources().getString(R.string.fail_file), Toast.LENGTH_LONG).show();
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Nenhuma aplicação encontrada para abrir este arquivo.", Toast.LENGTH_SHORT).show();
        }
    }


}
