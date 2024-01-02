package com.dao.impl;

import com.dao.FiliereDAO;
import com.entities.Filiere;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("filiereConverter")
public class FiliereConverter implements Converter{
    private FiliereDAO filiereDAO;
    @Override
    public Filiere getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if (value != null && !value.isEmpty()) {
                return filiereDAO.getById(Integer.parseInt(value));
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error in getAsObject method: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((Filiere) value).getCode());
        }
        return null;
    }



}
