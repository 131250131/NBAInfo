package test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * 
 * ��������
 *
 */
public class AudioPlayer  implements Runnable{

	private AudioFormat format;
	private byte[] samples;
	private boolean stop,check=true;
	private boolean isSleep=false;
	String s="";
	int num=0;
	Thread t1;
	public AudioPlayer(String filename) {
		s=filename;
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filename));
			format = stream.getFormat();
			samples = getSamples(stream);
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void playnoloop(){
		t1=new Thread(this);
		t1.start();
	}
	/**
	 * ѭ������
	 * @param string
	 * @param i
	 */

	public void playloop(){
	
		t1=new Thread(new LoopPlay());
		t1.start();
	}

	
	
	public byte[] getSamples() {
		return samples;
	}

	private byte[] getSamples(AudioInputStream audioStream) {
		int length = (int) (audioStream.getFrameLength() * format
				.getFrameSize());
		byte[] samples = new byte[length];
		DataInputStream is = new DataInputStream(audioStream);
		try {
			is.readFully(samples);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return samples;
	}

	private void audioPlay(InputStream source) {
		stop=false;
		int bufferSize = format.getFrameSize()
				* Math.round(format.getSampleRate() / 10);
		byte[] buffer = new byte[bufferSize];
		SourceDataLine line;
		try {
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(format, bufferSize);
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
			return;
		}
		line.start();
		try {
			int numBytesRead = 0;
			while (numBytesRead != -1 && !stop) {
				numBytesRead = source.read(buffer, 0, buffer.length);
				if (numBytesRead != -1) {
					line.write(buffer, 0, numBytesRead);
				}
				//�¼ӵ���ͣ
//				if(new GetSetting().Music==0&&isSleep==false&&num==1){
//					isSleep=true;
////					System.out.println("sleep");
//					check=true;
//					Thread t=new Thread(new Continue());
//					t.start();
//					synchronized(t1) {
//						try {
//							t1.wait(30000000);
//						} catch (InterruptedException e) {
//							// TODO �Զ����ɵ� catch ��
//							e.printStackTrace();
//						}
//					}
//				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		line.drain();
		line.close();
	}
	
	public void stop(){
		stop=true;
	}

	@Override
	public void run() {
		InputStream stream = new ByteArrayInputStream(this.getSamples());
	
		this.audioPlay(stream);

	}
//	class Continue implements Runnable{
//
//		@Override
//		public void run() {
//			// TODO �Զ����ɵķ������
//			while(check){
////				System.out.println("check");
//					if(num==1&&isSleep==true&&new GetSetting().Music==1){
//						synchronized(t1){
//							t1.notify();
//						}
//						isSleep=false;
//						check=false;
//					}
//			}
//			
//		}
//		
//	}
	class LoopPlay implements Runnable{

		@Override
		public void run() {
			while(!stop){
			InputStream stream = new ByteArrayInputStream(getSamples());
			audioPlay(stream);
					
			}
		}
		
		
	}
	
	public void Continue(){
		
	}
	public static void main(String[] args) {
		AudioPlayer t=new AudioPlayer("src/music/skill/ys.wav");
		t.playloop();
	}
}