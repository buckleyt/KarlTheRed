
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
	import javax.swing.JFrame;

	import sun.audio.AudioPlayer;
	import sun.audio.AudioStream;
	import sun.audio.ContinuousAudioDataStream;
	import javafx.scene.media.Media;
	import javafx.scene.media.MediaPlayer;

	public class MusicIntegration {

	    public static void main(String[] args) {
//	        JFrame frame = new JFrame();
//	        frame.setSize(200, 200);
//	        frame.setLocationRelativeTo(null);
//	        JButton button = new JButton("Click me");
//	        frame.add(button);
////	        button.addActionListener(new AL());
//	        frame.setVisible(true);
//	        song("Karl the Red Theme copy.wav");
	    	playSound();
	    }

	    public static class AL implements ActionListener {
	        public final void actionPerformed(ActionEvent e) {
	            song("Karl the Red Theme copy.wav");
	        }
	    }

	    public static void music() {
	        AudioPlayer A = AudioPlayer.player;
	        AudioStream B;
	        ContinuousAudioDataStream loop = null;
	        try {
	            InputStream test = new FileInputStream(
	                    "/Users/CallumHafnerSchnee/Desktop/SoundBoard/Walking/Short Horse Gallop.wav");
	            B = new AudioStream(test);
	            AudioPlayer.player.start(B);
	        } catch (FileNotFoundException e) {
	            System.out.print(e.toString());
	        } catch (IOException error) {
	            System.out.print(error.toString());
	        }
	        A.start(loop);
	    }

	    public static void song(String string) {
	        AudioPlayer A = AudioPlayer.player;
	        AudioStream B;
	        //ContinuousAudioDataStream loop = null;
	        try {
	            InputStream test = new FileInputStream(string);
	            B = new AudioStream(test);
	            AudioPlayer.player.start(B);
	        } catch (FileNotFoundException e) {
	            System.out.print(e.toString());
	        } catch (IOException error) {
	            System.out.print(error.toString());
	        }
	        //A.start(loop);
	    }

	    public static void sound(String string) {
	        AudioPlayer A = AudioPlayer.player;
	        AudioStream B;
	        ContinuousAudioDataStream loop = null;
	        try {
	            InputStream test = new FileInputStream(string);
	            B = new AudioStream(test);
	            AudioPlayer.player.start(B);
	        } catch (FileNotFoundException e) {
	            System.out.print(e.toString());
	        } catch (IOException error) {
	            System.out.print(error.toString());
	        }
	        A.start(loop);
	    }

	    public static void playSound() {
	    	File file = new File("Karl the Red Theme copy.wav");
	        if(file.exists()) {
	            try {
	                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

	                AudioFormat audioFormat = audioInputStream.getFormat();

	                DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

	                SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(info);
	                sourceLine.open(audioFormat);

	                sourceLine.start();

	                int nBytesRead = 0;
	                byte[] abData = new byte[128000];
	                while (nBytesRead != -1) {
	                    try {
	                        nBytesRead = audioInputStream.read(abData, 0, abData.length);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                    if (nBytesRead >= 0) {
	                        sourceLine.write(abData, 0, nBytesRead);
	                    }
	                }

	                sourceLine.drain();
	                sourceLine.close();

	            } catch (UnsupportedAudioFileException | IOException e) {
	                e.printStackTrace();
	            } catch (LineUnavailableException e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.err.println("The selected file doesn't exist!");
	        }
	    }
	    
	    public static void soundGroup(String string) {
	        AudioPlayer A = AudioPlayer.player;
	        AudioStream B;
	        ContinuousAudioDataStream loop = null;
	        try {
	            InputStream test = new FileInputStream(string);
	            B = new AudioStream(test);
	            AudioPlayer.player.start(B);
	        } catch (FileNotFoundException e) {
	            System.out.print(e.toString());
	        } catch (IOException error) {
	            System.out.print(error.toString());
	        }
	        A.start(loop);
	    }

	}

