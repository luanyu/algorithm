package com.ly.algorithm;

import com.ly.algorithm.model.TreeNode;

/**
 * 计算完全二叉树节点总数
 * @author luanyu
 */
public class CountCompleteTree {
	
	public static void main(String[] args){
		TreeNode root = new TreeNode();
		root.value = "root";
		root.left = new TreeNode();
		root.right = new TreeNode();
		root.left.value = "left";
		root.right.value = "right";
		System.out.println(count(root));
	}
	
	public static int countNodes(TreeNode root){
		if(root == null){
			return 0;
		}
		return count(root);
	}

	private static int count(TreeNode node) {
		if(node == null){
			return 0;
		}
		int heightL = height(node.left);
		int heightG = height(node.right);
		if(heightL == heightG){
			return (1 << heightL) + count(node.right);
		}else{
			return (1 << heightG) + count(node.left);
		}
	}
	
	private static int height(TreeNode node){
		int height = 0;
		TreeNode temp = node;
		
		while(temp != null){
			temp = temp.left;
			height++;
		}
		
		return height;
	}
}
