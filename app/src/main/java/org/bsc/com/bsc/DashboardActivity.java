package org.bsc.com.bsc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;


import org.bsc.com.bsc.PdfView.SampleActivity;
import org.bsc.com.bsc.VideoPlayerView.FullscreenActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class DashboardActivity extends Activity {
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HashMap<String,String> contentData;
    org.bsc.com.bsc.ExpandableListAdapter listAdapter;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expandableListView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        //Keep open expandable list view
        int count = listAdapter.getGroupCount();
        for ( int i = 0; i < count; i++ )
            expListView.expandGroup(i);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                     String fileName = contentData.get(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                if(fileName.contains(".pdf")){
                    Intent intent = new Intent(DashboardActivity.this, SampleActivity.class);
                    intent.putExtra("fileName",fileName);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DashboardActivity.this, FullscreenActivity.class);
                    intent.putExtra("fileName",fileName);
                    startActivity(intent);
                }





//                File file = new File(Environment.getExternalStorageDirectory(),
//                        "Report.pdf");
//                Uri path = Uri.fromFile(file);
//                Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
//                pdfOpenintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                pdfOpenintent.setDataAndType(path, "application/pdf");
//                try {
//                    startActivity(pdfOpenintent);
//                }
//                catch (ActivityNotFoundException e) {
//
//                }



//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
//                startMuPDFActivityWithExampleFile();
                return false;
            }
        });
    }

//    public void startMuPDFActivity(Uri documentUri) {
//        Intent intent = new Intent(DashboardActivity.this, DocumentActivity.class);
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setData(documentUri);
//        startActivity(intent);
//    }
//
//    public void startMuPDFActivityWithExampleFile() {
//        File dir = Environment.getExternalStoragePublicDirectory
//                (Environment.DIRECTORY_DOWNLOADS);
//        File file = new File(dir, "test.pdf");
//        Uri uri = Uri.fromFile(file);
//        startMuPDFActivity(uri);
//    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        contentData = new HashMap<String, String>();
        listDataHeader.add("Introduction");
        listDataHeader.add("Technical Infra Solution Deep Dive & Sub-Tower Transformation");
        listDataHeader.add("Technical Apps Solution Deep Dive & Sub-Tower Transformation");
        listDataHeader.add("Transition");
        listDataHeader.add("Solution Summary and Transformation");
        listDataHeader.add("About Infosys");
        listDataHeader.add("Additional Demos");

// Adding child data
        List<String> Intro = new ArrayList<String>();
        Intro.add("Infosys Team Introduction");

        List<String> technicalInfraSolution = new ArrayList<String>();
        technicalInfraSolution.add("Infrastructure Overview");
//technicalInfraSolution.add("Business Aligned Command Center Demo");
        technicalInfraSolution.add("Infrastructure Tower Level Solution");
        technicalInfraSolution.add("Service Desk and End User Services");
        technicalInfraSolution.add("Security");
        technicalInfraSolution.add("Non-Labor Sourcing");

        List<String> technicalAppSolns = new ArrayList<String>();
        technicalAppSolns.add("Application Services Overview");
        technicalAppSolns.add("Application Development");
//technicalAppSolns.add("Self Service Action Bot - Password Reset");
//technicalAppSolns.add("Self Service Information Bot - Knowledge Search");
        technicalAppSolns.add("Application Support");
        technicalAppSolns.add("Application Testing");

        List<String> transition = new ArrayList<String>();
        transition.add("Transition");

        List<String> solutionSummaryTransition = new ArrayList<String>();
        solutionSummaryTransition.add("Executive Summary");
//solutionSummaryTransition.add("Transformation");

        List<String> aboutInfosys = new ArrayList<String>();
        aboutInfosys.add("Infosys Corporate Presentation");

        List<String> otherDemos = new ArrayList<String>();
        otherDemos.add("Business Aligned Command Center");
        otherDemos.add("Contact Center");
        otherDemos.add("FAQ Bot");
        otherDemos.add("Infosys Healthcare Requirements Manager");
        otherDemos.add("Infosys Claims Advantage Platform");
        otherDemos.add("L3 Fix");
        otherDemos.add("Lex ELearning");
        otherDemos.add("Password Reset");


        contentData.put("Infosys Team Introduction","Introduction.pdf");
        contentData.put("Infrastructure Overview","InfrastructureServicesOverview.pdf");
//contentData.put("Business Aligned Command Center Demo","BusinessAligned.mp4");
        contentData.put("Infrastructure Tower Level Solution","InfrastructureTowerLevelSolution.pdf");
        contentData.put("Service Desk and End User Services","EndUserServices.pdf");
        contentData.put("Security","Security.pdf");
        contentData.put("Non-Labor Sourcing","NonLaborSourcing.pdf");

        contentData.put("Application Services Overview","ApplicationServicesOverview.pdf");
        contentData.put("Application Development","ApplicationDevelopment.pdf");
//contentData.put("Self Service Action Bot - Password Reset","SelfServiceActionBot.mp4");
//contentData.put("Self Service Information Bot - Knowledge Search","SelfServiceInformationBot.mp4");
        contentData.put("Application Support","ApplicationSupport.pdf");
        contentData.put("Application Testing","ApplicationTesting.pdf");

        contentData.put("Transition","Transition.pdf");

        contentData.put("Executive Summary","ExecutiveSummary.pdf");

        contentData.put("Infosys Corporate Presentation","InfosysCorporate.pdf");

        contentData.put("Business Aligned Command Center","Business Aligned.mp4");
        contentData.put("Contact Center","Contact Center.mp4");
        contentData.put("FAQ Bot","FAQ Bot.mp4");
        contentData.put("Password Reset","Password Reset.mp4");
        contentData.put("L3 Fix","L3 Fix.mp4");
        contentData.put("Lex ELearning","Lex ELearning.mp4");
        contentData.put("Infosys Healthcare Requirements Manager","iHRM.mp4");
        contentData.put("Infosys Claims Advantage Platform","InfosysClaimsAdvantagePlatform.mp4");

//contentData.put("Infosys Healthcare Requirements Management Solution","InfosysHRMS.mp4");
//contentData.put("Infosys Claims Advantage Platform","InfosysCAP.mp4");
        listDataChild.put(listDataHeader.get(0), Intro);
        listDataChild.put(listDataHeader.get(1), technicalInfraSolution);
        listDataChild.put(listDataHeader.get(2), technicalAppSolns);
        listDataChild.put(listDataHeader.get(3), transition);
        listDataChild.put(listDataHeader.get(4), solutionSummaryTransition);
        listDataChild.put(listDataHeader.get(5), aboutInfosys);
        listDataChild.put(listDataHeader.get(6), otherDemos);
    }
}
