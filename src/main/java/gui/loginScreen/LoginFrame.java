package gui.loginScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame
{
    public LoginFrame() {
        // Frame settings
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame

        // Create UI components
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JButton loginButton = new JButton("Login");

        // Layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        // Action Listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                // Here you would normally handle authentication.
                // For now, we'll just print out the entered username and password.
                System.out.println("Username: " + username);
                System.out.println("Password: " + new String(password));

                // Clear fields
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // Set the frame to be visible
        setVisible(true);
    }
}

