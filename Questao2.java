import java.util.*;
import java.io.*;

public class Questao2 {

  public static void main(String args[]) throws IOException {
    System.out.println("Informe o arquivo com os dados: ");
    Scanner input = new Scanner(System.in);
    String value = input.next();

    FileInputStream stream = new FileInputStream(value);
    InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(reader);

    String totalAString = br.readLine();
    String capacidString = br.readLine();

    int totalA = Integer.parseInt(totalAString);
    int capacid = Integer.parseInt(capacidString);

    Elevador elevator = new Elevador(capacid, totalA);

    System.out.println("Andar: " + elevator.getAndarAtual());
    System.out.println("Total andar: " + elevator.getTotalAndares());
    System.out.println("Capacidade: " + elevator.getCapacidade());
    System.out.println("Numero de pessoas: " + elevator.getNumPessoas());

  }

}

class Elevador {
  private int andarAtual = 0;
  private int totalAndares = 0;
  private int capacidade;
  private int numPessoas;

  public void setAndarAtual(int andar) {
    andarAtual = andar;
  }

  public void setNumPessoas(int pessoas) {
    numPessoas = pessoas;
  }

  public int getAndarAtual() {
    return andarAtual;
  }

  public int getTotalAndares() {
    return totalAndares;
  }

  public int getCapacidade() {
    return capacidade;
  }

  public int getNumPessoas() {
    return numPessoas;
  }

  public Elevador(int capac, int andares){
    capacidade = capac;
    totalAndares = andares;
  }

  public boolean entra(){
    if(numPessoas < capacidade) {
      numPessoas++;
      return true;
    } else {
      return false;
    }
  }

  public boolean sai(){
    if(numPessoas > 0) {
      numPessoas--;
      return true;
    } else {
      return false;
    }
  }

  public boolean sobe(){
    if(andarAtual < totalAndares){
      andarAtual++;
      return true;
    }else {
      return false;
    }
  }

  public boolean desce() {
    if(andarAtual > 0){
      andarAtual--;
      return true;
    }else {
      return false;
    }
  }


}
