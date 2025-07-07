package main.Ejercicio_02_invert;

import main.Ejercicio_01_insert.Ejercicio_01_insert.Node;

public class Ejercicio_02_invert {

    /**
     * Invierte un árbol binario (crea su imagen espejo) de forma recursiva.
     * 
     * @param root La raíz del árbol a invertir.
     * @return La raíz del árbol ya invertido.
     */
    public Node invertTree(Node root) {
        // Caso base: si el nodo es nulo o es una hoja, no hay nada que hacer.
        if (root == null) {
            return null;
        }

        // Intercambia el hijo izquierdo con el derecho.
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Llama recursivamente a la función para los subárboles.
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
