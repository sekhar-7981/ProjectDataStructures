package ProjectDataStructures;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class CircularQueue extends JFrame {

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
                CircularQueue frame = new CircularQueue();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CircularQueue() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 829, 483);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Circular Queue Data Structure");
        lblTitle.setForeground(new Color(128, 0, 255));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblTitle.setBounds(210, 11, 361, 26);
        contentPane.add(lblTitle);

        JLabel lblSize = new JLabel("Size :");
        lblSize.setForeground(new Color(0, 0, 255));
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSize.setBounds(69, 80, 60, 26);
        contentPane.add(lblSize);

        textFieldSize = new JTextField();
        textFieldSize.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldSize.setBounds(144, 78, 121, 31);
        contentPane.add(textFieldSize);
        textFieldSize.setColumns(10);

        JButton btnCreate = new JButton("Create");
        btnCreate.setForeground(new Color(255, 0, 128));
        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCreate.setBounds(448, 72, 105, 43);
        contentPane.add(btnCreate);

        JLabel lblElement = new JLabel("Element :");
        lblElement.setForeground(new Color(0, 0, 255));
        lblElement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblElement.setBounds(69, 180, 105, 26);
        contentPane.add(lblElement);

        textFieldElement = new JTextField();
        textFieldElement.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldElement.setBounds(167, 171, 138, 35);
        contentPane.add(textFieldElement);
        textFieldElement.setColumns(10);

        JLabel lblInsertPosition = new JLabel("Position :");
        lblInsertPosition.setForeground(new Color(0, 0, 255));
        lblInsertPosition.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblInsertPosition.setBounds(359, 171, 105, 32);
        contentPane.add(lblInsertPosition);

        textFieldInsertPosition = new JTextField();
        textFieldInsertPosition.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldInsertPosition.setBounds(462, 169, 133, 37);
        contentPane.add(textFieldInsertPosition);
        textFieldInsertPosition.setColumns(10);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setForeground(new Color(255, 0, 128));
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnInsert.setBounds(675, 163, 105, 43);
        contentPane.add(btnInsert);

        JLabel lblDeletePosition = new JLabel("Position :");
        lblDeletePosition.setForeground(new Color(0, 0, 255));
        lblDeletePosition.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDeletePosition.setBounds(69, 273, 95, 32);
        contentPane.add(lblDeletePosition);

        textFieldDeletePosition = new JTextField();
        textFieldDeletePosition.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldDeletePosition.setBounds(172, 273, 133, 35);
        contentPane.add(textFieldDeletePosition);
        textFieldDeletePosition.setColumns(10);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setForeground(new Color(255, 0, 128));
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setBounds(418, 262, 105, 43);
        contentPane.add(btnDelete);

        JButton btnDisplay = new JButton("Display :");
        btnDisplay.setForeground(new Color(255, 0, 128));
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDisplay.setBounds(69, 361, 133, 43);
        contentPane.add(btnDisplay);

        textFieldDisplay = new JTextField();
        textFieldDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldDisplay.setBounds(232, 367, 291, 37);
        contentPane.add(textFieldDisplay);
        textFieldDisplay.setColumns(10);

        JButton btnBack = new JButton("Back");
        btnBack.setForeground(new Color(255, 0, 128));
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
                JOptionPane.showMessageDialog(this, "Circular Queue created with size " + size);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid size input!");
            }
        });

        btnInsert.addActionListener(e -> {
            try {
                int element = Integer.parseInt(textFieldElement.getText());
                if ((rear + 1) % size == front) {
                    JOptionPane.showMessageDialog(this, "Circular Queue is full!");
                } else {
                    if (front == -1) front = 0;  // First element
                    rear = (rear + 1) % size;    // Circular increment
                    queue[rear] = element;
                    JOptionPane.showMessageDialog(this, "Element inserted: " + element);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid element input!");
            }
        });

        btnDelete.addActionListener(e -> {
            if (front == -1) {
                JOptionPane.showMessageDialog(this, "Circular Queue is empty!");
            } else {
                int deleted = queue[front];
                if (front == rear) {
                    front = -1;
                    rear = -1;
                } else {
                    front = (front + 1) % size;  // Circular increment
                }
                JOptionPane.showMessageDialog(this, "Deleted element: " + deleted);
            }
        });

        btnDisplay.addActionListener(e -> {
            if (front == -1) {
                textFieldDisplay.setText("Circular Queue is empty!");
            } else {
                StringBuilder display = new StringBuilder();
                int i = front;
                while (i != rear) {
                    display.append(queue[i]).append(" ");
                    i = (i + 1) % size;  // Circular increment
                }
                display.append(queue[rear]);
                textFieldDisplay.setText(display.toString());
                
                JLabel lblNewLabel = new JLabel("\r\n");
                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\istockphoto-589538028-1024x1024 (1).jpg"));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
                lblNewLabel.setBounds(10, 0, 795, 446);
                contentPane.add(lblNewLabel);
            }
        });

        btnBack.addActionListener(e -> dispose());
    }
}
