package view;


import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test {
  public static void main(String[] argv) throws Exception {

    JTextField component = new JTextField();
    component.addMouseListener(new MyMouseListener());
    JFrame f = new JFrame();

    f.add(component);
    f.setSize(300, 300);
    f.setVisible(true);

  }
}

class MyMouseListener extends MouseAdapter {
  public void mouseClicked(MouseEvent evt) {
    if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
      System.out.println("left" + (evt.getPoint()));
    }
    if ((evt.getModifiers() & InputEvent.BUTTON2_MASK) != 0) {
      System.out.println("middle" + (evt.getPoint()));
    }
    if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
      System.out.println("right" + (evt.getPoint()));
    }
  }
}