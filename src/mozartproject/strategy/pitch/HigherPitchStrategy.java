package mozartproject.strategy.pitch;

public class HigherPitchStrategy implements PitchStrategy{
	
	/**
	 * 
	 */
	@Override
	public int modifyPitch(int note) {
		note += 2;
		return note;
	}

}
