package ProjectDataStructures;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AllDataStructures extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AllDataStructures frame = new AllDataStructures();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

    public AllDataStructures() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 845, 504);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Data Structures Algorithms...");
        lblTitle.setForeground(new Color(255, 0, 255));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblTitle.setBounds(242, 11, 342, 49);
        contentPane.add(lblTitle);

        // Create and add buttons for each data structure
        JButton btnArray = new JButton("Array");
        btnArray.setForeground(new Color(0, 128, 64));
        btnArray.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnArray.setBounds(182, 87, 89, 48);
        btnArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Array arrayFrame = new Array();
                arrayFrame.setVisible(true);
            }
        });
        contentPane.add(btnArray);

        JButton btnStack = new JButton("Stack");
        btnStack.setForeground(new Color(0, 128, 64));
        btnStack.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnStack.setBounds(513, 87, 89, 48);
        btnStack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Stack stackFrame = new Stack();
                stackFrame.setVisible(true);
            }
        });
        contentPane.add(btnStack);

        JButton btnQueue = new JButton("Queue");
        btnQueue.setForeground(new Color(0, 128, 64));
        btnQueue.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnQueue.setBounds(168, 203, 144, 48);
        btnQueue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Queue queueFrame = new Queue();
                queueFrame.setVisible(true);
            }
        });
        contentPane.add(btnQueue);

        JButton btnCircularQueue = new JButton("Circular Queue");
        btnCircularQueue.setForeground(new Color(0, 128, 64));
        btnCircularQueue.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCircularQueue.setBounds(480, 203, 183, 48);
        btnCircularQueue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CircularQueue circularQueueFrame = new CircularQueue();
                circularQueueFrame.setVisible(true);
            }
        });
        contentPane.add(btnCircularQueue);

        JButton btnSinglyLinkedList = new JButton("Singly Linked List");
        btnSinglyLinkedList.setForeground(new Color(0, 128, 64));
        btnSinglyLinkedList.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSinglyLinkedList.setBounds(136, 305, 221, 53);
        btnSinglyLinkedList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SingleyLinkedList singlyLinkedListFrame = new SingleyLinkedList();
                singlyLinkedListFrame.setVisible(true);
            }
        });
        contentPane.add(btnSinglyLinkedList);

        JButton btnDoublyLinkedList = new JButton("Doubly Linked List");
        btnDoublyLinkedList.setForeground(new Color(0, 128, 64));
        btnDoublyLinkedList.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDoublyLinkedList.setBounds(466, 305, 232, 53);
        btnDoublyLinkedList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoublyLinkedList doublyLinkedListFrame = new DoublyLinkedList();
                doublyLinkedListFrame.setVisible(true);
            }
        });
        contentPane.add(btnDoublyLinkedList);

        // Master button to open all frames at once
        JButton btnOpenAll = new JButton("Open All");
        btnOpenAll.setForeground(new Color(255, 0, 0));
        btnOpenAll.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnOpenAll.setBounds(323, 388, 180, 48);
        btnOpenAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Array arrayFrame = new Array();
                arrayFrame.setVisible(true);
                Stack stackFrame = new Stack();
                stackFrame.setVisible(true);
                Queue queueFrame = new Queue();
                queueFrame.setVisible(true);
                CircularQueue circularQueueFrame = new CircularQueue();
                circularQueueFrame.setVisible(true);
                SingleyLinkedList singlyLinkedListFrame = new SingleyLinkedList();
                singlyLinkedListFrame.setVisible(true);
                DoublyLinkedList doublyLinkedListFrame = new DoublyLinkedList();
                doublyLinkedListFrame.setVisible(true);
            }
        });
        contentPane.add(btnOpenAll);

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\istockphoto-485371557-1024x1024.jpg"));
        lblBackground.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblBackground.setBounds(10, 11, 811, 445);
        contentPane.add(lblBackground);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\istockphoto-589538028-1024x1024.jpg"));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(10, 11, 797, 445);
        contentPane.add(lblNewLabel);
    }
}
