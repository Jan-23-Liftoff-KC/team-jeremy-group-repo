package com.digitalfilingcabinet.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class Files extends AbstractBaseClass{
   private String type;

   @Lob
    private byte[] data;

   public Files(){}

    public Files (String type, byte[] data) {
       super();
       this.type = type;
       this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
