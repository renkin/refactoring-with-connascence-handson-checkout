package checkout;

import java.util.Objects;

public class Euro {

	long euroCents;

	public Euro(long euroCents) {
		this.euroCents = euroCents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(euroCents);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Euro))
			return false;
		Euro other = (Euro) obj;
		return euroCents == other.euroCents;
	}

	public void add(Euro price) {
		this.euroCents += price.euroCents;
	}

	@Override
	public String toString() {
		return "Euro [euroCents=" + euroCents + "]";
	}

}
