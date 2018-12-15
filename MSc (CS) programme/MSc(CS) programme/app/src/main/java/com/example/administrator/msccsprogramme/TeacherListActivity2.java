package com.example.administrator.msccsprogramme;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TeacherListActivity2 extends BaseActivity {
    private List<Teacher2> teacherList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        initTeachers();
        TeacherAdapter2 teacherAdapter = new TeacherAdapter2(TeacherListActivity2.this,R.layout.teacher_item2, teacherList);
        ListView teacherListView= (ListView) findViewById(R.id.teacher_list_view);
    //        courseListView.setBackgroundColor(getResources().getColor(R.color.HotPink));
            teacherListView.setAdapter(teacherAdapter);
    }
    private void initTeachers(){
        Teacher2 t;
        t = new Teacher2(0,"",getResources().getString(R.string.faculty_introduction),"","", "");
        teacherList.add(t);
//        t = new Teacher2(R.drawable.ti_chan_h,"Dr. Chan H.T.H.","PhD (Carnegie Mellon)","Field of Research","Algorithms, Combinatorial Optimization, Graphs, Information Networks, Security & Privacy");
//        teacherList.add(t);
        try{
            InputStream inputStream = getResources().openRawResource(R.raw.teachers2);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String[] teacherInfo;
            Teacher2 teacher;
            int teacherImageID = 0;
            while ((line = bufferedReader.readLine())!=null){
                teacherInfo = line.split(";");
                switch (teacherInfo[0]){
                    case "Dr. Chan H.T.H.":
                        teacherImageID = R.drawable.ti_chan_h;
                        break;
                    case "Dr. Chan K.P.":
                        teacherImageID = R.drawable.ti_chan_k;
                        break;
                    case "Dr. Cheng R.C.K.":
                        teacherImageID = R.drawable.ti_cheng_r;
                        break;
                    case "Dr. Chim T.W.":
                        teacherImageID = R.drawable.ti_chim_tw;
                        break;
                    case "Dr. Choi L.Y.K.":
                        teacherImageID = R.drawable.ti_choi_lyk;
                        break;
                    case "Dr. Chow K.P.":
                        teacherImageID = R.drawable.ti_chow_kp;
                        break;
                    case "Dr. Chung H.Y.":
                        teacherImageID = R.drawable.ti_chung_hy;
                        break;
                    case "Dr. Lau V.M.K.":
                        teacherImageID = R.drawable.ti_lau_vmk;
                        break;
                    case "Dr. Pun K.K.H.":
                        teacherImageID = R.drawable.ti_pun_kkh;
                        break;
                    case "Dr. Rahmel J.H.":
                        teacherImageID = R.drawable.ti_rahmeljuergen;
                        break;
                    case "Dr. Schnieders D.":
                        teacherImageID = R.drawable.ti_schnieders_d;
                        break;
                    case "Dr. Tam A.T.C.":
                        teacherImageID = R.drawable.ti_tam_atc;
                        break;
                    case "Dr. Ting H.F.":
                        teacherImageID = R.drawable.ti_ting_hf;
                        break;
                    case "Dr. Wong K.K.Y.":
                        teacherImageID = R.drawable.ti_wong_kky;
                        break;
                    case "Dr. Wu C.":
                        teacherImageID = R.drawable.ti_wu_c;
                        break;
                    case "Dr. Yiu S.M.":
                        teacherImageID = R.drawable.ti_yiu_sm;
                        break;
                    case "Dr. Yiu S.W.":
                        teacherImageID = R.drawable.ti_yiu_sw;
                        break;
                    case "Mr. Mitcheson, G.":
                        teacherImageID = R.drawable.ti_mitcheson_g;
                        break;
                    case "Mr. Ng P.T.L.":
                        teacherImageID = R.drawable.ti_ng_ptl;
                        break;
                    case "Prof. Cheung D.W.L.":
                        teacherImageID = R.drawable.ti_cheung_dwl;
                        break;
                    case "Prof. Kao B.C.M.":
                        teacherImageID = R.drawable.ti_kao_bcm;
                        break;
                    case "Prof. Lam T.W.":
                        teacherImageID = R.drawable.ti_lam_tw;
                        break;
                    case "Prof. Lau F.C.M.":
                        teacherImageID = R.drawable.ti_lau_fcm;
                        break;
                    case "Prof. Tse T.H.":
                        teacherImageID = R.drawable.ti_tse_th;
                        break;
                    case "Prof. Wang C.L.":
                        teacherImageID = R.drawable.ti_wang_cl;
                        break;
                    case "Prof. Wang W.":
                        teacherImageID = R.drawable.ti_wang_w;
                        break;
                    case "Prof. White B.":
                        teacherImageID = R.drawable.ti_bebo_white;
                        break;
                    default:
                        teacherImageID = 0;
                        break;
                }
                teacher = new Teacher2(teacherImageID,teacherInfo[0],teacherInfo[1],teacherInfo[2],teacherInfo[3], teacherInfo[4]);
                teacherList.add(teacher);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
