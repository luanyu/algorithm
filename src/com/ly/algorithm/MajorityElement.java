package com.ly.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 多数投票算法
 * 给定一个有n个元素的非负数组，寻找数组中出现次数大于n/k的所有元素
 * @author luanyu
 */
public class MajorityElement {
	public static List<Integer> majorityElement(int[] nums, int k){

		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
			return res;
		}
		int[] candidates = new int[k - 1];
		int[] count = new int[k - 1];
		int i = 0, j = 0, frep = nums.length / k;
		for(i = 0; i < nums.length; i++){
			for(j = 0; j < k - 1; j++){
				if(count[j] == 0 || nums[i] == candidates[j]){
					count[j]++;
					candidates[j] = nums[i];
					break;
				}
			}
			if(j == k - 1){
				for(j = 0; j < k - 1; j++){
					count[j]--;
				}
			}
		}
		count = new int[k - 1];
		for(i = 0; i < nums.length; i++){
			for(j = 0; j < k - 1; j++){
				if(nums[i] == candidates[j]){
					count[j]++;
					break;
				}
			}
		}
		for(j = 0; j < k - 1; j++){
			if(count[j] > frep){
				res.add(candidates[j]);
			}
		}
		return res;
	}
}
