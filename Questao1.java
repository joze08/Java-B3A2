import java.util.*;
import java.io.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Questao1 {

  public static void main(String args[]) throws IOException, ParseException {
    System.out.println("Informe o arquivo com os dados: ");
    Scanner input = new Scanner(System.in);
    String value = input.next();

    FileInputStream stream = new FileInputStream(value);
    InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(reader);

    String nome = br.readLine();
    String dataString = br.readLine();
    String alturaString = br.readLine();

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    Date dataFormatada = formato.parse(dataString);

    double altura = Double.parseDouble(alturaString);

    Pessoa johndoe = new Pessoa();
    
    johndoe.setNome(nome);
    johndoe.setData(dataFormatada);
    johndoe.setAltura(altura);


    johndoe.imprimeTudo();
    //System.out.println("Nome: " + johndoe.getNome());
    //System.out.println("Data: " + johndoe.getData());
    //System.out.println("Altura: " + johndoe.getAltura());
    System.out.println("Idade: " + johndoe.calcAge());

  }
}

class Pessoa{
  private String nome;
  private Date dataNascimento;
  private double altura;

  public void setNome(String name){
    this.nome = name;
  }

  public void setData(Date date){
    this.dataNascimento = date;
  }

  public void setAltura(double height){
    this.altura = height;
  }

  public String getNome(){
    return nome;
  }

  public Date getData(){
    return dataNascimento;
  }

  public double getAltura(){
    return altura;
  }

  public void imprimeTudo(){
    System.out.println("Nome: " + nome);
    System.out.println("Data de nascimento: " + dataNascimento);
    System.out.println("Altura: " + altura);
  }

  public int calcAge(){
    Calendar dateOfBirth = new GregorianCalendar();
    dateOfBirth.setTime(dataNascimento);
    Calendar today = Calendar.getInstance();
    int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
    
    return age;
  }


}