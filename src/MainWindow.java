/** 
* Java Hash Generator
* Realize the conversion of text into hash value on java, use Java GUI, easy to use, support MD5/SHA1/SHA256/SHA512 hash algorithm.
* 
* @author  Karasukaigan 
* @date    2021/6/16
* @version 1.0.0
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public MainWindow() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setTitle("Java Hash Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JRadioButton jrbMD5 = new JRadioButton("MD5");
		jrbMD5.setSelected(true);
		
		JRadioButton jrbSHA1 = new JRadioButton("SHA1");
		
		JRadioButton jrbSHA256 = new JRadioButton("SHA256");
		
		JRadioButton jrbSHA512 = new JRadioButton("SHA512");
		
		ButtonGroup group = new ButtonGroup();
		group.add(jrbMD5);
		group.add(jrbSHA1);
		group.add(jrbSHA256);
		group.add(jrbSHA512);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
				
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);
					
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jrbMD5.isSelected()) {
					textArea_1.setText(GetHash.getHash(textArea.getText(),"MD5"));
				} else if (jrbSHA1.isSelected()) {
					textArea_1.setText(GetHash.getHash(textArea.getText(),"SHA1"));
				} else if (jrbSHA256.isSelected()) {
					textArea_1.setText(GetHash.getHash(textArea.getText(),"SHA256"));
				} else if (jrbSHA512.isSelected()) {
					textArea_1.setText(GetHash.getHash(textArea.getText(),"SHA512"));
				}
			}
		});
		
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_desktopPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jrbMD5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jrbSHA1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jrbSHA256)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jrbSHA512)))
					.addContainerGap())
		);
		
		gl_desktopPane.setVerticalGroup(
				gl_desktopPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_desktopPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton)
							.addComponent(jrbMD5)
							.addComponent(jrbSHA1)
							.addComponent(jrbSHA256)
							.addComponent(jrbSHA512))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
		);
		desktopPane.setLayout(gl_desktopPane);
	}
}
