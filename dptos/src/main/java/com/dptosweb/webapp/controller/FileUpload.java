package com.dptosweb.webapp.controller;


/**
 * Command class to handle uploading of a file.
 *
 * <p>
 * <a href="FileUpload.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:justomiguelvargas@gmail.com">Justo Vargas</a>
 */
public class FileUpload {
    private String name;
    private byte[] file;

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public byte[] getFile() {
        return file;
    }
}
