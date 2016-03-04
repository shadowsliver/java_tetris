package domain.model;


public class PropertiesReaderLogin extends PropertiesReader {

	public PropertiesReaderLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setPath() {
		super.path = "/db.properties";
	}
	
}
