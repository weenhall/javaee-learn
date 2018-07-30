#JDBC
## Java中数据库存储技术
 * JDBC访问
 * JDO
 * ORM工具(Hibernate,MyBatis)omit...
  
## JDBC是Java提供的访问数据库的接口,它定义了用来访问数据库的标准类库

## JDBC关键类
* DriverManager
* Connection
* Statement 
* PreparedStatement
* CallableStatement
* ResultSet

## JDBC常用URL
* ORCLE jdbc:oracle:thin:@localhost:1521:databasename
* SQLSERVER jdbc:microsoft:sqlserver//localhost:1433;DataBasename=databasename
* MYSQL jdbc:mysql://localhost:3306/databasename

## DatabaseMetaData 获取数据源中信息
* getURL():返回一个String类对象，代表数据库的URL
* getUserName():返回连接当前数据库管理系统的用户名
* isReadOnly():返回一个boolean值，指示数据库是否只允许读操作
* getDatabaseProductName():返回数据库的产品名称
* getDatabaseProductVersion():返回数据库的版本号
* getDriverName():返回驱动驱动程序的名称
* getDriverVersion():返回驱动程序的版本号

## ResultSetMetaData 获取结果集中对象的信息
* getColumnName(int column):获取指定列的名称
* getColumnCount():返回当前 ResultSet 对象中的列数
* getColumnTypeName(int column):检索指定列的数据库特定的类型名称
* getColumnDisplaySize(int column):指示指定列的最大标准宽度，以字符为单位
* isNullable(int column):指示指定列中的值是否可以为 null
* isAutoIncrement(int column):指示是否自动为指定列进行编号，这样这些列仍然是只读的

## 常用数据库分页语句
* MYSQL
  > select * from table limit currentpage,pagesize
* ORACLE
  > select * from(select a.*,rownum as rn from table where rownum<=end) a where a.rn>=start  
* SQLSERVER2000
  > select top pagesize * from table where column not in(select top pagesize*page column from table order by column) order by column
*SQLSERVER2005
  > select * from(select column,row)
  
# DBUtils 开源jdbc工具类