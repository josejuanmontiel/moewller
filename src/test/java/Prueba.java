import static org.junit.Assert.assertEquals;

class Agujero {
    Object origen;
    Object destino;
    public Agujero(Object origen, Object destino) {
        origen = destino;
    }
}

public class Prueba {
    public Object campo1;
    public Object campo2;
    public Object campo3;

    public void linkFields() {
        this.campo2 = this.campo1;
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        String valor = "campo1";
        p.campo1 = valor;
        p.linkFields();
        assertEquals(p.campo2, valor);

        String nuevoValor = "campoN";
        p.campo1 = nuevoValor;
        
        assertEquals(p.campo2, nuevoValor);
    }
    
}