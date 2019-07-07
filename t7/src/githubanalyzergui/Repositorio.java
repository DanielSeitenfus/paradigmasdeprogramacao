/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubanalyzergui;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Repositorio {
    private String user;
    private String name;
    private String url;
    private ArrayList<Commit> listaCommits;
    
    public Repositorio(String url){
        this.url = url;
        listaCommits = new ArrayList<>();
        String split[] = url.split("/");
        user = split[3];
        name = split[4];
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Commit> getListaCommits() {
        return listaCommits;
    }

    public void setListaCommits(ArrayList<Commit> listaCommits) {
        this.listaCommits = listaCommits;
    }
    
    
    
}
