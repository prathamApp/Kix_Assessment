package com.kix.assessment.ui.attendance_activity.FragmentSelectStudent;

import static com.kix.assessment.KIXApplication.attendanceDao;
import static com.kix.assessment.KIXApplication.logDao;
import static com.kix.assessment.KIXApplication.parentInformationDao;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.KIXApplication.studentDao;
import static com.kix.assessment.kix_utils.Kix_Constant.HOUSEHOLD_ID;
import static com.kix.assessment.kix_utils.Kix_Constant.STUDENT_ID;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.custom.BlurPopupDialog.BlurPopupWindow;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.custom.flexbox.AlignItems;
import com.kix.assessment.custom.flexbox.FlexDirection;
import com.kix.assessment.custom.flexbox.FlexboxLayoutManager;
import com.kix.assessment.custom.flexbox.JustifyContent;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Attendance;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Modal_PIF;
import com.kix.assessment.modal_classes.Modal_Session;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.services.KixSmartSync;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form.Fragment_AddParentInfoForm;
import com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form.Fragment_AddParentInfoForm_;
import com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form.Fragment_ParentInformation;
import com.kix.assessment.ui.attendance_activity.FragmentSelectStudent.parent_information_form.Fragment_ParentInformation_;
import com.kix.assessment.ui.attendance_activity.Fragment_AddStudent;
import com.kix.assessment.ui.attendance_activity.Fragment_AddStudent_;
import com.kix.assessment.ui.main_test.WebViewActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Objects;

@EFragment(R.layout.fragment_select_student)
public class Fragment_SelectStudent extends Fragment implements ContractStudentList{

    private static final int REQUEST_CODE_ASSESSMENT_BACK = 1111;

    @ViewById(R.id.rv_student)
    RecyclerView rv_student;

    @ViewById(R.id.fab_addChild)
    FloatingActionButton fab_addChild;

    private ArrayList<Modal_Student> students = new ArrayList<>();
    private boolean itemSelected;
    String surveyorCode, householdID;
    Modal_Student add_student = new Modal_Student();

    private StudentListAdapter studentListAdapter;

    public Fragment_SelectStudent() {/*Required constructor*/}

    @AfterViews
    public void initialize(){
        Log.e("KIX : ","selectstud");
        this.surveyorCode = this.getArguments().getString(Kix_Constant.SURVEYOR_CODE);
        this.householdID = this.getArguments().getString(HOUSEHOLD_ID);
        //students = getArguments() != null ? getArguments().getParcelableArrayList(Kix_Constant.STUDENT_LIST) : null;
        this.students = (ArrayList<Modal_Student>) studentDao.getAllStudentsBySurveyorCodeDescending(this.surveyorCode, this.householdID);
        if(this.students.size()==0){
            Toast.makeText(this.getActivity(), getString(R.string.no_student_found), Toast.LENGTH_SHORT).show();
            final Animation anim = android.view.animation.AnimationUtils.loadAnimation(this.fab_addChild.getContext(),  R.anim.shake);
            anim.setDuration(200L);
            this.fab_addChild.startAnimation(anim);
        }
/*
        add_student.setStud_Name("Add Child");
        if (!students.contains(add_student)){
            students.add(add_student);
        }
*/
        this.initializeAdapter();
    }

    @UiThread
    public void initializeAdapter() {
        if (this.studentListAdapter == null) {
            this.studentListAdapter = new StudentListAdapter(this.students, this.getActivity(), this);
            this.rv_student.setHasFixedSize(true);
            final FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this.getActivity(), FlexDirection.ROW);
            flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
            flexboxLayoutManager.setAlignItems(AlignItems.FLEX_START);
            this.rv_student.setLayoutManager(flexboxLayoutManager);
            this.rv_student.setAdapter(this.studentListAdapter);
        } else {
            this.studentListAdapter.notifyDataSetChanged();
        }
    }

    @Click(R.id.fab_addChild)
    public void addChild(){
        final Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
        bundle.putString(HOUSEHOLD_ID, this.householdID);
        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddStudent_(), R.id.attendance_frame,
                    bundle, Fragment_AddStudent.class.getSimpleName());
    }

    boolean loaderFlg;
    private BlurPopupWindow pushDialog, pushStatusDialogue;
    private TextView tv_dia_vil;
    private TextView tv_dia_survey;

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Fragment_SelectStudent.REQUEST_CODE_ASSESSMENT_BACK) {
            this.studentListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.rv_student.setAdapter(null);
        this.studentListAdapter = null;
        this.rv_student =null;
    }
    private TextView tv_dia_stud;
    private TextView tv_dia_score;
    private TextView tv_dialTitle;
    private CustomLodingDialog myLoadingDialog;

    @Override
    public void itemSelected(final int position) {
  /*      Bundle bundle = new Bundle();
        if(position == students.size()-1) {
            bundle.putString(Kix_Constant.SURVEYOR_CODE,surveyorCode);
            bundle.putString(Kix_Constant.HOUSEHOLD_ID,householdID);
            KIX_Utility.showFragment(getActivity(), new Fragment_AddStudent_(), R.id.attendance_frame,
                    bundle, Fragment_AddStudent.class.getSimpleName());
        }
        else {*/
            final Modal_Student modalStudnet = this.studentListAdapter.getitem(position);
            FastSave.getInstance().saveString(STUDENT_ID, ""+modalStudnet.getStudentId());

            FastSave.getInstance().saveString(Kix_Constant.SESSIONID, KIX_Utility.getUUID().toString());
        this.markAttendance(modalStudnet);
            final Intent intent = new Intent(this.getActivity(), WebViewActivity_.class);
            intent.putExtra(Kix_Constant.STUDENT_NAME, modalStudnet.getCH01());
        this.startActivityForResult(intent, Fragment_SelectStudent.REQUEST_CODE_ASSESSMENT_BACK);
        //}
    }

    @Override
    public void editStudent(final int position) {
        final Modal_Student modalStudnet = this.studentListAdapter.getitem(position);
        final Bundle bundle = new Bundle();
        bundle.putString(Kix_Constant.EDIT_STUDENT,Kix_Constant.EDIT_STUDENT);
        bundle.putString(STUDENT_ID,modalStudnet.getStudentId());

        KIX_Utility.showFragment(this.getActivity(), new Fragment_AddStudent_(), R.id.attendance_frame,
                bundle, Fragment_AddStudent.class.getSimpleName());
    }

    @Override
    public void addPIF(int position) {
        final Modal_Student modal_student = this.studentListAdapter.getitem(position);
        final Bundle bundle = new Bundle();
        bundle.putString(STUDENT_ID, modal_student.getStudentId());
        bundle.putString(HOUSEHOLD_ID, modal_student.getHouseholdId());

        Modal_PIF modalPif = parentInformationDao.getPIFbyStudentId(modal_student.getStudentId());
        if(modalPif!=null)
            KIX_Utility.showFragment(this.getActivity(), new Fragment_ParentInformation_(), R.id.attendance_frame,
                bundle, Fragment_ParentInformation.class.getSimpleName());
        else
            KIX_Utility.showFragment(this.getActivity(), new Fragment_AddParentInfoForm_(), R.id.attendance_frame,
                    bundle, Fragment_AddParentInfoForm.class.getSimpleName());
    }

    private void markAttendance(final Modal_Student stud) {
        //<editor-fold desc="below code is for saving the student attendance so as to pass it to "meri dukan" game, nothing else">
 /*       ArrayList<Modal_Student> stuList = new ArrayList<>();
        stuList.add(stud);
        String stu_json = new Gson().toJson(stuList);
        FastSave.getInstance().saveString(PD_Constant.PRESENT_STUDENTS, stu_json);*/
        //</editor-fold>
        final ArrayList<Attendance> attendances = new ArrayList<>();
        final Attendance attendance = new Attendance();
        attendance.sessionId = FastSave.getInstance().getString(Kix_Constant.SESSIONID, "");
        attendance.studentId = stud.getStudentId();
        attendance.attendanceDate = KIX_Utility.getCurrentDateTime();
        attendance.sentFlag = 0;
        attendances.add(attendance);
        attendanceDao.insertAttendance(attendances);
        final Modal_Session s = new Modal_Session();
        s.setSessionId(FastSave.getInstance().getString(Kix_Constant.SESSIONID, ""));
        s.setFromDate(KIX_Utility.getCurrentDateTime());
//        s.setToDate("NA");
        sessionDao.insert(s);
    }

    @Override
    public void onResume() {
//        FastSave.getInstance().saveString(Kix_Constant.SESSIONID, "NA");
        KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
        super.onResume();
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DataPushedSuccessfully(final EventMessage msg) {
        if (msg != null) {
            if (msg.getMessage().equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED)) {
                if (this.loaderFlg) {
                    this.myLoadingDialog.dismiss();
                    this.loaderFlg = false;
                }
                this.pushDialog(this.getResources().getString(R.string.push_success), Kix_Constant.SUCCESSFULLYPUSHED);
                BackupDatabase.backup(this.getActivity());
            } else if (msg.getMessage().equalsIgnoreCase(Kix_Constant.PUSHFAILED)) {
                if (this.loaderFlg) {
                    this.myLoadingDialog.dismiss();
                    this.loaderFlg = false;
                }
                this.pushDialog(this.getResources().getString(R.string.push_fail),Kix_Constant.PUSHFAILED);
            }
        }
    }

    public void pushDialog(final String message, final String pushType) {
        this.pushDialog = new BlurPopupWindow.Builder(this.getActivity())
                .setContentView(R.layout.dialog_push_result)
                .bindClickListener(v -> {
                    this.pushStatsDialog();
                    this.pushDialog.dismiss();
                }, R.id.dia_btnOk)
                .setGravity(Gravity.CENTER)
                .setDismissOnTouchBackground(false)
                .setDismissOnClickBack(true)
                .setScaleRatio(0.2f)
                .setBlurRadius(10)
                .setTintColor(0x30000000)
                .build();
        this.tv_dialTitle = this.pushDialog.findViewById(R.id.dia_title);
        this.tv_dialTitle.setText(""+message);
        if (pushType.equalsIgnoreCase(Kix_Constant.SUCCESSFULLYPUSHED)) {
            this.tv_dialTitle.setTextColor(this.getResources().getColor(R.color.colorBtnGreenDark));
        }else {
            this.tv_dialTitle.setTextColor(this.getResources().getColor(R.color.colorRedDark));
        }
        this.pushDialog.show();
    }

    public void pushStatsDialog() {
        this.pushStatusDialogue = new BlurPopupWindow.Builder(this.getActivity())
                .setContentView(R.layout.dialog_push_stats)
                .bindClickListener(v -> {
                    this.pushStatusDialogue.dismiss();
                }, R.id.dia_btnOk)
                .setGravity(Gravity.CENTER)
                .setDismissOnTouchBackground(false)
                .setDismissOnClickBack(true)
                .setScaleRatio(0.2f)
                .setBlurRadius(10)
                .setTintColor(0x30000000)
                .build();
        this.tv_dia_vil = this.pushStatusDialogue.findViewById(R.id.dia_vil);
        this.tv_dia_survey = this.pushStatusDialogue.findViewById(R.id.dia_survey);
        this.tv_dia_stud = this.pushStatusDialogue.findViewById(R.id.dia_stud);
        this.tv_dia_score = this.pushStatusDialogue.findViewById(R.id.dia_score);

        this.tv_dia_score.setText(this.getResources().getString(R.string.score_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.SCORE_COUNT, "0"));
        this.tv_dia_stud.setText(this.getResources().getString(R.string.student_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.STUDENT_COUNT, "0"));
        this.tv_dia_vil.setText(this.getResources().getString(R.string.village_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.VILLAGE_COUNT, "0"));
        this.tv_dia_survey.setText(this.getResources().getString(R.string.surveyor_count)
                + "" + FastSave.getInstance().getString(Kix_Constant.SURVEYOR_COUNT, "0"));

        this.pushStatusDialogue.show();
    }

    @UiThread
    public void showLoadingDialog() {
        this.loaderFlg = true;
        this.myLoadingDialog = new CustomLodingDialog(Objects.requireNonNull(this.getActivity()));
        this.myLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.myLoadingDialog.setContentView(R.layout.dialog_loader);
        Objects.requireNonNull(this.myLoadingDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.myLoadingDialog.setCancelable(false);
        this.myLoadingDialog.setCanceledOnTouchOutside(false);
        this.myLoadingDialog.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
