//某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。 
//
// Customers 表： 
//
// +----+-------+
//| Id | Name  |
//+----+-------+
//| 1  | Joe   |
//| 2  | Henry |
//| 3  | Sam   |
//| 4  | Max   |
//+----+-------+
// 
//
// Orders 表： 
//
// +----+------------+
//| Id | CustomerId |
//+----+------------+
//| 1  | 3          |
//| 2  | 1          |
//+----+------------+
// 
//
// 例如给定上述表格，你的查询应返回： 
//
// +-----------+
//| Customers |
//+-----------+
//| Henry     |
//| Max       |
//+-----------+
// 
// Related Topics 数据库 👍 247 👎 0

// select t1.Name as Customers from Customers t1 where t1.Id not in (select CustomerId from Orders)

package com.liuzhihang.leetcode.editor.cn;

public class CustomersWhoNeverOrder {

    public static void main(String[] args) {

        // Solution solution = new CustomersWhoNeverOrder().new Solution();

    }

//There is no code of Java type for this problem

}
