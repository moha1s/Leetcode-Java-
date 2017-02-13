# Leetcode-Java-
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

56. Merge Intervals
分别创建两个新数组start，end，分别把intervals里的start和end点，并用sort排序。然后新建一个List<Interval>，执行for循环，重点在于合并有交集的区间，比较相邻两个区间，前一个区间的end与后一区间的start比较，如果后[start]>前[end]，说明没有交集，直接储存第一个区间，否则，继续比较，知道出现后[start]<前[end]，说明有交集，储存起始前一个区间的start和当前后区间的前一个区间的end。
