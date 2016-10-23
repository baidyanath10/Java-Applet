
import java.applet.Applet;
import java.awt.*;
import static java.awt.FlowLayout.TRAILING;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class merge extends Applet implements ActionListener
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
    protected int num;

    public void init(){
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
        
   public void start(){
           
   }

   public void paint(Graphics g){
			
            if(status==true){
               h=0;
			   
               copyArray(ary,cp_ary);
				                
	       merge_sort(0, num);
	       drawArray(g);
	   }

		
    }
    public void merge_sort(int low, int high){
	int mid;
	if(low<high){
		mid=(low+high)/2;
		merge_sort(low,mid);
	
		merge_sort(mid+1,high);
	
		merge(low,mid,high);
	}

    }

    public void merge(int l,int m,int r){
	int n1 = m - l + 1;
        int n2 = r - m;

	int L[] = new int [n1];
        int R[] = new int [n2];

	for (int i=0; i<n1; ++i)
            L[i] = cp_ary[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = cp_ary[m + 1+ j];
	
	int i = 0, j = 0;
	int k = l;

        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                cp_ary[k] = L[i];
                i++;
            }
            else
            {
                cp_ary[k] = R[j];
                j++;
            }
            k++;
        }
	
	while (i < n1){
            cp_ary[k] = L[i];
            i++;
            k++;
        }
	
	while (j < n2){
            cp_ary[k] = R[j];
            j++;
            k++;
        }
   }

   public void drawArray(Graphics g){
            
    	for(int i=0;i<cp_ary.length;i++){
            g.drawOval(80+(i*70), 70+h, 30,30);
            g.drawString(cp_ary[i]+"", 90+(i*70), 90+h);

		try{
		    Thread.sleep(500);
		}                   
		catch(Exception e){
		}
        }
    	h+=40;
    } 
      
    public void copyArray(int a[],int b[]){
	for(int i=0;i<a.length;i++){
		b[i]=a[i];
	}
   }		
         
      
   public void stop(){   
   }

   public void destroy(){	    
   }

 
   public void actionPerformed(ActionEvent e) {
              
        txt = data.getText();
        array = txt.split(",");
    
        ary = new int[array.length];
        cp_ary = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            ary[i] = Integer.parseInt(array[i]);
        }
		num=ary.length;
        status=true;
   
        repaint();
    }
}
/*
<applet code="insertion" width=1000 height=500>
</applet>
*/
