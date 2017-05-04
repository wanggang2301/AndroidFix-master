AndFix总结：

1.AndFix不支持修改布局文件
2.AndFix 支持读取资源文件（Assets）
3.AndFix 支持在Activity中添加成员变量
4.AndFix 不支持添加匿名内部类（就是点击事件）如  img_header.setOnClickListener(new View.OnClickListener() { });
5.AndFix 不支持添加新的类
6.AndFix 支持在Activity添加新的方法
7.AndFix 支持连续打补丁（注意补丁的名字要求不一样）



测试打一次补丁的情况：

       1.不能出现新的类(包括内部类，匿名内部类)

       2.可以在类中重写方法，修改

       3.不可以在JavaBean类中添加方法(如果添加了并且使用了会报错)

       4.可以在已有的方法中写代码，使用jdk与sdk的api

