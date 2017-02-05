/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.wilsonline.webmodel;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maike
 */
@Named(value = "languageBean")
@SessionScoped
public class LanguageBean implements Serializable {
    
    private static final Logger LOG = LoggerFactory.getLogger(LanguageBean.class);
    private Locale locale;
    private String basename;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
        basename = "lang";
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        
        String bn = "lang";
        String lang = locale.getLanguage().toString();
        if (lang != "es"){
            bn += "_" + lang;
        }
        basename = bn;
    }

    public String getBasename() {
        return basename;
    }
    
}
