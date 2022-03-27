import net.datastructures.Position;
import net.datastructures.Tree;
import net.datastructures.BinaryTree;
import net.datastructures.LinkedBinaryTree;
import static dsaj.trees.TraversalExamples.spaces;
/**
 * Write a description of class TreeTester here.
 *
 * @author (your name)
 * @version 21 March 2022
 */
public class TreeTester
{
    public static<E> void printPreorderIndent(Tree<E> T, Position<E> p, int d){
        System.out.println(spaces(2*d)+ p.getElement());
        for(Position<E> c: T.children(p)){
            printPreorderIndent(T, c, d+1);
        }
    }
    /**
     * Gives the far left element of subtree T with root p.
     */
    public static<E> E farLeft(BinaryTree<E> T, Position<E> p){
        /* Base case */
        if(T.left(p) == null){return p.getElement();}
        /* Recursive case */
        else{
            return farLeft(T, T.left(p));
        }
    }
    /** 
     * Count number of leaf nodes
     */
    public static<E> int countLeafs(BinaryTree<E> T, Position<E> p){
        /* Base case */
        /* If the leaf doesn't exist (parent doesn't have left/right child) return 0 */
        /* If p is a leaf, return 1 */
        if(p == null){
            return 0;
        }
        else if(T.left(p) == null && T.right(p) == null){
            return 1;
        }
        /* Recursive case */
        else{
            return countLeafs(T, T.left(p)) + countLeafs(T, T.right(p));
        }
    }
    public static void main(String[] args){
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        
        tree.addRoot(2);
        
        Position<Integer> N3 = tree.addLeft(tree.root(), 3);
        /* tree.addLeft(parent, element) */
        Position<Integer> N6 = tree.addRight(tree.root(), 6);
        
        Position<Integer> N1 = tree.addLeft(N3, 1);
        /*Position<Integer> N7 = */tree.addRight(N3, 7);
        /*Position<Integer> N8 = */tree.addRight(N6, 8);
        
        /*Position<Integer> N19 = */tree.addLeft(N1, 19);
        
        printPreorderIndent(tree, tree.root(), 0);
        System.out.println("**************");
        
        System.out.println(farLeft(tree, tree.root()));
    }
}
