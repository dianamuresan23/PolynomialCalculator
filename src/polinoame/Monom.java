package polinoame;

import java.util.ArrayList;

public class Monom implements Comparable<Monom>{
	private int power;
	private int coef;
	public Monom()
	{	
	}
	public Monom(int power,int coef)
	{
		super();
		this.power=power;
		this.coef=coef;
	}
	public int getCoef()
	{
		return this.coef;
	}
	public void setCoef(int coef)
	{
		this.coef=coef;
	}
	public int getPower()
	{
		return this.power;
	}
	public void setPower(int p)
	{
		this.power=p;
	}	
	public Monom splitMonom(String monom)
	{
		if (monom.contains("^")&& monom.contains("x"))   //putere >1
		{
			String[] el=monom.split("\\^");
			int i=Integer.parseInt(el[1]);
			this.power=i;
		}
		else if(monom.contains("x"))     //puterea 1
			this.power=1;
		else                            //termen liber
			this.power=0;
		if (monom.charAt(0)==45 && monom.charAt(1)==120)   //-x
			{ 
			   this.coef=-1;
			   return this;
			}
		if  (monom.charAt(0)==120)   //x
		{
			this.coef=1;
		}
		else if (monom.charAt(0)!=120 &&monom.contains("x"))   // de forma "coef*x"
		{
			int i = 0;
		    String[] e=monom.split("x");
		    if (monom.charAt(0)==43 && monom.charAt(1)==120)   //+x
				this.coef=1;
		    else if (monom.charAt(0)==45 || monom.charAt(0)==43)  //+-
	    	  {    i=Integer.parseInt(e[0]);
	    	       this.coef=i;
	    	  }
		    else 
		    	this.coef=Integer.parseInt(e[0]);
		}
		else
		{
			int	i=Integer.parseInt(monom);
			this.coef=i;
		}	
		return this;
	}
	@Override
	public String toString() {
		return coef+ "x^" + power;
	}
	public int compareTo(Monom m) {
		return m.getPower()-this.power;
		
	}

	
		
	


}


