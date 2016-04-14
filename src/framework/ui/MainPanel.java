package framework.ui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	private ArrayList<JPanel> listPane = new ArrayList<JPanel>();

	public MainPanel(ArrayList<JPanel> lst) {
		super(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		for (int i = 0; i < lst.size(); i++) {
			listPane.add(lst.get(i));
			tabbedPane.addTab(lst.get(i).getName(), lst.get(i));
			tabbedPane.setMnemonicAt(i, i);
		}

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

}
