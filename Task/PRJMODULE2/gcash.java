package Task.PRJMODULE2;

public class gcash {

    public class GcashGuiApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Active session tracking state
    private String loggedInUserId = null;

    public GcashGuiApp() {
        setTitle("GCash Online Banking Portal");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add modular application panels
        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createRegisterPanel(), "Register");
        mainPanel.add(createDashboardPanel(), "Dashboard");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");
    }

    // --- 1. LOGIN SCREEN INTERFACE PANEL ---
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel titleLabel = new JLabel("GCash Authentication", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 90, 224));

        JTextField phoneField = new JTextField();
        phoneField.setBorder(BorderFactory.createTitledBorder("Mobile Number (09XXXXXXXXX)"));

        JPasswordField pinField = new JPasswordField();
        pinField.setBorder(BorderFactory.createTitledBorder("Secure MPIN"));

        JButton loginBtn = new JButton("Login Securely");
        loginBtn.setBackground(new Color(0, 90, 224));
        loginBtn.setForeground(Color.WHITE);

        JButton registerSwitchBtn = new JButton("Create New Account");

        panel.add(titleLabel);
        panel.add(phoneField);
        panel.add(pinField);
        panel.add(loginBtn);
        panel.add(new JLabel("or", SwingConstants.CENTER));
        panel.add(registerSwitchBtn);

        // Events
        loginBtn.addActionListener(e -> {
            try {
                String id = AuthService.login(phoneField.getText(), new String(pinField.getPassword()));
                loggedInUserId = id;
                phoneField.setText("");
                pinField.setText("");
                cardLayout.show(mainPanel, "Dashboard");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Security Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerSwitchBtn.addActionListener(e -> cardLayout.show(mainPanel, "Register"));
        return panel;
    }

    // --- 2. CUSTOM REGISTRATION PANEL ---
    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridLayout(8, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel titleLabel = new JLabel("Registration Portal", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField idField = new JTextField(); idField.setBorder(BorderFactory.createTitledBorder("User ID"));
        JTextField nameField = new JTextField(); nameField.setBorder(BorderFactory.createTitledBorder("Full Name"));
        JTextField emailField = new JTextField(); emailField.setBorder(BorderFactory.createTitledBorder("Email Address"));
        JTextField phoneField = new JTextField(); phoneField.setBorder(BorderFactory.createTitledBorder("Mobile Number"));
        JTextField pinField = new JTextField(); pinField.setBorder(BorderFactory.createTitledBorder("PIN (4-6 Digits)"));
        JTextField balField = new JTextField(); balField.setBorder(BorderFactory.createTitledBorder("Initial Deposit (PHP)"));

        JPanel btnPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton submitBtn = new JButton("Register");
        submitBtn.setBackground(Color.DARK_GRAY); submitBtn.setForeground(Color.WHITE);
        JButton backBtn = new JButton("Cancel");

        btnPanel.add(submitBtn);
        btnPanel.add(backBtn);

        panel.add(titleLabel);
        panel.add(idField);
        panel.add(nameField);
        panel.add(emailField);
        panel.add(phoneField);
        panel.add(pinField);
        panel.add(balField);
        panel.add(btnPanel);

        // Actions
        submitBtn.addActionListener(e -> {
            try {
                double bal = Double.parseDouble(balField.getText());
                AuthService.registerUser(idField.getText(), nameField.getText(), emailField.getText(), phoneField.getText(), pinField.getText(), bal);
                JOptionPane.showMessageDialog(this, "Profile Saved into Database!", "Success", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(mainPanel, "Login");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Alert", JOptionPane.WARNING_MESSAGE);
            }
        });

        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        return panel;
    }

    // --- 3. CORE BANKING DASHBOARD PANEL ---
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel titleLabel = new JLabel("Online Session Active", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.ITALIC, 16));

        JButton checkBalBtn = new JButton("Check Account Balances");

        JTextField recipientField = new JTextField();
        recipientField.setBorder(BorderFactory.createTitledBorder("Recipient Phone Number"));

        JTextField amountField = new JTextField();
        amountField.setBorder(BorderFactory.createTitledBorder("Transfer Amount (PHP)"));

        JButton transferBtn = new JButton("Execute Send Money");
        transferBtn.setBackground(Color.GREEN.darker());
        transferBtn.setForeground(Color.WHITE);

        JButton logoutBtn = new JButton("Secure Logout");
        logoutBtn.setBackground(Color.RED.darker());
        logoutBtn.setForeground(Color.WHITE);

        panel.add(titleLabel);
        panel.add(checkBalBtn);
        panel.add(recipientField);
        panel.add(amountField);
        panel.add(transferBtn);
        panel.add(logoutBtn);

        // Event Logic Hookups
        checkBalBtn.addActionListener(e -> {
            String details = BankingService.getGuiBalanceString(loggedInUserId);
            JOptionPane.showMessageDialog(this, details, "Account Ledger Statement", JOptionPane.INFORMATION_MESSAGE);
        });

        transferBtn.addActionListener(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                BankingService.transferFunds(loggedInUserId, recipientField.getText(), amt);
                JOptionPane.showMessageDialog(this, "Transfer verified & committed seamlessly!", "Success", JOptionPane.INFORMATION_MESSAGE);
                amountField.setText("");
                recipientField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Transfer Exception Blocked", JOptionPane.ERROR_MESSAGE);
            }
        });

        logoutBtn.addActionListener(e -> {
            loggedInUserId = null;
            JOptionPane.showMessageDialog(this, "Session state terminated successfully.");
            cardLayout.show(mainPanel, "Login");
        });

        return panel;
    }

    public static void main(String[] args) {
        // Run desktop frame window on safe UI design thread schedules
        SwingUtilities.invokeLater(() -> {
            new GcashGuiApp().setVisible(true);
        });
    }
}
    
}
