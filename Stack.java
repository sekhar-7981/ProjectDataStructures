package ProjectDataStructures;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Stack extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;      // Size input field
    private JTextField textField_1;    // Element input field for push
    private JTextField textField_2;    // Position input field for push
    private JTextField textField_3;    // Position input field for pop
    private JTextField textField_4;    // TextField to display the stack contents

    // Stack represented by ArrayList for dynamic operations
    private ArrayList<Integer> stack = new ArrayList<>();
    private int maxSize = 0;  // To store the maximum size of the stack

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Stack frame = new Stack();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Stack() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 745, 516);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Stack Data Structure");
        lblNewLabel.setForeground(new Color(255, 0, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblNewLabel.setBounds(203, 11, 286, 28);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Size :");
        lblNewLabel_1.setForeground(new Color(0, 255, 64));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(35, 92, 60, 28);
        contentPane.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField.setBounds(105, 95, 96, 28);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Create");
        btnNewButton.setForeground(new Color(255, 0, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton.setBounds(408, 89, 119, 41);
        btnNewButton.addActionListener(e -> {
            try {
                maxSize = Integer.parseInt(textField.getText());
                stack.clear();  // Reset stack when a new size is entered
                JOptionPane.showMessageDialog(this, "Stack of size " + maxSize + " created.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid size! Please enter a valid number.");
            }
        });
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("Element :");
        lblNewLabel_2.setForeground(new Color(0, 255, 64));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(35, 188, 96, 28);
        contentPane.add(lblNewLabel_2);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_1.setBounds(135, 188, 105, 27);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Position :");
        lblNewLabel_3.setForeground(new Color(0, 255, 64));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_3.setBounds(313, 188, 96, 24);
        contentPane.add(lblNewLabel_3);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_2.setBounds(408, 188, 119, 27);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Push");
        btnNewButton_1.setForeground(new Color(255, 0, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_1.setBounds(602, 181, 105, 41);
        btnNewButton_1.addActionListener(e -> {
            try {
                int element = Integer.parseInt(textField_1.getText());
                if (stack.size() >= maxSize) { // Check if the stack is full
                    JOptionPane.showMessageDialog(this, "Stack is full! Cannot add more elements.");
                } else {
                    int position = Integer.parseInt(textField_2.getText());
                    if (position < 0 || position > stack.size()) { // Position must be between 0 and stack size
                        JOptionPane.showMessageDialog(this, "Invalid position! Position must be between 0 and " + stack.size() + ".");
                    } else {
                        stack.add(position, element);  // Add element at specified position
                        JOptionPane.showMessageDialog(this, "Element " + element + " pushed at position " + position);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.");
            }
        });
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_4 = new JLabel("Position :");
        lblNewLabel_4.setForeground(new Color(0, 255, 64));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_4.setBounds(35, 295, 96, 28);
        contentPane.add(lblNewLabel_4);
        
        JButton btnNewButton_2 = new JButton("Pop");
        btnNewButton_2.setForeground(new Color(255, 0, 0));
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_2.setBounds(353, 282, 112, 41);
        btnNewButton_2.addActionListener(e -> {
            try {
                int position = Integer.parseInt(textField_3.getText());
                if (position < 0 || position >= stack.size()) { // Ensure position is valid
                    JOptionPane.showMessageDialog(this, "Invalid position! Cannot pop from position " + position + ". Position must be between 0 and " + (stack.size() - 1) + ".");
                } else {
                    int poppedElement = stack.remove(position);  // Pop element from specified position
                    JOptionPane.showMessageDialog(this, "Element " + poppedElement + " popped from position " + position);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.");
            }
        });
        contentPane.add(btnNewButton_2);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_3.setBounds(130, 295, 119, 27);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton_4 = new JButton("Display");
        btnNewButton_4.setForeground(new Color(255, 0, 0));
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_4.setBounds(35, 387, 136, 41);
        btnNewButton_4.addActionListener(e -> {
            StringBuilder stackContents = new StringBuilder();
            if (stack.isEmpty()) {
                stackContents.append("Stack is empty.");
            } else {
                // Append only the values (not positions)
                for (int i = 0; i < stack.size(); i++) {
                    stackContents.append(stack.get(i) + " "); // Only the values
                }
            }
            // Display the stack contents in textField_4
            textField_4.setText(stackContents.toString());
        });
        contentPane.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Back");
        btnNewButton_5.setForeground(new Color(255, 0, 0));
        btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_5.setBounds(556, 387, 105, 41);
        contentPane.add(btnNewButton_5);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_4.setBounds(205, 392, 204, 30);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\fantasy-2049567_1280.jpg"));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_5.setBounds(0, 0, 731, 468);
        contentPane.add(lblNewLabel_5);
    }
}
