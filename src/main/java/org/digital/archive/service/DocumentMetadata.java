package org.digital.archive.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.apache.log4j.Logger;

/**
 * Meta data of a document from an archive managed by {@link IArchiveService}.
 * 
 * @author Daniel Murygin <daniel.murygin[at]gmail[dot]com>
 */
/**
 * @author minda
 *
 */
public class DocumentMetadata implements Serializable {
    
    static final long serialVersionUID = 7283287076019483950L;

    private static final Logger LOG = Logger.getLogger(DocumentMetadata.class);
    
    public static final String PROP_UUID = "uuid";
    public static final String PROP_CUSTOMER_ID = "customerId";
    public static final String PROP_FILE_NAME = "fileName";
    public static final String PROP_FILE_TYPE = "fileType";
    public static final String PROP_UPLOAD_DATE = "uploadDate";
    public static final String PROP_DIGITAL_SIGN = "digitalSign";
    public static final String PROP_FILE_SOURCE = "fileSource";
    public static final String PROP_DIGITAL_SIGN_SOURCE = "digitalSignSource";
    
    
    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);
    
    protected String uuid;
    protected String fileName;
    protected String fileType;
    protected String fileSource;
    protected Date uploadDate;
    protected String customerId;
    protected String digitalSign;
    protected String digitalSignSource;
    
        
    
    public DocumentMetadata() {
        super();
    }

    public DocumentMetadata(String fileName, Date uploadDate, String customerId, String fileType, String fileSource, String digitalSign, String digitalSignSource) {
        this(UUID.randomUUID().toString(), fileName,  uploadDate,  customerId,  fileType,  fileSource,  digitalSign,  digitalSignSource);
    }
    
    public DocumentMetadata(String uuid, String fileName, Date uploadDate, 
    		String customerId, String fileType, String fileSource, String digitalSign, String digitalSignSource) {
        super();
        this.uuid = uuid;
        this.fileName = fileName;
        this.uploadDate = uploadDate;
        this.customerId = customerId;
        this.fileType = fileType;
        this.fileSource = fileSource;
        this.digitalSign = digitalSign;
        this.digitalSignSource = digitalSignSource;
    }
    
    public DocumentMetadata(Properties properties) {
        this(properties.getProperty(PROP_UUID),
             properties.getProperty(PROP_FILE_NAME),
             null,
             properties.getProperty(PROP_CUSTOMER_ID),
             properties.getProperty(PROP_FILE_TYPE),
             properties.getProperty(PROP_FILE_SOURCE),
             properties.getProperty(PROP_DIGITAL_SIGN),
             properties.getProperty(PROP_DIGITAL_SIGN_SOURCE)
        		);
        String dateString = properties.getProperty(PROP_UPLOAD_DATE);
        if(dateString!=null) {
            try {
                this.uploadDate = DATE_FORMAT.parse(dateString);
            } catch (ParseException e) {
                LOG.error("Error while parsing date string: " + dateString + ", format is: yyyy-MM-dd" , e);
            }
        }    
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
//    public Date getDocumentDate() {
//        return documentDate;
//    }
//    public void setDocumentDate(Date documentDate) {
//        this.documentDate = documentDate;
//    }
//    
//    public String getPersonName() {
//        return personName;
//    }
//    public void setPersonName(String personName) {
//        this.personName = personName;
//    }
    
    public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSource() {
		return fileSource;
	}

	public void setFileSource(String fileSource) {
		this.fileSource = fileSource;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDigitalSign() {
		return digitalSign;
	}

	public void setDigitalSign(String digitalSign) {
		this.digitalSign = digitalSign;
	}

	public String getDigitalSignSource() {
		return digitalSignSource;
	}

	public void setDigitalSignSource(String digitalSignSource) {
		this.digitalSignSource = digitalSignSource;
	}

	public Properties createProperties() {
        Properties props = new Properties();
        props.setProperty(PROP_UUID, getUuid());
        props.setProperty(PROP_FILE_NAME, getFileName());
        props.setProperty(PROP_CUSTOMER_ID, getCustomerId());
        props.setProperty(PROP_UPLOAD_DATE, DATE_FORMAT.format(getUploadDate()));
        
        props.setProperty(PROP_FILE_TYPE, getFileType());
        props.setProperty(PROP_DIGITAL_SIGN, getDigitalSign());
        props.setProperty(PROP_FILE_SOURCE, getFileSource());
        props.setProperty(PROP_DIGITAL_SIGN_SOURCE, getDigitalSignSource());
        
      
        
        return props;
    }
    
    
}
