package edu.gatech.spamr.view;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.ImageIcon;


public class SplashScreen extends JPanel implements MouseMotionListener {
	
	private MainAppView parent;
    private BufferedImage background;
    private BufferedImage wand;
    private BufferedImage fire;
    private BufferedImage highlight;
    private BufferedImage rightFoot;
    private BufferedImage leftFoot;
    private Point cursorPoint;
    private float val = 0.0f;
    int count=0;
    private BufferedImage foot100;
    private BufferedImage foot75;
    private BufferedImage foot50;
    private BufferedImage foot25;
    private BufferedImage foot100u;
    private BufferedImage foot75u;
    private BufferedImage foot50u;
    private BufferedImage foot25u;
    private BufferedImage foot100d;
    private BufferedImage foot75d;
    private BufferedImage foot50d;
    private BufferedImage foot25d;

    private AudioClip audioClip;

    private int x = 300, y = 600;
    private int x2 = 200 , y2=300;
    private int oldcount=0;

    public SplashScreen() {
        setPreferredSize(new Dimension(1280, 753));
        setMinimumSize(new Dimension(1280, 800));
        setLayout(null);

        try {
            background = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/splashBg.png"));
            wand = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/wand.png"));
            //fire = ImageIO.read(new File("fire.png"));
            //highlight = ImageIO.read(new File("highlight.png"));
            //rightFoot = ImageIO.read(new File("rightFoot.png"));
            //leftFoot = ImageIO.read(new File("leftFoot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton button = new JButton("CLICK TO PLAY!");
        button.setIcon(new ImageIcon(SplashScreen.class.getResource("/edu/gatech/spamr/resources/potter/click.jpg")));
        button.setFont(new Font("Verdana", Font.BOLD, 25));
        button.setBounds(0, 686, 1280, 81);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.setUpConfigDialog();
			}
		});
        add(button);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Image image = toolkit.getImage("wand.png");
        Cursor c = toolkit.createCustomCursor(wand , new Point(0, 0), "img");
        setCursor(c);

        addMouseMotionListener(this);
        try {
			foot100 = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/100.png"));
			foot75 = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot75.png"));
			foot50 = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot50.png"));
			foot25 = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot25.png"));
			foot100u = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot100u.png"));
			foot75u = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot75u.png"));
			foot50u = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot50u.png"));
			foot25u = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot25u.png"));
			foot100d = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot100d.png"));
			foot75d = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot75d.png"));
			foot50d = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot50d.png"));
			foot25d = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/foot25d.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Timer t2 = new Timer(125, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				
//				System.out.println(count);
				repaint();
				
				//if (count%4!=0){
					//drawImage(foot100,x,y,10,10,null);
				}
				
			
        	
        });
        t2.start();
        Timer t = new Timer(50, new ActionListener() {

        	@Override
            public void actionPerformed(ActionEvent arg0) {
        		
                val++;
                RescaleOp rescale = new RescaleOp(1.0f,val-7.0f, null);
                background = rescale.filter(background,null);
                repaint();
                if (val >= 14.0f) {
                    val = 0.0f;
                }
                if (val-7.0f >= 0.0f) {
                    try {
                        background = ImageIO.read(new File("src/edu/gatech/spamr/resources/potter/splashBg.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        t.start();
        
        
        //music();
    }
/*
    public void music(){
        URL url = null;
        try {
            url = new File("hedwig.wav").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        AudioInputStream ais = null;
        try {
            ais = AudioSystem.getAudioInputStream(url);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        try {
            clip.open(ais);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
*/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0,
                    getWidth(), getHeight(), null);
        }
        /*if (fire != null) {
            g.drawImage(fire, (int) cursorPoint.getX(),
                    (int) cursorPoint.getY(), null);
        }*/
        /*g.setColor(Color.YELLOW);
        if (cursorPoint != null) {
            g.fillOval((int) cursorPoint.getX(), (int) cursorPoint.getY(), 8, 8);
        }*/
        /*if (highlight != null) {
            System.out.println("HELO");
            g.drawImage(highlight, (int) cursorPoint.getX() - 25,
                    (int) cursorPoint.getY() - 25, null);
        }*/
       // if (oldcount==count)
        //	return;
        if (count<130){
        	oldcount = count;
        if(count%7==1){
        	g.drawImage(foot100, x, y, 60, 25, null);
        	
        }
        else if (count%7==2){
        	g.drawImage(foot75, x, y, 60, 25, null);
        }
        else if (count%7==3){
        	g.drawImage(foot50, x, y, 60, 25, null);
        }
        else if(count%7==4){
        	g.drawImage(foot25, x, y, 60, 25, null);
        }
        else if(count%7==0){
        	x+=20;
        	//g.drawImage(foot100, x, y, 60, 25, null);
        }
        }
        else if (count<200){
        	oldcount=count;
        	if (count==200)
        		x+=20;
        	if(count%7==1){
            	g.drawImage(foot100u, x, y, 25, 60, null);
            	
            }
            else if (count%7==2){
            	g.drawImage(foot75u, x, y, 25, 60, null);
            }
            else if (count%7==3){
            	g.drawImage(foot50u, x, y, 25, 60, null);
            }
            else if(count%7==4){
            	g.drawImage(foot25u, x, y, 25, 60, null);
            }
            else if(count%7==0){
            	//x+=8;
            	y-=18;
            	//g.drawImage(foot100, x, y, 60, 25, null);
            }
        }
        if (count<32||count>100){
        	if(count==101)x+=10;
        if(count%7==1){
        	g.drawImage(foot100, x2, y2,  60,25, null);
        	
        }
        else if (count%7==2){
        	g.drawImage(foot75, x2, y2,  60,25, null);
        }
        else if (count%7==3){
        	g.drawImage(foot50, x2, y2,  60,25, null);
        }
        else if(count%7==4){
        	g.drawImage(foot25, x2, y2,  60,25, null);
        }
        else if(count%7==0){
        	x2+=20;
        }
        }
        else {
        	if(count==32)x2+=12;
        	if(count%7==1){
            	g.drawImage(foot100d, x2, y2,  25,60, null);
            	
            }
            else if (count%7==2){
            	g.drawImage(foot75d, x2, y2,  25,60, null);
            }
            else if (count%7==3){
            	g.drawImage(foot50d, x2, y2,  25,60, null);
            }
            else if(count%7==4){
            	g.drawImage(foot25d, x2, y2,  25,60, null);
            }
            else if(count%7==0){
            	y2+=18;
            }
        }
       // g.drawImage(leftFoot, x+25, y, 10, 10, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        cursorPoint = e.getPoint();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursorPoint = e.getPoint();
        repaint();
    }

    public void setParent(MainAppView main){
		 parent = main;
	}

		
	

}
