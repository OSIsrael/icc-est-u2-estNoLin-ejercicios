package main.Ejercicio_04_depth;

import main.Ejercicio_01_insert.Ejercicio_01_insert.Node;

public class Ejercicio_04_depth {

    /**
     * Calcula la profundidad máxima de un árbol binario.
     * La profundidad es el número de nodos a lo largo del camino más larg
     * desde el nodo raíz hasta el nodo hoja más lejano.
     *
     * @param root La raíz del árbol.
     * @return La profundidad máxima del árbol.
     */
    public int maxDepth(Node root) {
        // Caso base: si el árbol está vacío, su profundidad es 0.
        if (root == null) {
            return 0;
        }

        // Calcula recursivamente la profundidad de los subárboles izquierdo y derecho.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // La profundidad del árbol es 1 (por el nodo actual) más la profundidad del subárbol más profundo.
        return 1 + Math.max(leftDepth, rightDepth);
    }
}