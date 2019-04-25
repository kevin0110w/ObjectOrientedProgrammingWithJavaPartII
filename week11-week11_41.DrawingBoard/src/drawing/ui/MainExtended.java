package drawing.ui;

import javax.swing.SwingUtilities;

public class MainExtended {

    public static void main(String[] args) {
        UserInterfaceExtended ui = new UserInterfaceExtended(new Avatar(30, 30));
        SwingUtilities.invokeLater(ui);
    }
}
