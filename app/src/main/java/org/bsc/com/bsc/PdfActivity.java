//package org.molina.com.molina;
//
//import android.app.Activity;
//import android.content.res.Configuration;
//import android.support.v4.app.FragmentActivity;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.Window;
//
//public class PdfActivity extends Activity {
//    private MuPDFCore core;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_pdf);
//        core = getMuPdfCore(savedInstanceState);
//
//        if (core == null) {
//            return;
//        }
//        orientation = AppData.getScreenOrientation(this);
//        mOrientation = getResources().getConfiguration().orientation;
//
//        if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
//            core.setDisplayPages(2);
//        } else {
//            core.setDisplayPages(1);
//        }
//        createUI(savedInstanceState);
//
//        setTitle(getIntent());
//        // hideLayout();
////		if (SectionSubSectionActivity.instance != null) {
////			try {
////				SectionSubSectionActivity.instance.finish();
////			} catch (Exception e) {
////			}
////		}
//        setListenerAndLoadAnimation();
//        setPageCount(pageScreen);
//
//        if (pageScreen != 0) {
//            if (orientation == 0 || orientation == 2) {
//
//                docView.setDisplayedViewIndex(pageScreen * 2 - 1);
//
//                // handler.sendEmptyMessageDelayed(0, 500);
//            } else {
//                if (pageScreen % 2 == 0) {
//                    docView.setDisplayedViewIndex(pageScreen / 2);
//                } else
//                    docView.setDisplayedViewIndex(pageScreen / 2 + 1);
//                // handler.sendEmptyMessageDelayed(0, 500);
//            }
//
//        } else {
//            docView.setDisplayedViewIndex(0);
//            // handler.sendEmptyMessageDelayed(0, 500);
//        }
//
//    }
//}
