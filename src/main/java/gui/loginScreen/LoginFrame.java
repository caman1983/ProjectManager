package gui.loginScreen;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.User;
import entities.UserList;
import gui.landingPage.MainFrame;

public class LoginFrame extends JFrame
{
    public LoginFrame() {
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        UIManager.put("Label.font", labelFont);

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

        loginButton.setBackground(new Color(64, 0, 128));
        loginButton.setBackground(new Color(64, 0, 128));
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));

        loginButton.setForeground(Color.WHITE);
        loginButton.setForeground(Color.WHITE);


        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);

        loginButton.setOpaque(true);
        loginButton.setContentAreaFilled(true);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);


        // Layout
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(64, 0, 128));


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
                String inputPassword = new String(passwordField.getPassword());

                // Access the list of users
                UserList users = new UserList();

                // Find user by username
                User foundUser = users.getUserList().stream()
                        .filter(user -> user.getUserName().equals(username))
                        .findFirst()
                        .orElse(null);

                if (foundUser == null) {
                    // User does not exist
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Login failed. User does not exist.",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!foundUser.isAdmin()) {
                    // User is not an admin
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Login failed. User is not an admin.",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!foundUser.isPasswordCorrect(inputPassword)) {
                    // Incorrect password
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Login failed. Incorrect password.",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // Login success
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Login successful for admin user: " + username,
                            "Login Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Hide the login frame
                    LoginFrame.this.setVisible(false);
                    LoginFrame.this.dispose();
                    // Open the MainFrame
                    new MainFrame();
                }

                // Clear fields
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // styling for button on hover
        loginButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Set border when clicked
                loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                loginButton.setBorderPainted(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Set border when mouse is pressed
                loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                loginButton.setBorderPainted(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Remove border when mouse is released
                loginButton.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Set border when mouse hovers over button
                loginButton.setBorderPainted(true);
                loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remove border when mouse exits button
                loginButton.setBorder(null);
            }
        });





        // Set the frame to be visible
        setVisible(true);
    }




}

