public class Stock 
{
    //Attributs

    private Liste[] tab= new Liste[26];

    //Constructeurs

    public Stock()
    {
       for (int i = 0; i < 26; i++) 
       {
           tab[i]= new Liste((char)(65 + i));
       }
    }

    //Methodes
    
    public boolean rechercher(String ch)
    {
       int ind=(int)(ch.charAt(0))-65;

       if (tab[ind].GetListeMed()==null)
       {
            System.out.println("\nCe medicament n'est plus en stock");
            return false;
       }
       else 
       {
            Medicament med=tab[ind].GetListeMed();

            while (med.GetSuiv()!=null&&med.GetNom().compareToIgnoreCase(ch)!=0) 
            {
                med=med.GetSuiv();
            }
            if (med.GetNom().compareToIgnoreCase(ch)==0)
            {
                System.out.println("\nCe medicament est en stock");
                return true;
            }
            else 
            {
                System.out.println("\nCe medicament n'est plus en stock");
                return false;
            }	
       }
    }


   public void achat (String m, double pa, int qte, boolean remb, double marge)
   {
        Medicament M=new Medicament(m, 0,(pa/qte), marge, remb);
        char ch=M.GetNom().charAt(0);
        int ind=((int)ch)-65;

        if (tab[ind].GetListeMed()==null)
        {
            M.SetPua(pa/qte);
            M.SetNb(qte);
            tab[ind].SetListeMed(M);
        }
        else 
        {
            Medicament med=tab[ind].GetListeMed();
            Medicament premed=med;
            while (med.GetSuiv()!=null&&med.GetNom().compareToIgnoreCase(M.GetNom())<0)
            {
                premed=med;
                med=med.GetSuiv();
            }
            
            if (med.GetNom().compareToIgnoreCase(M.GetNom())==0)
            {
                M.SetNb(med.GetNb()+qte);
                M.SetSuiv(med.GetSuiv());
                premed.SetSuiv(M);
            }
            else if (med.GetSuiv()==null)
            {
                M.SetNb(qte);
                med.SetSuiv(M);
            }
            else if (med.GetNom().compareToIgnoreCase(M.GetNom())<0)
            {
                M.SetNb(qte);
                M.SetSuiv(med);
                premed.SetSuiv(M);
            }
        }		
    }


    public double vente(String med, int nb, Client cl)
    {
        if (rechercher(med))
        {
            int ind=(int)(med.charAt(0))-65;
            Medicament tmp=tab[ind].GetListeMed();
            Medicament pretmp=tmp;
            while (med.compareToIgnoreCase(tmp.GetNom())!=0) 
            {
                pretmp=tmp;
                tmp=tmp.GetSuiv();
            }

            //Maintenant que nous avons trouver le medicament on le vend et apporte les modif necessaires

            if (nb<=tmp.GetNb())
            {
                tmp.SetNb(tmp.GetNb()-nb); 
                if (tmp.GetNb()==0)
                {
                    System.out.println("C etait la derniere boite");
                    pretmp.SetSuiv(tmp.GetSuiv());
                }
                else {pretmp=tmp;}

                if (!cl.GetAssure())
                {
                    return (nb*((pretmp.GetPua())+(pretmp.GetPua()*pretmp.GetMarge())/100));
                }
                else if (pretmp.GetRemb()!=true)
                {
                    return (nb*((pretmp.GetPua())+(pretmp.GetPua()*pretmp.GetMarge())/100));
                }
                else 
                {
                    return ((nb*((pretmp.GetPua())+(pretmp.GetPua()*pretmp.GetMarge())/100))*0.2);
                }
            }

            //si il y a une quentite suffisante

            else {System.out.println("achat impossible quantite insuffisante en stock"); return -1;}
        }

        //si il n'y a pas de medicament

        else  return -1;
    }


    public double valStock()
    {
        double montant=0;
        Medicament tmp;
        for (int i=0; i<26; i++)
        {
            if (tab[i].GetListeMed()!=null)
            {
                tmp=tab[i].GetListeMed();
                montant+=(tmp.GetPua()*tmp.GetNb());
                tmp=tmp.GetSuiv();

                while (tmp!=null)
                {
                    montant+=(tmp.GetPua()*tmp.GetNb());
                    tmp=tmp.GetSuiv();
                }
            }
        }
        return montant;
    }



}
   