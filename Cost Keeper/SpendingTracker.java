import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class SpendingTracker extends JFrame {

    private JPanel mainMenuPanel;
    private JPanel updateBalancePanel;
    private JPanel addExpensePanel;
    private JPanel viewExpensesPanel;

    private JButton updateBalanceButton;
    private JButton addExpenseButton;
    private JButton viewExpensesButton;
    private JButton backButton;

    private JLabel balanceLabel;
    private JTextField balanceField;
    private JButton submitBalanceButton;

    private JLabel expenseLabel;
    private JTextField expenseField;
    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel descriptionLabel;
    private JTextField descriptionField;
    private JButton submitExpenseButton;

    private JTextArea expensesArea;

    private double currentBalance;
    private ArrayList<Expense> expenses;

    public SpendingTracker() {
        setTitle("Spending Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        // Main Menu
        mainMenuPanel = new JPanel();
        updateBalanceButton = new JButton("Update Balance");
        addExpenseButton = new JButton("Add Expense");
        viewExpensesButton = new JButton("View Expenses");
        mainMenuPanel.add(updateBalanceButton);
        mainMenuPanel.add(addExpenseButton);
        mainMenuPanel.add(viewExpensesButton);
        add(mainMenuPanel, "mainMenu");

        // Update Balance
        updateBalancePanel = new JPanel();
        balanceLabel = new JLabel("Balance: ");
        balanceField = new JTextField(10);
        submitBalanceButton = new JButton("Submit");
        backButton = new JButton("Back");
        updateBalancePanel.add(balanceLabel);
        updateBalancePanel.add(balanceField);
        updateBalancePanel.add(submitBalanceButton);
        updateBalancePanel.add(backButton);
        add(updateBalancePanel, "updateBalance");

        // Add Expense
        addExpensePanel = new JPanel();
        expenseLabel = new JLabel("Expense: ");
        expenseField = new JTextField(10);
        dateLabel = new JLabel("Date: ");
        dateField = new JTextField(10);
        descriptionLabel = new JLabel("Description: ");
        descriptionField = new JTextField(10);
        submitExpenseButton = new JButton("Submit");
        backButton = new JButton("Back");
        addExpensePanel.add(expenseLabel);
        addExpensePanel.add(expenseField);
        addExpensePanel.add(dateLabel);
        addExpensePanel.add(dateField);
        addExpensePanel.add(descriptionLabel);
        addExpensePanel.add(descriptionField);
        addExpensePanel.add(submitExpenseButton);
        addExpensePanel.add(backButton);
        add(addExpensePanel, "addExpense");
    // View Expenses
    viewExpensesPanel = new JPanel();
    expensesArea = new JTextArea(10, 30);
    expensesArea.setEditable(false);
    backButton = new JButton("Back");
    viewExpensesPanel.add(expensesArea);
    viewExpensesPanel.add(backButton);
    add(viewExpensesPanel, "viewExpenses");

    // Action Listeners
    updateBalanceButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
            cardLayout.show(getContentPane(), "updateBalance");
        }
    });

    addExpenseButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
            cardLayout.show(getContentPane(), "addExpense");
        }
    });

    viewExpensesButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            expensesArea.setText("");
            for (Expense expense : expenses) {
                expensesArea.append(expense.toString() + "\n");
            }
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
            cardLayout.show(getContentPane(), "viewExpenses");
        }
    });

    backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
            cardLayout.show(getContentPane(), "mainMenu");
        }
    });

    submitBalanceButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            currentBalance = Double.parseDouble(balanceField.getText());
            balanceField.setText("");
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
            cardLayout.show(getContentPane(), "mainMenu");
        }
    });

    submitExpenseButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            double expense = Double.parseDouble(expenseField.getText());
            String date = dateField.getText();
            String description = descriptionField.getText();
            expenses.add(new Expense(expense, date, description));
            expenseField.setText("");
            dateField.setText("");
            descriptionField.setText("");
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
            cardLayout.show(getContentPane(), "mainMenu");
        }
    });

    currentBalance = 0.0;
    expenses = new ArrayList<Expense>();
}
/*
public static void main(String[] args) {
    SpendingTracker st = new SpendingTracker();
    st.setVisible(true);
}
*/
public class Expense {
    private double expense;
    private String date;
    private String description;

    public Expense(double expense, String date, String description) {
this.expense = expense;
this.date = date;
this.description = description;
}
    public double getExpense() {
        return expense;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "Expense: $" + expense + " Date: " + date + " Description: " + description;
    }
}
}
