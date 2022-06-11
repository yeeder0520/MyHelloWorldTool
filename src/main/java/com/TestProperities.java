import java.util.Properties;

public class TestProperities {
	public static void main(String args[]){
		Properties properties = System.getProperties();
		System.out.println(properties.getProperty("java"));
	}
}
