package com.example.aely.basketballstattracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Owner on 2/28/2016.
 */
public class CheckScores extends AppCompatActivity {

    private ArrayList<Scores> mScores;
    private ListView mNewListView;
    ObjectArrayAdapter mAdapter;
    private TextView mNoGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_scores);

        if(mScores == null) {
            mScores = new ArrayList<>();
        }

        mNewListView = (ListView) findViewById(R.id.newList);
        mNewListView.setAdapter(mAdapter);
        mNoGames = (TextView) findViewById(R.id.noGames);


        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        mScores = dbHandler.getAllScores();

        mAdapter = new ObjectArrayAdapter(CheckScores.this, R.layout.detail_line, mScores);
        mNewListView.setAdapter(mAdapter);

        mNewListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                final Scores scores = (Scores) mNewListView.getAdapter().getItem(position);
                mScores.remove(position);
                mAdapter.notifyDataSetChanged();
                removeGame(view, scores.get_id());
                Toast.makeText(getApplicationContext(), "Game erased.", Toast.LENGTH_LONG).show();

                if (mNewListView.getCount() < 1) {
                    mNoGames.setVisibility(View.VISIBLE);
                } else {
                    mNoGames.setVisibility(View.GONE);
                }
            }
        });

        if (mNewListView.getCount() < 1) {
            mNoGames.setVisibility(View.VISIBLE);
        } else {
            mNoGames.setVisibility(View.GONE);
        }
    }

    /**
     * This method calls the delete game method from the handler class
     * and remove the game.
     * @param view
     * @param position
     */
    public void removeGame (View view, int position) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);

        dbHandler.deleteGame(position);
    }

    public class ObjectArrayAdapter extends ArrayAdapter<Scores> {

        private ArrayList<Scores> scores;


        public ObjectArrayAdapter(Context context, int resource, ArrayList<Scores> scores) {
            super(context, resource, scores);
            this.scores = scores;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.detail_line, null);
            }

            Scores scoresObject = scores.get(position);

            if (scoresObject != null) {
                TextView mAwayTeam = (TextView) view.findViewById(R.id.finalAwayTeam);
                TextView mAwayScore = (TextView) view.findViewById(R.id.finalAwayScore);
                TextView mHomeTeam = (TextView) view.findViewById(R.id.finalHomeTeam);
                TextView mHomeScore = (TextView) view.findViewById(R.id.finalHomeScore);

                if (mAwayTeam != null) {
                    mAwayTeam.setText(scoresObject.get_awayteam());
                }
                if (mAwayScore != null) {
                    mAwayScore.setText(Integer.toString(scoresObject.get_awayscore()));
                }
                if (mHomeTeam != null) {
                    mHomeTeam.setText(scoresObject.get_hometeam());
                }

                if (mHomeScore != null) {
                    mHomeScore.setText(Integer.toString(scoresObject.get_homescore()));
                }
            }

            return view;
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
        menu.findItem(R.id.action_erase_game).setVisible(false);
        menu.findItem(R.id.action_save_game).setVisible(false);
        menu.findItem(R.id.action_previous_games).setVisible(false);
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

            case android.R.id.home:
                finish();
                return true;
            case R.id.action_help:
                Intent intent = new Intent(CheckScores.this, Help.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
