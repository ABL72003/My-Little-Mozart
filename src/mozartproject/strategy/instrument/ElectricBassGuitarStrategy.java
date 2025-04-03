package mozartproject.strategy.instrument;

import javax.sound.midi.Track;

public class ElectricBassGuitarStrategy implements InstrumentStrategy{

	@Override
	public void applyInstrument(Track track, int channel) throws Exception{
		InstrumentStrategy.addChange(track, channel, 33); //MIDI instrument Electric Bass Guitar - MIDI 33
	}

	
}
