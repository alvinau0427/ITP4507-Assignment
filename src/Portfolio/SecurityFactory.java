package Portfolio;

public interface SecurityFactory {
	public abstract Security create() throws Exception;
}