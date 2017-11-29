package org.digital.archive.service;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

/**
 * A document from an archive managed by {@link IArchiveService}.
 * 
 * @author Daniel Murygin <daniel.murygin[at]gmail[dot]com>
 */
public class Document extends DocumentMetadata implements Serializable {

    private static final long serialVersionUID = 2004955454853853315L;
    
    private byte[] fileData;
    
   
    
    public Document( byte[] fileData, String fileName, Date uploadDate, String customerId,
    		String fileType, String fileSource, String digitalSign, String digitalSignSource) {
        super(fileName, uploadDate, customerId, fileType, fileSource,  digitalSign,  digitalSignSource);
        this.fileData = fileData;
    }

    public Document(Properties properties) {
        super(properties);
    }
    
    public Document(DocumentMetadata metadata) {
        super(metadata.getUuid(), metadata.getFileName(), metadata.getUploadDate(), metadata.getCustomerId(),
        		metadata.getFileType(), metadata.getFileSource(), metadata.getDigitalSign(),
        		metadata.getDigitalSignSource());
    }

    public byte[] getFileData() {
        return fileData;
    }
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
    public DocumentMetadata getMetadata() {
        return new DocumentMetadata(getUuid(), getFileName(), getUploadDate(), getCustomerId(),
        		getFileType(), getFileSource(), getDigitalSign(), getDigitalSignSource());
    }
    
}
