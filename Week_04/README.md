# 学习笔记 Week 04

## dfs 深度优先搜索：root->left->right

```
//Java
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
```

## 二分查找代码
```
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```

## 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
  
```
public int findBreakingPoint(int[] nums){
    int left = 0, right = nums.length - 1, mid = 0;
    while(left <= right) {
        mid = (right - left) / 2 + left;
        if(nums[mid] >= nums[left] && nums[mid] <= nums[right]) return left;

        if(nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return left;
}
```
