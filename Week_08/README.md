学习笔记 Week08

## Bit operation
#### 位运算
|运算符   |示例     |例子        |
|:-------:|:-----:| :---------|
|左移     | <<     |0011 => 0110|
|右移     | >>     |0110 => 0011|
|或       | &#124; |0011 &#124;  1011 => 1011|
|与      | &      |0011 & 0110 => 0010|
|取反     | ~     |~0011 => 1100|
|异或     | ^      |0011^ 0110 => 0101|


#### 异或操作
- x^0 = x;
- x^1s = ~x;
- x^(~x) = 1s;
- x ^ x = 0;
- c = a^b => a^c = b, b^c = a;
- a^b^c = a^(b^c)

#### 指定位置的位运算
1. 将x最右边n位清零： x & (~0 << n)
2. 获取x第n位值：(x >> n) & 1
3. 获取x第n位的幂值：x & (1 << n)
4. 仅将第n位设置成1: x | (1 << n)
5. 仅将第n位设置成0: x & (~(1 << n))
6. 将x最高位至第n位（含）清零: x & ( (1 << n) - 1)

#### 位运算重点
- 判断奇偶 (x & 1) == 1; (x & 1) == 1;
- 取半 x >> 1；两倍 x << 1
- 将最低位的1变成0 : x & (x-1)
- 将最低位的0变成1 : x | (x+1)
- 得到最低位的1: x & (-x)
- x & (~x) => 0

## Bloom Filter
由一个很长的二进制向量和一系列随机函数构成，用于检索一个元素是否存在于一个集合中

优点：空间效率和查询时间远远超过一些算法

缺点：由一定的误识别率和删除困难


## LRU
实现: 哈希表 + 双链表
