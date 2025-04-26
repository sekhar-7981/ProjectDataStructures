package ProjectDataStructures;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Queue extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldSize;
    private JTextField textFieldElement;
    private JTextField textFieldInsertPosition;
    private JTextField textFieldDeletePosition;
    private JTextField textFieldDisplay;

    private int[] queue;
    private int front = -1, rear = -1, size;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Queue frame = new Queue();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Queue() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 829, 483);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Queue Data Structure");
        lblTitle.setForeground(new Color(255, 0, 255));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblTitle.setBounds(301, 11, 274, 26);
        contentPane.add(lblTitle);

        JLabel lblSize = new JLabel("Size :");
        lblSize.setForeground(new Color(255, 0, 0));
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSize.setBounds(69, 80, 60, 26);
        contentPane.add(lblSize);

        textFieldSize = new JTextField();
        textFieldSize.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldSize.setBounds(139, 80, 121, 32);
        contentPane.add(textFieldSize);
        textFieldSize.setColumns(10);

        JButton btnCreate = new JButton("Create");
        btnCreate.setForeground(new Color(0, 0, 255));
        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCreate.setBounds(446, 69, 105, 43);
        contentPane.add(btnCreate);

        JLabel lblElement = new JLabel("Element :");
        lblElement.setForeground(new Color(255, 0, 0));
        lblElement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblElement.setBounds(69, 180, 105, 26);
        contentPane.add(lblElement);

        textFieldElement = new JTextField();
        textFieldElement.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldElement.setBounds(167, 180, 138, 32);
        contentPane.add(textFieldElement);
        textFieldElement.setColumns(10);

        JLabel lblInsertPosition = new JLabel("Position :");
        lblInsertPosition.setForeground(new Color(255, 0, 0));
        lblInsertPosition.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblInsertPosition.setBounds(359, 171, 105, 32);
        contentPane.add(lblInsertPosition);

        textFieldInsertPosition = new JTextField();
        textFieldInsertPosition.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldInsertPosition.setBounds(462, 171, 133, 35);
        contentPane.add(textFieldInsertPosition);
        textFieldInsertPosition.setColumns(10);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setForeground(new Color(0, 0, 255));
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnInsert.setBounds(675, 163, 105, 43);
        contentPane.add(btnInsert);

        JLabel lblDeletePosition = new JLabel("Position :");
        lblDeletePosition.setForeground(new Color(255, 0, 0));
        lblDeletePosition.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDeletePosition.setBounds(69, 273, 95, 32);
        contentPane.add(lblDeletePosition);

        textFieldDeletePosition = new JTextField();
        textFieldDeletePosition.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldDeletePosition.setBounds(172, 271, 133, 34);
        contentPane.add(textFieldDeletePosition);
        textFieldDeletePosition.setColumns(10);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setForeground(new Color(0, 0, 255));
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setBounds(418, 262, 105, 43);
        contentPane.add(btnDelete);

        JButton btnDisplay = new JButton("Display :");
        btnDisplay.setForeground(new Color(0, 0, 255));
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDisplay.setBounds(69, 361, 133, 43);
        contentPane.add(btnDisplay);

        textFieldDisplay = new JTextField();
        textFieldDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldDisplay.setBounds(232, 361, 291, 32);
        contentPane.add(textFieldDisplay);
        textFieldDisplay.setColumns(10);

        JButton btnBack = new JButton("Back");
        btnBack.setForeground(new Color(0, 0, 255));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnBack.setBounds(661, 377, 105, 43);
        contentPane.add(btnBack);

        // Action Listeners
        btnCreate.addActionListener(e -> {
            try {
                size = Integer.parseInt(textFieldSize.getText());
                queue = new int[size];
                front = -1;
                rear = -1;
                JOptionPane.showMessageDialog(this, "Queue created with size " + size);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid size input!");
            }
        });

        btnInsert.addActionListener(e -> {
            try {
                int element = Integer.parseInt(textFieldElement.getText());
                if (rear == size - 1) {
                    JOptionPane.showMessageDialog(this, "Queue is full!");
                } else {
                    if (front == -1) front = 0;
                    queue[++rear] = element;
                    JOptionPane.showMessageDialog(this, "Element inserted: " + element);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid element input!");
            }
        });

        btnDelete.addActionListener(e -> {
            if (front == -1 || front > rear) {
                JOptionPane.showMessageDialog(this, "Queue is empty!");
            } else {
                int deleted = queue[front++];
                JOptionPane.showMessageDialog(this, "Deleted element: " + deleted);
            }
        });

        btnDisplay.addActionListener(e -> {
            if (front == -1 || front > rear) {
                textFieldDisplay.setText("Queue is empty!");
            } else {
                StringBuilder display = new StringBuilder();
                for (int i = front; i <= rear; i++) {
                    display.append(queue[i]).append(" ");
                }
                textFieldDisplay.setText(display.toString());
                
                JLabel lblSize_1 = new JLabel("");
                lblSize_1.setFont(new Font("Tahoma", Font.BOLD, 18));
                lblSize_1.setBounds(0, -25, 815, 471);
                contentPane.add(lblSize_1);
                
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\field-6574455_1280.jpg"));
                lblNewLabel.setBounds(0, -25, 815, 471);
                contentPane.add(lblNewLabel);
            }
        });

        btnBack.addActionListener(e -> dispose());
    }
}
