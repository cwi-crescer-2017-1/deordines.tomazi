/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
/**
 *
 * @author deordines.tomazi
 */
public class NewClass {
//  public static void main(String[] args) { 
//        try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
//        try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
//            System.out.print("Insira seu nome: ");
//            System.out.println("Hello World! - " + bufferedReader.readLine());
//        } catch (Exception e) {
//            //...
//        }
//    } catch (Exception e) {
//        //...
//    }
//    }
    
//    public static void main(String[] args) {
//        StringBuffer buffer = new StringBuffer();
//        ArrayList<String> estados = new ArrayList<String>();
//        
//        for (Estados estado : Estados.values()) {
//            estados.add(estado.getNome());
//        }
//        
//        Collections.sort(estados);
//        
//        for(String nome : estados) {
////            nome.replaceAll("([a-z])([A-Z])", "$1 S2");
//            buffer.append(nome).append(", ");
//        }
//        
//        buffer.replace(buffer.length() - 2, buffer.length(), ".");
//        System.out.print(buffer);
//    }
        
    public static void main(String[] args) {
        String data;
        int diasSomados;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        
        try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
            try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                System.out.print("Informe a data (01/01/1990): ");
                data = bufferedReader.readLine();
                System.out.println(data);
                
                System.out.print("Informe os dias a serem somados: ");
                diasSomados = Integer.parseInt(bufferedReader.readLine());
                System.out.println(diasSomados);
                
                calendar.setTime(formato.parse(data));
            } catch (Exception e) {
		//...
            }
	} catch (Exception e) {
		//...
	}
    }
}