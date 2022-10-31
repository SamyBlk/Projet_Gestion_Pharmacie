public class Client 
{
    //ATTRIBUTS

    private String 	nom;
    private String 	prenom;
    private String 	dateN;
    private boolean assure;
    private String	NSS;

    //CONSTRUCTEUR

    public Client (String nom, String prenom, String d, boolean a, String NSS)
    {
       this.nom= nom;
       this.prenom= prenom;
       dateN=d;
       assure=a;
       if (assure==true)
            this.NSS=NSS;
       else 
            System.out.println("ce cleint n'est pas assure");
    }

    //METHODES

    public boolean GetAssure(){return assure;}
    public String  GetNom(){return nom;}
    public String  GetPrenom(){return prenom;}
   
}