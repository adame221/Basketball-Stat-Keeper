package com.example.aely.basketballstattracker;

/**
 * Created by Owner on 4/6/2016.
 */
public class Scores {

    private int _id;
    private int _homescore;
    private String _hometeam;
    private int _awayscore;
    private String _awayteam;

    public Scores() {

    }

    public Scores(int _awayscore, int _id, String _hometeam, int _homescore, String _awayteam) {
        this._awayscore = _awayscore;
        this._id = _id;
        this._hometeam = _hometeam;
        this._homescore = _homescore;
        this._awayteam = _awayteam;
    }

    public Scores(int _awayscore, String _hometeam, int _homescore, String _awayteam) {
        this._awayscore = _awayscore;
        this._id = _id;
        this._hometeam = _hometeam;
        this._homescore = _homescore;
        this._awayteam = _awayteam;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_homescore() {
        return _homescore;
    }

    public void set_homescore(int _homescore) {
        this._homescore = _homescore;
    }

    public String get_hometeam() {
        return _hometeam;
    }

    public void set_hometeam(String _hometeam) {
        this._hometeam = _hometeam;
    }

    public String get_awayteam() {
        return _awayteam;
    }

    public void set_awayteam(String _awayteam) {
        this._awayteam = _awayteam;
    }

    public int get_awayscore() {
        return _awayscore;
    }

    public void set_awayscore(int _awayscore) {
        this._awayscore = _awayscore;
    }
}
