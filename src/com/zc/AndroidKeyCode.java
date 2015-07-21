package com.zc;

import java.io.IOException;

/**
 * 7/21/15  3:02 PM
 * Created by JustinZhang.
 */
public class AndroidKeyCode  implements  KeyCodeInterface{
    @Override
    public boolean up() {
        return exec(19);
    }

    @Override
    public boolean left() {
        return exec(21);
    }

    @Override
    public boolean right() {
        return exec(22);
    }

    @Override
    public boolean down() {
        return exec(20);
    }

    @Override
    public boolean center() {
        return exec(23);
    }

    @Override
    public boolean back() {
        return exec(4);
    }

    @Override
    public boolean home() {
        return exec(3);
    }

    @Override
    public boolean power() {
        return exec(26);
    }

    @Override
    public boolean zero() {
        return exec(7);
    }

    @Override
    public boolean one() {
        return exec(8);
    }

    @Override
    public boolean two() {
        return exec(9);
    }

    @Override
    public boolean three() {
        return exec(10);
    }

    @Override
    public boolean four() {
        return exec(11);
    }

    @Override
    public boolean five() {
        return exec(12);
    }

    @Override
    public boolean six() {
        return exec(13);
    }

    @Override
    public boolean seven() {
        return exec(14);
    }

    @Override
    public boolean eight() {
        return exec(15);
    }

    @Override
    public boolean nine() {
        return exec(16);
    }

    @Override
    public boolean delete() {
        return exec(67);
    }

    @Override
    public boolean enter() {
        return exec(66);
    }

    @Override
    public boolean exec(int keycode) {
        try {
            Runtime.getRuntime().exec("adb shell input keyevent "+keycode);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
