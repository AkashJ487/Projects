/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author JAGTAP
 */
public class Validator {
    public static String generateHash(String password) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(password.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (byte a :hashedBytes) 
                        {
				byte b = a;
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
    
     public static void onlyString(KeyEvent evt, JTextField field) {
          char c = evt.getKeyChar();
        if (!((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z') || (c==evt.VK_SPACE) || (c==evt.VK_CAPS_LOCK) || (c==evt.VK_SHIFT)||
            (c == evt.VK_BACK_SPACE) ||
            (c == evt.VK_DELETE))) {

        JOptionPane.showMessageDialog(null, "Enter Alphabets only");
       field.setText("");
        }
     }
     public static void onlyInteger(KeyEvent evt, JTextField field) {
          char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')||
            (c == evt.VK_BACK_SPACE) ||
            (c == evt.VK_DELETE))) {

        JOptionPane.showMessageDialog(null, "Enter Integers only");
       field.setText("");
        }
     }
    
}
