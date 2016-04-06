package interfaces.filters;

public class LowPass extends Filter
{
	double cutoff;
	public LowPass(double cutoff) { this.cutoff = cutoff; }
	public Waveform process(Waveform input)
	{ 
		System.out.println("Using LowPass.process()");
		return input; // Dummy processing
	}
}
