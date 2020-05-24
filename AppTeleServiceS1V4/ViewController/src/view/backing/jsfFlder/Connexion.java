package view.backing.jsfFlder;



import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlGraphicImage;

import javax.faces.context.FacesContext;

import oracle.jbo.client.Configuration;

import model.AM.UtilisateurAMImpl;

import model.DATA.UtilisateurData;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichDecorativeBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichLink;

public class Connexion {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelStretchLayout psl1;
    private RichDecorativeBox db1;
    private RichInputText it1;
    private RichInputText it2;
    private RichPanelBox pb1;
    private HtmlGraphicImage gi1;
    private RichButton b1;
    private RichLink l1;

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setDb1(RichDecorativeBox db1) {
        this.db1 = db1;
    }

    public RichDecorativeBox getDb1() {
        return db1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setGi1(HtmlGraphicImage gi1) {
        this.gi1 = gi1;
    }

    public HtmlGraphicImage getGi1() {
        return gi1;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }
    
    private String un;
    private String ps;

    public void setUn(String un) {
        this.un = un;
    }

    public String getUn() {
        return un;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getPs() {
        return ps;
    }

    public model.AM.UtilisateurAMImpl getAppModuleImpl() {
        UtilisateurAMImpl appModulee = null;
        String amDef = "model.AM.UtilisateurAM";
        String config = "UtilisateurAMLocal";
        appModulee = (model.AM.UtilisateurAMImpl) Configuration.createRootApplicationModule(amDef, config);
        return  appModulee;
    }
    
    public String loginAction() throws IOException {      
            FacesMessage msg;
            FacesContext context = FacesContext.getCurrentInstance();
            model.AM.UtilisateurAMImpl amImpl = (model.AM.UtilisateurAMImpl)getAppModuleImpl();
            System.out.println("view## "+amImpl.getViewObjects());
            UtilisateurData user = amImpl.connexion(un,ps); 
            if (user == null)
            {
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Utilisateur non trouvé","");
            }
            else
            {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Utilisateur trouvé","");           
                context.getExternalContext().redirect("/AppTeleServiceS1V4-ViewController-context-root/faces/jsfFlder/Home.jsf");
            }   
            context.addMessage("", msg);    
            return null;
        }

    public void setL1(RichLink l1) {
        this.l1 = l1;
    }

    public RichLink getL1() {
        return l1;
    }

    public String NCompte_action() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("/AppTeleServiceS1V4-ViewController-context-root/faces/jsfFlder/Inscription.jsf");
        return null;
    }
}
