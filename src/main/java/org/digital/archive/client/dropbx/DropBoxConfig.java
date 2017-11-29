package org.digital.archive.client.dropbx;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

public class DropBoxConfig {
	
	 private static final String ACCESS_TOKEN = "cjfsE6djMpAAAAAAAAAACFFN84b2vLBr_nE9MKQVGxM3F332-WFdYoimidjKBu-g";

	    @SuppressWarnings("deprecation")
		public static void main(String args[]) throws DbxException {
	        // Create Dropbox client
	        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
	        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
	        
	        
	     // Get current account info
	        FullAccount account = client.users().getCurrentAccount();
	        System.out.println(account.getName().getDisplayName());
	        
	        //APIs call
	        
	     // Get files and folder metadata from Dropbox root directory
	        ListFolderResult result = client.files().listFolder("");
	        while (true) {
	            for (Metadata metadata : result.getEntries()) {
	            	
	                System.out.println(metadata.getPathLower());	               
	            }

	            if (!result.getHasMore()) {
	                break;
	            }

	            result = client.files().listFolderContinue(result.getCursor());
	        }
	        
	       
	        
	    }

}
