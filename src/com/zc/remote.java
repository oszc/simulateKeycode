package com.zc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class Remote extends Frame {

    private static final long serialVersionUID = 22;
    GridLayout gl0, gl1, gl2;
    Panel p0, p1, p2,p3;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b_cancel, b_ok, b_turn_ok, b_home, b_dpad_up, b_dpad_down, b_dpad_left, b_dpad_right, b_back;
    StringBuffer str;

    JComboBox comboBox;
    KeyCodeInterface keyCode = new AndroidKeyCode();

    public Remote() {
        gl0 = new GridLayout(4, 5, 10, 15);
        gl1 = new GridLayout(3, 1, 0, 15);
        gl2 = new GridLayout(4, 1, 0, 15);

        b0 = new Button("0");
        b0.setForeground(Color.blue);
        b0.addActionListener(new Bt());
        b1 = new Button("1");
        b1.setForeground(Color.blue);
        b1.addActionListener(new Bt());
        b2 = new Button("2");
        b2.setForeground(Color.blue);
        b2.addActionListener(new Bt());
        b3 = new Button("3");
        b3.setForeground(Color.blue);
        b3.addActionListener(new Bt());
        b4 = new Button("4");
        b4.setForeground(Color.blue);
        b4.addActionListener(new Bt());
        b5 = new Button("5");
        b5.setForeground(Color.blue);
        b5.addActionListener(new Bt());
        b6 = new Button("6");
        b6.setForeground(Color.blue);
        b6.addActionListener(new Bt());
        b7 = new Button("7");
        b7.setForeground(Color.blue);
        b7.addActionListener(new Bt());
        b8 = new Button("8");
        b8.setForeground(Color.blue);
        b8.addActionListener(new Bt());
        b9 = new Button("9");
        b9.setForeground(Color.blue);
        b9.addActionListener(new Bt());
        b_cancel = new Button("C");
        b_cancel.setForeground(Color.blue);
        b_cancel.addActionListener(new Bt());
        b_turn_ok = new Button("确定");
        b_turn_ok.setForeground(Color.blue);
        b_turn_ok.addActionListener(new Bt());
        b_home = new Button("Home");
        b_home.setForeground(Color.blue);
        b_home.addActionListener(new Bt());
        b_dpad_left = new Button("左");
        b_dpad_left.setForeground(Color.blue);
        b_dpad_left.addActionListener(new Bt());
        b_dpad_right = new Button("右");
        b_dpad_right.setForeground(Color.blue);
        b_dpad_right.addActionListener(new Bt());
        b_dpad_up = new Button("上");
        b_dpad_up.setForeground(Color.blue);
        b_dpad_up.addActionListener(new Bt());
        b_dpad_down = new Button("下");
        b_dpad_down.setForeground(Color.blue);
        b_dpad_down.addActionListener(new Bt());
        b_ok = new Button("OK");
        b_ok.setForeground(Color.blue);
        b_ok.addActionListener(new Bt());
        b_cancel = new Button("C");
        b_cancel.setForeground(Color.blue);
        b_cancel.addActionListener(new Bt());
        b_back = new Button("返回");
        b_back.setForeground(Color.blue);
        b_back.addActionListener(new Bt());

        comboBox = new JComboBox();
        comboBox.addItem("aa");
        comboBox.addItem("bb");

        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();

        str = new StringBuffer();

        p0.setLayout(gl0);
        p0.add(b7);
        p0.add(b8);
        p0.add(b9);
        p0.add(b4);
        p0.add(b5);
        p0.add(b6);
        p0.add(b1);
        p0.add(b2);
        p0.add(b3);
        p0.add(b_cancel);
        p0.add(b0);
        p0.add(b_ok);
        p0.setBounds(10, 45, 150, 150);

        p1.setLayout(gl1);
        p1.add(b_turn_ok);
        p1.add(b_home);
        p1.add(b_back);
        p1.setBounds(170, 45, 60, 150);

        p2.setLayout(gl2);
        p2.add(b_dpad_up);
        p2.add(b_dpad_down);
        p2.add(b_dpad_left);
        p2.add(b_dpad_right);
        p2.setBounds(250, 45, 60, 150);

        p3.add(comboBox);
        p3.setBounds(320,45,150,60);

        setLayout(null);
        add(p0);
        add(p1);
        add(p2);
        add(p3);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e1) {
                System.exit(0);
            }
        });
        setBackground(Color.lightGray);
        setBounds(100, 350, 520, 250);
        setVisible(true);

    }

    class Bt implements ActionListener {

        public void actionPerformed(ActionEvent e2) {

            String retVal = null;
            if (e2.getSource() == b0) {
                retVal = keyCode.zero();
            } else if (e2.getSource() == b1) {
                retVal = keyCode.one();
            } else if (e2.getSource() == b2) {
                retVal = keyCode.two();
            } else if (e2.getSource() == b3) {
                retVal = keyCode.three();
            } else if (e2.getSource() == b4) {
                retVal = keyCode.four();
            } else if (e2.getSource() == b5) {
                retVal = keyCode.five();
            } else if (e2.getSource() == b6) {
                retVal = keyCode.six();
            } else if (e2.getSource() == b7) {
                retVal = keyCode.seven();
            } else if (e2.getSource() == b8) {
                retVal = keyCode.eight();
            } else if (e2.getSource() == b9) {
                retVal = keyCode.nine();
            } else if (e2.getSource() == b_dpad_up) {
                retVal = keyCode.up();
            } else if (e2.getSource() == b_dpad_down) {
                retVal = keyCode.down();
            } else if (e2.getSource() == b_dpad_left) {
                retVal = keyCode.left();
            } else if (e2.getSource() == b_dpad_right) {
                retVal = keyCode.right();
            } else if (e2.getSource() == b_turn_ok) {
                retVal = keyCode.center();
            } else if (e2.getSource() == b_home) {
                retVal = keyCode.home();
            } else if (e2.getSource() == b_back) {
                retVal = keyCode.back();
            } else if (e2.getSource() == b_cancel) {

                retVal = keyCode.delete();
            } else if (e2.getSource() == b_ok) {
                retVal = keyCode.enter();
            }

            if (retVal != null && retVal.length() > 0) {
                JOptionPane.showMessageDialog(null, retVal);
            }

        }
    }


}