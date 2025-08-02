import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Election Commission");
        frame.setSize(800, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon ic = new ImageIcon("images/welcome.png");//to set the image path
        Image sc = ic.getImage().getScaledInstance(800, 650, Image.SCALE_SMOOTH);//image scaling
        ImageIcon ic2 = new ImageIcon(sc); //image after scaling to add or setup in Jlabel

        JLabel imageLabel = new JLabel(ic2);//to display background image 
        imageLabel.setBounds(0, 0, 800, 650);
        imageLabel.setLayout(null); 

        
        Font buttonFont = new Font("Arial", Font.BOLD, 18);//custom font size and style

        
        JButton bt = new JButton("Tap to Enter");
        bt.setBounds(280, 450, 240, 50);
        bt.setFont(buttonFont);
        bt.setBackground(new Color(40, 67, 169)); // green RGB code used 
        bt.setForeground(Color.WHITE);
        bt.setFocusPainted(false);// button blue border remove 

        imageLabel.add(bt); 
     
        frame.setLayout(null);
        frame.add(imageLabel);
        frame.setVisible(true);

        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 frame.dispose();        //to dispose the start frame   
            }
        });
	}

}
