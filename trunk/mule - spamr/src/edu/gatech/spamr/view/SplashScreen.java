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

    private AudioClip audioClip;

    private int x = 250, y = 750;

    public SplashScreen() {
        setPreferredSize(new Dimension(1280, 800));
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
        button.setFont(new Font("Verdana", Font.BOLD, 25));
        button.setBounds(0, 700, 1280, 75);
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

   /* public void music(){
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
        g.drawImage(rightFoot, x, y, 10, 10, null);
        g.drawImage(leftFoot, x+25, y, 10, 10, null);
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