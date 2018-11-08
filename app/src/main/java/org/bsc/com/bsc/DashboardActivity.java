package org.bsc.com.bsc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bsc.com.bsc.PdfView.SampleActivity;
import org.bsc.com.bsc.VideoPlayerView.FullscreenActivity;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


public class DashboardActivity extends Activity {
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HashMap<String,String> contentData;
    FinalExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    String FILE_NAME ="hello.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expandableListView);
        // Read json data from local file and parsing the data to arraylist
        String jsonData =    readFileFromAssets();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        final Model model = gson.fromJson(jsonData, Model.class);
        System.out.print("JSON parse is done");

        listAdapter = new FinalExpandableListAdapter(this, model);

        // listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

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

                     String fileName = model.getCategories().get(groupPosition).getSubcategories().get(childPosition).getUrl();
                if(fileName.contains(".pdf")){
                    Intent intent = new Intent(DashboardActivity.this, SampleActivity.class);
                    intent.putExtra("fileName",fileName);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DashboardActivity.this, FullscreenActivity.class);
                    intent.putExtra("fileName",fileName);
                    startActivity(intent);
                }

                return false;
            }
        });

    }

    public String readFileFromAssets(){
        String text = "";
        try{
            InputStream inputStream = getAssets().open("dashboardui.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
           }

}
