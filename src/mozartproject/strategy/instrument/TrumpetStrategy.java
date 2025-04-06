package mozartproject.strategy.instrument;

import javax.sound.midi.Track;

public class TrumpetStrategy implements InstrumentStrategy{
	
	/**
	 * Concrete implementation of InstrumentStrategy that applies the
	 * Trumpet instrument to a MIDI track.
	 */
	@Override
	public void applyInstrument(Track track, int channel) throws Exception {
		InstrumentStrategy.addChange(track, channel, 56); //Trumpet Instrument - MIDI 56
	}

}
