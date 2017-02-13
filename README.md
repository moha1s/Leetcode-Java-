# Leetcode-Java-
一.(Sort类)：

350. Intersection of Two Arrays II：
a.首先用HashMap遍历一遍数组nums1，Key值储存数组元素，Value（初始值为1）值储存重复元素出现次数，每出现一次加1；
b.用List储存nums2中与nums1开始intersection的元素，当遇到map中包含的Key时，才判断对应Value是否大于1，是的话，将对应的nums2[i]，存入result中；这是为了防止当nums1的length小于nums2时，会重复储存nums2中相同数组元素的情况，举例：nums1={1}，nums2={1，1}，如果对应value不减一的话，result会为[1,1]，但实际result应为[1]。

349. Intersection of Two Arrays：
用Set遍历nums1，根据Set的方法性质，重复数组元素会被去除，用List储存nums2中与nums1相同的元素，如果set中remove掉了对应元素，则res中addnums2数组元素，再新建数组储存对应List值。

242. Valid Anagram：
首先判断两个字符串是否长度一样，不一样则为false，然后新建一个数组count，s.charAt(i)(得到的是对应字母的ASIC码)-'a'，存入数组，重复加1，t.charAt(i)-'a'，重复减1，这样的话如果为true每个数组元素值应为'0'，不为'0'的话则为false。

148. Sort List：
第一步：首先设置快慢指针slow和fast，将原链表head一分为二，第二步：然后再对以上两个链表利用sortList递归划分，划分到单个Node，通过自定义方法merge，进行排序呢，这样两个一分为二的链表都排好序。再对两个一般的链表进行merge，然后return 结果

147. Insertion Sort List:
新建一个链表res，然后cur=head，通过next，每次拿一个node出来，这个node值要和pre.next比，比pre.next大的话，pre=pre.next，如果小的话接着往下走，重复上面的步骤，把cur这个node插入到pre.next，如此循环往复，就能得到sorted list结果res.next。

56. Merge Intervals:
分别创建两个新数组start，end，分别把intervals里的start和end点，并用sort排序。然后新建一个List<Interval>，执行for循环，重点在于合并有交集的区间，比较相邻两个区间，前一个区间的end与后一区间的start比较，如果后[start]>前[end]，说明没有交集，直接储存第一个区间，否则，继续比较，知道出现后[start]<前[end]，说明有交集，储存起始前一个区间的start和当前后区间的前一个区间的end。

75. Sort Colors:
题记：public void 没有return（真是蠢），分别统计red,white,blue出现次数，然后nums的0，1，2个数就确定了，分别存入相应个数就可以了。

179. Largest Number:
首先把整数数组中的元素存到字符串数组中，用String.valueOf(nums[i])或者Integer.toString(nums[i]),然后用Arrays.sort(str,(s1,s2)->(s2+s1).compareTo(s1+s2));降序排列，其中"(a,b)->X(表达式)"的意思是：如果X<0，a,b不交换位置，若果X>0，a,b交换位置。最后用String.join(x,String[])对字符串数组进行拼接，x表示以什么拼接，如：x="-",String[]={"a","b"},则拼接后为"a-b"。最后判断字符串第一个res.charAt(0)是否为"0"，是的话直接return "0",因为若果nums={0,0}，res="0"，而不是"00".

274. H-Index:
H-Index的核心计算方法如下：
将某作者的所有文章的引用频次按照从大到小的位置排列;从前到后，找到最后一个满足条件的位置，其条件为：此位置是数组的第x个，其值为y，必须满足 y >= x;至此，思路已经形成。即先排序，然后从前向后遍历即可。我的解法是按照频次从小到大排列。之后需要从后向前遍历。只是方向发生了改变，不影响结果。

二.(Linkedlist类)：

2. Add Two Numbers
新建一个ListNode储存求和结果，while循环里，首先sum每次都要除以10得到进位数，然后分别加l1和l2相对应的node值，取余数存到ListNode中。遍历完之后，如果最后的sum除以10余1，往res中添加"1"。

21. Merge Two Sorted Lists
新建一个ListNode，然后分别比较l1和l2的node值大小，小的存入res，然后继续调用自己方法本身，比较小的.next。
