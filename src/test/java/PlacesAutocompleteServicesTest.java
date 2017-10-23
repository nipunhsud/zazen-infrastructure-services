import java.io.IOException;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zazen.infrastructure.configuration.InfrastructureConfigurationListener;
import com.zazen.infrastructure.google.autocomplete.PlacesAutocompleteServices;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InfrastructureConfigurationListener.class})
@Ignore
public class PlacesAutocompleteServicesTest {
	
	@Autowired
	PlacesAutocompleteServices placesAutocompleteServices;
	
	@Test
	public void test() throws ClientProtocolException, IOException{
//		CloseableHttpResponse response = placesAutocompleteServices.getHttpConnection();
//		
//		System.out.println("Response "+ response);
	}
	
}
