package polinoame;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
	private ArrayList<Monom> monoame;	
	public Polinom()
	{
		super();
		monoame=new ArrayList<Monom>();
	}
	public void adauga(Monom m)
	{
		this.monoame.add(m);
	}
	public int gradPolinom(Polinom p)
	{
		int gradmax=0;
		for (Monom m:p.getMonoame())
			if (m.getPower()>gradmax)
				gradmax=m.getPower();
		return gradmax;
	}
	public ArrayList<Monom> getMonoame()
	{
		return monoame;
	}
	public boolean validate(String polinom)
	{
		boolean valid=false;
		String format="[\\dx\\^\\d|x\\^\\d|\\d|x|\\-\\dx\\^\\d|\\-x\\^\\d|\\-\\d|\\-x]";
		Pattern p=Pattern.compile(format);
		Matcher m=p.matcher(polinom);
		valid=m.find();
		return valid;			
	}
	public Polinom splitPoly(String polinom)
	{
		String[] monoame1 = null;
		ArrayList<Monom> mon=new ArrayList<Monom>();
	    monoame1=polinom.split("(?=-)|(?=\\+)");
			for (String s:monoame1)
			{
				Monom m=new Monom();
				mon.add(m.splitMonom(s));
			}
			this.monoame=mon;
			return this;
	}
	public void sortare(Polinom p)
	{
		Collections.sort(p.monoame);
	}
	public void verifyGrade()
	{
		for (int i = 0; i < this.monoame.size()-1; i++) 
			for (int j = i + 1; j < this.monoame.size(); j++) 
				if (this.monoame.get(i).getPower() == this.monoame.get(j).getPower()) {
					this.monoame.get(i).setCoef(this.monoame.get(j).getCoef() + this.monoame.get(i).getCoef());
					this.monoame.remove(j);}
	}
	public Polinom add(Polinom p1,Polinom p2)
	{
		Polinom rr=new Polinom();
		for(Monom m1: p1.getMonoame())
		{   
			boolean match=false;
			for (Monom m2:p2.getMonoame())
				if (m1.getPower()==m2.getPower())
				{
					match=true;
					if (m1.getCoef()+m2.getCoef()!=0) {
					Monom rez=new Monom(m1.getPower(),m1.getCoef()+m2.getCoef());
					rr.monoame.add(rez);}
				}
			if (match==false)  // se adauga monoamele din primul polinom care nu au corespondent
				rr.monoame.add(m1);
		}
		for (Monom m2:p2.getMonoame())
		{
			boolean match1=false;
			for (Monom m1:p1.getMonoame())
				if(m2.getPower()==m1.getPower())
					match1=true;
			if (match1==false)  // se adauga monoamele din al doilea polinom
				rr.monoame.add(m2);
		}
		rr.sortare(rr);	
		this.monoame=rr.monoame;
		return this;
	}
	public Polinom dif(Polinom p1,Polinom p2)
	{
	   p1.sortare(p1);
	   p2.sortare(p2);
		Polinom rr=new Polinom();
		for(Monom m1: p1.getMonoame())
		{   
			boolean match=false;
			for (Monom m2:p2.getMonoame())
				if (m1.getPower()==m2.getPower())
				{
					match=true;
					if (m1.getCoef()-m2.getCoef()!=0) { //daca coef este 0 termenul nu se mai adauga
					Monom rez=new Monom(m1.getPower(),m1.getCoef()-m2.getCoef());
					rr.monoame.add(rez);}
				}
			if (match==false)
				rr.monoame.add(m1);	
		}
		for (Monom m2:p2.getMonoame())
		{
			boolean match1=false;
			for (Monom m1:p1.getMonoame())
				if(m2.getPower()==m1.getPower())
					match1=true;
			if (match1==false)
				{m2.setCoef(-m2.getCoef());
				rr.monoame.add(m2);}
		}
		rr.sortare(rr);
		this.monoame=rr.monoame;
		return this;
	}
	public Polinom mul(Polinom p1,Polinom p2)
	{
		Polinom rezult=new Polinom();
		for(Monom m1: p1.getMonoame())  
			for (Monom m2:p2.getMonoame())
			{
					Monom rez=new Monom(m1.getPower()+m2.getPower(),m1.getCoef()*m2.getCoef());
					rezult.monoame.add(rez);
			}
		rezult.sortare(rezult);
		rezult.verifyGrade();
		this.monoame=rezult.monoame;
		return this;
	}
	public String display()
	{
		int i;
		String rezultat="";
		if (this.monoame.isEmpty())
			return rezultat="0";
		rezultat=this.monoame.get(0).toString();
		for (i=1;i<this.monoame.size();i++)
	    if(this.monoame.get(i).getPower()==1)
			if (this.monoame.get(i).getCoef()>0)
				if (this.monoame.get(i).getCoef()==1)
					rezultat+="+x";
				else 
					rezultat+="+"+this.monoame.get(i).getCoef()+"x";
			else if (this.monoame.get(i).getCoef()==-1)
				rezultat+="-x";
			else rezultat+=this.monoame.get(i).getCoef()+"x";
	    else if(this.monoame.get(i).getPower()==0)
	    	if (this.monoame.get(i).getCoef()>0)
	    		rezultat+="+"+this.monoame.get(i).getCoef();
	    	else
	    		rezultat+=this.monoame.get(i).getCoef();
	    else if (this.monoame.get(i).getCoef()>0)
			rezultat+="+"+this.monoame.get(i).toString();
	    else if (this.monoame.get(i).getCoef()==-1 && this.monoame.get(i).getPower()==1)
	    	rezultat+="-x";
	    else
	    	rezultat+=this.monoame.get(i).toString();
		return rezultat;
	}
	public Polinom derivare(Polinom p)
	{
		Polinom rez=new Polinom();
		for (Monom m:p.getMonoame())
		{
			if (m.getPower()==0)
				continue;
			else if(m.getPower()==1)
				m.setPower(0);
			else 
			{
				m.setCoef(m.getCoef()*m.getPower());
				m.setPower(m.getPower()-1);
			}
			rez.monoame.add(m);
		}
		rez.sortare(rez);
		this.monoame=rez.monoame;
		return this;
	}
	public String integrare(Polinom p)
	{
		String  rez="";
		for (Monom m:p.monoame)
		{
			if (m.getPower()==0)
			{
				String s=Integer.toString(m.getCoef());
				if (m.getCoef()>0 && m!=p.monoame.get(0))
				   rez+="+"+s+"x";
				else
					rez+=s+"x";
			}
			else
			{
				String s1="";
				String s=Integer.toString(m.getPower()+1);
		      	if (m.getCoef()%(m.getPower()+1)==0)   //daca numaratorul se imparte la numitor
					{s1=Integer.toString(m.getCoef()/(m.getPower()+1));
					if (m.getCoef()>0 && m!=p.monoame.get(0))
						rez+="+"+s1+"x^"+s;
						else
							rez+=s1+"x^"+s;
					}  
			    else		
			    { s1=Integer.toString(m.getCoef());
			      if (m.getCoef()>0 && m!=p.monoame.get(0))
					rez+="+"+s1+"/"+s+"x^"+s;
				  else
						rez+=s1+"/"+s+"x^"+s;
			    }
			}
		}
		return rez;
	}
	public Polinom imp(Polinom p1,Polinom p2)
	{
		Polinom cat=new Polinom();
		if (p2.monoame.get(0).getCoef()==0)  //impartire cu 0
			return new Polinom();
		while(p1.gradPolinom(p1)>=p2.gradPolinom(p2))
		{
			int power=p1.monoame.get(0).getPower()-p2.monoame.get(0).getPower();
			int coef=p1.monoame.get(0).getCoef()/p2.monoame.get(0).getCoef();
			Monom m=new Monom(power,coef);
			Polinom rez=new Polinom();
			rez.monoame.add(m);
			cat.monoame.add(m);
			Polinom inm=new Polinom();
			inm.mul(rez,p2);
			p1.dif(p1,inm);
			p1.sortare(p1);
		}
		this.monoame=cat.monoame;
		return this;
	}
	@Override
	public String toString() {
		return "Polinom [monoame=" + monoame + "]";
	}
	
	
	

}
