/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author gilbert.solorzano
 * 
 */
/*
 *                          <name-value>
                                <name>uri-length</name>
                                <value>first-n-segments</value>
                            </name-value>
 */
public class ExNameValue {
    private String name;
    private String value;
    
    public ExNameValue(){}

    @XmlElement(name=AppExportS.NAME)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name=AppExportS.VALUE)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public String whatIsDifferent(ExNameValue obj){
        if(this.equals(obj) ) return AppExportS._U;
        
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L4).append(AppExportS.NAME_VALUE);
        
        bud.append(AppExportS.L4_1).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        if(!value.equals(obj.getValue())){
            bud.append(AppExportS.L4_1).append(AppExportS.VALUE);
            bud.append(AppExportS.L5).append(AppExportS.SRC).append(AppExportS.VE).append(value);
            bud.append(AppExportS.L5).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getValue());
        }
        
        return bud.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L4).append(AppExportS.NAME_VALUE);
        bud.append(AppExportS.L5).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        bud.append(AppExportS.L5).append(AppExportS.VALUE).append(AppExportS.VE).append(value);
        return bud.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 71 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExNameValue other = (ExNameValue) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        return true;
    }
    
    
}
