
package examen;

import javax.swing.JOptionPane;

/**
 *
 * @author moyportillo
 */
public class metodos {
    
    
    Integer cont = 1, opc = 0;
    factura obj_fac = new factura();
    
    public void menu(){
        do{
        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU\n1.Agregar nuevo cliente\n2.Consultar un cliente con informacion\n3.Tabla de facturas realizadas\n4.Salir\nSeleccione una opcion: "));
        switch(opc){
            case 1:
                    ingreso_Cliente();
                    break;
            case 2:
                    break;
            case 3:
                    this.obj_fac.Mostrar_Lista();
                    break;
            case 4:
                    JOptionPane.showMessageDialog(null, "Gracias Por Usar nuestro Programa");
                    break;
            default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida. \nFavor Ingrese una opcion del menu.");
                    break;
        }
        }while(opc!=4);
    }
    
    public void ingreso_Cliente(){
        String id, nombre, apellido, telefono, direccion;
        id = JOptionPane.showInputDialog(null, "Ingrese la identidad del Cliente: ");
        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del Cliente: ");
        apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del Cliente: ");
        telefono = JOptionPane.showInputDialog(null, "Ingrese el telefon del Cliente: ");
        direccion = JOptionPane.showInputDialog(null, "Ingrese la direccion del Cliente: ");
        factura obj_fac2 = new factura(id, nombre, apellido, telefono, direccion);
        obj_fac2.captura_Cliente();
    }
}
