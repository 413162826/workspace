package 面试相关.接口;

public class FilterProcessor {
	public static void main(String[] args) {
		Waveform w = new Waveform();
		//Apply用了策略模式
		//把filter的实现类，变成了Processor实现类。
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);
		Apply.process(new FilterAdapter(new HighPass(2.0)), w);
		Apply.process(new FilterAdapter(new BandPass(3.0,4.0)), w);
		
	}
}
class FilterAdapter implements Processor{
	//Filter用了策略模式
	Filter filter;
	//适配器模式（有点策略模式的味道，但要注意的是，它把所有策略，都用一个类包装了）
	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}
	@Override
	public String name() {
		return filter.name();
	}
	@Override
	public Object process(Object input) {
		return filter.process((Waveform)input);
	}
}