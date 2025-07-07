package main.Ejercicio_01_insert;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio_01_insert {
    // Clase interna para representar un nodo en el árbol
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Método para insertar un nuevo nodo en el árbol binario de búsqueda
    public Node insert(Node root, int data) {
        // Si el árbol está vacío, el nuevo nodo se convierte en la raíz
        if (root == null) {
            return new Node(data);
        }

        // Si el valor a insertar es menor que la data del nodo actual,
        // se inserta en el subárbol izquierdo
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        // Si el valor a insertar es mayor que la data del nodo actual,
        // se inserta en el subárbol derecho
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        // Retorna la raíz (modificada o no)
        return root;
    }

    // Método para realizar un recorrido en orden (in-order traversal) del árbol
    // y almacenar los elementos en una lista
    public List<Integer> inOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node node, List<Integer> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(node.data);
            inOrderTraversal(node.right, result);
        }
    }

    // Método para obtener la altura del árbol
    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // Método de utilidad para imprimir una cantidad de espacios
    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    // Método para imprimir el árbol nivel por nivel para que coincida con el output
    // esperado
    public void printTree(Node root) {
        if (root == null) {
            return;
        }

        int height = getHeight(root);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        for (int level = 1; level <= height; level++) {
            int nodesInLevel = (int) Math.pow(2, level - 1);
            // Espaciado inicial para centrar la línea de nodos
            int indent = (int) (Math.pow(2, height - level) - 1);
            // Espaciado entre nodos en la misma línea
            int spacing = (int) (Math.pow(2, height - level + 1) - 1);

            printSpaces(indent);

            for (int i = 0; i < nodesInLevel; i++) {
                Node node = queue.poll();
                if (node != null) {
                    System.out.print(node.data);
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    System.out.print(" "); // Espacio para un nodo nulo
                    queue.add(null);
                    queue.add(null);
                }
                printSpaces(spacing);
            }
            System.out.println();
        }
    }
}
