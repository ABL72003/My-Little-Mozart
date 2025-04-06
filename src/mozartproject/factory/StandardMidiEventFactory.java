package mozartproject.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StandardMidiEventFactory implements MidiEventFactory {
	
	/**
	 * Concrete Implementation of method set in MidiEventFactory interface.
	 * Creates a Standard note-on MIDI event.
	 * This method takes in four prarameters in tick, note, velocity, and channel.
	 * It returns a event of node-on and throws an exception if it cannot be constructed
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage noteOn = new ShortMessage();
		noteOn.setMessage(ShortMessage.NOTE_ON , channel, note, velocity);
		
		MidiEvent newEvent = new MidiEvent(noteOn, tick);
		return newEvent;
	}

		/**
	 * This is also another implementation of a method. 
	 * Creates a Standard note-off MIDI event.
	 * takes in tick, note, and a channel parameter.
	 * returns a note off event
	 * Throws an exception if the event cannot be created for whatever reason
		 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage noteOff = new ShortMessage();
		noteOff.setMessage(ShortMessage.NOTE_OFF , channel, note, 0);
		
		MidiEvent newEvent = new MidiEvent(noteOff, tick);
		return newEvent;
	}

}
