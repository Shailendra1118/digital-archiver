package org.digital.archive.client.docu;

//Download API Client and add to your project: 
		// https://github.com/docusign/docuSign-java-client
		import com.docusign.esign.api.*;
		import com.docusign.esign.client.*;
		import com.docusign.esign.model.*;
		
public class DocTest {

	public static void main(String args[]){
		
		

		// Enter your DocuSign credentials
		String UserName = "shailendra1118@gmail.com"; //"shailendra1118@gmail.com";
		String Password = "ignite";    
		String IntegratorKey = "ignitedocusign1118";

		// for production environment update to "www.docusign.net/restapi"
		String BaseUrl = "https://demo.docusign.net/restapi";

		// initialize the api client for the desired environment
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(BaseUrl);

		// create JSON formatted auth header
		String creds = "{\"Username\":\"" +  UserName + "\",\"Password\":\"" +  Password + "\",\"IntegratorKey\":\"" +  IntegratorKey + "\"}";
		apiClient.addDefaultHeader("X-DocuSign-Authentication", creds);

		// assign api client to the Configuration object
		Configuration.setDefaultApiClient(apiClient);

		try
		{
			// login call available off the AuthenticationApi
			AuthenticationApi authApi = new AuthenticationApi();

			// login has some optional parameters we can set
			AuthenticationApi.LoginOptions loginOps = authApi.new LoginOptions();
			loginOps.setApiPassword("true");
			loginOps.setIncludeAccountIdGuid("true");
			LoginInformation loginInfo = authApi.login(loginOps);

			// note that a given user may be a member of multiple accounts
			java.util.List<LoginAccount> loginAccounts = loginInfo.getLoginAccounts();

			System.out.println("LoginInformation: " + loginAccounts);
		}
		catch (com.docusign.esign.client.ApiException ex)
		{
			System.out.println("Exception: " + ex);
		}
	}
}
