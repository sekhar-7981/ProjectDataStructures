package ProjectDataStructures;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class DoublyLinkedList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldElement;
    private JTextField textFieldSearch;
    private JTextField textFieldDisplay;
    private Node head = null;
    private Node tail = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DoublyLinkedList frame = new DoublyLinkedList();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DoublyLinkedList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 868, 499);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Doubly Linked List Data Structure");
        lblTitle.setForeground(new Color(128, 0, 255));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblTitle.setBounds(228, 11, 411, 28);
        contentPane.add(lblTitle);

        JLabel lblElement = new JLabel("Element:");
        lblElement.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblElement.setBounds(34, 82, 109, 28);
        contentPane.add(lblElement);

        textFieldElement = new JTextField();
        textFieldElement.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldElement.setBounds(138, 82, 191, 27);
        contentPane.add(textFieldElement);
        textFieldElement.setColumns(10);

        JLabel lblSearch = new JLabel("Search Element:");
        lblSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSearch.setBounds(34, 173, 161, 28);
        contentPane.add(lblSearch);

        textFieldSearch = new JTextField();
        textFieldSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldSearch.setBounds(201, 173, 178, 28);
        contentPane.add(textFieldSearch);
        textFieldSearch.setColumns(10);

        JLabel lblDisplay = new JLabel("Display:");
        lblDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDisplay.setBounds(34, 263, 109, 34);
        contentPane.add(lblDisplay);

        textFieldDisplay = new JTextField();
        textFieldDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
        textFieldDisplay.setBounds(138, 263, 386, 30);
        textFieldDisplay.setEditable(false);
        contentPane.add(textFieldDisplay);
        textFieldDisplay.setColumns(10);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setForeground(new Color(128, 0, 64));
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnInsert.setBounds(34, 355, 109, 39);
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
        contentPane.add(btnInsert);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setForeground(new Color(128, 0, 64));
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setBounds(230, 355, 129, 39);
        btnDelete.addActionListener(e -> {
            if (head == null) {
                JOptionPane.showMessageDialog(this, "List is empty!");
            } else {
                int deletedData = delete();
                JOptionPane.showMessageDialog(this, "Deleted element: " + deletedData);
                textFieldDisplay.setText(display());
            }
        });
        contentPane.add(btnDelete);

        JButton btnSearch = new JButton("Search");
        btnSearch.setForeground(new Color(128, 0, 64));
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSearch.setBounds(433, 355, 129, 39);
        btnSearch.addActionListener(e -> {
            try {
                int key = Integer.parseInt(textFieldSearch.getText());
                boolean found = search(key);
                JOptionPane.showMessageDialog(this, "Element " + key + (found ? " found!" : " not found!"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter an integer.");
            }
        });
        contentPane.add(btnSearch);

        JButton btnSort = new JButton("Sort");
        btnSort.setForeground(new Color(128, 0, 64));
        btnSort.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSort.setBounds(624, 355, 99, 39);
        btnSort.addActionListener(e -> {
            sort();
            JOptionPane.showMessageDialog(this, "List sorted!");
            textFieldDisplay.setText(display());
        });
        contentPane.add(btnSort);

        JButton btnBack = new JButton("Back");
        btnBack.setForeground(new Color(128, 0, 64));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnBack.setBounds(733, 411, 89, 40);
        btnBack.addActionListener(e -> dispose());
        contentPane.add(btnBack);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\istockphoto-1301592082-1024x1024.jpg"));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(0, 0, 844, 462);
        contentPane.add(lblNewLabel);
    }

    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    private int delete() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int deletedData = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return deletedData;
    }

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
                result.append(" <-> ");
            }
        }
        return result.toString();
    }

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

    private void sort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current != null && current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
