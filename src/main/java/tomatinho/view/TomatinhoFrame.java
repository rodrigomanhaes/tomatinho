package tomatinho.view;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class TomatinhoFrame extends JFrame {
    private static final long serialVersionUID = -8092323271104865925L;

    private AddTaskPanel addTaskPanel;
    private List<TomatinhoContainer> containers;

    public TomatinhoFrame() {
        super("Tomatinho");
        init();
        build();
        getReady();
    }

    private void init() {
        addTaskPanel = new AddTaskPanel();
        containers = new ArrayList<TomatinhoContainer>();
        containers.add(addTaskPanel);
    }

    private void build() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(addTaskPanel);
    }

    private void getReady() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        maximizeAll();
        pack();
        normalizeAll();
        setVisible(true);
    }

    private void maximizeAll() {
        for (TomatinhoContainer c: containers)
            c.maximize();
    }

    private void normalizeAll() {
        for (TomatinhoContainer c: containers)
            c.normalSize();
    }
}