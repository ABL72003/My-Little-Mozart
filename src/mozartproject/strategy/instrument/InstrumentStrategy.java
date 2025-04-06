/**
 * 
 */
package mozartproject.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * Strategy interface for applying an instrument change to a MIDI track.
 * Different implementations of this interface represent different instruments
 * by modifying the track with a specific MIDI program change on the given channel.
 */
public interface InstrumentStrategy {
	
	void applyInstrument(Track track, int channel) throws Exception;
	
	//Utility method to add a program change to track
	static void addChange(Track track, int channel, int instrument) throws InvalidMidiDataException {
		ShortMessage newChange = new ShortMessage();
		newChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrument,0);
		track.add(new MidiEvent(newChange, 0));
	}
	
	
	
}
