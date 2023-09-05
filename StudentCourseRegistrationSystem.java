
package studentcourseregistrationsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseRegistrationSystem {

    private String name;
    private int studentId;
    private String email;
    private List<String> courses;

    public StudentCourseRegistrationSystem(int studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.courses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void registerCourse(String courseName) {
        courses.add(courseName);
    }

    @Override
    public String toString() {
        return name + " (ID: " + studentId + ")";
    }
}

class CourseRegistrationApp extends JFrame {
    private List<StudentCourseRegistrationSystem> students;
    private JTextField nameTextField;
    private JTextField idTextField;
    private JComboBox<String> courseComboBox;
    private JTextArea outputTextArea;

    public CourseRegistrationApp() {
        students = new ArrayList<>();
        students.add(new StudentCourseRegistrationSystem(1, "Amaya Devi", "amaya@example.com"));
        students.add(new StudentCourseRegistrationSystem(2, "Aditya Raj", "aditya@example.com"));
        students.add(new StudentCourseRegistrationSystem(3, "Harshit Kumar", "harshit@example.com"));

        setTitle("Student Course Registration");
        setSize(960, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        nameTextField = new JTextField();
        idTextField = new JTextField();
        courseComboBox = new JComboBox<>();
        outputTextArea = new JTextArea();


        populateCourseComboBox();
        
       JPanel inputPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); // Padding
        inputPanel.setBackground(Color.cyan);
        
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Increased font size for labels
        inputPanel.add(nameLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nameTextField.setPreferredSize(new Dimension(150, 40));
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        inputPanel.add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel idLabel = new JLabel("ID Number:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Increased font size for labels
        inputPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        idTextField.setPreferredSize(new Dimension(150, 40));
        idTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        inputPanel.add(idTextField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        JLabel courseLabel = new JLabel("Courses:");
        courseLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Increased font size for labels
        inputPanel.add(courseLabel, gbc);


        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        courseComboBox.setPreferredSize(new Dimension(150, 40));
        courseComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        inputPanel.add(courseComboBox, gbc);
        
        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        registerButton.setPreferredSize(new Dimension(150, 40));
        registerButton.setFont(new Font("Arial", Font.BOLD, 20));
        inputPanel.add(registerButton, gbc);
        
          registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = nameTextField.getText();
                int studentId = Integer.parseInt(idTextField.getText());
                String courseName = (String) courseComboBox.getSelectedItem();

                // Create a new student and add them to the list
                StudentCourseRegistrationSystem student = new StudentCourseRegistrationSystem(studentId, studentName, "");
                students.add(student);

                outputTextArea.append("Student Name: " + student.getName() + "\nID Number: " +
                        student.getStudentId() + "\nRegistered for Course: " + courseName + "\n\n");

                // Clear text fields
                nameTextField.setText("");
                idTextField.setText("");
            }
        });
          
        add(inputPanel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputTextArea.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        outputTextArea.setBackground(Color.WHITE);
        outputTextArea.setOpaque(true); 
        add(scrollPane, BorderLayout.CENTER);
    }

    private void populateCourseComboBox() {
        courseComboBox.addItem("Select Courses");
        courseComboBox.addItem("Math");
        courseComboBox.addItem("History");
        courseComboBox.addItem("Computer Science");
        courseComboBox.addItem("Hindi");
        courseComboBox.addItem("Physics");   
        courseComboBox.addItem("Social Science");
        courseComboBox.addItem("Chemistry");
        courseComboBox.addItem("Biology");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CourseRegistrationApp app = new CourseRegistrationApp();
                app.setVisible(true);
            }
        });
    }
}



    

