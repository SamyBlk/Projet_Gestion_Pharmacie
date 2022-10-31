public class Liste 
{
	//Attributs

	private char car;
	private Medicament listMed;

	//Constructeur

	public Liste (char c)
    {
		car=c;
		listMed=null;
	}
	public Liste (char c,Medicament l)
    {
		car=c;
		listMed=l;
	}

	//1//Getters
    
	public char getc(){return car;}

	public Medicament GetListeMed() 
    {
		return listMed;
	}

	//2//Setters

	public void SetListeMed(Medicament M)
    {
		listMed=new Medicament(M);
	}

	public void SetCar(char c){car=c;}
}