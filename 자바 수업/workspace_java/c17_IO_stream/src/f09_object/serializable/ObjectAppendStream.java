package f09_object.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectAppendStream extends ObjectOutputStream{

	public ObjectAppendStream(OutputStream out) throws IOException {
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException {
	}
	
}
