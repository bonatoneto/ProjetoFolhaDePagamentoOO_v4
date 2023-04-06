package negocio;

import entidades.Folha;

public class FolhaNegocio {

    public static float calculaSalarioBruto(Folha folha) {
        return folha.getNumHorasTrabalhadas() * folha.getValorHora();
    }
    
    public static float calculaIR(float bruto) {
        if (bruto <= 1372.81) 
            return 0;
        else 
        if (bruto <= 2743.25) 
            return (float) ((bruto * .15) - 205.92);
        else 
            return (float) ((bruto * .275) - 548.82);
    }
    
    public static float calculaINSS(float bruto) {
        if (bruto <= 868.29) 
            return (float) (bruto * 0.08);
        else 
        if (bruto < 1447.14) 
            return (float) (bruto * 0.09);
        else 
        if (bruto < 2894.28) 
            return (float) (bruto * 0.11);
        else 
            return (float) 318.37;	
    }
    
    public static float calculaFGTS(float bruto) {
        return (float) (bruto * 0.08);
    }
    
    public static float calculaSalarioLiquido(float bruto, float IR, float INSS) {
        return (float) (bruto - IR - INSS);
    }
}