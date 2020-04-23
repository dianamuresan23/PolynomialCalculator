package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame{
	JTextField firstPoly=new JTextField(35);
	private JLabel poly1=new JLabel("Polinom 1");
	JTextField secondPoly=new JTextField(35);
	private JLabel poly2=new JLabel("Polinom 2");
	
	private JButton sum=new JButton("Adunare  ");
	private JButton dif=new JButton("Scadere   ");
	private JButton imp=new JButton("Impartire");
	private JButton inm=new JButton("Inmultire ");
	private JButton deriv=new JButton("Derivare  ");
	private JButton integr=new JButton("Integrare");
	private JButton reset=new JButton("Resetare");
	
	JTextField rez=new JTextField(50);
	private JLabel rezultat=new JLabel("Rezultat");
	
	
	View()
	{
		JFrame f=new JFrame("Calculator Polinoame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(600,350));

		JPanel p=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		poly1.setFont(new Font("TimesRoman",Font.BOLD,15));
		poly2.setFont(new Font("TimesRoman",Font.BOLD,15));
		rezultat.setFont(new Font("TimesRoman",Font.BOLD,15));
		firstPoly.setPreferredSize(new Dimension(200,30));
		firstPoly.setBackground(new Color(255, 230, 204));
		firstPoly.setFont(new Font("TimesRoman",Font.BOLD,15));
		secondPoly.setPreferredSize(new Dimension(200,30));
		secondPoly.setBackground(new Color(255, 230, 204));
		secondPoly.setFont(new Font("TimesRoman",Font.BOLD,15));
		rez.setPreferredSize(new Dimension(200,30));
		rez.setBackground(new Color(255, 230, 204));
		rez.setFont(new Font("TimesRoman",Font.BOLD,15));
		p.add(poly1);
		p.add(firstPoly);
		p.add(poly2);
		p.add(secondPoly);
		
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
	    sum.setBackground(new Color(102, 102, 153));
	    sum.setForeground(Color.WHITE);
	    sum.setFont(new Font("Tahoma", Font.BOLD, 14));
	    sum.setPreferredSize(new Dimension(40,40));
	    dif.setBackground(new Color(102, 102, 153));
	    dif.setForeground(Color.WHITE);
	    dif.setFont(new Font("Tahoma", Font.BOLD, 14));
	    dif.setPreferredSize(new Dimension(40,40));
	    inm.setBackground(new Color(102, 102, 153));
	    inm.setForeground(Color.WHITE);
	    inm.setFont(new Font("Tahoma", Font.BOLD, 14));
	    inm.setPreferredSize(new Dimension(40,40));
	    imp.setBackground(new Color(102, 102, 153));
	    imp.setForeground(Color.WHITE);
	    imp.setFont(new Font("Tahoma", Font.BOLD, 14));
	    imp.setPreferredSize(new Dimension(40,40));
	    deriv.setBackground(new Color(102, 102, 153));
	    deriv.setForeground(Color.WHITE);
	    deriv.setFont(new Font("Tahoma", Font.BOLD, 14));
	    deriv.setPreferredSize(new Dimension(40,40));
	    integr.setBackground(new Color(102, 102, 153));
	    integr.setForeground(Color.WHITE);
	    integr.setFont(new Font("Tahoma", Font.BOLD, 14));
	    integr.setPreferredSize(new Dimension(40,40));
	    reset.setBackground(new Color(102, 102, 153));
	    reset.setForeground(Color.WHITE);
	    reset.setFont(new Font("Tahoma", Font.BOLD, 14));
	    reset.setPreferredSize(new Dimension(40,40));
	    
		
		p1.add(sum);
		p1.add(dif);
		p1.add(inm);
		
		p2.add(imp);
		p2.add(deriv);
		p2.add(integr);
		p3.setLayout(new BoxLayout(p3,BoxLayout.X_AXIS));
		p3.add(p1);
		p3.add(p2);
		p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
		p4.add(rezultat);
		p4.add(rez);
		p4.add(reset);
	
		p5.setLayout(new BoxLayout(p5,BoxLayout.Y_AXIS));
		p5.add(p);
		p5.add(p3);
		p5.add(p4);
		p.setBackground( new Color(255, 204, 153) );
		p1.setBackground( new Color(255, 204, 153) );
		p2.setBackground( new Color(255, 204, 153) );
		p3.setBackground( new Color(255, 204, 153) );
		p4.setBackground( new Color(255, 204, 153) );
		p5.setBackground( new Color(255, 204, 153) );
		f.setContentPane(p5);
		f.getContentPane().setBackground( new Color(255, 204, 153) );
		f.setVisible(true);
		
	}
	public JButton getReset() {
		return reset;
	}
	public JButton getSum()
	{
		return sum;
	}
	public JButton getDif()
	{
		return dif;
	}
	public JButton getInm()
	{
		return inm;
	}
	public JButton getImp()
	{
		return imp;
	}
	public JButton getDeriv()
	{
		return deriv;
	}
	public JButton getIntegr()
	{
		return integr;
	}
	public String getfirstPol()
	{
		return firstPoly.getText();
	}
	public String getsecondPol()
	{
		return secondPoly.getText();
	}
	public void showError(String message)
	{
		JOptionPane.showMessageDialog(this,message);
	}
	void addCalcListener(ActionListener listen)
	
	{

		sum.addActionListener(listen);
		dif.addActionListener(listen);
		inm.addActionListener(listen);
		imp.addActionListener(listen);
		deriv.addActionListener(listen);
		integr.addActionListener(listen);
		reset.addActionListener(listen);
	}


public static void main(String[] args)
{
	View theView=new View();
	Controller theController=new Controller(theView);
	
	
	
}
	
}
