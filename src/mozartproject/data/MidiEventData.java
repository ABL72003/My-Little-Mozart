package mozartproject.data;

/**
 * Represents a MIDI event's data including timing, note characteristics, and MIDI channel info.
 * This class is used to encapsulate information parsed from a CSV file
 */
public class MidiEventData {
    private int startEndTick, velocity, note, channel, noteOnOff;
    private int instrument;

    public MidiEventData(int startEndTick, int velocity, int note,
                         int channel, int instrument, int noteOnOff) {
        this.startEndTick = startEndTick;
        this.velocity = velocity;
        this.note = note;
        this.channel = channel;
        this.instrument = instrument;
        this.noteOnOff = noteOnOff;
    }
/**
 * getters and setters for all of the variables 
 * 
 */
	public int getStartEndTick() {
		return startEndTick;
	}

	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getNoteOnOff() {
		return noteOnOff;
	}

	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	public int getInstrument() {
		return instrument;
	}

	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
    
}