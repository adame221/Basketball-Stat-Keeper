package com.example.aely.basketballstattracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mAwayTeam, mHomeTeam, mAwayTeamScore, mHomeTeamScore;
    private int mIntAwayTeamScore, mIntHomeTeamScore = 0;
    private String mStrAway, mStrHome = "";
    private Button mSaveAway;
    private EditText mHomeEdit, mAwayEdit;
    private Button mSaveHome;
    private ArrayList<Scores> mScores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScrollView mScrollView;
        Button mAwayTeamPlusThree, mAwayTeamPlusTwo, mAwayTeamPlusOne, mHomeTeamPlusThree,
                mHomeTeamPlusTwo, mHomeTeamPlusOne, mAwayTeamMinusThree, mAwayTeamMinusTwo,
                mAwayTeamMinusOne, mHomeTeamMinusThree, mHomeTeamMinusTwo, mHomeTeamMinusOne;

        if(mScores == null) {
            mScores = new ArrayList<>();
        }

        mAwayTeam = (TextView) findViewById(R.id.awayTeam);
        mHomeTeam = (TextView) findViewById(R.id.homeTeam);
        mAwayTeamScore = (TextView) findViewById(R.id.awayTeamScore);
        mHomeTeamScore = (TextView) findViewById(R.id.homeTeamScore);
        mAwayTeamPlusThree = (Button) findViewById(R.id.awayTeamPlusThree);
        mAwayTeamPlusTwo = (Button) findViewById(R.id.awayTeamPlusTwo);
        mAwayTeamPlusOne = (Button) findViewById(R.id.awayTeamPlusOne);
        mHomeTeamPlusThree = (Button) findViewById(R.id.homeTeamPlusThree);
        mHomeTeamPlusTwo = (Button) findViewById(R.id.homeTeamPlusTwo);
        mHomeTeamPlusOne = (Button) findViewById(R.id.homeTeamPlusOne);
        mAwayTeamMinusThree = (Button) findViewById(R.id.awayTeamMinusThree);
        mAwayTeamMinusTwo = (Button) findViewById(R.id.awayTeamMinusTwo);
        mAwayTeamMinusOne = (Button) findViewById(R.id.awayTeamMinusOne);
        mHomeTeamMinusThree = (Button) findViewById(R.id.homeTeamMinusThree);
        mHomeTeamMinusTwo = (Button) findViewById(R.id.homeTeamMinusTwo);
        mHomeTeamMinusOne = (Button) findViewById(R.id.homeTeamMinusOne);
        mAwayEdit = (EditText) findViewById(R.id.awayEdit);
        mSaveAway = (Button) findViewById(R.id.saveAway);
        mHomeEdit = (EditText) findViewById(R.id.homeEdit);
        mSaveHome = (Button) findViewById(R.id.saveHome);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);

        mAwayTeam.setVisibility(View.VISIBLE);
        mHomeTeam.setVisibility(View.VISIBLE);
        mAwayEdit.setVisibility(View.GONE);
        mHomeEdit.setVisibility(View.GONE);
        mSaveAway.setVisibility(View.GONE);
        mSaveHome.setVisibility(View.GONE);

        mAwayTeamPlusThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntAwayTeamScore = Integer.parseInt(mAwayTeamScore.getText().toString());
                mIntAwayTeamScore = mIntAwayTeamScore + 3;
                mAwayTeamScore.setText(Integer.toString(mIntAwayTeamScore));
            }
        });

        mAwayTeamPlusTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntAwayTeamScore = Integer.parseInt(mAwayTeamScore.getText().toString());
                mIntAwayTeamScore = mIntAwayTeamScore + 2;
                mAwayTeamScore.setText(Integer.toString(mIntAwayTeamScore));
            }
        });

        mAwayTeamPlusOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntAwayTeamScore = Integer.parseInt(mAwayTeamScore.getText().toString());
                mIntAwayTeamScore = mIntAwayTeamScore + 1;
                mAwayTeamScore.setText(Integer.toString(mIntAwayTeamScore));
            }
        });

        mAwayTeamMinusThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntAwayTeamScore = Integer.parseInt(mAwayTeamScore.getText().toString());
                mIntAwayTeamScore = mIntAwayTeamScore - 3;
                if (mIntAwayTeamScore < 0) {
                    mIntAwayTeamScore = 0;
                }
                mAwayTeamScore.setText(Integer.toString(mIntAwayTeamScore));
            }
        });

        mAwayTeamMinusTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntAwayTeamScore = Integer.parseInt(mAwayTeamScore.getText().toString());
                mIntAwayTeamScore = mIntAwayTeamScore - 2;
                if (mIntAwayTeamScore < 0) {
                    mIntAwayTeamScore = 0;
                }
                mAwayTeamScore.setText(Integer.toString(mIntAwayTeamScore));
            }
        });

        mAwayTeamMinusOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntAwayTeamScore = Integer.parseInt(mAwayTeamScore.getText().toString());
                mIntAwayTeamScore = mIntAwayTeamScore - 1;
                if (mIntAwayTeamScore < 0) {
                    mIntAwayTeamScore = 0;
                }
                mAwayTeamScore.setText(Integer.toString(mIntAwayTeamScore));
            }
        });

        mHomeTeamPlusThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntHomeTeamScore = Integer.parseInt(mHomeTeamScore.getText().toString());
                mIntHomeTeamScore = mIntHomeTeamScore + 3;
                mHomeTeamScore.setText(Integer.toString(mIntHomeTeamScore));
            }
        });

        mHomeTeamPlusTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntHomeTeamScore = Integer.parseInt(mHomeTeamScore.getText().toString());
                mIntHomeTeamScore = mIntHomeTeamScore + 2;
                mHomeTeamScore.setText(Integer.toString(mIntHomeTeamScore));
            }
        });

        mHomeTeamPlusOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntHomeTeamScore = Integer.parseInt(mHomeTeamScore.getText().toString());
                mIntHomeTeamScore = mIntHomeTeamScore + 1;
                mHomeTeamScore.setText(Integer.toString(mIntHomeTeamScore));
            }
        });

        mHomeTeamMinusThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntHomeTeamScore = Integer.parseInt(mHomeTeamScore.getText().toString());
                mIntHomeTeamScore = mIntHomeTeamScore - 3;
                if (mIntHomeTeamScore < 0) {
                    mIntHomeTeamScore = 0;
                }
                mHomeTeamScore.setText(Integer.toString(mIntHomeTeamScore));
            }
        });

        mHomeTeamMinusTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntHomeTeamScore = Integer.parseInt(mHomeTeamScore.getText().toString());
                mIntHomeTeamScore = mIntHomeTeamScore - 2;
                if (mIntHomeTeamScore < 0) {
                    mIntHomeTeamScore = 0;
                }
                mHomeTeamScore.setText(Integer.toString(mIntHomeTeamScore));
            }
        });

        mHomeTeamMinusOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mIntHomeTeamScore = Integer.parseInt(mHomeTeamScore.getText().toString());
                mIntHomeTeamScore = mIntHomeTeamScore - 1;
                if (mIntHomeTeamScore < 0) {
                    mIntHomeTeamScore = 0;
                }
                mHomeTeamScore.setText(Integer.toString(mIntHomeTeamScore));
            }
        });

        mStrAway = mAwayTeam.getText().toString();

        mAwayTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAwayTeam.setVisibility(View.GONE);
                mAwayEdit.setVisibility(View.VISIBLE);
                mAwayEdit.setText(mStrAway);
                mSaveAway.setVisibility(View.VISIBLE);
            }
        });

        mSaveAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAwayTeam.setVisibility(View.VISIBLE);
                mAwayEdit.setVisibility(View.GONE);
                mStrAway = mAwayEdit.getText().toString();
                mAwayTeam.setText(mStrAway);
                mSaveAway.setVisibility(View.GONE);
            }
        });

        mStrHome = mHomeTeam.getText().toString();

        mHomeTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHomeTeam.setVisibility(View.GONE);
                mHomeEdit.setVisibility(View.VISIBLE);
                mHomeEdit.setText(mStrHome);
                mSaveHome.setVisibility(View.VISIBLE);
            }
        });

        mSaveHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHomeTeam.setVisibility(View.VISIBLE);
                mHomeEdit.setVisibility(View.GONE);
                mStrHome = mHomeEdit.getText().toString();
                mHomeTeam.setText(mStrHome);
                mSaveHome.setVisibility(View.GONE);
            }
        });
    }

    /**
     * This method add new scores to the database
     * @param item
     */
    public void newScores (MenuItem item) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        int finalAwayScore = Integer.parseInt(mAwayTeamScore.getText().toString());
        String finalAwayTeam = mAwayTeam.getText().toString();
        int finalHomeScore = Integer.parseInt(mHomeTeamScore.getText().toString());
        String finalHomeTeam = mHomeTeam.getText().toString();

        Scores scores = new Scores(finalAwayScore, finalAwayTeam, finalHomeScore, finalHomeTeam);

        dbHandler.addScores(scores);

        mHomeTeam.setText(getResources().getText(R.string.homeTeam));
        mAwayTeam.setText(getResources().getText(R.string.awayTeam));
        mAwayEdit.setVisibility(View.GONE);
        mHomeEdit.setVisibility(View.GONE);
        mSaveAway.setVisibility(View.GONE);
        mSaveHome.setVisibility(View.GONE);
        mHomeEdit.setText(getResources().getText(R.string.homeTeam));
        mAwayEdit.setText(getResources().getText(R.string.awayTeam));
        mHomeTeamScore.setText("0");
        mAwayTeamScore.setText("0");
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("AwayTeam", mAwayTeam.getText().toString());
        editor.putString("AwayTeamScore", mAwayTeamScore.getText().toString());
        editor.putString("HomeTeam", mHomeTeam.getText().toString());
        editor.putString("HomeTeamScore", mHomeTeamScore.getText().toString());
        editor.apply();
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String awayTeam = preferences.getString("AwayTeam", "");
        String awayTeamScore = preferences.getString("AwayTeamScore", "");
        String homeTeam = preferences.getString("HomeTeam", "");
        String homeTeamScore = preferences.getString("HomeTeamScore", "");

        if(!awayTeam.equals("") && !awayTeamScore.equals("") && !homeTeam.equals("") && !homeTeamScore.equals("")) {
            mAwayTeam.setText(awayTeam);
            mAwayTeamScore.setText(awayTeamScore);
            mHomeTeam.setText(homeTeam);
            mHomeTeamScore.setText(homeTeamScore);
        }
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     * <p/>
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     * <p/>
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     * <p/>
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     * <p/>
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p/>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_previous_games:
                Intent intent = new Intent(MainActivity.this, CheckScores.class);
                startActivityForResult(intent, 0);
                return true;
            case R.id.action_help:
                Intent intent2 = new Intent(MainActivity.this, Help.class);
                startActivity(intent2);
                return true;
            case R.id.action_erase_game:
                mHomeTeam.setText("Home Team");
                mAwayTeam.setText("Away Team");
                mHomeTeamScore.setText("0");
                mAwayTeamScore.setText("0");
                Toast.makeText(getApplicationContext(), "Your game got erased!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_save_game:
                newScores(item);
                Toast.makeText(getApplicationContext(), "Your game got saved.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
