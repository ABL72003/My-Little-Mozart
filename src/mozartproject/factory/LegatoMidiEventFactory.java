package mozartproject.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class LegatoMidiEventFactory implements MidiEventFactory {
	
	/**
	 * 
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage noteOn = new ShortMessage();
		noteOn.setMessage(ShortMessage.NOTE_ON , channel, note, velocity);
		
		tick += 80;
		
		MidiEvent newEvent = new MidiEvent(noteOn, tick);
		return newEvent;
	}

	/**
	 * 
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage noteOff = new ShortMessage();
		noteOff.setMessage(ShortMessage.NOTE_OFF , channel, note, 0);
		
		tick += 80;
		
		MidiEvent newEvent = new MidiEvent(noteOff, tick);
		return newEvent;
	}

}
