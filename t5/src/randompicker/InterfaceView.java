/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompicker;

import javax.swing.JFileChooser;
import randompicker.RandomPickerGUI.SwingAppendableText;

/**
 *
 * @author danie
 */
public interface InterfaceView {
    SwingAppendableText getTextArea();
    SwingAppendableText getLabel();
    SwingAppendableText getJBNext();
}
