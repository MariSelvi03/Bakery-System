package BakeryDesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BakeryGUI extends JFrame {
    private JTextArea textArea;
    private Bakery bakery;
    private Order order;
    private DefaultListModel<String> orderHistoryModel;

    public BakeryGUI() {
        bakery = new Bakery();
        order = new Order(100);

        // Setup the JFrame
        setTitle("Bakery System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Setup the text area for notifications
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Order History Panel
        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(new BorderLayout());
        historyPanel.setBorder(BorderFactory.createTitledBorder("Order History"));
        add(historyPanel, BorderLayout.EAST);

        // Order History List
        orderHistoryModel = new DefaultListModel<>();
        JList<String> orderHistoryList = new JList<>(orderHistoryModel);
        historyPanel.add(new JScrollPane(orderHistoryList), BorderLayout.CENTER);

        // Setup input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.SOUTH);

        // Price List
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new GridLayout(2, 1));
        pricePanel.setBorder(BorderFactory.createTitledBorder("Price List"));
        inputPanel.add(pricePanel);

        // Add price list items
        JLabel cakePriceLabel = new JLabel("Cake - $10");
        JLabel cookiePriceLabel = new JLabel("Cookie - $5");
        pricePanel.add(cakePriceLabel);
        pricePanel.add(cookiePriceLabel);

        // Order options
        JLabel itemLabel = new JLabel("Select an item to order:");
        inputPanel.add(itemLabel);

        JComboBox<String> itemSelector = new JComboBox<>(new String[]{"Select Item", "Cake", "Cookie"});
        inputPanel.add(itemSelector);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        inputPanel.add(buttonPanel);

        // Place Order Button
        JButton placeOrderButton = new JButton("Place Order");
        buttonPanel.add(placeOrderButton);

        // Clear Button
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);

        // Button actions
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) itemSelector.getSelectedItem();
                if (selectedItem != null && !selectedItem.equals("Select Item")) {
                    placeOrder(selectedItem);
                } else {
                    textArea.append("Please select an item to order.\n");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemSelector.setSelectedIndex(0);
                textArea.setText("");
            }
        });
    }

    private void placeOrder(String item) {
        textArea.append("Order placed for: " + item + "\n");

        // Use Factory Method Pattern to create a bakery product
        BakeryProductFactory factory;
        if (item.equals("Cake")) {
            factory = new CakeFactory();
        } else {
            factory = new CookieFactory();
        }
        BakeryProduct product = factory.createProduct();
        product.prepare(); // Preparing the product
        textArea.append("Preparing " + product.getClass().getSimpleName() + "\n");

        // Notify using Observer Pattern
        bakery.addObserver(new Customer("Alice"));
        bakery.addObserver(new Customer("Bob"));
        bakery.setCake("Your " + item + " is ready!"); // Simulate notification
        textArea.append("Notified customers about the new " + item + "\n");

        // Apply Strategy Pattern (No Discount for simplicity)
        order.setDiscountStrategy(new NoDiscount());
        textArea.append("Final price for " + item + ": " + order.calculateFinalPrice() + "\n");

        // Use Singleton Pattern to manage the bakery
        BakeryManager manager = BakeryManager.getInstance();
        manager.manageBakery();

        // Update Order History
        orderHistoryModel.addElement("Order for " + item + " placed at " + java.time.LocalTime.now());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BakeryGUI gui = new BakeryGUI();
            gui.setVisible(true);
        });
    }
}
