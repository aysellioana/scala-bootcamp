package week2.chapter14

//ex 6. A better way of modeling such trees is with case classes. Let’s start with binary
//trees.
//sealed abstract class BinaryTree
//case class Leaf(value: Int) extends BinaryTree
//case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
//Write a function to compute the sum of all elements in the leaves.

sealed class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(left:BinaryTree, right:BinaryTree) extends BinaryTree

