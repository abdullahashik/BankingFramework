package framework.factories;

public interface IFactory<T,R> {
	public R create(T dto);
}
