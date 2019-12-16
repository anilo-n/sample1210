package sample1210;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.GridLayout;
import java.awt.Container;

public class ColorBoxes extends Frame implements ActionListener{

    private Button startButton;
    private Button big;
    private Button middle;
    private Button small;
    private int sizeflag=0;

  public static void main(String args[]) {
    ColorBoxes cb = new ColorBoxes("Color Boxes Sample");
    cb.setLocation(100, 100);
    cb.setSize(500,400);
    cb.setBackground(Color.LIGHT_GRAY);
    cb.setVisible(true);
  }

  ColorBoxes(String title) {
		this.setTitle(title);
		this.addWindowListener(new WindowAdapter() {
        		public void windowClosing(WindowEvent e) {
         		 System.exit(0);
       		 }
      		});
		this.startButton = new Button("start");
		this.big=new Button("大");
		this.middle=new Button("中");
		this.small=new Button("小");
		this.startButton.addActionListener(this);
		this.big.addActionListener(this);
		this.middle.addActionListener(this);
		this.small.addActionListener(this);

		this.setLayout(new BorderLayout());
		Container container1=new Container();
		container1.setLayout(new GridLayout(1,4));
		container1.add(startButton);
		container1.add(big);
		container1.add(middle);
		container1.add(small);
		this.add("North",container1);

		     this.addComponentListener(new ComponentAdapter(){
	public void componentResized(ComponentEvent e){
	    ColorBoxes.this.repaint();
	}
	});
  }				  

    public void actionPerformed(ActionEvent evt){
	Button button=(Button)evt.getSource();
	if(button==startButton){
	    this.repaint();
    }
	else if(button==middle) sizeflag=0;
	else if(button==big) sizeflag=1;
	else if(button==small) sizeflag=2;
    }

  public void paint(Graphics g) {
     int rval;
     int gval;
     int bval;
     int sizeH=getSize().height;
     int sizeW=getSize().width;

     if(sizeflag==0){
     for (int j = 30+30+30; j < (sizeH-50); j += 30) 
	 for (int i = 8+5+30; i < (sizeW-50); i+= 30) {
        rval = (int)Math.floor(Math.random() * 256);
        gval = (int)Math.floor(Math.random() * 256);
        bval = (int)Math.floor(Math.random() * 256);
        
        g.setColor(new Color(rval,gval,bval));
        g.fillRect(i,j,25,25);
        g.setColor(Color.black);
        g.drawRect(i-1,j-1,25,25);
      }
     }
     else if(sizeflag==1){
     for (int j = 30+30+25; j < (sizeH-85); j += 80) 
	 for (int i = 8+5+25; i < (sizeW-85); i+= 80) {
        rval = (int)Math.floor(Math.random() * 256);
        gval = (int)Math.floor(Math.random() * 256);
        bval = (int)Math.floor(Math.random() * 256);
        
        g.setColor(new Color(rval,gval,bval));
        g.fillRect(i,j,75,75);
        g.setColor(Color.black);
        g.drawRect(i-1,j-1,75,75);
      }
     }
  else{
     for (int j = 30+30+15; j < (sizeH-20); j += 15) 
	 for (int i = 8+5+15; i < (sizeW-20); i+= 15) {
        rval = (int)Math.floor(Math.random() * 256);
        gval = (int)Math.floor(Math.random() * 256);
        bval = (int)Math.floor(Math.random() * 256);
        
        g.setColor(new Color(rval,gval,bval));
        g.fillRect(i,j,10,10);
        g.setColor(Color.black);
        g.drawRect(i-1,j-1,10,10);
      }
     }
  }

}	 


    


