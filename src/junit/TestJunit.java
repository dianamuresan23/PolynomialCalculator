package junit;

import polinoame.Polinom;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJunit {
      String pol1="3x^2-3x+12";
      String pol2="-4x^3-x^2+4x";
      Polinom p1=new Polinom();
      Polinom p2=new Polinom();
      Polinom rez=new Polinom();
      
    @Test  
	public void testSum()
	{
		p1.splitPoly(pol1);
		p2.splitPoly(pol2);
		rez.add(p1, p2);
		assertEquals("-4x^3+2x^2+x+12",rez.display());
		
	}
    
    @Test
    public void testDif()
    {
    	p1.splitPoly(pol1);
    	p2.splitPoly(pol2);
    	rez.dif(p1, p2);
    	assertEquals("4x^3+4x^2-7x+12",rez.display());
    	
    }
    
    @Test
    public void testMul()
    {
    	p1.splitPoly(pol1);
    	p2.splitPoly(pol2);
    	rez.mul(p1, p2);
    	rez.verifyGrade();
    	assertEquals("-12x^5+9x^4-33x^3-24x^2+48x",rez.display());
    }
    
    @Test 
    public void testDeriv()
    {
    	p1.splitPoly(pol1);
    	rez.derivare(p1);
    	assertEquals("6x^1-3",rez.display());
    }
    
    @Test 
    public void testIntegr()
    {
    	p1.splitPoly(pol1);
    	String rez=p1.integrare(p1);
    	assertEquals("1x^3-3/2x^2+12x",rez);
    		
    }
    @Test
    public void testImp()
    {
    	String s1="x^3+x^2";
    	String s2="x^2";
    	p1.splitPoly(s1);
    	p2.splitPoly(s2);
    	rez.imp(p1, p2);
    	assertEquals("1x^1+1",rez.display());
    	
    }

	
}
