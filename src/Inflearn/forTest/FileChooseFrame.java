package Inflearn.forTest;

import javax.swing.*;
import java.awt.*;

public class FileChooseFrame extends JFrame {

    public FileChooseFrame() {
        this.setVisible(true);
//        this.setSize(1,1);

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) {
            this.dispose();
        }


    }

}
