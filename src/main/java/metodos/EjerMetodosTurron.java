/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author smr1d
 */
public class EjerMetodosTurron {

    public static void main(String[] args) {

        //Declaramos variables (mano de obra y beneficio por unidad y por ventas)
        mostrarMenu();

    }

    // Metodos   
    //metodo para solo mostrar el menu inicial
    public static void mostrarMenu() {
        String palabra;
        // Creacion menu de dos opciones (ENTRAR o SALIR)
        do {
            palabra = JOptionPane.showInputDialog(
                    "Para entrar al menu escriba ENTRAR \n"
                    + "Para salir escriba SALIR");
            palabra = palabra.toUpperCase();

            switch (palabra) {
                case "ENTRAR":
                    leerCodigos();
                    break;
                case "SALIR":
                    JOptionPane.showMessageDialog(null, "Hasta luego");
            }

            // Hacemos la condicion del primer bucle para que salga si escribimos "salir"
        } while (!palabra.equalsIgnoreCase("salir"));

    }

    //metodo para leer el codigo del producto y filtrarlo
    public static void leerCodigos() {
        String codProducto = "";

        // Hacemos un bucle para que si el usuario introduce un codigo
        // que no este en la lista vuelva a pedir otra vez el codigo
        do {

            // Entradas con JOption (codigo del dulce y precio materia prima)
            codProducto = JOptionPane.showInputDialog("Introduce el codigo: \n"
                    + "M1 (mantecados de limon)\n"
                    + "M2 (mazapanes)\n"
                    + "P1 (polvorones)\n"
                    + "T1 (turron de chocolate)\n"
                    + "T2 (turron clasico)");
            codProducto = codProducto.toUpperCase();

            if (codProducto.equals("M1") || codProducto.equals("M2")
                    || codProducto.equals("T1") || codProducto.equals("T2")
                    || codProducto.equals("P1")) {

                leerMateriaPrima(codProducto);

                // En caso de que se escriba mal el codigo del producto    
            } else {
                JOptionPane.showConfirmDialog(null,
                        "El codigo introducido no es correcto");
            }
            // Hacemos la condicion del segundo bucle para que salga al primer menu
        } while (!(codProducto.equalsIgnoreCase("M1")
                || codProducto.equalsIgnoreCase("P1")
                || codProducto.equalsIgnoreCase("T1")
                || codProducto.equalsIgnoreCase("T2")
                || codProducto.equalsIgnoreCase("M2")
                || codProducto.equalsIgnoreCase("SALIR")));
    }

    //metodo para hacer los calculos dentro de cada codigo
    public static void filtrarCodigos(String codProducto, final double MANO_OBRA_M1_T1,
            final double BENEFICIO_M1_M2_P1, final double BENEFICIO_VENTAS, double materiaPrima,
            final double MANO_OBRA_M2_T2_P1, final double BENEFICIO_T1_T2) {
        String resultado;
        //algoritmo
        switch (codProducto) {
            case "M1":
                // Proceso unitario coste produccion y precio venta de M1
                double costeProdM1 = MANO_OBRA_M1_T1 + materiaPrima;

                double precioVentaM1 = costeProdM1 + (BENEFICIO_M1_M2_P1 * costeProdM1);

                double m1Necesarios = BENEFICIO_VENTAS / precioVentaM1;

                // Agrupamos los resultados en un textblock
                resultado
                        = """
                        Coste de produccion unitario: %.2f
                        Precio de venta unitario: %.2f
                        Cantidad necesaria para llegar a 2500€: %.2f
                        """.formatted(costeProdM1, precioVentaM1, m1Necesarios);

                // Mostramos el resultado
                JOptionPane.showConfirmDialog(null, resultado);
                break;

            case "M2":
                // Proceso unitario coste produccion y precio venta de M2
                double costeProdM2 = MANO_OBRA_M2_T2_P1 + materiaPrima;

                double precioVentaM2 = costeProdM2 + (BENEFICIO_M1_M2_P1 * costeProdM2);

                double m2Necesarios = BENEFICIO_VENTAS / precioVentaM2;

                // Agrupamos los resultados en un textblock
                resultado
                        = """
                        Coste de produccion unitario: %.2f
                        Precio de venta unitario: %.2f
                        Cantidad necesaria para llegar a 2500€: %.2f
                        """.formatted(costeProdM2, precioVentaM2, m2Necesarios);

                // Mostramos el resultado
                JOptionPane.showConfirmDialog(null, resultado);
                break;

            case "P1":
                // Proceso unitario coste produccion y precio venta de P1
                double costeProdP1 = MANO_OBRA_M2_T2_P1 + materiaPrima;

                double precioVentaP1 = costeProdP1 + (BENEFICIO_M1_M2_P1 * costeProdP1);

                double p1Necesarios = BENEFICIO_VENTAS / precioVentaP1;

                // Agrupamos los resultados en un textblock
                resultado
                        = """
                        Coste de produccion unitario: %.2f
                        Precio de venta unitario: %.2f
                        Cantidad necesaria para llegar a 2500€: %.2f
                        """.formatted(costeProdP1, precioVentaP1, p1Necesarios);

                // Mostramos el resultado
                JOptionPane.showConfirmDialog(null, resultado);
                break;

            case "T1":
                // Proceso unitario coste produccion y precio venta de T1
                double costeProdT1 = MANO_OBRA_M1_T1 + materiaPrima;

                double precioVentaT1 = costeProdT1 + (BENEFICIO_T1_T2 * costeProdT1);

                double t1Necesarios = BENEFICIO_VENTAS / precioVentaT1;

                // Agrupamos los resultados en un textblock
                resultado
                        = """
                        Coste de produccion unitario: %.2f
                        Precio de venta unitario: %.2f
                        Cantidad necesaria para llegar a 2500€: %.2f
                        """.formatted(costeProdT1, precioVentaT1, t1Necesarios);

                // Mostramos el resultado
                JOptionPane.showConfirmDialog(null, resultado);
                break;

            case "T2":
                // Proceso unitario coste produccion y precio venta de T2
                double costeProdT2 = MANO_OBRA_M2_T2_P1 + materiaPrima;

                double precioVentaT2 = costeProdT2 + (BENEFICIO_T1_T2 * costeProdT2);

                double t2Necesarios = BENEFICIO_VENTAS / precioVentaT2;

                // Agrupamos los resultados en un textblock
                resultado
                        = """
                        Coste de produccion unitario: %.2f
                        Precio de venta unitario: %.2f
                        Cantidad necesaria para llegar a 2500€: %.2f
                        """.formatted(costeProdT2, precioVentaT2, t2Necesarios);

                // Mostramos el resultado
                JOptionPane.showConfirmDialog(null, resultado);
                break;

        }
    }

    //metodo para leer el precio de la materia prima
    public static void leerMateriaPrima(String codProducto) {

        double materiaPrima = 0;
        final double LIMITE_INFERIOR = 0.1;
        final double LIMITE_SUPERIOR = 1;
        // Hacemos otro bucle para que vuelva a pedir el precio de la materia 
        // prima si introducimos un valor fuera del rango (0.1 - 1€)
        do {

            // algoritmo del producto
            // Entrada de precio materia prima con JOption y lo pasamos a double
            String precioMatPrimaString = (JOptionPane.showInputDialog("Introduce el precio de la materia prima del producto"));
            materiaPrima = Double.parseDouble(precioMatPrimaString);

            // Le ponemos la condicion al tercer bucle
        } while (materiaPrima < LIMITE_INFERIOR || materiaPrima > LIMITE_SUPERIOR);
        if (materiaPrima >= LIMITE_INFERIOR && materiaPrima <= LIMITE_SUPERIOR) {

            leerManoObra();

            filtrarCodigos(codProducto, 0.5, 0.5, 2500, materiaPrima, 0.9, 0.65);

            // En caso de que se escriba mal el precio de la materia    
        } else {
            JOptionPane.showConfirmDialog(null,
                    "El precio de la materia no es correcto");
        }
    }

    public static double leerManoObra() {

        double costeManoObra1 = 0;
        final double MANO_OBRA_M1_T1 = 0.5;
        final double MANO_OBRA_M2_T2_P1 = 0.9;
        do {
            String costeManoObra = JOptionPane.showInputDialog(
                    "Introduce el coste de la mano de obra ");
            costeManoObra1 = Double.parseDouble(costeManoObra);

        } while (costeManoObra1 < MANO_OBRA_M1_T1
                || costeManoObra1 > MANO_OBRA_M2_T2_P1);

        return costeManoObra1;
    }

    //Metodo para calcular los costes de produccion
    public static void calcularCosteProd(final double MANO_OBRA_M1_T1, 
            final double MANO_OBRA_M2_T2_P1, double materiaPrima){
        
        double costeProdM1 = MANO_OBRA_M1_T1 + materiaPrima;
        double costeProdM2 = MANO_OBRA_M2_T2_P1 + materiaPrima;
        double costeProdP1 = MANO_OBRA_M2_T2_P1 + materiaPrima;
        double costeProdT1 = MANO_OBRA_M1_T1 + materiaPrima;
        double costeProdT2 = MANO_OBRA_M2_T2_P1 + materiaPrima;
             
        }
    //Metodo para calcular PrecioVentaUnitario
    public static void calcularPrecioVentaUnitario(double costeProdM1, double costeProdM2,
            double costeProdP1, double costeProdT1, double costeProdT2, final double BENEFICIO_M1_M2_P1,
            final double BENEFICIO_T1_T2){
        
        double precioVentaM1 = costeProdM1 + (BENEFICIO_M1_M2_P1 * costeProdM1);
        double precioVentaM2 = costeProdM2 + (BENEFICIO_M1_M2_P1 * costeProdM2);
        double precioVentaP1 = costeProdP1 + (BENEFICIO_M1_M2_P1 * costeProdP1);
        double precioVentaT1 = costeProdT1 + (BENEFICIO_T1_T2 * costeProdT1);
        double precioVentaT2 = costeProdT2 + (BENEFICIO_T1_T2 * costeProdT2);
    }
}

    