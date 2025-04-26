package ProjectDataStructures;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Array extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    private int[] array; // The array to store elements
    private int size;    // Size of the array
    private int currentIndex = 0; // Current index for insertion

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Array frame = new Array();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Array() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 736, 478);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Array Data Structure");
        lblNewLabel.setForeground(new Color(255, 0, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblNewLabel.setBounds(203, 11, 294, 26);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Size :");
        lblNewLabel_1.setForeground(new Color(0, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(32, 94, 49, 20);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setForeground(new Color(0, 0, 0));
        textField.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField.setBounds(109, 94, 96, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Create");
        btnNewButton.setForeground(new Color(0, 0, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton.setBounds(340, 85, 117, 38);
        btnNewButton.addActionListener(e -> {
            try {
                size = Integer.parseInt(textField.getText());
                array = new int[size]; // Initialize the array
                currentIndex = 0; // Reset current index
                JOptionPane.showMessageDialog(this, "Array of size " + size + " created.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid size! Please enter a number.");
            }
        });
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("Element :");
        lblNewLabel_2.setForeground(new Color(0, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(32, 172, 96, 20);
        contentPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_1.setBounds(138, 172, 121, 25);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Position :");
        lblNewLabel_3.setForeground(new Color(0, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_3.setBounds(328, 175, 96, 14);
        contentPane.add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_2.setBounds(434, 168, 96, 28);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JButton btnNewButton_1 = new JButton("Insert");
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_1.setBounds(583, 156, 89, 38);
        btnNewButton_1.addActionListener(e -> {
            try {
                int element = Integer.parseInt(textField_1.getText());
                int position = Integer.parseInt(textField_2.getText());
                if (position < 0 || position >= size) {
                    JOptionPane.showMessageDialog(this, "Invalid position! Must be between 0 and " + (size - 1));
                } else {
                    array[position] = element; // Insert element
                    currentIndex++;
                    JOptionPane.showMessageDialog(this, "Element inserted at position " + position);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.");
            } catch (ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(this, "Array index out of bounds! Check position.");
            }
        });
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_4 = new JLabel("Position :");
        lblNewLabel_4.setForeground(new Color(0, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_4.setBounds(32, 257, 89, 28);
        contentPane.add(lblNewLabel_4);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_3.setBounds(138, 257, 96, 28);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton_2 = new JButton("Delete");
        btnNewButton_2.setForeground(new Color(0, 0, 255));
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_2.setBounds(328, 247, 107, 38);
        btnNewButton_2.addActionListener(e -> {
            try {
                int position = Integer.parseInt(textField_3.getText());
                if (position < 0 || position >= size) {
                    JOptionPane.showMessageDialog(this, "Invalid position! Must be between 0 and " + (size - 1));
                } else {
                    array[position] = 0; // Delete element (reset to 0)
                    JOptionPane.showMessageDialog(this, "Element at position " + position + " deleted.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid position.");
            }
        });
        contentPane.add(btnNewButton_2);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField_4.setBounds(203, 330, 221, 28);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JButton btnNewButton_3 = new JButton("Display");
        btnNewButton_3.setForeground(new Color(0, 0, 255));
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_3.setBounds(36, 329, 121, 38);
        btnNewButton_3.addActionListener(e -> {
            if (array != null) {
                StringBuilder displayText = new StringBuilder();
                for (int value : array) {
                    displayText.append(value).append(" ");
                }
                textField_4.setText(displayText.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Array is not created yet.");
            }
        });
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Back");
        btnNewButton_4.setForeground(new Color(0, 0, 255));
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_4.setBounds(559, 368, 89, 38);
        btnNewButton_4.addActionListener(e -> dispose());
        contentPane.add(btnNewButton_4);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setForeground(new Color(255, 0, 0));
        lblNewLabel_5.setBounds(0, -26, 722, 467);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\istockphoto-1095759454-1024x1024.jpg"));
        lblNewLabel_6.setBounds(0, -26, 722, 467);
        contentPane.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\sunset-7760143_1280.jpg"));
        lblNewLabel_7.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        lblNewLabel_7.setBounds(0, 0, 722, 430);
        contentPane.add(lblNewLabel_7);
    }
}
