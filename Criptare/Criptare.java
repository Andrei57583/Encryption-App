package Criptare;
import java.util.*;
public class Criptare 
{
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Character> lista = new ArrayList<Character>();
	private ArrayList<Character> lista_amestecata = new ArrayList<Character>();
	private char caracter = ' ';
	private char[] litere;
	
	Criptare()
	{
		
		cheieNoua();
		Meniu();
	}
	
	private void Meniu()
	{
		String n;
		do
		{	
			System.out.println("\nMENIU: "+"\n1.Apeleaza metoda \"cheieNoua\'"+
					"\n2.Apeleaza metoda \"getCheie\""+"\n3.Criptare"+"\n4.Decriptare"+"\n5.Inchideti programul");
			System.out.print("\nIntroduceti optiunea de la tastatura: ");
			n = scan.nextLine();
			
			switch(n)
			{
				case "1": cheieNoua(); break;
				
				case "2": getCheie(); break;
				
				case "3": cripteaza(); break;
				
				case "4": decripteaza(); break;
				
				case "5": System.out.println("Ati inchis programul!"); 
						  System.exit(0);	
						  break;
				
				default: System.out.println("Optiunea nu este valabila!");
			}
			
		}while(n != "5");
	}
	
	private void cheieNoua()
	{
		caracter = ' ';
		lista.clear();
		lista_amestecata.clear();
		
		for(int i=32; i<127; i++) // 32 este SPATIU in ASCII, 127 este DELETE in ASCII
		{
			lista.add(Character.valueOf(caracter));
			caracter++;
		}
		
		lista_amestecata = new ArrayList<>(lista);
		Collections.shuffle(lista_amestecata);
		System.out.println("O noua cheie a fost generata!");
	}
	
	private void getCheie()
	{
		System.out.println("Cheie: ");
		
		for(Character x : lista) //Arata caracterul corespunzator tuturor numerelor de la 32 la 126 in codul ASCII
		{
			System.out.print(x);
		}
		System.out.println();
		
		for(Character x : lista_amestecata)
		{
			System.out.print(x);
		}
		System.out.println();
	}
	
	private void cripteaza()
	{
		System.out.println("Introduceti un mesaj pe care programul sa-l cripteze: ");
		String mesaj = scan.nextLine();
		
		litere = mesaj.toCharArray();
		
		for(int i=0; i<litere.length; i++)
		{
			for(int j=0; j<lista.size(); j++)
			{
				if(litere[i] == lista.get(j))
				{
					litere[i] = lista_amestecata.get(j); 
					break;
				}
			}
		}
		
		System.out.println("Mesajul criptat: ");
		for(char x : litere)
		{
			System.out.print(x);
		}
		System.out.println();
	}
	
	private void decripteaza()
	{
		System.out.println("Introduceti un mesaj pe care programul sa-l cripteze: ");
		String mesaj = scan.nextLine();
		
		litere = mesaj.toCharArray();
		
		for(int i=0; i<litere.length; i++)
		{
			for(int j=0; j<lista_amestecata.size(); j++)
			{
				if(litere[i] == lista_amestecata.get(j))
				{
					litere[i] = lista.get(j); break;
				}
			}
		}
		
		System.out.println("Mesajul decriptat: ");
		for(char x : litere)
		{
			System.out.print(x);
		}
		System.out.println();
	}
}
