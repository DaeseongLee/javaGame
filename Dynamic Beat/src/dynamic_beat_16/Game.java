package dynamic_beat_16;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import dynamic_beat_14.Beat;

public class Game extends Thread {
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image blueFlareImage;	
	private Image judgeImage;	
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	
	
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private String score = "0";
	int score1=0;
	
	
	ArrayList<Note>noteList = new ArrayList<>();
	
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 0, null);
		g.drawImage(noteRouteDImage, 332, 0, null);
		g.drawImage(noteRouteFImage, 436, 0, null);
		g.drawImage(noteRouteSpace1Image, 540, 0, null);
		g.drawImage(noteRouteSpace2Image, 640, 0, null);
		g.drawImage(noteRouteJImage, 744, 0, null);
		g.drawImage(noteRouteKImage, 848, 0, null);
		g.drawImage(noteRouteLImage, 952, 0, null);
		g.drawImage(noteRouteLineImage, 224, 0, null);
		g.drawImage(noteRouteLineImage, 328, 0, null);
		g.drawImage(noteRouteLineImage, 432, 0, null);
		g.drawImage(noteRouteLineImage, 536, 0, null);
		g.drawImage(noteRouteLineImage, 740, 0, null);
		g.drawImage(noteRouteLineImage, 844, 0, null);
		g.drawImage(noteRouteLineImage, 948, 0, null);
		g.drawImage(noteRouteLineImage, 1052, 0, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementImage, 0, 580, null);
		for(int i =0; i < noteList.size(); i++ ) {
			Note note = noteList.get(i);
			if(note.getY()>620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}else {
				note.screenDraw(g);
			}
			note.screenDraw(g);
		}
		
		
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial",Font.PLAIN,26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270,	609);
		g.drawString("D", 374,	609);
		g.drawString("F", 478,	609);
		g.drawString("Space Bar", 580,	609);
		g.drawString("J", 784,	609);
		g.drawString("K", 889,	609);
		g.drawString("L", 993,	609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant",Font.BOLD,30));
		g.drawString(score, 565, 702);
		g.drawString(titleName, 20, 702);
		g.drawImage(blueFlareImage, 220, 200, null);
		g.drawImage(judgeImage, 590, 350, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
	}
	
	public void pressS()	{
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	}
	
	public void releaseS()	{
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		notBluflare();
	}
	
	
	
	public void pressD()	{
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	}
	public void releaseD()	{
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		notBluflare();
	}
	
	
	public void pressF()	{
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	}
	public void releaseF()	{
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		notBluflare();
	}
	
	
	public void pressSpace()	{
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	}
	public void releaseSpace()	{
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		notBluflare();
	}
	
	
	public void pressJ()	{
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	}
	public void releaseJ()	{
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		notBluflare();
	}
	
	
	public void pressK()	{
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	}
	public void releaseK()	{
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		notBluflare();
	}
	
	
	public void pressL()	{
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	}
	public void releaseL()	{
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		notBluflare();
	}
	
	
	@Override
	public void run() {
	dropNotes(this.titleName);
	}
	public void close() {
		dropNotes("exit");
		gameMusic.close();
		this.interrupt();
	}
	
	//객체지향 언어
	
	//c언어와 코볼은 object파일을 모아서 exe 실행파일을 시키는것.  a.obj, b.obj (build 과정) => a.exe
	// 자바는 bytecode가 있어서 따로 따로 실행 시킬 수 있음. 
		
	public void dropNotes(String titleName)  {
		Beat[] beats = new Beat[1000];
		int startTime = 4460 -Main.REACH_TIME*1000;
		int gap = 125;
		String[] str = {"S","D","F","Space","J","K","L"};
		int num1 = 0;
		
		if(titleName.equals("exit")) {
			return;}
		
		
		if(titleName.equals("너무나 눈부신 - breeze") && difficulty.equals("Easy")) {
			
			
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*5) , str[num1]);
				
			}
			
		}
		if(titleName.equals("너무나 눈부신 - breeze") && difficulty.equals("Hard")) {
			
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*2) , str[num1]);
				
			}
		}
		if(titleName.equals("나를 사랑하지 마세요 - breeze") && difficulty.equals("Easy")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*6) , str[num1]);
				
			}
		}
		if(titleName.equals("나를 사랑하지 마세요 - breeze") && difficulty.equals("Hard")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*2) , str[num1]);
				
			}
		}
		if(titleName.equals("나에게로 떠나는 여행-buzz") && difficulty.equals("Easy")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*5) , str[num1]);
				
			}
		}
		if(titleName.equals("나에게로 떠나는 여행-buzz") && difficulty.equals("Hard")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*2) , str[num1]);
				
			}
		}
		if(titleName.equals("내 사랑울보-sg워너비") && difficulty.equals("Easy")) {
			
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*6) , str[num1]);
				
			}
		}
		if(titleName.equals("내 사랑울보-sg워너비") && difficulty.equals("Hard")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*3) , str[num1]);
				
			}
		}
		if(titleName.equals("Lazenca-next") && difficulty.equals("Easy")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*7) , str[num1]);
				
			}
		}
		if(titleName.equals("Lazenca-next") && difficulty.equals("Hard")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*2) , str[num1]);
				
			}
		}
		if(titleName.equals("Alone Again-breeze") && difficulty.equals("Easy")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*5) , str[num1]);
				
			}
		}
		if(titleName.equals("Alone Again-breeze") && difficulty.equals("Hard")) {
			for(int i =0; i<1000; i++) {
				num1 = (int)(Math.random()*7);
				beats[i] = new Beat(startTime + gap *((i+1)*2) , str[num1]);
				
			}
		}
		int i = 0;
		gameMusic.start();

		while(i<beats.length &&!isInterrupted()) {
			boolean dropped =false;
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void judge(String input) {
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	public void judgeEvent(String judge) {
		
		
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		
		
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();

		}else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();

		}else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
			score1 += 50;
			score = String.valueOf(score1);
		}else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
			score1 += 80;
			score = String.valueOf(score1);
		}else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
			score1 += 100;
			score = String.valueOf(score1);
		}else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();

		}
		
	}
	public void notBluflare() {
		blueFlareImage = null;
		judgeImage = null;
	}
}
