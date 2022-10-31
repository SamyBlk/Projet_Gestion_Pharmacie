public class Medicament 
{
    //Attributs

    private String 	nom;
    private int 	nb;
    private double 	pua;
    private double 	marge;
    private boolean remb;
    private Medicament suiv;

    //Constructeurs

    public Medicament (String n, int nb, double p, double m, boolean r)
    {
       nom=new String(n);
       this.nb=nb;
       pua=p;
       marge=m;
       remb=r;
       suiv=null;
    }

    public Medicament (Medicament M)
    {
        this.nom=new String(M.nom);
        this.nb=M.nb;
        this.pua=M.pua;
        this.marge=M.marge;
        this.remb=M.remb;
        this.suiv=M.suiv;
    }

    public Medicament (){}
    //METHODES
    //1//Getters

    public String 	  GetNom()   {return nom;}
    public int 		  GetNb()	 {return nb;}
    public double 	  GetPua()   {return pua;}
    public double 	  GetMarge() {return marge;}
    public boolean 	  GetRemb()  {return remb;}
    public Medicament GetSuiv()  {return suiv;}

    //2//Setters

    public void	SetNb(int n)		  {nb=n;}
    public void SetPua(double p)	  {pua=p;}
    public void SetSuiv(Medicament s) {suiv=s;}
       
}
   