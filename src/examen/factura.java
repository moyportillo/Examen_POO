/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import javax.swing.JOptionPane;


public class factura extends Persona{
    
    
    private double imp, total, precio, acumulador, cantidad, pretotal;
    String nom_producto;
    Integer opc = 0;
    static Integer cont = 1, cont2, cont3 = 1;
    public static String [][] cliente = new String [1][5];
    public static String [][] lista_productos = new String [5][4];
    public static String [][] detalle = new String [1][25];
    
    public factura(){
        
    }
    
    public factura(String id, String nombre, String apellido, String telefono, String direccion) {
        super(id, nombre, apellido, telefono, direccion);
    }

    
    public void captura_Cliente(){
        cont2=1;
        Integer n = cont -1;
        String [][] esclavo = new String [cont][5];
        
        if(cont == 1){
            esclavo[n][0] = this.getId();
            esclavo[n][1] = this.getNombre();
            esclavo[n][2] = this.getApellido();
            esclavo[n][3] = this.getTelefono();
            esclavo[n][4] = this.getDireccion();
            
            cliente = esclavo;
        }
        else{
            for(int i=0; i<cont-1;i++){
                esclavo[i][0] = cliente[i][0];
                esclavo[i][1] = cliente[i][1];
                esclavo[i][2] = cliente[i][2];
                esclavo[i][3] = cliente[i][3];
                esclavo[i][4] = cliente[i][4];
            }
            esclavo[n][0] = this.getId();
            esclavo[n][1] = this.getNombre();
            esclavo[n][2] = this.getApellido();
            esclavo[n][3] = this.getTelefono();
            esclavo[n][4] = this.getDireccion();
            
            cliente = esclavo;
        }
        cont = cont + 1;
        sub_Menu();
    }
    
    public void sub_Menu(){
        do{
        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "***MENU DE PRODUCTOS\nOJO: Solo puede comprar 5 productos\n1.Manzanas 4 Lps/Libra\n"
                + "2.Frijoles 7 Lps/Libra\n3.Pan 25 Lps C/u\n4.Café 5 Lps/bolsita\n5.Azúcar 20 Lps/Libra\n6.Imprimir Compra.\n7.Cancelar Compra\nSeleccione una opcion: "));
        switch(opc){
            case 1:
                    this.setNom_producto("Manzanas");
                    this.setPrecio(4);
                    this.setCantidad(Double.parseDouble(JOptionPane.showInputDialog(null, "Cuantas libras de manzana (4lps/Libra): ")));
                    this.pre_Total();
                    this.ingreso_productos();
                    break;
            case 2:
                    this.setNom_producto("Frijoles");
                    this.setPrecio(7);
                    this.setCantidad(Double.parseDouble(JOptionPane.showInputDialog(null, "Cuantas libras de Frijoles (7.00 lps/Libra): ")));
                    this.pre_Total();
                    this.ingreso_productos();
                    break;
            case 3:
                    this.setNom_producto("Pan");
                    this.setPrecio(25);
                    this.setCantidad(Double.parseDouble(JOptionPane.showInputDialog(null, "Cuantas Unidades de Pan (25.00 lps c/u): ")));
                    this.pre_Total();
                    this.ingreso_productos();
                    break;
            case 4:
                    this.setNom_producto("Cafe");
                    this.setPrecio(5);
                    this.setCantidad(Double.parseDouble(JOptionPane.showInputDialog(null, "Cuantas Bolsitas de Cafe (5.00 lps/bolsita): ")));
                    this.pre_Total();
                    this.ingreso_productos();
                    break;
            case 5:
                    this.setNom_producto("Azucar");
                    this.setPrecio(20);
                    this.setCantidad(Double.parseDouble(JOptionPane.showInputDialog(null, "Cuantas libras de Azucar (20.00 lps/Libra): ")));
                    this.pre_Total();
                    this.ingreso_productos();
                    break;
            case 6:
                    this.detalle_fac();
                    JOptionPane.showMessageDialog(null, "Factura Guardada con Exito");
                    opc=7;
                    break;
            case 7: 
                    JOptionPane.showMessageDialog(null, "No se Registro ninguna factura");
                    break;
            default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida. \nFavor Ingrese una opcion del menu.");
                    break;
        }
        }while(opc!=7);
    }
    
    public void pre_Total(){
        this.setPretotal(this.getPrecio() * this.getCantidad());
    }
    
    public void ingreso_productos(){
        Integer n = cont2-1;
        String [][] esclavo2 = new String [5][4];
        if(cont2 == 1){
            esclavo2[n][0] = this.getNom_producto();
            esclavo2[n][1] = String.valueOf(this.getPrecio());
            esclavo2[n][2] = String.valueOf(this.getCantidad());
            esclavo2[n][3] = String.valueOf(this.getPretotal());
            lista_productos = esclavo2;
        }
        else{
            for(int i=0; i<cont2-1;i++){
                esclavo2[i][0] = lista_productos[i][0];
                esclavo2[i][1] = lista_productos[i][1];
                esclavo2[i][2] = lista_productos[i][2];
                esclavo2[i][3] = lista_productos[i][3];
            }
            esclavo2[n][0] = this.getNom_producto();
            esclavo2[n][1] = String.valueOf(this.getPrecio());
            esclavo2[n][2] = String.valueOf(this.getCantidad());
            esclavo2[n][3] = String.valueOf(this.getPretotal());
            lista_productos = esclavo2;
        }
        cont2 = cont2+1;
        this.acumulador = this.getPretotal() + this.acumulador;
    }
    
    public void detalle_fac(){
        this.imp = this.acumulador * 0.15;
        this.total = this.acumulador + this.imp;
        Integer n = cont3 - 1;
        String [][] esclavo3 =  new String [cont3][25];
        if(cont3 == 1){
            esclavo3[n][0] = cliente[cont3-1][0];
            esclavo3[n][1] = cliente[cont3-1][1];
            esclavo3[n][2] = lista_productos[0][0];
            esclavo3[n][3] = lista_productos[0][1];
            esclavo3[n][4] = lista_productos[0][2];
            esclavo3[n][5] = lista_productos[0][3];
            esclavo3[n][6] = lista_productos[1][0];
            esclavo3[n][7] = lista_productos[1][1];
            esclavo3[n][8] = lista_productos[1][2];
            esclavo3[n][9] = lista_productos[1][3];
            esclavo3[n][10] = lista_productos[2][0];
            esclavo3[n][11] = lista_productos[2][1];
            esclavo3[n][12] = lista_productos[2][2];
            esclavo3[n][13] = lista_productos[2][3];
            esclavo3[n][14] = lista_productos[3][0];
            esclavo3[n][15] = lista_productos[3][1];
            esclavo3[n][16] = lista_productos[3][2];
            esclavo3[n][17] = lista_productos[3][3];
            esclavo3[n][18] = lista_productos[4][0];
            esclavo3[n][19] = lista_productos[4][1];
            esclavo3[n][20] = lista_productos[4][2];
            esclavo3[n][21] = lista_productos[4][3];
            esclavo3[n][22] = String.valueOf(this.acumulador);
            esclavo3[n][23] = String.valueOf(this.imp);
            esclavo3[n][24] = String.valueOf(this.total);
            detalle = esclavo3;
        }
        else{
            for(int i=0; i<cont3-1;i++){
                for(int j=0; j<25; j++){
                    esclavo3[i][j] = detalle[i][j];
                }
            }
            esclavo3[n][0] = cliente[cont3-1][0];
            esclavo3[n][1] = cliente[cont3-1][1];
            esclavo3[n][2] = lista_productos[0][0];
            esclavo3[n][3] = lista_productos[0][1];
            esclavo3[n][4] = lista_productos[0][2];
            esclavo3[n][5] = lista_productos[0][3];
            esclavo3[n][6] = lista_productos[1][0];
            esclavo3[n][7] = lista_productos[1][1];
            esclavo3[n][8] = lista_productos[1][2];
            esclavo3[n][9] = lista_productos[1][3];
            esclavo3[n][10] = lista_productos[2][0];
            esclavo3[n][11] = lista_productos[2][1];
            esclavo3[n][12] = lista_productos[2][2];
            esclavo3[n][13] = lista_productos[2][3];
            esclavo3[n][14] = lista_productos[3][0];
            esclavo3[n][15] = lista_productos[3][1];
            esclavo3[n][16] = lista_productos[3][2];
            esclavo3[n][17] = lista_productos[3][3];
            esclavo3[n][18] = lista_productos[4][0];
            esclavo3[n][19] = lista_productos[4][1];
            esclavo3[n][20] = lista_productos[4][2];
            esclavo3[n][21] = lista_productos[4][3];
            esclavo3[n][22] = String.valueOf(this.acumulador);
            esclavo3[n][23] = String.valueOf(this.imp);
            esclavo3[n][24] = String.valueOf(this.total);
            detalle = esclavo3;
        }
        cont3 = cont3 +1;
    }
    
    public void Mostrar_Lista(){
        
        for(int i=0; i<cont3-1;i++){
            System.out.println("**FACTURA "+(i+1)+" **");
            System.out.println("ID: "+detalle[i][0]);
            System.out.println("Nombre Cliente: "+detalle[i][1]);
                for(int j=2; j<22; j++){
                    System.out.println(detalle[i][j]);
                }
            System.out.println("Subtotal: "+detalle[i][22]);
            System.out.println("Impuestos: "+detalle[i][23]);
            System.out.println("**TOTAL: "+detalle[i][24]+"**");
            System.out.println("***************************************************");
            }
    }

    public double getPretotal() {
        return pretotal;
    }

    public void setPretotal(double pretotal) {
        this.pretotal = pretotal;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
