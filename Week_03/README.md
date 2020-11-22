# 学习笔记 Week 03

## 递归
重点是要有效地划分子问题，去支降低时间成本。
```
public void recur(int level, int param) { 
  // 1. terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // 2. process current logic 
  process(level, param); 
  // 3. drill down 
  recur( level: level + 1, newParam); 
  // 4. restore current status 
 
}

```


## 分治
一种递归，需要有效地划分子问题和合并结果。
```
private static int divideConquer(Problem problem, ) {
  // 1. terminator 
  if (problem == NULL) {
    int res = processLastResult();
    return res;     
  }
  // 2. divide
  subProblems = splitProblem(problem)
  
  // 3. conquer
  res0 = divideConquer(subProblems[0])
  res1 = divideConquer(subProblems[1])
  
  // 4. merge
  result = processResult(res0, res1);
  
  return result;
}

```

## 回溯 Backtracking
回溯法使用试错的思想，尝试分步解决问题，在分步的过程中，如果发现一个路径不能得到有效的答案时，要回溯几步至之前的状态。经常需要restore之前的状态。

```
private static int backTracking(level, parameter1, parameter2 ...  ) {
  // 1. terminator 
  if (level > MAX_LEVEL) {
    // process result 
    return;     
  }
  
  // 2. process current logic
        update states


  // 3. drill down 

   if (condition1) 
        backTracking(level+1, p1, p2)
   else if(condition 2)
        continue
   
  //4. reverse states
  
  return result;
}

```
