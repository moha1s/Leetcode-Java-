## **Leetcode-Java-**
## 一.(Sort类)：

## 350. Intersection of Two Arrays II
a.首先用HashMap遍历一遍数组nums1，Key值储存数组元素，Value（初始值为1）值储存重复元素出现次数，每出现一次加1；
b.用List储存nums2中与nums1开始intersection的元素，当遇到map中包含的Key时，才判断对应Value是否大于1，是的话，将对应的nums2[i]，存入result中；这是为了防止当nums1的length小于nums2时，会重复储存nums2中相同数组元素的情况，举例：nums1={1}，nums2={1，1}，如果对应value不减一的话，result会为[1,1]，但实际result应为[1]。
## 349. Intersection of Two Arrays
用Set遍历nums1，根据Set的方法性质，重复数组元素会被去除，用List储存nums2中与nums1相同的元素，如果set中remove掉了对应元素，则res中addnums2数组元素，再新建数组储存对应List值。
## 242. Valid Anagram
首先判断两个字符串是否长度一样，不一样则为false，然后新建一个数组count，s.charAt(i)(得到的是对应字母的ASIC码)-'a'，存入数组，重复加1，t.charAt(i)-'a'，重复减1，这样的话如果为true每个数组元素值应为'0'，不为'0'的话则为false。
## 148. Sort List
第一步：首先设置快慢指针slow和fast，将原链表head一分为二，第二步：然后再对以上两个链表利用sortList递归划分，划分到单个Node，通过自定义方法merge，进行排序呢，这样两个一分为二的链表都排好序。再对两个一般的链表进行merge，然后return 结果
## 147. Insertion Sort List
新建一个链表res，然后cur=head，通过next，每次拿一个node出来，这个node值要和pre.next比，比pre.next大的话，pre=pre.next，如果小的话接着往下走，重复上面的步骤，把cur这个node插入到pre.next，如此循环往复，就能得到sorted list结果res.next。
## 56. Merge Intervals
分别创建两个新数组start，end，分别把intervals里的start和end点，并用sort排序。然后新建一个List<Interval>，执行for循环，重点在于合并有交集的区间，比较相邻两个区间，前一个区间的end与后一区间的start比较，如果后[start]>前[end]，说明没有交集，直接储存第一个区间，否则，继续比较，知道出现后[start]<前[end]，说明有交集，储存起始前一个区间的start和当前后区间的前一个区间的end。
## 75. Sort Colors
题记：public void 没有return（真是蠢），分别统计red,white,blue出现次数，然后nums的0，1，2个数就确定了，分别存入相应个数就可以了。
## 179. Largest Number
首先把整数数组中的元素存到字符串数组中，用String.valueOf(nums[i])或者Integer.toString(nums[i]),然后用Arrays.sort(str,(s1,s2)->(s2+s1).compareTo(s1+s2));降序排列，其中"(a,b)->X(表达式)"的意思是：如果X<0，a,b不交换位置，若果X>0，a,b交换位置。最后用String.join(x,String[])对字符串数组进行拼接，x表示以什么拼接，如：x="-",String[]={"a","b"},则拼接后为"a-b"。最后判断字符串第一个res.charAt(0)是否为"0"，是的话直接return "0",因为若果nums={0,0}，res="0"，而不是"00".
## 274. H-Index
H-Index的核心计算方法如下：
将某作者的所有文章的引用频次按照从大到小的位置排列;从前到后，找到最后一个满足条件的位置，其条件为：此位置是数组的第x个，其值为y，必须满足 y >= x;至此，思路已经形成。即先排序，然后从前向后遍历即可。我的解法是按照频次从小到大排列。之后需要从后向前遍历。只是方向发生了改变，不影响结果。
## 二.(Linkedlist类)：
## 2. Add Two Numbers
新建一个ListNode储存求和结果，while循环里，首先sum每次都要除以10得到进位数，然后分别加l1和l2相对应的node值，取余数存到ListNode中。遍历完之后，如果最后的sum除以10余1，往res中添加"1"。
## 445. Add Two Numbers II



## 21. Merge Two Sorted Lists
新建一个ListNode，然后分别比较l1和l2的node值大小，小的存入res，然后继续调用自己方法本身，比较小的.next。
## 83. Remove Duplicates from Sorted List
遇到一样的值的node，就把他跳过。
## 138. Copy List with Random Pointer
* 方法1：我们用HashMap先遍历一下原RandomListNode head,把每个节点存进去，这样的话Value值存入与原RandomListNode信息一模一样的点（label，next，random），但是他的两个指针都指向原来的点，第二我们用重新赋予指针。

* 假设原始链表如下，细线表示next指针，粗线表示random指针，没有画出的指针均指向NULL：
![Method-1](http://www.2cto.com/uploadfile/2013/1028/20131028041708955.jpg)
* 我们在构建新链表的节点时，保存原始链表的next指针映射关系，并把指针做如下变化(蓝色为原始链表节点，紫红色为新链表节点)：
![Method-1](http://www.2cto.com/uploadfile/2013/1028/20131028041722302.jpg)

* 方法2：第一遍扫描：对每个结点进行复制，把复制出来的新结点插在原结点之后；第二遍扫描：根据原结点的random，给新结点的random赋值；第三遍扫描：把新结点从原链表中拆分出来。
![Method-2](http://www.2cto.com/uploadfile/2013/1028/20131028041740524.jpg)
* 构建新节点random指针：new1->random = old1->random->next, new2-random = NULL, new3-random = NULL, new4->random = old4->random->next
* 恢复原始链表以及构建新链表：例如old1->next = old1->next->next,  new1->next = new1->next->next;该算法时间复杂度O(N)，空间复杂度O(1)

## 237. Delete Node in a Linked List
遇到相同值直接跳过。
## 234. Palindrome Linked List
用快慢指针将原链表一分为二，然后对后半部分链表进行反转，然后再比较两段链表是否相同。
## 206. Reverse Linked List
设置两个新的空节点。
## 203. Remove Linked List Elements
新建一个ListNode res，然后用res.next=head，用cur复制新链表res，while循环里，如果head.val==val，cur.next指向head.next，否则cur=cur.next。最后返回res.next。
## 160. Intersection of Two Linked Lists
我没看那些先找两个链表长度求差值的方法，这里的解法不需要求长度，我们分别从两个list从前往后走，当一个list走到null的时候，转到另一个list的头，这样我们就消除了差值，这时当另一个list也走到null时，他跳转的另一个list的头时，此时，两个node所在位置到list尾巴的长度一致，但两个list再次往后走，走到a==b时，说明到了intersection起始的位置，直接输出其中任意一个list即可。
## 445. Add Two Numbers II
利用Stack，将链表倒序push到Stack中，新建一个ListNode res，每次将得到的sum的余数值替换res.val，再新建一个ListNode head，head.next=res，这样每次得到的新res都放到head的后面，再令res=head，就能将结果从后往前保存；若果res第一个node为0，输出res.next，否则直接输出res。
## 328. Odd Even Linked List
用两个奇(odd)偶(even)指针分别指向奇偶节点的起始位置，另外需要一个单独的指针res=even来保存偶节点的起点位置，然后把奇节点的指向偶节点的下一个(一定是奇节点)，此奇节点后移一步，再把偶节点指向下一个奇节点的下一个(一定是偶节点)，此偶节点后移一步，以此类推直至末尾，此时把分开的偶节点的链表连在奇节点的链表后即可。
## 148. Sort List
快慢指针，将原list分为两半，然后再递归（调用自身方法），将list化为单个node，用merge方法将每半个链表排序，再总体merge。
## 147. Insertion Sort List
Insertion Sort就是把一个一个元素往已排好序的list中插入的过程。初始时，res list是空，把一个元素插入res list中。然后，在每一次插入过程中，都是找到最合适位置进行插入。因为是链表的插入操作，需要维护pre，cur和next一共3个指针。
pre始终指向res list的fakehead，cur指向当前需要被插入的元素，next指向下一个需要被插入的元素。当res为空以及pre.next所指向的元素比cur指向的元素值要大时，需要把cur元素插入到pre.next所指向元素之前。否则，pre指针后移。最后返回fakehead的next即可。
## 143. Reorder List
题目要重新按照 L0→Ln→L1→Ln-1→L2→Ln-2→…来排列，看例子1->2->3->4会变成1->4->2->3，拆开来看，是{1，2}和{4，3}的组合，而{4，3}是{3，4}的逆序。这样问题的解法就出来了。

第一步，将链表分为两部分。

第二步，将第二部分链表逆序。

第三步，将链表重新组合。
## 109. Convert Sorted List to Binary Search Tree
利用快慢指针，找list中点，设为tree的root，然后中点的前半部分为tree的左子树，利用递归插入树节点，同理中点的后半部分为右子树，递归插入树节点。
## 86. Partition List
设置两个新的链表，pre存储比x小的值，back存储比x大或者相等的值，cur1和cur2分别等于pre，back，最后cur2.next设置为空指针，防止TimeOut，把back.next接到cur1后面，最后输出pre.next。

## 111111111Next Greater Element I
利用HashMap构造键-值映射，再利用Stack，从nums的第一个元素压栈，然后后面的元素与之比较，比前面一个大，就找到Next Greater元素，形成键-值对，然后遍历findNums，利用getOrDefault，不存在键值对的默认为-1。

## 三.(Array类)：
## 448. Find All Numbers Disappeared in an Array
首先遍历数组每个元素-1，对应元素的每个值取反，然后再遍历，遇到大于0的值，index+1即为结果。
## 414. Third Maximum Number
利用PriorityQueue性质res，最小的始终排在队首，然后再利用Set不能存储相同元素，如果set能储存，就储存到优先队列中，如果res.size()>3,就res.poll()，这样始终保持res的size<=3，队首为第三大的数，遍历完数组，检查res的size大小，如果==2的话，res.poll()，删除队首，最后res.peek()，得到第三大的数或者size为2时最大的数。
## 283. Move Zeroes
实际上就是将所有的非0数向前尽可能的压缩，最后把没压缩的那部分全置0就行了。比如103040，先压缩成134，剩余的3为全置为0。过程中需要一个指针记录压缩到的位置。
## 268. Missing Number
思路是既然0到n之间少了一个数，我们将这个少了一个数的数组合0到n之间完整的数组异或一下，那么相同的数字都变为0了，剩下的就是少了的那个数字了(异或：0^0=0,0^1=1,1^1=0;0^任意一个数=其本身）
## 219. Contains Duplicate II
利用HashMap，Key存数组元素，Value存index，如果出现重复元素，get当前元素的value，用现在的value减去之前的value，即为差值，小于等于k，返回TRUE。
## 四.(Hash Table类）
##136. Single Number
利用位运算，两个相同数异或=0；
## 五.(Dynamic Programming类)
##62.Unique Paths
由题干可知，robot只能向下和向右移，所以设二维数组dp[m][n],dp[i][0]和dp[0][i]都为1，然后fill up整个dp[][]table，dp[i][j]=dp[i-1][j]+dp[i][j-1],最后result=dp[m-1][n-1].