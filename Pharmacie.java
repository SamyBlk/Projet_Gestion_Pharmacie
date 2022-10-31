public class Pharmacie 
{
    public static void main (String[] arges) 
    {
        Stock Ph=new Stock();
        
        Ph.achat("Dolicrane",6540.32, 200, true, 11.4);
        Ph.achat("Budecore",5163.09, 2, true, 10.5);//En rupture de stock prochainement
        Ph.achat("Aspegic",2000.45, 214, true, 15.0);
        Ph.achat("Paracetamole",1720.29, 256, true, 12.1);
        Ph.achat("Doliprane",600.00, 365, true, 17.3);
        Ph.achat("Betadine",5700.78, 536, false, 6.7);
        Ph.achat("Smecta",1800.89, 4, false, 20.0);//Ce medicament n'est pas remboursable 
        Ph.achat("Antadys",4200.42, 444, true, 14.6);
        Ph.achat("Clamoxyl",7809.98, 613, false, 16.8);
        Ph.achat("Augmentin",400.00, 233, true, 13.2);
        Ph.achat("Gaviscon",1516.16, 712, false, 7.9);
        Ph.achat("Dermagore",1867.56, 2, true, 15.1);
        Ph.achat("Seropram",6548.54, 20, true, 5.0);
        Ph.achat("Biafine",4575.57, 118, true, 18.7);
        Ph.achat("Charbonel",10000.00, 106, true, 15.3);//celui-ci est en realité le 15eme medicament
        Ph.achat("Lisopaine",20987.98, 365, true, 19.4);//Achat du medicament existant
        
        Client c1=new Client("Belkessa","Samy", "05.03.2003", true, "31080819");
        Client c2=new Client("BELKESSA","Amine", "22.10.1999", true, "31170522");
        Client c3=new Client("Belkessa","Omar", "05.01.1959", false, "31265559");
        
        double v1=Ph.vente("Seropram",4,c1);//Ce medicament est remboursable à un client assuré
        System.out.println("\n"+c1.GetNom()+" "+c1.GetPrenom()+" doit payer :"+v1+" DA");
        
        double v2=Ph.vente("Antadys",1,c3);//Ce medicament est remboursable à un client assuré
        System.out.println("\n"+c3.GetNom()+" "+c3.GetPrenom()+" doit payer :"+v2+" DA");
        
        double v3=Ph.vente("Smecta",2,c2);//Ce medicament n'est pas remboursable à un client assuré
        System.out.println("\n"+c2.GetNom()+" "+c2.GetPrenom()+" doit payer :"+v3+" DA");
        
        double v4=Ph.vente("Budecore",2,c2);//Vente d’un médicament avec un stock limite (0 boites après la vente)
        System.out.println("\n"+c2.GetNom()+" "+c2.GetPrenom()+" doit payer :"+v4+" DA");
   
   
    }
}