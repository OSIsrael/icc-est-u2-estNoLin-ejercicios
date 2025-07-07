package main.Ejercicio_03_listLeves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import main.Ejercicio_01_insert.Ejercicio_01_insert.Node;

public class Ejercicio_03_listLeves {

    /**
     * Devuelve una lista de listas enlazadas, donde cada lista enlazada contiene
     * los nodos de un nivel del árbol.
     * 
     * @param root La raíz del árbol.
     * @return Una lista de listas enlazadas con los nodos por nivel.
     */
    public List<LinkedList<Integer>> levelOrder(Node root) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.data);

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
}
