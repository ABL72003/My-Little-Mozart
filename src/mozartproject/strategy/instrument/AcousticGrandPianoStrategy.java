package mozartproject.strategy.instrument;
import javax.sound.midi.Track;

public class AcousticGrandPianoStrategy implements InstrumentStrategy{
	
	
	
	@Override
	public void applyInstrument(Track track, int channel) throws Exception {
		InstrumentStrategy.addChange(track, channel, 0); //Acoustic Grand Piano Instrument - MIDI 0
		
	}

}
