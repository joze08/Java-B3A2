import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Questao3{

  public static void main(String args[]) throws IOException {
    System.out.println("Informe o arquivo com os dados: ");
    Scanner input = new Scanner(System.in);
    String value = input.next();

    FileInputStream stream = new FileInputStream(value);
    InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(reader);

    String placa = br.readLine();
    String modelo = br.readLine();
    String entradaString = br.readLine();
    String saidaString = br.readLine();

    LocalTime entrada = LocalTime.parse(entradaString);
    LocalTime saida = LocalTime.parse(saidaString);

    Estacionamento estacionamento = new Estacionamento();

    estacionamento.set(placa, modelo, entrada, saida);
    estacionamento.imprimeTudo(0);


  }

}

class Estacionamento{
  private ArrayList<String> placaCarro = new ArrayList();
  private ArrayList<String> modeloCarro = new ArrayList();
  private ArrayList<LocalTime> horaEntrada = new ArrayList();
  private ArrayList<LocalTime> horaSaida = new ArrayList();

  public String getPlacaCarro(int i) {
    return placaCarro.get(i);
  }

  public String getModeloCarro(int i) {
    return modeloCarro.get(i);
  }

  public LocalTime getHoraEntrada(int i) {
    return horaEntrada.get(i);
  }

  public LocalTime getHoraSaida(int i) {
    return horaSaida.get(i);
  }

  //Esse método seta todo mundo junto pra manter o controle dos carros com o mesmo index
  public void set(String placa, String modelo, LocalTime entrada, LocalTime saida) {
    placaCarro.add(placa);
    modeloCarro.add(modelo);
    horaEntrada.add(entrada);
    horaSaida.add(saida);
  }

  public void imprimeTudo(int i) {
    System.out.println("Placa: " + placaCarro.get(i));
    System.out.println("modelo: " + modeloCarro.get(i));
    System.out.println("Hora de entrada: " + horaEntrada.get(i));
    System.out.println("Hora Saida: " + horaSaida.get(i));
    System.out.println("Total a pagar: " + valorHora(i));
  }

  public double valorHora(int i) {
    int tempo = (horaSaida.get(i).getHour()) - (horaEntrada.get(i).getHour());
    double valor = tempo * 1.5;

    return valor;
  }
}