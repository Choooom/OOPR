package toadinone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ELibrarySoft extends JFrame {

    private JPanel rightPanel;
    private JPanel calendarPanel;
    private JLabel monthLabel;
    private JPanel daysPanel;
    private JPanel sysManagementPanel = new JPanel();
    private JPanel transactionPanel = new JPanel();
    private JPanel shelvesPanel = new JPanel();
    private JPanel personalDetailsPanel;
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> yearComboBox;
    private Map<String, String> notes;
    private DefaultTableModel model;
    private JTable table;
    private JPanel contentPanel;
    
    //Eto par retrieve mo yung content ng table ng Admin_Details tas pasok mo sa variables
    //Kahet yung currentCreationDate and currentLastLoginDate tanggaleng nalang if di abot ng time
    private String currentFirstName = "Rosita";
    private String currentLastName = "Sharon";
    private String currentUserName = "rsharon";
    private String currentPassword = "password";
    private String currentEmail = "rosita.sharon@example.com";
    private String currentTitle = "Manager";
    private String currentCreationDate = "3/30/2015";
    private String currentLastLoginDate = "7/3/2016";

    public ELibrarySoft() {
        setTitle("eLibrary Soft");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        notes = new HashMap<>();

        // Create the top panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(107, 173, 35));
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(1000, 50));

        JLabel titleLabel = new JLabel("eLibrary Soft");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(107, 147, 35));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Dimension preferredSize = new Dimension(250, titleLabel.getPreferredSize().height);
        titleLabel.setPreferredSize(preferredSize);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        topPanel.add(titleLabel, BorderLayout.WEST);

        JButton logoutButton = new JButton("LOG OUT");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setBackground(new Color(107, 173, 35));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBorderPainted(false);
        logoutButton.setFocusPainted(false);
        topPanel.add(logoutButton, BorderLayout.EAST);

        // Create the left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(43, 57, 72));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(250, 700));

        JLabel navLabel = new JLabel("Main Navigation");
        navLabel.setOpaque(true);
        navLabel.setBackground(new Color(33, 46, 48));
        navLabel.setForeground(new Color(153, 153, 153));
        Dimension navLabelPreferredSize = new Dimension(550, navLabel.getPreferredSize().height);
        navLabel.setPreferredSize(navLabelPreferredSize);
        navLabel.setFont(new Font("SansSerif", 0, 22));
        navLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        navLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 73));
        leftPanel.add(navLabel);

        leftPanel.add(Box.createVerticalStrut(30));

        // Add individual buttons with icons
        leftPanel.add(createIconButton("Icon/DASHBOARD.png", "Dashboard", e -> dashboard()));
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(createIconButton("Icon/SM1.png", "System Management", e -> systemManagement()));
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(createIconButton("Icon/TRANSACTION.png", "Transaction", e -> transaction()));
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(createIconButton("Icon/CALENDAR_1.png", "Calendar", e -> calendar()));
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(createIconButton("Icon/SHELVE.png", "My Shelves", e -> shelves()));
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(createIconButton("Icon/PERSONAL-INFORMATION.png", "Personal Details", e -> personalDetails()));

        // Create the right panel
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new CardLayout());

        // Add panels to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(rightPanel, BorderLayout.CENTER);
        
    }
    
    private ImageIcon resizeImageIcon(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage();

        Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }
    
    private JPanel createIconButton(String iconPath, String text, ActionListener actionListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(new Color(43, 57, 72));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));  // Add padding to the left

        JLabel iconLabel = new JLabel(new ImageIcon(getClass().getResource(iconPath)));
        panel.add(iconLabel);

        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 17));
        button.setBackground(new Color(43, 57, 72));
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));  // Add some padding between icon and text
        button.addActionListener(actionListener);

        panel.add(button);
        return panel;
    }

    private void dashboard(){
        rightPanel.removeAll();
        // Add your dashboard component
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.add(new JLabel("Dashboard"));
        rightPanel.add(dashboardPanel, "Dashboard");
        ((CardLayout) rightPanel.getLayout()).show(rightPanel, "Dashboard");
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    private void systemManagement() {
        rightPanel.removeAll();
        sysManagementPanel.removeAll();
        
        sysManagementPanel.setLayout(null);
        
        JLabel sysManagementLabel = new JLabel("System Management");
        sysManagementLabel.setFont(new Font("Arial", Font.BOLD, 26));
        sysManagementLabel.setBounds(20,50,750,50);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(20,0,695,100);
        topPanel.setLayout(null);
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(107, 147, 35)));
        
        topPanel.add(sysManagementLabel);

        sysManagementPanel.add(topPanel);
        
        String[] options = {"Book List", "Requests", "Transactions"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        dropdown.setBounds(555,120,150,25);
        
        sysManagementPanel.add(dropdown);
        
        contentPanel = new JPanel(null);
        contentPanel.setBorder(new OutwardShadow(5));
        contentPanel.setBounds(50,160,635,400);
        
        sysManagementPanel.add(contentPanel);

        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) dropdown.getSelectedItem();
                switch (selected) {
                    case "Book List":
                        showBookList();
                        break;
                    case "Requests":
                        showRequests();
                        break;
                    case "Transactions":
                        showTransactions();
                        break;
                }
            }
        });

        rightPanel.add(sysManagementPanel);
        rightPanel.repaint();
        rightPanel.revalidate();
    }

    private void showBookList() {
        contentPanel.removeAll();

        JPanel bookListPanel = new JPanel(new BorderLayout());
        bookListPanel.setBounds(0, 0, 635, 400); // Set the bounds for bookListPanel

        String[] columnNames = {"Book", "Author", "Category", "Status"};
        Object[][] data = {
            {"Book 1", "Author 1", "Category 1", "Status 1"},
            {"Book 2", "Author 2", "Category 2", "Status 2"},
            {"Book 3", "Author 3", "Category 3", "Status 3"},
            {"Book 4", "Author 4", "Category 4", "Status 4"},
            {"Book 5", "Author 5", "Category 5", "Status 5"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        bookListPanel.add(scrollPane, BorderLayout.CENTER); // Add scrollPane to the CENTER of bookListPanel

        JPanel buttonPanel = new JPanel(); // buttonPanel should use default FlowLayout or similar
        JButton addButton = new JButton("ADD");
        addButton.setPreferredSize(new Dimension(80, 25)); // Set preferred size
        applyGreenButtonStyle(addButton);

        JButton editButton = new JButton("EDIT");
        editButton.setPreferredSize(new Dimension(80, 25)); // Set preferred size
        applyGreenButtonStyle(editButton);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setPreferredSize(new Dimension(80, 25)); // Set preferred size
        applyGreenButtonStyle(deleteButton);
        
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Add functionality for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField bookNameField = new JTextField();
                JTextField authorField = new JTextField();
                JTextField categoryField = new JTextField();
                JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Available", "Unavailable"});

                JPanel panel = new JPanel(new GridLayout(4, 2));
                panel.add(new JLabel("Book Name:"));
                panel.add(bookNameField);
                panel.add(new JLabel("Author:"));
                panel.add(authorField);
                panel.add(new JLabel("Category:"));
                panel.add(categoryField);
                panel.add(new JLabel("Status:"));
                panel.add(statusComboBox);

                int result = JOptionPane.showConfirmDialog(null, panel, "Add Book", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    model.addRow(new Object[]{bookNameField.getText(), authorField.getText(), categoryField.getText(), statusComboBox.getSelectedItem()});
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    JTextField bookNameField = new JTextField((String) table.getValueAt(selectedRow, 0));
                    JTextField authorField = new JTextField((String) table.getValueAt(selectedRow, 1));
                    JTextField categoryField = new JTextField((String) table.getValueAt(selectedRow, 2));
                    JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Available", "Unavailable"});
                    statusComboBox.setSelectedItem(table.getValueAt(selectedRow, 3));

                    JPanel panel = new JPanel(new GridLayout(4, 2));
                    panel.add(new JLabel("Book Name:"));
                    panel.add(bookNameField);
                    panel.add(new JLabel("Author:"));
                    panel.add(authorField);
                    panel.add(new JLabel("Category:"));
                    panel.add(categoryField);
                    panel.add(new JLabel("Status:"));
                    panel.add(statusComboBox);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Edit Book", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {
                        table.setValueAt(bookNameField.getText(), selectedRow, 0);
                        table.setValueAt(authorField.getText(), selectedRow, 1);
                        table.setValueAt(categoryField.getText(), selectedRow, 2);
                        table.setValueAt(statusComboBox.getSelectedItem(), selectedRow, 3);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        bookListPanel.add(buttonPanel, BorderLayout.SOUTH); // Add buttonPanel to the SOUTH of bookListPanel
        bookListPanel.setBorder(new OutwardShadow(5));
        
        contentPanel.add(bookListPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void showRequests() {
        contentPanel.removeAll();
        contentPanel.setLayout(null); // Ensure the layout is set to null if not already set

        JPanel requestsPanel = new JPanel(new BorderLayout());
        requestsPanel.setBounds(0, 0, 635, 400); // Set the bounds for requestsPanel

        String[] columnNames = {"Student Number", "Name", "Book Requested", "Return Date", "Status"};
        Object[][] data = {
            {"12345", "John Doe", "Book 1", "2024-06-15", "Pending"},
            {"23456", "Jane Smith", "Book 2", "2024-06-20", "Pending"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);
        requestsPanel.add(scrollPane, BorderLayout.CENTER);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(new Dimension(80, 25)); // Set preferred size
        applyGreenButtonStyle(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                for (int row : selectedRows) {
                    table.setValueAt("Approved", row, 4);
                }
                JOptionPane.showMessageDialog(requestsPanel, "Selected requests approved.");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);
        requestsPanel.add(buttonPanel, BorderLayout.SOUTH);
        requestsPanel.setBorder(new OutwardShadow(5));
        
        contentPanel.add(requestsPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void showTransactions() {
        contentPanel.removeAll();
        contentPanel.setLayout(null); // Ensure the layout is set to null if not already set

        JPanel transactionsPanel = new JPanel(new BorderLayout());
        transactionsPanel.setBounds(0, 0, 635, 400); // Set the bounds for transactionsPanel

        String[] columnNames = {"Student Number", "Name", "Type of Transaction", "Status"};
        Object[][] data = {
            {"12345", "John Doe", "Borrow", "Completed"},
            {"23456", "Jane Smith", "Return", "Pending"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);
        transactionsPanel.add(scrollPane, BorderLayout.CENTER);
        transactionsPanel.setBorder(new OutwardShadow(5));
        
        contentPanel.add(transactionsPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    private void transaction(){
        rightPanel.removeAll();
        transactionPanel.removeAll();
        
        transactionPanel.setLayout(null);
        
        JPanel todaysTransaction = new JPanel();
        todaysTransaction.setBorder(new OutwardShadow(5));
        todaysTransaction.setBackground(Color.WHITE);
        todaysTransaction.setBounds(30,50,325,500);
        todaysTransaction.setLayout(null);

        JLabel todaysTitle = new JLabel("Transactions");
        todaysTitle.setFont(new Font("Arial", Font.BOLD, 24));
        todaysTitle.setBounds(10, 15, 300, 50);

        JScrollPane todayScrollPane = new JScrollPane();
        todayScrollPane.setBounds(10,70,307,370);
        todayScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        todayScrollPane.setBorder(new LineBorder(new Color(43, 57, 72), 1));

        JPanel todayContentPanel = new JPanel();
        todayContentPanel.setLayout(new BoxLayout(todayContentPanel, BoxLayout.Y_AXIS));
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel("Transaction " + (i+1) + ": $" + (random.nextInt(1000) + 1));
            todayContentPanel.add(label);
        }
        todayScrollPane.setViewportView(todayContentPanel);

        todaysTransaction.add(todaysTitle);
        todaysTransaction.add(todayScrollPane);
        
        JPanel pendingTransaction = new JPanel();
        pendingTransaction.setBackground(Color.WHITE);
        pendingTransaction.setBorder(new OutwardShadow(5));
        pendingTransaction.setBounds(380,50,325,500);
        pendingTransaction.setLayout(null);

        JLabel pendingTitle = new JLabel("Pending Transactions");
        pendingTitle.setFont(new Font("Arial", Font.BOLD, 24));
        pendingTitle.setBounds(10, 15, 307, 50);

        JScrollPane pendingScrollPane = new JScrollPane();
        pendingScrollPane.setBounds(10,70,307,370);
        pendingScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pendingScrollPane.setBorder(new LineBorder(new Color(43, 57, 72), 1));

        JPanel pendingContentPanel = new JPanel();
        pendingContentPanel.setLayout(new BoxLayout(pendingContentPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < 20; i++) {
            JCheckBox checkBox = new JCheckBox("Pending Transaction " + (i+1) + ": $" + (random.nextInt(1000) + 1));
            pendingContentPanel.add(checkBox);
        }
        pendingScrollPane.setViewportView(pendingContentPanel);

        JButton confirmPaymentButton = new JButton("Confirm Payment");
        applyGreenButtonStyle(confirmPaymentButton);
        confirmPaymentButton.setOpaque(true);
        confirmPaymentButton.setFocusPainted(false);
        confirmPaymentButton.setBounds(10, 460, 150, 30);
        confirmPaymentButton.addActionListener(e -> {
            StringBuilder confirmedTransactions = new StringBuilder("Do you want to confirm these transactions?\n");
            boolean atLeastOneChecked = false;
            for (Component component : pendingContentPanel.getComponents()) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) component;
                    if (checkBox.isSelected()) {
                        confirmedTransactions.append(checkBox.getText()).append("\n");
                        atLeastOneChecked = true;
                    }
                }
            }

            if (atLeastOneChecked) {
                int result = JOptionPane.showConfirmDialog(null, confirmedTransactions.toString(), "Confirm Payment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    for (int i = pendingContentPanel.getComponentCount() - 1; i >= 0; i--) {
                        Component component = pendingContentPanel.getComponent(i);
                        if (component instanceof JCheckBox) {
                            JCheckBox checkBox = (JCheckBox) component;
                            if (checkBox.isSelected()) {
                                pendingContentPanel.remove(i);
                            }
                        }
                    }
                    pendingContentPanel.revalidate();
                    pendingContentPanel.repaint();
                } else {
                    for (Component component : pendingContentPanel.getComponents()) {
                        if (component instanceof JCheckBox) {
                            JCheckBox checkBox = (JCheckBox) component;
                            if (checkBox.isSelected()) {
                                checkBox.setSelected(false);
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select at least one transaction to confirm.", "No Selection", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        pendingTransaction.add(pendingTitle);
        pendingTransaction.add(pendingScrollPane);
        pendingTransaction.add(confirmPaymentButton);
        
        transactionPanel.add(todaysTransaction);
        transactionPanel.add(pendingTransaction);
        
        rightPanel.add(transactionPanel, "Transaction");
        ((CardLayout) rightPanel.getLayout()).show(rightPanel, "Transaction");
        
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    private void shelves() {
        rightPanel.removeAll();

        // Create the main panel to hold the shelves
        JPanel shelvesPanel = new JPanel();
        shelvesPanel.setLayout(null);

        // Create JLabel for "SHELVES"
        JLabel shelvesLabel = new JLabel("SHELVES");
        shelvesLabel.setFont(new Font("Arial", Font.BOLD, 32));
        shelvesLabel.setBounds(0, 0, 400, 50);
        shelvesPanel.add(shelvesLabel);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(null);
        labelPanel.setBounds(20, 20, 735, 50);

        labelPanel.add(shelvesLabel);
        shelvesPanel.add(labelPanel);

        // Create JComboBox for Aisle, Category, and Status
        JComboBox<String> aisleComboBox = new JComboBox<>(new String[]{"", "Aisle 1", "Aisle 2", "Aisle 3", "Aisle 4", "Aisle 5"});
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"", "Science", "Mathematics", "English", "Filipino", "Computer Studies"});
        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"", "Available", "Unavailable"});

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setBounds(0, 80, 735, 50);
        comboBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        comboBoxPanel.add(new JLabel("Aisle"));
        comboBoxPanel.add(aisleComboBox);
        comboBoxPanel.add(new JLabel("Category"));
        comboBoxPanel.add(categoryComboBox);
        comboBoxPanel.add(new JLabel("Status"));
        comboBoxPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        comboBoxPanel.add(statusComboBox);

        shelvesPanel.add(comboBoxPanel);

        // Create the table without checkboxes
        String[] columnNames = {"Book", "Author", "Category", "Status", "Aisle"};
        Object[][] data = {
            {"Book 1", "Author 1", "Science", "Available", "Aisle 1"},
            {"Book 2", "Author 2", "Mathematics", "Unavailable", "Aisle 2"},
            {"Book 3", "Author 3", "English", "Available", "Aisle 3"},
            {"Book 4", "Author 4", "Filipino", "Unavailable", "Aisle 4"},
            {"Book 5", "Author 5", "Computer Studies", "Available", "Aisle 5"}
        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel mainTable = new JPanel();
        mainTable.setBounds(20, 150, 695, 430);
        mainTable.setLayout(null);

        scrollPane.setBounds(15, 15, 665, 330);

        mainTable.add(scrollPane);

        // Add, Edit, and Delete buttons
        JButton addButton = new JButton("ADD");
        applyGreenButtonStyle(addButton);
        addButton.setBounds(280, 370, 100, 35);
        JButton editButton = new JButton("EDIT");
        applyGreenButtonStyle(editButton);
        editButton.setBounds(430, 370, 100, 35);
        JButton deleteButton = new JButton("DELETE");
        applyGreenButtonStyle(deleteButton);
        deleteButton.setBounds(580, 370, 100, 35);

        mainTable.setBorder(new OutwardShadow(5));
        mainTable.add(addButton);
        mainTable.add(editButton);
        mainTable.add(deleteButton);

        shelvesPanel.add(mainTable);

        rightPanel.add(shelvesPanel, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();

        // Action listeners for the combo boxes
        aisleComboBox.addActionListener(e -> filterTable(aisleComboBox, categoryComboBox, statusComboBox));
        categoryComboBox.addActionListener(e -> filterTable(aisleComboBox, categoryComboBox, statusComboBox));
        statusComboBox.addActionListener(e -> filterTable(aisleComboBox, categoryComboBox, statusComboBox));

        // Action listener for Add button
        addButton.addActionListener(e -> addBook());

        // Action listener for Edit button
        editButton.addActionListener(e -> editBooks());

        // Action listener for Delete button
        deleteButton.addActionListener(e -> deleteBooks());
    }

    private void filterTable(JComboBox<String> aisleComboBox, JComboBox<String> categoryComboBox, JComboBox<String> statusComboBox) {
        String aisle = (String) aisleComboBox.getSelectedItem();
        String category = (String) categoryComboBox.getSelectedItem();
        String status = (String) statusComboBox.getSelectedItem();

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        java.util.List<RowFilter<Object, Object>> filters = new java.util.ArrayList<>();
        if (aisle != null && !aisle.isEmpty()) {
            filters.add(RowFilter.regexFilter(aisle, 4));
        }
        if (category != null && !category.isEmpty()) {
            filters.add(RowFilter.regexFilter(category, 2));
        }
        if (status != null && !status.isEmpty()) {
            filters.add(RowFilter.regexFilter(status, 3));
        }

        RowFilter<Object, Object> filter = RowFilter.andFilter(filters);
        sorter.setRowFilter(filter);
    }

    private void addBook() {
        JTextField bookNameField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField aisleField = new JTextField();
        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Available", "Unavailable"});

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Book Name:"));
        panel.add(bookNameField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Status:"));
        panel.add(statusComboBox);
        panel.add(new JLabel("Aisle:"));
        panel.add(aisleField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Book", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Object[] newRow = {bookNameField.getText(), authorField.getText(), categoryField.getText(), statusComboBox.getSelectedItem(), aisleField.getText()};
            model.addRow(newRow);
        }
    }

    private void editBooks() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            JTextField bookNameField = new JTextField((String) model.getValueAt(selectedRow, 0));
            JTextField authorField = new JTextField((String) model.getValueAt(selectedRow, 1));
            JTextField categoryField = new JTextField((String) model.getValueAt(selectedRow, 2));
            JTextField aisleField = new JTextField((String) model.getValueAt(selectedRow, 4));
            JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Available", "Unavailable"});
            statusComboBox.setSelectedItem(model.getValueAt(selectedRow, 3));

            JPanel panel = new JPanel(new GridLayout(5, 2));
            panel.add(new JLabel("Book Name:"));
            panel.add(bookNameField);
            panel.add(new JLabel("Author:"));
            panel.add(authorField);
            panel.add(new JLabel("Category:"));
            panel.add(categoryField);
            panel.add(new JLabel("Status:"));
            panel.add(statusComboBox);
            panel.add(new JLabel("Aisle:"));
            panel.add(aisleField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Edit Book", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                model.setValueAt(bookNameField.getText(), selectedRow, 0);
                model.setValueAt(authorField.getText(), selectedRow, 1);
                model.setValueAt(categoryField.getText(), selectedRow, 2);
                model.setValueAt(statusComboBox.getSelectedItem(), selectedRow, 3);
                model.setValueAt(aisleField.getText(), selectedRow, 4);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteBooks() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void personalDetails(){
        rightPanel.removeAll();
        
        if (personalDetailsPanel == null) {
            personalDetailsPanel = new JPanel();
        }
        
        personalDetailsPanel.setLayout(null);
        
        JPanel verticalLinePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.DARK_GRAY);
                g.fillRect(getWidth() / 2 - 1, 0, 2, getHeight()); // Draw a vertical line at the center
            }
        };

        // Set the size and layout of the vertical line panel
        verticalLinePanel.setBounds(220, 115, 5, 420);
        
        personalDetailsPanel.add(verticalLinePanel);
        
        int panelWidth = 800;
        int panelHeight = 600;

        int labelWidth = 100;
        int fieldWidth = 200;
        int fieldHeight = 30;
        int verticalSpacing = 10;
        int labelFieldSpacing = 10;

        int centerX = panelWidth / 2 - 75;
        int centerXs = panelWidth / 2 + 150;
        int startY = 50;
        
        JLabel profileLabel = new JLabel("Personal Details");
        profileLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        profileLabel.setBounds(centerX - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth + fieldWidth + labelFieldSpacing, fieldHeight);
        personalDetailsPanel.add(profileLabel);
        
        ImageIcon profileIcon = new ImageIcon(getClass().getResource("Icon/PROFILE.png"));
        ImageIcon resizedProfileIcon = resizeImageIcon(profileIcon, 40, 40);
        JLabel profileIconLabel = new JLabel(resizedProfileIcon);
        profileIconLabel.setBounds((centerX - 178) - (labelWidth + fieldWidth + labelFieldSpacing), -70, 550, 550); // Adjust position and size as needed
        personalDetailsPanel.add(profileIconLabel);

        startY += fieldHeight + verticalSpacing + 20;

        startY += fieldHeight + verticalSpacing + 20;
        
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth, fieldHeight);
        personalDetailsPanel.add(firstNameLabel);

        JTextField firstNameField = new JTextField(currentFirstName);
        firstNameField.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing) + labelWidth + labelFieldSpacing, startY, fieldWidth, fieldHeight);
        personalDetailsPanel.add(firstNameField);

        startY += fieldHeight + verticalSpacing;

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth, fieldHeight);
        personalDetailsPanel.add(lastNameLabel);

        JTextField lastNameField = new JTextField(currentLastName);
        lastNameField.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing) + labelWidth + labelFieldSpacing, startY, fieldWidth, fieldHeight);
        personalDetailsPanel.add(lastNameField);

        startY += fieldHeight + verticalSpacing;

        JLabel userNameLabel = new JLabel("User Name:");
        userNameLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth, fieldHeight);
        personalDetailsPanel.add(userNameLabel);

        JTextField userNameField = new JTextField(currentUserName);
        userNameField.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing) + labelWidth + labelFieldSpacing, startY, fieldWidth, fieldHeight);
        personalDetailsPanel.add(userNameField);

        startY += fieldHeight + verticalSpacing;

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth, fieldHeight);
        personalDetailsPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(currentPassword);
        passwordField.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing) + labelWidth + labelFieldSpacing, startY, fieldWidth, fieldHeight);
        personalDetailsPanel.add(passwordField);

        startY += fieldHeight + verticalSpacing;

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth, fieldHeight);
        personalDetailsPanel.add(emailLabel);

        JTextField emailField = new JTextField(currentEmail);
        emailField.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing) + labelWidth + labelFieldSpacing, startY, fieldWidth, fieldHeight);
        personalDetailsPanel.add(emailField);

        startY += fieldHeight + verticalSpacing;

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth, fieldHeight);
        personalDetailsPanel.add(titleLabel);

        JTextField titleField = new JTextField(currentTitle);
        titleField.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing) + labelWidth + labelFieldSpacing, startY, fieldWidth, fieldHeight);
        personalDetailsPanel.add(titleField);

        startY += fieldHeight + verticalSpacing;

        startY += fieldHeight + verticalSpacing;

        JLabel creationDateTextLabel = new JLabel("Creation Date:");
        creationDateTextLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth, fieldHeight);
        personalDetailsPanel.add(creationDateTextLabel);

        JLabel creationDateLabel = new JLabel(currentCreationDate);
        creationDateLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing) + labelWidth + labelFieldSpacing, startY, fieldWidth, fieldHeight);
        personalDetailsPanel.add(creationDateLabel);

        startY += fieldHeight + verticalSpacing;

        JLabel lastLoginDateTextLabel = new JLabel("Last Login Date:");
        lastLoginDateTextLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing), startY, labelWidth, fieldHeight);
        personalDetailsPanel.add(lastLoginDateTextLabel);

        JLabel lastLoginDateLabel = new JLabel(currentLastLoginDate);
        lastLoginDateLabel.setBounds(centerXs - (labelWidth + fieldWidth + labelFieldSpacing) + labelWidth + labelFieldSpacing, startY, fieldWidth, fieldHeight);
        personalDetailsPanel.add(lastLoginDateLabel);

        startY += fieldHeight + verticalSpacing;

        JButton applyButton = new JButton("Apply");
        applyGreenButtonStyle(applyButton);
        applyButton.setOpaque(true);
        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update the database with new details
                currentFirstName = firstNameField.getText();
                currentLastName = lastNameField.getText();
                currentUserName = userNameField.getText();
                currentPassword = new String(passwordField.getPassword());
                currentEmail = emailField.getText();
                currentTitle = titleField.getText();
                // Update last login date sa database basta the firt time mag login yung admin, make a time object and store it sa database
                // update database dito;

                JOptionPane.showMessageDialog(null, "Profile updated successfully.");
            }
        });
        applyButton.setBounds((centerX + 155) - fieldWidth - labelFieldSpacing - 30, startY + 20, fieldWidth , fieldHeight + 10);
        personalDetailsPanel.add(applyButton);

        JButton cancelButton = new JButton("Cancel");
        applyGreenButtonStyle(cancelButton);
        cancelButton.setOpaque(true);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Revert the fields to the current database values
                firstNameField.setText(currentFirstName);
                lastNameField.setText(currentLastName);
                userNameField.setText(currentUserName);
                passwordField.setText(currentPassword);
                emailField.setText(currentEmail);
                titleField.setText(currentTitle);
            }
        });
        cancelButton.setBounds((centerX + 200) + labelFieldSpacing - 30, startY + 20, fieldWidth , fieldHeight + 10);
        personalDetailsPanel.add(cancelButton);
        rightPanel.add(personalDetailsPanel);
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    private void calendar() {
        rightPanel.removeAll();
        
        calendarPanel = new JPanel(new BorderLayout());
        rightPanel.add(calendarPanel, "Calendar");
        
        JPanel monthPanel = new JPanel();
        monthPanel.setLayout(new BorderLayout());

        monthComboBox = new JComboBox<>(new String[]{
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        });

        yearComboBox = new JComboBox<>();
        for (int i = 2010; i <= 2030; i++) {
            yearComboBox.addItem(i);
        }

        monthComboBox.addActionListener(e -> updateCalendar());
        yearComboBox.addActionListener(e -> updateCalendar());

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(monthComboBox);
        comboBoxPanel.add(yearComboBox);
        monthPanel.add(comboBoxPanel, BorderLayout.WEST);

        JPanel daysPanel = new JPanel();
        daysPanel.setLayout(new GridLayout(0, 7));

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            daysPanel.add(dayLabel);
        }

        calendarPanel.add(monthPanel, BorderLayout.NORTH);
        calendarPanel.add(daysPanel, BorderLayout.CENTER);

        calendarPanel.revalidate();
        calendarPanel.repaint();

        updateCalendar();
    }

    private void updateCalendar() {
        int year = (int) yearComboBox.getSelectedItem();
        int month = monthComboBox.getSelectedIndex();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        JPanel daysPanel = (JPanel) calendarPanel.getComponent(1);
        daysPanel.removeAll();

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            daysPanel.add(dayLabel);
        }

        for (int i = 1; i < firstDayOfWeek; i++) {
            daysPanel.add(new JLabel(""));
        }

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInMonth; i++) {
            JButton dayButton = new JButton(String.valueOf(i));
            dayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createNoteWindow(dayButton.getText(), month, year);
                }
            });
            daysPanel.add(dayButton);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private void createNoteWindow(String day, int month, int year) {
        String key = day + "-" + month + "-" + year;
        String note = notes.getOrDefault(key, "");

        JFrame noteFrame = new JFrame("Notes for Day " + day);
        noteFrame.setSize(300, 200);
        noteFrame.setLocationRelativeTo(this);

        JTextArea noteTextArea = new JTextArea(note);
        JButton confirmButton = new JButton("Confirm");

        confirmButton.addActionListener(e -> {
            notes.put(key, noteTextArea.getText());
            noteFrame.dispose();
        });

        noteFrame.setLayout(new BorderLayout());
        noteFrame.add(new JScrollPane(noteTextArea), BorderLayout.CENTER);
        noteFrame.add(confirmButton, BorderLayout.SOUTH);

        noteFrame.setVisible(true);
    }

    public static void applyGreenButtonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(34, 139, 34));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        
        Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        button.setBorder(roundedBorder);
        // Add mouse listener to handle background color changes
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(46, 184, 46));
                button.setBackground(new Color(34, 139, 34));
                Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 1, true);
                button.setBorder(roundedBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(34, 139, 34));
                Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 1, true);
                button.setBorder(roundedBorder);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(new Color(28, 115, 28));
                Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 2, true);
                button.setBorder(roundedBorder);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(new Color(46, 184, 46));
                button.setBackground(new Color(34, 139, 34));
                Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 1, true);
                button.setBorder(roundedBorder);
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ELibrarySoft().setVisible(true);
        });
    }
}
