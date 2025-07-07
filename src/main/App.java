package main;

import main.Ejercicio_01_insert.Ejercicio_01_insert;
import main.Ejercicio_01_insert.Ejercicio_01_insert.Node;
import main.Ejercicio_03_listLeves.Ejercicio_03_listLeves;
import main.Ejercicio_04_depth.Ejercicio_04_depth;
import main.Ejercicio_02_invert.Ejercicio_02_invert;
import utils.StudentValidator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        System.out.println("\n--- Ejercicio 01: Insertar en un Árbol Binario de Búsqueda ---");

        // 1. Crear una instancia del árbol
        Ejercicio_01_insert tree = new Ejercicio_01_insert();
        Node root = null;

        // 2. Definir los valores a insertar (el input de ejemplo)
        int[] valuesToInsert = { 5, 3, 7, 2, 4, 6, 8 };

        // 3. Insertar cada valor en el árbol
        System.out.print("Insertando valores: ");
        for (int value : valuesToInsert) {
            System.out.print(value + " ");
            root = tree.insert(root, value);
        }
        System.out.println("\n\nEstructura del Árbol Binario de Búsqueda resultante:");

        // 4. Imprimir el árbol para verificar la estructura
        tree.printTree(root);

        System.out.println("\n--- Ejercicio 02: Invertir un Árbol Binario ---");

        // 1. Reutilizamos la clase del ejercicio 1 para construir el árbol de ejemplo
        Ejercicio_01_insert treeBuilder = new Ejercicio_01_insert();
        Node rootForInvert = null;
        int[] valuesForInvert = { 4, 2, 7, 1, 3, 6, 9 };
        for (int value : valuesForInvert) {
            rootForInvert = treeBuilder.insert(rootForInvert, value);
        }

        System.out.println("Árbol Original:");
        treeBuilder.printTree(rootForInvert);

        // 2. Invertir el árbol usando la nueva clase
        Ejercicio_02_invert inverter = new Ejercicio_02_invert();
        Node invertedRoot = inverter.invertTree(rootForInvert);

        System.out.println("\nÁrbol Invertido (Output Esperado):");
        treeBuilder.printTree(invertedRoot);

        System.out.println("\n--- Ejercicio 03: Listar Niveles en Listas Enlazadas ---");

        // 1. Usamos el mismo árbol de entrada que en el ejercicio 2
        Ejercicio_01_insert treeBuilder3 = new Ejercicio_01_insert();
        Node rootForLevels = null;
        int[] valuesForLevels = { 4, 2, 7, 1, 3, 6, 9 };
        for (int value : valuesForLevels) {
            rootForLevels = treeBuilder3.insert(rootForLevels, value);
        }
        System.out.println("Árbol de entrada:");
        treeBuilder3.printTree(rootForLevels);

        // 2. Obtener la lista de niveles
        Ejercicio_03_listLeves lister = new Ejercicio_03_listLeves();
        List<LinkedList<Integer>> levels = lister.levelOrder(rootForLevels);

        // 3. Imprimir el resultado en el formato esperado
        System.out.println("\nNiveles del árbol en Listas Enlazadas (Output Esperado):");
        for (LinkedList<Integer> level : levels) {
            String output = level.stream().map(String::valueOf).collect(Collectors.joining(" → "));
            System.out.println(output);
        }

        System.out.println("\n--- Ejercicio 04: Calcular la Profundidad Máxima ---");

        // 1. Construir el árbol del ejemplo manualmente, ya que no es un BST.
        //       4
        //      / \
        //     2   7
        //    / \
        //   1   3
        //        \
        //         8
        Node rootForDepth = new Node(4);
        rootForDepth.left = new Node(2);
        rootForDepth.right = new Node(7);
        rootForDepth.left.left = new Node(1);
        rootForDepth.left.right = new Node(3);
        rootForDepth.left.right.right = new Node(8);

        // 2. Calcular la profundidad
        Ejercicio_04_depth depthCalculator = new Ejercicio_04_depth();
        int depth = depthCalculator.maxDepth(rootForDepth);

        // 3. Imprimir el resultado
        System.out.println("Profundidad Máxima del árbol (Output Esperado): " + depth);
    }

}
