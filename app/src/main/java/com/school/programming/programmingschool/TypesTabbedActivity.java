package com.school.programming.programmingschool;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.school.programming.programmingschool.dummy.TextDrawable;

public class TypesTabbedActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private RadioGroup radioGroup;
    private RadioButton correcAnswer;
    private int selectedId;
    private Snackbar snackbar;
    private RadioButton rb;
    private int progress;
    private int failedAttempts;
    private SharedPreferences sharedPreferences;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private int savedValue;
    private int enteredFeedbackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        setTitle("Java Variable Types");
        onFabClicked();

    }


public void onFabClicked(){

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
    fab.setImageDrawable(new TextDrawable(fab.getContext(), "Next", ColorStateList.valueOf(Color.WHITE), 55.f, TextDrawable.VerticalAlignment.BASELINE));


    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(enteredFeedbackView > 0){

            if (mViewPager.getCurrentItem() == 0) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                progress++;
            } else if (mViewPager.getCurrentItem() == 1) {
                radioGroup = (RadioGroup) findViewById(R.id.typesQuiz);
                //Quiz Snackbar feedback goes here
                selectedId = radioGroup.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(selectedId);
                if (rb != null) {
                    //If selection is correct
                    String answer = rb.getText().toString();
                    if (answer.matches("Two")) {
                        snackbar = Snackbar.make(mViewPager, "That's Correct!", Snackbar.LENGTH_LONG);
                        View snackBarView = snackbar.getView();
                        snackBarView.setBackgroundColor(Color.parseColor("#009688"));
                        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.WHITE);
                        snackbar.show();
                        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                        progress++;
                        TextView typesFeedbackTV = (TextView) findViewById(R.id.typesFeedbackTV);
                        TextView typesFeedbackStats = (TextView) findViewById(R.id.typesFeedbackStats);

                        typesFeedbackTV.setText(" Congratulations, You have successfully completed the Java Types Tutorial");
                        typesFeedbackTV.setTextColor(Color.parseColor("#009688"));
                        typesFeedbackTV.setTextSize(40);
                        typesFeedbackTV.setPadding(0, 10, 0, 0);
                        enteredFeedbackView++;
                        if (failedAttempts > 0) {
                            typesFeedbackStats.setText("Number of failed attempts: " + failedAttempts + "\nWe recommend that do more revision on Java Variable Types chapter");
                            typesFeedbackStats.setTextColor(Color.parseColor("#ef5350"));
                            typesFeedbackStats.setTextSize(25);
                        } else if (failedAttempts == 0) {
                            typesFeedbackStats.setText("Number of failed attempts: " + failedAttempts + "\nYou are good to progress to the next tutorial! Wohoo!");
                            typesFeedbackStats.setTextColor(Color.parseColor("#009688"));
                            typesFeedbackStats.setTextSize(25);
                        }
                    } else {
                        snackbar = Snackbar.make(mViewPager, "That's not quite right. Try again!", Snackbar.LENGTH_LONG);
                        View snackBarView = snackbar.getView();
                        snackBarView.setBackgroundColor(Color.parseColor("#ef5350"));
                        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.WHITE);
                        snackbar.show();
                        failedAttempts++;
                        savedValue = failedAttempts;
                    }
                }
            }
            }
        }
    });

}

    public void SaveInt(String key, int value){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void LoadInt(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        savedValue = sharedPreferences.getInt("key", 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed_types, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.placeholder_fragment_types, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            switch (position) {
                case 0:
                    return FragmentFirst.newInstance(position);
                case 1:
                    return FragmentSecond.newInstance(position);
                case 2:
                    return FragmentThird.newInstance(position);
                default:
                    //assume you only have 3
                    throw new IllegalArgumentException();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Notes";
                case 1:
                    return "Quiz";
                case 2:
                    return "Feedback";
            }
            return null;
        }
    }

    public static class FragmentFirst extends Fragment{

        ViewPager viewPager;
        FloatingActionButton fab;


        public static FragmentFirst newInstance(int sectionNumber) {
            FragmentFirst fragment = new FragmentFirst();

            return fragment;
        }

        public FragmentFirst() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            final View rootView = inflater.inflate(R.layout.fragment_types_notes, container, false);

/*          //Using Text View
            // get our html content
            String htmlAsString = getString(R.string.types_notes_content);      // used by WebView
            Spanned htmlAsSpanned = Html.fromHtml(htmlAsString); // used by TextView

            // set the html content on a TextView
            TextView textView = (TextView)rootView.findViewById(R.id.typesNotesTV);
            textView.setText(htmlAsSpanned);
*/


            WebView webView = (WebView)rootView.findViewById(R.id.typesNotesTV);
            String HTML = getString(R.string.types_notes_content);
            WebSettings settings = webView.getSettings();
            settings.setDefaultTextEncodingName("utf-8");
            webView.loadDataWithBaseURL(null, HTML, "text/html", "utf-8", null);

                return rootView;

        }

    }

    public static class FragmentSecond extends Fragment {
        public static FragmentSecond newInstance(int sectionNumber) {
            FragmentSecond fragment = new FragmentSecond();
            return fragment;
        }

        public FragmentSecond() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_types_quiz, container, false);
            return rootView;
        }



    }


    public static class FragmentThird extends Fragment {
        public static FragmentThird newInstance(int sectionNumber) {
            FragmentThird fragment = new FragmentThird();
            return fragment;
        }

        public FragmentThird() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_types_feedback, container, false);
            return rootView;
        }
    }
}