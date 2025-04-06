package mozartproject.strategy.pitch;

public class LowerPitchStrategy implements PitchStrategy{
	
	/**
	 * Concrete implementation of PitchStrategy that lowers the pitch of a note.
	 * This strategy subtracts 2 semitones from the original note value, effectively lowering its pitch.
	 */
	@Override
	public int modifyPitch(int note) {
		note -= 2;
		return note;
	}

}
