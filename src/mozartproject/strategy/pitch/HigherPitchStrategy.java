package mozartproject.strategy.pitch;

public class HigherPitchStrategy implements PitchStrategy{
	
	/**
	 * Concrete implementation of PitchStrategy that lowers the pitch of a note.
	 * This strategy adds 2 semitones from the original note value, effectively raising its pitch.
	 */
	@Override
	public int modifyPitch(int note) {
		note += 2;
		return note;
	}

}
