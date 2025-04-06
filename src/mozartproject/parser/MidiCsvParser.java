package mozartproject.parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mozartproject.data.*;

public class MidiCsvParser {
	
	
	
	/**
	 * Reads the given file and converts the information into the file into a list of MidiEventData
	 * @param fr
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static List<MidiEventData> parseCsv (String fr) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fr));
		List<MidiEventData> midiEvents = new ArrayList<>();
		
		String line;
        while ((line = br.readLine()) != null) {
        	System.out.println("In loop");
            // Split the line into parts (startEndTick, Note on off, channel, note, velocity , instrument)
            String[] parts = line.split(",");
            
            // Trim space between each part
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }
            
            int startEndTick = Integer.parseInt(parts[0]);
            int velocity = Integer.parseInt(parts[4]);
            int note = Integer.parseInt(parts[3]);
            int channel = Integer.parseInt(parts[2]);
            int instrument = Integer.parseInt(parts[5]);
            int noteOnOff = 0;
            
            if(parts[1].equals("Note_on_c")) {
            	noteOnOff = 1;
            }

            // Create a MidiEventData object based off of the current line
            MidiEventData data = new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff);
            
            //adds the object to the list
            midiEvents.add(data);
        }
        
        br.close();//closes file
		
		
		return midiEvents;
		
		
	}
}
