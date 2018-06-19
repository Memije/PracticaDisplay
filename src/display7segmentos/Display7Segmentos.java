/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display7segmentos;

import java.util.Arrays;

/**
 *
 * @author dmemije
 */
public final class Display7Segmentos {
        
    public static final double[][] salidas = new double[16][4];
    public static final double[][] entradas = new double[16][7];    
    
    public static void setVariables(){        
        entradas[0] =  Arrays.stream("1111110".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[1] =  Arrays.stream("0110000".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[2] =  Arrays.stream("1101101".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[3] =  Arrays.stream("1111001".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[4] =  Arrays.stream("0110011".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[5] =  Arrays.stream("1011011".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[6] =  Arrays.stream("1011111".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[7] =  Arrays.stream("1110000".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[8] =  Arrays.stream("1111111".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[9] =  Arrays.stream("1110011".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[10] = Arrays.stream("1110111".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[11] = Arrays.stream("0011111".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[12] = Arrays.stream("1001111".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[13] = Arrays.stream("0111101".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[14] = Arrays.stream("1001111".split("")).mapToDouble(Double::parseDouble).toArray();
        entradas[15] = Arrays.stream("1000111".split("")).mapToDouble(Double::parseDouble).toArray();
        
        salidas[0] =  Arrays.stream("0000".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[1] =  Arrays.stream("0001".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[2] =  Arrays.stream("0010".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[3] =  Arrays.stream("0011".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[4] =  Arrays.stream("0100".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[5] =  Arrays.stream("0101".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[6] =  Arrays.stream("0110".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[7] =  Arrays.stream("0111".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[8] =  Arrays.stream("1000".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[9] =  Arrays.stream("1001".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[10] = Arrays.stream("1010".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[11] = Arrays.stream("1011".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[12] = Arrays.stream("1100".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[13] = Arrays.stream("1101".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[14] = Arrays.stream("1110".split("")).mapToDouble(Double::parseDouble).toArray();
        salidas[15] = Arrays.stream("1111".split("")).mapToDouble(Double::parseDouble).toArray();
    }
    
    public static double[][] getEntradas(){
        return entradas;
    }
    
    public static double[][] getSalidas(){
        return salidas;
    }
    
    
}
