package Ejercicio1;

public class TestFiguras {

    public static void main(String[] args) {
        
        Figura objFigura = new Figura(3, 5);
        Circulo objCirculo = new Circulo(4, 8, 2.5);
        Rectangulo objRectangulo = new Rectangulo(9, 2, 35, 22);
        
        objFigura.posicion();
        objCirculo.posicion();
        objRectangulo.posicion();

    }

}
