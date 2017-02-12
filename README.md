# Leetcode-Java-
350. Intersection of Two Arrays II
a.首先用HashMap遍历一遍数组nums1，Key值储存数组元素，Value（初始值为1）值储存重复元素出现次数，每出现一次加1；
b.用List储存nums2中与nums1开始intersection的元素，当遇到map中包含的Key时，才判断对应Value是否大于1，是的话，将对应的nums2[i]，存入result中；这是为了防止当nums1的length小于nums2时，会重复储存nums2中相同数组元素的情况，举例：nums1={1}，nums2={1，1}，如果对应value不减一的话，result会为[1,1]，但实际result应为[1]。
349. Intersection of Two Arrays
用Set遍历nums1，根据Set的方法性质，重复数组元素会被去除，用List储存nums2中与nums1相同的元素，如果set中remove掉了对应元素，则res中addnums2数组元素，再新建数组储存对应List值。
