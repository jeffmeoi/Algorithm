# 集合set与映射map常见用法

## 分析
详见Cpp Standard Library.
```cpp
  集合set会自动从小到大排序，可用于查重
  #include<set>
  set<typename> name;
  name.begin();         //首元素指针
  name.end();           //尾元素指针
  name.insert(元素)      //插入元素
  name.size();          //获取集合尺寸
  set<typename>::iterator it; //迭代器
  
  #include<map>
  map<typename1, typename2>
  map[name1] = name2;
  
```


## 源代码

```cpp

#include<cstdio>
#include<set>
#include<map>
#include<iostream>
#include<string>
#include<sstream>

using namespace std;

set<string> dict;
map<string, int> month_name;
 
int main(int argc, char* argv[]){
	
	string s, buff;
	
	for(int i = 0; i < 5; i++){
		cin >> s;
		stringstream ss(s);
		while(ss >> buff)
			dict.insert(buff);
	}
	for(set<string>::iterator it = dict.begin(); it != dict.end(); ++it)
		cout << *it << endl;
	if(!dict.empty())
		dict.clear();
	
	month_name["January"] = 1;
	month_name["February"] = 2;
	month_name["March"] = 3;
	month_name["April"] = 4;
	month_name["May"] = 5;
	month_name["June"] = 6;
	month_name["July"] = 7;
	month_name["August"] = 8;
	month_name["September"] = 9;
	month_name["October"]  = 10;
	month_name["November"] = 11;
	month_name["December"] = 12;
	
	cout<<"July:  "<<month_name["July"]<<endl;
	
	return 0;
}

```

