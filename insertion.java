import java.applet.Applet;
import java.awt.*;
import static java.awt.FlowLayout.TRAILING;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertion extends Applet implements ActionListener
{
    protected TextField data = new TextField(30);
    protected Button sort = new Button("SORT");
    protected Label lbl = new Label();
	protected Label lbl1,lbl2;

    protected String txt=null;
    protected String array[];
    protected int ary[];
      protected int cp_ary[];
    protected boolean status = false;
    protected int h=0,key,j;
    
        public void init()
        {
			lbl1=new Label("ENTER THE NO. OF ELEMENT TO SORT:- ");
			this.add(lbl1);
            setBackground(Color.cyan);
            this.add(data);
            sort.addActionListener(this);
            this.add(sort);
            lbl.setBounds(20,20, 130,100);
            add(lbl);
			
            array=null;
        }
        
        public void start()
        {
           
        }
	public void paint(Graphics g)
        {
			
            if(status==true)
            {
               h=0;
               copyArray(ary,cp_ary);
				drawArray(g);
          
		  
		  for(int i=1;i<cp_ary.length;i++)
			{
			key=cp_ary[i];
			j=i-1;
				while(j>=0 && key<cp_ary[j])
				{
					cp_ary[j+1]=cp_ary[j];
					j--;
				}		
				cp_ary[j+1]=key;
				drawArray(g);
			}
		  
          
            }
            
           
	}
        public void drawArray(Graphics g)
        {
            
            for(int i=0;i<cp_ary.length;i++)
                {
                    g.drawOval(80+(i*70), 70+h, 30,30);
                    g.drawString(cp_ary[i]+"", 90+(i*70), 90+h);
			try{
                            Thread.sleep(500);
                        }                   
                        catch(Exception e)
                        {
                            
                        }
                }
            h+=40;
        }       
        public void copyArray(int a[],int b[])
        {
            for(int i=0;i<a.length;i++)
            {
                b[i]=a[i];
            }
        }
         
      
        public void stop()
        {
            
        }
        public void destroy()
        {
            
        }


    public void actionPerformed(ActionEvent e) 
	{
      
        
        txt = data.getText();
        array = txt.split(",");
    
        ary = new int[array.length];
        cp_ary = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            ary[i] = Integer.parseInt(array[i]);
        }
        status=true;
   
        repaint();
    }
}
/*
<applet code="insertion" width=1000 height=500>
</applet>
*/
