package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import model.AbstractBiomorph;
import controller.EventAction;

/**
 * Splash screen with user selection.
 * 
 * @author Nouman Mehmood <mehmoodn@aston.ac.uk>
 */

public class InterfacePicker extends AbstractGUI implements BiomorphInterface{
	
	private BiomorphInterface interfaceToLoad;
	
	private JLabel welcome;
	private JLabel title;
	private JLabel usertype;
	private JLabel description;
	private JLabel beginnerLabel;
	private JLabel advancedLabel;
	private JLabel helpLabel;
	private JLabel quitLabel;

	private JSeparator separator;
	
	private JButton beginner;
	private JButton advanced;
	private JButton help;
	private JButton quit;
	
	private JPanel panel;
	private JLabel devlabel1;
	private JLabel devlabel2;
	
	
	private List<BiomorphPanel> hallOfFameBiomorphs;
	private List<JButton> hallOfFameDeleteButtons;
	private BiomorphPanel biomorphPanelToDelete;
	private BiomorphPanel biomorphPanelToLoad;
	
	private GenomeViewUpdateModel genomeUpdate;


	public InterfacePicker(final AbstractBiomorph model) {
		super("Biomorph Mutation: Select User type", 1200, 640);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setResizable(false);

		/** Create the Panel */
		panel = new JPanel();
		panel.setBounds(10, 10, 900, 590);
		panel.setBorder(new EmptyBorder(15, 15, 15, 15));
		panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel.setLayout(null);
		
		/** Create the different labels*/
		welcome = new JLabel("CS2010, Group 7 Presents ");
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		welcome.setBounds(20, 20, 203, 30);
		
		title = new JLabel("The Biomorph Mutation Application");
		title.setFont(new Font("Tahoma", Font.BOLD, 37));
		title.setBounds(20, 50, 700, 40);
		
		description = new JLabel("Produce evolutionary art based on Richard Dawkin's Biomorphs in a creative way");
		description.setFont(new Font("Tahoma", Font.PLAIN, 20));
		description.setBounds(20, 100, 1000, 40);
		
		usertype = new JLabel("First, choose what type of user you are");
		usertype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usertype.setBounds(20, 180, 300, 40);
		
		/** Create the different buttons */
		separator = new JSeparator();
		separator.setBounds(20, 358, 550, 2);
		
		beginner = new JButton(" Beginner ");
		beginner.setForeground(Color.BLACK);
		beginner.setFont(new Font("Tahoma", Font.PLAIN, 16));
		beginner.setToolTipText("Using the application for the first time? Choose Beginner");
		beginner.setBounds(20, 230, 120, 40);
		
		beginnerLabel = new JLabel("Generate a basic biomorph");
		beginnerLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		beginnerLabel.setBounds(170, 231, 482, 40);
		
		advanced = new JButton(" Advanced ");
		advanced.setFont(new Font("Tahoma", Font.PLAIN, 16));
		advanced.setToolTipText("Want to experience something extraordinary? Choose advanced");
		advanced.setBounds(20, 290, 120, 40);
		
		advancedLabel = new JLabel("Produce more advanced biomorphs");
		advancedLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		advancedLabel.setBounds(170, 290, 405, 40);
		
		help = new JButton(" Help ");
		help.setFont(new Font("Tahoma", Font.PLAIN, 16));
		help.setToolTipText("Exit the Application. Unsaved Settings will be lost");
		help.setBounds(20, 386, 120, 40);
		help.setEnabled(false);
		
		helpLabel = new JLabel("Unsure about how to use the application?");
		helpLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		helpLabel.setBounds(170, 386, 316, 40);
		
		quit= new JButton(" Quit ");
		quit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quit.setToolTipText("Exit the Application. Unsaved Settings will be lost");
		quit.setBounds(20, 446, 120, 40);
		
		quitLabel = new JLabel("Exit the Application");
		quitLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quitLabel.setBounds(170, 446, 316, 40);
			
		devlabel1 = new JLabel("Developed by: ");
		devlabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		devlabel1.setBounds(20, 520, 120, 40);
		panel.add(devlabel1);
		
		devlabel2 = new JLabel("Alex Luckett, Nouman Mehmood, Jurgen Hajdini, Kelvin Chui & Mohammad Hussain");
		devlabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		devlabel2.setBounds(20, 550, 618, 40);
		panel.add(devlabel2);
		
		/** Add the different components to the Panel */
		panel.add(welcome);
		panel.add(title);
		panel.add(description);
		panel.add(usertype);
		panel.add(beginner);
		panel.add(advanced);
		panel.add(help);
		panel.add(quit);
		panel.add(beginnerLabel);
		panel.add(advancedLabel);
		panel.add(helpLabel);
		panel.add(quitLabel);
		panel.add(separator);
		
		/**Hall of Fame */
		hallOfFameBiomorphs = new ArrayList<BiomorphPanel>();
		hallOfFameDeleteButtons = new ArrayList<JButton>();
		
		JPanel hofPanel = new JPanel();
		hofPanel.setBounds(919, 12, 270, 590);
		hofPanel.setLayout(null);
		
		JLabel hofLabel = new JLabel(" Hall of Fame ");
		hofLabel.setBounds(80, -10, 150, 40);
		hofLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
			
		hofPanel.add(hofLabel);
		
		/* start point to position components at */
		int previousPanelY = 35;
		int previousBtnY = 190;
		
		for(int i = 0; i < 3; i++) {
			BiomorphPanel hofSubpanel = new BiomorphPanel();
			hofSubpanel.setBorder(new EmptyBorder(15, 15, 15, 15));
			hofSubpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			hofSubpanel.setBounds(10, previousPanelY, 250, 150);
			hofSubpanel.setLayout(null);
			hofSubpanel.addMouseListener(new HallOfFameLoadListener(hofSubpanel));
			
			JButton hofRemoveBtn = new JButton("Remove");
			hofRemoveBtn.setFont((new Font("Tahoma", Font.PLAIN, 12)));
			hofRemoveBtn.setBounds(95, previousBtnY, 90, 20);
			hofRemoveBtn.addMouseListener(new HallOfFameDeleteListener(hofSubpanel));
			
			previousPanelY += 185; // height of each component
			previousBtnY += 185;
			
			hofPanel.add(hofSubpanel);
			hofPanel.add(hofRemoveBtn);
			
			hallOfFameBiomorphs.add(hofSubpanel);
			hallOfFameDeleteButtons.add(hofRemoveBtn);
		}				
		
	
		windowFrame.add(hofPanel);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/** Add the panel to the window */
		windowFrame.getContentPane().add(panel);
		windowFrame.pack();
		windowFrame.setLocationRelativeTo(null); // centre aligned
		
		
		/** Beginner selection */
		beginner.addMouseListener(new EventAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				interfaceToLoad = new BasicGUI(model);
				destroyGui();
				System.out.println("basic set");
			}

		});

		/** Advanced Selection */
		advanced.addMouseListener(new EventAction() {	

			@Override
			public void actionPerformed(ActionEvent e) {
				interfaceToLoad = new AdvancedGUI(model);
				destroyGui();
				System.out.println("advanced set");
			}

		});

		
		/** Help Selection */
	//TODO
		
		
		/** Exit the application*/
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event){
				exitApplication();
			}
			
		});
		
		
		
	}
	
	public void addInterfacePickedListener(EventAction listener) {
		beginner.addMouseListener(listener);
		advanced.addMouseListener(listener);
	}
	
	public BiomorphInterface getInterfaceToLoad() {
		return interfaceToLoad;
	}
	
	
	
	
	
	

	@Override
	public GenomeViewUpdateModel getGenomeUpdate() {
		return genomeUpdate;
	}
	
	
	
	@Override
	public void addLoadHallOfFameBiomorphListener(EventAction listener) {
		for(BiomorphPanel panel : hallOfFameBiomorphs) {
			panel.addMouseListener(listener);
		}
	}

	@Override
	public void addDeleteHallOfFameBiomorphListener(EventAction listener) {
		for(JButton button : hallOfFameDeleteButtons) {
			button.addMouseListener(listener);
		}
	}

	

	@Override
	public void loadHallOfFame(List<AbstractBiomorph> biomorphs) {
		for(BiomorphPanel panel : hallOfFameBiomorphs) {
			panel.setBiomorph(null);
		}
		
		if(biomorphs.size() <= 3) {
			for(int i = 0; i < biomorphs.size(); i++) {
				hallOfFameBiomorphs.get(i).setBiomorph(biomorphs.get(i));
			}
		}
		
		for(BiomorphPanel panel : hallOfFameBiomorphs) {
			panel.refresh(); // ensure all panels are painted with new biomorph
		}
	}
	
	class HallOfFameDeleteListener extends EventAction {
		
		private BiomorphPanel biomorphPanel;
		
		public HallOfFameDeleteListener(BiomorphPanel biomorphPanel) {
			this.biomorphPanel = biomorphPanel;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			biomorphPanelToDelete = biomorphPanel;
		}
	}
	
	class HallOfFameLoadListener extends EventAction {
		
		private BiomorphPanel biomorphPanel;
		
		public HallOfFameLoadListener(BiomorphPanel biomorphNumber) {
			this.biomorphPanel = biomorphNumber;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			biomorphPanelToLoad = biomorphPanel;
		}
	}

	@Override
	public AbstractBiomorph getHofBiomorphToDelete() {
		return biomorphPanelToDelete.getBiomorph(); // files don't use 0 based numbering
	}

	@Override
	public AbstractBiomorph getHofBiomorphToLoad() {
		return biomorphPanelToLoad.getBiomorph();
	}

	@Override
	public void addGenerateListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMutateListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUpdateBiomorphListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addExitListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHelpListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUndoListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLoadInterfacePickerListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAddHallOfFameListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addManipulateBiomorphListener(MouseListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLoadProjectListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSaveProjectListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSaveImageListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGenomeChangeListener(EventAction listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMutations(List<AbstractBiomorph> biomorphs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AbstractBiomorph getMutatedBiomorph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BiomorphPanel getBiomorphPanel() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
	
	
	
}