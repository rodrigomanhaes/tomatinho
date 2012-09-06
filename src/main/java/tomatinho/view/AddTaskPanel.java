package tomatinho.view;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class AddTaskPanel extends JPanel implements TomatinhoContainer {
    private static final long serialVersionUID = -1940037701772368610L;

    private JButton addTask;
    private JTextField description;
    private JButton ok;
    private JPanel mainPanel;
    private JPanel formPanel;

    public AddTaskPanel() {
        super();
        init();
        build();
        bindEvents();
    }

    private void init() {
        addTask = new JButton("Add task");
        description = new JTextField(20);
        ok = new JButton("Ok");
        mainPanel = new JPanel();
        formPanel = new JPanel();
    }

    private void build() {
        setLayout(new FlowLayout());
        add(mainPanel);
        add(formPanel);
        formPanel.setVisible(false);

        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(addTask);

        formPanel.setLayout(new FlowLayout());
        formPanel.add(new JLabel("Description"));
        formPanel.add(description);
        formPanel.add(ok);
        formPanel.setBorder(BorderFactory.createTitledBorder("Add task"));
    }

    private void bindEvents() {
        addTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showForm();
            }
        });

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showButton();
            }
        });
    }

    public void maximize() {
        showForm();
    }

    public void normalSize() {
        showButton();
    }

    private void showForm() {
        mainPanel.setVisible(false);
        formPanel.setVisible(true);
    }

    private void showButton() {
        mainPanel.setVisible(true);
        formPanel.setVisible(false);
    }
}