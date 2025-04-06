package mozartproject.factory;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

/**
 * 
 * An interface for creating MIDI note-on and note-off events.
 * Implementations of this interface define how MIDI events are constructed.
 */
public interface MidiEventFactory {

	 MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	 MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
