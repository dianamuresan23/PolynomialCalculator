package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import polinoame.Monom;
import polinoame.Polinom;

public class Controller {
	private View theView;
	
	public Controller(View theView)
	{
		this.theView=theView;
		this.theView.addCalcListener(new CalcListener());
	}
	
	class CalcListener implements ActionListener
	{
	
		String p1,p2;
		Polinom pol1=new Polinom();
		Polinom pol2=new Polinom();
		Polinom result=new Polinom();
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()==theView.getSum())
			{   boolean b1,b2;
			    p1=theView.getfirstPol();
			    p2=theView.getsecondPol();
			    b1=pol1.validate(p1);
			    b2=pol2.validate(p2);
			    if (b1==false || b2==false)
			       theView.showError("Invalid Expression!");
			    else {
				pol1.splitPoly(p1);
				pol2.splitPoly(p2);
				pol1.verifyGrade();
				pol2.verifyGrade();
				pol1.sortare(pol1);
				pol2.sortare(pol2);
				result.add(pol1,pol2);
				theView.rez.setText(result.display());}
			}
			if (e.getSource()==theView.getDif())
			{
				boolean b1,b2;
				p1=theView.getfirstPol();
				p2=theView.getsecondPol();
				b1=pol1.validate(p1);
				b2=pol2.validate(p2);
				if (b1==false || b2==false)
					theView.showError("Invalid Expression!");
				else {
				pol1.splitPoly(p1);
				pol2.splitPoly(p2);
				pol1.verifyGrade();
				pol2.verifyGrade();
				pol1.sortare(pol1);
				pol2.sortare(pol2);
				result.dif(pol1,pol2);
				theView.rez.setText(result.display());}
			}
			if (e.getSource()==theView.getInm())
			{
				boolean b1,b2;
				p1=theView.getfirstPol();
				p2=theView.getsecondPol();
				b1=pol1.validate(p1);
				b2=pol2.validate(p2);
				if (b1==false || b2==false)
					theView.showError("Invalid Expression!");
				else {
				pol1.splitPoly(p1);
				pol2.splitPoly(p2);
				pol1.verifyGrade();
				pol2.verifyGrade();
				pol1.sortare(pol1);
				pol2.sortare(pol2);
				result.mul(pol1,pol2);
				result.verifyGrade();
				theView.rez.setText(result.display());}
				
			}
			if (e.getSource()==theView.getImp())
			{
				boolean b1,b2;
				p1=theView.getfirstPol();
				p2=theView.getsecondPol();
				b1=pol1.validate(p1);
				b2=pol2.validate(p2);
				if (pol2.getMonoame().isEmpty())
					theView.showError("Invalid Expression!");
				else if (b1==false || b2==false)
					theView.showError("Invalid Expression!");
				else {
				pol1.splitPoly(p1);
				pol2.splitPoly(p2);
				pol1.verifyGrade();
				pol2.verifyGrade();
				pol1.sortare(pol1);
				pol2.sortare(pol2);
				result.imp(pol1, pol2);
				if (result.getMonoame().isEmpty())
					theView.showError("Invalid Expression!");
				theView.rez.setText(result.display());}
				
				
			}
			if (e.getSource()==theView.getDeriv())
			{
				boolean b1;
				p1=theView.getfirstPol();
				b1=pol1.validate(p1);
				if (b1==false)
					theView.showError("Invalid Expression!");
				else {
				pol1.splitPoly(p1);
				pol1.verifyGrade();
				pol1.sortare(pol1);
				result.derivare(pol1);
				result.verifyGrade();
				theView.rez.setText(result.display());}
				
			}
			if (e.getSource()==theView.getIntegr())
			{
				String res="";
				boolean b1;
				p1=theView.getfirstPol();
				b1=pol1.validate(p1);
				if (b1==false)
					theView.showError("Invalid Expression!");
				else {
				pol1.splitPoly(p1);
				pol1.verifyGrade();
				pol1.sortare(pol1);
				res=pol1.integrare(pol1);
				theView.rez.setText(res);}
			}
			if (e.getSource()==theView.getReset())
			{
				theView.rez.setText("");
				theView.firstPoly.setText("");
				theView.secondPoly.setText("");
			}
	}

}
}
