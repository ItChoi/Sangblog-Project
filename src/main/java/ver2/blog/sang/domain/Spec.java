package ver2.blog.sang.domain;

public class Spec<T> {
	public T info;

	public Spec(T info) {
		super();
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
}
