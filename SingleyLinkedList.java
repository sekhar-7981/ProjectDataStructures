package ProjectDataStructures;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class SingleyLinkedList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldElement;
    private JTextField textFieldSearch;
    private JTextField textFieldDisplay;

    private Node head = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SingleyLinkedList frame = new SingleyLinkedList();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public SingleyLinkedList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 829, 515);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Singly Linked List Data Structure");
        lblTitle.setForeground(new Color(0, 0, 255));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblTitle.setBounds(214, 11, 400, 31);
        contentPane.add(lblTitle);

        JLabel lblElement = new JLabel("Element:");
        lblElement.setForeground(new Color(255, 0, 255));
        lblElement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblElement.setBounds(69, 80, 105, 26);
        contentPane.add(lblElement);

        textFieldElement = new JTextField();
        textFieldElement.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldElement.setBounds(167, 75, 138, 31);
        contentPane.add(textFieldElement);
        textFieldElement.setColumns(10);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setForeground(new Color(255, 0, 0));
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnInsert.setBounds(40, 322, 105, 43);
        contentPane.add(btnInsert);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setForeground(new Color(255, 0, 0));
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setBounds(235, 322, 105, 43);
        contentPane.add(btnDelete);

        JLabel lblSearch = new JLabel("Search Element:");
        lblSearch.setForeground(new Color(255, 0, 255));
        lblSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSearch.setBounds(69, 165, 190, 26);
        contentPane.add(lblSearch);

        textFieldSearch = new JTextField();
        textFieldSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldSearch.setBounds(247, 165, 138, 26);
        contentPane.add(textFieldSearch);
        textFieldSearch.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setForeground(new Color(255, 0, 0));
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSearch.setBounds(420, 322, 105, 43);
        contentPane.add(btnSearch);

        JButton btnSort = new JButton("Sort");
        btnSort.setForeground(new Color(255, 0, 0));
        btnSort.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSort.setBounds(604, 322, 116, 43);
        contentPane.add(btnSort);

        JLabel lblDisplay = new JLabel("Display:");
        lblDisplay.setForeground(new Color(255, 0, 255));
        lblDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDisplay.setBounds(69, 240, 133, 26);
        contentPane.add(lblDisplay);

        textFieldDisplay = new JTextField();
        textFieldDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldDisplay.setBounds(167, 235, 400, 37);
        textFieldDisplay.setEditable(false);
        contentPane.add(textFieldDisplay);
        textFieldDisplay.setColumns(10);

        JButton btnBack = new JButton("Back");
        btnBack.setForeground(new Color(255, 0, 0));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnBack.setBounds(676, 407, 105, 43);
        contentPane.add(btnBack);

        // Action Listeners
        btnInsert.addActionListener(e -> {
            try {
                int element = Integer.parseInt(textFieldElement.getText());
                insert(element);
                JOptionPane.showMessageDialog(this, "Element inserted: " + element);
                textFieldElement.setText("");
                textFieldDisplay.setText(display());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter an integer.");
            }
        });

        btnDelete.addActionListener(e -> {
            if (head == null) {
                JOptionPane.showMessageDialog(this, "List is empty!");
            } else {
                int deleted = delete();
                JOptionPane.showMessageDialog(this, "Deleted element: " + deleted);
                textFieldDisplay.setText(display());
            }
        });

        btnSearch.addActionListener(e -> {
            try {
                int key = Integer.parseInt(textFieldSearch.getText());
                boolean found = search(key);
                JOptionPane.showMessageDialog(this, "Element " + key + (found ? " found!" : " not found!"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter an integer.");
            }
        });

        btnSort.addActionListener(e -> {
            sort();
            JOptionPane.showMessageDialog(this, "List sorted!");
            textFieldDisplay.setText(display());
            
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
            lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\istockphoto-1614045654-1024x1024.jpg"));
            lblNewLabel.setBounds(0, 0, 805, 467);
            contentPane.add(lblNewLabel);
        });

        btnBack.addActionListener(e -> dispose());
    }

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert a new node at the end of the list
    private void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Delete the first node from the list
    private int delete() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int deletedData = head.data;
        head = head.next;
        return deletedData;
    }

    // Display the elements in the list
    private String display() {
        if (head == null) {
            return "List is empty";
        }
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            result.append(temp.data);
            temp = temp.next;
            if (temp != null) {
                result.append(" -> ");
            }
        }
        return result.toString();
    }

    // Search for an element in the list
    private boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Sort the linked list
    private void sort() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}
