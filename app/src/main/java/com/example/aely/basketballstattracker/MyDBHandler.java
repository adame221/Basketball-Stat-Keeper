package com.example.aely.basketballstattracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Owner on 4/6/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "scoresDB.db";
    private static final String TABLE_SCORES = "scores";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_HOMESCORE = "homescore";
    public static final String COLUMN_HOMETEAM = "hometeam";
    public static final String COLUMN_AWAYSCORE = "awayscore";
    public static final String COLUMN_AWAYTEAM = "awayteam";

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SCORES_TABLE = "CREATE TABLE " +
                TABLE_SCORES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_HOMESCORE
                + " INTEGER," + COLUMN_HOMETEAM + " TEXT," + COLUMN_AWAYSCORE
                + " INTEGER," + COLUMN_AWAYTEAM + " TEXT" + ")";
        db.execSQL(CREATE_SCORES_TABLE);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        onCreate(db);
    }

    /**
     *  insert database records
     *
     * @param scores  an instance of our Product data model class
     */
    public void addScores(Scores scores) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_HOMESCORE, scores.get_homescore());
        values.put(COLUMN_HOMETEAM, scores.get_hometeam());
        values.put(COLUMN_AWAYSCORE, scores.get_awayscore());
        values.put(COLUMN_AWAYTEAM, scores.get_awayteam());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_SCORES, null, values);
        db.close();
    }


    /**
     * This method gets all the scores from the database.
     * @return mScores
     */
    public ArrayList<Scores> getAllScores() {
        String selectQuery = "Select * FROM " + TABLE_SCORES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Scores> mScores = new ArrayList<>();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Scores team = new Scores();
                    team.set_id(Integer.parseInt(cursor.getString(0)));
                    team.set_homescore(Integer.parseInt(cursor.getString(1)));
                    team.set_hometeam(cursor.getString(2));
                    team.set_awayscore(Integer.parseInt(cursor.getString(3)));
                    team.set_awayteam(cursor.getString(4));
                    mScores.add(team);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        db.close();
        return mScores;
    }

    /**
     *
     *
     * @param gameId  the entry to be deleted in the form of a Scores object
     * @return result
     */
    public boolean deleteGame(int gameId) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_SCORES + " WHERE " + COLUMN_ID + " =  \"" + gameId + "\"";

        // search for the entry based on the product name
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Scores scores = new Scores();

        // if located, delete it from the table
        if (cursor.moveToFirst()) {
            scores.set_id(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_SCORES, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(scores.get_id()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
