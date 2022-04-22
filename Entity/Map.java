package Entity;

public class Map {
    public char superficie = 'n';
    public void dibujar(char [][] surface) {
        
    }
    public void cambiarSuelo(char texture) {
        this.superficie = texture; 
    }
    public char sueloActual(){
        return this.superficie;
    }
}