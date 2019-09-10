package com.mycompany.a3;
import java.io.InputStream; 
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
public class Sound {
	
	private Media m;
	
	public Sound(String fIn)
	{
		try
		{
			InputStream in = Display.getInstance().getResourceAsStream(getClass(), "/"+fIn);
			m  = MediaManager.createMedia(in, "audio/wav");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	public void play()
	{
		m.setTime(0);
		m.play();
	}

}
