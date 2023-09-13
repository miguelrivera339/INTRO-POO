package com.mycompany.clase_4;

public class Clase_4 {

    public static void main(String[] args) {

        //-->Declaracion del objeto PERRO
	    Animal perro = new Perro("Stich","Carnivoro",15,"Doberman");
        perro.Alimentarse();
        //-->Declaracion de otro objeto PERRO
        Perro perro1 = new Perro("Teddy","Croquetas",10,"Chihuahua");
        perro1.Alimentarse();


        //-->Declaracion del objeto Gato
        Animal gato = new Gato("Pelusa","Galletas",15,"Siames");
        gato.Alimentarse();
        //-->Declaracion del objeto Caballo
        Animal caballo = new caballo("Spark","Pasto",25,"Fino");
        caballo.Alimentarse();

        //-->Declaracion del objeto tiburon
         Animal conejo = new conejo("jaime","zanahoria",12,"Belier");
        gato.Alimentarse();
        
          Animal lobo = new lobo("jaime","zanahoria",12,"Belier");
        gato.Alimentarse();
    }
}