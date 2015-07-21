package com.zc;

/**
 * 7/21/15  2:59 PM
 * Created by JustinZhang.
 */
public interface KeyCodeInterface {
    boolean up();
    boolean left();
    boolean right();
    boolean down();
    boolean center();
    boolean back();
    boolean home();
    boolean power();
    boolean zero();
    boolean one();
    boolean two();
    boolean three();
    boolean four();
    boolean five();
    boolean six();
    boolean seven();
    boolean eight();
    boolean nine();
    boolean delete();
    boolean enter();

    boolean exec(int keycode);
}
